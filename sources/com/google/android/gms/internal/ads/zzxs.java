package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxs extends zzwa {
    private zzafu zzcfh;

    public final String getVersionString() {
        return "";
    }

    public final void setAppMuted(boolean z) throws RemoteException {
    }

    public final void setAppVolume(float f) throws RemoteException {
    }

    public final void zza(zzajx zzajx) throws RemoteException {
    }

    public final void zza(zzyd zzyd) throws RemoteException {
    }

    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzby(String str) throws RemoteException {
    }

    public final void zzbz(String str) throws RemoteException {
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final float zzos() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzot() throws RemoteException {
        return false;
    }

    public final void initialize() throws RemoteException {
        zzaxi.zzes("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzawy.zzzb.post(new zzxv(this));
    }

    public final void zza(zzafu zzafu) throws RemoteException {
        this.zzcfh = zzafu;
    }

    public final List<zzafr> zzou() throws RemoteException {
        return Collections.EMPTY_LIST;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzpj() {
        zzafu zzafu = this.zzcfh;
        if (zzafu != null) {
            try {
                zzafu.zzc(Collections.EMPTY_LIST);
            } catch (RemoteException e) {
                zzaxi.zzd("Could not notify onComplete event.", e);
            }
        }
    }
}
