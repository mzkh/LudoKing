package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C3124gw;

public class TapjoyLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f6593a = "TapjoyLog";

    /* renamed from: b */
    private static int f6594b = 6;

    /* renamed from: c */
    private static int f6595c = 4;

    /* renamed from: d */
    private static int f6596d = 2;

    /* renamed from: e */
    private static boolean f6597e = false;

    /* renamed from: f */
    private static int f6598f = f6594b;

    public static void setDebugEnabled(boolean z) {
        boolean z2;
        f6597e = z;
        C1831gz a = C1831gz.m3554a();
        if (C3124gw.f7370a != z) {
            C3124gw.f7370a = z;
            if (z) {
                C3124gw.m7216a("The debug mode has been enabled");
            } else {
                C3124gw.m7216a("The debug mode has been disabled");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && z && a.f3827k) {
            a.f3825i.mo30199a();
        }
        if (f6597e) {
            m6549a(TapjoyConstants.LOG_LEVEL_DEBUG_ON, false);
        } else {
            m6549a(TapjoyConstants.LOG_LEVEL_DEBUG_OFF, false);
        }
    }

    public static void setInternalLogging(boolean z) {
        if (z) {
            m6549a(TapjoyConstants.LOG_LEVEL_INTERNAL, true);
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    static void m6549a(String str, boolean z) {
        if (z || TapjoyAppSettings.getInstance() == null || TapjoyAppSettings.getInstance().f6450a == null) {
            if (str.equals(TapjoyConstants.LOG_LEVEL_INTERNAL)) {
                f6598f = f6596d;
                if (VERSION.SDK_INT >= 19) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            TapjoyLog.m6550d(TapjoyLog.f6593a, "Enabling WebView debugging");
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    });
                }
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_ON)) {
                f6598f = f6595c;
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_OFF)) {
                f6598f = f6594b;
            } else {
                String str2 = f6593a;
                StringBuilder sb = new StringBuilder("unrecognized loggingLevel: ");
                sb.append(str);
                m6550d(str2, sb.toString());
                f6598f = f6594b;
            }
            String str3 = f6593a;
            StringBuilder sb2 = new StringBuilder("logThreshold=");
            sb2.append(f6598f);
            m6550d(str3, sb2.toString());
            return;
        }
        m6550d(f6593a, "setLoggingLevel -- log setting already persisted");
    }

    public static boolean isLoggingEnabled() {
        return f6597e;
    }

    /* renamed from: i */
    public static void m6553i(String str, String str2) {
        m6548a(4, str, str2);
    }

    /* renamed from: e */
    public static void m6552e(String str, String str2) {
        m6551e(str, new TapjoyErrorMessage(ErrorType.INTERNAL_ERROR, str2));
    }

    /* renamed from: e */
    public static void m6551e(String str, TapjoyErrorMessage tapjoyErrorMessage) {
        if (tapjoyErrorMessage == null) {
            return;
        }
        if (f6598f == f6596d || tapjoyErrorMessage.getType() != ErrorType.INTERNAL_ERROR) {
            m6548a(6, str, tapjoyErrorMessage.toString());
        }
    }

    /* renamed from: w */
    public static void m6555w(String str, String str2) {
        m6548a(5, str, str2);
    }

    /* renamed from: d */
    public static void m6550d(String str, String str2) {
        m6548a(3, str, str2);
    }

    /* renamed from: v */
    public static void m6554v(String str, String str2) {
        m6548a(2, str, str2);
    }

    /* renamed from: a */
    private static void m6548a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(f6593a);
        sb.append(":");
        sb.append(str);
        String sb2 = sb.toString();
        if (f6598f <= i) {
            if (str2.length() > 4096) {
                int i2 = 0;
                while (i2 <= str2.length() / 4096) {
                    int i3 = i2 * 4096;
                    i2++;
                    int i4 = i2 * 4096;
                    if (i4 > str2.length()) {
                        i4 = str2.length();
                    }
                    Log.println(i, sb2, str2.substring(i3, i4));
                }
                return;
            }
            Log.println(i, sb2, str2);
        }
    }
}
