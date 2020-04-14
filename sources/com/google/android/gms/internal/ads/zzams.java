package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzams implements zzo {
    private final /* synthetic */ zzamt zzdfe;

    zzams(zzamt zzamt) {
        this.zzdfe = zzamt;
    }

    public final void zzsi() {
        zzaxi.zzdv("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdfe.zzdfg.onAdClosed(this.zzdfe);
    }

    public final void onPause() {
        zzaxi.zzdv("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzaxi.zzdv("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzsj() {
        zzaxi.zzdv("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdfe.zzdfg.onAdOpened(this.zzdfe);
    }
}
