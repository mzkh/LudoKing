package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzado extends zzacm {
    private final OnContentAdLoadedListener zzcws;

    public zzado(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzcws = onContentAdLoadedListener;
    }

    public final void zza(zzaca zzaca) {
        this.zzcws.onContentAdLoaded(new zzacf(zzaca));
    }
}
