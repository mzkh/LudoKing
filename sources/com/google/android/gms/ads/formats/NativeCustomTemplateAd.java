package com.google.android.gms.ads.formats;

import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface NativeCustomTemplateAd {
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface DisplayOpenMeasurement {
        void setView(View view);

        boolean start();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface OnCustomClickListener {
        void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public interface OnCustomTemplateAdLoadedListener {
        void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    void destroy();

    List<String> getAvailableAssetNames();

    String getCustomTemplateId();

    DisplayOpenMeasurement getDisplayOpenMeasurement();

    Image getImage(String str);

    CharSequence getText(String str);

    VideoController getVideoController();

    MediaView getVideoMediaView();

    void performClick(String str);

    void recordImpression();
}
