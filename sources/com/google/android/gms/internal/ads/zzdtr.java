package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtr implements ListIterator<String> {
    private final /* synthetic */ int zzgqx;
    private ListIterator<String> zzhor = this.zzhos.zzhot.listIterator(this.zzgqx);
    private final /* synthetic */ zzdts zzhos;

    zzdtr(zzdts zzdts, int i) {
        this.zzhos = zzdts;
        this.zzgqx = i;
    }

    public final boolean hasNext() {
        return this.zzhor.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzhor.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzhor.nextIndex();
    }

    public final int previousIndex() {
        return this.zzhor.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.zzhor.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzhor.next();
    }
}
