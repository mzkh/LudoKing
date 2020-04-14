package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;

/* renamed from: com.appsflyer.internal.ag */
public final class C1347ag {

    /* renamed from: ˊ */
    private static String f3443;

    C1347ag() {
    }

    /* renamed from: ॱ */
    public static synchronized String m3284(WeakReference<Context> weakReference) {
        synchronized (C1347ag.class) {
            if (weakReference.get() == null) {
                String str = f3443;
                return str;
            }
            if (f3443 == null) {
                String str2 = null;
                if (weakReference.get() != null) {
                    str2 = AppsFlyerLibCore.m3225((Context) weakReference.get()).getString("AF_INSTALLATION", null);
                }
                if (str2 != null) {
                    f3443 = str2;
                } else {
                    try {
                        File file = new File(((Context) weakReference.get()).getFilesDir(), "AF_INSTALLATION");
                        if (!file.exists()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            StringBuilder sb = new StringBuilder();
                            sb.append(currentTimeMillis);
                            sb.append("-");
                            sb.append(Math.abs(new SecureRandom().nextLong()));
                            f3443 = sb.toString();
                        } else {
                            f3443 = m3283(file);
                            file.delete();
                        }
                        String str3 = f3443;
                        Editor edit = AppsFlyerLibCore.m3225((Context) weakReference.get()).edit();
                        edit.putString("AF_INSTALLATION", str3);
                        edit.apply();
                    } catch (Exception e) {
                        AFLogger.afErrorLog("Error getting AF unique ID", e);
                    }
                }
                if (f3443 != null) {
                    AppsFlyerProperties.getInstance().set("uid", f3443);
                }
            }
            String str4 = f3443;
            return str4;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[SYNTHETIC, Splitter:B:20:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004a A[SYNTHETIC, Splitter:B:31:0x004a] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: ˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3283(java.io.File r6) {
        /*
            java.lang.String r0 = "Exception while trying to close the InstallationFile"
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x002a }
            java.lang.String r3 = "r"
            r2.<init>(r6, r3)     // Catch:{ IOException -> 0x002a }
            long r3 = r2.length()     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            int r6 = (int) r3     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            byte[] r1 = new byte[r6]     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            r2.readFully(r1)     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            r2.close()     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            r2.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x003c
        L_0x001b:
            r6 = move-exception
            com.appsflyer.AFLogger.afErrorLog(r0, r6)
            goto L_0x003c
        L_0x0020:
            r6 = move-exception
            r1 = r2
            goto L_0x0048
        L_0x0023:
            r6 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x002c
        L_0x0028:
            r6 = move-exception
            goto L_0x0048
        L_0x002a:
            r6 = move-exception
            r2 = r1
        L_0x002c:
            java.lang.String r3 = "Exception while reading InstallationFile: "
            com.appsflyer.AFLogger.afErrorLog(r3, r6)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r6 = move-exception
            com.appsflyer.AFLogger.afErrorLog(r0, r6)
        L_0x003b:
            r1 = r2
        L_0x003c:
            java.lang.String r6 = new java.lang.String
            if (r1 == 0) goto L_0x0041
            goto L_0x0044
        L_0x0041:
            r0 = 0
            byte[] r1 = new byte[r0]
        L_0x0044:
            r6.<init>(r1)
            return r6
        L_0x0048:
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r1 = move-exception
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
        L_0x0052:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1347ag.m3283(java.io.File):java.lang.String");
    }
}
