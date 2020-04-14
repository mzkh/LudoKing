package com.inmobi.media;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@TargetApi(17)
/* renamed from: com.inmobi.media.hm */
/* compiled from: CellularInfoUtil */
public class C2572hm {

    /* renamed from: a */
    private static final String f5673a = "hm";

    /* renamed from: a */
    private static boolean m5595a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    public static Map<String, String> m5594a(String str) {
        Object obj;
        HashMap hashMap = new HashMap();
        Context c = C2505gd.m5298c();
        if (c == null) {
            return hashMap;
        }
        C2568hj.m5581a();
        String l = C2505gd.m5314l();
        C2578hq b = C2579hs.m5621b();
        String str2 = null;
        String e = b != null ? b.mo28576e() : null;
        if (!((l == null || C2568hj.m5580a(l).f5333i) && (e == null || b.mo28574c()) && (!(b != null && b.mo28575d()) || C2568hj.m5580a(e).f5333i))) {
            return hashMap;
        }
        String g = "InMobi".equals(str) ? C2505gd.m5308g() : C2505gd.m5310h();
        C2568hj.m5581a();
        int i = C2568hj.m5580a(g).f5332h;
        boolean a = m5595a(i, 2);
        boolean a2 = m5595a(i, 1);
        C2570hk hkVar = new C2570hk();
        TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
        if (!a) {
            int[] b2 = m5597b(telephonyManager.getNetworkOperator());
            hkVar.f5664a = b2[0];
            hkVar.f5665b = b2[1];
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (networkCountryIso != null) {
                hkVar.f5668e = networkCountryIso.toLowerCase(Locale.ENGLISH);
            }
        }
        if (!a2) {
            int[] b3 = m5597b(telephonyManager.getSimOperator());
            hkVar.f5666c = b3[0];
            hkVar.f5667d = b3[1];
        }
        String str3 = "_";
        if (hkVar.f5666c == -1 && hkVar.f5667d == -1) {
            obj = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(hkVar.f5666c);
            sb.append(str3);
            sb.append(hkVar.f5667d);
            obj = sb.toString();
        }
        hashMap.put("s-ho", obj);
        if (!(hkVar.f5664a == -1 && hkVar.f5665b == -1)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(hkVar.f5664a);
            sb2.append(str3);
            sb2.append(hkVar.f5665b);
            str2 = sb2.toString();
        }
        hashMap.put("s-co", str2);
        hashMap.put("s-iso", hkVar.f5668e);
        hashMap.put("s-cn", C2527gp.m5387a(c));
        return hashMap;
    }

    /* renamed from: b */
    private static int[] m5597b(String str) {
        int[] iArr = {-1, -1};
        if (str != null && !"".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str.substring(0, 3));
                int parseInt2 = Integer.parseInt(str.substring(3));
                iArr[0] = parseInt;
                iArr[1] = parseInt2;
            } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            }
        }
        return iArr;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private static boolean m5598c() {
        if (VERSION.SDK_INT < 28) {
            return true;
        }
        LocationManager locationManager = (LocationManager) C2505gd.m5298c().getSystemService(Param.LOCATION);
        if (locationManager == null || !locationManager.isLocationEnabled()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> m5593a() {
        /*
            com.inmobi.media.C2568hj.m5581a()
            java.lang.String r0 = com.inmobi.media.C2505gd.m5314l()
            com.inmobi.media.hq r1 = com.inmobi.media.C2579hs.m5621b()
            r2 = 0
            if (r1 == 0) goto L_0x0013
            java.lang.String r3 = r1.mo28576e()
            goto L_0x0014
        L_0x0013:
            r3 = r2
        L_0x0014:
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0020
            boolean r6 = r1.mo28575d()
            if (r6 == 0) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            if (r0 == 0) goto L_0x002e
            com.inmobi.media.fb$b r0 = com.inmobi.media.C2568hj.m5580a(r0)
            boolean r0 = r0.f5335k
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            if (r3 == 0) goto L_0x003a
            boolean r1 = r1.mo28574c()
            if (r1 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r1 = 0
            goto L_0x003b
        L_0x003a:
            r1 = 1
        L_0x003b:
            if (r6 == 0) goto L_0x0048
            com.inmobi.media.fb$b r3 = com.inmobi.media.C2568hj.m5580a(r3)
            boolean r3 = r3.f5335k
            if (r3 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r3 = 0
            goto L_0x0049
        L_0x0048:
            r3 = 1
        L_0x0049:
            if (r0 == 0) goto L_0x0051
            if (r1 == 0) goto L_0x0051
            if (r3 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x0125
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()
            if (r0 == 0) goto L_0x0073
            java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r1 = com.inmobi.media.C2516gj.m5357a(r0, r1)
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.inmobi.media.C2516gj.m5357a(r0, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r3 < r6) goto L_0x006d
            goto L_0x0074
        L_0x006d:
            if (r1 != 0) goto L_0x0071
            if (r0 == 0) goto L_0x0073
        L_0x0071:
            r0 = 1
            goto L_0x0074
        L_0x0073:
            r0 = 0
        L_0x0074:
            if (r0 == 0) goto L_0x0125
            boolean r0 = m5598c()
            if (r0 != 0) goto L_0x007e
            goto L_0x0125
        L_0x007e:
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()
            if (r0 != 0) goto L_0x0086
            goto L_0x0125
        L_0x0086:
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = r0.getNetworkOperator()
            int[] r1 = m5597b(r1)
            r3 = r1[r5]
            java.lang.String r6 = java.lang.String.valueOf(r3)
            r3 = r1[r4]
            java.lang.String r7 = java.lang.String.valueOf(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            if (r3 < r4) goto L_0x00d1
            java.util.List r3 = r0.getAllCellInfo()
            if (r3 == 0) goto L_0x00d1
            r8 = r2
            r4 = 0
        L_0x00b0:
            int r9 = r3.size()
            if (r4 >= r9) goto L_0x00c5
            java.lang.Object r8 = r3.get(r4)
            android.telephony.CellInfo r8 = (android.telephony.CellInfo) r8
            boolean r9 = r8.isRegistered()
            if (r9 != 0) goto L_0x00c5
            int r4 = r4 + 1
            goto L_0x00b0
        L_0x00c5:
            if (r8 == 0) goto L_0x00d1
            com.inmobi.media.hl r2 = new com.inmobi.media.hl
            int r0 = r0.getNetworkType()
            r2.<init>(r8, r6, r7, r0)
            goto L_0x0125
        L_0x00d1:
            android.telephony.CellLocation r3 = r0.getCellLocation()
            if (r3 == 0) goto L_0x0125
            r1 = r1[r5]
            r4 = -1
            if (r1 != r4) goto L_0x00dd
            goto L_0x0125
        L_0x00dd:
            com.inmobi.media.hl r2 = new com.inmobi.media.hl
            r2.<init>()
            boolean r1 = r3 instanceof android.telephony.cdma.CdmaCellLocation
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == 0) goto L_0x0106
            android.telephony.cdma.CdmaCellLocation r3 = (android.telephony.cdma.CdmaCellLocation) r3
            r2.f5671b = r4
            int r0 = r0.getNetworkType()
            r2.f5672c = r0
            int r0 = r3.getSystemId()
            int r1 = r3.getNetworkId()
            int r3 = r3.getBaseStationId()
            java.lang.String r0 = com.inmobi.media.C2571hl.m5590a(r6, r0, r1, r3)
            r2.f5670a = r0
            goto L_0x0125
        L_0x0106:
            android.telephony.gsm.GsmCellLocation r3 = (android.telephony.gsm.GsmCellLocation) r3
            r2.f5671b = r4
            int r0 = r0.getNetworkType()
            r2.f5672c = r0
            int r8 = r3.getLac()
            int r9 = r3.getCid()
            int r10 = r3.getPsc()
            r11 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r0 = com.inmobi.media.C2571hl.m5591a(r6, r7, r8, r9, r10, r11)
            r2.f5670a = r0
        L_0x0125:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r2 == 0) goto L_0x0139
            org.json.JSONObject r1 = r2.mo28569a()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "c-sc"
            r0.put(r2, r1)
        L_0x0139:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2572hm.m5593a():java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f8  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> m5596b() {
        /*
            boolean r0 = com.inmobi.media.C2505gd.m5292a()
            r1 = 1
            if (r0 == 0) goto L_0x00e8
            boolean r0 = com.inmobi.media.C2505gd.m5292a()
            r2 = 0
            if (r0 == 0) goto L_0x002f
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.inmobi.media.C2516gj.m5357a(r0, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x001f
            goto L_0x0030
        L_0x001f:
            android.content.Context r3 = com.inmobi.media.C2505gd.m5298c()
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r3 = com.inmobi.media.C2516gj.m5357a(r3, r4)
            if (r3 != 0) goto L_0x002d
            if (r0 == 0) goto L_0x002f
        L_0x002d:
            r0 = 1
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x00e8
            boolean r0 = m5598c()
            if (r0 == 0) goto L_0x00e8
            com.inmobi.media.C2568hj.m5581a()
            java.lang.String r0 = com.inmobi.media.C2505gd.m5314l()
            com.inmobi.media.hq r3 = com.inmobi.media.C2579hs.m5621b()
            if (r3 == 0) goto L_0x004a
            java.lang.String r4 = r3.mo28576e()
            goto L_0x004b
        L_0x004a:
            r4 = 0
        L_0x004b:
            if (r3 == 0) goto L_0x0055
            boolean r5 = r3.mo28575d()
            if (r5 == 0) goto L_0x0055
            r5 = 1
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x0063
            com.inmobi.media.fb$b r0 = com.inmobi.media.C2568hj.m5580a(r0)
            boolean r0 = r0.f5334j
            if (r0 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r0 = 0
            goto L_0x0064
        L_0x0063:
            r0 = 1
        L_0x0064:
            if (r4 == 0) goto L_0x006f
            boolean r3 = r3.mo28574c()
            if (r3 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r3 = 0
            goto L_0x0070
        L_0x006f:
            r3 = 1
        L_0x0070:
            if (r5 == 0) goto L_0x007d
            com.inmobi.media.fb$b r4 = com.inmobi.media.C2568hj.m5580a(r4)
            boolean r4 = r4.f5334j
            if (r4 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r4 = 0
            goto L_0x007e
        L_0x007d:
            r4 = 1
        L_0x007e:
            if (r0 == 0) goto L_0x0086
            if (r3 == 0) goto L_0x0086
            if (r4 == 0) goto L_0x0086
            r0 = 1
            goto L_0x0087
        L_0x0086:
            r0 = 0
        L_0x0087:
            if (r0 != 0) goto L_0x008a
            goto L_0x00e8
        L_0x008a:
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()
            if (r0 != 0) goto L_0x0096
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            goto L_0x00ed
        L_0x0096:
            java.lang.String r3 = "phone"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = r0.getNetworkOperator()
            int[] r4 = m5597b(r4)
            r2 = r4[r2]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r4 = r4[r1]
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 17
            if (r5 < r6) goto L_0x00e6
            java.util.List r5 = r0.getAllCellInfo()
            if (r5 == 0) goto L_0x00e6
            java.util.Iterator r5 = r5.iterator()
        L_0x00c7:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e6
            java.lang.Object r6 = r5.next()
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6
            boolean r7 = r6.isRegistered()
            if (r7 != 0) goto L_0x00c7
            com.inmobi.media.hl r7 = new com.inmobi.media.hl
            int r8 = r0.getNetworkType()
            r7.<init>(r6, r2, r4, r8)
            r3.add(r7)
            goto L_0x00c7
        L_0x00e6:
            r0 = r3
            goto L_0x00ed
        L_0x00e8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x00ed:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0118
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            int r4 = r0.size()
            int r4 = r4 - r1
            java.lang.Object r0 = r0.get(r4)
            com.inmobi.media.hl r0 = (com.inmobi.media.C2571hl) r0
            org.json.JSONObject r0 = r0.mo28569a()
            r3.put(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "v-sc"
            r2.put(r1, r0)
        L_0x0118:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2572hm.m5596b():java.util.Map");
    }
}
