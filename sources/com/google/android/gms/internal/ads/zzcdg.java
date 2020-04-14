package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdg implements zzdwb<zzddi<Bundle>> {
    private final zzdwo<zzcrt<Bundle>> zzeop;
    private final zzdwo<zzcyg> zzfek;

    private zzcdg(zzdwo<zzcyg> zzdwo, zzdwo<zzcrt<Bundle>> zzdwo2) {
        this.zzfek = zzdwo;
        this.zzeop = zzdwo2;
    }

    public static zzcdg zzaa(zzdwo<zzcyg> zzdwo, zzdwo<zzcrt<Bundle>> zzdwo2) {
        return new zzcdg(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzddi) zzdwh.zza(((zzcyg) this.zzfek.get()).zzu(zzcyd.SIGNALS).zzb(((zzcrt) this.zzeop.get()).zzs(new Bundle())).zzant(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
