package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.l */
public class C1149l extends C1150m {

    /* renamed from: a */
    private final List<String> f2788a;

    public C1149l(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super(C1082d.m1998a(m2410a(list), iVar), appLovinAdLoadListener, "TaskFetchMultizoneAd", iVar);
        this.f2788a = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    private static String m2410a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        throw new IllegalArgumentException("No zone identifiers specified");
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2704m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo10116b() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.f2788a;
        hashMap.put(AdColonyAdapterUtils.KEY_ZONE_IDS, C1277l.m3044d(C1243d.m2921a((Collection<String>) list, list.size())));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1079b mo10117c() {
        return C1079b.APPLOVIN_MULTIZONE;
    }
}
