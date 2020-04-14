package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbn<E> extends zzdbd<E> {
    static final zzdbd<Object> zzgpp = new zzdbn(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzgpq;

    zzdbn(Object[] objArr, int i) {
        this.zzgpq = objArr;
        this.size = i;
    }

    /* access modifiers changed from: 0000 */
    public final int zzaol() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return false;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzaok() {
        return this.zzgpq;
    }

    /* access modifiers changed from: 0000 */
    public final int zzaom() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzgpq, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final E get(int i) {
        zzdaq.zzr(i, this.size);
        return this.zzgpq[i];
    }
}
