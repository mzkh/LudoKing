package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1137e;
import com.applovin.impl.sdk.p021d.C1139g;
import com.applovin.impl.sdk.p021d.C1152n;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NativeAdServiceImpl implements AppLovinNativeAdService {

    /* renamed from: a */
    private final C1192i f2071a;

    /* renamed from: b */
    private final C1227o f2072b;

    NativeAdServiceImpl(C1192i iVar) {
        this.f2071a = iVar;
        this.f2072b = iVar.mo10249v();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1899a(AppLovinNativeAd appLovinNativeAd, final AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        this.f2071a.mo10185K().mo10131a((C1122a) new C1139g(Arrays.asList(new NativeAdImpl[]{(NativeAdImpl) appLovinNativeAd}), this.f2071a, (AppLovinNativeAdPrecacheListener) new AppLovinNativeAdPrecacheListener() {
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
            }

            public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
            }

            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                NativeAdServiceImpl.this.m1902a(appLovinNativeAdPrecacheListener, appLovinNativeAd, i, true);
            }

            public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
                NativeAdServiceImpl.this.m1903a(appLovinNativeAdPrecacheListener, appLovinNativeAd, true);
            }
        }), C1161a.CACHING_OTHER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1900a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int i) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
            } catch (Exception e) {
                C1227o.m2837c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1901a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List<AppLovinNativeAd> list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
            } catch (Exception e) {
                C1227o.m2837c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1902a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, int i, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(appLovinNativeAd, i);
            } catch (Exception e) {
                C1227o.m2837c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(appLovinNativeAd, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1903a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            } catch (Exception e) {
                C1227o.m2837c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
        }
    }

    /* renamed from: a */
    private void m1904a(String str, int i, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f2071a.mo10185K().mo10131a((C1122a) new C1152n(str, i, this.f2071a, new AppLovinNativeAdLoadListener() {
            public void onNativeAdsFailedToLoad(int i) {
                NativeAdServiceImpl.this.m1900a(appLovinNativeAdLoadListener, i);
            }

            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                NativeAdServiceImpl.this.m1905a(list, appLovinNativeAdLoadListener);
            }
        }), C1161a.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1905a(List<AppLovinNativeAd> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int intValue = ((Integer) this.f2071a.mo10202a(C1096c.f2486dr)).intValue();
        if (intValue > 0) {
            List list2 = list;
            int size = list2.size();
            if (size == 0) {
                if (appLovinNativeAdLoadListener != null) {
                    appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
                }
                return;
            }
            int min = Math.min(intValue, size);
            final List subList = list2.subList(0, min);
            final List subList2 = list2.subList(min, size);
            m1907b(subList, new AppLovinNativeAdLoadListener() {
                public void onNativeAdsFailedToLoad(int i) {
                    AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                    if (appLovinNativeAdLoadListener != null) {
                        appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
                    }
                }

                public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                    NativeAdServiceImpl.this.m1908c(subList, new AppLovinNativeAdLoadListener() {
                        public void onNativeAdsFailedToLoad(int i) {
                            if (appLovinNativeAdLoadListener != null) {
                                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
                            }
                        }

                        public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                            if (appLovinNativeAdLoadListener != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(subList);
                                arrayList.addAll(subList2);
                                appLovinNativeAdLoadListener.onNativeAdsLoaded(arrayList);
                            }
                        }
                    });
                }
            });
        } else if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    /* renamed from: b */
    private void m1907b(List<NativeAdImpl> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f2071a.mo10185K().mo10131a((C1122a) new C1137e(list, this.f2071a, (AppLovinNativeAdLoadListener) new AppLovinNativeAdLoadListener() {
            public void onNativeAdsFailedToLoad(int i) {
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                if (appLovinNativeAdLoadListener != null) {
                    appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
                }
            }

            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                if (appLovinNativeAdLoadListener != null) {
                    appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
                }
            }
        }), C1161a.CACHING_OTHER);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1908c(List<NativeAdImpl> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f2071a.mo10185K().mo10131a((C1122a) new C1139g(list, this.f2071a, (AppLovinNativeAdLoadListener) new AppLovinNativeAdLoadListener() {
            public void onNativeAdsFailedToLoad(int i) {
                NativeAdServiceImpl.this.m1900a(appLovinNativeAdLoadListener, i);
            }

            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                NativeAdServiceImpl.this.m1901a(appLovinNativeAdLoadListener, list);
            }
        }), C1161a.CACHING_OTHER);
    }

    public boolean hasPreloadedAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1227o.m2841i("NativeAdService", "Unable to check if ad is preloaded - invalid zone id.");
            return false;
        }
        return this.f2071a.mo10195U().mo9985g(C1082d.m1998a(str, this.f2071a));
    }

    public void loadNativeAds(int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        loadNativeAds(i, null, appLovinNativeAdLoadListener);
    }

    public void loadNativeAds(int i, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        if (i > 0) {
            this.f2071a.mo10205a();
            if (i == 1) {
                C1082d b = C1082d.m2002b(str, this.f2071a);
                AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd) this.f2071a.mo10195U().mo9983e(b);
                if (appLovinNativeAd != null) {
                    m1901a(appLovinNativeAdLoadListener, Arrays.asList(new AppLovinNativeAd[]{appLovinNativeAd}));
                } else {
                    m1904a(str, 1, appLovinNativeAdLoadListener);
                }
                if (((Boolean) this.f2071a.mo10202a(C1096c.f2369be)).booleanValue()) {
                    this.f2071a.mo10195U().mo9987i(b);
                    return;
                }
                return;
            }
            m1904a(str, i, appLovinNativeAdLoadListener);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested invalid number of native ads: ");
        sb.append(i);
        C1227o.m2841i("NativeAdService", sb.toString());
    }

    public void loadNextAd(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        loadNativeAds(1, appLovinNativeAdLoadListener);
    }

    public void precacheResources(AppLovinNativeAd appLovinNativeAd, final AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f2071a.mo10205a();
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            m1899a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        this.f2071a.mo10185K().mo10131a((C1122a) new C1137e(Arrays.asList(new NativeAdImpl[]{(NativeAdImpl) appLovinNativeAd}), this.f2071a, (AppLovinNativeAdPrecacheListener) new AppLovinNativeAdPrecacheListener() {
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                NativeAdServiceImpl.this.m1902a(appLovinNativeAdPrecacheListener, appLovinNativeAd, i, false);
            }

            public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
                NativeAdServiceImpl.this.m1903a(appLovinNativeAdPrecacheListener, appLovinNativeAd, false);
                NativeAdServiceImpl.this.m1899a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            }

            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
            }

            public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
            }
        }), C1161a.CACHING_OTHER);
    }

    public void preloadAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1227o.m2841i("NativeAdService", "Unable to preload zone for invalid zone id.");
            return;
        }
        this.f2071a.mo10205a();
        C1082d a = C1082d.m1998a(str, this.f2071a);
        this.f2071a.mo10194T().mo9986h(a);
        this.f2071a.mo10194T().mo9987i(a);
    }

    public void preloadAds(C1082d dVar) {
        this.f2071a.mo10194T().mo9986h(dVar);
        int g = dVar.mo9854g();
        if (g == 0 && this.f2071a.mo10194T().mo9980b(dVar)) {
            g = 1;
        }
        this.f2071a.mo10194T().mo9979b(dVar, g);
    }

    public String toString() {
        return "NativeAdServiceImpl{}";
    }
}
