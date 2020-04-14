package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqe implements zzdwb<zzcqc> {
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<zzcvp> zzfxz;

    private zzcqe(zzdwo<zzddl> zzdwo, zzdwo<zzcvp> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzfxz = zzdwo2;
    }

    public static zzcqe zzap(zzdwo<zzddl> zzdwo, zzdwo<zzcvp> zzdwo2) {
        return new zzcqe(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcqc((zzddl) this.zzfck.get(), (zzcvp) this.zzfxz.get());
    }
}
