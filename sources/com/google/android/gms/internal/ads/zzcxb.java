package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxb implements zzdwb<Context> {
    private final zzcxa zzgla;
    private final zzdwo<zzcwy> zzglb;

    private zzcxb(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        this.zzgla = zzcxa;
        this.zzglb = zzdwo;
    }

    public static zzcxb zzb(zzcxa zzcxa, zzdwo<zzcwy> zzdwo) {
        return new zzcxb(zzcxa, zzdwo);
    }

    public static Context zzb(zzcxa zzcxa, zzcwy zzcwy) {
        return (Context) zzdwh.zza(zzcwy.zzzc, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzgla, (zzcwy) this.zzglb.get());
    }
}
