package com.inmobi.media;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.inmobi.media.ho */
/* compiled from: WifiInfoUtil */
public final class C2574ho {
    /* renamed from: a */
    public static boolean m5602a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    public static boolean m5601a(int i) {
        return !m5602a(i, 2);
    }

    /* renamed from: a */
    public static C2573hn m5600a(boolean z, boolean z2) {
        C2573hn hnVar;
        String str = "\"";
        Context c = C2505gd.m5298c();
        if (c == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) c.getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                String bssid = connectionInfo.getBSSID();
                String ssid = connectionInfo.getSSID();
                if (bssid != null && !m5603a(z, ssid)) {
                    hnVar = new C2573hn();
                    try {
                        hnVar.f5675a = m5599a(bssid);
                        String substring = (ssid == null || !ssid.startsWith(str) || !ssid.endsWith(str)) ? ssid : ssid.substring(1, ssid.length() - 1);
                        if (z2) {
                            substring = null;
                        }
                        hnVar.f5676b = substring;
                        hnVar.f5677c = connectionInfo.getRssi();
                        hnVar.f5678d = connectionInfo.getIpAddress();
                    } catch (Exception e) {
                        e = e;
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                        return hnVar;
                    }
                    return hnVar;
                }
            }
            hnVar = null;
        } catch (Exception e2) {
            e = e2;
            hnVar = null;
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return hnVar;
        }
        return hnVar;
    }

    /* renamed from: a */
    static boolean m5603a(boolean z, String str) {
        return z && str != null && str.endsWith("_nomap");
    }

    /* renamed from: a */
    static long m5599a(String str) {
        String[] split = str.split("\\:");
        byte[] bArr = new byte[6];
        int i = 0;
        while (i < 6) {
            try {
                bArr[i] = (byte) Integer.parseInt(split[i], 16);
                i++;
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ((((long) bArr[0]) & 255) << 40) | ((((long) bArr[3]) & 255) << 16) | (((long) bArr[5]) & 255) | ((((long) bArr[4]) & 255) << 8) | ((((long) bArr[2]) & 255) << 24) | ((((long) bArr[1]) & 255) << 32);
    }
}
