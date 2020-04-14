package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbce implements zzdcj {
    private final zzdf zzczr;
    private final Context zzdpy;
    private final zzaxl zzefr;
    private final zza zzefs;
    private final String zzeft;

    zzbce(Context context, zzdf zzdf, zzaxl zzaxl, zza zza, String str) {
        this.zzdpy = context;
        this.zzczr = zzdf;
        this.zzefr = zzaxl;
        this.zzefs = zza;
        this.zzeft = str;
    }

    public final zzddi zzf(Object obj) {
        Context context = this.zzdpy;
        zzdf zzdf = this.zzczr;
        zzaxl zzaxl = this.zzefr;
        zza zza = this.zzefs;
        String str = this.zzeft;
        zzq.zzkk();
        zzbbw zza2 = zzbcb.zza(context, zzbdj.zzaar(), "", false, false, zzdf, zzaxl, null, null, zza, zzsd.zzmm(), null, false);
        zzaxw zzl = zzaxw.zzl(zza2);
        zza2.zzzp().zza((zzbdf) new zzbcg(zzl));
        zza2.loadUrl(str);
        return zzl;
    }
}
