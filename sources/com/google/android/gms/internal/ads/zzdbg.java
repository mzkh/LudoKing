package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdbg<E> extends zzday<E> implements Set<E> {
    @NullableDecl
    private transient zzdbd<E> zzgpe;

    public static <E> zzdbg<E> zzae(E e) {
        return new zzdbv(e);
    }

    /* access modifiers changed from: private */
    public static boolean zzu(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    /* access modifiers changed from: 0000 */
    public boolean zzaoq() {
        return false;
    }

    @SafeVarargs
    public static <E> zzdbg<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzdaq.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr = new Object[(eArr.length + 6)];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(objArr.length, objArr);
    }

    /* access modifiers changed from: private */
    public static <E> zzdbg<E> zza(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return zzae(objArr[0]);
            }
            int zzdr = zzdr(i);
            Object[] objArr2 = new Object[zzdr];
            int i2 = zzdr - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object zzd = zzdbk.zzd(objArr[i5], i5);
                int hashCode = zzd.hashCode();
                int zzdp = zzdaz.zzdp(hashCode);
                while (true) {
                    int i6 = zzdp & i2;
                    Object obj = objArr2[i6];
                    if (obj != null) {
                        if (obj.equals(zzd)) {
                            break;
                        }
                        zzdp++;
                    } else {
                        int i7 = i4 + 1;
                        objArr[i4] = zzd;
                        objArr2[i6] = zzd;
                        i3 += hashCode;
                        i4 = i7;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, null);
            if (i4 == 1) {
                return new zzdbv(objArr[0], i3);
            }
            if (zzdr(i4) < zzdr / 2) {
                i = i4;
            } else {
                if (zzu(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                zzdbt zzdbt = new zzdbt(objArr, i3, objArr2, i2, i4);
                return zzdbt;
            }
        }
        return zzdbt.zzgpu;
    }

    static int zzdr(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzdaq.checkArgument(z, "collection too large");
            return 1073741824;
        }
    }

    zzdbg() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdbg) || !zzaoq() || !((zzdbg) obj).zzaoq() || hashCode() == obj.hashCode()) {
            return zzdbs.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzdbs.zzf(this);
    }

    public zzdbd<E> zzaon() {
        zzdbd<E> zzdbd = this.zzgpe;
        if (zzdbd != null) {
            return zzdbd;
        }
        zzdbd<E> zzaor = zzaor();
        this.zzgpe = zzaor;
        return zzaor;
    }

    /* access modifiers changed from: 0000 */
    public zzdbd<E> zzaor() {
        return zzdbd.zzc(toArray());
    }

    public static <E> zzdbj<E> zzds(int i) {
        zzdax.zzf(i, "expectedSize");
        return new zzdbj<>(i);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
