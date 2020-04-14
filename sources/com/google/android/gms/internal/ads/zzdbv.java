package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbv<E> extends zzdbg<E> {
    private final transient E zzgpx;
    private transient int zzgpy;

    zzdbv(E e) {
        this.zzgpx = zzdaq.checkNotNull(e);
    }

    public final int size() {
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return false;
    }

    zzdbv(E e, int i) {
        this.zzgpx = e;
        this.zzgpy = i;
    }

    public final boolean contains(Object obj) {
        return this.zzgpx.equals(obj);
    }

    public final zzdbu<E> zzaoj() {
        return new zzdbi(this.zzgpx);
    }

    /* access modifiers changed from: 0000 */
    public final zzdbd<E> zzaor() {
        return zzdbd.zzad(this.zzgpx);
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzgpx;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.zzgpy;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzgpx.hashCode();
        this.zzgpy = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoq() {
        return this.zzgpy != 0;
    }

    public final String toString() {
        String obj = this.zzgpx.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
