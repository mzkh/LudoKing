package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadu extends zzade {
    private final UnconfirmedClickListener zzcxa;

    public zzadu(UnconfirmedClickListener unconfirmedClickListener) {
        this.zzcxa = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.zzcxa.onUnconfirmedClickReceived(str);
    }

    public final void onUnconfirmedClickCancelled() {
        this.zzcxa.onUnconfirmedClickCancelled();
    }
}
