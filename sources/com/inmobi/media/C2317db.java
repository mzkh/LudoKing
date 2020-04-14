package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2300cu.C2301a;
import com.inmobi.media.C2426eq.C2435i;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.db */
/* compiled from: InMobiTrackedNativeV2DisplayAd */
public class C2317db extends C2299ct {

    /* renamed from: d */
    private static final String f4890d = "db";
    @NonNull

    /* renamed from: e */
    private final WeakReference<Context> f4891e;
    @NonNull

    /* renamed from: f */
    private final C2300cu f4892f;
    @NonNull

    /* renamed from: g */
    private final C2319dd f4893g = new C2319dd(1);
    @NonNull

    /* renamed from: h */
    private final C2542h f4894h;

    public C2317db(@NonNull Context context, @NonNull C2542h hVar, @NonNull C2300cu cuVar) {
        super(hVar);
        this.f4891e = new WeakReference<>(context);
        this.f4892f = cuVar;
        this.f4894h = hVar;
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4892f.mo28150b();
    }

    /* renamed from: a */
    public final C2301a mo28145a() {
        return this.f4892f.mo28145a();
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            Context context = (Context) this.f4891e.get();
            View b = this.f4892f.mo28150b();
            C2435i iVar = this.f4855c.f5182i;
            C2542h hVar = (C2542h) this.f4853a;
            if (!(context == null || b == null || hVar.f5595j)) {
                this.f4893g.mo28176a(context, b, hVar, iVar);
                this.f4893g.mo28175a(context, b, this.f4894h, this.f4894h.f5607v, iVar);
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4892f.mo28149a(viewArr);
            throw th;
        }
        this.f4892f.mo28149a(viewArr);
    }

    /* renamed from: a */
    public final void mo28146a(int i) {
        this.f4892f.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        if (i == 0) {
            C2319dd.m4763b(context);
        } else if (i == 1) {
            C2319dd.m4764c(context);
        } else if (i == 2) {
            try {
                this.f4893g.mo28173a(context);
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            } catch (Throwable th) {
                this.f4892f.mo28147a(context, i);
                throw th;
            }
        }
        this.f4892f.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        this.f4893g.mo28174a(this.f4894h.mo28496g(), this.f4892f.mo28150b(), this.f4894h);
        super.mo28153e();
        this.f4891e.clear();
        this.f4892f.mo28153e();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        View b = this.f4892f.mo28150b();
        if (b != null) {
            this.f4893g.mo28174a(this.f4894h.mo28496g(), b, this.f4894h);
        }
        return this.f4892f.mo28144a(view, viewGroup, z);
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            C2542h hVar = (C2542h) this.f4853a;
            if (!hVar.f5595j) {
                this.f4893g.mo28177a((Context) this.f4891e.get(), hVar);
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4892f.mo28152d();
            throw th;
        }
        this.f4892f.mo28152d();
    }
}
