package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqa extends zzdpy {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzhgo;
    private int zzhgp;
    private int zzhgq;
    private int zzhgr;
    private int zzhgs;

    private zzdqa(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzhgs = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzhgq = this.pos;
        this.zzhgo = z;
    }

    public final int zzaxu() throws IOException {
        if (zzayk()) {
            this.zzhgr = 0;
            return 0;
        }
        this.zzhgr = zzaym();
        int i = this.zzhgr;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzdrg.zzbaf();
    }

    public final void zzfp(int i) throws zzdrg {
        if (this.zzhgr != i) {
            throw zzdrg.zzbag();
        }
    }

    public final boolean zzfq(int i) throws IOException {
        int zzaxu;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzdrg.zzbae();
            }
            while (i3 < 10) {
                if (zzayr() < 0) {
                    i3++;
                }
            }
            throw zzdrg.zzbae();
            return true;
        } else if (i2 == 1) {
            zzfu(8);
            return true;
        } else if (i2 == 2) {
            zzfu(zzaym());
            return true;
        } else if (i2 == 3) {
            do {
                zzaxu = zzaxu();
                if (zzaxu == 0) {
                    break;
                }
            } while (zzfq(zzaxu));
            zzfp(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzfu(4);
                return true;
            }
            throw zzdrg.zzbah();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzayp());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzayo());
    }

    public final long zzaxv() throws IOException {
        return zzayn();
    }

    public final long zzaxw() throws IOException {
        return zzayn();
    }

    public final int zzaxx() throws IOException {
        return zzaym();
    }

    public final long zzaxy() throws IOException {
        return zzayp();
    }

    public final int zzaxz() throws IOException {
        return zzayo();
    }

    public final boolean zzaya() throws IOException {
        return zzayn() != 0;
    }

    public final String readString() throws IOException {
        int zzaym = zzaym();
        if (zzaym > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzaym <= i - i2) {
                String str = new String(this.buffer, i2, zzaym, zzdqx.UTF_8);
                this.pos += zzaym;
                return str;
            }
        }
        if (zzaym == 0) {
            return "";
        }
        if (zzaym < 0) {
            throw zzdrg.zzbad();
        }
        throw zzdrg.zzbac();
    }

    public final String zzayb() throws IOException {
        int zzaym = zzaym();
        if (zzaym > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzaym <= i - i2) {
                String zzn = zzdtw.zzn(this.buffer, i2, zzaym);
                this.pos += zzaym;
                return zzn;
            }
        }
        if (zzaym == 0) {
            return "";
        }
        if (zzaym <= 0) {
            throw zzdrg.zzbad();
        }
        throw zzdrg.zzbac();
    }

    public final zzdpm zzayc() throws IOException {
        byte[] bArr;
        int zzaym = zzaym();
        if (zzaym > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzaym <= i - i2) {
                zzdpm zzh = zzdpm.zzh(this.buffer, i2, zzaym);
                this.pos += zzaym;
                return zzh;
            }
        }
        if (zzaym == 0) {
            return zzdpm.zzhgb;
        }
        if (zzaym > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzaym <= i3 - i4) {
                this.pos = zzaym + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzdpm.zzz(bArr);
            }
        }
        if (zzaym > 0) {
            throw zzdrg.zzbac();
        } else if (zzaym == 0) {
            bArr = zzdqx.zzhlj;
            return zzdpm.zzz(bArr);
        } else {
            throw zzdrg.zzbad();
        }
    }

    public final int zzayd() throws IOException {
        return zzaym();
    }

    public final int zzaye() throws IOException {
        return zzaym();
    }

    public final int zzayf() throws IOException {
        return zzayo();
    }

    public final long zzayg() throws IOException {
        return zzayp();
    }

    public final int zzayh() throws IOException {
        return zzft(zzaym());
    }

    public final long zzayi() throws IOException {
        return zzez(zzayn());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzaym() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzayj()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqa.zzaym():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzayn() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b5
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b5
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0026
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            r3 = r2
            goto L_0x00b2
        L_0x0026:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0037
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto L_0x00b2
        L_0x0037:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0045
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0045:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005c
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0058:
            long r1 = r1 ^ r3
            r3 = r1
        L_0x005a:
            r1 = r0
            goto L_0x00b2
        L_0x005c:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006e:
            long r3 = r3 ^ r5
            goto L_0x00b2
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0058
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006e
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x005a
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b5
        L_0x00b2:
            r11.pos = r1
            return r3
        L_0x00b5:
            long r0 = r11.zzayj()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqa.zzayn():long");
    }

    /* access modifiers changed from: 0000 */
    public final long zzayj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzayr = zzayr();
            j |= ((long) (zzayr & Byte.MAX_VALUE)) << i;
            if ((zzayr & 128) == 0) {
                return j;
            }
        }
        throw zzdrg.zzbae();
    }

    private final int zzayo() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzdrg.zzbac();
    }

    private final long zzayp() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzdrg.zzbac();
    }

    public final int zzfr(int i) throws zzdrg {
        if (i >= 0) {
            int zzayl = i + zzayl();
            int i2 = this.zzhgs;
            if (zzayl <= i2) {
                this.zzhgs = zzayl;
                zzayq();
                return i2;
            }
            throw zzdrg.zzbac();
        }
        throw zzdrg.zzbad();
    }

    private final void zzayq() {
        this.limit += this.zzhgp;
        int i = this.limit;
        int i2 = i - this.zzhgq;
        int i3 = this.zzhgs;
        if (i2 > i3) {
            this.zzhgp = i2 - i3;
            this.limit = i - this.zzhgp;
            return;
        }
        this.zzhgp = 0;
    }

    public final void zzfs(int i) {
        this.zzhgs = i;
        zzayq();
    }

    public final boolean zzayk() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzayl() {
        return this.pos - this.zzhgq;
    }

    private final byte zzayr() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzdrg.zzbac();
    }

    private final void zzfu(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzdrg.zzbad();
        }
        throw zzdrg.zzbac();
    }
}
