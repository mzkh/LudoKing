package com.moat.analytics.mobile.inm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import androidx.annotation.FloatRange;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.s */
class C2738s {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f6136a;

    /* renamed from: b */
    private static C2740a f6137b;

    /* renamed from: c */
    private static C2741b f6138c;

    /* renamed from: com.moat.analytics.mobile.inm.s$a */
    static class C2740a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f6140a;

        /* renamed from: b */
        private String f6141b;

        /* renamed from: c */
        private String f6142c;

        /* renamed from: d */
        private String f6143d;

        private C2740a() {
            this.f6140a = false;
            String str = "_unknown_";
            this.f6141b = str;
            this.f6142c = str;
            this.f6143d = str;
            try {
                Context c = C2738s.m6323c();
                if (c != null) {
                    this.f6140a = true;
                    PackageManager packageManager = c.getPackageManager();
                    this.f6142c = c.getPackageName();
                    this.f6141b = packageManager.getApplicationLabel(c.getApplicationInfo()).toString();
                    this.f6143d = packageManager.getInstallerPackageName(this.f6142c);
                    return;
                }
                C2735p.m6310a(3, "Util", (Object) this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo29084a() {
            return this.f6141b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo29085b() {
            return this.f6142c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public String mo29086c() {
            String str = this.f6143d;
            return str != null ? str : "_unknown_";
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.s$b */
    static class C2741b {

        /* renamed from: a */
        String f6144a;

        /* renamed from: b */
        String f6145b;

        /* renamed from: c */
        Integer f6146c;

        /* renamed from: d */
        boolean f6147d;

        /* renamed from: e */
        boolean f6148e;

        /* renamed from: f */
        boolean f6149f;

        private C2741b() {
            String str = "_unknown_";
            this.f6144a = str;
            this.f6145b = str;
            this.f6146c = Integer.valueOf(-1);
            this.f6147d = false;
            this.f6148e = false;
            this.f6149f = false;
            try {
                Context c = C2738s.m6323c();
                if (c != null) {
                    this.f6149f = true;
                    TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
                    this.f6144a = telephonyManager.getSimOperatorName();
                    this.f6145b = telephonyManager.getNetworkOperatorName();
                    this.f6146c = Integer.valueOf(telephonyManager.getPhoneType());
                    this.f6147d = C2738s.m6329i();
                    this.f6148e = C2738s.m6322b(c);
                }
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }
    }

    C2738s() {
    }

    @FloatRange(from = 0.0d, mo650to = 1.0d)
    /* renamed from: a */
    static double m6318a() {
        try {
            double h = (double) m6328h();
            double streamMaxVolume = (double) ((AudioManager) C2695a.m6141a().getSystemService("audio")).getStreamMaxVolume(3);
            Double.isNaN(h);
            Double.isNaN(streamMaxVolume);
            return h / streamMaxVolume;
        } catch (Exception e) {
            C2726m.m6274a(e);
            return 0.0d;
        }
    }

    /* renamed from: a */
    static void m6320a(final Context context) {
        try {
            AsyncTask.execute(new Runnable() {
                public final void run() {
                    String str;
                    String str2 = "Util";
                    try {
                        Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{context});
                        if (!((Boolean) cls2.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])).booleanValue()) {
                            C2738s.f6136a = (String) cls2.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                            StringBuilder sb = new StringBuilder("Retrieved Advertising ID = ");
                            sb.append(C2738s.f6136a);
                            C2735p.m6310a(3, str2, (Object) this, sb.toString());
                            return;
                        }
                        C2735p.m6310a(3, str2, (Object) this, "User has limited ad tracking");
                    } catch (ClassNotFoundException e) {
                        e = e;
                        str = "ClassNotFoundException while retrieving Advertising ID";
                        C2735p.m6312a(str2, (Object) this, str, e);
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        str = "NoSuchMethodException while retrieving Advertising ID";
                        C2735p.m6312a(str2, (Object) this, str, e);
                    } catch (Exception e3) {
                        C2726m.m6274a(e3);
                    }
                }
            });
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: b */
    static String m6321b() {
        return f6136a;
    }

    /* renamed from: b */
    static boolean m6322b(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: c */
    static Context m6323c() {
        WeakReference<Context> weakReference = ((C2724k) MoatAnalytics.getInstance()).f6104e;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: d */
    static C2740a m6324d() {
        C2740a aVar = f6137b;
        if (aVar == null || !aVar.f6140a) {
            f6137b = new C2740a();
        }
        return f6137b;
    }

    /* renamed from: e */
    static C2741b m6325e() {
        C2741b bVar = f6138c;
        if (bVar == null || !bVar.f6149f) {
            f6138c = new C2741b();
        }
        return f6138c;
    }

    /* renamed from: h */
    private static int m6328h() {
        try {
            return ((AudioManager) C2695a.m6141a().getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m6329i() {
        int i;
        Context c = m6323c();
        if (c != null) {
            String str = "adb_enabled";
            i = VERSION.SDK_INT >= 17 ? Global.getInt(c.getContentResolver(), str, 0) : Secure.getInt(c.getContentResolver(), str, 0);
        } else {
            i = 0;
        }
        return i == 1;
    }
}
