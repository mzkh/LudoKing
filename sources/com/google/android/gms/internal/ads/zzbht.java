package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbht implements zzdwb<zzajc> {
    private final zzdwo<zzaix> zzfcu;

    private zzbht(zzdwo<zzaix> zzdwo) {
        this.zzfcu = zzdwo;
    }

    public static zzbht zzb(zzdwo<zzaix> zzdwo) {
        return new zzbht(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzajc) zzdwh.zza(((zzaix) this.zzfcu.get()).zzrl(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
