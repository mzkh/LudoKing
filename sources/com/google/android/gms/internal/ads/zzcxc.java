package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxc implements zzdwb<zzcwy> {
    private final zzdwo<zzcww> zzfcl;
    private final zzcxa zzgla;
    private final zzdwo<String> zzglc;

    private zzcxc(zzcxa zzcxa, zzdwo<zzcww> zzdwo, zzdwo<String> zzdwo2) {
        this.zzgla = zzcxa;
        this.zzfcl = zzdwo;
        this.zzglc = zzdwo2;
    }

    public static zzcxc zza(zzcxa zzcxa, zzdwo<zzcww> zzdwo, zzdwo<String> zzdwo2) {
        return new zzcxc(zzcxa, zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzcwy) zzdwh.zza(((zzcww) this.zzfcl.get()).zzgg((String) this.zzglc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
