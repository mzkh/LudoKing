package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ac */
/* compiled from: Ad */
public class C2153ac {

    /* renamed from: b */
    private static final String f4318b = "ac";

    /* renamed from: a */
    String f4319a;
    @NonNull

    /* renamed from: c */
    private String f4320c = "unknown";

    /* renamed from: d */
    private final String f4321d;

    /* renamed from: e */
    private long f4322e;

    /* renamed from: f */
    private long f4323f;

    /* renamed from: g */
    private String f4324g;

    /* renamed from: h */
    private String f4325h;

    /* renamed from: i */
    private boolean f4326i;

    /* renamed from: j */
    private final float f4327j;
    @Nullable

    /* renamed from: k */
    private final String f4328k;

    /* renamed from: l */
    private String f4329l;

    /* renamed from: m */
    private String f4330m;

    /* renamed from: n */
    private final String f4331n;

    public C2153ac(String str, String str2, String str3, boolean z, long j, float f, @Nullable String str4, String str5, String str6, String str7) {
        this.f4319a = str;
        this.f4324g = str2;
        this.f4321d = str3;
        this.f4322e = System.currentTimeMillis();
        this.f4325h = "";
        this.f4326i = z;
        this.f4323f = j;
        this.f4327j = f;
        this.f4328k = str4;
        this.f4329l = str5;
        this.f4330m = str6;
        this.f4331n = str7;
        mo27932x();
    }

    C2153ac(@NonNull C2153ac acVar, String str) {
        this.f4319a = acVar.f4319a;
        this.f4324g = str;
        this.f4321d = acVar.f4321d;
        this.f4322e = acVar.f4322e;
        this.f4325h = acVar.f4325h;
        this.f4326i = acVar.f4326i;
        this.f4323f = acVar.f4323f;
        this.f4327j = acVar.f4327j;
        this.f4328k = acVar.f4328k;
        this.f4329l = acVar.f4329l;
        this.f4330m = acVar.f4330m;
        this.f4331n = acVar.mo27815f();
        mo27932x();
    }

    /* renamed from: a */
    public final String mo27807a() {
        return this.f4321d;
    }

    /* renamed from: b */
    public final String mo27811b() {
        return this.f4319a;
    }

    /* renamed from: c */
    public String mo27812c() {
        return this.f4325h;
    }

    /* renamed from: d */
    public boolean mo27813d() {
        return this.f4326i;
    }

    /* renamed from: e */
    public String mo27814e() {
        return this.f4329l;
    }

    @NonNull
    /* renamed from: f */
    public final String mo27815f() {
        return this.f4331n;
    }

    @NonNull
    /* renamed from: g */
    public JSONObject mo27816g() {
        try {
            return this.f4328k == null ? new JSONObject() : new JSONObject(this.f4328k);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    /* renamed from: w */
    private long mo27931w() {
        long j = this.f4323f;
        if (j == -1) {
            return -1;
        }
        return this.f4322e + j;
    }

    /* renamed from: a */
    public boolean mo27810a(long j) {
        long j2;
        if (mo27931w() == -1) {
            j2 = (this.f4322e + TimeUnit.SECONDS.toMillis(j)) - System.currentTimeMillis();
        } else {
            j2 = mo27931w() - System.currentTimeMillis();
        }
        return j2 < 0;
    }

    /* renamed from: h */
    public String mo27817h() {
        return this.f4324g;
    }

    @NonNull
    /* renamed from: i */
    public Set<C2206av> mo27818i() {
        HashSet hashSet = new HashSet();
        String str = this.f4324g;
        if (!(str == null || str.length() == 0)) {
            try {
                JSONArray jSONArray = new JSONArray(this.f4324g);
                if (jSONArray.length() == 0) {
                    return hashSet;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = new JSONObject(jSONArray.getString(i));
                    int i2 = jSONObject.getInt("type");
                    String string = jSONObject.getString("url");
                    if (string != null) {
                        hashSet.add(new C2206av(i2, string));
                    }
                }
                return hashSet;
            } catch (JSONException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
        return hashSet;
    }

    /* renamed from: x */
    private void mo27932x() {
        String str = "markupType";
        String str2 = "unknown";
        try {
            JSONObject jSONObject = new JSONObject(this.f4319a);
            if (jSONObject.isNull(str)) {
                this.f4320c = str2;
            }
            this.f4320c = jSONObject.getString(str);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            this.f4320c = str2;
        }
    }

    @NonNull
    /* renamed from: j */
    public final String mo27819j() {
        return this.f4320c;
    }

    /* renamed from: a */
    public void mo27808a(String str) {
        this.f4325h = str;
    }

    /* renamed from: k */
    public float mo27820k() {
        return this.f4327j;
    }

    @Nullable
    /* renamed from: l */
    public String mo27821l() throws JSONException {
        String str = "pubContent";
        if ("inmobiJson".equals(mo27819j())) {
            return new JSONObject(this.f4319a).getJSONObject(str).toString();
        }
        return new JSONObject(this.f4319a).getString(str).trim();
    }

    /* renamed from: m */
    public boolean mo27822m() {
        try {
            return new JSONObject(this.f4319a).optBoolean("canLoadBeforeShow", true);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return true;
        }
    }

    @Nullable
    /* renamed from: n */
    public JSONObject mo27823n() {
        try {
            return new JSONObject(this.f4319a).optJSONObject("cachedAdData");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    @Nullable
    /* renamed from: o */
    public JSONObject mo27824o() {
        try {
            return new JSONObject(this.f4319a).optJSONObject("transaction");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27809a(@Nullable JSONObject jSONObject) throws JSONException {
        String l = mo27821l();
        if (l != null) {
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    l = l.replace(str, jSONObject.getString(str));
                }
            }
            JSONObject jSONObject2 = new JSONObject(this.f4319a);
            String str2 = "pubContent";
            if ("inmobiJson".equals(mo27819j())) {
                jSONObject2.put(str2, new JSONObject(l));
            } else {
                jSONObject2.put(str2, l);
            }
            this.f4319a = jSONObject2.toString();
        }
    }

    @Nullable
    /* renamed from: p */
    public JSONArray mo27825p() {
        try {
            return new JSONObject(this.f4319a).optJSONArray("trackingEvents");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    @Nullable
    /* renamed from: q */
    public String mo27826q() {
        try {
            return new JSONObject(this.f4319a).optString("baseEventUrl", null);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    @Nullable
    /* renamed from: r */
    public Long mo27827r() {
        String str = "asPlcId";
        try {
            JSONObject jSONObject = new JSONObject(this.f4319a);
            if (jSONObject.has(str)) {
                return Long.valueOf(jSONObject.getLong(str));
            }
            return null;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    @Nullable
    /* renamed from: s */
    public String mo27828s() {
        try {
            return new JSONObject(this.f4319a).optString("adAuctionMeta", null);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    /* renamed from: t */
    public boolean mo27829t() {
        try {
            return new JSONObject(this.f4319a).optBoolean("applyBitmap");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return false;
        }
    }

    @Nullable
    /* renamed from: b */
    public static Map<String, String> m4242b(@NonNull JSONObject jSONObject) throws JSONException {
        String str = "rewards";
        if (!jSONObject.has(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        if (jSONObject2 != null) {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject2.getString(str2));
            }
        }
        return hashMap;
    }

    @Nullable
    /* renamed from: u */
    public Map<String, String> mo27830u() {
        try {
            return m4242b(new JSONObject(this.f4319a).getJSONObject("pubContent"));
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    @NonNull
    /* renamed from: v */
    public String mo27831v() {
        String str = "";
        try {
            return new JSONObject(this.f4319a).optString("creativeId", str);
        } catch (JSONException unused) {
            return str;
        }
    }
}
