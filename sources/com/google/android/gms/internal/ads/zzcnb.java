package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmk.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnb extends zzati {
    private zzbei zzgdl;

    public zzcnb(zzbei zzbei) {
        this.zzgdl = zzbei;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzath zzath, zzatd zzatd) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str = zzath.zzbqy;
        String str2 = zzath.zzblw;
        zzdcy.zza(this.zzgdl.zzabo().zzf(new zza().zzby(context).zza(new zzcwg().zzgf(str).zzg(new zztw().zznz()).zzd(zzath.zzdpz).zzane()).zzafy()).zza(new zzcnc(new zzcnc.zza().zzge(str2))).zzf(new zzbpn.zza().zzagm()).zzado().zzadt(), new zzcna(this, zzatd), this.zzgdl.zzabb());
    }
}
