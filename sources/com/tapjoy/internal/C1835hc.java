package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.C3023eu.C3024a;
import com.tapjoy.internal.C3041fa.C3042a;
import com.tapjoy.internal.C3053fe.C3054a;
import com.tapjoy.internal.C3062fh.C3063a;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: com.tapjoy.internal.hc */
public final class C1835hc {

    /* renamed from: a */
    public static final String f3840a = UUID.randomUUID().toString();

    /* renamed from: d */
    private static C1835hc f3841d;

    /* renamed from: b */
    public final C3063a f3842b = new C3063a();

    /* renamed from: c */
    public final C3144hj f3843c;

    /* renamed from: e */
    private final C3042a f3844e = new C3042a();

    /* renamed from: f */
    private final C3024a f3845f = new C3024a();

    /* renamed from: g */
    private final Context f3846g;

    /* renamed from: a */
    public static synchronized C1835hc m3607a(Context context) {
        C1835hc hcVar;
        synchronized (C1835hc.class) {
            if (f3841d == null) {
                f3841d = new C1835hc(context, C3144hj.m7269a(context));
            }
            hcVar = f3841d;
        }
        return hcVar;
    }

    private C1835hc(Context context, C3144hj hjVar) {
        C3147hn.m7278a();
        C3042a aVar = this.f3844e;
        aVar.f7095p = "12.4.1/Android";
        aVar.f7086g = "Android";
        aVar.f7087h = VERSION.RELEASE;
        this.f3844e.f7084e = Build.MANUFACTURER;
        this.f3844e.f7085f = Build.MODEL;
        this.f3844e.f7091l = Locale.getDefault().toString();
        this.f3844e.f7092m = TimeZone.getDefault().getID();
        Context applicationContext = context.getApplicationContext();
        this.f3846g = applicationContext;
        C3042a aVar2 = this.f3844e;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        File file = new File(C1831gz.m3559c(applicationContext), "deviceid");
        String str = TapjoyConstants.PREF_ANALYTICS_ID;
        String string = sharedPreferences.getString(str, null);
        if (C1852jq.m3669c(string)) {
            String b = file.exists() ? C1852jq.m3668b(C1810bg.m3457a(file)) : null;
            if (b == null) {
                b = UUID.randomUUID().toString();
            }
            string = b;
            Editor edit = sharedPreferences.edit();
            edit.putString(str, string);
            edit.apply();
        }
        aVar2.f7083d = string;
        if (!C3091ga.m7138b().mo18107a(TapjoyConnectFlag.DISABLE_ANDROID_ID_AS_ANALYTICS_ID, true)) {
            C3042a aVar3 = this.f3844e;
            String string2 = Secure.getString(applicationContext.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            aVar3.f7099t = !"9774d56d682e549c".equals(string2) ? C1852jq.m3668b(string2) : null;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        if (telephonyManager != null) {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!C1852jq.m3669c(simCountryIso)) {
                this.f3844e.f7096q = simCountryIso.toUpperCase(Locale.US);
            }
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!C1852jq.m3669c(networkCountryIso)) {
                this.f3844e.f7097r = networkCountryIso.toUpperCase(Locale.US);
            }
        }
        String packageName = applicationContext.getPackageName();
        C3042a aVar4 = this.f3844e;
        aVar4.f7093n = packageName;
        Signature[] e = C1862z.m3705e(packageManager, packageName);
        aVar4.f7094o = C1852jq.m3667a((e == null || e.length <= 0) ? null : Base64.encodeToString(C2922ch.m6677a(e[0].toByteArray()), 2));
        this.f3845f.f6968c = C1862z.m3701a(packageManager, packageName);
        this.f3845f.f6969d = Integer.valueOf(C1862z.m3702b(packageManager, packageName));
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (!C1852jq.m3669c(installerPackageName)) {
            this.f3845f.f6971f = installerPackageName;
        }
        String a = m3608a(packageManager, packageName);
        if (!C1852jq.m3669c(a)) {
            this.f3845f.f6972g = a;
        }
        mo18157a();
        this.f3843c = hjVar;
        String a2 = this.f3843c.f7430c.mo30368a();
        if (a2 != null && a2.length() > 0) {
            C3042a aVar5 = this.f3844e;
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(" 12.4.1/Android");
            aVar5.f7095p = sb.toString();
        }
        String b2 = this.f3843c.mo30219b();
        if (b2 != null) {
            this.f3842b.f7207d = b2;
        }
        C3063a aVar6 = this.f3842b;
        C3144hj hjVar2 = this.f3843c;
        String str2 = "it";
        long j = hjVar2.f7429b.getLong(str2, 0);
        if (j == 0) {
            Context context2 = hjVar2.f7428a;
            j = C1862z.m3703c(context2.getPackageManager(), context2.getPackageName());
            if (j == 0) {
                j = C1831gz.m3560d(hjVar2.f7428a).lastModified();
                if (j == 0) {
                    Context context3 = hjVar2.f7428a;
                    j = new File(C1862z.m3704d(context3.getPackageManager(), context3.getPackageName())).lastModified();
                    if (j == 0) {
                        j = System.currentTimeMillis();
                    }
                }
            }
            hjVar2.f7429b.edit().putLong(str2, j).apply();
        }
        aVar6.f7206c = Long.valueOf(j);
        int b3 = this.f3843c.f7433f.mo30349b();
        this.f3842b.f7208e = Integer.valueOf(m3606a(7, b3));
        this.f3842b.f7209f = Integer.valueOf(m3606a(30, b3));
        int b4 = this.f3843c.f7435h.mo30349b();
        if (b4 > 0) {
            this.f3842b.f7211h = Integer.valueOf(b4);
        }
        long a3 = this.f3843c.f7436i.mo30362a();
        if (a3 > 0) {
            this.f3842b.f7212i = Long.valueOf(a3);
        }
        long a4 = this.f3843c.f7437j.mo30362a();
        if (a4 > 0) {
            this.f3842b.f7213j = Long.valueOf(a4);
        }
        long a5 = this.f3843c.f7438k.mo30362a();
        if (a5 > 0) {
            this.f3842b.f7214k = Long.valueOf(a5);
        }
        String a6 = this.f3843c.f7439l.mo30368a();
        if (a6 != null) {
            this.f3842b.f7215l = a6;
        }
        int b5 = this.f3843c.f7440m.mo30349b();
        if (b5 > 0) {
            this.f3842b.f7216m = Integer.valueOf(b5);
        }
        double a7 = this.f3843c.f7441n.mo30231a();
        if (a7 != 0.0d) {
            this.f3842b.f7217n = Double.valueOf(a7);
        }
        long a8 = this.f3843c.f7442o.mo30362a();
        if (a8 > 0) {
            this.f3842b.f7218o = Long.valueOf(a8);
        }
        double a9 = this.f3843c.f7443p.mo30231a();
        if (a9 != 0.0d) {
            this.f3842b.f7219p = Double.valueOf(a9);
        }
        String a10 = this.f3843c.f7434g.mo30368a();
        if (a10 != null) {
            try {
                C3056ff ffVar = (C3056ff) C3056ff.f7156c.mo29991a(Base64.decode(a10, 2));
                this.f3842b.f7210g.clear();
                this.f3842b.f7210g.addAll(ffVar.f7157d);
            } catch (IllegalArgumentException unused) {
                this.f3843c.f7434g.mo30366c();
            } catch (IOException unused2) {
                this.f3843c.f7434g.mo30366c();
            }
        }
        this.f3845f.f6970e = this.f3843c.f7444q.mo30368a();
        this.f3842b.f7222s = this.f3843c.f7445r.mo30368a();
        int intValue = this.f3843c.f7446s.mo30346a().intValue();
        this.f3842b.f7223t = intValue != -1 ? Integer.valueOf(intValue) : null;
        int intValue2 = this.f3843c.f7447t.mo30346a().intValue();
        this.f3842b.f7224u = intValue2 != -1 ? Integer.valueOf(intValue2) : null;
        this.f3842b.f7225v = this.f3843c.f7448u.mo30368a();
        this.f3842b.f7226w = this.f3843c.f7449v.mo30368a();
        this.f3842b.f7227x = this.f3843c.f7450w.mo30368a();
        this.f3842b.f7228y = this.f3843c.f7451x.mo30368a();
        this.f3842b.f7229z = this.f3843c.f7452y.mo30368a();
        String a11 = this.f3843c.f7453z.mo30368a();
        if (a11 != null) {
            try {
                C3059fg fgVar = (C3059fg) C3059fg.f7159c.mo29991a(Base64.decode(a11, 2));
                this.f3842b.f7204A.clear();
                this.f3842b.f7204A.addAll(fgVar.f7160d);
            } catch (IllegalArgumentException unused3) {
                this.f3843c.f7453z.mo30366c();
            } catch (IOException unused4) {
                this.f3843c.f7453z.mo30366c();
            }
        }
        String a12 = this.f3843c.f7424A.mo30368a();
        boolean booleanValue = this.f3843c.f7425B.mo30203a().booleanValue();
        if (a12 != null) {
            C3063a aVar7 = this.f3842b;
            aVar7.f7220q = a12;
            aVar7.f7221r = Boolean.valueOf(booleanValue);
        } else {
            C3063a aVar8 = this.f3842b;
            aVar8.f7220q = null;
            aVar8.f7221r = null;
        }
        this.f3842b.f7205B = this.f3843c.f7426C.mo30203a();
    }

    /* renamed from: a */
    private static String m3608a(PackageManager packageManager, String str) {
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, 128).metaData;
            if (bundle != null) {
                Object obj = bundle.get("com.tapjoy.appstore");
                if (obj != null) {
                    return obj.toString().trim();
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0057 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18157a() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            android.content.Context r1 = r4.f3846g     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "window"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0057 }
            android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ Exception -> 0x0057 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ Exception -> 0x0057 }
            r1.getMetrics(r0)     // Catch:{ Exception -> 0x0057 }
            android.app.Activity r1 = com.tapjoy.internal.C3114gr.m7195a()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x0036
            android.view.Window r1 = r1.getWindow()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x0036
            int r2 = r0.heightPixels     // Catch:{ Exception -> 0x0057 }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ Exception -> 0x0057 }
            r3.<init>()     // Catch:{ Exception -> 0x0057 }
            android.view.View r1 = r1.getDecorView()     // Catch:{ Exception -> 0x0057 }
            r1.getWindowVisibleDisplayFrame(r3)     // Catch:{ Exception -> 0x0057 }
            int r1 = r3.top     // Catch:{ Exception -> 0x0057 }
            int r2 = r2 - r1
            r0.heightPixels = r2     // Catch:{ Exception -> 0x0057 }
        L_0x0036:
            com.tapjoy.internal.fa$a r1 = r4.f3844e     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.densityDpi     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0057 }
            r1.f7088i = r2     // Catch:{ Exception -> 0x0057 }
            com.tapjoy.internal.fa$a r1 = r4.f3844e     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.widthPixels     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0057 }
            r1.f7089j = r2     // Catch:{ Exception -> 0x0057 }
            com.tapjoy.internal.fa$a r1 = r4.f3844e     // Catch:{ Exception -> 0x0057 }
            int r0 = r0.heightPixels     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0057 }
            r1.f7090k = r0     // Catch:{ Exception -> 0x0057 }
            goto L_0x0057
        L_0x0055:
            r0 = move-exception
            goto L_0x0059
        L_0x0057:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            return
        L_0x0059:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1835hc.mo18157a():void");
    }

    /* renamed from: b */
    public final C3044fb mo18163b() {
        C3044fb fbVar;
        synchronized (this) {
            this.f3844e.f7091l = Locale.getDefault().toString();
            this.f3844e.f7092m = TimeZone.getDefault().getID();
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis() - 259200000;
            Iterator it = this.f3842b.f7210g.iterator();
            while (it.hasNext()) {
                if (((C3053fe) it.next()).f7151g.longValue() <= currentTimeMillis) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                m3609g();
            }
            fbVar = new C3044fb(this.f3844e.mo30097b(), this.f3845f.mo30082b(), this.f3842b.mo30119b());
        }
        return fbVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final String mo18166c() {
        String a;
        synchronized (this) {
            a = this.f3843c.f7431d.mo30368a();
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00dc  */
    @javax.annotation.Nullable
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tapjoy.internal.C3047fc mo18168d() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0141 }
            r2 = 1
            int r3 = r0.get(r2)     // Catch:{ all -> 0x0141 }
            int r3 = r3 * 10000
            r4 = 2
            int r5 = r0.get(r4)     // Catch:{ all -> 0x0141 }
            int r5 = r5 * 100
            int r3 = r3 + r5
            int r3 = r3 + 100
            r5 = 5
            int r6 = r0.get(r5)     // Catch:{ all -> 0x0141 }
            int r3 = r3 + r6
            com.tapjoy.internal.hj r6 = r1.f3843c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r6 = r6.f7432e     // Catch:{ all -> 0x0141 }
            java.lang.Integer r6 = r6.mo30346a()     // Catch:{ all -> 0x0141 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0141 }
            r7 = 0
            if (r6 == r3) goto L_0x013f
            if (r6 != 0) goto L_0x004a
            com.tapjoy.internal.fh$a r0 = r1.f3842b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0141 }
            r0.f7208e = r4     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fh$a r0 = r1.f3842b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0141 }
            r0.f7209f = r4     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fc r0 = new com.tapjoy.internal.fc     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "fq7_0_1"
            java.lang.String r5 = "fq30_0_1"
            r0.<init>(r4, r5, r7)     // Catch:{ all -> 0x0141 }
            goto L_0x012f
        L_0x004a:
            com.tapjoy.internal.hj r8 = r1.f3843c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r8 = r8.f7433f     // Catch:{ all -> 0x0141 }
            java.lang.Integer r8 = r8.mo30346a()     // Catch:{ all -> 0x0141 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0141 }
            r9 = 7
            int r10 = m3606a(r9, r8)     // Catch:{ all -> 0x0141 }
            r11 = 30
            int r12 = m3606a(r11, r8)     // Catch:{ all -> 0x0141 }
            java.util.Calendar r13 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0141 }
            int r14 = r6 / 10000
            int r15 = r6 / 100
            int r15 = r15 % 100
            int r15 = r15 - r2
            int r6 = r6 % 100
            r13.set(r14, r15, r6)     // Catch:{ all -> 0x0141 }
            int r6 = r0.get(r2)     // Catch:{ all -> 0x0141 }
            int r14 = r13.get(r2)     // Catch:{ all -> 0x0141 }
            int r6 = r6 - r14
            int r6 = java.lang.Integer.signum(r6)     // Catch:{ all -> 0x0141 }
            r14 = -1
            if (r6 == r14) goto L_0x00a8
            if (r6 == r2) goto L_0x008e
            r4 = 6
            int r0 = r0.get(r4)     // Catch:{ all -> 0x0141 }
            int r4 = r13.get(r4)     // Catch:{ all -> 0x0141 }
            int r0 = r0 - r4
            goto L_0x00d4
        L_0x008e:
            java.lang.Object r14 = r0.clone()     // Catch:{ all -> 0x0141 }
            java.util.Calendar r14 = (java.util.Calendar) r14     // Catch:{ all -> 0x0141 }
            int r15 = r13.get(r2)     // Catch:{ all -> 0x0141 }
            int r4 = r13.get(r4)     // Catch:{ all -> 0x0141 }
            int r13 = r13.get(r5)     // Catch:{ all -> 0x0141 }
            r14.set(r15, r4, r13)     // Catch:{ all -> 0x0141 }
            long r16 = r0.getTimeInMillis()     // Catch:{ all -> 0x0141 }
            goto L_0x00c1
        L_0x00a8:
            java.lang.Object r14 = r13.clone()     // Catch:{ all -> 0x0141 }
            java.util.Calendar r14 = (java.util.Calendar) r14     // Catch:{ all -> 0x0141 }
            int r15 = r0.get(r2)     // Catch:{ all -> 0x0141 }
            int r4 = r0.get(r4)     // Catch:{ all -> 0x0141 }
            int r0 = r0.get(r5)     // Catch:{ all -> 0x0141 }
            r14.set(r15, r4, r0)     // Catch:{ all -> 0x0141 }
            long r16 = r13.getTimeInMillis()     // Catch:{ all -> 0x0141 }
        L_0x00c1:
            r0 = 0
        L_0x00c2:
            long r18 = r14.getTimeInMillis()     // Catch:{ all -> 0x0141 }
            int r4 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x00d0
            r14.add(r5, r2)     // Catch:{ all -> 0x0141 }
            int r0 = r0 + 1
            goto L_0x00c2
        L_0x00d0:
            if (r6 <= 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            int r0 = -r0
        L_0x00d4:
            int r4 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0141 }
            if (r4 < r11) goto L_0x00dc
            r15 = 0
            goto L_0x00e4
        L_0x00dc:
            if (r0 < 0) goto L_0x00e1
            int r15 = r8 << r0
            goto L_0x00e4
        L_0x00e1:
            int r0 = -r0
            int r15 = r8 >> r0
        L_0x00e4:
            r2 = r2 | r15
            int r0 = m3606a(r9, r2)     // Catch:{ all -> 0x0141 }
            int r4 = m3606a(r11, r2)     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fh$a r5 = r1.f3842b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0141 }
            r5.f7208e = r6     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fh$a r5 = r1.f3842b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0141 }
            r5.f7209f = r6     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fc r5 = new com.tapjoy.internal.fc     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "fq7_"
            r6.<init>(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r10)     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "_"
            r6.append(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r0)     // Catch:{ all -> 0x0141 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "fq30_"
            r6.<init>(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r12)     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "_"
            r6.append(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r4)     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0141 }
            r5.<init>(r0, r4, r7)     // Catch:{ all -> 0x0141 }
            r0 = r5
        L_0x012f:
            com.tapjoy.internal.hj r4 = r1.f3843c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r4 = r4.f7432e     // Catch:{ all -> 0x0141 }
            r4.mo30347a(r3)     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.hj r3 = r1.f3843c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r3 = r3.f7433f     // Catch:{ all -> 0x0141 }
            r3.mo30347a(r2)     // Catch:{ all -> 0x0141 }
            monitor-exit(r20)     // Catch:{ all -> 0x0141 }
            return r0
        L_0x013f:
            monitor-exit(r20)     // Catch:{ all -> 0x0141 }
            return r7
        L_0x0141:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x0141 }
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1835hc.mo18168d():com.tapjoy.internal.fc");
    }

    /* renamed from: a */
    private static int m3606a(int i, int i2) {
        return Integer.bitCount(((1 << i) - 1) & i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo18161a(String str, long j, boolean z) {
        synchronized (this) {
            int size = this.f3842b.f7210g.size();
            int i = 0;
            while (i < size) {
                C3053fe feVar = (C3053fe) this.f3842b.f7210g.get(i);
                if (!feVar.f7150f.equals(str)) {
                    i++;
                } else if (!z) {
                    return false;
                } else {
                    C3054a b = feVar.mo30107b();
                    b.f7154d = Long.valueOf(j);
                    this.f3842b.f7210g.set(i, b.mo30110b());
                    return true;
                }
            }
            this.f3842b.f7210g.add(new C3053fe(str, Long.valueOf(j)));
            m3609g();
            return true;
        }
    }

    /* renamed from: g */
    private void m3609g() {
        this.f3843c.f7434g.mo30369a(Base64.encodeToString(C3056ff.f7156c.mo29994b(new C3056ff(this.f3842b.f7210g)), 2));
    }

    /* renamed from: a */
    public final boolean mo18160a(String str) {
        boolean z;
        synchronized (this) {
            this.f3843c.f7444q.mo30369a(str);
            z = true;
            if (str != null) {
                if (C1851jo.m3665a(this.f3845f.f6970e, str)) {
                    z = false;
                }
                this.f3845f.f6970e = str;
            } else {
                if (this.f3845f.f6970e == null) {
                    z = false;
                }
                this.f3845f.f6970e = null;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo18165b(String str) {
        boolean z;
        synchronized (this) {
            this.f3843c.f7445r.mo30369a(str);
            z = !C1851jo.m3665a(this.f3842b.f7222s, str);
            if (z) {
                this.f3842b.f7222s = str;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo18159a(Integer num) {
        boolean z;
        synchronized (this) {
            this.f3843c.f7446s.mo30348a(num);
            z = !C1851jo.m3665a(this.f3842b.f7223t, num);
            if (z) {
                this.f3842b.f7223t = num;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo18164b(Integer num) {
        boolean z;
        synchronized (this) {
            this.f3843c.f7447t.mo30348a(num);
            z = !C1851jo.m3665a(this.f3842b.f7224u, num);
            if (z) {
                this.f3842b.f7224u = num;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo18158a(int i, String str) {
        boolean z;
        synchronized (this) {
            z = false;
            if (i == 1) {
                this.f3843c.f7448u.mo30369a(str);
                z = !C1851jo.m3665a(this.f3842b.f7225v, str);
                if (z) {
                    this.f3842b.f7225v = str;
                }
            } else if (i == 2) {
                this.f3843c.f7449v.mo30369a(str);
                z = !C1851jo.m3665a(this.f3842b.f7226w, str);
                if (z) {
                    this.f3842b.f7226w = str;
                }
            } else if (i == 3) {
                this.f3843c.f7450w.mo30369a(str);
                z = !C1851jo.m3665a(this.f3842b.f7227x, str);
                if (z) {
                    this.f3842b.f7227x = str;
                }
            } else if (i == 4) {
                this.f3843c.f7451x.mo30369a(str);
                z = !C1851jo.m3665a(this.f3842b.f7228y, str);
                if (z) {
                    this.f3842b.f7228y = str;
                }
            } else if (i == 5) {
                this.f3843c.f7452y.mo30369a(str);
                z = !C1851jo.m3665a(this.f3842b.f7229z, str);
                if (z) {
                    this.f3842b.f7229z = str;
                }
            }
        }
        return z;
    }

    /* renamed from: e */
    public final Set mo18169e() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f3842b.f7204A);
        }
        return hashSet;
    }

    /* renamed from: c */
    public final boolean mo18167c(String str) {
        synchronized (this) {
            for (int size = this.f3842b.f7210g.size() - 1; size >= 0; size--) {
                C3053fe feVar = (C3053fe) this.f3842b.f7210g.get(size);
                if (feVar.f7150f.equals(str)) {
                    C3054a b = feVar.mo30107b();
                    b.f7155e = Long.valueOf(System.currentTimeMillis());
                    this.f3842b.f7210g.set(size, b.mo30110b());
                    m3609g();
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: f */
    public final boolean mo18170f() {
        return ((Boolean) C1851jo.m3666b(this.f3842b.f7205B, C3062fh.f7177r)).booleanValue();
    }

    /* renamed from: a */
    public final boolean mo18162a(boolean z) {
        boolean z2;
        synchronized (this) {
            this.f3843c.f7426C.mo30204a(z);
            z2 = z != ((Boolean) C1851jo.m3666b(this.f3842b.f7205B, C3062fh.f7177r)).booleanValue();
            this.f3842b.f7205B = Boolean.valueOf(z);
        }
        return z2;
    }
}
