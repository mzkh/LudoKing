package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbt<E> extends zzdbg<E> {
    static final zzdbt<Object> zzgpu;
    private final transient int mask;
    private final transient int size;
    private final transient int zzafv;
    private final transient Object[] zzgpv;
    private final transient Object[] zzgpw;

    zzdbt(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzgpv = objArr;
        this.zzgpw = objArr2;
        this.mask = i2;
        this.zzafv = i;
        this.size = i3;
    }

    /* access modifiers changed from: 0000 */
    public final int zzaol() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoq() {
        return true;
    }

    public final boolean contains(@NullableDecl Object obj) {
        int i;
        Object[] objArr = this.zzgpw;
        if (obj == null || objArr == null) {
            return false;
        }
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        int zzdp = zzdaz.zzdp(i);
        while (true) {
            int i2 = zzdp & this.mask;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzdp = i2 + 1;
        }
    }

    public final int size() {
        return this.size;
    }

    public final zzdbu<E> zzaoj() {
        return (zzdbu) zzaon().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzaok() {
        return this.zzgpv;
    }

    /* access modifiers changed from: 0000 */
    public final int zzaom() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzgpv, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* access modifiers changed from: 0000 */
    public final zzdbd<E> zzaor() {
        return zzdbd.zzb(this.zzgpv, this.size);
    }

    public final int hashCode() {
        return this.zzafv;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static {
        zzdbt zzdbt = new zzdbt(new Object[0], 0, null, 0, 0);
        zzgpu = zzdbt;
    }
}
