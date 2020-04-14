package com.applovin.impl.sdk.network;

import com.applovin.impl.mediation.p016d.C0989b;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p020c.C1114h;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;
import com.applovin.impl.sdk.utils.C1284r;
import com.applovin.sdk.AppLovinErrorCodes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.network.a */
public class C1211a {

    /* renamed from: a */
    private final C1192i f3046a;

    /* renamed from: b */
    private final C1227o f3047b;

    /* renamed from: c */
    private C1213b f3048c;

    /* renamed from: com.applovin.impl.sdk.network.a$a */
    public static class C1212a {

        /* renamed from: a */
        private long f3049a;

        /* renamed from: b */
        private long f3050b;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2721a(long j) {
            this.f3049a = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m2723b(long j) {
            this.f3050b = j;
        }

        /* renamed from: a */
        public long mo10295a() {
            return this.f3049a;
        }

        /* renamed from: b */
        public long mo10296b() {
            return this.f3050b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.a$b */
    public static class C1213b {

        /* renamed from: a */
        private final long f3051a = System.currentTimeMillis();

        /* renamed from: b */
        private final String f3052b;

        /* renamed from: c */
        private final long f3053c;

        /* renamed from: d */
        private final long f3054d;

        C1213b(String str, long j, long j2) {
            this.f3052b = str;
            this.f3053c = j;
            this.f3054d = j2;
        }

        /* renamed from: a */
        public long mo10297a() {
            return this.f3051a;
        }

        /* renamed from: b */
        public String mo10298b() {
            return this.f3052b;
        }

        /* renamed from: c */
        public long mo10299c() {
            return this.f3053c;
        }

        /* renamed from: d */
        public long mo10300d() {
            return this.f3054d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RequestMeasurement{timestampMillis=");
            sb.append(this.f3051a);
            sb.append(", urlHostAndPathString='");
            sb.append(this.f3052b);
            sb.append('\'');
            sb.append(", responseSize=");
            sb.append(this.f3053c);
            sb.append(", connectionTimeMillis=");
            sb.append(this.f3054d);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.a$c */
    public interface C1214c<T> {
        /* renamed from: a */
        void mo9301a(int i);

        /* renamed from: a */
        void mo9302a(T t, int i);
    }

    public C1211a(C1192i iVar) {
        this.f3046a = iVar;
        this.f3047b = iVar.mo10249v();
    }

    /* renamed from: a */
    private int m2711a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return AppLovinErrorCodes.NO_NETWORK;
        }
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (!(th instanceof IOException)) {
            return th instanceof JSONException ? -104 : -1;
        }
        if (((Boolean) this.f3046a.mo10202a(C1096c.f2317af)).booleanValue()) {
            return -100;
        }
        String message = th.getMessage();
        return (message == null || !message.toLowerCase(Locale.ENGLISH).contains("authentication challenge")) ? -100 : 401;
    }

    /* renamed from: a */
    private <T> T m2712a(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t instanceof C1283q) {
                return C1284r.m3130a(str, this.f3046a);
            }
            if (t instanceof String) {
                return str;
            }
            C1227o oVar = this.f3047b;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to process response of type '");
            sb.append(t.getClass().getName());
            sb.append("'");
            oVar.mo10382e("ConnectionManager", sb.toString());
        }
        return t;
    }

    /* renamed from: a */
    private HttpURLConnection m2713a(String str, String str2, Map<String, String> map, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f3046a.mo10202a(C1096c.f2491dw)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f3046a.mo10202a(C1096c.f2492dx)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        if (map != null && map.size() > 0) {
            for (String str3 : map.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AppLovin-");
                sb.append(str3);
                httpURLConnection.setRequestProperty(sb.toString(), (String) map.get(str3));
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m2714a(int i, String str) {
        if (((Boolean) this.f3046a.mo10202a(C1096c.f2314ac)).booleanValue()) {
            try {
                C1219d.m2769a(i, str, this.f3046a.mo10179D());
            } catch (Throwable th) {
                C1227o v = this.f3046a.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to track response code for URL: ");
                sb.append(str);
                v.mo10379b("ConnectionManager", sb.toString(), th);
            }
        }
    }

    /* renamed from: a */
    private void m2715a(String str) {
        C1114h hVar;
        C1113g gVar;
        if (C1277l.m3040a(str, C1246g.m2957g(this.f3046a)) || C1277l.m3040a(str, C1246g.m2958h(this.f3046a))) {
            hVar = this.f3046a.mo10186L();
            gVar = C1113g.f2663h;
        } else if (C1277l.m3040a(str, C0989b.m1762a(this.f3046a)) || C1277l.m3040a(str, C0989b.m1764b(this.f3046a))) {
            hVar = this.f3046a.mo10186L();
            gVar = C1113g.f2669n;
        } else {
            hVar = this.f3046a.mo10186L();
            gVar = C1113g.f2664i;
        }
        hVar.mo10036a(gVar);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=T, for r5v0, types: [T, java.lang.String] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> void m2716a(T r5, int r6, java.lang.String r7, T r8, boolean r9, com.applovin.impl.sdk.network.C1211a.C1214c<T> r10) {
        /*
            r4 = this;
            com.applovin.impl.sdk.o r0 = r4.f3047b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r2 = " received from \""
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ConnectionManager"
            r0.mo10378b(r2, r1)
            com.applovin.impl.sdk.o r0 = r4.f3047b
            r0.mo10376a(r2, r5)
            java.lang.String r0 = "\""
            r1 = 200(0xc8, float:2.8E-43)
            if (r6 < r1) goto L_0x00b7
            r1 = 300(0x12c, float:4.2E-43)
            if (r6 >= r1) goto L_0x00b7
            if (r9 == 0) goto L_0x0036
            com.applovin.impl.sdk.i r9 = r4.f3046a
            java.lang.String r9 = r9.mo10246t()
            java.lang.String r5 = com.applovin.impl.sdk.utils.C1276k.m3021a(r5, r9)
        L_0x0036:
            if (r5 == 0) goto L_0x0041
            int r9 = r5.length()
            r1 = 2
            if (r9 <= r1) goto L_0x0041
            r9 = 1
            goto L_0x0042
        L_0x0041:
            r9 = 0
        L_0x0042:
            r1 = 204(0xcc, float:2.86E-43)
            if (r6 == r1) goto L_0x00b3
            if (r9 == 0) goto L_0x00b3
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            if (r9 == 0) goto L_0x004e
        L_0x004c:
            r8 = r5
            goto L_0x00b3
        L_0x004e:
            boolean r9 = r8 instanceof com.applovin.impl.sdk.utils.C1283q     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            if (r9 == 0) goto L_0x0059
            com.applovin.impl.sdk.i r9 = r4.f3046a     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            com.applovin.impl.sdk.utils.q r5 = com.applovin.impl.sdk.utils.C1284r.m3130a(r5, r9)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            goto L_0x004c
        L_0x0059:
            boolean r9 = r8 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            if (r9 == 0) goto L_0x0064
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r9.<init>(r5)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r8 = r9
            goto L_0x00b3
        L_0x0064:
            com.applovin.impl.sdk.o r5 = r4.f3047b     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r9.<init>()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r1 = "Unable to handle '"
            r9.append(r1)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.Class r1 = r8.getClass()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r1 = r1.getName()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r9.append(r1)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r1 = "'"
            r9.append(r1)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r5.mo10382e(r2, r9)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            goto L_0x00b3
        L_0x0088:
            r5 = move-exception
            r4.m2715a(r7)
            com.applovin.impl.sdk.o r9 = r4.f3047b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Invalid XML returned from \""
            goto L_0x00a3
        L_0x0096:
            r5 = move-exception
            r4.m2715a(r7)
            com.applovin.impl.sdk.o r9 = r4.f3047b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Invalid JSON returned from \""
        L_0x00a3:
            r1.append(r3)
            r1.append(r7)
            r1.append(r0)
            java.lang.String r7 = r1.toString()
            r9.mo10379b(r2, r7, r5)
        L_0x00b3:
            r10.mo9302a(r8, r6)
            goto L_0x00d6
        L_0x00b7:
            com.applovin.impl.sdk.o r5 = r4.f3047b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r9 = " error received from \""
            r8.append(r9)
            r8.append(r7)
            r8.append(r0)
            java.lang.String r7 = r8.toString()
            r5.mo10382e(r2, r7)
            r10.mo9301a(r6)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1211a.m2716a(java.lang.String, int, java.lang.String, java.lang.Object, boolean, com.applovin.impl.sdk.network.a$c):void");
    }

    /* renamed from: a */
    private void m2717a(String str, String str2, int i, long j) {
        C1227o oVar = this.f3047b;
        StringBuilder sb = new StringBuilder();
        sb.append("Successful ");
        sb.append(str);
        sb.append(" returned ");
        sb.append(i);
        sb.append(" in ");
        sb.append(((float) (System.currentTimeMillis() - j)) / 1000.0f);
        sb.append(" s over ");
        sb.append(C1246g.m2955f(this.f3046a));
        sb.append(" to \"");
        sb.append(str2);
        sb.append("\"");
        oVar.mo10380c("ConnectionManager", sb.toString());
    }

    /* renamed from: a */
    private void m2718a(String str, String str2, int i, long j, Throwable th) {
        C1227o oVar = this.f3047b;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed ");
        sb.append(str);
        sb.append(" returned ");
        sb.append(i);
        sb.append(" in ");
        sb.append(((float) (System.currentTimeMillis() - j)) / 1000.0f);
        sb.append(" s over ");
        sb.append(C1246g.m2955f(this.f3046a));
        sb.append(" to \"");
        sb.append(str2);
        sb.append("\"");
        oVar.mo10379b("ConnectionManager", sb.toString(), th);
    }

    /* renamed from: a */
    public C1213b mo10293a() {
        return this.f3048c;
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r10v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r6v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r10v22 */
    /* JADX WARNING: type inference failed for: r10v23, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r10v24 */
    /* JADX WARNING: type inference failed for: r10v25 */
    /* JADX WARNING: type inference failed for: r11v11 */
    /* JADX WARNING: type inference failed for: r10v26 */
    /* JADX WARNING: type inference failed for: r11v12 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: type inference failed for: r10v27 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r10v28 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r10v29 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: type inference failed for: r11v20 */
    /* JADX WARNING: type inference failed for: r11v21 */
    /* JADX WARNING: type inference failed for: r11v22 */
    /* JADX WARNING: type inference failed for: r11v23 */
    /* JADX WARNING: type inference failed for: r11v24 */
    /* JADX WARNING: type inference failed for: r7v23 */
    /* JADX WARNING: type inference failed for: r6v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r11v25 */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r16v3 */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r10v30 */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r10v31 */
    /* JADX WARNING: type inference failed for: r16v8 */
    /* JADX WARNING: type inference failed for: r10v32 */
    /* JADX WARNING: type inference failed for: r16v10 */
    /* JADX WARNING: type inference failed for: r16v11 */
    /* JADX WARNING: type inference failed for: r16v12 */
    /* JADX WARNING: type inference failed for: r16v13 */
    /* JADX WARNING: type inference failed for: r11v27 */
    /* JADX WARNING: type inference failed for: r11v28 */
    /* JADX WARNING: type inference failed for: r11v29 */
    /* JADX WARNING: type inference failed for: r10v33 */
    /* JADX WARNING: type inference failed for: r10v34 */
    /* JADX WARNING: type inference failed for: r10v35 */
    /* JADX WARNING: type inference failed for: r10v36 */
    /* JADX WARNING: type inference failed for: r10v37 */
    /* JADX WARNING: type inference failed for: r10v38 */
    /* JADX WARNING: type inference failed for: r10v39 */
    /* JADX WARNING: type inference failed for: r10v40 */
    /* JADX WARNING: type inference failed for: r10v41 */
    /* JADX WARNING: type inference failed for: r10v42 */
    /* JADX WARNING: type inference failed for: r10v43 */
    /* JADX WARNING: type inference failed for: r10v44 */
    /* JADX WARNING: type inference failed for: r10v45 */
    /* JADX WARNING: type inference failed for: r10v46 */
    /* JADX WARNING: type inference failed for: r10v47 */
    /* JADX WARNING: type inference failed for: r10v48 */
    /* JADX WARNING: type inference failed for: r10v49 */
    /* JADX WARNING: type inference failed for: r10v50 */
    /* JADX WARNING: type inference failed for: r10v51 */
    /* JADX WARNING: type inference failed for: r10v52 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r10v53 */
    /* JADX WARNING: type inference failed for: r10v54 */
    /* JADX WARNING: type inference failed for: r10v55 */
    /* JADX WARNING: type inference failed for: r10v56 */
    /* JADX WARNING: type inference failed for: r10v57 */
    /* JADX WARNING: type inference failed for: r10v58 */
    /* JADX WARNING: type inference failed for: r10v59 */
    /* JADX WARNING: type inference failed for: r11v30 */
    /* JADX WARNING: type inference failed for: r11v31 */
    /* JADX WARNING: type inference failed for: r11v32 */
    /* JADX WARNING: type inference failed for: r11v33 */
    /* JADX WARNING: type inference failed for: r11v34 */
    /* JADX WARNING: type inference failed for: r11v35 */
    /* JADX WARNING: type inference failed for: r11v36 */
    /* JADX WARNING: type inference failed for: r16v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0325, code lost:
        r0 = e;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0327, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0328, code lost:
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x032b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x032c, code lost:
        r24 = r10;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0331, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0332, code lost:
        r24 = r10;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0335, code lost:
        r7 = r0;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0363, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0364, code lost:
        r5 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0368, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x036f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0373, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0374, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0378, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0379, code lost:
        r24 = r10;
        r7 = r0;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0382, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0383, code lost:
        r17 = r5;
        r24 = r10;
        r7 = r0;
        r15 = 0;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03a3, code lost:
        if (r26.mo10313h() == false) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x03a6, code lost:
        r0 = th;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x03ac, code lost:
        r7 = r0;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0192, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0193, code lost:
        r7 = r0;
        r24 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0198, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0199, code lost:
        r7 = r0;
        r24 = r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:50:0x018e, B:168:0x0357] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r10v3
      assigns: []
      uses: []
      mth insns count: 527
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0325 A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:132:0x0290] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0327 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:59:0x01a5] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0363 A[ExcHandler: all (th java.lang.Throwable), PHI: r17 
      PHI: (r17v13 java.net.HttpURLConnection) = (r17v15 java.net.HttpURLConnection), (r17v15 java.net.HttpURLConnection), (r17v20 java.net.HttpURLConnection), (r17v22 java.net.HttpURLConnection), (r17v22 java.net.HttpURLConnection) binds: [B:168:0x0357, B:169:?, B:57:0x01a1, B:50:0x018e, B:51:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:50:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0373 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:43:0x016f] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x039f A[SYNTHETIC, Splitter:B:190:0x039f] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03a6 A[ExcHandler: all (th java.lang.Throwable), PHI: r10 r17 
      PHI: (r10v11 ?) = (r10v44 ?), (r10v45 ?), (r10v49 ?), (r10v56 ?), (r10v58 ?) binds: [B:202:0x03be, B:203:?, B:190:0x039f, B:143:0x02d0, B:144:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r17v4 java.net.HttpURLConnection) = (r17v5 java.net.HttpURLConnection), (r17v5 java.net.HttpURLConnection), (r17v5 java.net.HttpURLConnection), (r17v20 java.net.HttpURLConnection), (r17v20 java.net.HttpURLConnection) binds: [B:202:0x03be, B:203:?, B:190:0x039f, B:143:0x02d0, B:144:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:143:0x02d0] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03c5  */
    /* JADX WARNING: Unknown variable types count: 34 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void mo10294a(com.applovin.impl.sdk.network.C1215b<T> r26, com.applovin.impl.sdk.network.C1211a.C1212a r27, com.applovin.impl.sdk.network.C1211a.C1214c<T> r28) {
        /*
            r25 = this;
            r8 = r25
            r0 = r27
            r9 = r28
            if (r26 == 0) goto L_0x045b
            java.lang.String r1 = r26.mo10302a()
            java.lang.String r10 = r26.mo10305b()
            if (r1 == 0) goto L_0x0453
            if (r10 == 0) goto L_0x044b
            if (r9 == 0) goto L_0x0443
            java.lang.String r2 = r1.toLowerCase()
            java.lang.String r3 = "http"
            boolean r2 = r2.startsWith(r3)
            java.lang.String r7 = "ConnectionManager"
            if (r2 != 0) goto L_0x0043
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Requested postback submission to non HTTP endpoint "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "; skipping..."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.applovin.impl.sdk.C1227o.m2841i(r7, r0)
            r0 = -900(0xfffffffffffffc7c, float:NaN)
            r9.mo9301a(r0)
            return
        L_0x0043:
            com.applovin.impl.sdk.i r2 = r8.f3046a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r3 = com.applovin.impl.sdk.p019b.C1096c.f2493dy
            java.lang.Object r2 = r2.mo10202a(r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = "https://"
            boolean r3 = r1.contains(r2)
            if (r3 != 0) goto L_0x006c
            com.applovin.impl.sdk.i r3 = r8.f3046a
            com.applovin.impl.sdk.o r3 = r3.mo10249v()
            java.lang.String r4 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r3.mo10381d(r7, r4)
            java.lang.String r3 = "http://"
            java.lang.String r1 = r1.replace(r3, r2)
        L_0x006c:
            boolean r11 = r26.mo10319m()
            com.applovin.impl.sdk.i r2 = r8.f3046a
            long r2 = com.applovin.impl.sdk.utils.C1281o.m3064a(r2)
            java.util.Map r4 = r26.mo10307c()
            if (r4 == 0) goto L_0x0086
            java.util.Map r4 = r26.mo10307c()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x008c
        L_0x0086:
            int r4 = r26.mo10315i()
            if (r4 < 0) goto L_0x00c0
        L_0x008c:
            java.util.Map r4 = r26.mo10307c()
            if (r4 == 0) goto L_0x00a5
            int r5 = r26.mo10315i()
            if (r5 < 0) goto L_0x00a5
            int r5 = r26.mo10315i()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "current_retry_attempt"
            r4.put(r6, r5)
        L_0x00a5:
            if (r11 == 0) goto L_0x00bc
            java.lang.String r4 = com.applovin.impl.sdk.utils.C1281o.m3076a(r4)
            com.applovin.impl.sdk.i r5 = r8.f3046a
            java.lang.String r5 = r5.mo10246t()
            java.lang.String r4 = com.applovin.impl.sdk.utils.C1276k.m3022a(r4, r5, r2)
            java.lang.String r5 = "p"
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1277l.m3036a(r1, r5, r4)
            goto L_0x00c0
        L_0x00bc:
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1277l.m3041b(r1, r4)
        L_0x00c0:
            r12 = r1
            long r13 = java.lang.System.currentTimeMillis()
            com.applovin.impl.sdk.o r4 = r8.f3047b     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            r5.<init>()     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.lang.String r6 = "Sending "
            r5.append(r6)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            r5.append(r10)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.lang.String r6 = " request to \""
            r5.append(r6)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            r5.append(r12)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.lang.String r6 = "\"..."
            r5.append(r6)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            r4.mo10380c(r7, r5)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.util.Map r4 = r26.mo10308d()     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            int r5 = r26.mo10317k()     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            java.net.HttpURLConnection r5 = r8.m2713a(r12, r10, r4, r5)     // Catch:{ Throwable -> 0x03fd, all -> 0x03f9 }
            org.json.JSONObject r4 = r26.mo10309e()     // Catch:{ Throwable -> 0x03f1, all -> 0x03ee }
            if (r4 == 0) goto L_0x016f
            if (r11 == 0) goto L_0x010f
            org.json.JSONObject r4 = r26.mo10309e()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            com.applovin.impl.sdk.i r6 = r8.f3046a     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r6 = r6.mo10246t()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1276k.m3022a(r4, r6, r2)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            goto L_0x0117
        L_0x010f:
            org.json.JSONObject r2 = r26.mo10309e()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
        L_0x0117:
            com.applovin.impl.sdk.o r3 = r8.f3047b     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r4.<init>()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r6 = "Request to \""
            r4.append(r6)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r4.append(r12)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r6 = "\" is "
            r4.append(r6)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r4.append(r2)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r3.mo10378b(r7, r4)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json; charset=utf-8"
            r5.setRequestProperty(r3, r4)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r3 = 1
            r5.setDoOutput(r3)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            byte[] r3 = r2.getBytes(r3)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            int r3 = r3.length     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r5.setFixedLengthStreamingMode(r3)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.io.OutputStream r6 = r5.getOutputStream()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            java.lang.String r1 = "UTF8"
            r4.<init>(r6, r1)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r3.print(r2)     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            r3.close()     // Catch:{ Throwable -> 0x0168, all -> 0x0165 }
            goto L_0x016f
        L_0x0165:
            r0 = move-exception
            goto L_0x03fb
        L_0x0168:
            r0 = move-exception
            r7 = r0
            r11 = r5
            r24 = r10
            goto L_0x03f7
        L_0x016f:
            int r6 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x0382, Throwable -> 0x0378, all -> 0x0373 }
            if (r6 <= 0) goto L_0x034a
            com.applovin.impl.sdk.i r1 = r8.f3046a     // Catch:{ MalformedURLException -> 0x0343, Throwable -> 0x033c, all -> 0x0373 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2519eY     // Catch:{ MalformedURLException -> 0x0343, Throwable -> 0x033c, all -> 0x0373 }
            java.lang.Object r1 = r1.mo10202a(r2)     // Catch:{ MalformedURLException -> 0x0343, Throwable -> 0x033c, all -> 0x0373 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ MalformedURLException -> 0x0343, Throwable -> 0x033c, all -> 0x0373 }
            boolean r1 = r1.booleanValue()     // Catch:{ MalformedURLException -> 0x0343, Throwable -> 0x033c, all -> 0x0373 }
            if (r1 == 0) goto L_0x019e
            r1 = r25
            r2 = r10
            r3 = r12
            r4 = r6
            r17 = r5
            r15 = r6
            r5 = r13
            r1.m2717a(r2, r3, r4, r5)     // Catch:{ MalformedURLException -> 0x0198, Throwable -> 0x0192, all -> 0x0363 }
            goto L_0x01a1
        L_0x0192:
            r0 = move-exception
            r7 = r0
            r24 = r10
            goto L_0x036a
        L_0x0198:
            r0 = move-exception
            r7 = r0
            r24 = r10
            goto L_0x0371
        L_0x019e:
            r17 = r5
            r15 = r6
        L_0x01a1:
            java.io.InputStream r6 = r17.getInputStream()     // Catch:{ MalformedURLException -> 0x033a, Throwable -> 0x0338, all -> 0x0363 }
            r8.m2714a(r15, r12)     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            long r4 = r1 - r13
            com.applovin.impl.sdk.i r1 = r8.f3046a     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2519eY     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            java.lang.Object r1 = r1.mo10202a(r2)     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            boolean r1 = r1.booleanValue()     // Catch:{ MalformedURLException -> 0x0331, Throwable -> 0x032b, all -> 0x0327 }
            if (r1 == 0) goto L_0x0267
            com.applovin.impl.sdk.i r1 = r8.f3046a     // Catch:{ MalformedURLException -> 0x025f, Throwable -> 0x0257, all -> 0x0252 }
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1246g.m2939a(r6, r1)     // Catch:{ MalformedURLException -> 0x025f, Throwable -> 0x0257, all -> 0x0252 }
            boolean r1 = r26.mo10313h()     // Catch:{ MalformedURLException -> 0x025f, Throwable -> 0x0257, all -> 0x0252 }
            if (r1 == 0) goto L_0x023f
            if (r0 == 0) goto L_0x021c
            if (r2 == 0) goto L_0x0201
            int r1 = r2.length()     // Catch:{ MalformedURLException -> 0x01fd, Throwable -> 0x01f9, all -> 0x01f5 }
            r16 = r6
            long r6 = (long) r1
            r0.m2723b(r6)     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            boolean r1 = r26.mo10320n()     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            if (r1 == 0) goto L_0x0203
            com.applovin.impl.sdk.network.a$b r1 = new com.applovin.impl.sdk.network.a$b     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            java.lang.String r19 = r26.mo10302a()     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            int r3 = r2.length()     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            long r6 = (long) r3     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            r18 = r1
            r20 = r6
            r22 = r4
            r18.<init>(r19, r20, r22)     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            r8.f3048c = r1     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            goto L_0x0203
        L_0x01f5:
            r0 = move-exception
            r16 = r6
            goto L_0x0208
        L_0x01f9:
            r0 = move-exception
            r16 = r6
            goto L_0x020d
        L_0x01fd:
            r0 = move-exception
            r16 = r6
            goto L_0x0215
        L_0x0201:
            r16 = r6
        L_0x0203:
            r0.m2721a(r4)     // Catch:{ MalformedURLException -> 0x0214, Throwable -> 0x020c, all -> 0x0207 }
            goto L_0x021e
        L_0x0207:
            r0 = move-exception
        L_0x0208:
            r10 = r16
            goto L_0x03a7
        L_0x020c:
            r0 = move-exception
        L_0x020d:
            r7 = r0
            r24 = r10
            r10 = r16
            goto L_0x03ad
        L_0x0214:
            r0 = move-exception
        L_0x0215:
            r7 = r0
            r24 = r10
            r10 = r16
            goto L_0x038a
        L_0x021c:
            r16 = r6
        L_0x021e:
            int r3 = r17.getResponseCode()     // Catch:{ MalformedURLException -> 0x023b, Throwable -> 0x0237, all -> 0x0233 }
            java.lang.Object r5 = r26.mo10312g()     // Catch:{ MalformedURLException -> 0x023b, Throwable -> 0x0237, all -> 0x0233 }
            r1 = r25
            r4 = r12
            r7 = r16
            r6 = r11
            r11 = r7
            r7 = r28
            r1.m2716a(r2, r3, r4, r5, r6, r7)     // Catch:{ MalformedURLException -> 0x024a, Throwable -> 0x0248, all -> 0x0246 }
            goto L_0x024f
        L_0x0233:
            r0 = move-exception
            r11 = r16
            goto L_0x0254
        L_0x0237:
            r0 = move-exception
            r11 = r16
            goto L_0x0259
        L_0x023b:
            r0 = move-exception
            r11 = r16
            goto L_0x0261
        L_0x023f:
            r11 = r6
            if (r0 == 0) goto L_0x024c
            r0.m2721a(r4)     // Catch:{ MalformedURLException -> 0x024a, Throwable -> 0x0248, all -> 0x0246 }
            goto L_0x024c
        L_0x0246:
            r0 = move-exception
            goto L_0x0254
        L_0x0248:
            r0 = move-exception
            goto L_0x0259
        L_0x024a:
            r0 = move-exception
            goto L_0x0261
        L_0x024c:
            r9.mo9302a(r2, r15)     // Catch:{ MalformedURLException -> 0x024a, Throwable -> 0x0248, all -> 0x0246 }
        L_0x024f:
            r10 = r11
            goto L_0x0322
        L_0x0252:
            r0 = move-exception
            r11 = r6
        L_0x0254:
            r10 = r11
            goto L_0x03a7
        L_0x0257:
            r0 = move-exception
            r11 = r6
        L_0x0259:
            r7 = r0
            r24 = r10
            r10 = r11
            goto L_0x03ad
        L_0x025f:
            r0 = move-exception
            r11 = r6
        L_0x0261:
            r7 = r0
            r24 = r10
            r10 = r11
            goto L_0x038a
        L_0x0267:
            r1 = 200(0xc8, float:2.8E-43)
            if (r15 < r1) goto L_0x0311
            r1 = 400(0x190, float:5.6E-43)
            if (r15 >= r1) goto L_0x0311
            if (r0 == 0) goto L_0x0285
            r0.m2721a(r4)     // Catch:{ MalformedURLException -> 0x027e, Throwable -> 0x0275, all -> 0x0327 }
            goto L_0x0285
        L_0x0275:
            r0 = move-exception
            r7 = r0
            r24 = r10
            r11 = r17
            r10 = r6
            goto L_0x0404
        L_0x027e:
            r0 = move-exception
            r7 = r0
            r24 = r10
            r10 = r6
            goto L_0x038a
        L_0x0285:
            r1 = r25
            r2 = r10
            r3 = r12
            r22 = r4
            r4 = r15
            r24 = r10
            r10 = r6
            r5 = r13
            r1.m2717a(r2, r3, r4, r5)     // Catch:{ MalformedURLException -> 0x0325 }
            com.applovin.impl.sdk.i r1 = r8.f3046a     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1246g.m2939a(r10, r1)     // Catch:{ MalformedURLException -> 0x0325 }
            if (r1 == 0) goto L_0x0309
            com.applovin.impl.sdk.o r2 = r8.f3047b     // Catch:{ MalformedURLException -> 0x0325 }
            r2.mo10376a(r7, r1)     // Catch:{ MalformedURLException -> 0x0325 }
            if (r0 == 0) goto L_0x02aa
            int r2 = r1.length()     // Catch:{ MalformedURLException -> 0x0325 }
            long r2 = (long) r2     // Catch:{ MalformedURLException -> 0x0325 }
            r0.m2723b(r2)     // Catch:{ MalformedURLException -> 0x0325 }
        L_0x02aa:
            boolean r0 = r26.mo10320n()     // Catch:{ MalformedURLException -> 0x0325 }
            if (r0 == 0) goto L_0x02c4
            com.applovin.impl.sdk.network.a$b r0 = new com.applovin.impl.sdk.network.a$b     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r19 = r26.mo10302a()     // Catch:{ MalformedURLException -> 0x0325 }
            int r2 = r1.length()     // Catch:{ MalformedURLException -> 0x0325 }
            long r2 = (long) r2     // Catch:{ MalformedURLException -> 0x0325 }
            r18 = r0
            r20 = r2
            r18.<init>(r19, r20, r22)     // Catch:{ MalformedURLException -> 0x0325 }
            r8.f3048c = r0     // Catch:{ MalformedURLException -> 0x0325 }
        L_0x02c4:
            if (r11 == 0) goto L_0x02d0
            com.applovin.impl.sdk.i r0 = r8.f3046a     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r0 = r0.mo10246t()     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1276k.m3021a(r1, r0)     // Catch:{ MalformedURLException -> 0x0325 }
        L_0x02d0:
            java.lang.Object r0 = r26.mo10312g()     // Catch:{ Throwable -> 0x02dc, MalformedURLException -> 0x0325, all -> 0x03a6 }
            java.lang.Object r0 = r8.m2712a(r1, (T) r0)     // Catch:{ Throwable -> 0x02dc, MalformedURLException -> 0x0325, all -> 0x03a6 }
            r9.mo9302a(r0, r15)     // Catch:{ Throwable -> 0x02dc, MalformedURLException -> 0x0325, all -> 0x03a6 }
            goto L_0x0322
        L_0x02dc:
            r0 = move-exception
            com.applovin.impl.sdk.o r1 = r8.f3047b     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0325 }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r3 = "Unable to parse response from \""
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x0325 }
            r2.append(r12)     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x0325 }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedURLException -> 0x0325 }
            r1.mo10379b(r7, r2, r0)     // Catch:{ MalformedURLException -> 0x0325 }
            com.applovin.impl.sdk.i r0 = r8.f3046a     // Catch:{ MalformedURLException -> 0x0325 }
            com.applovin.impl.sdk.c.h r0 = r0.mo10186L()     // Catch:{ MalformedURLException -> 0x0325 }
            com.applovin.impl.sdk.c.g r1 = com.applovin.impl.sdk.p020c.C1113g.f2664i     // Catch:{ MalformedURLException -> 0x0325 }
            r0.mo10036a(r1)     // Catch:{ MalformedURLException -> 0x0325 }
            r0 = -800(0xfffffffffffffce0, float:NaN)
            r9.mo9301a(r0)     // Catch:{ MalformedURLException -> 0x0325 }
            goto L_0x0322
        L_0x0309:
            java.lang.Object r0 = r26.mo10312g()     // Catch:{ MalformedURLException -> 0x0325 }
            r9.mo9302a(r0, r15)     // Catch:{ MalformedURLException -> 0x0325 }
            goto L_0x0322
        L_0x0311:
            r24 = r10
            r10 = r6
            r7 = 0
            r1 = r25
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m2718a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x0325 }
            r9.mo9301a(r15)     // Catch:{ MalformedURLException -> 0x0325 }
        L_0x0322:
            r18 = r10
            goto L_0x035f
        L_0x0325:
            r0 = move-exception
            goto L_0x0335
        L_0x0327:
            r0 = move-exception
            r10 = r6
            goto L_0x03a7
        L_0x032b:
            r0 = move-exception
            r24 = r10
            r10 = r6
            goto L_0x03ac
        L_0x0331:
            r0 = move-exception
            r24 = r10
            r10 = r6
        L_0x0335:
            r7 = r0
            goto L_0x038a
        L_0x0338:
            r0 = move-exception
            goto L_0x0340
        L_0x033a:
            r0 = move-exception
            goto L_0x0347
        L_0x033c:
            r0 = move-exception
            r17 = r5
            r15 = r6
        L_0x0340:
            r24 = r10
            goto L_0x0369
        L_0x0343:
            r0 = move-exception
            r17 = r5
            r15 = r6
        L_0x0347:
            r24 = r10
            goto L_0x0370
        L_0x034a:
            r17 = r5
            r15 = r6
            r24 = r10
            r7 = 0
            r1 = r25
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m2718a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x036f, Throwable -> 0x0368, all -> 0x0363 }
            r9.mo9301a(r15)     // Catch:{ MalformedURLException -> 0x036f, Throwable -> 0x0368, all -> 0x0363 }
            r18 = 0
        L_0x035f:
            r10 = r18
            goto L_0x03d6
        L_0x0363:
            r0 = move-exception
            r5 = r17
            goto L_0x03fb
        L_0x0368:
            r0 = move-exception
        L_0x0369:
            r7 = r0
        L_0x036a:
            r11 = r17
            r10 = 0
            goto L_0x0404
        L_0x036f:
            r0 = move-exception
        L_0x0370:
            r7 = r0
        L_0x0371:
            r10 = 0
            goto L_0x038a
        L_0x0373:
            r0 = move-exception
            r17 = r5
            goto L_0x03fb
        L_0x0378:
            r0 = move-exception
            r17 = r5
            r24 = r10
            r7 = r0
            r11 = r17
            goto L_0x03f7
        L_0x0382:
            r0 = move-exception
            r17 = r5
            r24 = r10
            r7 = r0
            r10 = 0
            r15 = 0
        L_0x038a:
            r0 = -901(0xfffffffffffffc7b, float:NaN)
            r8.m2714a(r0, r12)     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            com.applovin.impl.sdk.i r1 = r8.f3046a     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2519eY     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            java.lang.Object r1 = r1.mo10202a(r2)     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            boolean r1 = r1.booleanValue()     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            if (r1 == 0) goto L_0x03b1
            boolean r1 = r26.mo10313h()     // Catch:{ Throwable -> 0x03ab, all -> 0x03a6 }
            if (r1 != 0) goto L_0x03b7
            goto L_0x03b1
        L_0x03a6:
            r0 = move-exception
        L_0x03a7:
            r5 = r17
            goto L_0x0438
        L_0x03ab:
            r0 = move-exception
        L_0x03ac:
            r7 = r0
        L_0x03ad:
            r11 = r17
            goto L_0x0404
        L_0x03b1:
            java.lang.Object r1 = r26.mo10312g()     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            if (r1 == 0) goto L_0x03c5
        L_0x03b7:
            r1 = r25
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m2718a(r2, r3, r4, r5, r7)     // Catch:{ Throwable -> 0x03ab, all -> 0x03a6 }
            r9.mo9301a(r0)     // Catch:{ Throwable -> 0x03ab, all -> 0x03a6 }
            goto L_0x03d6
        L_0x03c5:
            r1 = r25
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m2717a(r2, r3, r4, r5)     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            java.lang.Object r1 = r26.mo10312g()     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
            r9.mo9302a(r1, r0)     // Catch:{ Throwable -> 0x03e8, all -> 0x03e3 }
        L_0x03d6:
            com.applovin.impl.sdk.i r0 = r8.f3046a
            com.applovin.impl.sdk.utils.C1281o.m3083a(r10, r0)
            com.applovin.impl.sdk.i r0 = r8.f3046a
            r1 = r17
            com.applovin.impl.sdk.utils.C1281o.m3087a(r1, r0)
            goto L_0x0435
        L_0x03e3:
            r0 = move-exception
            r1 = r17
            r5 = r1
            goto L_0x0438
        L_0x03e8:
            r0 = move-exception
            r1 = r17
            r7 = r0
            r11 = r1
            goto L_0x0404
        L_0x03ee:
            r0 = move-exception
            r1 = r5
            goto L_0x03fb
        L_0x03f1:
            r0 = move-exception
            r1 = r5
            r24 = r10
            r7 = r0
            r11 = r1
        L_0x03f7:
            r10 = 0
            goto L_0x0403
        L_0x03f9:
            r0 = move-exception
            r5 = 0
        L_0x03fb:
            r10 = 0
            goto L_0x0438
        L_0x03fd:
            r0 = move-exception
            r24 = r10
            r7 = r0
            r10 = 0
            r11 = 0
        L_0x0403:
            r15 = 0
        L_0x0404:
            com.applovin.impl.sdk.i r0 = r8.f3046a     // Catch:{ all -> 0x0436 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p019b.C1096c.f2317af     // Catch:{ all -> 0x0436 }
            java.lang.Object r0 = r0.mo10202a(r1)     // Catch:{ all -> 0x0436 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0436 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0436 }
            if (r0 == 0) goto L_0x0416
            if (r15 != 0) goto L_0x041b
        L_0x0416:
            int r0 = r8.m2711a(r7)     // Catch:{ all -> 0x0436 }
            r15 = r0
        L_0x041b:
            r8.m2714a(r15, r12)     // Catch:{ all -> 0x0436 }
            r1 = r25
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m2718a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x0436 }
            r9.mo9301a(r15)     // Catch:{ all -> 0x0436 }
            com.applovin.impl.sdk.i r0 = r8.f3046a
            com.applovin.impl.sdk.utils.C1281o.m3083a(r10, r0)
            com.applovin.impl.sdk.i r0 = r8.f3046a
            com.applovin.impl.sdk.utils.C1281o.m3087a(r11, r0)
        L_0x0435:
            return
        L_0x0436:
            r0 = move-exception
            r5 = r11
        L_0x0438:
            com.applovin.impl.sdk.i r1 = r8.f3046a
            com.applovin.impl.sdk.utils.C1281o.m3083a(r10, r1)
            com.applovin.impl.sdk.i r1 = r8.f3046a
            com.applovin.impl.sdk.utils.C1281o.m3087a(r5, r1)
            throw r0
        L_0x0443:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x044b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x0453:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x045b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1211a.mo10294a(com.applovin.impl.sdk.network.b, com.applovin.impl.sdk.network.a$a, com.applovin.impl.sdk.network.a$c):void");
    }
}
