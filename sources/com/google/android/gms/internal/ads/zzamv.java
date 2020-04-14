package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzamv implements Runnable {
    private final /* synthetic */ zzamt zzdfe;
    private final /* synthetic */ AdOverlayInfoParcel zzdfm;

    zzamv(zzamt zzamt, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdfe = zzamt;
        this.zzdfm = adOverlayInfoParcel;
    }

    public final void run() {
        zzq.zzki();
        zzn.zza(this.zzdfe.zzdff, this.zzdfm, true);
    }
}
