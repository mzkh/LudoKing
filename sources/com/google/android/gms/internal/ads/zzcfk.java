package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfk implements zzdwb<zzcfj> {
    private final zzdwo<zzcfh> zzepa;
    private final zzdwo<zzddl> zzfvy;

    private zzcfk(zzdwo<zzcfh> zzdwo, zzdwo<zzddl> zzdwo2) {
        this.zzepa = zzdwo;
        this.zzfvy = zzdwo2;
    }

    public static zzcfk zzai(zzdwo<zzcfh> zzdwo, zzdwo<zzddl> zzdwo2) {
        return new zzcfk(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcfj((zzcfh) this.zzepa.get(), (zzddl) this.zzfvy.get());
    }
}
