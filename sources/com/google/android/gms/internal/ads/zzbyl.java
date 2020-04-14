package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbyl implements zzdcz<zzbbw> {
    private final /* synthetic */ String zzfpt;
    private final /* synthetic */ zzaer zzfpu;

    zzbyl(zzbyh zzbyh, String str, zzaer zzaer) {
        this.zzfpt = str;
        this.zzfpu = zzaer;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbbw) obj).zza(this.zzfpt, this.zzfpu);
    }
}
