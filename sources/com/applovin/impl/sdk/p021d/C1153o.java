package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1080c;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.o */
public class C1153o extends C1150m {

    /* renamed from: a */
    private final C1080c f2795a;

    public C1153o(C1080c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super(C1082d.m1998a("adtoken_zone", iVar), appLovinAdLoadListener, "TaskFetchTokenAd", iVar);
        this.f2795a = cVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2707p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo10116b() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", C1277l.m3044d(this.f2795a.mo9838a()));
        hashMap.put("adtoken_prefix", C1277l.m3044d(this.f2795a.mo9840c()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1079b mo10117c() {
        return C1079b.REGULAR_AD_TOKEN;
    }
}
