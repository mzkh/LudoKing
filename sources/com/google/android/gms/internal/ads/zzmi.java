package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmi extends zzgy {
    private static final Object zzbcx = new Object();
    private final boolean zzags;
    private final boolean zzagt;
    private final long zzbcy;
    private final long zzbcz;
    private final long zzbda;
    private final long zzbdb;

    public zzmi(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public final int zzep() {
        return 1;
    }

    public final int zzeq() {
        return 1;
    }

    private zzmi(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbcy = j;
        this.zzbcz = j2;
        this.zzbda = 0;
        this.zzbdb = 0;
        this.zzags = z;
        this.zzagt = false;
    }

    public final zzhd zza(int i, zzhd zzhd, boolean z, long j) {
        zznr.zzc(i, 0, 1);
        boolean z2 = this.zzags;
        long j2 = this.zzbcz;
        zzhd.zzagg = null;
        zzhd.zzagq = -9223372036854775807L;
        zzhd.zzagr = -9223372036854775807L;
        zzhd.zzags = z2;
        zzhd.zzagt = false;
        zzhd.zzagw = 0;
        zzhd.zzagh = j2;
        zzhd.zzagu = 0;
        zzhd.zzagv = 0;
        zzhd.zzagx = 0;
        return zzhd;
    }

    public final zzha zza(int i, zzha zzha, boolean z) {
        zznr.zzc(i, 0, 1);
        Object obj = z ? zzbcx : null;
        return zzha.zza(obj, obj, 0, this.zzbcy, 0, false);
    }

    public final int zzc(Object obj) {
        return zzbcx.equals(obj) ? 0 : -1;
    }
}
