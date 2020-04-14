package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcit extends zzalw {
    private zzcgf<zzamd, zzchk> zzfxs;
    private final /* synthetic */ zzcir zzfyz;

    private zzcit(zzcir zzcir, zzcgf<zzamd, zzchk> zzcgf) {
        this.zzfyz = zzcir;
        this.zzfxs = zzcgf;
    }

    public final void zza(zzakm zzakm) throws RemoteException {
        this.zzfyz.zzfyy = zzakm;
        ((zzchk) this.zzfxs.zzfxg).onAdLoaded();
    }

    public final void zzdg(String str) throws RemoteException {
        ((zzchk) this.zzfxs.zzfxg).onAdFailedToLoad(0);
    }
}
