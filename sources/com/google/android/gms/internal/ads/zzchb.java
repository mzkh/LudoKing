package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzchb extends zzalq {
    private zzcgf<zzamd, zzchk> zzfxs;
    private final /* synthetic */ zzcgw zzfxt;

    private zzchb(zzcgw zzcgw, zzcgf<zzamd, zzchk> zzcgf) {
        this.zzfxt = zzcgw;
        this.zzfxs = zzcgf;
    }

    public final void zzab(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzfxt.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzchk) this.zzfxs.zzfxg).onAdLoaded();
    }

    public final void zzdg(String str) throws RemoteException {
        ((zzchk) this.zzfxs.zzfxg).onAdFailedToLoad(0);
    }
}
