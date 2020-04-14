package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzchf implements zzbsu {
    private final zzaxv zzbrt;

    zzchf(zzaxv zzaxv) {
        this.zzbrt = zzaxv;
    }

    public final void zza(boolean z, Context context) {
        zzaxv zzaxv = this.zzbrt;
        try {
            zzq.zzki();
            zzn.zza(context, (AdOverlayInfoParcel) zzaxv.get(), true);
        } catch (Exception unused) {
        }
    }
}
