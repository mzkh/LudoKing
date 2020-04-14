package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfb implements zzcxn<zzcfa, zzcfd> {
    private final String zzdjp;
    private final zzapr zzfvf;
    private final String zzfvs;
    private final Context zzlk;

    public zzcfb(Context context, String str, zzapr zzapr, String str2) {
        this.zzlk = context;
        this.zzfvs = str;
        this.zzfvf = zzapr;
        this.zzdjp = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r2 = new java.io.InputStreamReader(r6.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        com.google.android.gms.ads.internal.zzq.zzkj();
        r0 = com.google.android.gms.internal.ads.zzaul.zza(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r7.zzep(r0);
        r5.zzfvt = r8;
        r5.zzdko = r0;
        r5.zzab = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b4, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c6, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzuv.zzon().zzd(com.google.android.gms.internal.ads.zzza.zzcrn)).booleanValue() == false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01d1, code lost:
        throw new com.google.android.gms.internal.ads.zzcek("No Fill", 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01d2, code lost:
        r5.zzfvu = com.google.android.gms.ads.internal.zzq.zzkq().elapsedRealtime() - r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r6.disconnect();
        r1.zzfvf.zztl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e5, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e6, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzcfd zza(java.lang.String r21, com.google.android.gms.internal.ads.zzapk r22, org.json.JSONObject r23, java.lang.String r24) throws com.google.android.gms.internal.ads.zzcek {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "Received error HTTP response code: "
            java.lang.String r2 = "doritos_v2"
            java.lang.String r3 = "doritos"
            java.lang.String r4 = ""
            int r5 = r22.getErrorCode()     // Catch:{ IOException -> 0x0279 }
            r6 = -2
            r7 = 0
            r8 = 1
            if (r5 == r6) goto L_0x0040
            int r0 = r22.getErrorCode()     // Catch:{ IOException -> 0x0279 }
            if (r0 != r8) goto L_0x0038
            java.util.List r0 = r22.zztd()     // Catch:{ IOException -> 0x0279 }
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = ", "
            java.util.List r2 = r22.zztd()     // Catch:{ IOException -> 0x0279 }
            java.lang.String r0 = android.text.TextUtils.join(r0, r2)     // Catch:{ IOException -> 0x0279 }
            com.google.android.gms.internal.ads.zzaug.zzes(r0)     // Catch:{ IOException -> 0x0279 }
        L_0x002c:
            com.google.android.gms.internal.ads.zzcek r0 = new com.google.android.gms.internal.ads.zzcek     // Catch:{ IOException -> 0x0279 }
            java.lang.String r2 = "Error building request URL."
            int r3 = r22.getErrorCode()     // Catch:{ IOException -> 0x0279 }
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x0279 }
            throw r0     // Catch:{ IOException -> 0x0279 }
        L_0x0038:
            com.google.android.gms.internal.ads.zzcek r0 = new com.google.android.gms.internal.ads.zzcek     // Catch:{ IOException -> 0x0279 }
            java.lang.String r2 = "Internal error."
            r0.<init>(r2, r7)     // Catch:{ IOException -> 0x0279 }
            throw r0     // Catch:{ IOException -> 0x0279 }
        L_0x0040:
            com.google.android.gms.internal.ads.zzcfd r5 = new com.google.android.gms.internal.ads.zzcfd     // Catch:{ IOException -> 0x0279 }
            r5.<init>()     // Catch:{ IOException -> 0x0279 }
            java.lang.String r6 = "SDK version: "
            java.lang.String r9 = r1.zzfvs     // Catch:{ IOException -> 0x0279 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IOException -> 0x0279 }
            int r10 = r9.length()     // Catch:{ IOException -> 0x0279 }
            if (r10 == 0) goto L_0x0058
            java.lang.String r6 = r6.concat(r9)     // Catch:{ IOException -> 0x0279 }
            goto L_0x005e
        L_0x0058:
            java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x0279 }
            r9.<init>(r6)     // Catch:{ IOException -> 0x0279 }
            r6 = r9
        L_0x005e:
            com.google.android.gms.internal.ads.zzaug.zzet(r6)     // Catch:{ IOException -> 0x0279 }
            java.lang.String r6 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r9 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x0279 }
            int r10 = r9.length()     // Catch:{ IOException -> 0x0279 }
            if (r10 == 0) goto L_0x0072
            java.lang.String r6 = r6.concat(r9)     // Catch:{ IOException -> 0x0279 }
            goto L_0x0078
        L_0x0072:
            java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x0279 }
            r9.<init>(r6)     // Catch:{ IOException -> 0x0279 }
            r6 = r9
        L_0x0078:
            com.google.android.gms.internal.ads.zzaug.zzdv(r6)     // Catch:{ IOException -> 0x0279 }
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x0279 }
            r9 = r21
            r6.<init>(r9)     // Catch:{ IOException -> 0x0279 }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ IOException -> 0x0279 }
            r9.<init>()     // Catch:{ IOException -> 0x0279 }
            com.google.android.gms.common.util.Clock r10 = com.google.android.gms.ads.internal.zzq.zzkq()     // Catch:{ IOException -> 0x0279 }
            long r10 = r10.elapsedRealtime()     // Catch:{ IOException -> 0x0279 }
            r12 = 0
        L_0x0090:
            com.google.android.gms.internal.ads.zzapr r13 = r1.zzfvf     // Catch:{ IOException -> 0x0279 }
            r13.zztk()     // Catch:{ IOException -> 0x0279 }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ IOException -> 0x0279 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0279 }
            com.google.android.gms.internal.ads.zzaul r13 = com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x026f }
            android.content.Context r14 = r1.zzlk     // Catch:{ all -> 0x026f }
            java.lang.String r15 = r1.zzfvs     // Catch:{ all -> 0x026f }
            r13.zza(r14, r15, r7, r6)     // Catch:{ all -> 0x026f }
            boolean r13 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x026f }
            if (r13 != 0) goto L_0x00b4
            java.lang.String r13 = "Cookie"
            r14 = r24
            r6.addRequestProperty(r13, r14)     // Catch:{ all -> 0x026f }
            goto L_0x00b6
        L_0x00b4:
            r14 = r24
        L_0x00b6:
            boolean r13 = r22.zztg()     // Catch:{ all -> 0x026f }
            if (r13 == 0) goto L_0x00f3
            java.lang.String r13 = "pii"
            r15 = r23
            org.json.JSONObject r13 = r15.optJSONObject(r13)     // Catch:{ all -> 0x026f }
            if (r13 == 0) goto L_0x00ed
            java.lang.String r16 = r13.optString(r3, r4)     // Catch:{ all -> 0x026f }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x026f }
            if (r16 != 0) goto L_0x00d9
            java.lang.String r7 = "x-afma-drt-cookie"
            java.lang.String r8 = r13.optString(r3, r4)     // Catch:{ all -> 0x026f }
            r6.addRequestProperty(r7, r8)     // Catch:{ all -> 0x026f }
        L_0x00d9:
            java.lang.String r7 = r13.optString(r2, r4)     // Catch:{ all -> 0x026f }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x026f }
            if (r7 != 0) goto L_0x00f5
            java.lang.String r7 = "x-afma-drt-v2-cookie"
            java.lang.String r8 = r13.optString(r2, r4)     // Catch:{ all -> 0x026f }
            r6.addRequestProperty(r7, r8)     // Catch:{ all -> 0x026f }
            goto L_0x00f5
        L_0x00ed:
            java.lang.String r7 = "DSID signal does not exist."
            com.google.android.gms.internal.ads.zzaug.zzdy(r7)     // Catch:{ all -> 0x026f }
            goto L_0x00f5
        L_0x00f3:
            r15 = r23
        L_0x00f5:
            if (r22 == 0) goto L_0x0129
            java.lang.String r8 = r22.zztf()     // Catch:{ all -> 0x026f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x026f }
            if (r8 != 0) goto L_0x0129
            r8 = 1
            r6.setDoOutput(r8)     // Catch:{ all -> 0x026f }
            java.lang.String r8 = r22.zztf()     // Catch:{ all -> 0x026f }
            byte[] r8 = r8.getBytes()     // Catch:{ all -> 0x026f }
            int r13 = r8.length     // Catch:{ all -> 0x026f }
            r6.setFixedLengthStreamingMode(r13)     // Catch:{ all -> 0x026f }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0123 }
            java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ all -> 0x0123 }
            r13.<init>(r7)     // Catch:{ all -> 0x0123 }
            r13.write(r8)     // Catch:{ all -> 0x0121 }
            com.google.android.gms.common.util.IOUtils.closeQuietly(r13)     // Catch:{ all -> 0x026f }
            goto L_0x012a
        L_0x0121:
            r0 = move-exception
            goto L_0x0125
        L_0x0123:
            r0 = move-exception
            r13 = 0
        L_0x0125:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r13)     // Catch:{ all -> 0x026f }
            throw r0     // Catch:{ all -> 0x026f }
        L_0x0129:
            r8 = 0
        L_0x012a:
            com.google.android.gms.internal.ads.zzaxc r7 = new com.google.android.gms.internal.ads.zzaxc     // Catch:{ all -> 0x026f }
            r7.<init>()     // Catch:{ all -> 0x026f }
            r7.zza(r6, r8)     // Catch:{ all -> 0x026f }
            int r8 = r6.getResponseCode()     // Catch:{ all -> 0x026f }
            java.util.Map r13 = r6.getHeaderFields()     // Catch:{ all -> 0x026f }
            java.util.Set r13 = r13.entrySet()     // Catch:{ all -> 0x026f }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x026f }
        L_0x0142:
            boolean r17 = r13.hasNext()     // Catch:{ all -> 0x026f }
            if (r17 == 0) goto L_0x0183
            java.lang.Object r17 = r13.next()     // Catch:{ all -> 0x026f }
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17     // Catch:{ all -> 0x026f }
            java.lang.Object r18 = r17.getKey()     // Catch:{ all -> 0x026f }
            r19 = r2
            r2 = r18
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x026f }
            java.lang.Object r17 = r17.getValue()     // Catch:{ all -> 0x026f }
            r18 = r3
            r3 = r17
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x026f }
            boolean r17 = r9.containsKey(r2)     // Catch:{ all -> 0x026f }
            if (r17 == 0) goto L_0x0172
            java.lang.Object r2 = r9.get(r2)     // Catch:{ all -> 0x026f }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x026f }
            r2.addAll(r3)     // Catch:{ all -> 0x026f }
            goto L_0x017e
        L_0x0172:
            r17 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x026f }
            r4.<init>(r3)     // Catch:{ all -> 0x026f }
            r9.put(r2, r4)     // Catch:{ all -> 0x026f }
            r4 = r17
        L_0x017e:
            r3 = r18
            r2 = r19
            goto L_0x0142
        L_0x0183:
            r19 = r2
            r18 = r3
            r17 = r4
            r7.zza(r6, r8)     // Catch:{ all -> 0x026f }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 300(0x12c, float:4.2E-43)
            if (r8 < r2) goto L_0x01ee
            if (r8 >= r3) goto L_0x01ee
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x01e8 }
            java.io.InputStream r0 = r6.getInputStream()     // Catch:{ all -> 0x01e8 }
            r2.<init>(r0)     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x01e6 }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaul.zza(r2)     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)     // Catch:{ all -> 0x026f }
            r7.zzep(r0)     // Catch:{ all -> 0x026f }
            r5.zzfvt = r8     // Catch:{ all -> 0x026f }
            r5.zzdko = r0     // Catch:{ all -> 0x026f }
            r5.zzab = r9     // Catch:{ all -> 0x026f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x026f }
            if (r0 == 0) goto L_0x01d2
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcrn     // Catch:{ all -> 0x026f }
            com.google.android.gms.internal.ads.zzyw r2 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x026f }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x026f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x026f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x026f }
            if (r0 == 0) goto L_0x01c9
            goto L_0x01d2
        L_0x01c9:
            com.google.android.gms.internal.ads.zzcek r0 = new com.google.android.gms.internal.ads.zzcek     // Catch:{ all -> 0x026f }
            java.lang.String r2 = "No Fill"
            r3 = 3
            r0.<init>(r2, r3)     // Catch:{ all -> 0x026f }
            throw r0     // Catch:{ all -> 0x026f }
        L_0x01d2:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzkq()     // Catch:{ all -> 0x026f }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x026f }
            long r2 = r2 - r10
            r5.zzfvu = r2     // Catch:{ all -> 0x026f }
            r6.disconnect()     // Catch:{ IOException -> 0x0279 }
            com.google.android.gms.internal.ads.zzapr r0 = r1.zzfvf     // Catch:{ IOException -> 0x0279 }
            r0.zztl()     // Catch:{ IOException -> 0x0279 }
            return r5
        L_0x01e6:
            r0 = move-exception
            goto L_0x01ea
        L_0x01e8:
            r0 = move-exception
            r2 = 0
        L_0x01ea:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)     // Catch:{ all -> 0x026f }
            throw r0     // Catch:{ all -> 0x026f }
        L_0x01ee:
            if (r8 < r3) goto L_0x0246
            r2 = 400(0x190, float:5.6E-43)
            if (r8 >= r2) goto L_0x0246
            java.lang.String r2 = "Location"
            java.lang.String r2 = r6.getHeaderField(r2)     // Catch:{ all -> 0x026f }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x026f }
            if (r3 != 0) goto L_0x0239
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x026f }
            r3.<init>(r2)     // Catch:{ all -> 0x026f }
            r2 = 1
            int r12 = r12 + r2
            com.google.android.gms.internal.ads.zzyp<java.lang.Integer> r4 = com.google.android.gms.internal.ads.zzza.zzcqt     // Catch:{ all -> 0x026f }
            com.google.android.gms.internal.ads.zzyw r7 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x026f }
            java.lang.Object r4 = r7.zzd(r4)     // Catch:{ all -> 0x026f }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x026f }
            int r4 = r4.intValue()     // Catch:{ all -> 0x026f }
            if (r12 > r4) goto L_0x022c
            r6.disconnect()     // Catch:{ IOException -> 0x0279 }
            com.google.android.gms.internal.ads.zzapr r4 = r1.zzfvf     // Catch:{ IOException -> 0x0279 }
            r4.zztl()     // Catch:{ IOException -> 0x0279 }
            r6 = r3
            r4 = r17
            r3 = r18
            r2 = r19
            r7 = 0
            r8 = 1
            goto L_0x0090
        L_0x022c:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ all -> 0x026f }
            com.google.android.gms.internal.ads.zzcek r0 = new com.google.android.gms.internal.ads.zzcek     // Catch:{ all -> 0x026f }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r2)     // Catch:{ all -> 0x026f }
            throw r0     // Catch:{ all -> 0x026f }
        L_0x0239:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ all -> 0x026f }
            com.google.android.gms.internal.ads.zzcek r0 = new com.google.android.gms.internal.ads.zzcek     // Catch:{ all -> 0x026f }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r2)     // Catch:{ all -> 0x026f }
            throw r0     // Catch:{ all -> 0x026f }
        L_0x0246:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x026f }
            r3 = 46
            r2.<init>(r3)     // Catch:{ all -> 0x026f }
            r2.append(r0)     // Catch:{ all -> 0x026f }
            r2.append(r8)     // Catch:{ all -> 0x026f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x026f }
            com.google.android.gms.internal.ads.zzaug.zzeu(r2)     // Catch:{ all -> 0x026f }
            com.google.android.gms.internal.ads.zzcek r2 = new com.google.android.gms.internal.ads.zzcek     // Catch:{ all -> 0x026f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x026f }
            r4.<init>(r3)     // Catch:{ all -> 0x026f }
            r4.append(r0)     // Catch:{ all -> 0x026f }
            r4.append(r8)     // Catch:{ all -> 0x026f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x026f }
            r2.<init>(r0)     // Catch:{ all -> 0x026f }
            throw r2     // Catch:{ all -> 0x026f }
        L_0x026f:
            r0 = move-exception
            r6.disconnect()     // Catch:{ IOException -> 0x0279 }
            com.google.android.gms.internal.ads.zzapr r2 = r1.zzfvf     // Catch:{ IOException -> 0x0279 }
            r2.zztl()     // Catch:{ IOException -> 0x0279 }
            throw r0     // Catch:{ IOException -> 0x0279 }
        L_0x0279:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x028f
            java.lang.String r2 = r2.concat(r3)
            goto L_0x0295
        L_0x028f:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x0295:
            com.google.android.gms.internal.ads.zzaug.zzeu(r2)
            com.google.android.gms.internal.ads.zzcek r2 = new com.google.android.gms.internal.ads.zzcek
            java.lang.String r3 = "Error connecting to ad server:"
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x02af
            java.lang.String r0 = r3.concat(r0)
            goto L_0x02b4
        L_0x02af:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x02b4:
            r3 = 2
            r2.<init>(r0, r3)
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfb.zza(java.lang.String, com.google.android.gms.internal.ads.zzapk, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzcfd");
    }

    public final /* synthetic */ Object apply(Object obj) throws Exception {
        zzcfa zzcfa = (zzcfa) obj;
        return zza(zzcfa.zzfvm.getUrl(), zzcfa.zzfvm, zzcfa.zzfvl, this.zzdjp);
    }
}
