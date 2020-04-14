package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvy implements zzbnj {
    private final zzbur zzfjl;
    private final zzbuv zzfkr;

    public zzbvy(zzbur zzbur, zzbuv zzbuv) {
        this.zzfjl = zzbur;
        this.zzfkr = zzbuv;
    }

    public final void onAdImpression() {
        if (this.zzfjl.zzahw() != null) {
            zzbbw zzahv = this.zzfjl.zzahv();
            zzbbw zzahu = this.zzfjl.zzahu();
            if (zzahv == null) {
                zzahv = zzahu != null ? zzahu : null;
            }
            if (this.zzfkr.zzahl() && zzahv != null) {
                zzahv.zza("onSdkImpression", new ArrayMap());
            }
        }
    }
}
