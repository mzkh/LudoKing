package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdcc<I, O> extends zzdca<I, O, zzdal<? super I, ? extends O>, O> {
    zzdcc(zzddi<? extends I> zzddi, zzdal<? super I, ? extends O> zzdal) {
        super(zzddi, zzdal);
    }

    /* access modifiers changed from: 0000 */
    public final void setResult(@NullableDecl O o) {
        set(o);
    }

    /* access modifiers changed from: 0000 */
    @NullableDecl
    public final /* synthetic */ Object zzc(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzdal) obj).apply(obj2);
    }
}
