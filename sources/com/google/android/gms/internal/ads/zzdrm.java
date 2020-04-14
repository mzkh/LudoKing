package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdrm<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzhmh;

    public zzdrm(Iterator<Entry<K, Object>> it) {
        this.zzhmh = it;
    }

    public final boolean hasNext() {
        return this.zzhmh.hasNext();
    }

    public final void remove() {
        this.zzhmh.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzhmh.next();
        return entry.getValue() instanceof zzdrh ? new zzdrj(entry) : entry;
    }
}
