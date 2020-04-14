package com.unity3d.services.core.misc;

import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class Utilities {
    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (j > 0) {
            handler.postDelayed(runnable, j);
        } else {
            handler.post(runnable);
        }
    }

    public static String Sha256(String str) {
        return Sha256(str.getBytes());
    }

    public static String Sha256(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr, 0, bArr.length);
            return toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String Sha256(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return toHexString(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            byte b2 = b & 255;
            if (b2 <= 15) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(Integer.toHexString(b2));
            str = sb2.toString();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[SYNTHETIC, Splitter:B:23:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[SYNTHETIC, Splitter:B:31:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeFile(java.io.File r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "Error closing FileOutputStream"
            r1 = 0
            if (r5 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r2 = 0
            r3 = 1
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0029 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0029 }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r4.write(r6)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r4.flush()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r4.close()     // Catch:{ Exception -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L_0x001f:
            r1 = 1
            goto L_0x0039
        L_0x0021:
            r5 = move-exception
            r2 = r4
            goto L_0x0054
        L_0x0024:
            r6 = move-exception
            r2 = r4
            goto L_0x002a
        L_0x0027:
            r5 = move-exception
            goto L_0x0054
        L_0x0029:
            r6 = move-exception
        L_0x002a:
            java.lang.String r3 = "Could not write file"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r6)     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L_0x0039:
            if (r1 == 0) goto L_0x0053
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Wrote file: "
            r6.append(r0)
            java.lang.String r5 = r5.getAbsolutePath()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r5)
        L_0x0053:
            return r1
        L_0x0054:
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L_0x005e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.Utilities.writeFile(java.io.File, java.lang.String):boolean");
    }

    public static byte[] readFileBytes(File file) throws IOException {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[((int) file.length())];
        int i = 0;
        int i2 = 4096;
        long j = (long) 4096;
        if (file.length() < j) {
            i2 = (int) file.length();
        }
        while (true) {
            int read = fileInputStream.read(bArr, i, i2);
            if (read > 0) {
                i += read;
                if (file.length() - ((long) i) < j) {
                    i2 = ((int) file.length()) - i;
                }
            } else {
                fileInputStream.close();
                return bArr;
            }
        }
    }

    public static JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            jSONObject3.put(str, jSONObject2.get(str));
        }
        Iterator keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String str2 = (String) keys2.next();
            if (!jSONObject3.has(str2) || !(jSONObject3.get(str2) instanceof JSONObject) || !(jSONObject.get(str2) instanceof JSONObject)) {
                jSONObject3.put(str2, jSONObject.get(str2));
            } else {
                jSONObject3.put(str2, mergeJsonObjects(jSONObject.getJSONObject(str2), jSONObject3.getJSONObject(str2)));
            }
        }
        return jSONObject3;
    }
}
