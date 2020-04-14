package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcjr extends zzamb {
    private zzcgf<zzamd, zzchk> zzfxs;

    private zzcjr(zzcjm zzcjm, zzcgf<zzamd, zzchk> zzcgf) {
        this.zzfxs = zzcgf;
    }

    public final void zzsf() throws RemoteException {
        ((zzchk) this.zzfxs.zzfxg).onAdLoaded();
    }

    public final void zzdg(String str) throws RemoteException {
        ((zzchk) this.zzfxs.zzfxg).onAdFailedToLoad(0);
    }
}
