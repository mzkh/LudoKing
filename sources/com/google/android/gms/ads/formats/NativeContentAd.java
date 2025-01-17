package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class NativeContentAd extends NativeAd {
    public static final String ASSET_ADVERTISER = "1004";
    public static final String ASSET_ATTRIBUTION_ICON_IMAGE = "1007";
    public static final String ASSET_BODY = "1002";
    public static final String ASSET_CALL_TO_ACTION = "1003";
    public static final String ASSET_HEADLINE = "1001";
    public static final String ASSET_IMAGE = "1005";
    public static final String ASSET_LOGO = "1006";
    public static final String ASSET_MEDIA_VIDEO = "1009";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface OnContentAdLoadedListener {
        void onContentAdLoaded(NativeContentAd nativeContentAd);
    }

    public abstract void destroy();

    @KeepForSdk
    public abstract AdChoicesInfo getAdChoicesInfo();

    public abstract CharSequence getAdvertiser();

    public abstract CharSequence getBody();

    public abstract CharSequence getCallToAction();

    public abstract Bundle getExtras();

    public abstract CharSequence getHeadline();

    public abstract List<Image> getImages();

    public abstract Image getLogo();

    public abstract CharSequence getMediationAdapterClassName();

    public abstract VideoController getVideoController();
}
