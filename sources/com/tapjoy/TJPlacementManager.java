package com.tapjoy;

import android.content.Context;
import com.tapjoy.internal.C1852jq;
import com.tapjoy.internal.C2888az;
import com.tapjoy.internal.C3120gv;
import com.tapjoy.internal.C3136he;

public class TJPlacementManager {

    /* renamed from: a */
    private static final C2888az f6394a = C2888az.m6591a();

    /* renamed from: b */
    private static int f6395b = 0;

    /* renamed from: c */
    private static int f6396c = 0;

    /* renamed from: d */
    private static int f6397d = 3;

    /* renamed from: e */
    private static int f6398e = 3;

    /* renamed from: f */
    private static int f6399f = TapjoyConstants.TJC_PLACEMENT_RESPONSE_TIMEOUT;

    public static TJPlacement createPlacement(Context context, String str, boolean z, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a = m6494a(str, null, null, z, false);
        a.f6317j = z;
        a.f6310c.setPlacementType("sdk");
        a.setContext(context);
        return new TJPlacement(a, tJPlacementListener);
    }

    /* renamed from: a */
    public static TJPlacement m6495a(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (f6394a) {
            tJPlacement = new TJPlacement(m6494a(str, str2, str3, false, false), tJPlacementListener);
        }
        return tJPlacement;
    }

    /* renamed from: b */
    public static TJPlacement m6496b(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (f6394a) {
            tJPlacement = new TJPlacement(m6494a(str, str2, str3, false, true), tJPlacementListener);
        }
        return tJPlacement;
    }

    /* renamed from: a */
    static TJCorePlacement m6493a(String str) {
        TJCorePlacement tJCorePlacement;
        synchronized (f6394a) {
            tJCorePlacement = (TJCorePlacement) f6394a.get(str);
        }
        return tJCorePlacement;
    }

    public static void setCachedPlacementLimit(int i) {
        f6397d = i;
    }

    public static void setPreRenderedPlacementLimit(int i) {
        f6398e = i;
    }

    public static int getCachedPlacementLimit() {
        return f6397d;
    }

    public static int getPreRenderedPlacementLimit() {
        return f6398e;
    }

    public static int getCachedPlacementCount() {
        return f6395b;
    }

    public static int getPreRenderedPlacementCount() {
        return f6396c;
    }

    public static boolean canCachePlacement() {
        return getCachedPlacementCount() < getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement() {
        return getPreRenderedPlacementCount() < getPreRenderedPlacementLimit();
    }

    public static void incrementPlacementCacheCount() {
        int i = f6395b + 1;
        f6395b = i;
        int i2 = f6397d;
        if (i > i2) {
            f6395b = i2;
        }
        printPlacementCacheInformation();
    }

    public static void decrementPlacementCacheCount() {
        int i = f6395b - 1;
        f6395b = i;
        if (i < 0) {
            f6395b = 0;
        }
        printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount() {
        int i = f6396c + 1;
        f6396c = i;
        int i2 = f6398e;
        if (i > i2) {
            f6396c = i2;
        }
    }

    public static void decrementPlacementPreRenderCount() {
        int i = f6396c - 1;
        f6396c = i;
        if (i < 0) {
            f6396c = 0;
        }
    }

    public static void printPlacementCacheInformation() {
        StringBuilder sb = new StringBuilder("Space available in placement cache: ");
        sb.append(f6395b);
        sb.append(" out of ");
        sb.append(f6397d);
        TapjoyLog.m6553i("TJPlacementManager", sb.toString());
    }

    public static void printPlacementPreRenderInformation() {
        StringBuilder sb = new StringBuilder("Space available for placement pre-render: ");
        sb.append(f6396c);
        sb.append(" out of ");
        sb.append(f6398e);
        TapjoyLog.m6553i("TJPlacementManager", sb.toString());
    }

    public static void dismissContentShowing(boolean z) {
        if (z) {
            TJAdUnitActivity.m6429a();
        }
        C3136he.m7244a();
        C3120gv.m7207a();
    }

    public static void setPlacementResponseTimeOut(int i) {
        f6399f = i;
    }

    public static int getPlacementResponseTimeOut() {
        return f6399f;
    }

    /* renamed from: a */
    static TJCorePlacement m6494a(String str, String str2, String str3, boolean z, boolean z2) {
        TJCorePlacement a;
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "!SYSTEM!" : "");
        sb.append(!C1852jq.m3669c(str) ? str : "");
        if (C1852jq.m3669c(str2)) {
            str2 = "";
        }
        sb.append(str2);
        if (C1852jq.m3669c(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(Boolean.toString(z2));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("TJCorePlacement key=");
        sb3.append(sb2);
        TapjoyLog.m6550d("TJPlacementManager", sb3.toString());
        synchronized (f6394a) {
            a = m6493a(sb2);
            if (a == null) {
                a = new TJCorePlacement(str, sb2, z2);
                f6394a.put(sb2, a);
                StringBuilder sb4 = new StringBuilder("Created TJCorePlacement with GUID: ");
                sb4.append(a.f6311d);
                TapjoyLog.m6550d("TJPlacementManager", sb4.toString());
            }
        }
        return a;
    }
}
