package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2159ai.C2161a;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.x */
/* compiled from: NativeUnifiedAdManager */
public class C2666x extends C2143ab {

    /* renamed from: f */
    private static final String f5954f = "x";

    /* renamed from: g */
    private static final String f5955g = "InMobi";
    @Nullable

    /* renamed from: h */
    private C2663v f5956h;

    /* renamed from: c */
    public void mo28809c() {
    }

    public C2666x(@NonNull C2674z zVar) {
        super(zVar);
    }

    /* renamed from: a */
    public void mo28883a(@NonNull C2205au auVar, @NonNull Context context) {
        C2663v vVar = this.f5956h;
        if (vVar == null) {
            this.f5956h = new C2663v(context, new C2161a("native", f5955g).mo27863a(auVar.f4505a).mo27869b(C2262c.m4584a(context)).mo27870c(auVar.f4506b).mo27866a(auVar.f4507c).mo27867a(), this);
        } else {
            vVar.mo28740a(context);
            this.f5956h.mo28762b(C2262c.m4584a(context));
        }
        this.f5956h.mo28748a(auVar.f4506b);
        this.f5956h.mo28752a(auVar.f4507c);
    }

    /* renamed from: o */
    public boolean mo28885o() {
        C2663v vVar = this.f5956h;
        return vVar != null && vVar.mo28819U();
    }

    @Nullable
    /* renamed from: p */
    public C2620l mo27795p() {
        return this.f5956h;
    }

    /* renamed from: a */
    public void mo28805a() {
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
        C2663v vVar = this.f5956h;
        if (vVar == null) {
            mo27778a((C2620l) null, inMobiAdRequestStatus);
        } else if (vVar.mo28783r() == null) {
            mo27778a((C2620l) null, inMobiAdRequestStatus);
        } else {
            this.f4303e.post(new Runnable() {
                public final void run() {
                    C2666x.this.f4302d.mo27706e();
                }
            });
            if (!mo28885o()) {
                this.f5956h.mo28758b(1);
                this.f5956h.mo28736P();
            }
        }
    }

    /* renamed from: a */
    public void mo28806a(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        mo27778a((C2620l) this.f5956h, inMobiAdRequestStatus);
    }

    @UiThread
    /* renamed from: q */
    public void mo28886q() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            if (mo27782a(f5955g, vVar.mo28769e().toString())) {
                this.f4301c = 1;
                this.f5956h.mo28788w();
            }
        }
    }

    /* renamed from: b */
    public void mo27783b() {
        super.mo27783b();
        this.f4301c = 2;
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2666x.this.f4302d.mo27685a();
            }
        });
    }

    /* renamed from: r */
    public void mo28887r() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            vVar.mo28818T();
        }
        this.f5956h = null;
    }

    /* renamed from: s */
    public void mo28888s() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            if (vVar.f5859g != null) {
                vVar.f5859g.mo28517u();
            }
            return;
        }
        C2514gh.m5342a(1, f5954f, "InMobiNative is not initialized. Ignoring takeAction");
    }

    /* renamed from: t */
    public void mo28889t() {
        C2663v vVar = this.f5956h;
        if (vVar != null && vVar.mo28770f() == 5 && !(vVar.mo28767d() instanceof Activity)) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                ((C2542h) p).mo28516t();
            }
        }
    }

    /* renamed from: w */
    public void mo28890w() {
        C2663v vVar = this.f5956h;
        if (vVar != null && vVar.mo28770f() == 5 && !(vVar.mo28767d() instanceof Activity)) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                ((C2542h) p).mo28515s();
            }
        }
    }

    /* renamed from: x */
    public JSONObject mo28891x() {
        C2663v vVar = this.f5956h;
        if (vVar == null) {
            return new JSONObject();
        }
        C2452f p = vVar.mo28781p();
        if (p != null) {
            C2220bg bgVar = (C2220bg) p.getDataModel();
            if (bgVar != null) {
                return bgVar.f4572i.f4584a;
            }
        }
        return null;
    }

    /* renamed from: y */
    public String mo28892y() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2220bg bgVar = (C2220bg) p.getDataModel();
                if (bgVar != null) {
                    return bgVar.f4572i.f4585b.f4588a;
                }
            }
        }
        return null;
    }

    /* renamed from: z */
    public String mo28893z() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2220bg bgVar = (C2220bg) p.getDataModel();
                if (bgVar != null) {
                    return bgVar.f4572i.f4585b.f4589b;
                }
            }
        }
        return null;
    }

    /* renamed from: A */
    public String mo28876A() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2220bg bgVar = (C2220bg) p.getDataModel();
                if (bgVar != null) {
                    return bgVar.f4572i.f4585b.f4590c;
                }
            }
        }
        return null;
    }

    /* renamed from: B */
    public String mo28877B() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2220bg bgVar = (C2220bg) p.getDataModel();
                if (bgVar != null) {
                    return bgVar.f4572i.f4585b.f4593f;
                }
            }
        }
        return null;
    }

    /* renamed from: C */
    public String mo28878C() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2220bg bgVar = (C2220bg) p.getDataModel();
                if (bgVar != null) {
                    return bgVar.f4572i.f4585b.f4591d;
                }
            }
        }
        return null;
    }

    /* renamed from: D */
    public float mo28879D() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2220bg bgVar = (C2220bg) p.getDataModel();
                if (bgVar != null) {
                    return bgVar.f4572i.f4585b.f4592e;
                }
            }
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* renamed from: E */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo28880E() {
        /*
            r2 = this;
            com.inmobi.media.v r0 = r2.f5956h
            r1 = 0
            if (r0 == 0) goto L_0x001f
            com.inmobi.media.f r0 = r0.mo28781p()
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r0.getDataModel()
            com.inmobi.media.bg r0 = (com.inmobi.media.C2220bg) r0
            if (r0 == 0) goto L_0x001a
            com.inmobi.media.bg$a r0 = r0.f4572i
            com.inmobi.media.bg$a$a r0 = r0.f4585b
            boolean r0 = r0.f4594g
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 == 0) goto L_0x001f
            r0 = 1
            return r0
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2666x.mo28880E():boolean");
    }

    @Nullable
    /* renamed from: F */
    public Boolean mo28881F() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                return Boolean.valueOf(p instanceof C2596i);
            }
        }
        return null;
    }

    /* renamed from: G */
    public void mo28882G() {
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            C2452f p = vVar.mo28781p();
            if (p != null) {
                C2542h hVar = (C2542h) p;
                C2220bg k = hVar.mo28500k();
                if (k != null) {
                    hVar.mo28488a((View) null, k.f4572i.f4586c);
                    hVar.mo28489a(k.f4572i.f4586c, true);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo28884b(@NonNull C2205au auVar, @NonNull Context context) {
        if (this.f5956h == null) {
            mo28883a(auVar, context);
        }
        C2663v vVar = this.f5956h;
        if (vVar != null) {
            vVar.f5949t = true;
        }
    }

    /* renamed from: h */
    public void mo28810h() {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2666x.this.f4302d.mo27739h();
            }
        });
    }

    /* renamed from: k */
    public void mo28813k() {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2666x.this.f4302d.mo27741j();
            }
        });
    }

    /* renamed from: i */
    public void mo28811i() {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2666x.this.f4302d.mo27740i();
            }
        });
    }

    /* renamed from: a */
    public void mo28808a(final boolean z) {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2666x.this.f4302d.mo27738a(z);
            }
        });
    }
}
