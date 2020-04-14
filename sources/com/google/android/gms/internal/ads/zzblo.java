package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblo implements zzdwb<zzatq> {
    private final zzdwo<zzatz> zzelw;
    private final zzdwo<Clock> zzfco;
    private final zzdwo<zzcwe> zzfef;

    private zzblo(zzdwo<Clock> zzdwo, zzdwo<zzatz> zzdwo2, zzdwo<zzcwe> zzdwo3) {
        this.zzfco = zzdwo;
        this.zzelw = zzdwo2;
        this.zzfef = zzdwo3;
    }

    public static zzblo zzh(zzdwo<Clock> zzdwo, zzdwo<zzatz> zzdwo2, zzdwo<zzcwe> zzdwo3) {
        return new zzblo(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return (zzatq) zzdwh.zza(((zzatz) this.zzelw.get()).zza((Clock) this.zzfco.get(), ((zzcwe) this.zzfef.get()).zzgkh), "Cannot return null from a non-@Nullable @Provides method");
    }
}
