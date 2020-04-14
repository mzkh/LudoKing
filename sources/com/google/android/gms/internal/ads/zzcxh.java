package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxh implements zzdwb<zzddl> {
    private static final zzcxh zzgle = new zzcxh();

    public static zzcxh zzanj() {
        return zzgle;
    }

    public final /* synthetic */ Object get() {
        zzddl zzddl;
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrx)).booleanValue()) {
            zzddl = zzaxn.zzdwk;
        } else {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcrw)).booleanValue()) {
                zzddl = zzaxn.zzdwi;
            } else {
                zzddl = zzaxn.zzdwm;
            }
        }
        return (zzddl) zzdwh.zza(zzddl, "Cannot return null from a non-@Nullable @Provides method");
    }
}
