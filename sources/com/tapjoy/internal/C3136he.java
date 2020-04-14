package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.WindowManager.BadTokenException;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TJContentActivity.AbstractContentProducer;

/* renamed from: com.tapjoy.internal.he */
public class C3136he extends C1837hg {

    /* renamed from: h */
    private static final String f7396h = "he";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static C3136he f7397i;

    /* renamed from: a */
    final String f7398a;

    /* renamed from: b */
    final C1845hu f7399b;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C1831gz f7400j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2916c f7401k;

    /* renamed from: l */
    private boolean f7402l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f7403m;

    /* renamed from: n */
    private Context f7404n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f7405o = false;

    /* renamed from: a */
    public static void m7244a() {
        C3136he heVar = f7397i;
        if (heVar != null) {
            heVar.m7254e();
        }
    }

    public C3136he(C1831gz gzVar, String str, C1845hu huVar, Context context) {
        this.f7400j = gzVar;
        this.f7398a = str;
        this.f7399b = huVar;
        this.f7404n = context;
    }

    /* renamed from: b */
    public final void mo18174b() {
        C1845hu huVar = this.f7399b;
        if (huVar.f3866a != null) {
            huVar.f3866a.mo30230b();
        }
        if (huVar.f3867b != null) {
            huVar.f3867b.mo30230b();
        }
        huVar.f3868c.mo30230b();
        if (huVar.f3870e != null) {
            huVar.f3870e.mo30230b();
        }
        if (huVar.f3871f != null) {
            huVar.f3871f.mo30230b();
        }
        if (huVar.f3878m != null && huVar.f3878m.f7492a != null) {
            huVar.f3878m.f7492a.mo30230b();
        }
    }

    /* renamed from: c */
    public final boolean mo18175c() {
        C1845hu huVar = this.f7399b;
        return (huVar.f3868c == null || huVar.f3868c.f7501b == null || (huVar.f3878m != null && huVar.f3878m.f7492a != null && huVar.f3878m.f7492a.f7501b == null) || ((huVar.f3867b == null || huVar.f3871f == null || huVar.f3867b.f7501b == null || huVar.f3871f.f7501b == null) && (huVar.f3866a == null || huVar.f3870e == null || huVar.f3866a.f7501b == null || huVar.f3870e.f7501b == null))) ? false : true;
    }

    /* renamed from: a */
    public final void mo18173a(final C3128ha haVar, final C3085fw fwVar) {
        Activity a = C1806a.m3444a(this.f7404n);
        if (a != null && !a.isFinishing()) {
            try {
                m7245a(a, haVar, fwVar);
                new Object[1][0] = this.f7398a;
                return;
            } catch (BadTokenException unused) {
            }
        }
        Activity a2 = C3114gr.m7195a();
        try {
            TJContentActivity.start(C1831gz.m3554a().f3821e, new AbstractContentProducer() {
                public final void show(Activity activity) {
                    try {
                        C3136he.this.m7245a(activity, haVar, fwVar);
                    } catch (BadTokenException unused) {
                        C3124gw.m7222b("Failed to show the content for \"{}\" caused by invalid activity", C3136he.this.f7398a);
                        haVar.mo29405a(C3136he.this.f7398a, C3136he.this.f3851f, null);
                    }
                }

                public final void dismiss(Activity activity) {
                    C3136he.this.m7254e();
                }
            }, (a2 == null || (a2.getWindow().getAttributes().flags & 1024) == 0) ? false : true);
            new Object[1][0] = this.f7398a;
        } catch (ActivityNotFoundException unused2) {
            if (a2 != null && !a2.isFinishing()) {
                try {
                    m7245a(a2, haVar, fwVar);
                    new Object[1][0] = this.f7398a;
                    return;
                } catch (BadTokenException unused3) {
                    C3124gw.m7222b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.f7398a);
                    haVar.mo29405a(this.f7398a, this.f3851f, null);
                }
            }
            C3124gw.m7222b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.f7398a);
            haVar.mo29405a(this.f7398a, this.f3851f, null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7245a(final android.app.Activity r13, final com.tapjoy.internal.C3128ha r14, com.tapjoy.internal.C3085fw r15) {
        /*
            r12 = this;
            boolean r0 = r12.f7402l
            if (r0 == 0) goto L_0x0013
            java.lang.String r13 = f7396h
            com.tapjoy.TapjoyErrorMessage r14 = new com.tapjoy.TapjoyErrorMessage
            com.tapjoy.TapjoyErrorMessage$ErrorType r15 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR
            java.lang.String r0 = "Content is already displayed"
            r14.<init>(r15, r0)
            com.tapjoy.TapjoyLog.m6551e(r13, r14)
            return
        L_0x0013:
            r0 = 1
            r12.f7402l = r0
            f7397i = r12
            com.tapjoy.internal.fq r1 = r15.f7271a
            r12.f3852g = r1
            com.tapjoy.internal.c r1 = new com.tapjoy.internal.c
            r1.<init>(r13)
            r12.f7401k = r1
            com.tapjoy.internal.c r1 = r12.f7401k
            com.tapjoy.internal.he$2 r2 = new com.tapjoy.internal.he$2
            r2.<init>(r14)
            r1.setOnCancelListener(r2)
            com.tapjoy.internal.c r1 = r12.f7401k
            com.tapjoy.internal.he$3 r2 = new com.tapjoy.internal.he$3
            r2.<init>(r13, r14)
            r1.setOnDismissListener(r2)
            com.tapjoy.internal.c r1 = r12.f7401k
            r2 = 0
            r1.setCanceledOnTouchOutside(r2)
            com.tapjoy.internal.iq r1 = new com.tapjoy.internal.iq
            com.tapjoy.internal.hu r3 = r12.f7399b
            com.tapjoy.internal.he$4 r4 = new com.tapjoy.internal.he$4
            r4.<init>(r13, r14)
            r1.<init>(r13, r3, r4)
            com.tapjoy.internal.ip r3 = new com.tapjoy.internal.ip
            com.tapjoy.internal.hu r4 = r12.f7399b
            r3.<init>(r13, r4, r1)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r13)
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r5 = 17
            r6 = -2
            r4.<init>(r6, r6, r5)
            r1.addView(r3, r4)
            com.tapjoy.internal.c r4 = r12.f7401k
            r4.setContentView(r1)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x018c
            com.tapjoy.internal.c r1 = r12.f7401k
            android.view.Window r1 = r1.getWindow()
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 16
            if (r4 != r5) goto L_0x009a
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
            java.lang.String r5 = "4.1.2"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x009a
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            android.content.Context r5 = r1.getContext()
            java.lang.Boolean r5 = m7243a(r5)
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0095
            r1 = 0
            goto L_0x009b
        L_0x0095:
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            r1.setFlags(r4, r4)
        L_0x009a:
            r1 = 1
        L_0x009b:
            if (r1 == 0) goto L_0x018c
            int r1 = com.tapjoy.internal.C2864ad.C2866a.f6636b
            com.tapjoy.internal.ae r4 = new com.tapjoy.internal.ae
            r4.<init>()
            int[] r5 = com.tapjoy.internal.C2864ad.C28651.f6634a
            int r1 = r1 - r0
            r1 = r5[r1]
            r5 = 1114636288(0x42700000, float:60.0)
            r6 = 1050253722(0x3e99999a, float:0.3)
            r7 = 1053609165(0x3ecccccd, float:0.4)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r1 == r0) goto L_0x0153
            r9 = 2
            r10 = -1093874483(0xffffffffbecccccd, float:-0.4)
            r11 = -1032847360(0xffffffffc2700000, float:-60.0)
            if (r1 == r9) goto L_0x0124
            r2 = 3
            if (r1 == r2) goto L_0x00f5
            r2 = 4
            if (r1 == r2) goto L_0x00c5
            goto L_0x0181
        L_0x00c5:
            com.tapjoy.internal.ag r1 = new com.tapjoy.internal.ag
            r1.<init>()
            r1.f6651a = r0
            r1.f6652b = r5
            com.tapjoy.internal.af r0 = r1.mo29799a()
            com.tapjoy.internal.ae r0 = r4.mo29796a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo29796a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo29801a(r6)
            com.tapjoy.internal.ah r1 = r1.mo29802b(r10)
            android.view.animation.Animation r1 = r1.mo29800a()
            r0.mo29796a(r1)
            goto L_0x0181
        L_0x00f5:
            com.tapjoy.internal.ag r1 = new com.tapjoy.internal.ag
            r1.<init>()
            r1.f6651a = r0
            r1.f6652b = r11
            com.tapjoy.internal.af r0 = r1.mo29799a()
            com.tapjoy.internal.ae r0 = r4.mo29796a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo29796a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo29801a(r6)
            com.tapjoy.internal.ah r1 = r1.mo29802b(r8)
            android.view.animation.Animation r1 = r1.mo29800a()
            r0.mo29796a(r1)
            goto L_0x0181
        L_0x0124:
            com.tapjoy.internal.ag r0 = new com.tapjoy.internal.ag
            r0.<init>()
            r0.f6651a = r2
            r0.f6652b = r11
            com.tapjoy.internal.af r0 = r0.mo29799a()
            com.tapjoy.internal.ae r0 = r4.mo29796a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo29796a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo29801a(r10)
            com.tapjoy.internal.ah r1 = r1.mo29802b(r6)
            android.view.animation.Animation r1 = r1.mo29800a()
            r0.mo29796a(r1)
            goto L_0x0181
        L_0x0153:
            com.tapjoy.internal.ag r0 = new com.tapjoy.internal.ag
            r0.<init>()
            r0.f6651a = r2
            r0.f6652b = r5
            com.tapjoy.internal.af r0 = r0.mo29799a()
            com.tapjoy.internal.ae r0 = r4.mo29796a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo29796a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo29801a(r8)
            com.tapjoy.internal.ah r1 = r1.mo29802b(r6)
            android.view.animation.Animation r1 = r1.mo29800a()
            r0.mo29796a(r1)
        L_0x0181:
            com.tapjoy.internal.ad r0 = r4.mo29795b()
            android.view.animation.Animation r0 = r0.mo29794a()
            r3.startAnimation(r0)
        L_0x018c:
            com.tapjoy.internal.c r0 = r12.f7401k     // Catch:{ BadTokenException -> 0x01d2 }
            r0.show()     // Catch:{ BadTokenException -> 0x01d2 }
            com.tapjoy.internal.c r0 = r12.f7401k
            android.view.Window r0 = r0.getWindow()
            r1 = -1
            r0.setLayout(r1, r1)
            android.view.Window r13 = r13.getWindow()
            android.view.WindowManager$LayoutParams r13 = r13.getAttributes()
            int r13 = r13.flags
            r0 = 1024(0x400, float:1.435E-42)
            r13 = r13 & r0
            if (r13 == 0) goto L_0x01b3
            com.tapjoy.internal.c r13 = r12.f7401k
            android.view.Window r13 = r13.getWindow()
            r13.setFlags(r0, r0)
        L_0x01b3:
            long r0 = android.os.SystemClock.elapsedRealtime()
            r12.f7403m = r0
            com.tapjoy.internal.gz r13 = r12.f7400j
            com.tapjoy.internal.hu r0 = r12.f7399b
            java.util.Map r0 = r0.f3876k
            r13.mo18121a(r0)
            r15.mo30148a()
            com.tapjoy.internal.fq r13 = r12.f3852g
            if (r13 == 0) goto L_0x01cc
            r13.mo30144b()
        L_0x01cc:
            java.lang.String r13 = r12.f7398a
            r14.mo29407c(r13)
            return
        L_0x01d2:
            r13 = move-exception
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3136he.m7245a(android.app.Activity, com.tapjoy.internal.ha, com.tapjoy.internal.fw):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7254e() {
        C2916c cVar = this.f7401k;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    /* renamed from: a */
    private static Boolean m7243a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                Object obj = bundle.get("tapjoy:hardwareAccelerated");
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return null;
    }
}
