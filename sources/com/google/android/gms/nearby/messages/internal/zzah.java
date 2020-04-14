package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.internal.nearby.zzgy;
import com.google.android.gms.internal.nearby.zzhb;
import com.google.android.gms.internal.nearby.zzhd;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzah extends GmsClient<zzs> {
    private final int zzfh;
    private final ClientAppContext zzhi;
    private final zzhd<ListenerKey, IBinder> zzhl = new zzhd<>();

    @TargetApi(14)
    zzah(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        int i;
        super(context, looper, 62, clientSettings, connectionCallbacks, onConnectionFailedListener);
        String realClientPackageName = clientSettings.getRealClientPackageName();
        int zzb = zzb(context);
        if (messagesOptions != null) {
            ClientAppContext clientAppContext = new ClientAppContext(realClientPackageName, null, false, null, zzb);
            this.zzhi = clientAppContext;
            i = messagesOptions.zzfh;
        } else {
            ClientAppContext clientAppContext2 = new ClientAppContext(realClientPackageName, null, false, null, zzb);
            this.zzhi = clientAppContext2;
            i = -1;
        }
        this.zzfh = i;
        if (zzb == 1 && PlatformVersion.isAtLeastIceCreamSandwich()) {
            Activity activity = (Activity) context;
            String str = "NearbyMessagesClient";
            if (Log.isLoggable(str, 2)) {
                Log.v(str, String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new zzaj(activity, this));
        }
    }

    static int zzb(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return queryLocalInterface instanceof zzs ? (zzs) queryLocalInterface : new zzt(iBinder);
    }

    public final void disconnect() {
        try {
            zzf(2);
        } catch (RemoteException e) {
            String str = "NearbyMessagesClient";
            if (Log.isLoggable(str, 2)) {
                Log.v(str, String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", new Object[]{e}));
            }
        }
        this.zzhl.clear();
        super.disconnect();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        getServiceRequestExtraArgs.putInt("NearbyPermissions", this.zzfh);
        getServiceRequestExtraArgs.putParcelable("ClientAppContext", this.zzhi);
        return getServiceRequestExtraArgs;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    /* access modifiers changed from: 0000 */
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent) throws RemoteException {
        ((zzs) getService()).zza(new zzcg(null, new zzgy(listenerHolder), pendingIntent));
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent, @Nullable zzab zzab, SubscribeOptions subscribeOptions) throws RemoteException {
        zza(listenerHolder, pendingIntent, zzab, subscribeOptions, this.zzhi.zzhf);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent, @Nullable zzab zzab, SubscribeOptions subscribeOptions, int i) throws RemoteException {
        SubscribeOptions subscribeOptions2 = subscribeOptions;
        ListenerHolder<ResultHolder<Status>> listenerHolder2 = listenerHolder;
        SubscribeRequest subscribeRequest = new SubscribeRequest(null, subscribeOptions.getStrategy(), new zzgy(listenerHolder), subscribeOptions.getFilter(), pendingIntent, null, zzab, subscribeOptions2.zzgb, subscribeOptions2.zzgc, this.zzhi.zzhf);
        ((zzs) getService()).zza(subscribeRequest);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2) throws RemoteException {
        zzgy zzgy = new zzgy(listenerHolder);
        if (!this.zzhl.containsKey(listenerHolder2.getListenerKey())) {
            zzgy.zza(new Status(0));
            return;
        }
        ((zzs) getService()).zza(new zzcg((IBinder) this.zzhl.get(listenerHolder2.getListenerKey()), zzgy, null));
        this.zzhl.remove(listenerHolder2.getListenerKey());
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2, @Nullable zzab zzab, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) throws RemoteException {
        zza(listenerHolder, listenerHolder2, zzab, subscribeOptions, null, this.zzhi.zzhf);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2, @Nullable zzab zzab, SubscribeOptions subscribeOptions, @Nullable byte[] bArr, int i) throws RemoteException {
        if (!this.zzhl.containsKey(listenerHolder2.getListenerKey())) {
            this.zzhl.zza(listenerHolder2.getListenerKey(), new zzgw(listenerHolder2));
        } else {
            ListenerHolder<MessageListener> listenerHolder3 = listenerHolder2;
        }
        ListenerHolder<ResultHolder<Status>> listenerHolder4 = listenerHolder;
        SubscribeRequest subscribeRequest = new SubscribeRequest((IBinder) this.zzhl.get(listenerHolder2.getListenerKey()), subscribeOptions.getStrategy(), new zzgy(listenerHolder), subscribeOptions.getFilter(), null, null, zzab, subscribeOptions.zzgb, i);
        ((zzs) getService()).zza(subscribeRequest);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, zzaf zzaf) throws RemoteException {
        ((zzs) getService()).zza(new zzce(zzaf, new zzgy(listenerHolder)));
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, zzaf zzaf, @Nullable zzv zzv, PublishOptions publishOptions) throws RemoteException {
        zza(listenerHolder, zzaf, zzv, publishOptions, this.zzhi.zzhf);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(ListenerHolder<ResultHolder<Status>> listenerHolder, zzaf zzaf, @Nullable zzv zzv, PublishOptions publishOptions, int i) throws RemoteException {
        zzbz zzbz = new zzbz(zzaf, publishOptions.getStrategy(), new zzgy(listenerHolder), zzv, i);
        ((zzs) getService()).zza(zzbz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(ListenerHolder<ResultHolder<Status>> listenerHolder, ListenerHolder<StatusCallback> listenerHolder2) throws RemoteException {
        if (!this.zzhl.containsKey(listenerHolder2.getListenerKey())) {
            this.zzhl.zza(listenerHolder2.getListenerKey(), new zzhb(listenerHolder2));
        }
        zzcb zzcb = new zzcb(new zzgy(listenerHolder), (IBinder) this.zzhl.get(listenerHolder2.getListenerKey()));
        zzcb.zzix = true;
        ((zzs) getService()).zza(zzcb);
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(ListenerHolder<ResultHolder<Status>> listenerHolder, ListenerHolder<StatusCallback> listenerHolder2) throws RemoteException {
        zzgy zzgy = new zzgy(listenerHolder);
        if (!this.zzhl.containsKey(listenerHolder2.getListenerKey())) {
            zzgy.zza(new Status(0));
            return;
        }
        zzcb zzcb = new zzcb(zzgy, (IBinder) this.zzhl.get(listenerHolder2.getListenerKey()));
        zzcb.zzix = false;
        ((zzs) getService()).zza(zzcb);
        this.zzhl.remove(listenerHolder2.getListenerKey());
    }

    /* access modifiers changed from: 0000 */
    public final void zzf(int i) throws RemoteException {
        String str;
        String str2 = "NearbyMessagesClient";
        if (i == 1) {
            str = "ACTIVITY_STOPPED";
        } else if (i != 2) {
            if (Log.isLoggable(str2, 5)) {
                Log.w(str2, String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", new Object[]{Integer.valueOf(i)}));
            }
            return;
        } else {
            str = "CLIENT_DISCONNECTED";
        }
        if (isConnected()) {
            zzj zzj = new zzj(i);
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, String.format("Emitting client lifecycle event %s", new Object[]{str}));
            }
            ((zzs) getService()).zza(zzj);
            return;
        }
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", new Object[]{str}));
        }
    }
}
