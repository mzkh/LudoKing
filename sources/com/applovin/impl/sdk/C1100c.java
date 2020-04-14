package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.C1090j;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1150m;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.c */
public class C1100c extends C1230q {
    C1100c(C1192i iVar) {
        super(iVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1082d mo9971a(C1090j jVar) {
        return ((AppLovinAdBase) jVar).getAdZone();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1122a mo9972a(C1082d dVar) {
        C1150m mVar = new C1150m(dVar, this, this.f3108a);
        mVar.mo10120a(true);
        return mVar;
    }

    /* renamed from: a */
    public void mo9973a() {
        for (C1082d dVar : C1082d.m2003b(this.f3108a)) {
            if (!dVar.mo9850d()) {
                mo9986h(dVar);
            }
        }
    }

    /* renamed from: a */
    public void mo9974a(C1082d dVar, int i) {
        mo10385c(dVar, i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9975a(Object obj, C1082d dVar, int i) {
        if (obj instanceof C1205l) {
            ((C1205l) obj).mo9974a(dVar, i);
        }
        if (obj instanceof AppLovinAdLoadListener) {
            ((AppLovinAdLoadListener) obj).failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9976a(Object obj, C1090j jVar) {
        ((AppLovinAdLoadListener) obj).adReceived((AppLovinAd) jVar);
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
        mo10384b((C1090j) appLovinAd);
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
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
    }
}
