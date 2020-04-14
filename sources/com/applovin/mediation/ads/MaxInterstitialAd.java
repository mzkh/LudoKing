package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0948a;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MaxInterstitialAd implements C0948a {

    /* renamed from: a */
    private static WeakReference<Activity> f3264a = new WeakReference<>(null);

    /* renamed from: b */
    private final MaxFullscreenAdImpl f3265b;

    public MaxInterstitialAd(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxInterstitialAd(String str, AppLovinSdk appLovinSdk, Activity activity) {
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            f3264a = new WeakReference<>(activity);
            String str2 = str;
            MaxFullscreenAdImpl maxFullscreenAdImpl = new MaxFullscreenAdImpl(str2, MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", C1281o.m3071a(appLovinSdk));
            this.f3265b = maxFullscreenAdImpl;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public void destroy() {
        this.f3265b.destroy();
    }

    public Activity getActivity() {
        return (Activity) f3264a.get();
    }

    public boolean isReady() {
        return this.f3265b.isReady();
    }

    public void loadAd() {
        this.f3265b.loadAd(getActivity());
    }

    public void setExtraParameter(String str, String str2) {
        this.f3265b.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.f3265b.setListener(maxAdListener);
    }

    public void showAd() {
        showAd(null);
    }

    public void showAd(String str) {
        this.f3265b.showAd(str, getActivity());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f3265b);
        return sb.toString();
    }
}
