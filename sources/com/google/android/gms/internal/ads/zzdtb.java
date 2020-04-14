package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtb extends zzdth {
    private final /* synthetic */ zzdta zzhoh;

    private zzdtb(zzdta zzdta) {
        this.zzhoh = zzdta;
        super(zzdta, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzdtc(this.zzhoh, null);
    }

    /* synthetic */ zzdtb(zzdta zzdta, zzdsz zzdsz) {
        this(zzdta);
    }
}
