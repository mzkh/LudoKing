package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1097d;
import com.applovin.impl.sdk.p019b.C1098e;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.g */
public class C1246g {

    /* renamed from: a */
    private static final int[] f3141a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f3142b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f3143c = {15, 12, 13};

    /* renamed from: a */
    public static String m2939a(InputStream inputStream, C1192i iVar) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[((Integer) iVar.mo10202a(C1096c.f2446dD)).intValue()];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            iVar.mo10249v().mo10379b("ConnectionUtils", "Encountered error while reading stream", th);
            return null;
        }
    }

    /* renamed from: a */
    public static String m2940a(String str, C1192i iVar) {
        return m2941a((String) iVar.mo10202a(C1096c.f2296aK), str, iVar);
    }

    /* renamed from: a */
    public static String m2941a(String str, String str2, C1192i iVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (iVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static JSONObject m2942a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    public static void m2943a(int i, C1192i iVar) {
        StringBuilder sb;
        String str;
        C1097d C = iVar.mo10178C();
        String str2 = "SDK key \"";
        String str3 = "AppLovinSdk";
        if (i == 401) {
            String str4 = "";
            C.mo9953a(C1096c.f2277S, (Object) str4);
            C.mo9953a(C1096c.f2278T, (Object) str4);
            C.mo9952a();
            sb = new StringBuilder();
            sb.append(str2);
            sb.append(iVar.mo10246t());
            str = "\" is rejected by AppLovin. Please make sure the SDK key is correct.";
        } else if (i == 418) {
            C.mo9953a(C1096c.f2276R, (Object) Boolean.valueOf(true));
            C.mo9952a();
            sb = new StringBuilder();
            sb.append(str2);
            sb.append(iVar.mo10246t());
            str = "\" has been blocked. Please contact AppLovin support at support@applovin.com.";
        } else if ((i >= 400 && i < 500) || i == -1) {
            iVar.mo10232f();
            return;
        } else {
            return;
        }
        sb.append(str);
        C1227o.m2841i(str3, sb.toString());
    }

    /* renamed from: a */
    public static void m2944a(JSONObject jSONObject, boolean z, C1192i iVar) {
        iVar.mo10219ac().mo10160a(jSONObject, z);
    }

    /* renamed from: a */
    public static boolean m2945a() {
        return m2948a((String) null);
    }

    /* renamed from: a */
    private static boolean m2946a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2947a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo b = m2949b(context);
        if (b != null) {
            return b.isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2948a(String str) {
        if (C1245f.m2936g()) {
            return (!C1245f.m2937h() || TextUtils.isEmpty(str)) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        return true;
    }

    /* renamed from: b */
    private static NetworkInfo m2949b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: b */
    public static String m2950b(String str, C1192i iVar) {
        return m2941a((String) iVar.mo10202a(C1096c.f2297aL), str, iVar);
    }

    /* renamed from: c */
    public static void m2951c(JSONObject jSONObject, C1192i iVar) {
        String b = C1247h.m2985b(jSONObject, "persisted_data", (String) null, iVar);
        if (C1277l.m3042b(b)) {
            iVar.mo10209a(C1098e.f2578x, b);
            iVar.mo10249v().mo10380c("ConnectionUtils", "Updated persisted data");
        }
    }

    /* renamed from: d */
    public static void m2952d(JSONObject jSONObject, C1192i iVar) {
        String str = "ConnectionUtils";
        String str2 = "settings";
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (iVar != null) {
            try {
                if (jSONObject.has(str2)) {
                    C1097d C = iVar.mo10178C();
                    if (!jSONObject.isNull(str2)) {
                        C.mo9955a(jSONObject.getJSONObject(str2));
                        C.mo9952a();
                        iVar.mo10249v().mo10378b(str, "New settings processed");
                    }
                }
            } catch (JSONException e) {
                iVar.mo10249v().mo10379b(str, "Unable to parse settings out of API response", e);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: e */
    public static Map<String, String> m2953e(C1192i iVar) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = (String) iVar.mo10202a(C1096c.f2278T);
        if (C1277l.m3042b(str2)) {
            str = "device_token";
        } else {
            if (!((Boolean) iVar.mo10202a(C1096c.f2507eM)).booleanValue()) {
                str2 = iVar.mo10246t();
                str = TapjoyConstants.TJC_API_KEY;
            }
            hashMap.put("sc", C1277l.m3044d((String) iVar.mo10202a(C1096c.f2280V)));
            hashMap.put("sc2", C1277l.m3044d((String) iVar.mo10202a(C1096c.f2281W)));
            hashMap.put("server_installed_at", C1277l.m3044d((String) iVar.mo10202a(C1096c.f2282X)));
            C1281o.m3085a("persisted_data", C1277l.m3044d((String) iVar.mo10203a(C1098e.f2578x)), (Map<String, String>) hashMap);
            return hashMap;
        }
        hashMap.put(str, str2);
        hashMap.put("sc", C1277l.m3044d((String) iVar.mo10202a(C1096c.f2280V)));
        hashMap.put("sc2", C1277l.m3044d((String) iVar.mo10202a(C1096c.f2281W)));
        hashMap.put("server_installed_at", C1277l.m3044d((String) iVar.mo10202a(C1096c.f2282X)));
        C1281o.m3085a("persisted_data", C1277l.m3044d((String) iVar.mo10203a(C1098e.f2578x)), (Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: e */
    public static void m2954e(JSONObject jSONObject, C1192i iVar) {
        JSONArray b = C1247h.m2988b(jSONObject, "zones", (JSONArray) null, iVar);
        if (b != null) {
            Iterator it = iVar.mo10197W().mo9861a(b).iterator();
            while (it.hasNext()) {
                C1082d dVar = (C1082d) it.next();
                if (dVar.mo9850d()) {
                    iVar.mo10242p().preloadAds(dVar);
                } else {
                    iVar.mo10241o().preloadAds(dVar);
                }
            }
            iVar.mo10194T().mo9977a(iVar.mo10197W().mo9860a());
            iVar.mo10195U().mo9977a(iVar.mo10197W().mo9860a());
        }
    }

    /* renamed from: f */
    public static String m2955f(C1192i iVar) {
        NetworkInfo b = m2949b(iVar.mo10179D());
        String str = "unknown";
        if (b == null) {
            return str;
        }
        int type = b.getType();
        int subtype = b.getSubtype();
        return type == 1 ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : type == 0 ? m2946a(subtype, f3141a) ? "2g" : m2946a(subtype, f3142b) ? "3g" : m2946a(subtype, f3143c) ? "4g" : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE : str;
    }

    /* renamed from: f */
    public static void m2956f(JSONObject jSONObject, C1192i iVar) {
        JSONObject b = C1247h.m2989b(jSONObject, "variables", (JSONObject) null, iVar);
        if (b != null) {
            iVar.mo10245s().updateVariables(b);
        }
    }

    /* renamed from: g */
    public static String m2957g(C1192i iVar) {
        return m2941a((String) iVar.mo10202a(C1096c.f2294aI), "4.0/ad", iVar);
    }

    /* renamed from: h */
    public static String m2958h(C1192i iVar) {
        return m2941a((String) iVar.mo10202a(C1096c.f2295aJ), "4.0/ad", iVar);
    }

    /* renamed from: i */
    public static String m2959i(C1192i iVar) {
        return m2941a((String) iVar.mo10202a(C1096c.f2300aO), "1.0/variable_config", iVar);
    }

    /* renamed from: j */
    public static String m2960j(C1192i iVar) {
        return m2941a((String) iVar.mo10202a(C1096c.f2301aP), "1.0/variable_config", iVar);
    }
}
