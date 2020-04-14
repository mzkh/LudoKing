package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbf<E> extends zzdau<E> {
    private final zzdbd<E> zzgpd;

    zzdbf(zzdbd<E> zzdbd, int i) {
        super(zzdbd.size(), i);
        this.zzgpd = zzdbd;
    }

    /* access modifiers changed from: protected */
    public final E get(int i) {
        return this.zzgpd.get(i);
    }
}
