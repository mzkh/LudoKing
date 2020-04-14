package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zza extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmu;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmu = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.zzmu.zzmr != null && this.zzmu.zzms != null) {
            this.zzmu.zzms.zzb(this.zzmu.zzmr.getAdMetadata());
        }
    }
}
