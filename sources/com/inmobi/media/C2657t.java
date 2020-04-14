package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2159ai.C2161a;
import com.inmobi.media.C2620l.C2636a;

/* renamed from: com.inmobi.media.t */
/* compiled from: InterstitialUnifiedAdManager */
public class C2657t extends C2143ab {

    /* renamed from: f */
    private static final String f5937f = "t";

    /* renamed from: g */
    private static final String f5938g = "InMobi";
    @Nullable

    /* renamed from: h */
    private C2652s f5939h;

    /* renamed from: i */
    private boolean f5940i;

    public C2657t(@NonNull C2674z zVar) {
        super(zVar);
    }

    /* renamed from: s */
    private void m6051s() {
        super.mo27783b();
        this.f4301c = 2;
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2657t.this.f4302d.mo27685a();
            }
        });
    }

    /* renamed from: b */
    private void m6049b(boolean z) {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2657t.this.f4302d.mo27708g();
            }
        });
        mo27777J();
        if (z) {
            this.f4301c = 6;
            C2652s sVar = this.f5939h;
            if (sVar != null) {
                sVar.mo28722B();
            }
        }
    }

    /* renamed from: a */
    public void mo28865a(@NonNull C2205au auVar, @NonNull Context context) {
        if (this.f5939h == null) {
            this.f5939h = new C2652s(context, new C2161a("int", f5938g).mo27863a(auVar.f4505a).mo27870c(auVar.f4506b).mo27866a(auVar.f4507c).mo27867a(), this);
        }
        this.f5939h.mo28740a(context);
        this.f5939h.mo28752a(auVar.f4507c);
        this.f5939h.mo28748a(auVar.f4506b);
        this.f5939h.mo28762b("activity");
        if (auVar.f4508d) {
            this.f5939h.mo28819U();
        }
    }

    /* renamed from: a */
    public void mo28805a() {
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
        C2652s sVar = this.f5939h;
        if (sVar == null) {
            mo27778a((C2620l) null, inMobiAdRequestStatus);
            return;
        }
        C2153ac r = sVar.mo28783r();
        if (r == null) {
            mo27778a((C2620l) null, inMobiAdRequestStatus);
            return;
        }
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2657t.this.f4302d.mo27706e();
            }
        });
        if (!this.f5939h.mo28818T()) {
            if (r.mo27822m()) {
                this.f5939h.mo28758b(1);
                this.f5939h.mo28736P();
                return;
            }
            m6051s();
        }
    }

    /* renamed from: a */
    public void mo28806a(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        mo27778a((C2620l) this.f5939h, inMobiAdRequestStatus);
    }

    /* renamed from: b */
    public final void mo27783b() {
        C2652s sVar = this.f5939h;
        if (sVar == null) {
            m6050d(null, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            return;
        }
        try {
            if (!m6048a(sVar, true) || this.f5940i) {
                this.f5939h.mo28858e(this);
            } else {
                m6051s();
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* renamed from: c */
    public final void mo28809c() {
        C2652s sVar = this.f5939h;
        if (sVar != null) {
            sVar.mo28742a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }

    /* renamed from: f */
    public final void mo27793f() {
        C2652s sVar = this.f5939h;
        if (sVar != null && !sVar.mo28738R()) {
            this.f4303e.post(new Runnable() {
                public final void run() {
                    C2657t.this.f4302d.mo27692c();
                }
            });
            this.f5939h.mo28722B();
            this.f4301c = 0;
            this.f5939h.mo28739S();
        }
    }

    @Nullable
    /* renamed from: p */
    public C2620l mo27795p() {
        return this.f5939h;
    }

    /* renamed from: o */
    public void mo28866o() {
        C2652s sVar = this.f5939h;
        if (sVar != null) {
            if (mo27782a(f5938g, sVar.mo28769e().toString())) {
                this.f4301c = 1;
                this.f5940i = false;
                String str = f5937f;
                StringBuilder sb = new StringBuilder("Fetching an Interstitial ad for placement id: ");
                sb.append(this.f5939h.mo28769e().toString());
                C2514gh.m5342a(2, str, sb.toString());
                this.f5939h.mo28746a((C2636a) this);
                this.f5939h.mo28788w();
            }
        }
    }

    /* renamed from: q */
    public boolean mo28867q() {
        if (this.f5939h == null || 2 != this.f4301c) {
            return false;
        }
        try {
            if (!m6048a(this.f5939h, false) || this.f5939h.mo28818T()) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* renamed from: r */
    public void mo28868r() {
        if (m6052t()) {
            mo27776I();
            C2652s sVar = this.f5939h;
            if (sVar != null) {
                this.f5940i = true;
                try {
                    if (m6048a(sVar, true)) {
                        this.f5939h.mo28858e(this);
                        return;
                    }
                    this.f5939h.mo28736P();
                } catch (IllegalStateException unused) {
                }
            }
        }
    }

    /* renamed from: l */
    public void mo28814l() {
        C2620l p = mo27795p();
        if (p == null) {
            return;
        }
        if (p.mo28770f() == 7 || p.mo28770f() == 8) {
            C2652s sVar = this.f5939h;
            if (sVar != null) {
                sVar.mo28739S();
            }
            p.mo28768d((C2636a) this);
            return;
        }
        m6049b(true);
    }

    /* renamed from: m */
    public void mo28815m() {
        C2652s sVar = this.f5939h;
        if (sVar != null) {
            sVar.mo28742a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"SwitchIntDef"})
    /* renamed from: b */
    public void mo27786b(@NonNull C2620l lVar, boolean z, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!z) {
            m6050d(lVar, inMobiAdRequestStatus);
        }
    }

    /* renamed from: a */
    public final void mo27778a(C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (inMobiAdRequestStatus == null || !StatusCode.AD_ACTIVE.equals(inMobiAdRequestStatus.getStatusCode())) {
            super.mo27778a(lVar, inMobiAdRequestStatus);
        } else {
            mo27789c(lVar, inMobiAdRequestStatus);
        }
    }

    /* renamed from: a */
    private boolean m6048a(@NonNull C2652s sVar, boolean z) throws IllegalStateException {
        C2153ac acVar;
        C2162aj ajVar = sVar.f5868p;
        if (ajVar == null) {
            acVar = null;
        } else {
            acVar = ajVar.mo27884k();
        }
        if (acVar != null) {
            return ajVar.mo27882i();
        }
        if (z) {
            m6050d(sVar, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
        throw new IllegalStateException("AdUnit doesn't have a current ad");
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: d */
    private void m6050d(@Nullable C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        int i = this.f4301c;
        if (i != 1) {
            String str = f5938g;
            if (i == 2) {
                C2514gh.m5342a(1, str, "Unable to Show Ad, canShowAd Failed");
                m6049b(true);
            } else if (i == 5) {
                C2514gh.m5342a(1, str, "Ad will be dismissed, Internal error");
                C2652s sVar = this.f5939h;
                if (sVar != null) {
                    sVar.mo28739S();
                }
                mo27777J();
                mo27793f();
            }
        } else {
            mo27789c(lVar, inMobiAdRequestStatus);
        }
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: t */
    private boolean m6052t() {
        int i = this.f4301c;
        String str = f5938g;
        if (i == 1) {
            C2514gh.m5342a(1, str, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            return false;
        } else if (i == 5) {
            if (this.f5939h != null) {
                StringBuilder sb = new StringBuilder(C2143ab.f4298a);
                sb.append(this.f5939h.mo28769e().toString());
                C2514gh.m5342a(1, str, sb.toString());
                m6049b(false);
            }
            return false;
        } else if (!this.f5940i) {
            return true;
        } else {
            C2514gh.m5342a(1, str, C2143ab.f4299b);
            return false;
        }
    }
}
