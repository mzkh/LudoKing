package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.android.installreferrer.commons.InstallReferrerCommons;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService.Stub;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

class InstallReferrerClientImpl extends InstallReferrerClient {
    private static final int PLAY_STORE_MIN_APP_VER = 80837300;
    private static final String SERVICE_ACTION_NAME = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";
    private static final String SERVICE_NAME = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
    private static final String SERVICE_PACKAGE_NAME = "com.android.vending";
    private static final String TAG = "InstallReferrerClient";
    private final Context mApplicationContext;
    /* access modifiers changed from: private */
    public int mClientState = 0;
    /* access modifiers changed from: private */
    public IGetInstallReferrerService mService;
    private ServiceConnection mServiceConnection;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    private final class InstallReferrerServiceConnection implements ServiceConnection {
        private final InstallReferrerStateListener mListener;

        private InstallReferrerServiceConnection(@NonNull InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.mListener = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose(InstallReferrerClientImpl.TAG, "Install Referrer service connected.");
            InstallReferrerClientImpl.this.mService = Stub.asInterface(iBinder);
            InstallReferrerClientImpl.this.mClientState = 2;
            this.mListener.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn(InstallReferrerClientImpl.TAG, "Install Referrer service disconnected.");
            InstallReferrerClientImpl.this.mService = null;
            InstallReferrerClientImpl.this.mClientState = 0;
            this.mListener.onInstallReferrerServiceDisconnected();
        }
    }

    public InstallReferrerClientImpl(@NonNull Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    public boolean isReady() {
        return (this.mClientState != 2 || this.mService == null || this.mServiceConnection == null) ? false : true;
    }

    public void startConnection(@NonNull InstallReferrerStateListener installReferrerStateListener) {
        boolean isReady = isReady();
        String str = TAG;
        if (isReady) {
            InstallReferrerCommons.logVerbose(str, "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.mClientState;
        if (i == 1) {
            InstallReferrerCommons.logWarn(str, "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else if (i == 3) {
            InstallReferrerCommons.logWarn(str, "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else {
            InstallReferrerCommons.logVerbose(str, "Starting install referrer service setup.");
            this.mServiceConnection = new InstallReferrerServiceConnection(installReferrerStateListener);
            Intent intent = new Intent(SERVICE_ACTION_NAME);
            String str2 = "com.android.vending";
            intent.setComponent(new ComponentName(str2, SERVICE_NAME));
            List queryIntentServices = this.mApplicationContext.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str3 = resolveInfo.serviceInfo.packageName;
                    String str4 = resolveInfo.serviceInfo.name;
                    if (!str2.equals(str3) || str4 == null || !isPlayStoreCompatible()) {
                        InstallReferrerCommons.logWarn(str, "Play Store missing or incompatible. Version 8.3.73 or later required.");
                        this.mClientState = 0;
                        installReferrerStateListener.onInstallReferrerSetupFinished(2);
                        return;
                    }
                    if (this.mApplicationContext.bindService(new Intent(intent), this.mServiceConnection, 1)) {
                        InstallReferrerCommons.logVerbose(str, "Service was bonded successfully.");
                        return;
                    }
                    InstallReferrerCommons.logWarn(str, "Connection to service is blocked.");
                    this.mClientState = 0;
                    installReferrerStateListener.onInstallReferrerSetupFinished(1);
                    return;
                }
            }
            this.mClientState = 0;
            InstallReferrerCommons.logVerbose(str, "Install Referrer service unavailable on device.");
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
        }
    }

    public void endConnection() {
        this.mClientState = 3;
        if (this.mServiceConnection != null) {
            InstallReferrerCommons.logVerbose(TAG, "Unbinding from service.");
            this.mApplicationContext.unbindService(this.mServiceConnection);
            this.mServiceConnection = null;
        }
        this.mService = null;
    }

    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (isReady()) {
            Bundle bundle = new Bundle();
            bundle.putString(InMobiNetworkValues.PACKAGE_NAME, this.mApplicationContext.getPackageName());
            try {
                return new ReferrerDetails(this.mService.getInstallReferrer(bundle));
            } catch (RemoteException e) {
                InstallReferrerCommons.logWarn(TAG, "RemoteException getting install referrer information");
                this.mClientState = 0;
                throw e;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }

    private boolean isPlayStoreCompatible() {
        try {
            if (this.mApplicationContext.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= PLAY_STORE_MIN_APP_VER) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }
}
