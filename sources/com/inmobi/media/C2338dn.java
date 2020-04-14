package com.inmobi.media;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.dn */
/* compiled from: OmidNativeTracker */
public final class C2338dn extends C2234bo {

    /* renamed from: i */
    private static final String f4955i = "dn";

    /* renamed from: g */
    public final String f4956g;

    /* renamed from: h */
    public final String f4957h;

    public C2338dn(String str, String str2, String str3, String str4, Map<String, String> map) {
        super(str3, 0, str4, map);
        this.f4957h = str;
        this.f4956g = str2;
    }

    private C2338dn(String str, String str2, String str3, String str4, int i, String str5, Map<String, String> map) {
        super(str, str4, i, str5, map);
        this.f4957h = str2;
        this.f4956g = str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        if (r0 == 2) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r0 == 3) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        if (r0 == 4) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        r1 = r2;
     */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.media.C2234bo m4842a(org.json.JSONObject r10) {
        /*
            java.lang.String r0 = "type"
            java.lang.String r0 = r10.getString(r0)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r1 = "webview_ping"
            java.lang.String r2 = "url_ping"
            java.lang.String r3 = "html_script"
            r4 = -1
            java.lang.String r5 = "unknown"
            if (r0 == 0) goto L_0x0055
            int r6 = r0.length()     // Catch:{ JSONException -> 0x0098 }
            if (r6 != 0) goto L_0x0018
            goto L_0x0055
        L_0x0018:
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = r0.toLowerCase(r6)     // Catch:{ JSONException -> 0x0098 }
            int r6 = r0.hashCode()     // Catch:{ JSONException -> 0x0098 }
            r7 = 4
            r8 = 3
            r9 = 2
            switch(r6) {
                case -1918378017: goto L_0x0041;
                case -970292670: goto L_0x0039;
                case -284840886: goto L_0x0031;
                case 2015859192: goto L_0x0029;
                default: goto L_0x0028;
            }     // Catch:{ JSONException -> 0x0098 }
        L_0x0028:
            goto L_0x0049
        L_0x0029:
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x0098 }
            if (r0 == 0) goto L_0x0049
            r0 = 4
            goto L_0x004a
        L_0x0031:
            boolean r0 = r0.equals(r5)     // Catch:{ JSONException -> 0x0098 }
            if (r0 == 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x0039:
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x0098 }
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x004a
        L_0x0041:
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0098 }
            if (r0 == 0) goto L_0x0049
            r0 = 3
            goto L_0x004a
        L_0x0049:
            r0 = -1
        L_0x004a:
            if (r0 == r9) goto L_0x0053
            if (r0 == r8) goto L_0x0051
            if (r0 == r7) goto L_0x0056
            goto L_0x0055
        L_0x0051:
            r1 = r3
            goto L_0x0056
        L_0x0053:
            r1 = r2
            goto L_0x0056
        L_0x0055:
            r1 = r5
        L_0x0056:
            java.lang.String r0 = "eventType"
            java.lang.String r0 = r10.getString(r0)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r6 = m4553a(r0)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "url"
            java.lang.String r5 = r10.getString(r0)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "eventId"
            int r7 = r10.optInt(r0, r4)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "vendorKey"
            java.lang.String r2 = r10.optString(r0)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "verificationParams"
            java.lang.String r3 = r10.optString(r0)     // Catch:{ JSONException -> 0x0098 }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ JSONException -> 0x0098 }
            r10.<init>()     // Catch:{ JSONException -> 0x0098 }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0098 }
            if (r0 != 0) goto L_0x008d
            com.inmobi.media.dn r8 = new com.inmobi.media.dn     // Catch:{ JSONException -> 0x0098 }
            r0 = r8
            r4 = r5
            r5 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x0098 }
            return r8
        L_0x008d:
            com.inmobi.media.bo r8 = new com.inmobi.media.bo     // Catch:{ JSONException -> 0x0098 }
            r0 = r8
            r2 = r5
            r3 = r7
            r4 = r6
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ JSONException -> 0x0098 }
            return r8
        L_0x0098:
            r10 = move-exception
            com.inmobi.media.fd r0 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r1 = new com.inmobi.media.fz
            r1.<init>(r10)
            r0.mo28382a(r1)
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2338dn.m4842a(org.json.JSONObject):com.inmobi.media.bo");
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f4628a);
            jSONObject.put("url", this.f4629b);
            jSONObject.put("eventType", this.f4631d);
            jSONObject.put("eventId", this.f4630c);
            if (!TextUtils.isEmpty(this.f4957h)) {
                jSONObject.put("vendorKey", this.f4957h);
            }
            if (!TextUtils.isEmpty(this.f4956g)) {
                jSONObject.put("verificationParams", this.f4956g);
            }
            Map map = this.f4632e;
            String str = "extras";
            if (map == null) {
                map = new HashMap();
            }
            jSONObject.put(str, C2515gi.m5348a(map, ","));
            return jSONObject.toString();
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }
}
