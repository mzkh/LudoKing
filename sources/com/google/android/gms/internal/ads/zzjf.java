package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzjf implements zzjk {
    private final byte[] zzana = new byte[8];
    private final Stack<zzjh> zzanb = new Stack<>();
    private final zzjp zzanc = new zzjp();
    private zzjj zzand;
    private int zzane;
    private int zzanf;
    private long zzang;

    zzjf() {
    }

    public final void zza(zzjj zzjj) {
        this.zzand = zzjj;
    }

    public final void reset() {
        this.zzane = 0;
        this.zzanb.clear();
        this.zzanc.reset();
    }

    public final boolean zzb(zziv zziv) throws IOException, InterruptedException {
        String str;
        double d;
        int zzaj;
        int zza;
        zznr.checkState(this.zzand != null);
        while (true) {
            if (this.zzanb.isEmpty() || zziv.getPosition() < ((zzjh) this.zzanb.peek()).zzanj) {
                if (this.zzane == 0) {
                    long zza2 = this.zzanc.zza(zziv, true, false, 4);
                    if (zza2 == -2) {
                        zziv.zzgb();
                        while (true) {
                            zziv.zza(this.zzana, 0, 4);
                            zzaj = zzjp.zzaj(this.zzana[0]);
                            if (zzaj != -1 && zzaj <= 4) {
                                zza = (int) zzjp.zza(this.zzana, zzaj, false);
                                if (this.zzand.zzah(zza)) {
                                    break;
                                }
                            }
                            zziv.zzab(1);
                        }
                        zziv.zzab(zzaj);
                        zza2 = (long) zza;
                    }
                    if (zza2 == -1) {
                        return false;
                    }
                    this.zzanf = (int) zza2;
                    this.zzane = 1;
                }
                if (this.zzane == 1) {
                    this.zzang = this.zzanc.zza(zziv, false, true, 8);
                    this.zzane = 2;
                }
                int zzag = this.zzand.zzag(this.zzanf);
                if (zzag == 0) {
                    zziv.zzab((int) this.zzang);
                    this.zzane = 0;
                } else if (zzag == 1) {
                    long position = zziv.getPosition();
                    this.zzanb.add(new zzjh(this.zzanf, this.zzang + position));
                    this.zzand.zzd(this.zzanf, position, this.zzang);
                    this.zzane = 0;
                    return true;
                } else if (zzag == 2) {
                    long j = this.zzang;
                    if (j <= 8) {
                        this.zzand.zzc(this.zzanf, zza(zziv, (int) j));
                        this.zzane = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j);
                    throw new zzgv(sb.toString());
                } else if (zzag == 3) {
                    long j2 = this.zzang;
                    if (j2 <= 2147483647L) {
                        zzjj zzjj = this.zzand;
                        int i = this.zzanf;
                        int i2 = (int) j2;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zziv.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        zzjj.zza(i, str);
                        this.zzane = 0;
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j2);
                    throw new zzgv(sb2.toString());
                } else if (zzag == 4) {
                    this.zzand.zza(this.zzanf, (int) this.zzang, zziv);
                    this.zzane = 0;
                    return true;
                } else if (zzag == 5) {
                    long j3 = this.zzang;
                    if (j3 == 4 || j3 == 8) {
                        zzjj zzjj2 = this.zzand;
                        int i3 = this.zzanf;
                        int i4 = (int) this.zzang;
                        long zza3 = zza(zziv, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) zza3);
                        } else {
                            d = Double.longBitsToDouble(zza3);
                        }
                        zzjj2.zza(i3, d);
                        this.zzane = 0;
                        return true;
                    }
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j3);
                    throw new zzgv(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(zzag);
                    throw new zzgv(sb4.toString());
                }
            } else {
                this.zzand.zzai(((zzjh) this.zzanb.pop()).zzanf);
                return true;
            }
        }
    }

    private final long zza(zziv zziv, int i) throws IOException, InterruptedException {
        zziv.readFully(this.zzana, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzana[i2] & 255));
        }
        return j;
    }
}
