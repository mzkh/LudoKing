package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcum implements zzcva {
    private final String zzcyz;
    private final String zzdbt;
    private final zzapy zzfhc;

    zzcum(zzapy zzapy, String str, String str2) {
        this.zzfhc = zzapy;
        this.zzcyz = str;
        this.zzdbt = str2;
    }

    public final void zzt(Object obj) {
        zzapy zzapy = this.zzfhc;
        ((zzarj) obj).zza(new zzarw(zzapy.getType(), zzapy.getAmount()), this.zzcyz, this.zzdbt);
    }
}
