package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbmh implements zzdal {
    private final Context zzdpy;
    private final zzaxl zzfdz;
    private final zzcwe zzfgq;

    zzbmh(Context context, zzaxl zzaxl, zzcwe zzcwe) {
        this.zzdpy = context;
        this.zzfdz = zzaxl;
        this.zzfgq = zzcwe;
    }

    public final Object apply(Object obj) {
        Context context = this.zzdpy;
        zzaxl zzaxl = this.zzfdz;
        zzcwe zzcwe = this.zzfgq;
        zzcvr zzcvr = (zzcvr) obj;
        zzavd zzavd = new zzavd(context);
        zzavd.zzej(zzcvr.zzdkv);
        zzavd.zzek(zzcvr.zzgjj.toString());
        zzavd.zzr(zzaxl.zzblz);
        zzavd.setAdUnitId(zzcwe.zzgkh);
        return zzavd;
    }
}
