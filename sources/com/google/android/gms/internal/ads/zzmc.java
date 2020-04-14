package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzmc implements zzjd {
    private final zzoc zzant = new zzoc(32);
    private final zznc zzazw;
    private final int zzbcl;
    private final zzma zzbcm = new zzma();
    private final zzlz zzbcn = new zzlz();
    private final AtomicInteger zzbco = new AtomicInteger();
    private zzmb zzbcp;
    private zzmb zzbcq;
    private zzgo zzbcr;
    private boolean zzbcs;
    private zzgo zzbct;
    private long zzbcu;
    private int zzbcv;
    private zzme zzbcw;

    public zzmc(zznc zznc) {
        this.zzazw = zznc;
        this.zzbcl = zznc.zzia();
        int i = this.zzbcl;
        this.zzbcv = i;
        this.zzbcp = new zzmb(0, i);
        this.zzbcq = this.zzbcp;
    }

    public final void zzj(boolean z) {
        int andSet = this.zzbco.getAndSet(z ? 0 : 2);
        zzhn();
        this.zzbcm.zzho();
        if (andSet == 2) {
            this.zzbcr = null;
        }
    }

    public final int zzhp() {
        return this.zzbcm.zzhp();
    }

    public final void disable() {
        if (this.zzbco.getAndSet(2) == 0) {
            zzhn();
        }
    }

    public final boolean zzhq() {
        return this.zzbcm.zzhq();
    }

    public final zzgo zzhr() {
        return this.zzbcm.zzhr();
    }

    public final long zzhh() {
        return this.zzbcm.zzhh();
    }

    public final void zzhu() {
        long zzhs = this.zzbcm.zzhs();
        if (zzhs != -1) {
            zzed(zzhs);
        }
    }

    public final boolean zze(long j, boolean z) {
        long zzd = this.zzbcm.zzd(j, z);
        if (zzd == -1) {
            return false;
        }
        zzed(zzd);
        return true;
    }

    public final int zza(zzgq zzgq, zzik zzik, boolean z, boolean z2, long j) {
        int i;
        zzik zzik2 = zzik;
        int zza = this.zzbcm.zza(zzgq, zzik, z, z2, this.zzbcr, this.zzbcn);
        if (zza == -5) {
            this.zzbcr = zzgq.zzafx;
            return -5;
        } else if (zza == -4) {
            if (!zzik.zzfv()) {
                if (zzik2.zzamb < j) {
                    zzik2.zzv(Integer.MIN_VALUE);
                }
                if (zzik.zzfx()) {
                    zzlz zzlz = this.zzbcn;
                    long j2 = zzlz.zzauv;
                    this.zzant.reset(1);
                    zza(j2, this.zzant.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzant.data[0];
                    boolean z3 = (b & 128) != 0;
                    byte b2 = b & Byte.MAX_VALUE;
                    if (zzik2.zzama.f3919iv == null) {
                        zzik2.zzama.f3919iv = new byte[16];
                    }
                    zza(j3, zzik2.zzama.f3919iv, (int) b2);
                    long j4 = j3 + ((long) b2);
                    if (z3) {
                        this.zzant.reset(2);
                        zza(j4, this.zzant.data, 2);
                        j4 += 2;
                        i = this.zzant.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    int[] iArr = zzik2.zzama.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzik2.zzama.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i2 = i * 6;
                        this.zzant.reset(i2);
                        zza(j4, this.zzant.data, i2);
                        j4 += (long) i2;
                        this.zzant.zzbg(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.zzant.readUnsignedShort();
                            iArr4[i3] = this.zzant.zzir();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzlz.size - ((int) (j4 - zzlz.zzauv));
                    }
                    zzjg zzjg = zzlz.zzapp;
                    zzik2.zzama.set(i, iArr2, iArr4, zzjg.zzani, zzik2.zzama.f3919iv, zzjg.zzanh);
                    int i4 = (int) (j4 - zzlz.zzauv);
                    zzlz.zzauv += (long) i4;
                    zzlz.size -= i4;
                }
                zzik2.zzx(this.zzbcn.size);
                long j5 = this.zzbcn.zzauv;
                ByteBuffer byteBuffer = zzik2.zzcq;
                int i5 = this.zzbcn.size;
                zzed(j5);
                while (i5 > 0) {
                    int i6 = (int) (j5 - this.zzbcp.zzbch);
                    int min = Math.min(i5, this.zzbcl - i6);
                    zzmz zzmz = this.zzbcp.zzbcj;
                    byteBuffer.put(zzmz.data, zzmz.zzay(i6), min);
                    j5 += (long) min;
                    i5 -= min;
                    if (j5 == this.zzbcp.zzaqu) {
                        this.zzazw.zza(zzmz);
                        this.zzbcp = this.zzbcp.zzht();
                    }
                }
                zzed(this.zzbcn.zzbbu);
            }
            return -4;
        } else if (zza == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzed(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbcp.zzbch);
            int min = Math.min(i - i2, this.zzbcl - i3);
            zzmz zzmz = this.zzbcp.zzbcj;
            System.arraycopy(zzmz.data, zzmz.zzay(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zzbcp.zzaqu) {
                this.zzazw.zza(zzmz);
                this.zzbcp = this.zzbcp.zzht();
            }
        }
    }

    private final void zzed(long j) {
        while (j >= this.zzbcp.zzaqu) {
            this.zzazw.zza(this.zzbcp.zzbcj);
            this.zzbcp = this.zzbcp.zzht();
        }
    }

    public final void zza(zzme zzme) {
        this.zzbcw = zzme;
    }

    public final void zze(zzgo zzgo) {
        zzgo zzgo2 = zzgo == null ? null : zzgo;
        boolean zzg = this.zzbcm.zzg(zzgo2);
        this.zzbct = zzgo;
        this.zzbcs = false;
        zzme zzme = this.zzbcw;
        if (zzme != null && zzg) {
            zzme.zzf(zzgo2);
        }
    }

    public final int zza(zziv zziv, int i, boolean z) throws IOException, InterruptedException {
        if (!zzhv()) {
            int zzaa = zziv.zzaa(i);
            if (zzaa != -1) {
                return zzaa;
            }
            throw new EOFException();
        }
        try {
            int zzat = zzat(i);
            zzmz zzmz = this.zzbcq.zzbcj;
            int read = zziv.read(zzmz.data, zzmz.zzay(this.zzbcv), zzat);
            if (read != -1) {
                this.zzbcv += read;
                this.zzbcu += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            zzhw();
        }
    }

    public final void zza(zzoc zzoc, int i) {
        if (!zzhv()) {
            zzoc.zzbh(i);
            return;
        }
        while (i > 0) {
            int zzat = zzat(i);
            zzmz zzmz = this.zzbcq.zzbcj;
            zzoc.zze(zzmz.data, zzmz.zzay(this.zzbcv), zzat);
            this.zzbcv += zzat;
            this.zzbcu += (long) zzat;
            i -= zzat;
        }
        zzhw();
    }

    public final void zza(long j, int i, int i2, int i3, zzjg zzjg) {
        if (!zzhv()) {
            long j2 = j;
            this.zzbcm.zzec(j);
            return;
        }
        long j3 = j;
        try {
            this.zzbcm.zza(j, i, this.zzbcu - ((long) i2), i2, zzjg);
        } finally {
            zzhw();
        }
    }

    private final boolean zzhv() {
        return this.zzbco.compareAndSet(0, 1);
    }

    private final void zzhw() {
        if (!this.zzbco.compareAndSet(1, 0)) {
            zzhn();
        }
    }

    private final void zzhn() {
        this.zzbcm.zzhn();
        zzmb zzmb = this.zzbcp;
        if (zzmb.zzbci) {
            int i = ((int) (this.zzbcq.zzbch - zzmb.zzbch)) / this.zzbcl;
            zzmz[] zzmzArr = new zzmz[((this.zzbcq.zzbci ? 1 : 0) + i)];
            for (int i2 = 0; i2 < zzmzArr.length; i2++) {
                zzmzArr[i2] = zzmb.zzbcj;
                zzmb = zzmb.zzht();
            }
            this.zzazw.zza(zzmzArr);
        }
        this.zzbcp = new zzmb(0, this.zzbcl);
        this.zzbcq = this.zzbcp;
        this.zzbcu = 0;
        this.zzbcv = this.zzbcl;
        this.zzazw.zzm();
    }

    private final int zzat(int i) {
        if (this.zzbcv == this.zzbcl) {
            this.zzbcv = 0;
            if (this.zzbcq.zzbci) {
                this.zzbcq = this.zzbcq.zzbck;
            }
            zzmb zzmb = this.zzbcq;
            zzmz zzhz = this.zzazw.zzhz();
            zzmb zzmb2 = new zzmb(this.zzbcq.zzaqu, this.zzbcl);
            zzmb.zzbcj = zzhz;
            zzmb.zzbck = zzmb2;
            zzmb.zzbci = true;
        }
        return Math.min(i, this.zzbcl - this.zzbcv);
    }
}
