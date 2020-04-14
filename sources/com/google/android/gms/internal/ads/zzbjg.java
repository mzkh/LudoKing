package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjg implements zzdwb<zzasm> {
    private final zzdwo<Context> zzejy;
    private final zzbiv zzfec;
    private final zzdwo<zzcwe> zzfef;

    public zzbjg(zzbiv zzbiv, zzdwo<Context> zzdwo, zzdwo<zzcwe> zzdwo2) {
        this.zzfec = zzbiv;
        this.zzejy = zzdwo;
        this.zzfef = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzasm) zzdwh.zza(new zzasm((Context) this.zzejy.get(), ((zzcwe) this.zzfef.get()).zzgkh), "Cannot return null from a non-@Nullable @Provides method");
    }
}
