package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpp extends zzdpr {
    private final int limit = this.zzhge.size();
    private int position = 0;
    private final /* synthetic */ zzdpm zzhge;

    zzdpp(zzdpm zzdpm) {
        this.zzhge = zzdpm;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzhge.zzfn(i);
        }
        throw new NoSuchElementException();
    }
}
