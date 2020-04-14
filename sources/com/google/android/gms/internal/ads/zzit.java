package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzit implements zziv {
    private static final byte[] zzamn = new byte[4096];
    private final zzne zzamo;
    private final long zzamp;
    private long zzamq;
    private byte[] zzamr = new byte[65536];
    private int zzams;
    private int zzamt;

    public zzit(zzne zzne, long j, long j2) {
        this.zzamo = zzne;
        this.zzamq = j;
        this.zzamp = j2;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzaf(zzb);
        return zzb;
    }

    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzaf(zzb);
        return zzb != -1;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    public final int zzaa(int i) throws IOException, InterruptedException {
        int zzad = zzad(i);
        if (zzad == 0) {
            byte[] bArr = zzamn;
            zzad = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzaf(zzad);
        return zzad;
    }

    public final void zzab(int i) throws IOException, InterruptedException {
        int zzad = zzad(i);
        while (zzad < i && zzad != -1) {
            byte[] bArr = zzamn;
            zzad = zza(bArr, -zzad, Math.min(i, bArr.length + zzad), zzad, false);
        }
        zzaf(zzad);
    }

    public final void zza(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzamr, this.zzams - i2, bArr, i, i2);
        }
    }

    private final boolean zzd(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.zzams + i;
        byte[] bArr = this.zzamr;
        if (i2 > bArr.length) {
            this.zzamr = Arrays.copyOf(this.zzamr, zzof.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzamt - this.zzams, i);
        while (min < i) {
            min = zza(this.zzamr, this.zzams, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.zzams += i;
        this.zzamt = Math.max(this.zzamt, this.zzams);
        return true;
    }

    public final void zzac(int i) throws IOException, InterruptedException {
        zzd(i, false);
    }

    public final void zzgb() {
        this.zzams = 0;
    }

    public final long getPosition() {
        return this.zzamq;
    }

    public final long getLength() {
        return this.zzamp;
    }

    private final int zzad(int i) {
        int min = Math.min(this.zzamt, i);
        zzae(min);
        return min;
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzamt;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzamr, 0, bArr, i, min);
        zzae(min);
        return min;
    }

    private final void zzae(int i) {
        this.zzamt -= i;
        this.zzams = 0;
        byte[] bArr = this.zzamr;
        int i2 = this.zzamt;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[(i2 + 65536)];
        }
        System.arraycopy(this.zzamr, i, bArr, 0, this.zzamt);
        this.zzamr = bArr;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.zzamo.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final void zzaf(int i) {
        if (i != -1) {
            this.zzamq += (long) i;
        }
    }
}
