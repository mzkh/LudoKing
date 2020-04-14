package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.ii */
public abstract class C1850ii extends C1816bz {
    /* renamed from: b */
    public final String mo18083b() {
        return "POST";
    }

    /* renamed from: d */
    public final String mo18085d() {
        return "application/json";
    }

    /* renamed from: e */
    public Map mo18086e() {
        Map e = super.mo18086e();
        C1831gz a = C1831gz.m3554a();
        StringBuilder sb = new StringBuilder();
        sb.append(a.f3829m);
        sb.append("/Android");
        e.put("sdk_ver", sb.toString());
        e.put(TapjoyConstants.TJC_API_KEY, a.f3828l);
        if (C3124gw.f7370a) {
            e.put("debug", Boolean.valueOf(true));
        }
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Object mo18087f() {
        try {
            return super.mo18087f();
        } catch (Exception e) {
            new Object[1][0] = this;
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: a */
    public Object mo18079a(C1812bn bnVar) {
        bnVar.mo18078s();
        return null;
    }
}
