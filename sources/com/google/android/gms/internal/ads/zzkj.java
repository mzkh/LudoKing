package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzkj {
    public final int[] zzamu;
    public final long[] zzamv;
    public final int zzavc;
    public final int zzavi;
    public final int[] zzavk;
    public final long[] zzaxi;

    public zzkj(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zznr.checkArgument(iArr.length == jArr2.length);
        zznr.checkArgument(jArr.length == jArr2.length);
        if (iArr2.length != jArr2.length) {
            z = false;
        }
        zznr.checkArgument(z);
        this.zzamv = jArr;
        this.zzamu = iArr;
        this.zzavi = i;
        this.zzaxi = jArr2;
        this.zzavk = iArr2;
        this.zzavc = jArr.length;
    }

    public final int zzdw(long j) {
        for (int zza = zzof.zza(this.zzaxi, j, true, false); zza >= 0; zza--) {
            if ((this.zzavk[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzdx(long j) {
        for (int zzb = zzof.zzb(this.zzaxi, j, true, false); zzb < this.zzaxi.length; zzb++) {
            if ((this.zzavk[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
