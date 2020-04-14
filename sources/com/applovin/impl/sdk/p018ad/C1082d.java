package com.applovin.impl.sdk.p018ad;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.d */
public final class C1082d {

    /* renamed from: a */
    private static final Map<String, C1082d> f2196a = new HashMap();

    /* renamed from: b */
    private static final Object f2197b = new Object();

    /* renamed from: c */
    private C1192i f2198c;

    /* renamed from: d */
    private C1227o f2199d;

    /* renamed from: e */
    private JSONObject f2200e;

    /* renamed from: f */
    private final String f2201f;

    /* renamed from: g */
    private String f2202g;

    /* renamed from: h */
    private AppLovinAdSize f2203h;

    /* renamed from: i */
    private AppLovinAdType f2204i;

    private C1082d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, C1192i iVar) {
        if (!TextUtils.isEmpty(str) || !(appLovinAdType == null || appLovinAdSize == null)) {
            this.f2198c = iVar;
            this.f2199d = iVar != null ? iVar.mo10249v() : null;
            this.f2203h = appLovinAdSize;
            this.f2204i = appLovinAdType;
            if (!TextUtils.isEmpty(str)) {
                this.f2201f = str.toLowerCase(Locale.ENGLISH);
                this.f2202g = str.toLowerCase(Locale.ENGLISH);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(appLovinAdSize.getLabel());
            sb.append("_");
            sb.append(appLovinAdType.getLabel());
            this.f2201f = sb.toString().toLowerCase(Locale.ENGLISH);
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type or size specified");
    }

    /* renamed from: a */
    public static C1082d m1996a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, C1192i iVar) {
        return m1997a(appLovinAdSize, appLovinAdType, null, iVar);
    }

    /* renamed from: a */
    public static C1082d m1997a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, C1192i iVar) {
        C1082d dVar = new C1082d(appLovinAdSize, appLovinAdType, str, iVar);
        synchronized (f2197b) {
            String str2 = dVar.f2201f;
            if (f2196a.containsKey(str2)) {
                dVar = (C1082d) f2196a.get(str2);
            } else {
                f2196a.put(str2, dVar);
            }
        }
        return dVar;
    }

    /* renamed from: a */
    public static C1082d m1998a(String str, C1192i iVar) {
        return m1997a(null, null, str, iVar);
    }

    /* renamed from: a */
    public static C1082d m1999a(String str, JSONObject jSONObject, C1192i iVar) {
        C1082d a = m1998a(str, iVar);
        a.f2200e = jSONObject;
        return a;
    }

    /* renamed from: a */
    private <ST> C1096c<ST> m2000a(String str, C1096c<ST> cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.f2201f);
        return this.f2198c.mo10201a(sb.toString(), cVar);
    }

    /* renamed from: a */
    private boolean m2001a(C1096c<String> cVar, AppLovinAdSize appLovinAdSize) {
        return ((String) this.f2198c.mo10202a(cVar)).toUpperCase(Locale.ENGLISH).contains(appLovinAdSize.getLabel());
    }

    /* renamed from: b */
    public static C1082d m2002b(String str, C1192i iVar) {
        return m1997a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, str, iVar);
    }

    /* renamed from: b */
    public static Collection<C1082d> m2003b(C1192i iVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(8);
        Collections.addAll(linkedHashSet, new C1082d[]{m2004c(iVar), m2006d(iVar), m2007e(iVar), m2008f(iVar), m2009g(iVar), m2010h(iVar)});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: c */
    public static C1082d m2004c(C1192i iVar) {
        return m1996a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR, iVar);
    }

    /* renamed from: c */
    public static C1082d m2005c(String str, C1192i iVar) {
        return m1997a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str, iVar);
    }

    /* renamed from: d */
    public static C1082d m2006d(C1192i iVar) {
        return m1996a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR, iVar);
    }

    /* renamed from: e */
    public static C1082d m2007e(C1192i iVar) {
        return m1996a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR, iVar);
    }

    /* renamed from: f */
    public static C1082d m2008f(C1192i iVar) {
        return m1996a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, iVar);
    }

    /* renamed from: g */
    public static C1082d m2009g(C1192i iVar) {
        return m1996a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, iVar);
    }

    /* renamed from: h */
    public static C1082d m2010h(C1192i iVar) {
        return m1996a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, iVar);
    }

    /* renamed from: k */
    private boolean m2011k() {
        try {
            if (!TextUtils.isEmpty(this.f2202g)) {
                return true;
            }
            return AppLovinAdType.INCENTIVIZED.equals(mo9849c()) ? ((Boolean) this.f2198c.mo10202a(C1096c.f2367bc)).booleanValue() : m2001a(C1096c.f2366bb, mo9848b());
        } catch (Throwable th) {
            this.f2199d.mo10379b("AdZone", "Unable to safely test preload merge capability", th);
            return false;
        }
    }

    /* renamed from: a */
    public String mo9846a() {
        return this.f2201f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9847a(C1192i iVar) {
        this.f2198c = iVar;
        this.f2199d = iVar.mo10249v();
    }

    /* renamed from: b */
    public AppLovinAdSize mo9848b() {
        if (this.f2203h == null) {
            String str = "ad_size";
            if (C1247h.m2983a(this.f2200e, str)) {
                this.f2203h = AppLovinAdSize.fromString(C1247h.m2985b(this.f2200e, str, (String) null, this.f2198c));
            }
        }
        return this.f2203h;
    }

    /* renamed from: c */
    public AppLovinAdType mo9849c() {
        if (this.f2204i == null) {
            JSONObject jSONObject = this.f2200e;
            String str = AppEventsConstants.EVENT_PARAM_AD_TYPE;
            if (C1247h.m2983a(jSONObject, str)) {
                this.f2204i = AppLovinAdType.fromString(C1247h.m2985b(this.f2200e, str, (String) null, this.f2198c));
            }
        }
        return this.f2204i;
    }

    /* renamed from: d */
    public boolean mo9850d() {
        return AppLovinAdSize.NATIVE.equals(mo9848b()) && AppLovinAdType.NATIVE.equals(mo9849c());
    }

    /* renamed from: e */
    public int mo9851e() {
        String str = "capacity";
        if (C1247h.m2983a(this.f2200e, str)) {
            return C1247h.m2984b(this.f2200e, str, 0, this.f2198c);
        }
        if (!TextUtils.isEmpty(this.f2202g)) {
            return mo9850d() ? ((Integer) this.f2198c.mo10202a(C1096c.f2382br)).intValue() : ((Integer) this.f2198c.mo10202a(C1096c.f2381bq)).intValue();
        }
        return ((Integer) this.f2198c.mo10202a(m2000a("preload_capacity_", C1096c.f2370bf))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2201f.equalsIgnoreCase(((C1082d) obj).f2201f);
    }

    /* renamed from: f */
    public int mo9853f() {
        String str = "extended_capacity";
        if (C1247h.m2983a(this.f2200e, str)) {
            return C1247h.m2984b(this.f2200e, str, 0, this.f2198c);
        }
        if (TextUtils.isEmpty(this.f2202g)) {
            return ((Integer) this.f2198c.mo10202a(m2000a("extended_preload_capacity_", C1096c.f2376bl))).intValue();
        } else if (mo9850d()) {
            return 0;
        } else {
            return ((Integer) this.f2198c.mo10202a(C1096c.f2383bs)).intValue();
        }
    }

    /* renamed from: g */
    public int mo9854g() {
        return C1247h.m2984b(this.f2200e, "preload_count", 0, this.f2198c);
    }

    /* renamed from: h */
    public boolean mo9855h() {
        boolean z = false;
        if (!((Boolean) this.f2198c.mo10202a(C1096c.f2365ba)).booleanValue() || !m2011k()) {
            return false;
        }
        if (TextUtils.isEmpty(this.f2202g)) {
            C1096c a = m2000a("preload_merge_init_tasks_", null);
            if (a != null && ((Boolean) this.f2198c.mo10202a(a)).booleanValue() && mo9851e() > 0) {
                z = true;
            }
            return z;
        } else if (this.f2200e != null && mo9854g() == 0) {
            return false;
        } else {
            String upperCase = ((String) this.f2198c.mo10202a(C1096c.f2366bb)).toUpperCase(Locale.ENGLISH);
            return (upperCase.contains(AppLovinAdSize.INTERSTITIAL.getLabel()) || upperCase.contains(AppLovinAdSize.BANNER.getLabel()) || upperCase.contains(AppLovinAdSize.MREC.getLabel()) || upperCase.contains(AppLovinAdSize.LEADER.getLabel())) ? ((Boolean) this.f2198c.mo10202a(C1096c.f2390bz)).booleanValue() : this.f2198c.mo10197W().mo9862a(this) && mo9854g() > 0 && ((Boolean) this.f2198c.mo10202a(C1096c.f2453dK)).booleanValue();
        }
    }

    public int hashCode() {
        return this.f2201f.hashCode();
    }

    /* renamed from: i */
    public boolean mo9857i() {
        String str = "wrapped_ads_enabled";
        return C1247h.m2983a(this.f2200e, str) ? C1247h.m2963a(this.f2200e, str, Boolean.valueOf(false), this.f2198c).booleanValue() : mo9848b() != null ? this.f2198c.mo10224b((C1096c) C1096c.f2417ca).contains(mo9848b().getLabel()) : ((Boolean) this.f2198c.mo10202a(C1096c.f2364bZ)).booleanValue();
    }

    /* renamed from: j */
    public boolean mo9858j() {
        return m2003b(this.f2198c).contains(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdZone{identifier=");
        sb.append(this.f2201f);
        sb.append(", zoneObject=");
        sb.append(this.f2200e);
        sb.append('}');
        return sb.toString();
    }
}
