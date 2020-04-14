package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcki extends zzaqs {
    private final /* synthetic */ zzboo zzfzy;
    private final /* synthetic */ zzbmv zzfzz;
    private final /* synthetic */ zzbnr zzgaa;
    private final /* synthetic */ zzbrc zzgab;

    zzcki(zzcke zzcke, zzboo zzboo, zzbmv zzbmv, zzbnr zzbnr, zzbrc zzbrc) {
        this.zzfzy = zzboo;
        this.zzfzz = zzbmv;
        this.zzgaa = zzbnr;
        this.zzgab = zzbrc;
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzfzy.zzsj();
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzfzy.zzsi();
    }

    public final void zzan(IObjectWrapper iObjectWrapper) {
        this.zzfzz.onAdClicked();
    }

    public final void zzao(IObjectWrapper iObjectWrapper) {
        this.zzgaa.onAdLeftApplication();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaqt zzaqt) {
        this.zzgab.zza(zzaqt);
    }

    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgab.zzra();
    }

    public final void zzap(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgaa.onRewardedVideoCompleted();
    }
}
