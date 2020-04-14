package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblk implements zzdwb<zzbqs<zzbna>> {
    private final zzbli zzfgg;
    private final zzdwo<zzblr> zzfgh;

    private zzblk(zzbli zzbli, zzdwo<zzblr> zzdwo) {
        this.zzfgg = zzbli;
        this.zzfgh = zzdwo;
    }

    public static zzblk zza(zzbli zzbli, zzdwo<zzblr> zzdwo) {
        return new zzblk(zzbli, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzblr) this.zzfgh.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
