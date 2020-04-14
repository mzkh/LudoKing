package com.applovin.mediation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import java.util.ArrayList;

class AppLovinNativeAdMapper extends NativeAppInstallAdMapper {
    private AppLovinNativeAd mNativeAd;

    private static class AppLovinNativeAdImage extends Image {
        private final Drawable mDrawable;
        private final Uri mUri;

        public double getScale() {
            return 1.0d;
        }

        AppLovinNativeAdImage(Uri uri, Drawable drawable) {
            this.mDrawable = drawable;
            this.mUri = uri;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public Uri getUri() {
            return this.mUri;
        }
    }

    AppLovinNativeAdMapper(AppLovinNativeAd appLovinNativeAd, Context context) {
        this.mNativeAd = appLovinNativeAd;
        setHeadline(appLovinNativeAd.getTitle());
        setBody(appLovinNativeAd.getDescriptionText());
        setCallToAction(appLovinNativeAd.getCtaText());
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        ArrayList arrayList = new ArrayList(1);
        Uri parse = Uri.parse(appLovinNativeAd.getImageUrl());
        Drawable createFromPath = Drawable.createFromPath(parse.getPath());
        Uri parse2 = Uri.parse(appLovinNativeAd.getIconUrl());
        Drawable createFromPath2 = Drawable.createFromPath(parse2.getPath());
        AppLovinNativeAdImage appLovinNativeAdImage = new AppLovinNativeAdImage(parse, createFromPath);
        AppLovinNativeAdImage appLovinNativeAdImage2 = new AppLovinNativeAdImage(parse2, createFromPath2);
        arrayList.add(appLovinNativeAdImage);
        setImages(arrayList);
        setIcon(appLovinNativeAdImage2);
        imageView.setImageDrawable(createFromPath);
        setMediaView(imageView);
        setStarRating((double) appLovinNativeAd.getStarRating());
        Bundle bundle = new Bundle();
        bundle.putLong(AppLovinNativeAdapter.KEY_EXTRA_AD_ID, appLovinNativeAd.getAdId());
        bundle.putString(AppLovinNativeAdapter.KEY_EXTRA_CAPTION_TEXT, appLovinNativeAd.getCaptionText());
        setExtras(bundle);
        setOverrideClickHandling(false);
        setOverrideImpressionRecording(false);
    }

    public void recordImpression() {
        this.mNativeAd.trackImpression();
    }

    public void handleClick(View view) {
        this.mNativeAd.launchClickTarget(view.getContext());
    }
}
