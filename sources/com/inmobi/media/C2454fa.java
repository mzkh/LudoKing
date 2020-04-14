package com.inmobi.media;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fa */
/* compiled from: RootConfig */
public final class C2454fa extends C2436er {

    /* renamed from: h */
    private static final Object f5298h = new Object();

    /* renamed from: a */
    int f5299a = 3;

    /* renamed from: b */
    int f5300b = 60;

    /* renamed from: c */
    int f5301c = 3;

    /* renamed from: d */
    public int f5302d = -1;

    /* renamed from: e */
    C2456b f5303e = new C2456b();

    /* renamed from: f */
    public boolean f5304f = false;

    /* renamed from: g */
    private List<C2455a> f5305g = new ArrayList();

    /* renamed from: com.inmobi.media.fa$a */
    /* compiled from: RootConfig */
    static final class C2455a {

        /* renamed from: a */
        String f5306a;

        /* renamed from: b */
        long f5307b;

        /* renamed from: c */
        String f5308c;

        /* renamed from: d */
        String f5309d;

        /* renamed from: e */
        String f5310e = "https://config.inmobi.com/config-server/v1/config/secure.cfg";

        C2455a() {
        }
    }

    /* renamed from: com.inmobi.media.fa$b */
    /* compiled from: RootConfig */
    public static final class C2456b {

        /* renamed from: a */
        String f5311a = C2506ge.m5320b();

        /* renamed from: b */
        String f5312b = C2506ge.m5324e();
    }

    /* renamed from: a */
    public final String mo28340a() {
        return "root";
    }

    C2454fa(@Nullable String str) {
        super(str);
    }

    /* renamed from: b */
    public final JSONObject mo28342b() throws JSONException {
        boolean z;
        JSONObject b = super.mo28342b();
        JSONArray jSONArray = new JSONArray();
        b.put("maxRetries", this.f5299a);
        b.put("retryInterval", this.f5300b);
        b.put("waitTime", this.f5301c);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", this.f5303e.f5311a);
        jSONObject.put("url", this.f5303e.f5312b);
        b.put("latestSdkInfo", jSONObject);
        synchronized (f5298h) {
            z = false;
            for (int i = 0; i < this.f5305g.size(); i++) {
                C2455a aVar = (C2455a) this.f5305g.get(i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", aVar.f5306a);
                jSONObject2.put("expiry", aVar.f5307b);
                jSONObject2.put("protocol", aVar.f5308c);
                jSONObject2.put("url", aVar.f5309d);
                if ("root".equals(aVar.f5306a)) {
                    jSONObject2.put("fallbackUrl", aVar.f5310e);
                }
                jSONArray.put(jSONObject2);
            }
        }
        b.put("components", jSONArray);
        b.put("monetizationDisabled", this.f5304f);
        JSONObject jSONObject3 = new JSONObject();
        if (this.f5302d == 1) {
            z = true;
        }
        jSONObject3.put("transmitRequest", z);
        b.put("gdpr", jSONObject3);
        return b;
    }

    /* renamed from: a */
    public final void mo28341a(JSONObject jSONObject) throws JSONException {
        super.mo28341a(jSONObject);
        this.f5299a = jSONObject.getInt("maxRetries");
        this.f5300b = jSONObject.getInt("retryInterval");
        this.f5301c = jSONObject.getInt("waitTime");
        JSONObject jSONObject2 = jSONObject.getJSONObject("latestSdkInfo");
        this.f5303e.f5311a = jSONObject2.getString("version");
        this.f5303e.f5312b = jSONObject2.getString("url");
        JSONArray jSONArray = jSONObject.getJSONArray("components");
        synchronized (f5298h) {
            this.f5305g.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                C2455a aVar = new C2455a();
                aVar.f5306a = jSONObject3.getString("type");
                aVar.f5307b = jSONObject3.getLong("expiry");
                aVar.f5308c = jSONObject3.getString("protocol");
                aVar.f5309d = jSONObject3.getString("url");
                if ("root".equals(aVar.f5306a)) {
                    aVar.f5310e = jSONObject3.getString("fallbackUrl");
                }
                this.f5305g.add(aVar);
            }
        }
        this.f5304f = jSONObject.getBoolean("monetizationDisabled");
        this.f5302d = jSONObject.getJSONObject("gdpr").getBoolean("transmitRequest") ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a5, code lost:
        if (r9.f5302d == -1) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a9, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo28343c() {
        /*
            r9 = this;
            java.util.List<com.inmobi.media.fa$a> r0 = r9.f5305g
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.f5299a
            if (r0 < 0) goto L_0x00ad
            int r0 = r9.f5300b
            if (r0 < 0) goto L_0x00ad
            int r0 = r9.f5301c
            if (r0 >= 0) goto L_0x0014
            goto L_0x00ad
        L_0x0014:
            com.inmobi.media.fa$b r0 = r9.f5303e
            java.lang.String r0 = r0.f5311a
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x00ad
            com.inmobi.media.fa$b r0 = r9.f5303e
            java.lang.String r0 = r0.f5312b
            java.lang.String r2 = "http://"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x003c
            com.inmobi.media.fa$b r0 = r9.f5303e
            java.lang.String r0 = r0.f5312b
            java.lang.String r2 = "https://"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x003c
            goto L_0x00ad
        L_0x003c:
            java.lang.Object r0 = f5298h
            monitor-enter(r0)
            r2 = 0
        L_0x0040:
            java.util.List<com.inmobi.media.fa$a> r3 = r9.f5305g     // Catch:{ all -> 0x00aa }
            int r3 = r3.size()     // Catch:{ all -> 0x00aa }
            if (r2 >= r3) goto L_0x00a1
            java.util.List<com.inmobi.media.fa$a> r3 = r9.f5305g     // Catch:{ all -> 0x00aa }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00aa }
            com.inmobi.media.fa$a r3 = (com.inmobi.media.C2454fa.C2455a) r3     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r3.f5306a     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00aa }
            int r4 = r4.length()     // Catch:{ all -> 0x00aa }
            if (r4 != 0) goto L_0x005e
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            return r1
        L_0x005e:
            long r4 = r3.f5307b     // Catch:{ all -> 0x00aa }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x009f
            long r4 = r3.f5307b     // Catch:{ all -> 0x00aa }
            r6 = 864000(0xd2f00, double:4.268727E-318)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0070
            goto L_0x009f
        L_0x0070:
            java.lang.String r4 = r3.f5308c     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00aa }
            int r4 = r4.length()     // Catch:{ all -> 0x00aa }
            if (r4 != 0) goto L_0x007e
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            return r1
        L_0x007e:
            java.lang.String r4 = r3.f5309d     // Catch:{ all -> 0x00aa }
            boolean r4 = m5142c(r4)     // Catch:{ all -> 0x00aa }
            if (r4 == 0) goto L_0x0088
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            return r1
        L_0x0088:
            java.lang.String r4 = "root"
            java.lang.String r5 = r3.f5306a     // Catch:{ all -> 0x00aa }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00aa }
            if (r4 == 0) goto L_0x009c
            java.lang.String r3 = r3.f5310e     // Catch:{ all -> 0x00aa }
            boolean r3 = m5142c(r3)     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x009c
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            return r1
        L_0x009c:
            int r2 = r2 + 1
            goto L_0x0040
        L_0x009f:
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            return r1
        L_0x00a1:
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            int r0 = r9.f5302d
            r2 = -1
            if (r0 == r2) goto L_0x00a9
            r0 = 1
            return r0
        L_0x00a9:
            return r1
        L_0x00aa:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00aa }
            throw r1
        L_0x00ad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2454fa.mo28343c():boolean");
    }

    /* renamed from: c */
    private static boolean m5142c(String str) {
        return str == null || str.trim().length() == 0 || (!str.startsWith("http://") && !str.startsWith("https://"));
    }

    /* renamed from: a */
    public final long mo28377a(String str) {
        synchronized (f5298h) {
            for (int i = 0; i < this.f5305g.size(); i++) {
                C2455a aVar = (C2455a) this.f5305g.get(i);
                if (str.equals(aVar.f5306a)) {
                    long j = aVar.f5307b;
                    return j;
                }
            }
            return 86400;
        }
    }

    /* renamed from: b */
    public final String mo28378b(String str) {
        synchronized (f5298h) {
            for (int i = 0; i < this.f5305g.size(); i++) {
                C2455a aVar = (C2455a) this.f5305g.get(i);
                if (str.equals(aVar.f5306a)) {
                    String str2 = aVar.f5309d;
                    return str2;
                }
            }
            String str3 = "";
            return str3;
        }
    }

    /* renamed from: d */
    public final String mo28379d() {
        synchronized (f5298h) {
            for (C2455a aVar : this.f5305g) {
                if ("root".equals(aVar.f5306a)) {
                    String str = aVar.f5310e;
                    return str;
                }
            }
            String str2 = "https://config.inmobi.com/config-server/v1/config/secure.cfg";
            return str2;
        }
    }
}
