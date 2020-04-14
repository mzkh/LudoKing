package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbr<K> extends zzdbg<K> {
    private final transient zzdbd<K> zzgpd;
    private final transient zzdbh<K, ?> zzgps;

    zzdbr(zzdbh<K, ?> zzdbh, zzdbd<K> zzdbd) {
        this.zzgps = zzdbh;
        this.zzgpd = zzdbd;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzaoo() {
        return true;
    }

    public final zzdbu<K> zzaoj() {
        return (zzdbu) zzaon().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        return zzaon().zza(objArr, i);
    }

    public final zzdbd<K> zzaon() {
        return this.zzgpd;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzgps.get(obj) != null;
    }

    public final int size() {
        return this.zzgps.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
