package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoh implements zzdwb<zzcof> {
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<zzcwe> zzfef;

    private zzcoh(zzdwo<zzddl> zzdwo, zzdwo<zzcwe> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzfef = zzdwo2;
    }

    public static zzcoh zzak(zzdwo<zzddl> zzdwo, zzdwo<zzcwe> zzdwo2) {
        return new zzcoh(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcof((zzddl) this.zzfck.get(), (zzcwe) this.zzfef.get());
    }
}
