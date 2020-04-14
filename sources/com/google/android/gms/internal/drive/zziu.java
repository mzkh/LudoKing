package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zziu implements Cloneable {
    private Object value;
    private zzis<?, ?> zznc;
    private List<zziz> zznd = new ArrayList();

    zziu() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzaq()];
        zza(zzip.zzb(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbj */
    public final zziu clone() {
        Object clone;
        zziu zziu = new zziu();
        try {
            zziu.zznc = this.zznc;
            if (this.zznd == null) {
                zziu.zznd = null;
            } else {
                zziu.zznd.addAll(this.zznd);
            }
            if (this.value != null) {
                if (this.value instanceof zzix) {
                    clone = (zzix) ((zzix) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zziu.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzix[]) {
                        zzix[] zzixArr = (zzix[]) this.value;
                        zzix[] zzixArr2 = new zzix[zzixArr.length];
                        zziu.value = zzixArr2;
                        while (i < zzixArr.length) {
                            zzixArr2[i] = (zzix) zzixArr[i].clone();
                            i++;
                        }
                    }
                }
                zziu.value = clone;
            }
            return zziu;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zziu)) {
            return false;
        }
        zziu zziu = (zziu) obj;
        if (this.value == null || zziu.value == null) {
            List<zziz> list = this.zznd;
            if (list != null) {
                List<zziz> list2 = zziu.zznd;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(toByteArray(), zziu.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzis<?, ?> zzis = this.zznc;
            if (zzis != zziu.zznc) {
                return false;
            }
            if (!zzis.zzmx.isArray()) {
                return this.value.equals(zziu.value);
            }
            Object obj2 = this.value;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zziu.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zziu.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zziu.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zziu.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zziu.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zziu.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zziu.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzip zzip) throws IOException {
        if (this.value == null) {
            for (zziz zziz : this.zznd) {
                zzip.zzp(zziz.tag);
                zzip.zzc(zziz.zzng);
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zziz zziz) throws IOException {
        List<zziz> list = this.zznd;
        if (list != null) {
            list.add(zziz);
            return;
        }
        Object obj = this.value;
        if (obj instanceof zzix) {
            byte[] bArr = zziz.zzng;
            zzio zza = zzio.zza(bArr, 0, bArr.length);
            int zzbe = zza.zzbe();
            if (zzbe == bArr.length - zzip.zzm(zzbe)) {
                zzix zza2 = ((zzix) this.value).zza(zza);
                this.zznc = this.zznc;
                this.value = zza2;
                this.zznd = null;
                return;
            }
            throw zziw.zzbk();
        } else if (obj instanceof zzix[]) {
            Collections.singletonList(zziz);
            throw new NoSuchMethodError();
        } else {
            Collections.singletonList(zziz);
            throw new NoSuchMethodError();
        }
    }

    /* access modifiers changed from: 0000 */
    public final int zzaq() {
        if (this.value == null) {
            int i = 0;
            for (zziz zziz : this.zznd) {
                i += zzip.zzq(zziz.tag) + 0 + zziz.zzng.length;
            }
            return i;
        }
        throw new NoSuchMethodError();
    }
}
