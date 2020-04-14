package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoc implements zzdwb<zzcoa> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcpd<zzcrx>> zzelb;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzatr> zzgeg;

    private zzcoc(zzdwo<zzcpd<zzcrx>> zzdwo, zzdwo<zzcwe> zzdwo2, zzdwo<Context> zzdwo3, zzdwo<zzatr> zzdwo4) {
        this.zzelb = zzdwo;
        this.zzfef = zzdwo2;
        this.zzejy = zzdwo3;
        this.zzgeg = zzdwo4;
    }

    public static zzcoc zze(zzdwo<zzcpd<zzcrx>> zzdwo, zzdwo<zzcwe> zzdwo2, zzdwo<Context> zzdwo3, zzdwo<zzatr> zzdwo4) {
        return new zzcoc(zzdwo, zzdwo2, zzdwo3, zzdwo4);
    }

    public final /* synthetic */ Object get() {
        return new zzcoa((zzcpd) this.zzelb.get(), (zzcwe) this.zzfef.get(), (Context) this.zzejy.get(), (zzatr) this.zzgeg.get());
    }
}
