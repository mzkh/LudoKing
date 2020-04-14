package com.inmobi.media;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.inmobi.media.C2426eq.C2434h;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ag */
/* compiled from: AdFactory */
public final class C2158ag {

    /* renamed from: a */
    private static final String f4365a = C2153ac.class.getSimpleName();

    @Nullable
    /* renamed from: a */
    public static C2153ac m4281a(JSONObject jSONObject, String str, @NonNull String str2, C2276cf cfVar, long j) {
        long millis;
        C2153ac acVar;
        JSONObject jSONObject2 = jSONObject;
        C2276cf cfVar2 = cfVar;
        String str3 = "bidInfoEncrypted";
        String str4 = "bid";
        try {
            String string = jSONObject2.getString("markupType");
            String string2 = jSONObject2.getString("impressionId");
            String optString = jSONObject2.optString("adAuctionMeta");
            long optLong = jSONObject2.optLong("expiry", TimeUnit.MILLISECONDS.toSeconds(j));
            if (optLong <= 0) {
                millis = -1;
            } else {
                millis = TimeUnit.SECONDS.toMillis(optLong);
            }
            long j2 = millis;
            float parseFloat = jSONObject2.has(str4) ? Float.parseFloat(C2487fs.m5228a(C2524gn.m5380a(Base64.decode(jSONObject2.getString(str4), 0), cfVar2.f4781b, cfVar2.f4780a))) : 0.0f;
            String a = jSONObject2.has(str3) ? cfVar2.mo28107a(jSONObject2.getString(str3)) : null;
            char c = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1470802432) {
                if (hashCode != -1084172778) {
                    if (hashCode == 3213227) {
                        if (string.equals(String.HTML)) {
                            c = 2;
                        }
                    }
                } else if (string.equals("inmobiJson")) {
                    c = 3;
                }
            } else if (string.equals("mediationJson")) {
                c = 1;
            }
            if (c == 1 || c == 2) {
                C2153ac acVar2 = new C2153ac(jSONObject.toString(), null, str, false, j2, parseFloat, a, str2, optString, string2);
                acVar = acVar2;
            } else if (c != 3) {
                return null;
            } else {
                acVar = m4280a(jSONObject, str, j2, parseFloat, a, str2, optString, string2);
            }
            return acVar;
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    /* renamed from: a */
    private static C2153ac m4280a(JSONObject jSONObject, String str, long j, float f, String str2, String str3, String str4, String str5) {
        String str6 = "rootContainer";
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("pubContent");
            if (jSONObject2.isNull(str6)) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str6);
            JSONArray jSONArray = new JSONArray();
            for (String a : m4288e(jSONObject3)) {
                m4284a(jSONArray, a, 2);
            }
            for (String a2 : m4289f(jSONObject3)) {
                m4284a(jSONArray, a2, 1);
            }
            C2153ac acVar = new C2153ac(jSONObject.toString(), jSONArray.toString(), str, m4287d(jSONObject3), j, f, str2, str3, str4, str5);
            return acVar;
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    /* renamed from: a */
    public static C2153ac m4279a(@NonNull C2153ac acVar, @NonNull C2426eq eqVar) throws JSONException {
        if (!"inmobiJson".equals(acVar.mo27819j())) {
            return acVar;
        }
        JSONObject jSONObject = new JSONObject(acVar.mo27821l());
        String c = m4286c(jSONObject.getJSONObject("rootContainer"));
        if (c.trim().length() == 0) {
            return acVar;
        }
        C2296cq a = new C2290cn(eqVar.f5183j).mo28131a(c);
        JSONArray jSONArray = new JSONArray(acVar.mo27817h());
        if (a.f4846f != 0) {
            return null;
        }
        List<C2234bo> list = a.f4844d;
        JSONArray jSONArray2 = new JSONArray();
        for (C2234bo boVar : list) {
            jSONArray2.put(boVar.toString());
        }
        List<C2284ck> list2 = a.f4845e;
        JSONArray jSONArray3 = new JSONArray();
        for (C2284ck ckVar : list2) {
            jSONArray3.put(ckVar.toString());
        }
        String b = a.mo28138b();
        if (b == null || b.isEmpty()) {
            return null;
        }
        m4284a(jSONArray, b, 0);
        List<String> a2 = m4283a(jSONObject, eqVar.f5183j);
        a2.size();
        for (String a3 : a2) {
            m4284a(jSONArray, a3, 0);
        }
        try {
            for (String a4 : m4282a(jSONObject)) {
                m4284a(jSONArray, a4, 2);
            }
            for (String a5 : m4285b(jSONObject)) {
                m4284a(jSONArray, a5, 1);
            }
        } catch (Exception unused) {
        }
        String jSONArray4 = jSONArray.toString();
        String b2 = a.mo28138b();
        String str = a.f4842b;
        String str2 = a.f4843c;
        C2204at atVar = new C2204at(acVar, jSONArray4, b2, str, str2, jSONArray2.toString(), jSONArray3.toString());
        return atVar;
    }

    /* renamed from: a */
    private static void m4284a(JSONArray jSONArray, String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", i);
        jSONObject.put("url", str);
        jSONArray.put(jSONObject);
    }

    /* renamed from: a */
    private static List<String> m4283a(JSONObject jSONObject, C2434h hVar) {
        String str = "rootContainer";
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("pages");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!jSONArray.getJSONObject(i).isNull(str)) {
                    String c = m4286c(jSONArray.getJSONObject(i).getJSONObject(str));
                    if (c.trim().length() != 0) {
                        C2296cq a = new C2290cn(hVar).mo28131a(c);
                        if (a != null) {
                            if (a.f4846f == 0) {
                                String b = a.mo28138b();
                                if (b != null && !b.isEmpty()) {
                                    arrayList.add(b);
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m4282a(JSONObject jSONObject) {
        String str = "rootContainer";
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("pages");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!jSONArray.getJSONObject(i).isNull(str)) {
                    arrayList.addAll(m4288e(jSONArray.getJSONObject(i).getJSONObject(str)));
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    /* renamed from: b */
    private static List<String> m4285b(JSONObject jSONObject) {
        String str = "rootContainer";
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("pages");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!jSONArray.getJSONObject(i).isNull(str)) {
                    arrayList.addAll(m4289f(jSONArray.getJSONObject(i).getJSONObject(str)));
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: c */
    private static String m4286c(@NonNull JSONObject jSONObject) {
        String str = "";
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            if (jSONArray.length() == 0) {
                return str;
            }
            String string = jSONObject.getString("assetType");
            if ("video".equalsIgnoreCase(string)) {
                return jSONArray.getString(0);
            }
            if (!"container".equalsIgnoreCase(string)) {
                return str;
            }
            String str2 = str;
            for (int i = 0; i < jSONArray.length(); i++) {
                str2 = m4286c(jSONArray.getJSONObject(i));
                if (str2.trim().length() != 0) {
                    break;
                }
            }
            return str2;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return str;
        }
    }

    /* renamed from: d */
    private static boolean m4287d(@NonNull JSONObject jSONObject) {
        String str = "preload";
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            if (jSONArray.length() == 0) {
                return false;
            }
            String string = jSONObject.getString("assetType");
            if ("webview".equalsIgnoreCase(string)) {
                if (jSONObject.isNull(str) || !jSONObject.getBoolean(str)) {
                    return false;
                }
                return true;
            } else if (!"container".equalsIgnoreCase(string)) {
                return false;
            } else {
                boolean z = false;
                for (int i = 0; i < jSONArray.length(); i++) {
                    z = m4287d(jSONArray.getJSONObject(i));
                    if (z) {
                        break;
                    }
                }
                return z;
            }
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return false;
        }
    }

    @NonNull
    /* renamed from: e */
    private static List<String> m4288e(@NonNull JSONObject jSONObject) {
        String str = "preload";
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            if (jSONArray.length() == 0) {
                return arrayList;
            }
            String string = jSONObject.getString("assetType");
            if (MessengerShareContentUtility.MEDIA_IMAGE.equalsIgnoreCase(string)) {
                if (!jSONObject.isNull(str) && jSONObject.getBoolean(str)) {
                    arrayList.add(jSONArray.getString(0));
                }
                return arrayList;
            }
            if ("container".equalsIgnoreCase(string)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.addAll(m4288e(jSONArray.getJSONObject(i)));
                }
            }
            return arrayList;
        } catch (JSONException unused) {
        }
    }

    @NonNull
    /* renamed from: f */
    private static List<String> m4289f(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            if (jSONArray.length() == 0) {
                return arrayList;
            }
            String string = jSONObject.getString("assetType");
            if ("gif".equalsIgnoreCase(string)) {
                arrayList.add(jSONArray.getString(0));
                return arrayList;
            }
            if ("container".equalsIgnoreCase(string)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.addAll(m4289f(jSONArray.getJSONObject(i)));
                }
            }
            return arrayList;
        } catch (JSONException unused) {
        }
    }
}
