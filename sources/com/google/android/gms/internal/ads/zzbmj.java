package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmj implements zzdwb<zzbou> {
    private final zzdwo<zzbou> zzfgr;

    private zzbmj(zzdwo<zzbou> zzdwo) {
        this.zzfgr = zzdwo;
    }

    public static zzbmj zzf(zzdwo<zzbou> zzdwo) {
        return new zzbmj(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbou) zzdwh.zza((zzbou) this.zzfgr.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
