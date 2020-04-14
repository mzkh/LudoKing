package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsh implements zzdwb<zzasm> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcwe> zzfef;
    private final zzbrx zzfin;

    private zzbsh(zzbrx zzbrx, zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2) {
        this.zzfin = zzbrx;
        this.zzejy = zzdwo;
        this.zzfef = zzdwo2;
    }

    public static zzbsh zza(zzbrx zzbrx, zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2) {
        return new zzbsh(zzbrx, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzasm) zzdwh.zza(new zzasm((Context) this.zzejy.get(), ((zzcwe) this.zzfef.get()).zzgkh), "Cannot return null from a non-@Nullable @Provides method");
    }
}
