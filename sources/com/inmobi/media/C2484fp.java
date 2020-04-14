package com.inmobi.media;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fp */
/* compiled from: NetworkConnection */
class C2484fp {

    /* renamed from: a */
    protected static final String f5424a = "fp";

    /* renamed from: b */
    protected C2486fr f5425b;

    /* renamed from: c */
    protected HttpURLConnection f5426c;

    public C2484fp(C2486fr frVar) {
        this.f5425b = frVar;
    }

    /* renamed from: a */
    public C2487fs mo28405a() {
        C2487fs fsVar;
        C2487fs fsVar2;
        this.f5425b.mo27984a();
        if (this.f5425b.f5447s != 1) {
            C2487fs fsVar3 = new C2487fs();
            fsVar3.f5452a = new C2485fq(-8, "Network Request dropped as current request is not GDPR compliant.");
            return fsVar3;
        }
        if (C2515gi.m5353a()) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f5425b.mo28414g()).openConnection();
                m5211a(httpURLConnection);
                this.f5426c = httpURLConnection;
                if (!this.f5425b.f5443o) {
                    this.f5426c.setInstanceFollowRedirects(false);
                }
                if ("POST".equals(this.f5425b.f5440l)) {
                    String h = this.f5425b.mo28415h();
                    this.f5426c.setRequestProperty("Content-Length", Integer.toString(h.length()));
                    this.f5426c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    BufferedWriter bufferedWriter = null;
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(this.f5426c.getOutputStream()));
                        try {
                            bufferedWriter2.write(h);
                            C2515gi.m5350a((Closeable) bufferedWriter2);
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            C2515gi.m5350a((Closeable) bufferedWriter);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C2515gi.m5350a((Closeable) bufferedWriter);
                        throw th;
                    }
                }
                fsVar = mo28406b();
            } catch (IOException e) {
                fsVar2 = new C2487fs();
                fsVar2.f5452a = new C2485fq(-2, e.getLocalizedMessage());
                fsVar = fsVar2;
                return fsVar;
            } catch (Exception e2) {
                fsVar2 = new C2487fs();
                fsVar2.f5452a = new C2485fq(-1, e2.getLocalizedMessage());
                fsVar = fsVar2;
                return fsVar;
            }
        } else {
            fsVar = new C2487fs();
            fsVar.f5452a = new C2485fq(0, "Network not reachable currently. Please try again.");
        }
        return fsVar;
    }

    /* renamed from: a */
    private void m5211a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(this.f5425b.f5441m);
        httpURLConnection.setReadTimeout(this.f5425b.f5442n);
        httpURLConnection.setUseCaches(false);
        Map f = this.f5425b.mo28413f();
        if (f != null) {
            for (String str : f.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) f.get(str));
            }
        }
        String str2 = this.f5425b.f5440l;
        httpURLConnection.setRequestMethod(str2);
        if (!"GET".equals(str2)) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069 A[Catch:{ all -> 0x001a, SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007d A[Catch:{ all -> 0x001a, SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.inmobi.media.C2487fs mo28406b() {
        /*
            r12 = this;
            com.inmobi.media.fs r0 = new com.inmobi.media.fs
            r0.<init>()
            r1 = -1
            r2 = -3
            r3 = -2
            r4 = 504(0x1f8, float:7.06E-43)
            java.net.HttpURLConnection r5 = r12.f5426c     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            int r5 = r5.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            r6 = 0
            r7 = 200(0xc8, float:2.8E-43)
            if (r5 != r7) goto L_0x001d
            r12.m5210a(r0, r6)     // Catch:{ all -> 0x001a }
            goto L_0x0096
        L_0x001a:
            r5 = move-exception
            goto L_0x00a1
        L_0x001d:
            r8 = 400(0x190, float:5.6E-43)
            r9 = -9
            r10 = 500(0x1f4, float:7.0E-43)
            r11 = -7
            if (r8 > r5) goto L_0x002a
            if (r10 <= r5) goto L_0x002a
        L_0x0028:
            r6 = -7
            goto L_0x0067
        L_0x002a:
            if (r7 >= r5) goto L_0x0031
            r7 = 300(0x12c, float:4.2E-43)
            if (r7 <= r5) goto L_0x0031
            goto L_0x0065
        L_0x0031:
            if (r5 == 0) goto L_0x0067
            switch(r5) {
                case -9: goto L_0x0065;
                case -8: goto L_0x0063;
                case -7: goto L_0x0028;
                case -6: goto L_0x0061;
                case -5: goto L_0x005f;
                case -4: goto L_0x005d;
                case -3: goto L_0x005b;
                case -2: goto L_0x0059;
                default: goto L_0x0036;
            }     // Catch:{ all -> 0x001a }
        L_0x0036:
            switch(r5) {
                case 302: goto L_0x0056;
                case 303: goto L_0x0053;
                case 304: goto L_0x0050;
                default: goto L_0x0039;
            }     // Catch:{ all -> 0x001a }
        L_0x0039:
            switch(r5) {
                case 500: goto L_0x004d;
                case 501: goto L_0x004a;
                case 502: goto L_0x0047;
                case 503: goto L_0x0044;
                case 504: goto L_0x0041;
                case 505: goto L_0x003e;
                default: goto L_0x003c;
            }     // Catch:{ all -> 0x001a }
        L_0x003c:
            r6 = -1
            goto L_0x0067
        L_0x003e:
            r6 = 505(0x1f9, float:7.08E-43)
            goto L_0x0067
        L_0x0041:
            r6 = 504(0x1f8, float:7.06E-43)
            goto L_0x0067
        L_0x0044:
            r6 = 503(0x1f7, float:7.05E-43)
            goto L_0x0067
        L_0x0047:
            r6 = 502(0x1f6, float:7.03E-43)
            goto L_0x0067
        L_0x004a:
            r6 = 501(0x1f5, float:7.02E-43)
            goto L_0x0067
        L_0x004d:
            r6 = 500(0x1f4, float:7.0E-43)
            goto L_0x0067
        L_0x0050:
            r6 = 304(0x130, float:4.26E-43)
            goto L_0x0067
        L_0x0053:
            r6 = 303(0x12f, float:4.25E-43)
            goto L_0x0067
        L_0x0056:
            r6 = 302(0x12e, float:4.23E-43)
            goto L_0x0067
        L_0x0059:
            r6 = -2
            goto L_0x0067
        L_0x005b:
            r6 = -3
            goto L_0x0067
        L_0x005d:
            r6 = -4
            goto L_0x0067
        L_0x005f:
            r6 = -5
            goto L_0x0067
        L_0x0061:
            r6 = -6
            goto L_0x0067
        L_0x0063:
            r6 = -8
            goto L_0x0067
        L_0x0065:
            r6 = -9
        L_0x0067:
            if (r6 != r11) goto L_0x007d
            r5 = 1
            r12.m5210a(r0, r5)     // Catch:{ all -> 0x001a }
            java.lang.String r5 = r0.mo28418b()     // Catch:{ all -> 0x001a }
            java.lang.String r5 = m5209a(r5)     // Catch:{ all -> 0x001a }
            com.inmobi.media.fq r7 = new com.inmobi.media.fq     // Catch:{ all -> 0x001a }
            r7.<init>(r6, r5)     // Catch:{ all -> 0x001a }
            r0.f5452a = r7     // Catch:{ all -> 0x001a }
            goto L_0x0096
        L_0x007d:
            com.inmobi.media.fq r7 = new com.inmobi.media.fq     // Catch:{ all -> 0x001a }
            java.lang.String r8 = "HTTP:"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x001a }
            java.lang.String r5 = r8.concat(r5)     // Catch:{ all -> 0x001a }
            r7.<init>(r6, r5)     // Catch:{ all -> 0x001a }
            r0.f5452a = r7     // Catch:{ all -> 0x001a }
            java.net.HttpURLConnection r5 = r12.f5426c     // Catch:{ all -> 0x001a }
            java.util.Map r5 = r5.getHeaderFields()     // Catch:{ all -> 0x001a }
            r0.f5454c = r5     // Catch:{ all -> 0x001a }
        L_0x0096:
            java.net.HttpURLConnection r5 = r12.f5426c     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            com.inmobi.media.C2515gi.m5351a(r5)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            java.net.HttpURLConnection r5 = r12.f5426c     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            r5.disconnect()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            goto L_0x00d3
        L_0x00a1:
            java.net.HttpURLConnection r6 = r12.f5426c     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            com.inmobi.media.C2515gi.m5351a(r6)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            java.net.HttpURLConnection r6 = r12.f5426c     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            r6.disconnect()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
            throw r5     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c0, OutOfMemoryError -> 0x00b6, Exception -> 0x00ac }
        L_0x00ac:
            com.inmobi.media.fq r2 = new com.inmobi.media.fq
            java.lang.String r3 = "UNKNOWN_ERROR"
            r2.<init>(r1, r3)
            r0.f5452a = r2
            goto L_0x00d3
        L_0x00b6:
            com.inmobi.media.fq r1 = new com.inmobi.media.fq
            java.lang.String r3 = "OUT_OF_MEMORY_ERROR"
            r1.<init>(r2, r3)
            r0.f5452a = r1
            goto L_0x00d3
        L_0x00c0:
            com.inmobi.media.fq r1 = new com.inmobi.media.fq
            java.lang.String r2 = "NETWORK_IO_ERROR"
            r1.<init>(r3, r2)
            r0.f5452a = r1
            goto L_0x00d3
        L_0x00ca:
            com.inmobi.media.fq r1 = new com.inmobi.media.fq
            java.lang.String r2 = "HTTP_GATEWAY_TIMEOUT"
            r1.<init>(r4, r2)
            r0.f5452a = r1
        L_0x00d3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2484fp.mo28406b():com.inmobi.media.fs");
    }

    /* renamed from: a */
    private void m5210a(C2487fs fsVar, boolean z) throws IOException {
        if (!this.f5425b.mo28412e() || ((long) this.f5426c.getContentLength()) <= this.f5425b.f5445q) {
            byte[] a = C2515gi.m5354a(z ? this.f5426c.getErrorStream() : this.f5426c.getInputStream());
            if (a.length != 0) {
                if (this.f5425b.mo27985b()) {
                    a = this.f5425b.mo28408a(a);
                    if (a == null) {
                        fsVar.f5452a = new C2485fq(-4, "Unable to decrypt the server response.");
                    }
                }
                if (a != null && this.f5425b.f5446r) {
                    a = C2515gi.m5355a(a);
                    if (a == null) {
                        fsVar.f5452a = new C2485fq(-6, "Failed to uncompress gzip response");
                    }
                }
                if (a != null) {
                    fsVar.mo28419b(a);
                }
            }
            fsVar.f5454c = this.f5426c.getHeaderFields();
            return;
        }
        fsVar.f5452a = new C2485fq(-5, "Response size greater than specified max response size");
    }

    /* renamed from: a */
    private static String m5209a(String str) {
        String str2 = "errorMessage";
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return jSONObject.getString(str2);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }
}
