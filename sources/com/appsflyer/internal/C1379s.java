package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;

/* renamed from: com.appsflyer.internal.s */
public final class C1379s {

    /* renamed from: com.appsflyer.internal.s$d */
    public static final class C1380d {

        /* renamed from: ˊ */
        public static final C1379s f3585 = new C1379s();
    }

    /* renamed from: com.appsflyer.internal.s$e */
    public static final class C1381e {

        /* renamed from: ˊ */
        public final String f3586;

        /* renamed from: ˋ */
        public final String f3587;

        /* renamed from: ˏ */
        public final String f3588;

        C1381e(@NonNull String str, @Nullable String str2, @Nullable String str3) {
            this.f3587 = str;
            this.f3586 = str2;
            this.f3588 = str3;
        }
    }

    C1379s() {
    }

    /* renamed from: ˎ */
    public static C1381e m3346(@NonNull Context context) {
        String str;
        String str2 = "unknown";
        String str3 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String str4 = "MOBILE";
            String str5 = "WIFI";
            if (connectivityManager != null) {
                boolean z = false;
                if (21 <= VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i]);
                        if (!(networkInfo != null && networkInfo.isConnectedOrConnecting())) {
                            i++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                    if (!(networkInfo2 != null && networkInfo2.isConnectedOrConnecting())) {
                        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                        if (!(networkInfo3 != null && networkInfo3.isConnectedOrConnecting())) {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                                z = true;
                            }
                            if (z) {
                                if (1 != activeNetworkInfo.getType()) {
                                    if (activeNetworkInfo.getType() == 0) {
                                    }
                                }
                            }
                        }
                        str2 = str4;
                    }
                }
                str2 = str5;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager.getSimOperatorName();
            try {
                str3 = telephonyManager.getNetworkOperatorName();
                if ((str3 == null || str3.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str3 = "CDMA";
                }
            } catch (Throwable th) {
                th = th;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                return new C1381e(str2, str3, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            return new C1381e(str2, str3, str);
        }
        return new C1381e(str2, str3, str);
    }
}
