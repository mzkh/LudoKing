package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbe extends zzdbd<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdbd zzgpc;

    zzdbe(zzdbd zzdbd, int i, int i2) {
        this.zzgpc = zzdbd;
        this.offset = i;
        this.length = i2;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return true;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzaok() {
        return this.zzgpc.zzaok();
    }

    /* access modifiers changed from: 0000 */
    public final int zzaol() {
        return this.zzgpc.zzaol() + this.offset;
    }

    /* access modifiers changed from: 0000 */
    public final int zzaom() {
        return this.zzgpc.zzaol() + this.offset + this.length;
    }

    public final E get(int i) {
        zzdaq.zzr(i, this.length);
        return this.zzgpc.get(i + this.offset);
    }

    public final zzdbd<E> zzt(int i, int i2) {
        zzdaq.zzf(i, i2, this.length);
        zzdbd zzdbd = this.zzgpc;
        int i3 = this.offset;
        return (zzdbd) zzdbd.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
