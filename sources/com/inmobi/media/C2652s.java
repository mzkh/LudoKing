package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.media.C2620l.C2636a;
import com.tapjoy.TJAdUnitConstants.String;

/* renamed from: com.inmobi.media.s */
/* compiled from: InterstitialAdUnit */
public class C2652s extends C2620l {

    /* renamed from: r */
    private static final String f5930r = "s";

    /* renamed from: s */
    private int f5931s = 0;

    /* renamed from: t */
    private boolean f5932t = false;

    /* renamed from: g */
    public String mo28771g() {
        return "int";
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final int mo28772h() {
        return 1;
    }

    public C2652s(@NonNull Context context, @NonNull C2159ai aiVar, @Nullable C2636a aVar) {
        super(context, aiVar, aVar);
        aiVar.mo27849e();
        mo28741a(context, aiVar, aVar);
        mo28762b("activity");
    }

    @Nullable
    /* renamed from: q */
    public C2600j mo28782q() {
        C2600j q = super.mo28782q();
        if (this.f5932t && q != null) {
            q.mo28357a();
        }
        return q;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    @androidx.annotation.UiThread
    /* renamed from: V */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m6016V() {
        /*
            r8 = this;
            boolean r0 = r8.mo28787v()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0013
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES
            r0.<init>(r3)
            r8.mo28743a(r0, r2)
            return r1
        L_0x0013:
            com.inmobi.media.l$a r0 = r8.mo28777l()
            if (r0 != 0) goto L_0x001a
            return r1
        L_0x001a:
            int r3 = r8.mo28770f()
            java.lang.String r4 = "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: "
            r5 = 2
            java.lang.String r6 = "InMobiInterstitial"
            if (r3 == r2) goto L_0x008d
            if (r3 == r5) goto L_0x0063
            r4 = 4
            if (r3 == r4) goto L_0x005d
            r4 = 7
            if (r3 == r4) goto L_0x0034
            r4 = 8
            if (r3 == r4) goto L_0x0034
            r0 = 0
            goto L_0x00a5
        L_0x0034:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: "
            r3.<init>(r4)
            com.inmobi.media.ai r4 = r8.mo28769e()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.inmobi.media.C2514gh.m5342a(r2, r6, r3)
            com.inmobi.ads.InMobiAdRequestStatus r3 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r4 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.AD_ACTIVE
            r3.<init>(r4)
            r8.mo28729I()
            if (r0 == 0) goto L_0x00a4
            r0.mo27778a(r8, r3)
            goto L_0x00a4
        L_0x005d:
            if (r0 == 0) goto L_0x00a4
            r0.mo28805a()
            goto L_0x00a4
        L_0x0063:
            java.lang.String r3 = r8.mo28774j()
            java.lang.String r7 = "html"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0087
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            com.inmobi.media.ai r3 = r8.mo28769e()
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.inmobi.media.C2514gh.m5342a(r2, r6, r0)
            goto L_0x00a4
        L_0x0087:
            if (r0 == 0) goto L_0x00a4
            r0.mo28805a()
            goto L_0x00a4
        L_0x008d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            com.inmobi.media.ai r3 = r8.mo28769e()
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.inmobi.media.C2514gh.m5342a(r2, r6, r0)
        L_0x00a4:
            r0 = 1
        L_0x00a5:
            if (r0 == 0) goto L_0x00a8
            return r1
        L_0x00a8:
            r0 = 5
            int r3 = r8.mo28770f()
            if (r0 != r3) goto L_0x00cc
            boolean r0 = r8.mo28779n()
            if (r0 == 0) goto L_0x00b9
            r8.mo28722B()
            goto L_0x00cc
        L_0x00b9:
            com.inmobi.media.l$a r0 = r8.mo28777l()
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "Listener was garbage collected. Unable to give callback"
            com.inmobi.media.C2514gh.m5342a(r5, r6, r0)
            goto L_0x00cb
        L_0x00c5:
            r0.mo28805a()
            r0.mo27783b()
        L_0x00cb:
            return r1
        L_0x00cc:
            r8.f5865m = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2652s.m6016V():boolean");
    }

    @UiThread
    /* renamed from: w */
    public void mo28788w() {
        if (m6016V()) {
            super.mo28788w();
        }
    }

    /* renamed from: a */
    public void mo28755a(@Nullable byte[] bArr) {
        if (m6016V()) {
            super.mo28755a(bArr);
        }
    }

    @UiThread
    /* renamed from: e */
    public void mo28858e(C2636a aVar) {
        String str = "InMobiInterstitial";
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.CALLED_FROM_WRONG_THREAD), false);
            C2514gh.m5342a(1, str, "Please ensure that you call show() on the UI thread");
        } else if (aVar == null) {
            C2514gh.m5342a(2, str, "Listener was garbage collected. Unable to give callback");
        } else if (!mo28818T()) {
            C2514gh.m5342a(1, f5930r, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            aVar.mo28809c();
        } else if (!C2532gs.m5406e()) {
            mo28722B();
            aVar.mo28809c();
        } else {
            mo28746a(aVar);
            this.f5854b = 7;
            if (!String.HTML.equals(mo28774j())) {
                this.f5860h.submit(new C2651r(this, aVar));
            } else if (mo28779n()) {
                mo28860g(aVar);
                C2452f p = mo28781p();
                if (p != null) {
                    p.destroy();
                }
            } else {
                mo28859f(aVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final void mo28859f(C2636a aVar) {
        boolean W = m6017W();
        if (aVar == null) {
            C2514gh.m5342a(2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
        } else if (!W) {
            this.f5854b = 3;
            aVar.mo28809c();
        } else {
            aVar.mo27791d();
        }
    }

    /* renamed from: W */
    private boolean m6017W() {
        try {
            InMobiAdActivity.class.getSimpleName();
            C2452f p = mo28781p();
            if (p != null) {
                if (!"unknown".equals(p.getMarkupType())) {
                    int a = InMobiAdActivity.m4207a(p);
                    Intent intent = new Intent(mo28767d(), InMobiAdActivity.class);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", a);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", String.HTML.equals(mo28774j()) ? Callback.DEFAULT_DRAG_ANIMATION_DURATION : 201);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
                    C2505gd.m5287a(mo28767d(), intent);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            C2514gh.m5342a(1, "InMobiInterstitial", "Cannot show ad; SDK encountered an unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return false;
        }
    }

    /* renamed from: T */
    public boolean mo28818T() {
        return mo28770f() == 5;
    }

    /* renamed from: U */
    public void mo28819U() {
        C2452f p = mo28781p();
        if (p != null) {
            this.f5932t = true;
            p.mo28357a();
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: u */
    public final Integer mo28786u() {
        return Integer.valueOf(this.f5855c.f5175b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28754a(boolean z) {
        super.mo28754a(z);
        if (mo28770f() == 2) {
            StringBuilder sb = new StringBuilder("Interstitial ad successfully fetched for placement id: ");
            sb.append(mo28769e().toString());
            C2514gh.m5342a(2, "InMobiInterstitial", sb.toString());
            mo28734N();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[Catch:{ IllegalStateException -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[Catch:{ IllegalStateException -> 0x004a }] */
    @androidx.annotation.UiThread
    /* renamed from: P */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo28736P() {
        /*
            r5 = this;
            r5.mo28723C()
            r0 = 1
            boolean r1 = r5.mo28735O()     // Catch:{ IllegalStateException -> 0x004a }
            if (r1 == 0) goto L_0x000b
            return
        L_0x000b:
            r5.mo28737Q()     // Catch:{ IllegalStateException -> 0x004a }
            java.lang.String r1 = r5.mo28774j()     // Catch:{ IllegalStateException -> 0x004a }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ IllegalStateException -> 0x004a }
            r4 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
            if (r3 == r4) goto L_0x002c
            r4 = 3213227(0x3107ab, float:4.50269E-39)
            if (r3 == r4) goto L_0x0022
            goto L_0x0036
        L_0x0022:
            java.lang.String r3 = "html"
            boolean r1 = r1.equals(r3)     // Catch:{ IllegalStateException -> 0x004a }
            if (r1 == 0) goto L_0x0036
            r1 = 0
            goto L_0x0037
        L_0x002c:
            java.lang.String r3 = "inmobiJson"
            boolean r1 = r1.equals(r3)     // Catch:{ IllegalStateException -> 0x004a }
            if (r1 == 0) goto L_0x0036
            r1 = 1
            goto L_0x0037
        L_0x0036:
            r1 = -1
        L_0x0037:
            if (r1 == 0) goto L_0x003f
            if (r1 == r0) goto L_0x003e
            r5.mo28774j()     // Catch:{ IllegalStateException -> 0x004a }
        L_0x003e:
            return
        L_0x003f:
            android.os.Handler r1 = r5.f5862j     // Catch:{ IllegalStateException -> 0x004a }
            com.inmobi.media.s$1 r2 = new com.inmobi.media.s$1     // Catch:{ IllegalStateException -> 0x004a }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x004a }
            r1.post(r2)     // Catch:{ IllegalStateException -> 0x004a }
            return
        L_0x004a:
            com.inmobi.ads.InMobiAdRequestStatus r1 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r2 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r1.<init>(r2)
            r5.mo28743a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2652s.mo28736P():void");
    }

    @UiThread
    /* renamed from: a */
    public void mo28134a(C2153ac acVar, boolean z) {
        if (!z) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
            return;
        }
        try {
            super.mo28134a(acVar, z);
        } catch (IllegalStateException unused) {
        }
        C2153ac r = mo28783r();
        if (r == null) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
        } else if (r.mo27813d()) {
            this.f5863k = true;
            mo28731K();
        } else {
            mo28759b(r);
        }
    }

    @UiThread
    /* renamed from: b */
    public void mo28760b(@NonNull C2159ai aiVar, boolean z) {
        super.mo28760b(aiVar, z);
        if (!z) {
            if (mo28769e().equals(aiVar) && (2 == mo28770f() || 5 == mo28770f())) {
                this.f5854b = 0;
                mo28743a(new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE), false);
            }
        } else if (mo28769e().equals(aiVar) && 2 == mo28770f()) {
            if (this.f5863k) {
                this.f5864l = true;
                mo28732L();
                return;
            }
            mo28733M();
        }
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: M */
    public final void mo28733M() {
        mo28728H();
        this.f5854b = 5;
        C2636a l = mo28777l();
        if (l != null && l.mo28812j()) {
            l.mo27783b();
        }
    }

    /* renamed from: D */
    public void mo28724D() {
        super.mo28724D();
        if (mo28770f() == 4) {
            mo28763c(2);
            StringBuilder sb = new StringBuilder("Successfully loaded Interstitial ad markup in the WebView for placement id: ");
            sb.append(mo28769e().toString());
            C2514gh.m5342a(2, "InMobiInterstitial", sb.toString());
            mo28790y();
            mo28733M();
        }
    }

    @UiThread
    /* renamed from: c */
    public void mo28533c(C2600j jVar) {
        super.mo28533c(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                if (C2652s.this.mo28770f() == 2) {
                    C2652s.this.f5854b = 4;
                }
            }
        });
    }

    @UiThread
    /* renamed from: E */
    public void mo28725E() {
        super.mo28725E();
        if (mo28770f() == 4) {
            mo28763c(2);
            this.f5854b = 3;
            StringBuilder sb = new StringBuilder("Failed to load the Interstitial markup in the WebView for placement id: ");
            sb.append(mo28769e().toString());
            C2514gh.m5342a(2, "InMobiInterstitial", sb.toString());
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
        }
    }

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: F */
    public final void mo28726F() {
        if (2 == mo28770f() || 4 == mo28770f()) {
            mo28763c(2);
            this.f5854b = 3;
            StringBuilder sb = new StringBuilder("Failed to load the Interstitial markup in the WebView for placement id: ");
            sb.append(mo28769e().toString());
            C2514gh.m5342a(2, "InMobiInterstitial", sb.toString());
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
        }
    }

    /* renamed from: f */
    public synchronized void mo28536f(C2600j jVar) {
        super.mo28536f(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                C2652s sVar = C2652s.this;
                sVar.mo28765c(sVar.mo28777l());
            }
        });
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: c */
    public final void mo28765c(C2636a aVar) {
        if (mo28770f() == 7) {
            this.f5931s++;
            if (this.f5931s == 1) {
                StringBuilder sb = new StringBuilder("Successfully displayed Interstitial for placement id: ");
                sb.append(mo28769e().toString());
                C2514gh.m5342a(2, "InMobiInterstitial", sb.toString());
                if (aVar != null) {
                    aVar.mo27792e();
                }
            } else {
                this.f5854b = 8;
            }
        } else if (mo28770f() == 8) {
            this.f5931s++;
        }
    }

    /* renamed from: g */
    public synchronized void mo28537g(C2600j jVar) {
        super.mo28537g(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                C2652s sVar = C2652s.this;
                sVar.mo28768d(sVar.mo28777l());
            }
        });
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: d */
    public final void mo28768d(C2636a aVar) {
        if (mo28770f() == 8) {
            this.f5931s--;
            if (this.f5931s == 1) {
                this.f5854b = 7;
            }
        } else if (mo28770f() == 7) {
            this.f5931s--;
            StringBuilder sb = new StringBuilder("Interstitial ad dismissed for placement id: ");
            sb.append(mo28769e().toString());
            String str = "InMobiInterstitial";
            C2514gh.m5342a(2, str, sb.toString());
            if (aVar != null) {
                aVar.mo27793f();
                return;
            }
            C2514gh.m5342a(2, str, "Listener was garbage collected. Unable to give callback");
        }
    }

    /* renamed from: G */
    public boolean mo28727G() {
        return 4 == mo28770f() || 2 == mo28770f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: N */
    public final void mo28734N() {
        C2636a l = mo28777l();
        if (l != null) {
            l.mo28805a();
        }
    }

    /* renamed from: b */
    public void mo28762b(String str) {
        super.mo28762b("activity");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public final void mo28723C() {
        super.mo28723C();
        this.f5931s = 0;
    }

    /* renamed from: b */
    public void mo28529b() {
        super.mo28529b();
        C2452f p = mo28781p();
        if (p instanceof C2600j) {
            Activity fullScreenActivity = ((C2600j) p).getFullScreenActivity();
            if (fullScreenActivity != null) {
                this.f5869q = true;
                fullScreenActivity.finish();
            }
        }
    }

    /* renamed from: B */
    public void mo28722B() {
        super.mo28722B();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final void mo28860g(C2636a aVar) {
        this.f5854b = 0;
        if (aVar != null) {
            aVar.mo28809c();
        } else {
            C2514gh.m5342a(2, "InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
        }
    }
}
