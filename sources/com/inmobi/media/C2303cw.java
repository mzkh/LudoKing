package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.inmobi.media.cw */
/* compiled from: ViewableNativeV2DisplayAd */
public final class C2303cw extends C2300cu {
    @NonNull

    /* renamed from: d */
    private final C2542h f4859d;

    /* renamed from: e */
    private boolean f4860e = false;
    @Nullable

    /* renamed from: f */
    private C2600j f4861f;

    /* renamed from: a */
    public final void mo28146a(int i) {
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
    }

    /* renamed from: d */
    public final void mo28152d() {
    }

    public C2303cw(@NonNull C2542h hVar, @Nullable C2600j jVar) {
        super(hVar);
        this.f4859d = hVar;
        this.f4861f = jVar;
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        if (this.f4860e) {
            return null;
        }
        Context m = this.f4859d.mo28502m();
        if (m == null) {
            return null;
        }
        C2426eq eqVar = this.f4855c;
        C2542h hVar = this.f4859d;
        this.f4854b = new C2365eb(m, eqVar, hVar, hVar.mo28500k());
        C2514gh.m5342a(2, "InMobi", "Ad markup loaded into the container will be inflated into a View.");
        View a = this.f4854b.mo28154a(view, viewGroup, z, this.f4861f);
        mo28148a(a);
        this.f4859d.mo28519w();
        return a;
    }

    /* renamed from: e */
    public final void mo28153e() {
        if (!this.f4860e) {
            this.f4860e = true;
            if (this.f4854b != null) {
                this.f4854b.mo28155a();
                this.f4854b = null;
            }
            C2600j jVar = this.f4861f;
            if (jVar != null) {
                jVar.destroy();
                this.f4861f = null;
            }
            super.mo28153e();
        }
    }
}
