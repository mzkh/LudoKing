package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0948a;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd implements C0948a {

    /* renamed from: a */
    private static final Map<String, MaxRewardedAd> f3266a = new HashMap();

    /* renamed from: b */
    private static final Object f3267b = new Object();

    /* renamed from: c */
    private static WeakReference<Activity> f3268c = new WeakReference<>(null);

    /* renamed from: d */
    private final MaxFullscreenAdImpl f3269d;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        String str2 = str;
        MaxFullscreenAdImpl maxFullscreenAdImpl = new MaxFullscreenAdImpl(str2, MaxAdFormat.REWARDED, this, "MaxRewardedAd", C1281o.m3071a(appLovinSdk));
        this.f3269d = maxFullscreenAdImpl;
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            updateActivity(activity);
            synchronized (f3267b) {
                MaxRewardedAd maxRewardedAd = (MaxRewardedAd) f3266a.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
                f3266a.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void updateActivity(Activity activity) {
        if (activity != null) {
            f3268c = new WeakReference<>(activity);
        }
    }

    public void destroy() {
        synchronized (f3267b) {
            f3266a.remove(this.f3269d.getAdUnitId());
        }
        this.f3269d.destroy();
    }

    public Activity getActivity() {
        return (Activity) f3268c.get();
    }

    public boolean isReady() {
        return this.f3269d.isReady();
    }

    public void loadAd() {
        this.f3269d.loadAd(getActivity());
    }

    public void setExtrasParameter(String str, String str2) {
        this.f3269d.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.f3269d.setListener(maxRewardedAdListener);
    }

    public void showAd() {
        showAd(null);
    }

    public void showAd(String str) {
        this.f3269d.showAd(str, getActivity());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f3269d);
        return sb.toString();
    }
}
