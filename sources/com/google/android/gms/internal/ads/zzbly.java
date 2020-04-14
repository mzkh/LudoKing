package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbly implements zzdwb<zzc> {
    private final zzdwo<Context> zzejy;
    private final zzblz zzfgl;
    private final zzdwo<zzasi> zzfgm;

    private zzbly(zzblz zzblz, zzdwo<Context> zzdwo, zzdwo<zzasi> zzdwo2) {
        this.zzfgl = zzblz;
        this.zzejy = zzdwo;
        this.zzfgm = zzdwo2;
    }

    public static zzbly zza(zzblz zzblz, zzdwo<Context> zzdwo, zzdwo<zzasi> zzdwo2) {
        return new zzbly(zzblz, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzc) zzdwh.zza(new zzc((Context) this.zzejy.get(), (zzasi) this.zzfgm.get(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
