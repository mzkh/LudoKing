package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjt implements zzdwb<zzcga<zzbio>> {
    private final zzdwo<zzddl> zzfdx;
    private final zzdwo<zzcyg> zzfek;
    private final zzdwo<zzcgw> zzfel;
    private final zzdwo<zzckk> zzfem;

    public zzbjt(zzdwo<zzcyg> zzdwo, zzdwo<zzddl> zzdwo2, zzdwo<zzcgw> zzdwo3, zzdwo<zzckk> zzdwo4) {
        this.zzfek = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzfel = zzdwo3;
        this.zzfem = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return (zzcga) zzdwh.zza(new zzckm((zzcyg) this.zzfek.get(), (zzddl) this.zzfdx.get(), (zzckk) this.zzfem.get(), (zzcgw) this.zzfel.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
