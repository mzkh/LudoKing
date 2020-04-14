package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzxd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class PublisherInterstitialAd {
    private final zzxd zzabg;

    public PublisherInterstitialAd(Context context) {
        this.zzabg = new zzxd(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final AdListener getAdListener() {
        return this.zzabg.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzabg.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzabg.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzabg.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzabg.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzabg.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzabg.zza(publisherAdRequest.zzdb());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzabg.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzabg.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzabg.setAppEventListener(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzabg.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final String getMediationAdapterClassName() {
        return this.zzabg.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzabg.show();
    }

    public final void setImmersiveMode(boolean z) {
        this.zzabg.setImmersiveMode(z);
    }
}
