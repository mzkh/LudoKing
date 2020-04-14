package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjo implements zzdwb<zzcga<zzbio>> {
    private final zzdwo<zzckm<zzbio, zzcwm, zzchk>> zzepq;
    private final zzdwo<Boolean> zzewh;
    private final zzdwo<zzciz> zzewj;

    public zzbjo(zzdwo<Boolean> zzdwo, zzdwo<zzciz> zzdwo2, zzdwo<zzckm<zzbio, zzcwm, zzchk>> zzdwo3) {
        this.zzewh = zzdwo;
        this.zzewj = zzdwo2;
        this.zzepq = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        Object obj = (zzciz) this.zzewj.get();
        Object obj2 = (zzckm) this.zzepq.get();
        if (!((Boolean) this.zzewh.get()).booleanValue()) {
            obj = obj2;
        }
        return (zzcga) zzdwh.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
