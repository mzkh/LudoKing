package com.unity3d.services.core.cache;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.unity3d.services.core.api.Request;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.WebRequest;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CacheThreadHandler extends Handler {
    private boolean _active = false;
    private boolean _canceled = false;
    private WebRequest _currentRequest = null;

    CacheThreadHandler() {
    }

    public void handleMessage(Message message) {
        HashMap hashMap;
        Bundle data = message.getData();
        String str = "source";
        String string = data.getString(str);
        data.remove(str);
        String str2 = "target";
        String string2 = data.getString(str2);
        data.remove(str2);
        String str3 = "connectTimeout";
        int i = data.getInt(str3);
        data.remove(str3);
        String str4 = "readTimeout";
        int i2 = data.getInt(str4);
        data.remove(str4);
        String str5 = "progressInterval";
        int i3 = data.getInt(str5);
        data.remove(str5);
        String str6 = "append";
        boolean z = data.getBoolean(str6, false);
        data.remove(str6);
        if (data.size() > 0) {
            DeviceLog.debug("There are headers left in data, reading them");
            HashMap hashMap2 = new HashMap();
            for (String str7 : data.keySet()) {
                hashMap2.put(str7, Arrays.asList(data.getStringArray(str7)));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        File file = new File(string2);
        if ((!z || file.exists()) && (z || !file.exists())) {
            if (message.what == 1) {
                downloadFile(string, string2, i, i2, i3, hashMap, z);
            }
            return;
        }
        this._active = false;
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.CACHE, CacheEvent.DOWNLOAD_ERROR, CacheError.FILE_STATE_WRONG, string, string2, Boolean.valueOf(z), Boolean.valueOf(file.exists()));
    }

    public void setCancelStatus(boolean z) {
        this._canceled = z;
        if (z) {
            WebRequest webRequest = this._currentRequest;
            if (webRequest != null) {
                this._active = false;
                webRequest.cancel();
            }
        }
    }

    public boolean isActive() {
        return this._active;
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v8, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r6v26 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r6v29 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* JADX WARNING: type inference failed for: r6v33 */
    /* JADX WARNING: type inference failed for: r6v36 */
    /* JADX WARNING: type inference failed for: r6v37 */
    /* JADX WARNING: type inference failed for: r6v38 */
    /* JADX WARNING: type inference failed for: r6v39 */
    /* JADX WARNING: type inference failed for: r6v40 */
    /* JADX WARNING: type inference failed for: r6v41 */
    /* JADX WARNING: type inference failed for: r6v42 */
    /* JADX WARNING: type inference failed for: r6v43 */
    /* JADX WARNING: type inference failed for: r6v44 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r6v47 */
    /* JADX WARNING: type inference failed for: r6v48 */
    /* JADX WARNING: type inference failed for: r6v49 */
    /* JADX WARNING: type inference failed for: r6v50 */
    /* JADX WARNING: type inference failed for: r6v51 */
    /* JADX WARNING: type inference failed for: r6v52 */
    /* JADX WARNING: type inference failed for: r6v53 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r6v55 */
    /* JADX WARNING: type inference failed for: r6v56 */
    /* JADX WARNING: type inference failed for: r6v57 */
    /* JADX WARNING: type inference failed for: r6v58 */
    /* JADX WARNING: type inference failed for: r6v59 */
    /* JADX WARNING: type inference failed for: r6v60 */
    /* JADX WARNING: type inference failed for: r6v61 */
    /* JADX WARNING: type inference failed for: r6v62 */
    /* JADX WARNING: type inference failed for: r6v63 */
    /* JADX WARNING: type inference failed for: r6v64 */
    /* JADX WARNING: type inference failed for: r6v65 */
    /* JADX WARNING: type inference failed for: r6v66 */
    /* JADX WARNING: type inference failed for: r6v67 */
    /* JADX WARNING: type inference failed for: r6v68 */
    /* JADX WARNING: type inference failed for: r6v69 */
    /* JADX WARNING: type inference failed for: r6v70 */
    /* JADX WARNING: type inference failed for: r6v71 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v1
      assigns: []
      uses: []
      mth insns count: 399
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
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02e0 A[SYNTHETIC, Splitter:B:110:0x02e0] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x030a A[SYNTHETIC, Splitter:B:119:0x030a] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01aa A[SYNTHETIC, Splitter:B:66:0x01aa] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f8 A[SYNTHETIC, Splitter:B:77:0x01f8] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0246 A[SYNTHETIC, Splitter:B:88:0x0246] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0294 A[SYNTHETIC, Splitter:B:99:0x0294] */
    /* JADX WARNING: Unknown variable types count: 27 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadFile(java.lang.String r24, java.lang.String r25, int r26, int r27, int r28, java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r29, boolean r30) {
        /*
            r23 = this;
            r13 = r23
            r14 = r24
            r0 = r25
            r1 = r30
            java.lang.String r15 = "Error closing stream"
            boolean r2 = r13._canceled
            if (r2 != 0) goto L_0x032d
            if (r14 == 0) goto L_0x032d
            if (r0 != 0) goto L_0x0014
            goto L_0x032d
        L_0x0014:
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            java.lang.String r2 = " to "
            if (r1 == 0) goto L_0x0049
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unity Ads cache: resuming download "
            r3.append(r4)
            r3.append(r14)
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = " at "
            r3.append(r0)
            long r6 = r5.length()
            r3.append(r6)
            java.lang.String r0 = " bytes"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r0)
            goto L_0x0063
        L_0x0049:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unity Ads cache: start downloading "
            r3.append(r4)
            r3.append(r14)
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r0)
        L_0x0063:
            boolean r0 = com.unity3d.services.core.device.Device.isActiveNetworkConnected()
            r12 = 2
            r11 = 1
            r10 = 0
            if (r0 != 0) goto L_0x0085
            java.lang.String r0 = "Unity Ads cache: download cancelled, no internet connection available"
            com.unity3d.services.core.log.DeviceLog.debug(r0)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r1 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r2 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r3 = new java.lang.Object[r12]
            com.unity3d.services.core.cache.CacheError r4 = com.unity3d.services.core.cache.CacheError.NO_INTERNET
            r3[r10] = r4
            r3[r11] = r14
            r0.sendEvent(r1, r2, r3)
            return
        L_0x0085:
            r13._active = r11
            long r2 = android.os.SystemClock.elapsedRealtime()
            r8 = 0
            r9 = 3
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x02b4, MalformedURLException -> 0x0268, IOException -> 0x021a, IllegalStateException -> 0x01cc, NetworkIOException -> 0x017e, all -> 0x0173 }
            r6.<init>(r5, r1)     // Catch:{ FileNotFoundException -> 0x02b4, MalformedURLException -> 0x0268, IOException -> 0x021a, IllegalStateException -> 0x01cc, NetworkIOException -> 0x017e, all -> 0x0173 }
            r0 = r26
            r1 = r27
            r4 = r29
            com.unity3d.services.core.request.WebRequest r0 = r13.getWebRequest(r14, r0, r1, r4)     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            r13._currentRequest = r0     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.cache.CacheThreadHandler$1 r1 = new com.unity3d.services.core.cache.CacheThreadHandler$1     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            r4 = r28
            r1.<init>(r5, r4)     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            r0.setProgressListener(r1)     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            long r16 = r0.makeStreamRequest(r6)     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            r13._active = r10     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            long r18 = r0.getContentLength()     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.request.WebRequest r0 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            boolean r0 = r0.isCanceled()     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.request.WebRequest r1 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            int r20 = r1.getResponseCode()     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            com.unity3d.services.core.request.WebRequest r1 = r13._currentRequest     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            java.util.Map r21 = r1.getResponseHeaders()     // Catch:{ FileNotFoundException -> 0x0165, MalformedURLException -> 0x0157, IOException -> 0x0149, IllegalStateException -> 0x013b, NetworkIOException -> 0x012e, all -> 0x011f }
            r1 = r23
            r4 = r24
            r22 = r6
            r6 = r16
            r14 = r8
            r8 = r18
            r10 = r0
            r16 = 1
            r11 = r20
            r17 = 2
            r12 = r21
            r1.postProcessDownload(r2, r4, r5, r6, r8, r10, r11, r12)     // Catch:{ FileNotFoundException -> 0x011b, MalformedURLException -> 0x0117, IOException -> 0x0113, IllegalStateException -> 0x010f, NetworkIOException -> 0x010b, all -> 0x0107 }
            r13._currentRequest = r14
            r22.close()     // Catch:{ Exception -> 0x00e8 }
            goto L_0x0302
        L_0x00e8:
            r0 = move-exception
            r1 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r1)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r6 = 0
            r4[r6] = r5
            r4[r16] = r24
            java.lang.String r1 = r1.getMessage()
            r4[r17] = r1
            goto L_0x02ff
        L_0x0107:
            r0 = move-exception
            r4 = 3
            r6 = 0
            goto L_0x0129
        L_0x010b:
            r0 = move-exception
            r4 = 3
            r6 = 0
            goto L_0x0138
        L_0x010f:
            r0 = move-exception
            r4 = 3
            r6 = 0
            goto L_0x0145
        L_0x0113:
            r0 = move-exception
            r4 = 3
            r6 = 0
            goto L_0x0153
        L_0x0117:
            r0 = move-exception
            r4 = 3
            r6 = 0
            goto L_0x0161
        L_0x011b:
            r0 = move-exception
            r4 = 3
            r6 = 0
            goto L_0x016f
        L_0x011f:
            r0 = move-exception
            r22 = r6
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0129:
            r1 = r0
            r8 = r22
            goto L_0x0306
        L_0x012e:
            r0 = move-exception
            r22 = r6
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0138:
            r8 = r22
            goto L_0x0186
        L_0x013b:
            r0 = move-exception
            r22 = r6
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0145:
            r8 = r22
            goto L_0x01d4
        L_0x0149:
            r0 = move-exception
            r22 = r6
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0153:
            r8 = r22
            goto L_0x0222
        L_0x0157:
            r0 = move-exception
            r22 = r6
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0161:
            r8 = r22
            goto L_0x0270
        L_0x0165:
            r0 = move-exception
            r22 = r6
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x016f:
            r8 = r22
            goto L_0x02bc
        L_0x0173:
            r0 = move-exception
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x017b:
            r1 = r0
            goto L_0x0306
        L_0x017e:
            r0 = move-exception
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0186:
            java.lang.String r1 = "Network error"
            com.unity3d.services.core.log.DeviceLog.exception(r1, r0)     // Catch:{ all -> 0x0303 }
            r13._active = r6     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x0303 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.NETWORK_ERROR     // Catch:{ all -> 0x0303 }
            r5[r6] = r7     // Catch:{ all -> 0x0303 }
            r5[r16] = r24     // Catch:{ all -> 0x0303 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0303 }
            r5[r17] = r0     // Catch:{ all -> 0x0303 }
            r1.sendEvent(r2, r3, r5)     // Catch:{ all -> 0x0303 }
            r13._currentRequest = r14
            if (r8 == 0) goto L_0x0302
            r8.close()     // Catch:{ Exception -> 0x01af }
            goto L_0x0302
        L_0x01af:
            r0 = move-exception
            r1 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r1)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r4[r6] = r5
            r4[r16] = r24
            java.lang.String r1 = r1.getMessage()
            r4[r17] = r1
            goto L_0x02ff
        L_0x01cc:
            r0 = move-exception
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x01d4:
            java.lang.String r1 = "Illegal state"
            com.unity3d.services.core.log.DeviceLog.exception(r1, r0)     // Catch:{ all -> 0x0303 }
            r13._active = r6     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x0303 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.ILLEGAL_STATE     // Catch:{ all -> 0x0303 }
            r5[r6] = r7     // Catch:{ all -> 0x0303 }
            r5[r16] = r24     // Catch:{ all -> 0x0303 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0303 }
            r5[r17] = r0     // Catch:{ all -> 0x0303 }
            r1.sendEvent(r2, r3, r5)     // Catch:{ all -> 0x0303 }
            r13._currentRequest = r14
            if (r8 == 0) goto L_0x0302
            r8.close()     // Catch:{ Exception -> 0x01fd }
            goto L_0x0302
        L_0x01fd:
            r0 = move-exception
            r1 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r1)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r4[r6] = r5
            r4[r16] = r24
            java.lang.String r1 = r1.getMessage()
            r4[r17] = r1
            goto L_0x02ff
        L_0x021a:
            r0 = move-exception
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0222:
            java.lang.String r1 = "Couldn't request stream"
            com.unity3d.services.core.log.DeviceLog.exception(r1, r0)     // Catch:{ all -> 0x0303 }
            r13._active = r6     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x0303 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch:{ all -> 0x0303 }
            r5[r6] = r7     // Catch:{ all -> 0x0303 }
            r5[r16] = r24     // Catch:{ all -> 0x0303 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0303 }
            r5[r17] = r0     // Catch:{ all -> 0x0303 }
            r1.sendEvent(r2, r3, r5)     // Catch:{ all -> 0x0303 }
            r13._currentRequest = r14
            if (r8 == 0) goto L_0x0302
            r8.close()     // Catch:{ Exception -> 0x024b }
            goto L_0x0302
        L_0x024b:
            r0 = move-exception
            r1 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r1)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r4[r6] = r5
            r4[r16] = r24
            java.lang.String r1 = r1.getMessage()
            r4[r17] = r1
            goto L_0x02ff
        L_0x0268:
            r0 = move-exception
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x0270:
            java.lang.String r1 = "Malformed URL"
            com.unity3d.services.core.log.DeviceLog.exception(r1, r0)     // Catch:{ all -> 0x0303 }
            r13._active = r6     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x0303 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.MALFORMED_URL     // Catch:{ all -> 0x0303 }
            r5[r6] = r7     // Catch:{ all -> 0x0303 }
            r5[r16] = r24     // Catch:{ all -> 0x0303 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0303 }
            r5[r17] = r0     // Catch:{ all -> 0x0303 }
            r1.sendEvent(r2, r3, r5)     // Catch:{ all -> 0x0303 }
            r13._currentRequest = r14
            if (r8 == 0) goto L_0x0302
            r8.close()     // Catch:{ Exception -> 0x0298 }
            goto L_0x0302
        L_0x0298:
            r0 = move-exception
            r1 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r1)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r4[r6] = r5
            r4[r16] = r24
            java.lang.String r1 = r1.getMessage()
            r4[r17] = r1
            goto L_0x02ff
        L_0x02b4:
            r0 = move-exception
            r14 = r8
            r4 = 3
            r6 = 0
            r16 = 1
            r17 = 2
        L_0x02bc:
            java.lang.String r1 = "Couldn't create target file"
            com.unity3d.services.core.log.DeviceLog.exception(r1, r0)     // Catch:{ all -> 0x0303 }
            r13._active = r6     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewApp r1 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR     // Catch:{ all -> 0x0303 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0303 }
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch:{ all -> 0x0303 }
            r5[r6] = r7     // Catch:{ all -> 0x0303 }
            r5[r16] = r24     // Catch:{ all -> 0x0303 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0303 }
            r5[r17] = r0     // Catch:{ all -> 0x0303 }
            r1.sendEvent(r2, r3, r5)     // Catch:{ all -> 0x0303 }
            r13._currentRequest = r14
            if (r8 == 0) goto L_0x0302
            r8.close()     // Catch:{ Exception -> 0x02e4 }
            goto L_0x0302
        L_0x02e4:
            r0 = move-exception
            r1 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r1)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r2 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r3 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r5 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r4[r6] = r5
            r4[r16] = r24
            java.lang.String r1 = r1.getMessage()
            r4[r17] = r1
        L_0x02ff:
            r0.sendEvent(r2, r3, r4)
        L_0x0302:
            return
        L_0x0303:
            r0 = move-exception
            goto L_0x017b
        L_0x0306:
            r13._currentRequest = r14
            if (r8 == 0) goto L_0x032c
            r8.close()     // Catch:{ Exception -> 0x030e }
            goto L_0x032c
        L_0x030e:
            r0 = move-exception
            r2 = r0
            com.unity3d.services.core.log.DeviceLog.exception(r15, r2)
            com.unity3d.services.core.webview.WebViewApp r0 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            com.unity3d.services.core.webview.WebViewEventCategory r3 = com.unity3d.services.core.webview.WebViewEventCategory.CACHE
            com.unity3d.services.core.cache.CacheEvent r5 = com.unity3d.services.core.cache.CacheEvent.DOWNLOAD_ERROR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.unity3d.services.core.cache.CacheError r7 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR
            r4[r6] = r7
            r4[r16] = r24
            java.lang.String r2 = r2.getMessage()
            r4[r17] = r2
            r0.sendEvent(r3, r5, r4)
        L_0x032c:
            throw r1
        L_0x032d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.cache.CacheThreadHandler.downloadFile(java.lang.String, java.lang.String, int, int, int, java.util.HashMap, boolean):void");
    }

    private void postProcessDownload(long j, String str, File file, long j2, long j3, boolean z, int i, Map<String, List<String>> map) {
        String str2 = str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (!file.setReadable(true, false)) {
            DeviceLog.debug("Unity Ads cache: could not set file readable!");
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads cache: File ");
            sb.append(file.getName());
            sb.append(" of ");
            sb.append(j2);
            sb.append(" bytes downloaded in ");
            sb.append(elapsedRealtime);
            sb.append("ms");
            DeviceLog.debug(sb.toString());
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.CACHE, CacheEvent.DOWNLOAD_END, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(elapsedRealtime), Integer.valueOf(i), Request.getResponseHeadersMap(map));
            return;
        }
        long j4 = j2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unity Ads cache: downloading of ");
        sb2.append(str2);
        sb2.append(" stopped");
        DeviceLog.debug(sb2.toString());
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.CACHE, CacheEvent.DOWNLOAD_STOPPED, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(elapsedRealtime), Integer.valueOf(i), Request.getResponseHeadersMap(map));
    }

    private WebRequest getWebRequest(String str, int i, int i2, HashMap<String, List<String>> hashMap) throws MalformedURLException {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        WebRequest webRequest = new WebRequest(str, "GET", hashMap2, i, i2);
        return webRequest;
    }
}
