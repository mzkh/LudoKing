package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzcec implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    protected final Object mLock = new Object();
    protected final zzaxv<InputStream> zzdbn = new zzaxv<>();
    protected boolean zzfux = false;
    protected boolean zzfuy = false;
    protected zzape zzfuz;
    @VisibleForTesting(otherwise = 3)
    @GuardedBy("mLock")
    protected zzaom zzfva;

    /* access modifiers changed from: protected */
    public final void zzakj() {
        synchronized (this.mLock) {
            this.zzfuy = true;
            if (this.zzfva.isConnected() || this.zzfva.isConnecting()) {
                this.zzfva.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public void onConnectionSuspended(int i) {
        zzaug.zzdv("Cannot connect to remote service, fallback to local instance.");
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaug.zzdv("Disconnected from remote ad request service.");
        this.zzdbn.setException(new zzcel(0));
    }
}
