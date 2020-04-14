package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2300cu.C2301a;
import com.inmobi.media.C2426eq.C2435i;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.dc */
/* compiled from: InMobiTrackedNativeV2VideoAd */
public class C2318dc extends C2299ct {

    /* renamed from: d */
    private static final String f4895d = "dc";
    @NonNull

    /* renamed from: e */
    private final WeakReference<Context> f4896e;
    @NonNull

    /* renamed from: f */
    private final C2300cu f4897f;
    @NonNull

    /* renamed from: g */
    private final C2319dd f4898g = new C2319dd(0);
    @NonNull

    /* renamed from: h */
    private final C2542h f4899h;

    public C2318dc(@NonNull C2596i iVar, @NonNull C2300cu cuVar) {
        super(iVar);
        this.f4896e = new WeakReference<>(iVar.mo28502m());
        this.f4897f = cuVar;
        this.f4899h = iVar;
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4897f.mo28150b();
    }

    /* renamed from: a */
    public final C2301a mo28145a() {
        return this.f4897f.mo28145a();
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            Context context = (Context) this.f4896e.get();
            C2596i iVar = (C2596i) this.f4853a;
            if (!iVar.f5595j && context != null) {
                this.f4898g.mo28177a(context, (C2542h) iVar);
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4897f.mo28152d();
            throw th;
        }
        this.f4897f.mo28152d();
    }

    /* renamed from: a */
    public final void mo28146a(int i) {
        this.f4897f.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        if (i == 0) {
            C2319dd.m4763b(context);
        } else if (i == 1) {
            C2319dd.m4764c(context);
        } else if (i == 2) {
            try {
                this.f4898g.mo28173a(context);
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            } catch (Throwable th) {
                this.f4897f.mo28147a(context, i);
                throw th;
            }
        }
        this.f4897f.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        this.f4898g.mo28174a((Context) this.f4896e.get(), this.f4897f.mo28150b(), this.f4899h);
        super.mo28153e();
        this.f4896e.clear();
        this.f4897f.mo28153e();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        View b = this.f4897f.mo28150b();
        if (b != null) {
            this.f4898g.mo28174a((Context) this.f4896e.get(), b, this.f4899h);
        }
        return this.f4897f.mo28144a(view, viewGroup, z);
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            C2596i iVar = (C2596i) this.f4853a;
            C2403ek ekVar = (C2403ek) iVar.getVideoContainerView();
            Context context = (Context) this.f4896e.get();
            C2435i iVar2 = this.f4855c.f5182i;
            if (!(context == null || ekVar == null || iVar.f5595j)) {
                C2390ej videoView = ekVar.getVideoView();
                this.f4898g.mo28176a(context, videoView, iVar, iVar2);
                View b = this.f4897f.mo28150b();
                if (!(videoView.getTag() == null || b == null)) {
                    C2235bp bpVar = (C2235bp) videoView.getTag();
                    if (iVar.getPlacementType() == 0 && !((Boolean) bpVar.f4542v.get("isFullScreen")).booleanValue()) {
                        this.f4898g.mo28175a(context, b, this.f4899h, ((C2596i) this.f4899h).f5748w, iVar2);
                    }
                }
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4897f.mo28149a(viewArr);
            throw th;
        }
        this.f4897f.mo28149a(viewArr);
    }
}
