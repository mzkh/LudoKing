package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzwj extends zzwh {
    private final MuteThisAdListener zzcdy;

    public zzwj(MuteThisAdListener muteThisAdListener) {
        this.zzcdy = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.zzcdy.onAdMuted();
    }
}
