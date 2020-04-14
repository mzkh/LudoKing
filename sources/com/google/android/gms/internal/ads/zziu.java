package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zziu implements zzjb {
    private final int length;
    private final long zzagh;
    private final int[] zzamu;
    private final long[] zzamv;
    private final long[] zzamw;
    private final long[] zzamx;

    public zziu(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzamu = iArr;
        this.zzamv = jArr;
        this.zzamw = jArr2;
        this.zzamx = jArr3;
        this.length = iArr.length;
        int i = this.length;
        if (i > 0) {
            this.zzagh = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.zzagh = 0;
        }
    }

    public final boolean zzgc() {
        return true;
    }

    public final long getDurationUs() {
        return this.zzagh;
    }

    public final long zzdt(long j) {
        return this.zzamv[zzof.zza(this.zzamx, j, true, true)];
    }
}
