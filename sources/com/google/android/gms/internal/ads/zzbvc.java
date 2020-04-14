package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvc implements zzdwb<zzasm> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcwe> zzfef;
    private final zzbvd zzfmg;

    private zzbvc(zzbvd zzbvd, zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2) {
        this.zzfmg = zzbvd;
        this.zzejy = zzdwo;
        this.zzfef = zzdwo2;
    }

    public static zzbvc zza(zzbvd zzbvd, zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2) {
        return new zzbvc(zzbvd, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzasm) zzdwh.zza(new zzasm((Context) this.zzejy.get(), ((zzcwe) this.zzfef.get()).zzgkh), "Cannot return null from a non-@Nullable @Provides method");
    }
}
