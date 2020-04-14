package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.C1827gj.C1828a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.fy */
public final class C1822fy extends C1827gj {

    /* renamed from: a */
    static final Map f3784a = Collections.unmodifiableMap(new HashMap());

    /* renamed from: c */
    private final C1828a f3785c = mo18106a("BuildConfig");

    /* renamed from: d */
    private final C1828a f3786d = mo18106a("ServerFinal");

    /* renamed from: e */
    private final C1828a f3787e = mo18106a("AppRuntime");

    /* renamed from: f */
    private final C1828a f3788f = mo18106a("ConnectFlags");

    /* renamed from: g */
    private final C1828a f3789g = mo18106a("ServerDefault");

    C1822fy() {
        C1828a a = mo18106a("SDKDefault");
        HashMap hashMap = new HashMap();
        hashMap.put("placement_request_content_retry_timeout", Integer.valueOf(-1));
        String str = "placement_request_content_retry_backoff";
        hashMap.put(str, Arrays.asList(new Number[]{Long.valueOf(0), Long.valueOf(500), Long.valueOf(TapjoyConstants.TIMER_INCREMENT), Double.valueOf(2.0d)}));
        a.f3806b = hashMap;
    }

    /* renamed from: a */
    public final void mo18091a(@Nullable Map map) {
        Map map2;
        Map map3 = null;
        if (map != null) {
            map3 = (Map) map.get("final");
            map2 = (Map) map.get("default");
        } else {
            map2 = null;
        }
        this.f3786d.f3806b = map3;
        this.f3789g.f3806b = map2;
        setChanged();
    }

    /* renamed from: a */
    public final void mo18090a(Hashtable hashtable) {
        HashMap hashMap = new HashMap();
        for (Entry entry : hashtable.entrySet()) {
            String str = (String) f3784a.get(entry.getKey());
            if (str == null) {
                str = (String) entry.getKey();
            }
            this.f3787e.f3806b.remove(str);
            hashMap.put(str, entry.getValue());
        }
        this.f3788f.f3806b = hashMap;
        setChanged();
    }
}
