package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbte implements zzdwb<zzbtf> {
    private final zzdwo<zzbuy> zzfdw;
    private final zzdwo<Map<String, zzcga<zzbkq>>> zzffl;
    private final zzdwo<Map<String, zzcga<zzbuj>>> zzfiz;
    private final zzdwo<Map<String, zzcih<zzbuj>>> zzfja;
    private final zzdwo<zzbkp<zzbio>> zzfjb;

    public zzbte(zzdwo<Map<String, zzcga<zzbkq>>> zzdwo, zzdwo<Map<String, zzcga<zzbuj>>> zzdwo2, zzdwo<Map<String, zzcih<zzbuj>>> zzdwo3, zzdwo<zzbkp<zzbio>> zzdwo4, zzdwo<zzbuy> zzdwo5) {
        this.zzffl = zzdwo;
        this.zzfiz = zzdwo2;
        this.zzfja = zzdwo3;
        this.zzfjb = zzdwo4;
        this.zzfdw = zzdwo5;
    }

    public final /* synthetic */ Object get() {
        zzbtf zzbtf = new zzbtf((Map) this.zzffl.get(), (Map) this.zzfiz.get(), (Map) this.zzfja.get(), this.zzfjb, (zzbuy) this.zzfdw.get());
        return zzbtf;
    }
}
