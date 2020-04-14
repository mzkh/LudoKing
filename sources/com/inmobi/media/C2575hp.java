package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.media.hp */
/* compiled from: WifiScanner */
public class C2575hp {

    /* renamed from: a */
    private static final String f5679a = "hp";
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    public static Context f5680b = null;

    /* renamed from: c */
    private static Handler f5681c = null;

    /* renamed from: d */
    private static boolean f5682d = false;

    /* renamed from: e */
    private static final IntentFilter f5683e = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static List<C2573hn> f5684f;

    /* renamed from: g */
    private static Runnable f5685g = new Runnable() {
        public final void run() {
            C2575hp.m5610e();
        }
    };
    @SuppressLint({"WifiManagerPotentialLeak", "MissingPermission"})

    /* renamed from: h */
    private static final BroadcastReceiver f5686h = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            WifiManager wifiManager = (WifiManager) C2575hp.f5680b.getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI);
            C2575hp.m5610e();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            C2568hj.m5581a();
            int i = C2568hj.m5583e().f5329e;
            boolean a = C2574ho.m5601a(i);
            boolean a2 = C2574ho.m5602a(i, 1);
            ArrayList arrayList = new ArrayList();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    if (!C2574ho.m5603a(a, scanResult.SSID)) {
                        String str = 0;
                        if (scanResult != null) {
                            C2573hn hnVar = new C2573hn();
                            hnVar.f5675a = C2574ho.m5599a(scanResult.BSSID);
                            if (!a2) {
                                str = scanResult.SSID;
                            }
                            hnVar.f5676b = str;
                            hnVar.f5677c = scanResult.level;
                            str = hnVar;
                        }
                        arrayList.add(str);
                    }
                }
            }
            C2575hp.f5684f = arrayList;
        }
    };

    /* renamed from: a */
    public static void m5605a() {
        f5680b = C2505gd.m5298c();
        m5606a(Looper.myLooper());
    }

    /* renamed from: b */
    public static List<C2573hn> m5607b() {
        return f5684f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        return;
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m5606a(android.os.Looper r6) {
        /*
            java.lang.Class<com.inmobi.media.hp> r0 = com.inmobi.media.C2575hp.class
            monitor-enter(r0)
            android.os.Handler r1 = f5681c     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            android.content.Context r1 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            java.lang.String r2 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ all -> 0x004a }
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0048
            boolean r2 = r1.isWifiEnabled()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0022
            goto L_0x0048
        L_0x0022:
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x004a }
            r2.<init>(r6)     // Catch:{ all -> 0x004a }
            f5681c = r2     // Catch:{ all -> 0x004a }
            java.lang.Runnable r6 = f5685g     // Catch:{ all -> 0x004a }
            r3 = 10000(0x2710, double:4.9407E-320)
            r2.postDelayed(r6, r3)     // Catch:{ all -> 0x004a }
            boolean r6 = f5682d     // Catch:{ all -> 0x004a }
            if (r6 != 0) goto L_0x0043
            r6 = 1
            f5682d = r6     // Catch:{ all -> 0x004a }
            android.content.Context r6 = f5680b     // Catch:{ all -> 0x004a }
            android.content.BroadcastReceiver r2 = f5686h     // Catch:{ all -> 0x004a }
            android.content.IntentFilter r3 = f5683e     // Catch:{ all -> 0x004a }
            r4 = 0
            android.os.Handler r5 = f5681c     // Catch:{ all -> 0x004a }
            r6.registerReceiver(r2, r3, r4, r5)     // Catch:{ all -> 0x004a }
        L_0x0043:
            r1.startScan()     // Catch:{ all -> 0x004a }
            monitor-exit(r0)
            return
        L_0x0048:
            monitor-exit(r0)
            return
        L_0x004a:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2575hp.m5606a(android.os.Looper):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static synchronized void m5610e() {
        synchronized (C2575hp.class) {
            if (f5681c != null) {
                f5681c.removeCallbacks(f5685g);
                if (f5682d) {
                    f5682d = false;
                    try {
                        f5680b.unregisterReceiver(f5686h);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                f5681c = null;
                f5680b = null;
            }
        }
    }
}
