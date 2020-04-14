package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppEventUtility {
    private static final String regex = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";

    public static void assertIsMainThread() {
    }

    public static void assertIsNotMainThread() {
    }

    public static double normalizePrice(String str) {
        try {
            Matcher matcher = Pattern.compile(regex, 8).matcher(str);
            if (!matcher.find()) {
                return 0.0d;
            }
            return NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(matcher.group(0)).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte valueOf : bArr) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
        }
        return stringBuffer.toString();
    }

    public static boolean isEmulator() {
        String str = Build.FINGERPRINT;
        String str2 = MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE;
        if (!str.startsWith(str2) && !Build.FINGERPRINT.startsWith("unknown")) {
            String str3 = "google_sdk";
            if (!Build.MODEL.contains(str3) && !Build.MODEL.contains("Emulator") && !Build.MODEL.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith(str2) || !Build.DEVICE.startsWith(str2)) && !str3.equals(Build.PRODUCT))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (NameNotFoundException unused) {
            return "";
        }
    }
}
