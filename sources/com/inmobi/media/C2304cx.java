package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.inmobi.media.cx */
/* compiled from: ViewableNativeV2VideoAd */
public final class C2304cx extends C2300cu {
    @NonNull

    /* renamed from: d */
    private final C2596i f4862d;

    /* renamed from: e */
    private boolean f4863e = false;

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

    public C2304cx(@NonNull C2596i iVar) {
        super(iVar);
        this.f4862d = iVar;
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        if (this.f4863e) {
            return null;
        }
        Context m = this.f4862d.mo28502m();
        if (m == null) {
            return null;
        }
        C2426eq eqVar = this.f4855c;
        C2596i iVar = this.f4862d;
        this.f4854b = new C2365eb(m, eqVar, iVar, iVar.mo28500k());
        View a = this.f4854b.mo28154a(view, viewGroup, false, null);
        mo28148a(a);
        this.f4862d.mo28519w();
        return a;
    }

    /* renamed from: e */
    public final void mo28153e() {
        if (!this.f4863e) {
            this.f4863e = true;
            if (this.f4854b != null) {
                this.f4854b.mo28155a();
                this.f4854b = null;
            }
            super.mo28153e();
        }
    }
}
