package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.C1090j;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1152n;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.p */
public class C1228p extends C1230q {
    C1228p(C1192i iVar) {
        super(iVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1082d mo9971a(C1090j jVar) {
        return ((NativeAdImpl) jVar).getAdZone();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1122a mo9972a(C1082d dVar) {
        return new C1152n(null, 1, this.f3108a, this);
    }

    /* renamed from: a */
    public void mo10383a() {
        mo9986h(C1082d.m2010h(this.f3108a));
    }

    /* renamed from: a */
    public void mo9974a(C1082d dVar, int i) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9975a(Object obj, C1082d dVar, int i) {
        ((AppLovinNativeAdLoadListener) obj).onNativeAdsFailedToLoad(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9976a(Object obj, C1090j jVar) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = (AppLovinNativeAdLoadListener) obj;
        appLovinNativeAdLoadListener.onNativeAdsLoaded(Arrays.asList(new AppLovinNativeAd[]{(AppLovinNativeAd) jVar}));
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo9977a(LinkedHashSet linkedHashSet) {
        super.mo9977a(linkedHashSet);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo9978a(C1082d dVar, Object obj) {
        return super.mo9978a(dVar, obj);
    }

    public void adReceived(AppLovinAd appLovinAd) {
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo9979b(C1082d dVar, int i) {
        super.mo9979b(dVar, i);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ boolean mo9980b(C1082d dVar) {
        return super.mo9980b(dVar);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ C1090j mo9981c(C1082d dVar) {
        return super.mo9981c(dVar);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C1090j mo9982d(C1082d dVar) {
        return super.mo9982d(dVar);
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ C1090j mo9983e(C1082d dVar) {
        return super.mo9983e(dVar);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo9984f(C1082d dVar) {
        super.mo9984f(dVar);
    }

    public void failedToReceiveAd(int i) {
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ boolean mo9985g(C1082d dVar) {
        return super.mo9985g(dVar);
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo9986h(C1082d dVar) {
        super.mo9986h(dVar);
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ void mo9987i(C1082d dVar) {
        super.mo9987i(dVar);
    }

    public void onNativeAdsFailedToLoad(int i) {
        mo10385c(C1082d.m2010h(this.f3108a), i);
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd) list.get(0);
        if (((Boolean) this.f3108a.mo10202a(C1096c.f2347bI)).booleanValue()) {
            this.f3108a.mo10242p().precacheResources(appLovinNativeAd, new AppLovinNativeAdPrecacheListener() {
                public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                    C1228p pVar = C1228p.this;
                    pVar.mo10385c(C1082d.m2010h(pVar.f3108a), i);
                }

                public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
                    if (!C1277l.m3042b(appLovinNativeAd.getVideoUrl())) {
                        C1228p.this.mo10384b((C1090j) appLovinNativeAd);
                    }
                }

                public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                    C1227o oVar = C1228p.this.f3109b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Video failed to cache during native ad preload. ");
                    sb.append(i);
                    oVar.mo10381d("NativeAdPreloadManager", sb.toString());
                    C1228p.this.mo10384b((C1090j) appLovinNativeAd);
                }

                public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
                    C1228p.this.mo10384b((C1090j) appLovinNativeAd);
                }
            });
        } else {
            mo10384b((C1090j) appLovinNativeAd);
        }
    }
}
