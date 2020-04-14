package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtc implements Iterator<Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzdta zzhoh;
    private Iterator<Entry<K, V>> zzhoi;

    private zzdtc(zzdta zzdta) {
        this.zzhoh = zzdta;
        this.pos = this.zzhoh.zzhoc.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzhoh.zzhoc.size()) || zzbbt().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Entry<K, V>> zzbbt() {
        if (this.zzhoi == null) {
            this.zzhoi = this.zzhoh.zzhof.entrySet().iterator();
        }
        return this.zzhoi;
    }

    public final /* synthetic */ Object next() {
        if (zzbbt().hasNext()) {
            return (Entry) zzbbt().next();
        }
        List zzb = this.zzhoh.zzhoc;
        int i = this.pos - 1;
        this.pos = i;
        return (Entry) zzb.get(i);
    }

    /* synthetic */ zzdtc(zzdta zzdta, zzdsz zzdsz) {
        this(zzdta);
    }
}
