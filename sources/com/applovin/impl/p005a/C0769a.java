package com.applovin.impl.p005a;

import android.net.Uri;
import com.applovin.impl.p005a.C0783j.C0785a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1101a;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.a */
public class C0769a extends C1084f {

    /* renamed from: a */
    private final String f1219a;

    /* renamed from: b */
    private final String f1220b;

    /* renamed from: c */
    private final C0779f f1221c;

    /* renamed from: d */
    private final long f1222d;

    /* renamed from: e */
    private final C0783j f1223e;

    /* renamed from: f */
    private final C0774b f1224f;

    /* renamed from: g */
    private final Set<C0780g> f1225g;

    /* renamed from: h */
    private final Set<C0780g> f1226h;

    /* renamed from: com.applovin.impl.a.a$a */
    public static class C0771a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public JSONObject f1227a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public JSONObject f1228b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C1079b f1229c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C1192i f1230d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f1231e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f1232f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public String f1233g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public C0779f f1234h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public C0783j f1235i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public C0774b f1236j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public Set<C0780g> f1237k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public Set<C0780g> f1238l;

        private C0771a() {
        }

        /* renamed from: a */
        public C0771a mo8900a(long j) {
            this.f1231e = j;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8901a(C0774b bVar) {
            this.f1236j = bVar;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8902a(C0779f fVar) {
            this.f1234h = fVar;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8903a(C0783j jVar) {
            this.f1235i = jVar;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8904a(C1079b bVar) {
            this.f1229c = bVar;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8905a(C1192i iVar) {
            if (iVar != null) {
                this.f1230d = iVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        /* renamed from: a */
        public C0771a mo8906a(String str) {
            this.f1232f = str;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8907a(Set<C0780g> set) {
            this.f1237k = set;
            return this;
        }

        /* renamed from: a */
        public C0771a mo8908a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f1227a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        /* renamed from: a */
        public C0769a mo8909a() {
            return new C0769a(this);
        }

        /* renamed from: b */
        public C0771a mo8910b(String str) {
            this.f1233g = str;
            return this;
        }

        /* renamed from: b */
        public C0771a mo8911b(Set<C0780g> set) {
            this.f1238l = set;
            return this;
        }

        /* renamed from: b */
        public C0771a mo8912b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f1228b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    /* renamed from: com.applovin.impl.a.a$b */
    public enum C0772b {
        COMPANION_AD,
        VIDEO
    }

    /* renamed from: com.applovin.impl.a.a$c */
    public enum C0773c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    private C0769a(C0771a aVar) {
        super(aVar.f1227a, aVar.f1228b, aVar.f1229c, aVar.f1230d);
        this.f1219a = aVar.f1232f;
        this.f1221c = aVar.f1234h;
        this.f1220b = aVar.f1233g;
        this.f1223e = aVar.f1235i;
        this.f1224f = aVar.f1236j;
        this.f1225g = aVar.f1237k;
        this.f1226h = aVar.f1238l;
        this.f1222d = aVar.f1231e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<com.applovin.impl.p005a.C0780g> m993a(com.applovin.impl.p005a.C0769a.C0772b r6, java.lang.String[] r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x0049
            int r0 = r7.length
            if (r0 <= 0) goto L_0x0049
            r0 = 0
            com.applovin.impl.a.a$b r1 = com.applovin.impl.p005a.C0769a.C0772b.VIDEO
            if (r6 != r1) goto L_0x0013
            com.applovin.impl.a.j r1 = r5.f1223e
            if (r1 == 0) goto L_0x0013
            java.util.Map r0 = r1.mo8952e()
            goto L_0x001f
        L_0x0013:
            com.applovin.impl.a.a$b r1 = com.applovin.impl.p005a.C0769a.C0772b.COMPANION_AD
            if (r6 != r1) goto L_0x001f
            com.applovin.impl.a.b r6 = r5.f1224f
            if (r6 == 0) goto L_0x001f
            java.util.Map r0 = r6.mo8916d()
        L_0x001f:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            if (r0 == 0) goto L_0x0044
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0044
            int r1 = r7.length
            r2 = 0
        L_0x002e:
            if (r2 >= r1) goto L_0x0044
            r3 = r7[r2]
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0041
            java.lang.Object r3 = r0.get(r3)
            java.util.Collection r3 = (java.util.Collection) r3
            r6.addAll(r3)
        L_0x0041:
            int r2 = r2 + 1
            goto L_0x002e
        L_0x0044:
            java.util.Set r6 = java.util.Collections.unmodifiableSet(r6)
            return r6
        L_0x0049:
            java.util.Set r6 = java.util.Collections.emptySet()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p005a.C0769a.m993a(com.applovin.impl.a.a$b, java.lang.String[]):java.util.Set");
    }

    /* renamed from: aH */
    public static C0771a m994aH() {
        return new C0771a();
    }

    /* renamed from: aI */
    private String m995aI() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject == null) {
            return null;
        }
        return stringFromAdObject.replace("{CLCODE}", getClCode());
    }

    /* renamed from: aJ */
    private C0785a m996aJ() {
        C0785a[] values = C0785a.values();
        int intValue = ((Integer) this.sdk.mo10202a(C1096c.f2504eJ)).intValue();
        return (intValue < 0 || intValue >= values.length) ? C0785a.UNSPECIFIED : values[intValue];
    }

    /* renamed from: aK */
    private Set<C0780g> m997aK() {
        C0783j jVar = this.f1223e;
        return jVar != null ? jVar.mo8951d() : Collections.emptySet();
    }

    /* renamed from: aL */
    private Set<C0780g> m998aL() {
        C0774b bVar = this.f1224f;
        return bVar != null ? bVar.mo8915c() : Collections.emptySet();
    }

    /* renamed from: a */
    public Set<C0780g> mo8875a(C0773c cVar, String str) {
        return mo8876a(cVar, new String[]{str});
    }

    /* renamed from: a */
    public Set<C0780g> mo8876a(C0773c cVar, String[] strArr) {
        C1227o v = this.sdk.mo10249v();
        StringBuilder sb = new StringBuilder();
        sb.append("Retrieving trackers of type '");
        sb.append(cVar);
        String str = "' and events '";
        sb.append(str);
        sb.append(strArr);
        sb.append("'...");
        String str2 = "VastAd";
        v.mo10378b(str2, sb.toString());
        if (cVar == C0773c.IMPRESSION) {
            return this.f1225g;
        }
        if (cVar == C0773c.VIDEO_CLICK) {
            return m997aK();
        }
        if (cVar == C0773c.COMPANION_CLICK) {
            return m998aL();
        }
        if (cVar == C0773c.VIDEO) {
            return m993a(C0772b.VIDEO, strArr);
        }
        if (cVar == C0773c.COMPANION) {
            return m993a(C0772b.COMPANION_AD, strArr);
        }
        if (cVar == C0773c.ERROR) {
            return this.f1226h;
        }
        C1227o v2 = this.sdk.mo10249v();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to retrieve trackers of invalid type '");
        sb2.append(cVar);
        sb2.append(str);
        sb2.append(strArr);
        sb2.append("'");
        v2.mo10382e(str2, sb2.toString());
        return Collections.emptySet();
    }

    /* renamed from: a */
    public void mo8877a(String str) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_template", str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean mo8878a() {
        return mo8884b();
    }

    /* renamed from: aD */
    public String mo8879aD() {
        return getStringFromAdObject("html_template", "");
    }

    /* renamed from: aE */
    public Uri mo8880aE() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", null);
        if (C1277l.m3042b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aF */
    public boolean mo8881aF() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.valueOf(true));
    }

    /* renamed from: aG */
    public boolean mo8882aG() {
        return getBooleanFromAdObject("cache_video", Boolean.valueOf(true));
    }

    /* renamed from: an */
    public List<C1101a> mo8883an() {
        List<C1101a> a;
        synchronized (this.adObjectLock) {
            a = C1281o.m3078a("vimp_urls", this.adObject, getClCode(), m995aI(), this.sdk);
        }
        return a;
    }

    /* renamed from: b */
    public boolean mo8884b() {
        String str = "vast_is_streaming";
        boolean z = false;
        if (containsKeyForAdObject(str)) {
            return getBooleanFromAdObject(str, Boolean.valueOf(false));
        }
        C0786k i = mo8895i();
        if (i != null && i.mo8961c()) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public C0772b mo8885c() {
        String str = "companion_ad";
        return str.equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", str)) ? C0772b.COMPANION_AD : C0772b.VIDEO;
    }

    /* renamed from: d */
    public Uri mo8886d() {
        C0786k i = mo8895i();
        if (i != null) {
            return i.mo8960b();
        }
        return null;
    }

    /* renamed from: e */
    public boolean mo8887e() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.valueOf(true));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0769a) || !super.equals(obj)) {
            return false;
        }
        C0769a aVar = (C0769a) obj;
        String str = this.f1219a;
        if (str == null ? aVar.f1219a != null : !str.equals(aVar.f1219a)) {
            return false;
        }
        String str2 = this.f1220b;
        if (str2 == null ? aVar.f1220b != null : !str2.equals(aVar.f1220b)) {
            return false;
        }
        C0779f fVar = this.f1221c;
        if (fVar == null ? aVar.f1221c != null : !fVar.equals(aVar.f1221c)) {
            return false;
        }
        C0783j jVar = this.f1223e;
        if (jVar == null ? aVar.f1223e != null : !jVar.equals(aVar.f1223e)) {
            return false;
        }
        C0774b bVar = this.f1224f;
        if (bVar == null ? aVar.f1224f != null : !bVar.equals(aVar.f1224f)) {
            return false;
        }
        Set<C0780g> set = this.f1225g;
        if (set == null ? aVar.f1225g != null : !set.equals(aVar.f1225g)) {
            return false;
        }
        Set<C0780g> set2 = this.f1226h;
        if (set2 != null) {
            z = set2.equals(aVar.f1226h);
        } else if (aVar.f1226h != null) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public Uri mo8889f() {
        C0783j jVar = this.f1223e;
        if (jVar != null) {
            return jVar.mo8950c();
        }
        return null;
    }

    /* renamed from: g */
    public Uri mo8890g() {
        return mo8889f();
    }

    public long getCreatedAtMillis() {
        return this.f1222d;
    }

    /* renamed from: h */
    public C0783j mo8892h() {
        return this.f1223e;
    }

    public boolean hasVideoUrl() {
        C0783j jVar = this.f1223e;
        if (jVar == null) {
            return false;
        }
        List a = jVar.mo8948a();
        return a != null && a.size() > 0;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f1219a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f1220b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        C0779f fVar = this.f1221c;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        C0783j jVar = this.f1223e;
        int hashCode5 = (hashCode4 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        C0774b bVar = this.f1224f;
        int hashCode6 = (hashCode5 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        Set<C0780g> set = this.f1225g;
        int hashCode7 = (hashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        Set<C0780g> set2 = this.f1226h;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode7 + i;
    }

    /* renamed from: i */
    public C0786k mo8895i() {
        C0783j jVar = this.f1223e;
        if (jVar != null) {
            return jVar.mo8947a(m996aJ());
        }
        return null;
    }

    /* renamed from: j */
    public C0774b mo8896j() {
        return this.f1224f;
    }

    /* renamed from: k */
    public boolean mo8897k() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.valueOf(false));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastAd{title='");
        sb.append(this.f1219a);
        sb.append('\'');
        sb.append(", adDescription='");
        sb.append(this.f1220b);
        sb.append('\'');
        sb.append(", systemInfo=");
        sb.append(this.f1221c);
        sb.append(", videoCreative=");
        sb.append(this.f1223e);
        sb.append(", companionAd=");
        sb.append(this.f1224f);
        sb.append(", impressionTrackers=");
        sb.append(this.f1225g);
        sb.append(", errorTrackers=");
        sb.append(this.f1226h);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: u */
    public boolean mo8899u() {
        return mo8889f() != null;
    }
}
