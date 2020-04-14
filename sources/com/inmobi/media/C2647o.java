package com.inmobi.media;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2159ai.C2161a;
import com.inmobi.media.C2620l.C2636a;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.o */
/* compiled from: BannerUnifiedAdManager */
public class C2647o extends C2143ab {

    /* renamed from: f */
    private static final String f5917f = "o";

    /* renamed from: g */
    private static final String f5918g = "InMobi";
    @Nullable

    /* renamed from: h */
    private C2640n f5919h;
    @Nullable

    /* renamed from: i */
    private C2640n f5920i;
    @Nullable

    /* renamed from: j */
    private C2640n f5921j;
    @Nullable

    /* renamed from: k */
    private C2640n f5922k;

    public C2647o(@NonNull C2674z zVar) {
        super(zVar);
    }

    /* renamed from: a */
    public void mo28841a(@NonNull Context context, @NonNull C2205au auVar, @NonNull String str) {
        C2159ai a = new C2161a("banner", f5918g).mo27869b(C2262c.m4584a(context)).mo27863a(auVar.f4505a).mo27870c(auVar.f4506b).mo27866a(auVar.f4507c).mo27865a(str).mo27867a();
        C2640n nVar = this.f5919h;
        if (nVar == null || this.f5920i == null) {
            this.f5919h = new C2640n(context, a, this);
            this.f5920i = new C2640n(context, a, this);
            this.f5922k = this.f5919h;
        } else {
            nVar.mo28741a(context, a, (C2636a) this);
            this.f5920i.mo28741a(context, a, (C2636a) this);
        }
        if (auVar.f4508d) {
            this.f5919h.mo28818T();
            this.f5920i.mo28818T();
        }
        this.f5919h.mo28748a(auVar.f4506b);
        this.f5920i.mo28748a(auVar.f4506b);
    }

    /* renamed from: a */
    public final void mo28805a() {
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
        C2640n nVar = this.f5922k;
        if (nVar == null) {
            mo27778a((C2620l) null, inMobiAdRequestStatus);
        } else if (nVar.mo28783r() == null) {
            mo27778a((C2620l) null, inMobiAdRequestStatus);
        } else {
            this.f5922k.mo28758b(1);
            this.f5922k.mo28736P();
        }
    }

    /* renamed from: a */
    public void mo28806a(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        mo27778a((C2620l) this.f5922k, inMobiAdRequestStatus);
    }

    /* renamed from: b */
    public void mo27783b() {
        super.mo27783b();
        this.f4301c = 0;
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2647o.this.f4302d.mo27685a();
            }
        });
    }

    /* renamed from: f */
    public void mo27793f() {
        this.f4301c = 0;
        super.mo27793f();
    }

    /* renamed from: m */
    public void mo28815m() {
        C2620l p = mo27795p();
        if (p != null) {
            p.mo28742a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }

    /* renamed from: o */
    public boolean mo28846o() {
        C2640n nVar = this.f5922k;
        if (!(nVar == null || nVar.mo28770f() == 1 || this.f5922k.mo28770f() == 2)) {
            C2640n nVar2 = this.f5921j;
            if (nVar2 == null || nVar2.mo28770f() != 8) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: p */
    public C2620l mo27795p() {
        if (m5985A()) {
            return this.f5921j;
        }
        return this.f5922k;
    }

    /* renamed from: A */
    private boolean m5985A() {
        C2640n nVar = this.f5921j;
        return nVar != null && (nVar.mo28770f() == 4 || this.f5921j.mo28770f() == 8 || this.f5921j.mo28770f() == 7);
    }

    @UiThread
    /* renamed from: a */
    public void mo28843a(@NonNull String str, boolean z) {
        C2640n nVar = this.f5922k;
        if (nVar != null) {
            if (mo27782a(f5918g, nVar.mo28769e().toString())) {
                this.f4301c = 1;
                this.f5922k.mo28826c(str);
                this.f5922k.mo28825b(z);
            }
        }
    }

    /* renamed from: q */
    public void mo28847q() {
        C2640n nVar = this.f5921j;
        if (nVar == null) {
            this.f5921j = this.f5919h;
            this.f5922k = this.f5920i;
        } else if (nVar.equals(this.f5919h)) {
            this.f5921j = this.f5920i;
            this.f5922k = this.f5919h;
        } else {
            if (this.f5921j.equals(this.f5920i)) {
                this.f5921j = this.f5919h;
                this.f5922k = this.f5920i;
            }
        }
    }

    /* renamed from: a */
    public void mo28842a(@NonNull RelativeLayout relativeLayout) {
        C2640n nVar = this.f5921j;
        if (nVar != null) {
            C2600j jVar = (C2600j) nVar.mo28781p();
            if (jVar != null) {
                C2300cu viewableAd = jVar.getViewableAd();
                if (this.f5921j.mo28819U()) {
                    jVar.mo28357a();
                }
                ViewGroup viewGroup = (ViewGroup) jVar.getParent();
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                View c = viewableAd.mo28151c();
                viewableAd.mo28149a(new View[0]);
                C2640n nVar2 = this.f5922k;
                if (nVar2 != null) {
                    nVar2.mo28821W();
                }
                if (viewGroup == null) {
                    relativeLayout.addView(c, layoutParams);
                } else {
                    viewGroup.removeAllViews();
                    viewGroup.addView(c, layoutParams);
                }
                this.f5922k.mo28722B();
            }
        }
    }

    /* renamed from: r */
    public void mo28848r() {
        C2640n nVar = this.f5921j;
        if (nVar != null) {
            nVar.mo28822X();
        }
    }

    /* renamed from: s */
    public void mo28849s() {
        C2640n nVar = this.f5921j;
        if (nVar != null) {
            nVar.mo28821W();
        }
    }

    /* renamed from: a */
    public int mo28840a(int i, int i2) {
        C2640n nVar = this.f5922k;
        if (nVar == null) {
            return i2;
        }
        if (i < nVar.mo28775k().f5175b) {
            i = this.f5922k.mo28775k().f5175b;
        }
        return i;
    }

    /* renamed from: t */
    public int mo28850t() {
        C2620l p = mo27795p();
        if (p != null) {
            return p.mo28775k().f5176c;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo28844a(long j) {
        C2640n nVar = this.f5922k;
        if (nVar == null) {
            return false;
        }
        int i = nVar.mo28775k().f5175b;
        if (SystemClock.elapsedRealtime() - j >= ((long) (i * 1000))) {
            return true;
        }
        C2640n nVar2 = this.f5922k;
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST);
        String str = "Ad cannot be refreshed before ";
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(" seconds");
        mo27789c(nVar2, inMobiAdRequestStatus.setCustomMessage(sb.toString()));
        String str2 = f5917f;
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i);
        sb2.append(" seconds (AdPlacement Id = ");
        sb2.append(this.f5922k.mo28769e().toString());
        sb2.append(")");
        C2514gh.m5342a(1, str2, sb2.toString());
        return false;
    }

    @NonNull
    /* renamed from: u */
    public String mo27796u() {
        C2640n nVar = this.f5921j;
        return nVar != null ? nVar.mo28778m() : "";
    }

    @NonNull
    /* renamed from: v */
    public JSONObject mo27797v() {
        C2640n nVar = this.f5921j;
        return nVar == null ? new JSONObject() : nVar.mo28784s();
    }

    /* renamed from: w */
    public boolean mo28851w() {
        C2640n nVar = this.f5921j;
        return nVar != null && nVar.mo28820V();
    }

    /* renamed from: x */
    public void mo28852x() {
        C2640n nVar = this.f5919h;
        if (nVar != null) {
            nVar.mo28823Y();
        }
        C2640n nVar2 = this.f5920i;
        if (nVar2 != null) {
            nVar2.mo28823Y();
        }
    }

    /* renamed from: b */
    public boolean mo28845b(@NonNull RelativeLayout relativeLayout) {
        if (this.f5921j == null) {
            return true;
        }
        C2640n nVar = this.f5922k;
        if ((nVar != null && nVar.mo28770f() == 4) || !this.f5921j.mo28738R()) {
            return true;
        }
        m5986c(relativeLayout);
        this.f5921j.mo28739S();
        return false;
    }

    /* renamed from: c */
    private void m5986c(@NonNull RelativeLayout relativeLayout) {
        C2640n nVar = this.f5921j;
        if (nVar != null) {
            C2600j jVar = (C2600j) nVar.mo28781p();
            if (jVar != null) {
                C2300cu viewableAd = jVar.getViewableAd();
                if (this.f5921j.mo28819U()) {
                    jVar.mo28357a();
                }
                View c = viewableAd.mo28151c();
                viewableAd.mo28149a(new View[0]);
                ViewGroup viewGroup = (ViewGroup) jVar.getParent();
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                if (viewGroup == null) {
                    relativeLayout.addView(c, layoutParams);
                    return;
                }
                viewGroup.removeAllViews();
                viewGroup.addView(c, layoutParams);
            }
        }
    }

    /* renamed from: a */
    public final void mo27778a(C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (mo27790c(inMobiAdRequestStatus)) {
            C2640n nVar = this.f5921j;
            if (nVar != null && nVar.equals(lVar)) {
                this.f5921j.f5869q = true;
            }
            if (lVar != null) {
                lVar.mo28742a(inMobiAdRequestStatus);
            }
        } else {
            mo27789c(lVar, inMobiAdRequestStatus);
        }
    }

    /* renamed from: b */
    public void mo27786b(@NonNull C2620l lVar, boolean z, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (2 == this.f4301c) {
            if (!z) {
            }
        } else if (!z) {
            lVar.mo28739S();
            mo27789c(lVar, inMobiAdRequestStatus);
        }
    }

    /* renamed from: y */
    public void mo28853y() {
        C2640n nVar = this.f5919h;
        if (nVar != null) {
            nVar.mo28824Z();
        }
        C2640n nVar2 = this.f5920i;
        if (nVar2 != null) {
            nVar2.mo28824Z();
        }
    }

    /* renamed from: z */
    public void mo28854z() {
        mo28852x();
        C2640n nVar = this.f5919h;
        if (nVar != null) {
            nVar.mo28722B();
            this.f5919h = null;
        }
        C2640n nVar2 = this.f5920i;
        if (nVar2 != null) {
            nVar2.mo28722B();
            this.f5920i = null;
        }
        this.f5921j = null;
        this.f5922k = null;
    }
}
