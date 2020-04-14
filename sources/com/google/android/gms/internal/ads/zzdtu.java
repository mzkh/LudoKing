package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtu implements Iterator<String> {
    private final /* synthetic */ zzdts zzhos;
    private Iterator<String> zzhpo = this.zzhos.zzhot.iterator();

    zzdtu(zzdts zzdts) {
        this.zzhos = zzdts;
    }

    public final boolean hasNext() {
        return this.zzhpo.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzhpo.next();
    }
}
