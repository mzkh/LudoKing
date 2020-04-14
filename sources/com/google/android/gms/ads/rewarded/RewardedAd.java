package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzarl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class RewardedAd {
    private final zzarl zzgnb;

    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzgnb = new zzarl(context, str);
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzgnb.zza(adRequest.zzdb(), rewardedAdLoadCallback);
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzgnb.zza(publisherAdRequest.zzdb(), rewardedAdLoadCallback);
    }

    public final String getMediationAdapterClassName() {
        return this.zzgnb.getMediationAdapterClassName();
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.zzgnb.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzgnb.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
    }

    public final Bundle getAdMetadata() {
        return this.zzgnb.getAdMetadata();
    }

    public final boolean isLoaded() {
        return this.zzgnb.isLoaded();
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzgnb.show(activity, rewardedAdCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzgnb.show(activity, rewardedAdCallback, z);
    }

    @Nullable
    public final RewardItem getRewardItem() {
        return this.zzgnb.getRewardItem();
    }
}
