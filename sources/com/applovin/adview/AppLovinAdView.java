package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.sdk.C1227o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a */
    private AdViewController f1207a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m991a(null, null, null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m991a(appLovinAdSize, str, null, context, null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m991a(appLovinAdSize, str, appLovinSdk, context, null);
    }

    /* renamed from: a */
    private void m990a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int applyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, i, applyDimension);
    }

    /* renamed from: a */
    private void m991a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            AdViewControllerImpl adViewControllerImpl = new AdViewControllerImpl();
            adViewControllerImpl.initializeAdView(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
            this.f1207a = adViewControllerImpl;
            return;
        }
        m990a(attributeSet, context);
    }

    public void destroy() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.destroy();
        }
    }

    @Deprecated
    public AdViewController getAdViewController() {
        return this.f1207a;
    }

    public AppLovinAdSize getSize() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            return adViewController.getSize();
        }
        return null;
    }

    public String getZoneId() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            return adViewController.getZoneId();
        }
        return null;
    }

    @Deprecated
    public boolean isAdReadyToDisplay() {
        AdViewController adViewController = this.f1207a;
        return adViewController != null && adViewController.isAdReadyToDisplay();
    }

    public void loadNextAd() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.loadNextAd();
        } else {
            C1227o.m2839g("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.onVisibilityChanged(i);
        }
    }

    public void pause() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.pause();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, null);
    }

    @Deprecated
    public void renderAd(AppLovinAd appLovinAd, String str) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.renderAd(appLovinAd, str);
        }
    }

    public void resume() {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.resume();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.setAdClickListener(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.setAdDisplayListener(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.setAdLoadListener(appLovinAdLoadListener);
        }
    }

    @Deprecated
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.setAdVideoPlaybackListener(appLovinAdVideoPlaybackListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.setAdViewEventListener(appLovinAdViewEventListener);
        }
    }

    public void setAutoDestroy(boolean z) {
        AdViewController adViewController = this.f1207a;
        if (adViewController != null) {
            adViewController.setAutoDestroy(z);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinAdView{zoneId='");
        sb.append(getZoneId());
        sb.append("', size=");
        sb.append(getSize());
        sb.append('}');
        return sb.toString();
    }
}
