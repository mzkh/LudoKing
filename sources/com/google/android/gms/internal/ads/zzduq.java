package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzduq implements Cloneable {
    private Object value;
    private zzduo<?, ?> zzhrf;
    private List<Object> zzhrg = new ArrayList();

    zzduq() {
    }

    /* access modifiers changed from: 0000 */
    public final int zznx() {
        if (this.value == null) {
            Iterator it = this.zzhrg.iterator();
            if (!it.hasNext()) {
                return 0;
            }
            it.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzduj zzduj) throws IOException {
        if (this.value == null) {
            Iterator it = this.zzhrg.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzduq)) {
            return false;
        }
        zzduq zzduq = (zzduq) obj;
        if (this.value == null || zzduq.value == null) {
            List<Object> list = this.zzhrg;
            if (list != null) {
                List<Object> list2 = zzduq.zzhrg;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(toByteArray(), zzduq.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzduo<?, ?> zzduo = this.zzhrf;
            if (zzduo != zzduq.zzhrf) {
                return false;
            }
            if (!zzduo.zzhrd.isArray()) {
                return this.value.equals(zzduq.value);
            }
            Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) zzduq.value);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) zzduq.value);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) zzduq.value);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) zzduq.value);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) zzduq.value);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) zzduq.value);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) zzduq.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zznx()];
        zza(zzduj.zzae(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbcj */
    public final zzduq clone() {
        zzduq zzduq = new zzduq();
        try {
            zzduq.zzhrf = this.zzhrf;
            if (this.zzhrg == null) {
                zzduq.zzhrg = null;
            } else {
                zzduq.zzhrg.addAll(this.zzhrg);
            }
            if (this.value != null) {
                if (this.value instanceof zzdus) {
                    zzduq.value = (zzdus) ((zzdus) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzduq.value = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzduq.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        zzduq.value = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        zzduq.value = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        zzduq.value = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        zzduq.value = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        zzduq.value = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzdus[]) {
                        zzdus[] zzdusArr = (zzdus[]) this.value;
                        zzdus[] zzdusArr2 = new zzdus[zzdusArr.length];
                        zzduq.value = zzdusArr2;
                        while (i < zzdusArr.length) {
                            zzdusArr2[i] = (zzdus) zzdusArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return zzduq;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
