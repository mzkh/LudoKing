package com.inmobi.media;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.inmobi.media.v */
/* compiled from: NativeAdUnit */
public final class C2663v extends C2620l {

    /* renamed from: r */
    public static final String f5947r = "v";

    /* renamed from: s */
    public WeakReference<View> f5948s;

    /* renamed from: t */
    public boolean f5949t = false;

    /* renamed from: u */
    private int f5950u = 0;

    /* renamed from: g */
    public final String mo28771g() {
        return "native";
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final int mo28772h() {
        return 0;
    }

    C2663v(@NonNull Context context, @NonNull C2159ai aiVar, @Nullable C2636a aVar) {
        super(context, aiVar, aVar);
        aiVar.mo27849e();
        mo28741a(context, aiVar, aVar);
    }

    /* renamed from: a */
    public final void mo28740a(Context context) {
        super.mo28740a(context);
        m6069b(context);
    }

    /* renamed from: V */
    private boolean m6068V() {
        C2636a l = mo28777l();
        if (mo28787v()) {
            if (l != null) {
                l.mo27778a((C2620l) this, new InMobiAdRequestStatus(StatusCode.MISSING_REQUIRED_DEPENDENCIES));
            }
            return false;
        } else if (1 == mo28770f() || 2 == mo28770f()) {
            C2514gh.m5342a(1, f5947r, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            return false;
        } else {
            String str = f5947r;
            StringBuilder sb = new StringBuilder("Fetching a Native ad for placement id: ");
            sb.append(mo28769e().toString());
            C2514gh.m5342a(2, str, sb.toString());
            if (5 == mo28770f()) {
                if (!mo28779n()) {
                    if (l != null) {
                        m6069b(mo28767d());
                        l.mo28805a();
                        l.mo27783b();
                    }
                    return false;
                }
                mo28818T();
            }
            this.f5865m = false;
            return true;
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    private void m6069b(Context context) {
        C2452f p = mo28781p();
        if (p instanceof C2542h) {
            ((C2542h) p).mo28486a(context);
        }
    }

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: b */
    public final void mo28760b(@NonNull C2159ai aiVar, boolean z) {
        super.mo28760b(aiVar, z);
        if (!z) {
            if (mo28769e().equals(aiVar) && (2 == mo28770f() || 5 == mo28770f())) {
                this.f5854b = 0;
                if (mo28777l() != null) {
                    mo28777l().mo27778a((C2620l) this, new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE));
                }
            }
        } else if (mo28769e().equals(aiVar) && 2 == mo28770f() && mo28777l() != null && mo28767d() != null) {
            if (this.f5863k) {
                this.f5864l = true;
                mo28732L();
                return;
            }
            mo28733M();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo28761b(@NonNull C2162aj ajVar) {
        if (String.HTML.equals(mo28774j())) {
            mo28744a(mo28769e(), new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        } else {
            super.mo28761b(ajVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28754a(boolean z) {
        super.mo28754a(z);
        if (mo28770f() == 2) {
            C2636a l = mo28777l();
            if (l != null) {
                l.mo28805a();
            }
        }
    }

    @UiThread
    /* renamed from: P */
    public final void mo28736P() {
        mo28723C();
        try {
            if (!mo28735O()) {
                mo28737Q();
            }
        } catch (IllegalStateException unused) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[Catch:{ Exception -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[Catch:{ Exception -> 0x0040 }] */
    @androidx.annotation.UiThread
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo28134a(com.inmobi.media.C2153ac r2, boolean r3) {
        /*
            r1 = this;
            r0 = 1
            if (r3 != 0) goto L_0x000e
            com.inmobi.ads.InMobiAdRequestStatus r2 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r2.<init>(r3)
            r1.mo28743a(r2, r0)
            return
        L_0x000e:
            super.mo28134a(r2, r3)     // Catch:{ IllegalStateException -> 0x0011 }
        L_0x0011:
            com.inmobi.media.ac r2 = r1.mo28783r()     // Catch:{ Exception -> 0x0040 }
            if (r2 != 0) goto L_0x0022
            com.inmobi.ads.InMobiAdRequestStatus r2 = new com.inmobi.ads.InMobiAdRequestStatus     // Catch:{ Exception -> 0x0040 }
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR     // Catch:{ Exception -> 0x0040 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0040 }
            r1.mo28743a(r2, r0)     // Catch:{ Exception -> 0x0040 }
            return
        L_0x0022:
            int r3 = r1.f5861i     // Catch:{ Exception -> 0x0040 }
            if (r3 != 0) goto L_0x0031
            boolean r3 = r2.mo27813d()     // Catch:{ Exception -> 0x0040 }
            if (r3 != 0) goto L_0x0034
            r3 = 0
            r1.mo28776k(r3)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0034
        L_0x0031:
            r1.mo28759b(r2)     // Catch:{ Exception -> 0x0040 }
        L_0x0034:
            boolean r2 = r2.mo27813d()     // Catch:{ Exception -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            r1.f5863k = r0     // Catch:{ Exception -> 0x0040 }
            r1.mo28731K()     // Catch:{ Exception -> 0x0040 }
        L_0x003f:
            return
        L_0x0040:
            com.inmobi.ads.InMobiAdRequestStatus r2 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r2.<init>(r3)
            r1.mo28743a(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2663v.mo28134a(com.inmobi.media.ac, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: M */
    public final void mo28733M() {
        this.f5860h.submit(new C2665w(this));
    }

    /* renamed from: T */
    public final void mo28818T() {
        try {
            super.mo28722B();
            this.f5856d = null;
        } catch (Exception e) {
            C2514gh.m5342a(1, "InMobi", "Could not destroy native ad; SDK encountered unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    /* renamed from: U */
    public final boolean mo28819U() {
        return mo28770f() == 5;
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: i */
    public final Map<String, String> mo28773i() {
        Map<String, String> i = super.mo28773i();
        i.put("a-parentViewWidth", String.valueOf(C2528gq.m5393a().f5541a));
        i.put("a-productVersion", "NS-1.0.0-20160411");
        i.put("trackerType", "url_ping");
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo28765c(C2636a aVar) {
        if (mo28770f() == 5) {
            this.f5854b = 7;
        } else if (mo28770f() == 7) {
            this.f5950u++;
        }
        StringBuilder sb = new StringBuilder("Successfully displayed fullscreen for placement id: ");
        sb.append(mo28769e().toString());
        String str = "InMobi";
        C2514gh.m5342a(2, str, sb.toString());
        if (this.f5950u == 0) {
            if (aVar != null) {
                aVar.mo27792e();
                return;
            }
            C2514gh.m5342a(2, str, "Listener was garbage collected. Unable to give callback");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final void mo28768d(C2636a aVar) {
        if (mo28770f() == 7) {
            int i = this.f5950u;
            if (i > 0) {
                this.f5950u = i - 1;
            } else {
                this.f5854b = 5;
            }
        }
        StringBuilder sb = new StringBuilder("Successfully dismissed fullscreen for placement id: ");
        sb.append(mo28769e().toString());
        String str = "InMobi";
        C2514gh.m5342a(2, str, sb.toString());
        if (this.f5950u == 0 && mo28770f() == 5) {
            if (aVar != null) {
                aVar.mo27793f();
                return;
            }
            C2514gh.m5342a(2, str, "Listener was garbage collected. Unable to give callback");
        }
    }

    @UiThread
    /* renamed from: w */
    public final void mo28788w() {
        if (!this.f5865m && m6068V()) {
            super.mo28788w();
        }
    }
}
