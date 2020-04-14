package com.applovin.impl.mediation;

import android.os.Bundle;

/* renamed from: com.applovin.impl.mediation.f */
public class C0994f {

    /* renamed from: a */
    private final Bundle f1912a;

    /* renamed from: com.applovin.impl.mediation.f$a */
    public static class C0996a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Bundle f1913a = new Bundle();

        /* renamed from: a */
        public C0996a mo9537a(String str) {
            if (str != null) {
                this.f1913a.remove(str);
                return this;
            }
            throw new IllegalArgumentException("No key specified.");
        }

        /* renamed from: a */
        public C0996a mo9538a(String str, String str2) {
            if (str != null) {
                this.f1913a.putString(str, str2);
                return this;
            }
            throw new IllegalArgumentException("No key specified");
        }

        /* renamed from: a */
        public C0994f mo9539a() {
            return new C0994f(this);
        }
    }

    private C0994f(C0996a aVar) {
        this.f1912a = aVar.f1913a;
    }

    /* renamed from: a */
    public Bundle mo9535a() {
        return this.f1912a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediatedRequestParameters{extraParameters=");
        sb.append(this.f1912a);
        sb.append('}');
        return sb.toString();
    }
}
