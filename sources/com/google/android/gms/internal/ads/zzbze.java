package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbze implements zzdwb<zzcga<zzbyz>> {
    private final zzdwo<zzckm<zzbyz, zzcwm, zzchn>> zzfcm;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzckm<zzbyz, zzcwm, zzchk>> zzfqj;

    public zzbze(zzdwo<zzckm<zzbyz, zzcwm, zzchn>> zzdwo, zzdwo<zzckm<zzbyz, zzcwm, zzchk>> zzdwo2, zzdwo<zzcwe> zzdwo3) {
        this.zzfcm = zzdwo;
        this.zzfqj = zzdwo2;
        this.zzfef = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        zzcga zzcga;
        zzdwo<zzckm<zzbyz, zzcwm, zzchn>> zzdwo = this.zzfcm;
        zzdwo<zzckm<zzbyz, zzcwm, zzchk>> zzdwo2 = this.zzfqj;
        if (((zzcwe) this.zzfef.get()).zzgkn.contains("new_rewarded")) {
            zzcga = (zzcga) zzdwo2.get();
        } else {
            zzcga = (zzcga) zzdwo.get();
        }
        return (zzcga) zzdwh.zza(zzcga, "Cannot return null from a non-@Nullable @Provides method");
    }
}
