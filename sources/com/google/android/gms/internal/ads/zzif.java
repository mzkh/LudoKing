package com.google.android.gms.internal.ads;

import com.google.android.gms.games.GamesStatusCodes;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzif {
    private final int zzafn;
    private float zzaga;
    private float zzagb;
    private final int zzala;
    private final int zzalb;
    private final int zzalc;
    private final int zzald = (this.zzalc * 2);
    private final short[] zzale;
    private int zzalf;
    private short[] zzalg;
    private int zzalh;
    private short[] zzali;
    private int zzalj;
    private short[] zzalk;
    private int zzall;
    private int zzalm;
    private int zzaln;
    private int zzalo;
    private int zzalp;
    private int zzalq;
    private int zzalr;
    private int zzals;
    private int zzalt;
    private int zzalu;

    public zzif(int i, int i2) {
        this.zzafn = i;
        this.zzala = i2;
        this.zzalb = i / 400;
        this.zzalc = i / 65;
        int i3 = this.zzald;
        this.zzale = new short[i3];
        this.zzalf = i3;
        this.zzalg = new short[(i3 * i2)];
        this.zzalh = i3;
        this.zzali = new short[(i3 * i2)];
        this.zzalj = i3;
        this.zzalk = new short[(i3 * i2)];
        this.zzall = 0;
        this.zzalm = 0;
        this.zzalr = 0;
        this.zzaga = 1.0f;
        this.zzagb = 1.0f;
    }

    public final void setSpeed(float f) {
        this.zzaga = f;
    }

    public final void zzc(float f) {
        this.zzagb = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzala;
        int i2 = remaining / i;
        int i3 = (i * i2) << 1;
        zzu(i2);
        shortBuffer.get(this.zzalg, this.zzaln * this.zzala, i3 / 2);
        this.zzaln += i2;
        zzfs();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzala, this.zzalo);
        shortBuffer.put(this.zzali, 0, this.zzala * min);
        this.zzalo -= min;
        short[] sArr = this.zzali;
        int i = this.zzala;
        System.arraycopy(sArr, min * i, sArr, 0, this.zzalo * i);
    }

    public final void zzev() {
        int i;
        int i2 = this.zzaln;
        float f = this.zzaga;
        float f2 = this.zzagb;
        int i3 = this.zzalo + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzalp)) / f2) + 0.5f));
        zzu((this.zzald * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzald;
            int i5 = i * 2;
            int i6 = this.zzala;
            if (i4 >= i5 * i6) {
                break;
            }
            this.zzalg[(i6 * i2) + i4] = 0;
            i4++;
        }
        this.zzaln += i * 2;
        zzfs();
        if (this.zzalo > i3) {
            this.zzalo = i3;
        }
        this.zzaln = 0;
        this.zzalq = 0;
        this.zzalp = 0;
    }

    public final int zzfr() {
        return this.zzalo;
    }

    private final void zzt(int i) {
        int i2 = this.zzalo + i;
        int i3 = this.zzalh;
        if (i2 > i3) {
            this.zzalh = i3 + (i3 / 2) + i;
            this.zzali = Arrays.copyOf(this.zzali, this.zzalh * this.zzala);
        }
    }

    private final void zzu(int i) {
        int i2 = this.zzaln + i;
        int i3 = this.zzalf;
        if (i2 > i3) {
            this.zzalf = i3 + (i3 / 2) + i;
            this.zzalg = Arrays.copyOf(this.zzalg, this.zzalf * this.zzala);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzt(i2);
        int i3 = this.zzala;
        System.arraycopy(sArr, i * i3, this.zzali, this.zzalo * i3, i3 * i2);
        this.zzalo += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzald / i2;
        int i4 = this.zzala;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzale[i7] = (short) (i8 / i5);
        }
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzala;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.zzalt = i5 / i6;
        this.zzalu = i7 / i8;
        return i6;
    }

    private final void zzfs() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzalo;
        float f = this.zzaga / this.zzagb;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.zzaln;
            if (i9 >= this.zzald) {
                int i10 = 0;
                while (true) {
                    int i11 = this.zzalq;
                    if (i11 > 0) {
                        int min = Math.min(this.zzald, i11);
                        zza(this.zzalg, i10, min);
                        this.zzalq -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.zzalg;
                        int i12 = this.zzafn;
                        int i13 = i12 > 4000 ? i12 / GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND : 1;
                        if (this.zzala == i8 && i13 == i8) {
                            i4 = zza(sArr, i10, this.zzalb, this.zzalc);
                        } else {
                            zzb(sArr, i10, i13);
                            int zza = zza(this.zzale, 0, this.zzalb / i13, this.zzalc / i13);
                            if (i13 != i8) {
                                int i14 = zza * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.zzalb;
                                if (i16 >= i18) {
                                    i18 = i16;
                                }
                                int i19 = this.zzalc;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.zzala == i8) {
                                    i4 = zza(sArr, i10, i18, i17);
                                } else {
                                    zzb(sArr, i10, i8);
                                    i4 = zza(this.zzale, 0, i18, i17);
                                }
                            } else {
                                i4 = zza;
                            }
                        }
                        int i20 = this.zzalt;
                        int i21 = i20 != 0 && this.zzalr != 0 && this.zzalu <= i20 * 3 && (i20 << 1) > this.zzals * 3 ? this.zzalr : i4;
                        this.zzals = this.zzalt;
                        this.zzalr = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzalg;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i21) / (f - 1.0f));
                            } else {
                                this.zzalq = (int) ((((float) i21) * (2.0f - f)) / (f - 1.0f));
                                i6 = i21;
                            }
                            zzt(i6);
                            int i22 = i6;
                            int i23 = i21;
                            zza(i6, this.zzala, this.zzali, this.zzalo, sArr2, i10, sArr2, i10 + i21);
                            this.zzalo += i22;
                            i10 += i23 + i22;
                        } else {
                            int i24 = i21;
                            short[] sArr3 = this.zzalg;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i24) * f) / (1.0f - f));
                            } else {
                                this.zzalq = (int) ((((float) i24) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i5 = i24;
                            }
                            int i25 = i24 + i5;
                            zzt(i25);
                            int i26 = this.zzala;
                            System.arraycopy(sArr3, i10 * i26, this.zzali, this.zzalo * i26, i26 * i24);
                            int i27 = i25;
                            zza(i5, this.zzala, this.zzali, this.zzalo + i24, sArr3, i24 + i10, sArr3, i10);
                            this.zzalo += i27;
                            i10 += i5;
                        }
                    }
                    if (this.zzald + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i28 = this.zzaln - i10;
                short[] sArr4 = this.zzalg;
                int i29 = this.zzala;
                System.arraycopy(sArr4, i10 * i29, sArr4, 0, i29 * i28);
                this.zzaln = i28;
            }
        } else {
            zza(this.zzalg, 0, this.zzaln);
            this.zzaln = 0;
        }
        float f2 = this.zzagb;
        if (f2 != 1.0f && this.zzalo != i7) {
            int i30 = this.zzafn;
            int i31 = (int) (((float) i30) / f2);
            while (true) {
                if (i31 <= 16384 && i30 <= 16384) {
                    break;
                }
                i31 /= 2;
                i30 /= 2;
            }
            int i32 = this.zzalo - i7;
            int i33 = this.zzalp + i32;
            int i34 = this.zzalj;
            if (i33 > i34) {
                this.zzalj = i34 + (i34 / 2) + i32;
                this.zzalk = Arrays.copyOf(this.zzalk, this.zzalj * this.zzala);
            }
            short[] sArr5 = this.zzali;
            int i35 = this.zzala;
            System.arraycopy(sArr5, i7 * i35, this.zzalk, this.zzalp * i35, i35 * i32);
            this.zzalo = i7;
            this.zzalp += i32;
            int i36 = 0;
            while (true) {
                i = this.zzalp;
                if (i36 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.zzall;
                    int i37 = (i2 + 1) * i31;
                    i3 = this.zzalm;
                    if (i37 <= i3 * i30) {
                        break;
                    }
                    zzt(1);
                    int i38 = 0;
                    while (true) {
                        int i39 = this.zzala;
                        if (i38 >= i39) {
                            break;
                        }
                        short[] sArr6 = this.zzali;
                        int i40 = (this.zzalo * i39) + i38;
                        short[] sArr7 = this.zzalk;
                        int i41 = (i36 * i39) + i38;
                        short s = sArr7[i41];
                        short s2 = sArr7[i41 + i39];
                        int i42 = this.zzalm * i30;
                        int i43 = this.zzall;
                        int i44 = i43 * i31;
                        int i45 = (i43 + 1) * i31;
                        int i46 = i45 - i42;
                        int i47 = i45 - i44;
                        sArr6[i40] = (short) (((s * i46) + ((i47 - i46) * s2)) / i47);
                        i38++;
                    }
                    this.zzalm++;
                    this.zzalo++;
                }
                this.zzall = i2 + 1;
                if (this.zzall == i30) {
                    this.zzall = 0;
                    zznr.checkState(i3 == i31);
                    this.zzalm = 0;
                }
                i36++;
            }
            int i48 = i - 1;
            if (i48 != 0) {
                short[] sArr8 = this.zzalk;
                int i49 = this.zzala;
                System.arraycopy(sArr8, i48 * i49, sArr8, 0, (i - i48) * i49);
                this.zzalp -= i48;
            }
        }
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
