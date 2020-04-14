package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdbi extends zzdbu<T> {
    private boolean zzgpj;
    private final /* synthetic */ Object zzgpk;

    zzdbi(Object obj) {
        this.zzgpk = obj;
    }

    public final boolean hasNext() {
        return !this.zzgpj;
    }

    public final T next() {
        if (!this.zzgpj) {
            this.zzgpj = true;
            return this.zzgpk;
        }
        throw new NoSuchElementException();
    }
}
