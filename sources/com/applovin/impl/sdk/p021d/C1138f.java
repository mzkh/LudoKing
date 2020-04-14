package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1206m;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.f */
abstract class C1138f extends C1122a {

    /* renamed from: a */
    protected final AppLovinNativeAdPrecacheListener f2772a;

    /* renamed from: c */
    private final List<NativeAdImpl> f2773c;

    /* renamed from: d */
    private final AppLovinNativeAdLoadListener f2774d;

    /* renamed from: e */
    private int f2775e;

    C1138f(String str, List<NativeAdImpl> list, C1192i iVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(str, iVar);
        this.f2773c = list;
        this.f2774d = appLovinNativeAdLoadListener;
        this.f2772a = null;
    }

    C1138f(String str, List<NativeAdImpl> list, C1192i iVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(str, iVar);
        if (list != null) {
            this.f2773c = list;
            this.f2774d = null;
            this.f2772a = appLovinNativeAdPrecacheListener;
            return;
        }
        throw new IllegalArgumentException("Native ads cannot be null");
    }

    /* renamed from: a */
    private void m2374a(int i) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f2774d;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
        }
    }

    /* renamed from: a */
    private void m2375a(List<AppLovinNativeAd> list) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f2774d;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo10107a(String str, C1206m mVar, List<String> list) {
        String str2 = "Unable to cache icon resource ";
        if (!C1277l.m3042b(str)) {
            mo10068a("Asked to cache file with null/empty URL, nothing to do.");
            return null;
        } else if (!C1281o.m3094a(str, list)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Domain is not whitelisted, skipping precache for URL ");
            sb.append(str);
            mo10068a(sb.toString());
            return null;
        } else {
            try {
                String a = mVar.mo10275a(mo10075g(), str, null, list, true, true, null);
                if (a != null) {
                    return a;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str);
                mo10071c(sb2.toString());
                return null;
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(str);
                mo10069a(sb3.toString(), e);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo10103a(NativeAdImpl nativeAdImpl);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo10104a(NativeAdImpl nativeAdImpl, int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo10105a(NativeAdImpl nativeAdImpl, C1206m mVar);

    public void run() {
        List list;
        for (NativeAdImpl nativeAdImpl : this.f2773c) {
            mo10068a("Beginning resource caching phase...");
            if (mo10105a(nativeAdImpl, this.f2745b.mo10196V())) {
                this.f2775e++;
                mo10103a(nativeAdImpl);
            } else {
                mo10072d("Unable to cache resources");
            }
        }
        try {
            if (this.f2775e == this.f2773c.size()) {
                list = this.f2773c;
            } else if (((Boolean) this.f2745b.mo10202a(C1096c.f2485dq)).booleanValue()) {
                mo10072d("Mismatch between successful populations and requested size");
                m2374a(-6);
                return;
            } else {
                list = this.f2773c;
            }
            m2375a(list);
        } catch (Throwable th) {
            C1227o.m2837c(mo10074f(), "Encountered exception while notifying publisher code", th);
        }
    }
}
