package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbla {
    private final zzcvz zzels;
    private final zzcvr zzfbi;
    private final String zzffi;

    public zzbla(zzcvz zzcvz, zzcvr zzcvr, @Nullable String str) {
        this.zzels = zzcvz;
        this.zzfbi = zzcvr;
        if (str == null) {
            str = "com.google.ads.mediation.admob.AdMobAdapter";
        }
        this.zzffi = str;
    }

    public final zzcvz zzafp() {
        return this.zzels;
    }

    public final zzcvr zzafq() {
        return this.zzfbi;
    }

    public final String zzafr() {
        return this.zzffi;
    }
}
