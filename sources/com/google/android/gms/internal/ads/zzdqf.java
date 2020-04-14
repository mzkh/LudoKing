package com.google.android.gms.internal.ads;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public abstract class zzdqf extends zzdpn {
    private static final Logger logger = Logger.getLogger(zzdqf.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzhgx = zzdtt.zzbca();
    zzdqg zzhgy = this;

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zza extends zzb {
        private final ByteBuffer zzhgz;
        private int zzhha;

        zza(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzhgz = byteBuffer;
            this.zzhha = byteBuffer.position();
        }

        public final void flush() {
            this.zzhgz.position(this.zzhha + zzayx());
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static class zzb extends zzdqf {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i;
                    this.position = i;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final void zzz(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzz(i, 0);
            zzfz(i2);
        }

        public final void zzab(int i, int i2) throws IOException {
            zzz(i, 0);
            zzga(i2);
        }

        public final void zzad(int i, int i2) throws IOException {
            zzz(i, 5);
            zzgc(i2);
        }

        public final void zzg(int i, long j) throws IOException {
            zzz(i, 0);
            zzfa(j);
        }

        public final void zzi(int i, long j) throws IOException {
            zzz(i, 1);
            zzfc(j);
        }

        public final void zzg(int i, boolean z) throws IOException {
            zzz(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzg(int i, String str) throws IOException {
            zzz(i, 2);
            zzhi(str);
        }

        public final void zza(int i, zzdpm zzdpm) throws IOException {
            zzz(i, 2);
            zzcz(zzdpm);
        }

        public final void zzcz(zzdpm zzdpm) throws IOException {
            zzga(zzdpm.size());
            zzdpm.zza((zzdpn) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        public final void zza(int i, zzdsg zzdsg) throws IOException {
            zzz(i, 2);
            zzj(zzdsg);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzdsg zzdsg, zzdsv zzdsv) throws IOException {
            zzz(i, 2);
            zzdpf zzdpf = (zzdpf) zzdsg;
            int zzaxh = zzdpf.zzaxh();
            if (zzaxh == -1) {
                zzaxh = zzdsv.zzau(zzdpf);
                zzdpf.zzfi(zzaxh);
            }
            zzga(zzaxh);
            zzdsv.zza(zzdsg, this.zzhgy);
        }

        public final void zzb(int i, zzdsg zzdsg) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, zzdsg);
            zzz(1, 4);
        }

        public final void zzb(int i, zzdpm zzdpm) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, zzdpm);
            zzz(1, 4);
        }

        public final void zzj(zzdsg zzdsg) throws IOException {
            zzga(zzdsg.zzazu());
            zzdsg.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzdsg zzdsg, zzdsv zzdsv) throws IOException {
            zzdpf zzdpf = (zzdpf) zzdsg;
            int zzaxh = zzdpf.zzaxh();
            if (zzaxh == -1) {
                zzaxh = zzdsv.zzau(zzdpf);
                zzdpf.zzfi(zzaxh);
            }
            zzga(zzaxh);
            zzdsv.zza(zzdsg, this.zzhgy);
        }

        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfa((long) i);
            }
        }

        public final void zzga(int i) throws IOException {
            if (!zzdqf.zzhgx || zzdpj.zzaxl() || zzayu() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzdtt.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzdtt.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzdtt.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzdtt.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzdtt.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzdtt.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzdtt.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzdtt.zza(bArr10, (long) i14, (byte) (i12 | 128));
                int i15 = i12 >>> 7;
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzdtt.zza(bArr11, (long) i16, (byte) i15);
            }
        }

        public final void zzgc(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzfa(long j) throws IOException {
            if (!zzdqf.zzhgx || zzayu() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzdtt.zza(bArr3, (long) i3, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzdtt.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzfc(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzhi(String str) throws IOException {
            int i = this.position;
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    this.position = i + zzgf2;
                    int zza = zzdtw.zza(str, this.buffer, this.position, zzayu());
                    this.position = i;
                    zzga((zza - i) - zzgf2);
                    this.position = zza;
                    return;
                }
                zzga(zzdtw.zza(str));
                this.position = zzdtw.zza(str, this.buffer, this.position, zzayu());
            } catch (zzdtz e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd((Throwable) e2);
            }
        }

        public final int zzayu() {
            return this.limit - this.position;
        }

        public final int zzayx() {
            return this.position - this.offset;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zzc extends zzdqf {
        private final ByteBuffer zzakm;
        private final int zzhha;
        private final ByteBuffer zzhhb;

        zzc(ByteBuffer byteBuffer) {
            super();
            this.zzhhb = byteBuffer;
            this.zzakm = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzhha = byteBuffer.position();
        }

        public final void zzz(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzz(i, 0);
            zzfz(i2);
        }

        public final void zzab(int i, int i2) throws IOException {
            zzz(i, 0);
            zzga(i2);
        }

        public final void zzad(int i, int i2) throws IOException {
            zzz(i, 5);
            zzgc(i2);
        }

        public final void zzg(int i, long j) throws IOException {
            zzz(i, 0);
            zzfa(j);
        }

        public final void zzi(int i, long j) throws IOException {
            zzz(i, 1);
            zzfc(j);
        }

        public final void zzg(int i, boolean z) throws IOException {
            zzz(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzg(int i, String str) throws IOException {
            zzz(i, 2);
            zzhi(str);
        }

        public final void zza(int i, zzdpm zzdpm) throws IOException {
            zzz(i, 2);
            zzcz(zzdpm);
        }

        public final void zza(int i, zzdsg zzdsg) throws IOException {
            zzz(i, 2);
            zzj(zzdsg);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzdsg zzdsg, zzdsv zzdsv) throws IOException {
            zzz(i, 2);
            zza(zzdsg, zzdsv);
        }

        public final void zzb(int i, zzdsg zzdsg) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, zzdsg);
            zzz(1, 4);
        }

        public final void zzb(int i, zzdpm zzdpm) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, zzdpm);
            zzz(1, 4);
        }

        public final void zzj(zzdsg zzdsg) throws IOException {
            zzga(zzdsg.zzazu());
            zzdsg.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzdsg zzdsg, zzdsv zzdsv) throws IOException {
            zzdpf zzdpf = (zzdpf) zzdsg;
            int zzaxh = zzdpf.zzaxh();
            if (zzaxh == -1) {
                zzaxh = zzdsv.zzau(zzdpf);
                zzdpf.zzfi(zzaxh);
            }
            zzga(zzaxh);
            zzdsv.zza(zzdsg, this.zzhgy);
        }

        public final void zzd(byte b) throws IOException {
            try {
                this.zzakm.put(b);
            } catch (BufferOverflowException e) {
                throw new zzd((Throwable) e);
            }
        }

        public final void zzcz(zzdpm zzdpm) throws IOException {
            zzga(zzdpm.size());
            zzdpm.zza((zzdpn) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfa((long) i);
            }
        }

        public final void zzga(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzakm.put((byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                i >>>= 7;
            }
            try {
                this.zzakm.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzd((Throwable) e);
            }
        }

        public final void zzgc(int i) throws IOException {
            try {
                this.zzakm.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzd((Throwable) e);
            }
        }

        public final void zzfa(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzakm.put((byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                j >>>= 7;
            }
            try {
                this.zzakm.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzd((Throwable) e);
            }
        }

        public final void zzfc(long j) throws IOException {
            try {
                this.zzakm.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzd((Throwable) e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzakm.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzd((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzd((Throwable) e2);
            }
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzhi(String str) throws IOException {
            int position = this.zzakm.position();
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    int position2 = this.zzakm.position() + zzgf2;
                    this.zzakm.position(position2);
                    zzhk(str);
                    int position3 = this.zzakm.position();
                    this.zzakm.position(position);
                    zzga(position3 - position2);
                    this.zzakm.position(position3);
                    return;
                }
                zzga(zzdtw.zza(str));
                zzhk(str);
            } catch (zzdtz e) {
                this.zzakm.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzd((Throwable) e2);
            }
        }

        public final void flush() {
            this.zzhhb.position(this.zzakm.position());
        }

        public final int zzayu() {
            return this.zzakm.remaining();
        }

        private final void zzhk(String str) throws IOException {
            try {
                zzdtw.zza(str, this.zzakm);
            } catch (IndexOutOfBoundsException e) {
                throw new zzd((Throwable) e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzd(String str) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzd(String str, Throwable th) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zze extends zzdqf {
        private final ByteBuffer zzakm;
        private long zzamq = this.zzhhd;
        private final ByteBuffer zzhhb;
        private final long zzhhc;
        private final long zzhhd;
        private final long zzhhe;
        private final long zzhhf = (this.zzhhe - 10);

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzhhb = byteBuffer;
            this.zzakm = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzhhc = zzdtt.zzn(byteBuffer);
            this.zzhhd = this.zzhhc + ((long) byteBuffer.position());
            this.zzhhe = this.zzhhc + ((long) byteBuffer.limit());
        }

        public final void zzz(int i, int i2) throws IOException {
            zzga((i << 3) | i2);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzz(i, 0);
            zzfz(i2);
        }

        public final void zzab(int i, int i2) throws IOException {
            zzz(i, 0);
            zzga(i2);
        }

        public final void zzad(int i, int i2) throws IOException {
            zzz(i, 5);
            zzgc(i2);
        }

        public final void zzg(int i, long j) throws IOException {
            zzz(i, 0);
            zzfa(j);
        }

        public final void zzi(int i, long j) throws IOException {
            zzz(i, 1);
            zzfc(j);
        }

        public final void zzg(int i, boolean z) throws IOException {
            zzz(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzg(int i, String str) throws IOException {
            zzz(i, 2);
            zzhi(str);
        }

        public final void zza(int i, zzdpm zzdpm) throws IOException {
            zzz(i, 2);
            zzcz(zzdpm);
        }

        public final void zza(int i, zzdsg zzdsg) throws IOException {
            zzz(i, 2);
            zzj(zzdsg);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzdsg zzdsg, zzdsv zzdsv) throws IOException {
            zzz(i, 2);
            zza(zzdsg, zzdsv);
        }

        public final void zzb(int i, zzdsg zzdsg) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, zzdsg);
            zzz(1, 4);
        }

        public final void zzb(int i, zzdpm zzdpm) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, zzdpm);
            zzz(1, 4);
        }

        public final void zzj(zzdsg zzdsg) throws IOException {
            zzga(zzdsg.zzazu());
            zzdsg.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzdsg zzdsg, zzdsv zzdsv) throws IOException {
            zzdpf zzdpf = (zzdpf) zzdsg;
            int zzaxh = zzdpf.zzaxh();
            if (zzaxh == -1) {
                zzaxh = zzdsv.zzau(zzdpf);
                zzdpf.zzfi(zzaxh);
            }
            zzga(zzaxh);
            zzdsv.zza(zzdsg, this.zzhgy);
        }

        public final void zzd(byte b) throws IOException {
            long j = this.zzamq;
            if (j < this.zzhhe) {
                this.zzamq = 1 + j;
                zzdtt.zza(j, b);
                return;
            }
            throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.zzhhe), Integer.valueOf(1)}));
        }

        public final void zzcz(zzdpm zzdpm) throws IOException {
            zzga(zzdpm.size());
            zzdpm.zza((zzdpn) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzga(i2);
            write(bArr, 0, i2);
        }

        public final void zzfz(int i) throws IOException {
            if (i >= 0) {
                zzga(i);
            } else {
                zzfa((long) i);
            }
        }

        public final void zzga(int i) throws IOException {
            if (this.zzamq <= this.zzhhf) {
                while ((i & -128) != 0) {
                    long j = this.zzamq;
                    this.zzamq = j + 1;
                    zzdtt.zza(j, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzamq;
                this.zzamq = 1 + j2;
                zzdtt.zza(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.zzamq;
                if (j3 >= this.zzhhe) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j3), Long.valueOf(this.zzhhe), Integer.valueOf(1)}));
                } else if ((i & -128) == 0) {
                    this.zzamq = 1 + j3;
                    zzdtt.zza(j3, (byte) i);
                    return;
                } else {
                    this.zzamq = j3 + 1;
                    zzdtt.zza(j3, (byte) ((i & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    i >>>= 7;
                }
            }
        }

        public final void zzgc(int i) throws IOException {
            this.zzakm.putInt((int) (this.zzamq - this.zzhhc), i);
            this.zzamq += 4;
        }

        public final void zzfa(long j) throws IOException {
            if (this.zzamq <= this.zzhhf) {
                while ((j & -128) != 0) {
                    long j2 = this.zzamq;
                    this.zzamq = j2 + 1;
                    zzdtt.zza(j2, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzamq;
                this.zzamq = 1 + j3;
                zzdtt.zza(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.zzamq;
                if (j4 >= this.zzhhe) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j4), Long.valueOf(this.zzhhe), Integer.valueOf(1)}));
                } else if ((j & -128) == 0) {
                    this.zzamq = 1 + j4;
                    zzdtt.zza(j4, (byte) ((int) j));
                    return;
                } else {
                    this.zzamq = j4 + 1;
                    zzdtt.zza(j4, (byte) ((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128));
                    j >>>= 7;
                }
            }
        }

        public final void zzfc(long j) throws IOException {
            this.zzakm.putLong((int) (this.zzamq - this.zzhhc), j);
            this.zzamq += 8;
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.zzhhe - j;
                long j3 = this.zzamq;
                if (j2 >= j3) {
                    zzdtt.zza(bArr, (long) i, j3, j);
                    this.zzamq += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzamq), Long.valueOf(this.zzhhe), Integer.valueOf(i2)}));
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzhi(String str) throws IOException {
            long j = this.zzamq;
            try {
                int zzgf = zzgf(str.length() * 3);
                int zzgf2 = zzgf(str.length());
                if (zzgf2 == zzgf) {
                    int i = ((int) (this.zzamq - this.zzhhc)) + zzgf2;
                    this.zzakm.position(i);
                    zzdtw.zza(str, this.zzakm);
                    int position = this.zzakm.position() - i;
                    zzga(position);
                    this.zzamq += (long) position;
                    return;
                }
                int zza = zzdtw.zza(str);
                zzga(zza);
                zzfj(this.zzamq);
                zzdtw.zza(str, this.zzakm);
                this.zzamq += (long) zza;
            } catch (zzdtz e) {
                this.zzamq = j;
                zzfj(this.zzamq);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzd((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzd((Throwable) e3);
            }
        }

        public final void flush() {
            this.zzhhb.position((int) (this.zzamq - this.zzhhc));
        }

        public final int zzayu() {
            return (int) (this.zzhhe - this.zzamq);
        }

        private final void zzfj(long j) {
            this.zzakm.position((int) (j - this.zzhhc));
        }
    }

    public static zzdqf zzaa(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzbi(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzfe(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int zzfg(long j) {
        return 8;
    }

    public static int zzfh(long j) {
        return 8;
    }

    private static long zzfi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzgf(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzgh(int i) {
        return 4;
    }

    public static int zzgi(int i) {
        return 4;
    }

    private static int zzgk(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, zzdpm zzdpm) throws IOException;

    public abstract void zza(int i, zzdsg zzdsg) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zzdsg zzdsg, zzdsv zzdsv) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(zzdsg zzdsg, zzdsv zzdsv) throws IOException;

    public abstract void zzaa(int i, int i2) throws IOException;

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzad(int i, int i2) throws IOException;

    public abstract int zzayu();

    public abstract void zzb(int i, zzdpm zzdpm) throws IOException;

    public abstract void zzb(int i, zzdsg zzdsg) throws IOException;

    public abstract void zzcz(zzdpm zzdpm) throws IOException;

    public abstract void zzd(byte b) throws IOException;

    public abstract void zzfa(long j) throws IOException;

    public abstract void zzfc(long j) throws IOException;

    public abstract void zzfz(int i) throws IOException;

    public abstract void zzg(int i, long j) throws IOException;

    public abstract void zzg(int i, String str) throws IOException;

    public abstract void zzg(int i, boolean z) throws IOException;

    public abstract void zzga(int i) throws IOException;

    public abstract void zzgc(int i) throws IOException;

    public abstract void zzhi(String str) throws IOException;

    public abstract void zzi(int i, long j) throws IOException;

    public abstract void zzj(zzdsg zzdsg) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzz(int i, int i2) throws IOException;

    public static zzdqf zzm(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zza(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zzdtt.zzbcb()) {
            return new zze(byteBuffer);
        } else {
            return new zzc(byteBuffer);
        }
    }

    private zzdqf() {
    }

    public final void zzac(int i, int i2) throws IOException {
        zzab(i, zzgk(i2));
    }

    public final void zzh(int i, long j) throws IOException {
        zzg(i, zzfi(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzad(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, double d) throws IOException {
        zzi(i, Double.doubleToRawLongBits(d));
    }

    public final void zzgb(int i) throws IOException {
        zzga(zzgk(i));
    }

    public final void zzfb(long j) throws IOException {
        zzfa(zzfi(j));
    }

    public final void zzf(float f) throws IOException {
        zzgc(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) throws IOException {
        zzfc(Double.doubleToRawLongBits(d));
    }

    public final void zzbh(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public static int zzae(int i, int i2) {
        return zzgd(i) + zzge(i2);
    }

    public static int zzaf(int i, int i2) {
        return zzgd(i) + zzgf(i2);
    }

    public static int zzag(int i, int i2) {
        return zzgd(i) + zzgf(zzgk(i2));
    }

    public static int zzah(int i, int i2) {
        return zzgd(i) + 4;
    }

    public static int zzai(int i, int i2) {
        return zzgd(i) + 4;
    }

    public static int zzj(int i, long j) {
        return zzgd(i) + zzfe(j);
    }

    public static int zzk(int i, long j) {
        return zzgd(i) + zzfe(j);
    }

    public static int zzl(int i, long j) {
        return zzgd(i) + zzfe(zzfi(j));
    }

    public static int zzm(int i, long j) {
        return zzgd(i) + 8;
    }

    public static int zzn(int i, long j) {
        return zzgd(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzgd(i) + 4;
    }

    public static int zzc(int i, double d) {
        return zzgd(i) + 8;
    }

    public static int zzh(int i, boolean z) {
        return zzgd(i) + 1;
    }

    public static int zzaj(int i, int i2) {
        return zzgd(i) + zzge(i2);
    }

    public static int zzh(int i, String str) {
        return zzgd(i) + zzhj(str);
    }

    public static int zzc(int i, zzdpm zzdpm) {
        int zzgd = zzgd(i);
        int size = zzdpm.size();
        return zzgd + zzgf(size) + size;
    }

    public static int zza(int i, zzdrl zzdrl) {
        int zzgd = zzgd(i);
        int zzazu = zzdrl.zzazu();
        return zzgd + zzgf(zzazu) + zzazu;
    }

    public static int zzc(int i, zzdsg zzdsg) {
        return zzgd(i) + zzk(zzdsg);
    }

    static int zzb(int i, zzdsg zzdsg, zzdsv zzdsv) {
        return zzgd(i) + zzb(zzdsg, zzdsv);
    }

    public static int zzd(int i, zzdsg zzdsg) {
        return (zzgd(1) << 1) + zzaf(2, i) + zzc(3, zzdsg);
    }

    public static int zzd(int i, zzdpm zzdpm) {
        return (zzgd(1) << 1) + zzaf(2, i) + zzc(3, zzdpm);
    }

    public static int zzb(int i, zzdrl zzdrl) {
        return (zzgd(1) << 1) + zzaf(2, i) + zza(3, zzdrl);
    }

    public static int zzgd(int i) {
        return zzgf(i << 3);
    }

    public static int zzge(int i) {
        if (i >= 0) {
            return zzgf(i);
        }
        return 10;
    }

    public static int zzgg(int i) {
        return zzgf(zzgk(i));
    }

    public static int zzfd(long j) {
        return zzfe(j);
    }

    public static int zzff(long j) {
        return zzfe(zzfi(j));
    }

    public static int zzgj(int i) {
        return zzge(i);
    }

    public static int zzhj(String str) {
        int i;
        try {
            i = zzdtw.zza(str);
        } catch (zzdtz unused) {
            i = str.getBytes(zzdqx.UTF_8).length;
        }
        return zzgf(i) + i;
    }

    public static int zza(zzdrl zzdrl) {
        int zzazu = zzdrl.zzazu();
        return zzgf(zzazu) + zzazu;
    }

    public static int zzda(zzdpm zzdpm) {
        int size = zzdpm.size();
        return zzgf(size) + size;
    }

    public static int zzab(byte[] bArr) {
        int length = bArr.length;
        return zzgf(length) + length;
    }

    public static int zzk(zzdsg zzdsg) {
        int zzazu = zzdsg.zzazu();
        return zzgf(zzazu) + zzazu;
    }

    static int zzb(zzdsg zzdsg, zzdsv zzdsv) {
        zzdpf zzdpf = (zzdpf) zzdsg;
        int zzaxh = zzdpf.zzaxh();
        if (zzaxh == -1) {
            zzaxh = zzdsv.zzau(zzdpf);
            zzdpf.zzfi(zzaxh);
        }
        return zzgf(zzaxh) + zzaxh;
    }

    public final void zzayv() {
        if (zzayu() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzdtz zzdtz) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzdtz);
        byte[] bytes = str.getBytes(zzdqx.UTF_8);
        try {
            zzga(bytes.length);
            zzi(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzd((Throwable) e);
        } catch (zzd e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzdsg zzdsg, zzdsv zzdsv) {
        int zzgd = zzgd(i) << 1;
        zzdpf zzdpf = (zzdpf) zzdsg;
        int zzaxh = zzdpf.zzaxh();
        if (zzaxh == -1) {
            zzaxh = zzdsv.zzau(zzdpf);
            zzdpf.zzfi(zzaxh);
        }
        return zzgd + zzaxh;
    }

    @Deprecated
    public static int zzl(zzdsg zzdsg) {
        return zzdsg.zzazu();
    }

    @Deprecated
    public static int zzgl(int i) {
        return zzgf(i);
    }
}
