package com.inmobi.media;

import androidx.annotation.Nullable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.er */
/* compiled from: Config */
public abstract class C2436er {

    /* renamed from: m */
    public C2437a f5243m = new C2437a();
    @Nullable

    /* renamed from: n */
    String f5244n;

    /* renamed from: com.inmobi.media.er$a */
    /* compiled from: Config */
    public static final class C2437a {

        /* renamed from: a */
        public HashMap<String, Boolean> f5245a = new HashMap<>();

        C2437a() {
            this.f5245a.put("O1", Boolean.TRUE);
            this.f5245a.put("UM5", Boolean.TRUE);
            this.f5245a.put("GPID", Boolean.TRUE);
            this.f5245a.put("SHA1_IMEI", Boolean.FALSE);
            this.f5245a.put("MD5_IMEI", Boolean.FALSE);
        }
    }

    /* renamed from: a */
    public abstract String mo28340a();

    /* renamed from: c */
    public abstract boolean mo28343c();

    public C2436er(@Nullable String str) {
        this.f5244n = str;
    }

    /* renamed from: a */
    public void mo28341a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("includeIds");
        for (int i = 0; i < jSONObject2.length(); i++) {
            String str = "O1";
            this.f5243m.f5245a.put(str, Boolean.valueOf(jSONObject2.getBoolean(str)));
            String str2 = "UM5";
            this.f5243m.f5245a.put(str2, Boolean.valueOf(jSONObject2.getBoolean(str2)));
            String str3 = "GPID";
            this.f5243m.f5245a.put(str3, Boolean.valueOf(jSONObject2.getBoolean(str3)));
            String str4 = "SHA1_IMEI";
            this.f5243m.f5245a.put(str4, Boolean.valueOf(jSONObject2.optBoolean(str4, false)));
            String str5 = "MD5_IMEI";
            this.f5243m.f5245a.put(str5, Boolean.valueOf(jSONObject2.optBoolean(str5, false)));
        }
    }

    /* renamed from: b */
    public JSONObject mo28342b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = "O1";
        jSONObject2.put(str, this.f5243m.f5245a.get(str));
        String str2 = "UM5";
        jSONObject2.put(str2, this.f5243m.f5245a.get(str2));
        String str3 = "GPID";
        jSONObject2.put(str3, this.f5243m.f5245a.get(str3));
        String str4 = "SHA1_IMEI";
        jSONObject2.put(str4, this.f5243m.f5245a.get(str4));
        String str5 = "MD5_IMEI";
        jSONObject2.put(str5, this.f5243m.f5245a.get(str5));
        jSONObject.put("includeIds", jSONObject2);
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r0.equals(r4.f5244n) != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.inmobi.media.C2436er
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.inmobi.media.er r4 = (com.inmobi.media.C2436er) r4
            java.lang.String r0 = r4.mo28340a()
            java.lang.String r2 = r3.mo28340a()
            boolean r0 = r0.equals(r2)
            r2 = 1
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r3.f5244n
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = r4.f5244n
            if (r0 != 0) goto L_0x0020
            goto L_0x002e
        L_0x0020:
            java.lang.String r0 = r3.f5244n
            if (r0 == 0) goto L_0x002d
            java.lang.String r4 = r4.f5244n
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2436er.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = mo28340a().hashCode();
        String str = this.f5244n;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.media.C2436er m5081a(java.lang.String r6, @androidx.annotation.Nullable java.lang.String r7) {
        /*
            int r0 = r6.hashCode()
            r1 = 6
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            switch(r0) {
                case -60641721: goto L_0x003f;
                case 3579: goto L_0x0035;
                case 96432: goto L_0x002b;
                case 3506402: goto L_0x0021;
                case 780346297: goto L_0x0017;
                case 2088265419: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "signals"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 5
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "telemetry"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 6
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "root"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 4
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "ads"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "pk"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 3
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "crashReporting"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 2
            goto L_0x004a
        L_0x0049:
            r6 = -1
        L_0x004a:
            if (r6 == r5) goto L_0x0072
            if (r6 == r4) goto L_0x006c
            if (r6 == r3) goto L_0x0066
            if (r6 == r2) goto L_0x0060
            if (r6 == r1) goto L_0x005a
            com.inmobi.media.eq r6 = new com.inmobi.media.eq
            r6.<init>(r7)
            goto L_0x0077
        L_0x005a:
            com.inmobi.media.fc r6 = new com.inmobi.media.fc
            r6.<init>(r7)
            goto L_0x0077
        L_0x0060:
            com.inmobi.media.fb r6 = new com.inmobi.media.fb
            r6.<init>(r7)
            goto L_0x0077
        L_0x0066:
            com.inmobi.media.fa r6 = new com.inmobi.media.fa
            r6.<init>(r7)
            goto L_0x0077
        L_0x006c:
            com.inmobi.media.ez r6 = new com.inmobi.media.ez
            r6.<init>(r7)
            goto L_0x0077
        L_0x0072:
            com.inmobi.media.ey r6 = new com.inmobi.media.ey
            r6.<init>(r7)
        L_0x0077:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2436er.m5081a(java.lang.String, java.lang.String):com.inmobi.media.er");
    }
}
