package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmb extends zzvc {
    private final zzcmm zzgca;

    public zzcmb(Context context, zzbei zzbei, zzcwg zzcwg, zzbuy zzbuy, zzuy zzuy) {
        zzcmo zzcmo = new zzcmo(zzbuy);
        zzcmo.zzc(zzuy);
        this.zzgca = new zzcmm(new zzcmu(zzbei, context, zzcmo, zzcwg), zzcwg.zzand());
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgca.isLoading();
    }

    public final void zzb(zztx zztx) throws RemoteException {
        this.zzgca.zzb(zztx);
    }

    public final synchronized void zza(zztx zztx, int i) throws RemoteException {
        this.zzgca.zza(zztx, i);
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.zzgca.getMediationAdapterClassName();
    }

    public final synchronized String zzju() {
        return this.zzgca.zzju();
    }
}
