package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcjy implements zzdal {
    private final zzcvr zzfea;
    private final zzbbw zzfpd;
    private final zzcju zzfzr;
    private final zzbzb zzfzs;

    zzcjy(zzcju zzcju, zzbbw zzbbw, zzcvr zzcvr, zzbzb zzbzb) {
        this.zzfzr = zzcju;
        this.zzfpd = zzbbw;
        this.zzfea = zzcvr;
        this.zzfzs = zzbzb;
    }

    public final Object apply(Object obj) {
        zzbbw zzbbw = this.zzfpd;
        zzcvr zzcvr = this.zzfea;
        zzbzb zzbzb = this.zzfzs;
        if (zzcvr.zzdnj) {
            zzbbw.zzaac();
        }
        zzbbw.zzzj();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzckb)).booleanValue()) {
            zzq.zzkl();
            zzaur.zza(zzbbw);
        }
        return zzbzb.zzadp();
    }
}
