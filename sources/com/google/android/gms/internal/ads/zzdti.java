package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdti implements Iterator<Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzdta zzhoh;
    private Iterator<Entry<K, V>> zzhoi;
    private boolean zzhom;

    private zzdti(zzdta zzdta) {
        this.zzhoh = zzdta;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzhoh.zzhoc.size() || (!this.zzhoh.zzhod.isEmpty() && zzbbt().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzhom) {
            this.zzhom = false;
            this.zzhoh.zzbbr();
            if (this.pos < this.zzhoh.zzhoc.size()) {
                zzdta zzdta = this.zzhoh;
                int i = this.pos;
                this.pos = i - 1;
                zzdta.zzha(i);
                return;
            }
            zzbbt().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Entry<K, V>> zzbbt() {
        if (this.zzhoi == null) {
            this.zzhoi = this.zzhoh.zzhod.entrySet().iterator();
        }
        return this.zzhoi;
    }

    public final /* synthetic */ Object next() {
        this.zzhom = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzhoh.zzhoc.size()) {
            return (Entry) this.zzhoh.zzhoc.get(this.pos);
        }
        return (Entry) zzbbt().next();
    }

    /* synthetic */ zzdti(zzdta zzdta, zzdsz zzdsz) {
        this(zzdta);
    }
}
