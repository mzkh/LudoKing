package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1206m;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.g */
public class C1139g extends C1138f {
    public C1139g(List<NativeAdImpl> list, C1192i iVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdVideos", list, iVar, appLovinNativeAdLoadListener);
    }

    public C1139g(List<NativeAdImpl> list, C1192i iVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdVideos", list, iVar, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m2380b(NativeAdImpl nativeAdImpl) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to cache video resource ");
        sb.append(nativeAdImpl.getSourceVideoUrl());
        mo10071c(sb.toString());
        mo10104a(nativeAdImpl, !C1246g.m2947a(mo10075g()) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
        return false;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2702k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10103a(NativeAdImpl nativeAdImpl) {
        if (this.f2772a != null) {
            this.f2772a.onNativeAdVideoPreceached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10104a(NativeAdImpl nativeAdImpl, int i) {
        if (this.f2772a != null) {
            this.f2772a.onNativeAdVideoPrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo10105a(NativeAdImpl nativeAdImpl, C1206m mVar) {
        if (!C1277l.m3042b(nativeAdImpl.getSourceVideoUrl())) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Beginning native ad video caching");
        sb.append(nativeAdImpl.getAdId());
        mo10068a(sb.toString());
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2348bJ)).booleanValue()) {
            String a = mo10107a(nativeAdImpl.getSourceVideoUrl(), mVar, nativeAdImpl.getResourcePrefixes());
            if (a == null) {
                return m2380b(nativeAdImpl);
            }
            nativeAdImpl.setVideoUrl(a);
        } else {
            mo10068a("Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
