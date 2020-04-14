package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbyo implements zzt {
    private final zzbnr zzfpx;

    private zzbyo(zzbnr zzbnr) {
        this.zzfpx = zzbnr;
    }

    static zzt zza(zzbnr zzbnr) {
        return new zzbyo(zzbnr);
    }

    public final void zzsy() {
        this.zzfpx.onAdLeftApplication();
    }
}
