package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1215b.C1216a;
import com.applovin.impl.sdk.p019b.C1096c;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.g */
public class C1225g<T> extends C1215b {

    /* renamed from: com.applovin.impl.sdk.network.g$a */
    public static class C1226a<T> extends C1216a<T> {
        public C1226a(C1192i iVar) {
            super(iVar);
            this.f3076h = false;
            this.f3077i = ((Integer) iVar.mo10202a(C1096c.f2488dt)).intValue();
            this.f3078j = ((Integer) iVar.mo10202a(C1096c.f2487ds)).intValue();
            this.f3079k = ((Integer) iVar.mo10202a(C1096c.f2490dv)).intValue();
        }

        /* renamed from: b */
        public C1226a mo10323a(T t) {
            this.f3075g = t;
            return this;
        }

        /* renamed from: b */
        public C1226a mo10325a(Map<String, String> map) {
            this.f3072d = map;
            return this;
        }

        /* renamed from: b */
        public C1226a mo10326a(JSONObject jSONObject) {
            this.f3074f = jSONObject;
            return this;
        }

        /* renamed from: b */
        public C1225g<T> mo10328a() {
            return new C1225g<>(this);
        }

        /* renamed from: c */
        public C1226a mo10366c(Map<String, String> map) {
            this.f3073e = map;
            return this;
        }

        /* renamed from: c */
        public C1226a mo10327a(boolean z) {
            this.f3080l = z;
            return this;
        }

        /* renamed from: d */
        public C1226a mo10322a(int i) {
            this.f3077i = i;
            return this;
        }

        /* renamed from: d */
        public C1226a mo10324a(String str) {
            this.f3070b = str;
            return this;
        }

        /* renamed from: e */
        public C1226a mo10329b(int i) {
            this.f3078j = i;
            return this;
        }

        /* renamed from: e */
        public C1226a mo10333c(String str) {
            this.f3071c = str;
            return this;
        }

        /* renamed from: f */
        public C1226a mo10332c(int i) {
            this.f3079k = i;
            return this;
        }

        /* renamed from: f */
        public C1226a mo10330b(String str) {
            this.f3069a = str;
            return this;
        }
    }

    protected C1225g(C1226a aVar) {
        super(aVar);
    }

    /* renamed from: b */
    public static C1226a m2812b(C1192i iVar) {
        return new C1226a(iVar);
    }
}
