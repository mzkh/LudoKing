package com.inmobi.media;

import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.cd */
/* compiled from: OrientationProperties */
public class C2274cd {

    /* renamed from: e */
    private static String f4767e = "cd";

    /* renamed from: a */
    public boolean f4768a = true;

    /* renamed from: b */
    public String f4769b = "none";

    /* renamed from: c */
    public String f4770c = String.RIGHT;

    /* renamed from: d */
    public String f4771d = null;

    /* renamed from: a */
    public static C2274cd m4611a(String str, C2274cd cdVar) {
        String str2 = String.RIGHT;
        C2274cd cdVar2 = new C2274cd();
        cdVar2.f4771d = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cdVar2.f4769b = jSONObject.optString("forceOrientation", cdVar.f4769b);
            cdVar2.f4768a = jSONObject.optBoolean("allowOrientationChange", cdVar.f4768a);
            cdVar2.f4770c = jSONObject.optString("direction", cdVar.f4770c);
            if (!cdVar2.f4769b.equals(String.PORTRAIT) && !cdVar2.f4769b.equals(String.LANDSCAPE)) {
                cdVar2.f4769b = "none";
            }
            if (cdVar2.f4770c.equals("left") || cdVar2.f4770c.equals(str2)) {
                return cdVar2;
            }
            cdVar2.f4770c = str2;
            return cdVar2;
        } catch (JSONException unused) {
            return null;
        }
    }
}
