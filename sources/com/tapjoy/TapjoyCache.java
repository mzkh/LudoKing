package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCache {
    public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
    public static final int CACHE_LIMIT = -1;

    /* renamed from: a */
    private static TapjoyCache f6453a = null;
    public static boolean unit_test_mode = false;

    /* renamed from: b */
    private Context f6454b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TapjoyCacheMap f6455c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Vector f6456d;

    /* renamed from: e */
    private ExecutorService f6457e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public File f6458f;

    public class CacheAssetThread implements Callable {

        /* renamed from: b */
        private URL f6463b;

        /* renamed from: c */
        private String f6464c;

        /* renamed from: d */
        private long f6465d;

        public CacheAssetThread(URL url, String str, long j) {
            this.f6463b = url;
            this.f6464c = str;
            this.f6465d = j;
            if (this.f6465d <= 0) {
                this.f6465d = 86400;
            }
            TapjoyCache.this.f6456d.add(TapjoyCache.m6514b(this.f6463b.toString()));
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(10:26|27|28|29|30|31|32|(1:35)|36|37) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x011f */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x01a1 A[SYNTHETIC, Splitter:B:57:0x01a1] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x01a8 A[SYNTHETIC, Splitter:B:61:0x01a8] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x01dc A[SYNTHETIC, Splitter:B:70:0x01dc] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01e3 A[SYNTHETIC, Splitter:B:74:0x01e3] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01ea A[SYNTHETIC, Splitter:B:80:0x01ea] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01f1 A[SYNTHETIC, Splitter:B:84:0x01f1] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x017a=Splitter:B:54:0x017a, B:67:0x01ae=Splitter:B:67:0x01ae} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean call() {
            /*
                r11 = this;
                java.net.URL r0 = r11.f6463b
                java.lang.String r0 = r0.toString()
                java.lang.String r0 = com.tapjoy.TapjoyCache.m6514b(r0)
                com.tapjoy.TapjoyCache r1 = com.tapjoy.TapjoyCache.this
                com.tapjoy.TapjoyCacheMap r1 = r1.f6455c
                boolean r1 = r1.containsKey(r0)
                r2 = 1
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                java.lang.String r3 = "TapjoyCache"
                if (r1 == 0) goto L_0x008c
                com.tapjoy.TapjoyCache r1 = com.tapjoy.TapjoyCache.this
                com.tapjoy.TapjoyCacheMap r1 = r1.f6455c
                java.lang.Object r1 = r1.get(r0)
                com.tapjoy.TapjoyCachedAssetData r1 = (com.tapjoy.TapjoyCachedAssetData) r1
                java.io.File r4 = new java.io.File
                java.lang.String r1 = r1.getLocalFilePath()
                r4.<init>(r1)
                boolean r1 = r4.exists()
                if (r1 == 0) goto L_0x0085
                long r4 = r11.f6465d
                r6 = 0
                int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r1 == 0) goto L_0x0052
                com.tapjoy.TapjoyCache r1 = com.tapjoy.TapjoyCache.this
                com.tapjoy.TapjoyCacheMap r1 = r1.f6455c
                java.lang.Object r1 = r1.get(r0)
                com.tapjoy.TapjoyCachedAssetData r1 = (com.tapjoy.TapjoyCachedAssetData) r1
                long r4 = r11.f6465d
                r1.resetTimeToLive(r4)
                goto L_0x0064
            L_0x0052:
                com.tapjoy.TapjoyCache r1 = com.tapjoy.TapjoyCache.this
                com.tapjoy.TapjoyCacheMap r1 = r1.f6455c
                java.lang.Object r1 = r1.get(r0)
                com.tapjoy.TapjoyCachedAssetData r1 = (com.tapjoy.TapjoyCachedAssetData) r1
                r4 = 86400(0x15180, double:4.26873E-319)
                r1.resetTimeToLive(r4)
            L_0x0064:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r4 = "Reseting time to live for "
                r1.<init>(r4)
                java.net.URL r4 = r11.f6463b
                java.lang.String r4 = r4.toString()
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                com.tapjoy.TapjoyLog.m6550d(r3, r1)
                com.tapjoy.TapjoyCache r1 = com.tapjoy.TapjoyCache.this
                java.util.Vector r1 = r1.f6456d
                r1.remove(r0)
                return r2
            L_0x0085:
                com.tapjoy.TapjoyCache r1 = com.tapjoy.TapjoyCache.getInstance()
                r1.removeAssetFromCache(r0)
            L_0x008c:
                java.lang.System.currentTimeMillis()
                r1 = 0
                java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x01f5 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f5 }
                r5.<init>()     // Catch:{ Exception -> 0x01f5 }
                com.tapjoy.TapjoyCache r6 = com.tapjoy.TapjoyCache.this     // Catch:{ Exception -> 0x01f5 }
                java.io.File r6 = r6.f6458f     // Catch:{ Exception -> 0x01f5 }
                r5.append(r6)     // Catch:{ Exception -> 0x01f5 }
                java.lang.String r6 = "/"
                r5.append(r6)     // Catch:{ Exception -> 0x01f5 }
                java.lang.String r6 = com.tapjoy.TapjoyUtil.SHA256(r0)     // Catch:{ Exception -> 0x01f5 }
                r5.append(r6)     // Catch:{ Exception -> 0x01f5 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01f5 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x01f5 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "Downloading and caching asset from: "
                r5.<init>(r6)
                java.net.URL r6 = r11.f6463b
                r5.append(r6)
                java.lang.String r6 = " to "
                r5.append(r6)
                r5.append(r4)
                java.lang.String r5 = r5.toString()
                com.tapjoy.TapjoyLog.m6550d(r3, r5)
                r5 = 0
                java.net.URL r6 = r11.f6463b     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                java.net.URLConnection r6 = com.tapjoy.internal.C3066fj.m7086a(r6)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r7 = 15000(0x3a98, float:2.102E-41)
                r6.setConnectTimeout(r7)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r7 = 30000(0x7530, float:4.2039E-41)
                r6.setReadTimeout(r7)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r6.connect()     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                boolean r7 = r6 instanceof java.net.HttpURLConnection     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                if (r7 == 0) goto L_0x0106
                r7 = r6
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                int r7 = r7.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r8 = 200(0xc8, float:2.8E-43)
                if (r7 != r8) goto L_0x00f2
                goto L_0x0106
            L_0x00f2:
                java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                java.lang.String r8 = "Unexpected response code: "
                r6.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r6.append(r7)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                java.lang.String r6 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r2.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                throw r2     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
            L_0x0106:
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                java.io.InputStream r6 = r6.getInputStream()     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                r7.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x01ac, Exception -> 0x0178, all -> 0x0175 }
                java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ SocketTimeoutException -> 0x0171, Exception -> 0x016d, all -> 0x0168 }
                java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0171, Exception -> 0x016d, all -> 0x0168 }
                r8.<init>(r4)     // Catch:{ SocketTimeoutException -> 0x0171, Exception -> 0x016d, all -> 0x0168 }
                r6.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x0171, Exception -> 0x016d, all -> 0x0168 }
                com.tapjoy.TapjoyUtil.writeFileToDevice(r7, r6)     // Catch:{ SocketTimeoutException -> 0x0166, Exception -> 0x0164, all -> 0x0162 }
                r7.close()     // Catch:{ IOException -> 0x011f }
            L_0x011f:
                r6.close()     // Catch:{ IOException -> 0x0122 }
            L_0x0122:
                com.tapjoy.TapjoyCachedAssetData r1 = new com.tapjoy.TapjoyCachedAssetData
                java.net.URL r5 = r11.f6463b
                java.lang.String r5 = r5.toString()
                java.lang.String r4 = r4.getAbsolutePath()
                long r6 = r11.f6465d
                r1.<init>(r5, r4, r6)
                java.lang.String r4 = r11.f6464c
                if (r4 == 0) goto L_0x013a
                r1.setOfferID(r4)
            L_0x013a:
                com.tapjoy.TapjoyCache r4 = com.tapjoy.TapjoyCache.this
                com.tapjoy.TapjoyCacheMap r4 = r4.f6455c
                r4.put(r0, r1)
                com.tapjoy.TapjoyCache r4 = com.tapjoy.TapjoyCache.this
                java.util.Vector r4 = r4.f6456d
                r4.remove(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r4 = "----- Download complete -----"
                r0.<init>(r4)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.tapjoy.TapjoyLog.m6550d(r3, r0)
                return r2
            L_0x0162:
                r0 = move-exception
                goto L_0x016a
            L_0x0164:
                r2 = move-exception
                goto L_0x016f
            L_0x0166:
                r2 = move-exception
                goto L_0x0173
            L_0x0168:
                r0 = move-exception
                r6 = r5
            L_0x016a:
                r5 = r7
                goto L_0x01e8
            L_0x016d:
                r2 = move-exception
                r6 = r5
            L_0x016f:
                r5 = r7
                goto L_0x017a
            L_0x0171:
                r2 = move-exception
                r6 = r5
            L_0x0173:
                r5 = r7
                goto L_0x01ae
            L_0x0175:
                r0 = move-exception
                r6 = r5
                goto L_0x01e8
            L_0x0178:
                r2 = move-exception
                r6 = r5
            L_0x017a:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e7 }
                java.lang.String r8 = "Error caching asset: "
                r7.<init>(r8)     // Catch:{ all -> 0x01e7 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01e7 }
                r7.append(r2)     // Catch:{ all -> 0x01e7 }
                java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyLog.m6552e(r3, r2)     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyCache r2 = com.tapjoy.TapjoyCache.this     // Catch:{ all -> 0x01e7 }
                java.util.Vector r2 = r2.f6456d     // Catch:{ all -> 0x01e7 }
                r2.remove(r0)     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyUtil.deleteFileOrDirectory(r4)     // Catch:{ all -> 0x01e7 }
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01e7 }
                if (r5 == 0) goto L_0x01a6
                r5.close()     // Catch:{ IOException -> 0x01a5 }
                goto L_0x01a6
            L_0x01a5:
            L_0x01a6:
                if (r6 == 0) goto L_0x01ab
                r6.close()     // Catch:{ IOException -> 0x01ab }
            L_0x01ab:
                return r0
            L_0x01ac:
                r2 = move-exception
                r6 = r5
            L_0x01ae:
                com.tapjoy.TapjoyErrorMessage r7 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyErrorMessage$ErrorType r8 = com.tapjoy.TapjoyErrorMessage.ErrorType.NETWORK_ERROR     // Catch:{ all -> 0x01e7 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e7 }
                java.lang.String r10 = "Network timeout during caching: "
                r9.<init>(r10)     // Catch:{ all -> 0x01e7 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01e7 }
                r9.append(r2)     // Catch:{ all -> 0x01e7 }
                java.lang.String r2 = r9.toString()     // Catch:{ all -> 0x01e7 }
                r7.<init>(r8, r2)     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyLog.m6551e(r3, r7)     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyCache r2 = com.tapjoy.TapjoyCache.this     // Catch:{ all -> 0x01e7 }
                java.util.Vector r2 = r2.f6456d     // Catch:{ all -> 0x01e7 }
                r2.remove(r0)     // Catch:{ all -> 0x01e7 }
                com.tapjoy.TapjoyUtil.deleteFileOrDirectory(r4)     // Catch:{ all -> 0x01e7 }
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01e7 }
                if (r5 == 0) goto L_0x01e1
                r5.close()     // Catch:{ IOException -> 0x01e0 }
                goto L_0x01e1
            L_0x01e0:
            L_0x01e1:
                if (r6 == 0) goto L_0x01e6
                r6.close()     // Catch:{ IOException -> 0x01e6 }
            L_0x01e6:
                return r0
            L_0x01e7:
                r0 = move-exception
            L_0x01e8:
                if (r5 == 0) goto L_0x01ef
                r5.close()     // Catch:{ IOException -> 0x01ee }
                goto L_0x01ef
            L_0x01ee:
            L_0x01ef:
                if (r6 == 0) goto L_0x01f4
                r6.close()     // Catch:{ IOException -> 0x01f4 }
            L_0x01f4:
                throw r0
            L_0x01f5:
                com.tapjoy.TapjoyCache r2 = com.tapjoy.TapjoyCache.this
                java.util.Vector r2 = r2.f6456d
                r2.remove(r0)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyCache.CacheAssetThread.call():java.lang.Boolean");
        }
    }

    public TapjoyCache(Context context) {
        if (f6453a == null || unit_test_mode) {
            f6453a = this;
            this.f6454b = context;
            this.f6455c = new TapjoyCacheMap(context, -1);
            this.f6456d = new Vector();
            this.f6457e = Executors.newFixedThreadPool(5);
            if (Environment.getExternalStorageDirectory() != null) {
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tapjoy"));
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6454b.getFilesDir());
            sb.append("/Tapjoy/Cache/");
            this.f6458f = new File(sb.toString());
            if (!this.f6458f.exists()) {
                String str = "TapjoyCache";
                if (this.f6458f.mkdirs()) {
                    StringBuilder sb2 = new StringBuilder("Created directory at: ");
                    sb2.append(this.f6458f.getPath());
                    TapjoyLog.m6550d(str, sb2.toString());
                } else {
                    TapjoyLog.m6552e(str, "Error initalizing cache");
                    f6453a = null;
                }
            }
            m6512a();
        }
    }

    /* renamed from: a */
    private void m6512a() {
        SharedPreferences sharedPreferences = this.f6454b.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0);
        Editor edit = sharedPreferences.edit();
        for (Entry entry : sharedPreferences.getAll().entrySet()) {
            File file = new File((String) entry.getKey());
            String str = "TapjoyCache";
            if (!file.exists() || !file.isFile()) {
                StringBuilder sb = new StringBuilder("Removing reference to missing asset: ");
                sb.append((String) entry.getKey());
                TapjoyLog.m6550d(str, sb.toString());
                edit.remove((String) entry.getKey()).apply();
            } else {
                TapjoyCachedAssetData fromRawJSONString = TapjoyCachedAssetData.fromRawJSONString(entry.getValue().toString());
                String str2 = "Removing asset because deserialization failed.";
                if (fromRawJSONString != null) {
                    StringBuilder sb2 = new StringBuilder("Loaded Asset: ");
                    sb2.append(fromRawJSONString.getAssetURL());
                    TapjoyLog.m6550d(str, sb2.toString());
                    String b = m6514b(fromRawJSONString.getAssetURL());
                    if (b == null || "".equals(b) || b.length() <= 0) {
                        TapjoyLog.m6552e(str, str2);
                        edit.remove((String) entry.getKey()).apply();
                    } else if (fromRawJSONString.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000) {
                        StringBuilder sb3 = new StringBuilder("Asset expired, removing from cache: ");
                        sb3.append(fromRawJSONString.getAssetURL());
                        TapjoyLog.m6550d(str, sb3.toString());
                        if (fromRawJSONString.getLocalFilePath() != null && fromRawJSONString.getLocalFilePath().length() > 0) {
                            TapjoyUtil.deleteFileOrDirectory(new File(fromRawJSONString.getLocalFilePath()));
                        }
                    } else {
                        this.f6455c.put(b, fromRawJSONString);
                    }
                } else {
                    TapjoyLog.m6552e(str, str2);
                    edit.remove((String) entry.getKey()).apply();
                }
            }
        }
    }

    public void cacheAssetGroup(final JSONArray jSONArray, final TJCacheListener tJCacheListener) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            if (tJCacheListener != null) {
                tJCacheListener.onCachingComplete(1);
            }
            return;
        }
        new Thread() {
            public final void run() {
                String str = "Caching thread failed: ";
                StringBuilder sb = new StringBuilder("Starting to cache asset group size of ");
                sb.append(jSONArray.length());
                String str2 = "TapjoyCache";
                TapjoyLog.m6550d(str2, sb.toString());
                ArrayList<Future> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        Future cacheAssetFromJSONObject = TapjoyCache.this.cacheAssetFromJSONObject(jSONArray.getJSONObject(i));
                        if (cacheAssetFromJSONObject != null) {
                            arrayList.add(cacheAssetFromJSONObject);
                        }
                    } catch (JSONException unused) {
                        TapjoyLog.m6552e(str2, "Failed to load JSON object from JSONArray");
                    }
                }
                int i2 = 1;
                for (Future future : arrayList) {
                    try {
                        if (((Boolean) future.get()).booleanValue()) {
                        }
                    } catch (InterruptedException e) {
                        StringBuilder sb2 = new StringBuilder(str);
                        sb2.append(e.toString());
                        TapjoyLog.m6552e(str2, sb2.toString());
                    } catch (ExecutionException e2) {
                        StringBuilder sb3 = new StringBuilder(str);
                        sb3.append(e2.toString());
                        TapjoyLog.m6552e(str2, sb3.toString());
                    }
                    i2 = 2;
                }
                TapjoyLog.m6550d(str2, "Finished caching group");
                TJCacheListener tJCacheListener = tJCacheListener;
                if (tJCacheListener != null) {
                    tJCacheListener.onCachingComplete(i2);
                }
            }
        }.start();
    }

    public Future cacheAssetFromJSONObject(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("url");
            Long.valueOf(86400);
            return cacheAssetFromURL(string, jSONObject.optString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID), Long.valueOf(jSONObject.optLong(TapjoyConstants.TJC_TIME_TO_LIVE)).longValue());
        } catch (JSONException unused) {
            TapjoyLog.m6552e("TapjoyCache", "Required parameters to cache an asset from JSON is not present");
            return null;
        }
    }

    public Future cacheAssetFromURL(String str, String str2, long j) {
        String str3 = "TapjoyCache";
        try {
            URL url = new URL(str);
            if (!this.f6456d.contains(m6514b(str))) {
                return startCachingThread(url, str2, j);
            }
            StringBuilder sb = new StringBuilder("URL is already in the process of being cached: ");
            sb.append(str);
            TapjoyLog.m6550d(str3, sb.toString());
            return null;
        } catch (MalformedURLException unused) {
            TapjoyLog.m6550d(str3, "Invalid cache assetURL");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m6514b(String str) {
        if (str.startsWith("//")) {
            StringBuilder sb = new StringBuilder("http:");
            sb.append(str);
            str = sb.toString();
        }
        try {
            return new URL(str).getFile();
        } catch (MalformedURLException unused) {
            StringBuilder sb2 = new StringBuilder("Invalid URL ");
            sb2.append(str);
            TapjoyLog.m6552e("TapjoyCache", sb2.toString());
            return "";
        }
    }

    public Future startCachingThread(URL url, String str, long j) {
        if (url == null) {
            return null;
        }
        ExecutorService executorService = this.f6457e;
        CacheAssetThread cacheAssetThread = new CacheAssetThread(url, str, j);
        return executorService.submit(cacheAssetThread);
    }

    public void clearTapjoyCache() {
        String str = "TapjoyCache";
        TapjoyLog.m6550d(str, "Cleaning Tapjoy cache!");
        TapjoyUtil.deleteFileOrDirectory(this.f6458f);
        if (this.f6458f.mkdirs()) {
            StringBuilder sb = new StringBuilder("Created new cache directory at: ");
            sb.append(this.f6458f.getPath());
            TapjoyLog.m6550d(str, sb.toString());
        }
        this.f6455c = new TapjoyCacheMap(this.f6454b, -1);
    }

    public boolean removeAssetFromCache(String str) {
        String b = m6514b(str);
        return (b == "" || this.f6455c.remove((Object) b) == null) ? false : true;
    }

    public boolean isURLDownloading(String str) {
        if (this.f6456d != null) {
            String b = m6514b(str);
            if (b != "" && this.f6456d.contains(b)) {
                return true;
            }
        }
        return false;
    }

    public boolean isURLCached(String str) {
        return this.f6455c.get(m6514b(str)) != null;
    }

    public TapjoyCachedAssetData getCachedDataForURL(String str) {
        String b = m6514b(str);
        if (b != "") {
            return (TapjoyCachedAssetData) this.f6455c.get(b);
        }
        return null;
    }

    public TapjoyCacheMap getCachedData() {
        return this.f6455c;
    }

    public String getPathOfCachedURL(String str) {
        String b = m6514b(str);
        if (b == "" || !this.f6455c.containsKey(b)) {
            return str;
        }
        TapjoyCachedAssetData tapjoyCachedAssetData = (TapjoyCachedAssetData) this.f6455c.get(b);
        if (new File(tapjoyCachedAssetData.getLocalFilePath()).exists()) {
            return tapjoyCachedAssetData.getLocalURL();
        }
        getInstance().removeAssetFromCache(str);
        return str;
    }

    public String cachedAssetsToJSON() {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.f6455c.entrySet()) {
            try {
                jSONObject.put(((String) entry.getKey()).toString(), ((TapjoyCachedAssetData) entry.getValue()).toRawJSONString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String getCachedOfferIDs() {
        ArrayList arrayList = new ArrayList();
        TapjoyCacheMap tapjoyCacheMap = this.f6455c;
        if (tapjoyCacheMap == null) {
            return "";
        }
        for (Entry value : tapjoyCacheMap.entrySet()) {
            String offerId = ((TapjoyCachedAssetData) value.getValue()).getOfferId();
            if (!(offerId == null || offerId.length() == 0 || arrayList.contains(offerId))) {
                arrayList.add(offerId);
            }
        }
        return TextUtils.join(",", arrayList);
    }

    public void printCacheInformation() {
        String str = "TapjoyCache";
        TapjoyLog.m6550d(str, "------------- Cache Data -------------");
        StringBuilder sb = new StringBuilder("Number of files in cache: ");
        sb.append(this.f6455c.size());
        TapjoyLog.m6550d(str, sb.toString());
        StringBuilder sb2 = new StringBuilder("Cache Size: ");
        sb2.append(TapjoyUtil.fileOrDirectorySize(this.f6458f));
        TapjoyLog.m6550d(str, sb2.toString());
        TapjoyLog.m6550d(str, "--------------------------------------");
    }

    public static TapjoyCache getInstance() {
        return f6453a;
    }

    public static void setInstance(TapjoyCache tapjoyCache) {
        f6453a = tapjoyCache;
    }
}
