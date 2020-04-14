package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfr implements zzcvj {
    private final /* synthetic */ zzbfa zzerq;
    private zzdwo<Context> zzeyv;
    private zzdwo<zzcud<zzbzc, zzbyz>> zzeyw;
    private zzdwo<zzcui> zzeyx;
    private zzdwo<zzcwc> zzeyy;
    private zzdwo<zzcvb> zzeyz;
    private zzdwo<zzcvl> zzeza;
    private zzdwo<String> zzezb;
    private zzdwo<zzcvf> zzezc;

    private zzbfr(zzbfa zzbfa, Context context, String str) {
        this.zzerq = zzbfa;
        this.zzeyv = zzdwe.zzbb(context);
        this.zzeyw = new zzcug(this.zzeyv);
        this.zzeyx = zzdwc.zzan(zzcuz.zzamu());
        this.zzeyy = zzdwc.zzan(zzcwb.zzamz());
        zzcvg zzcvg = new zzcvg(this.zzeyv, this.zzerq.zzekc, this.zzerq.zzejx, this.zzeyw, this.zzeyx, zzcwf.zzanb(), this.zzeyy);
        this.zzeyz = zzdwc.zzan(zzcvg);
        this.zzeza = zzdwc.zzan(new zzcvq(this.zzeyz, this.zzeyx, this.zzeyy));
        this.zzezb = zzdwe.zzbc(str);
        this.zzezc = zzdwc.zzan(new zzcvk(this.zzezb, this.zzeyz, this.zzeyx, this.zzeyy));
    }

    public final zzcvl zzadk() {
        return (zzcvl) this.zzeza.get();
    }

    public final zzcvf zzadl() {
        return (zzcvf) this.zzezc.get();
    }
}
