package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdk extends zzl {
    private final /* synthetic */ zzch zzfu;
    private final ListenerToken zzgh;
    private final ListenerHolder<OpenFileCallback> zzgi;

    zzdk(zzch zzch, ListenerToken listenerToken, ListenerHolder<OpenFileCallback> listenerHolder) {
        this.zzfu = zzch;
        this.zzgh = listenerToken;
        this.zzgi = listenerHolder;
    }

    private final void zza(zzdg<OpenFileCallback> zzdg) {
        this.zzgi.notifyListener(new zzdo(this, zzdg));
    }

    public final void zza(Status status) throws RemoteException {
        zza((zzdg<OpenFileCallback>) new zzdl<OpenFileCallback>(this, status));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Status status, OpenFileCallback openFileCallback) {
        openFileCallback.onError(ApiExceptionUtil.fromStatus(status));
        this.zzfu.cancelOpenFileCallback(this.zzgh);
    }

    public final void zza(zzfb zzfb) throws RemoteException {
        zza((zzdg<OpenFileCallback>) new zzdn<OpenFileCallback>(this, zzfb));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzfb zzfb, OpenFileCallback openFileCallback) {
        openFileCallback.onContents(new zzbi(zzfb.zzeq));
        this.zzfu.cancelOpenFileCallback(this.zzgh);
    }

    public final void zza(zzff zzff) throws RemoteException {
        zza((zzdg<OpenFileCallback>) new zzdm<OpenFileCallback>(zzff));
    }
}
