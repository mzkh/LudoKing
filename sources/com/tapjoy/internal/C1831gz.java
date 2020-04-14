package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.C3026ev.C3027a;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.gz */
public final class C1831gz {

    /* renamed from: q */
    private static final C1831gz f3813q;

    /* renamed from: r */
    private static C1831gz f3814r;

    /* renamed from: w */
    private static Handler f3815w;

    /* renamed from: x */
    private static File f3816x;

    /* renamed from: a */
    public final C3142hh f3817a = new C3142hh(this);

    /* renamed from: b */
    public C3143hi f3818b;

    /* renamed from: c */
    public boolean f3819c = false;

    /* renamed from: d */
    public String f3820d = null;

    /* renamed from: e */
    public Context f3821e;

    /* renamed from: f */
    public C1835hc f3822f;

    /* renamed from: g */
    public C1830gy f3823g;

    /* renamed from: h */
    public C1840hm f3824h;

    /* renamed from: i */
    public C3125gx f3825i;

    /* renamed from: j */
    public String f3826j;

    /* renamed from: k */
    public boolean f3827k;

    /* renamed from: l */
    public String f3828l;

    /* renamed from: m */
    public String f3829m;

    /* renamed from: n */
    public boolean f3830n = false;

    /* renamed from: o */
    public String f3831o;

    /* renamed from: p */
    public C3128ha f3832p = C3128ha.m7230a((C3111go) null);

    /* renamed from: s */
    private boolean f3833s = false;

    /* renamed from: t */
    private boolean f3834t = false;

    /* renamed from: u */
    private String f3835u;

    /* renamed from: v */
    private String f3836v;

    static {
        C1831gz gzVar = new C1831gz();
        f3813q = gzVar;
        f3814r = gzVar;
    }

    /* renamed from: a */
    public static C1831gz m3554a() {
        return f3814r;
    }

    private C1831gz() {
    }

    /* renamed from: b */
    public final synchronized void mo18127b(Context context) {
        if (this.f3821e == null) {
            Context applicationContext = context.getApplicationContext();
            this.f3821e = applicationContext;
            C3091ga.m7137a().mo30164a(applicationContext);
            this.f3822f = C1835hc.m3607a(applicationContext);
            File file = new File(m3559c(applicationContext), "events2");
            if (this.f3825i == null) {
                this.f3825i = new C3125gx(file);
            }
            this.f3823g = new C1830gy(this.f3822f, this.f3825i);
            this.f3824h = new C1840hm(this.f3823g);
            this.f3818b = new C3143hi(applicationContext);
            C1823gf.m3514a(new C3105gh(new File(m3559c(applicationContext), "usages"), this.f3823g));
            C3155ht htVar = C3155ht.f7479a;
            htVar.f7480b = applicationContext.getApplicationContext();
            htVar.f7481c = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
            htVar.f7482d = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
            htVar.mo30223a();
        }
    }

    /* renamed from: a */
    public final C3044fb mo18118a(boolean z) {
        if (z) {
            this.f3822f.mo18157a();
        }
        return this.f3822f.mo18163b();
    }

    /* renamed from: b */
    public final synchronized void mo18126b() {
        if (this.f3827k) {
            C1833hb.m3584b(this.f3821e).mo18142e(this.f3820d);
            mo18120a((String) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18120a(@javax.annotation.Nullable final java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f3827k     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0040
            if (r6 != 0) goto L_0x000d
            java.lang.String r0 = r5.f3831o     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000d
            java.lang.String r6 = r5.f3831o     // Catch:{ all -> 0x0046 }
        L_0x000d:
            r0 = 0
            r5.f3831o = r0     // Catch:{ all -> 0x0046 }
            if (r6 == 0) goto L_0x0044
            com.tapjoy.internal.hc r0 = r5.f3822f     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.fb r0 = r0.mo18163b()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "GCM registration id of device {} updated for sender {}: {}"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r3 = 0
            com.tapjoy.internal.fa r4 = r0.f7101d     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = r4.f7065h     // Catch:{ all -> 0x0046 }
            r2[r3] = r4     // Catch:{ all -> 0x0046 }
            r3 = 1
            java.lang.String r4 = r5.f3820d     // Catch:{ all -> 0x0046 }
            r2[r3] = r4     // Catch:{ all -> 0x0046 }
            r3 = 2
            r2[r3] = r6     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.C3124gw.m7218a(r1, r2)     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.il r1 = new com.tapjoy.internal.il     // Catch:{ all -> 0x0046 }
            r1.<init>(r0, r6)     // Catch:{ all -> 0x0046 }
            com.tapjoy.internal.gz$1 r0 = new com.tapjoy.internal.gz$1     // Catch:{ all -> 0x0046 }
            r0.<init>(r6)     // Catch:{ all -> 0x0046 }
            java.util.concurrent.ExecutorService r6 = com.tapjoy.internal.C1817ca.f3777a     // Catch:{ all -> 0x0046 }
            r1.mo18082a(r0, r6)     // Catch:{ all -> 0x0046 }
            monitor-exit(r5)
            return
        L_0x0040:
            if (r6 == 0) goto L_0x0044
            r5.f3831o = r6     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r5)
            return
        L_0x0046:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1831gz.mo18120a(java.lang.String):void");
    }

    /* renamed from: b */
    public final void mo18128b(String str) {
        C1830gy gyVar = this.f3823g;
        C3027a a = gyVar.mo18113a(C3035ey.APP, "push_ignore");
        a.f7026s = new C3047fc(null, null, str);
        gyVar.mo18114a(a);
    }

    /* renamed from: a */
    public final boolean mo18125a(Context context, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo18127b(context);
        if (!this.f3822f.mo18161a(str, currentTimeMillis, z)) {
            return false;
        }
        C1830gy gyVar = this.f3823g;
        C3027a a = gyVar.mo18113a(C3035ey.APP, "push_show");
        a.f7026s = new C3047fc(null, null, str);
        gyVar.mo18114a(a);
        return true;
    }

    /* renamed from: a */
    public static void m3557a(GLSurfaceView gLSurfaceView) {
        if (C3124gw.m7219a((Object) gLSurfaceView, "setGLSurfaceView: The given GLSurfaceView was null")) {
            C3114gr.m7196a(gLSurfaceView);
        }
    }

    /* renamed from: c */
    public final Set mo18129c() {
        if (!mo18132d("getUserTags")) {
            return new HashSet();
        }
        return this.f3822f.mo18169e();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Set, code=java.util.Set<java.lang.String>, for r5v0, types: [java.util.Set, java.util.Set<java.lang.String>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18124a(java.util.Set<java.lang.String> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "setUserTags"
            boolean r0 = r4.mo18132d(r0)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r5 == 0) goto L_0x0045
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x0045
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x001a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x001a
            java.lang.String r1 = r1.trim()
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x001a
            int r2 = r1.length()
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 > r3) goto L_0x001a
            r0.add(r1)
            int r1 = r0.size()
            if (r1 >= r3) goto L_0x0044
            goto L_0x001a
        L_0x0044:
            r5 = r0
        L_0x0045:
            com.tapjoy.internal.hc r0 = r4.f3822f
            monitor-enter(r0)
            if (r5 == 0) goto L_0x007b
            boolean r1 = r5.isEmpty()     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x007b
            com.tapjoy.internal.ej r1 = com.tapjoy.internal.C3059fg.f7159c     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.fg r2 = new com.tapjoy.internal.fg     // Catch:{ all -> 0x008b }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x008b }
            r3.<init>(r5)     // Catch:{ all -> 0x008b }
            r2.<init>(r3)     // Catch:{ all -> 0x008b }
            byte[] r1 = r1.mo29994b(r2)     // Catch:{ all -> 0x008b }
            r2 = 2
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r2)     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.hj r2 = r0.f3843c     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.o r2 = r2.f7453z     // Catch:{ all -> 0x008b }
            r2.mo30369a(r1)     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.fh$a r1 = r0.f3842b     // Catch:{ all -> 0x008b }
            java.util.List r1 = r1.f7204A     // Catch:{ all -> 0x008b }
            r1.clear()     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.fh$a r1 = r0.f3842b     // Catch:{ all -> 0x008b }
            java.util.List r1 = r1.f7204A     // Catch:{ all -> 0x008b }
            r1.addAll(r5)     // Catch:{ all -> 0x008b }
            goto L_0x0089
        L_0x007b:
            com.tapjoy.internal.hj r5 = r0.f3843c     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.o r5 = r5.f7453z     // Catch:{ all -> 0x008b }
            r5.mo30366c()     // Catch:{ all -> 0x008b }
            com.tapjoy.internal.fh$a r5 = r0.f3842b     // Catch:{ all -> 0x008b }
            java.util.List r5 = r5.f7204A     // Catch:{ all -> 0x008b }
            r5.clear()     // Catch:{ all -> 0x008b }
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x008b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1831gz.mo18124a(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061 A[SYNTHETIC, Splitter:B:39:0x0061] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18119a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f3827k     // Catch:{ all -> 0x0119 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            r3.mo18127b(r4)     // Catch:{ all -> 0x0119 }
            android.content.Context r4 = r3.f3821e     // Catch:{ all -> 0x0119 }
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0012
            r4 = 1
            goto L_0x0013
        L_0x0012:
            r4 = 0
        L_0x0013:
            java.lang.String r2 = "The given context was null"
            boolean r4 = com.tapjoy.internal.C3124gw.m7220a(r4, r2)     // Catch:{ all -> 0x0119 }
            if (r4 != 0) goto L_0x001d
            monitor-exit(r3)
            return
        L_0x001d:
            if (r8 == 0) goto L_0x0031
            int r4 = r8.length()     // Catch:{ all -> 0x0119 }
            r2 = 24
            if (r4 != r2) goto L_0x0031
            java.lang.String r4 = "[0-9a-f]{24}"
            boolean r4 = r8.matches(r4)     // Catch:{ all -> 0x0119 }
            if (r4 == 0) goto L_0x0031
            r4 = 1
            goto L_0x003b
        L_0x0031:
            java.lang.String r4 = "Invalid App ID: {}"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0119 }
            r2[r1] = r8     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.C3124gw.m7222b(r4, r2)     // Catch:{ all -> 0x0119 }
            r4 = 0
        L_0x003b:
            if (r4 != 0) goto L_0x003f
            monitor-exit(r3)
            return
        L_0x003f:
            if (r9 == 0) goto L_0x0053
            int r4 = r9.length()     // Catch:{ all -> 0x0119 }
            r2 = 20
            if (r4 != r2) goto L_0x0053
            java.lang.String r4 = "[0-9A-Za-z\\-_]{20}"
            boolean r4 = r9.matches(r4)     // Catch:{ all -> 0x0119 }
            if (r4 == 0) goto L_0x0053
            r4 = 1
            goto L_0x005d
        L_0x0053:
            java.lang.String r4 = "Invalid App Key: {}"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0119 }
            r2[r1] = r9     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.C3124gw.m7222b(r4, r2)     // Catch:{ all -> 0x0119 }
            r4 = 0
        L_0x005d:
            if (r4 != 0) goto L_0x0061
            monitor-exit(r3)
            return
        L_0x0061:
            r3.f3828l = r5     // Catch:{ all -> 0x0119 }
            r3.f3829m = r6     // Catch:{ all -> 0x0119 }
            r3.f3835u = r8     // Catch:{ all -> 0x0119 }
            r3.f3836v = r9     // Catch:{ all -> 0x0119 }
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0112 }
            r4.<init>(r7)     // Catch:{ MalformedURLException -> 0x0112 }
            java.lang.String r5 = "TapjoySDK"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r9.<init>()     // Catch:{ all -> 0x0119 }
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = " "
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            r9.append(r6)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = " ("
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0119 }
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = "; Android "
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0119 }
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = "; "
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0119 }
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = ")"
            r9.append(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.ce r6 = new com.tapjoy.internal.ce     // Catch:{ all -> 0x0119 }
            r6.<init>(r5, r4)     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.C1817ca.f3778b = r6     // Catch:{ all -> 0x0119 }
            java.util.concurrent.ExecutorService r4 = java.util.concurrent.Executors.newCachedThreadPool()     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.C1817ca.f3777a = r4     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.gx r4 = r3.f3825i     // Catch:{ all -> 0x0119 }
            r4.f7372b = r6     // Catch:{ all -> 0x0119 }
            r4.mo30199a()     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ all -> 0x0119 }
            r4[r1] = r7     // Catch:{ all -> 0x0119 }
            r3.f3827k = r0     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.hd r4 = new com.tapjoy.internal.hd     // Catch:{ all -> 0x0119 }
            android.content.Context r5 = r3.f3821e     // Catch:{ all -> 0x0119 }
            java.io.File r5 = m3560d(r5)     // Catch:{ all -> 0x0119 }
            r4.<init>(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = r4.mo18172b()     // Catch:{ all -> 0x0119 }
            if (r5 == 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r0 = 0
        L_0x00d6:
            if (r0 != 0) goto L_0x00eb
            boolean r4 = r4.mo18171a()     // Catch:{ all -> 0x0119 }
            if (r4 == 0) goto L_0x00eb
            com.tapjoy.internal.gy r4 = r3.f3823g     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.ey r5 = com.tapjoy.internal.C3035ey.APP     // Catch:{ all -> 0x0119 }
            java.lang.String r6 = "install"
            com.tapjoy.internal.ev$a r5 = r4.mo18113a(r5, r6)     // Catch:{ all -> 0x0119 }
            r4.mo18114a(r5)     // Catch:{ all -> 0x0119 }
        L_0x00eb:
            com.tapjoy.internal.hc r4 = r3.f3822f     // Catch:{ all -> 0x0119 }
            boolean r5 = com.tapjoy.internal.C1852jq.m3669c(r8)     // Catch:{ all -> 0x0119 }
            if (r5 != 0) goto L_0x010d
            com.tapjoy.internal.hj r5 = r4.f3843c     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.o r5 = r5.f7427D     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = r5.mo30368a()     // Catch:{ all -> 0x0119 }
            boolean r5 = r8.equals(r5)     // Catch:{ all -> 0x0119 }
            if (r5 != 0) goto L_0x010d
            com.tapjoy.internal.hj r5 = r4.f3843c     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.o r5 = r5.f7427D     // Catch:{ all -> 0x0119 }
            r5.mo30369a(r8)     // Catch:{ all -> 0x0119 }
            com.tapjoy.internal.hj r4 = r4.f3843c     // Catch:{ all -> 0x0119 }
            r4.mo30218a(r1)     // Catch:{ all -> 0x0119 }
        L_0x010d:
            r3.mo18126b()     // Catch:{ all -> 0x0119 }
            monitor-exit(r3)
            return
        L_0x0112:
            r4 = move-exception
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0119 }
            r5.<init>(r4)     // Catch:{ all -> 0x0119 }
            throw r5     // Catch:{ all -> 0x0119 }
        L_0x0119:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1831gz.mo18119a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: c */
    public final boolean mo18130c(String str) {
        if ((this.f3827k || this.f3826j != null) && this.f3821e != null) {
            return true;
        }
        if (C3124gw.f7370a) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": Should be called after initializing the SDK");
            C3124gw.m7221b(sb.toString());
        }
        return false;
    }

    /* renamed from: d */
    public final boolean mo18132d(String str) {
        if (this.f3821e != null) {
            return true;
        }
        if (C3124gw.f7370a) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": Should be called after initializing the SDK");
            C3124gw.m7221b(sb.toString());
        }
        return false;
    }

    /* renamed from: d */
    public final boolean mo18131d() {
        C1840hm hmVar = this.f3824h;
        return hmVar != null && hmVar.f3858b.get();
    }

    /* renamed from: e */
    public final boolean mo18133e() {
        boolean z;
        C1840hm hmVar = this.f3824h;
        if (hmVar.f3859c != null) {
            hmVar.f3859c.cancel(false);
            hmVar.f3859c = null;
        }
        if (hmVar.f3858b.compareAndSet(false, true)) {
            C3124gw.m7216a("New session started");
            C1830gy gyVar = hmVar.f3857a;
            C3047fc d = gyVar.f3808a.mo18168d();
            C1835hc hcVar = gyVar.f3808a;
            synchronized (hcVar) {
                int b = hcVar.f3843c.f7435h.mo30349b() + 1;
                hcVar.f3843c.f7435h.mo30347a(b);
                hcVar.f3842b.f7211h = Integer.valueOf(b);
            }
            C3027a a = gyVar.mo18113a(C3035ey.APP, "bootup");
            gyVar.f3810c = SystemClock.elapsedRealtime();
            if (d != null) {
                a.f7026s = d;
            }
            gyVar.mo18114a(a);
            C3081fs.f7266c.notifyObservers();
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        C3142hh hhVar = this.f3817a;
        synchronized (hhVar) {
            hhVar.f7418b = null;
        }
        C3155ht.f7479a.mo30223a();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18121a(Map map) {
        C1830gy gyVar = this.f3823g;
        C3027a a = gyVar.mo18113a(C3035ey.CAMPAIGN, "impression");
        if (map != null) {
            a.f7025r = C2895bh.m6597a((Object) map);
        }
        gyVar.mo18114a(a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18122a(Map map, long j) {
        C1830gy gyVar = this.f3823g;
        C3027a a = gyVar.mo18113a(C3035ey.CAMPAIGN, ViewHierarchyConstants.VIEW_KEY);
        a.f7016i = Long.valueOf(j);
        if (map != null) {
            a.f7025r = C2895bh.m6597a((Object) map);
        }
        gyVar.mo18114a(a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18123a(Map map, String str) {
        C1830gy gyVar = this.f3823g;
        C3027a a = gyVar.mo18113a(C3035ey.CAMPAIGN, String.CLICK);
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("region", str);
        a.f7025r = C2895bh.m6597a((Object) linkedHashMap);
        gyVar.mo18114a(a);
    }

    /* renamed from: a */
    public static synchronized void m3558a(Runnable runnable) {
        synchronized (C1831gz.class) {
            if (f3815w == null) {
                f3815w = new Handler(Looper.getMainLooper());
            }
            f3815w.post(runnable);
        }
    }

    /* renamed from: c */
    public static synchronized File m3559c(Context context) {
        File file;
        synchronized (C1831gz.class) {
            if (f3816x == null) {
                f3816x = context.getDir("fiverocks", 0);
            }
            file = f3816x;
        }
        return file;
    }

    /* renamed from: d */
    static File m3560d(Context context) {
        return new File(m3559c(context), "install");
    }

    /* renamed from: a */
    public static String m3556a(Context context, Intent intent) {
        String a = C1819d.m3508a(intent);
        if (a != null) {
            C1831gz gzVar = f3814r;
            gzVar.mo18127b(context);
            if (C1852jq.m3669c(gzVar.f3822f.mo18166c()) || intent.getBooleanExtra("fiverocks:force", false)) {
                C1835hc hcVar = gzVar.f3822f;
                synchronized (hcVar) {
                    hcVar.f3843c.f7431d.mo30369a(a);
                    hcVar.f3842b.f7207d = a;
                }
                if (a.length() > 0) {
                    C1830gy gyVar = gzVar.f3823g;
                    gyVar.mo18114a(gyVar.mo18113a(C3035ey.APP, TapjoyConstants.TJC_REFERRER));
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public static C1831gz m3555a(Context context) {
        C1831gz gzVar = f3814r;
        gzVar.mo18127b(context);
        return gzVar;
    }
}
