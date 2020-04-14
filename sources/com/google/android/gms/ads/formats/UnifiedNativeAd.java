package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class UnifiedNativeAd {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface MediaContent {
        float getAspectRatio();

        @Nullable
        Drawable getMainImage();

        void setMainImage(@Nullable Drawable drawable);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface OnUnifiedNativeAdLoadedListener {
        void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface UnconfirmedClickListener {
        void onUnconfirmedClickCancelled();

        void onUnconfirmedClickReceived(String str);
    }

    public abstract void cancelUnconfirmedClick();

    public abstract void destroy();

    public abstract void enableCustomClickGesture();

    public abstract AdChoicesInfo getAdChoicesInfo();

    public abstract String getAdvertiser();

    public abstract String getBody();

    public abstract String getCallToAction();

    public abstract Bundle getExtras();

    public abstract String getHeadline();

    public abstract Image getIcon();

    public abstract List<Image> getImages();

    public abstract MediaContent getMediaContent();

    public abstract String getMediationAdapterClassName();

    public abstract List<MuteThisAdReason> getMuteThisAdReasons();

    public abstract String getPrice();

    public abstract Double getStarRating();

    public abstract String getStore();

    public abstract VideoController getVideoController();

    public abstract boolean isCustomClickGestureEnabled();

    public abstract boolean isCustomMuteThisAdEnabled();

    public abstract void muteThisAd(MuteThisAdReason muteThisAdReason);

    @KeepForSdk
    public abstract void performClick(Bundle bundle);

    public abstract void recordCustomClickGesture();

    @KeepForSdk
    public abstract boolean recordImpression(Bundle bundle);

    @KeepForSdk
    public abstract void reportTouchEvent(Bundle bundle);

    public abstract void setMuteThisAdListener(MuteThisAdListener muteThisAdListener);

    public abstract void setUnconfirmedClickListener(UnconfirmedClickListener unconfirmedClickListener);

    /* access modifiers changed from: protected */
    public abstract Object zzjd();

    public abstract Object zzji();
}
