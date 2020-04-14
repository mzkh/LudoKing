package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1206m;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.e */
public class C1137e extends C1138f {
    public C1137e(List<NativeAdImpl> list, C1192i iVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdImages", list, iVar, appLovinNativeAdLoadListener);
    }

    public C1137e(List<NativeAdImpl> list, C1192i iVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdImages", list, iVar, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m2369b(NativeAdImpl nativeAdImpl) {
        mo10071c("Unable to cache image resource");
        mo10104a(nativeAdImpl, !C1246g.m2947a(mo10075g()) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES);
        return false;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2701j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10103a(NativeAdImpl nativeAdImpl) {
        if (this.f2772a != null) {
            this.f2772a.onNativeAdImagesPrecached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10104a(NativeAdImpl nativeAdImpl, int i) {
        if (this.f2772a != null) {
            this.f2772a.onNativeAdImagePrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo10105a(NativeAdImpl nativeAdImpl, C1206m mVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Beginning native ad image caching for #");
        sb.append(nativeAdImpl.getAdId());
        mo10068a(sb.toString());
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2348bJ)).booleanValue()) {
            String a = mo10107a(nativeAdImpl.getSourceIconUrl(), mVar, nativeAdImpl.getResourcePrefixes());
            if (a == null) {
                return m2369b(nativeAdImpl);
            }
            nativeAdImpl.setIconUrl(a);
            String a2 = mo10107a(nativeAdImpl.getSourceImageUrl(), mVar, nativeAdImpl.getResourcePrefixes());
            if (a2 == null) {
                return m2369b(nativeAdImpl);
            }
            nativeAdImpl.setImageUrl(a2);
        } else {
            mo10068a("Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
