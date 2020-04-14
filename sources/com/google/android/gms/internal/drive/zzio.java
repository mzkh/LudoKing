package com.google.android.gms.internal.drive;

import java.io.IOException;

public final class zzio {
    private final byte[] buffer;
    private final int zzmn;
    private final int zzmo;
    private int zzmp;
    private int zzmq;
    private int zzmr;
    private int zzms = Integer.MAX_VALUE;
    private int zzmt = 64;
    private int zzmu = 67108864;

    private zzio(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzmn = i;
        int i3 = i2 + i;
        this.zzmp = i3;
        this.zzmo = i3;
        this.zzmq = i;
    }

    public static zzio zza(byte[] bArr, int i, int i2) {
        return new zzio(bArr, 0, i2);
    }

    private final byte zzbg() throws IOException {
        int i = this.zzmq;
        if (i != this.zzmp) {
            byte[] bArr = this.buffer;
            this.zzmq = i + 1;
            return bArr[i];
        }
        throw zziw.zzbk();
    }

    private final void zzl(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzmq;
            int i3 = i2 + i;
            int i4 = this.zzms;
            if (i3 > i4) {
                zzl(i4 - i2);
                throw zziw.zzbk();
            } else if (i <= this.zzmp - i2) {
                this.zzmq = i2 + i;
            } else {
                throw zziw.zzbk();
            }
        } else {
            throw zziw.zzbl();
        }
    }

    public final int getPosition() {
        return this.zzmq - this.zzmn;
    }

    public final String readString() throws IOException {
        int zzbe = zzbe();
        if (zzbe >= 0) {
            int i = this.zzmp;
            int i2 = this.zzmq;
            if (zzbe <= i - i2) {
                String str = new String(this.buffer, i2, zzbe, zziv.UTF_8);
                this.zzmq += zzbe;
                return str;
            }
            throw zziw.zzbk();
        }
        throw zziw.zzbl();
    }

    public final byte[] zza(int i, int i2) {
        if (i2 == 0) {
            return zzja.zzns;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzmn + i, bArr, 0, i2);
        return bArr;
    }

    public final int zzbd() throws IOException {
        if (this.zzmq == this.zzmp) {
            this.zzmr = 0;
            return 0;
        }
        this.zzmr = zzbe();
        int i = this.zzmr;
        if (i != 0) {
            return i;
        }
        throw new zziw("Protocol message contained an invalid tag (zero).");
    }

    public final int zzbe() throws IOException {
        byte b;
        int i;
        byte zzbg = zzbg();
        if (zzbg >= 0) {
            return zzbg;
        }
        byte b2 = zzbg & Byte.MAX_VALUE;
        byte zzbg2 = zzbg();
        if (zzbg2 >= 0) {
            i = zzbg2 << 7;
        } else {
            b2 |= (zzbg2 & Byte.MAX_VALUE) << 7;
            byte zzbg3 = zzbg();
            if (zzbg3 >= 0) {
                i = zzbg3 << 14;
            } else {
                b2 |= (zzbg3 & Byte.MAX_VALUE) << 14;
                byte zzbg4 = zzbg();
                if (zzbg4 >= 0) {
                    i = zzbg4 << 21;
                } else {
                    byte b3 = b2 | ((zzbg4 & Byte.MAX_VALUE) << 21);
                    byte zzbg5 = zzbg();
                    b = b3 | (zzbg5 << 28);
                    if (zzbg5 < 0) {
                        for (int i2 = 0; i2 < 5; i2++) {
                            if (zzbg() >= 0) {
                                return b;
                            }
                        }
                        throw zziw.zzbm();
                    }
                    return b;
                }
            }
        }
        b = b2 | i;
        return b;
    }

    public final long zzbf() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbg = zzbg();
            j |= ((long) (zzbg & Byte.MAX_VALUE)) << i;
            if ((zzbg & 128) == 0) {
                return j;
            }
        }
        throw zziw.zzbm();
    }

    public final void zzj(int i) throws zziw {
        if (this.zzmr != i) {
            throw new zziw("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzk(int i) throws IOException {
        int zzbd;
        int i2 = i & 7;
        if (i2 == 0) {
            zzbe();
            return true;
        } else if (i2 == 1) {
            zzbg();
            zzbg();
            zzbg();
            zzbg();
            zzbg();
            zzbg();
            zzbg();
            zzbg();
            return true;
        } else if (i2 == 2) {
            zzl(zzbe());
            return true;
        } else if (i2 == 3) {
            do {
                zzbd = zzbd();
                if (zzbd == 0) {
                    break;
                }
            } while (zzk(zzbd));
            zzj(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzbg();
                zzbg();
                zzbg();
                zzbg();
                return true;
            }
            throw new zziw("Protocol message tag had invalid wire type.");
        }
    }
}
