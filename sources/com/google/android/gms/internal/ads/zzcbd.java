package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbd implements zzdwb<zzcay> {
    private final zzdwo<zzsd> zzfrj;
    private final zzdwo<Map<zzcyd, zzcba>> zzfrw;

    private zzcbd(zzdwo<zzsd> zzdwo, zzdwo<Map<zzcyd, zzcba>> zzdwo2) {
        this.zzfrj = zzdwo;
        this.zzfrw = zzdwo2;
    }

    public static zzcbd zzt(zzdwo<zzsd> zzdwo, zzdwo<Map<zzcyd, zzcba>> zzdwo2) {
        return new zzcbd(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcay((zzsd) this.zzfrj.get(), (Map) this.zzfrw.get());
    }
}
