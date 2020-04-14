package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.inmobi.media.gp */
/* compiled from: DeviceInfo */
public class C2527gp {
    @SuppressLint({"MissingPermission", "NewApi"})
    /* renamed from: c */
    private static String m5391c() {
        Context c = C2505gd.m5298c();
        String str = "";
        if (c == null) {
            return str;
        }
        String str2 = "1";
        if (C2516gj.m5357a(c, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (VERSION.SDK_INT < 28) {
                        int type = activeNetworkInfo.getType();
                        int subtype = activeNetworkInfo.getSubtype();
                        if (type == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(type);
                            sb.append("|");
                            sb.append(subtype);
                            str = sb.toString();
                        } else if (type != 1) {
                            str = Integer.toString(type);
                        }
                    } else {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                        if (networkCapabilities != null) {
                            if (networkCapabilities.hasTransport(0)) {
                                StringBuilder sb2 = new StringBuilder("0|");
                                sb2.append(activeNetworkInfo.getSubtype());
                                str = sb2.toString();
                            } else if (!networkCapabilities.hasTransport(1)) {
                                str = networkCapabilities.hasTransport(2) ? "7" : networkCapabilities.hasTransport(3) ? "9" : networkCapabilities.hasTransport(4) ? "17" : networkCapabilities.hasTransport(5) ? "10" : networkCapabilities.hasTransport(6) ? "11" : "8";
                            }
                        }
                    }
                    str = str2;
                }
            }
        }
        return str;
    }

    @NonNull
    /* renamed from: a */
    public static String m5387a(@NonNull Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
    }

    /* renamed from: a */
    public static Map<String, String> m5388a(boolean z) {
        int i;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("d-brand-name", Build.BRAND);
            hashMap.put("d-manufacturer-name", Build.MANUFACTURER);
            hashMap.put("d-model-name", Build.MODEL);
            hashMap.put("d-nettype-raw", m5391c());
            hashMap.put("d-localization", Locale.getDefault().toString());
            hashMap.put("d-language", Locale.getDefault().getLanguage());
            String str = "d-media-volume";
            Context c = C2505gd.m5298c();
            if (c != null) {
                if (!z) {
                    AudioManager audioManager = (AudioManager) c.getSystemService("audio");
                    i = (audioManager.getStreamVolume(3) * 100) / audioManager.getStreamMaxVolume(3);
                    hashMap.put(str, String.valueOf(i));
                    return hashMap;
                }
            }
            i = 0;
            hashMap.put(str, String.valueOf(i));
        } catch (Exception unused) {
            C2527gp.class.getSimpleName();
        }
        return hashMap;
    }

    /* renamed from: a */
    public static int m5386a() {
        String c = m5391c();
        if (c.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return 0;
        }
        return c.startsWith("1") ? 1 : 2;
    }

    /* renamed from: b */
    public static String m5390b() {
        int a = m5386a();
        if (a != 0) {
            return a != 1 ? "NIL" : TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
        }
        return "carrier";
    }

    /* renamed from: b */
    public static int m5389b(@NonNull Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
    }
}
