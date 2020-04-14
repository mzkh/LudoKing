package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbq extends zzdbd<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzgpo;

    zzdbq(Object[] objArr, int i, int i2) {
        this.zzgpo = objArr;
        this.offset = i;
        this.size = i2;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return true;
    }

    public final Object get(int i) {
        zzdaq.zzr(i, this.size);
        return this.zzgpo[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
