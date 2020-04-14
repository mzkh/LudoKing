package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1144j;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {

    /* renamed from: a */
    private final C1192i f3045a;

    public PostbackServiceImpl(C1192i iVar) {
        this.f3045a = iVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(C1225g.m2812b(this.f3045a).mo10324a(str).mo10327a(false).mo10328a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(C1225g gVar, C1161a aVar, AppLovinPostbackListener appLovinPostbackListener) {
        this.f3045a.mo10185K().mo10131a((C1122a) new C1144j(gVar, aVar, this.f3045a, appLovinPostbackListener), aVar);
    }

    public void dispatchPostbackRequest(C1225g gVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(gVar, C1161a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
