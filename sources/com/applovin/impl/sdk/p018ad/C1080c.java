package com.applovin.impl.sdk.p018ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1277l;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.c */
public class C1080c {

    /* renamed from: a */
    private final C1192i f2189a;

    /* renamed from: b */
    private final String f2190b;

    /* renamed from: com.applovin.impl.sdk.ad.c$a */
    public enum C1081a {
        f2191a(r2),
        f2192b(r3),
        f2193c(r4);
        

        /* renamed from: d */
        private final String f2195d;

        private C1081a(String str) {
            this.f2195d = str;
        }

        public String toString() {
            return this.f2195d;
        }
    }

    public C1080c(String str, C1192i iVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (iVar != null) {
            this.f2190b = str;
            this.f2189a = iVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private String m1991a(C1096c<String> cVar) {
        for (String str : this.f2189a.mo10224b((C1096c) cVar)) {
            if (this.f2190b.startsWith(str)) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo9838a() {
        return this.f2190b;
    }

    /* renamed from: b */
    public C1081a mo9839b() {
        return m1991a(C1096c.f2303aR) != null ? C1081a.f2192b : m1991a(C1096c.f2304aS) != null ? C1081a.f2193c : C1081a.f2191a;
    }

    /* renamed from: c */
    public String mo9840c() {
        String a = m1991a(C1096c.f2303aR);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = m1991a(C1096c.f2304aS);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return null;
    }

    /* renamed from: d */
    public JSONObject mo9841d() {
        String str = "AdToken";
        if (mo9839b() == C1081a.f2193c) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f2190b.substring(mo9840c().length()), 0), "UTF-8"));
                C1227o v = this.f2189a.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded token into ad response: ");
                sb.append(jSONObject);
                v.mo10378b(str, sb.toString());
                return jSONObject;
            } catch (JSONException e) {
                C1227o v2 = this.f2189a.mo10249v();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to decode token '");
                sb2.append(this.f2190b);
                sb2.append("' into JSON");
                v2.mo10379b(str, sb2.toString(), e);
            } catch (Throwable th) {
                C1227o v3 = this.f2189a.mo10249v();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to process ad response from token '");
                sb3.append(this.f2190b);
                sb3.append("'");
                v3.mo10379b(str, sb3.toString(), th);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1080c)) {
            return false;
        }
        C1080c cVar = (C1080c) obj;
        String str = this.f2190b;
        if (str != null) {
            z = str.equals(cVar.f2190b);
        } else if (cVar.f2190b != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f2190b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String a = C1277l.m3033a(32, this.f2190b);
        StringBuilder sb = new StringBuilder();
        sb.append("AdToken{id=");
        sb.append(a);
        sb.append(", type=");
        sb.append(mo9839b());
        sb.append('}');
        return sb.toString();
    }
}
