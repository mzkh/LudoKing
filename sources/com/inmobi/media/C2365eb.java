package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.inmobi.media.C2300cu.C2301a;

/* renamed from: com.inmobi.media.eb */
/* compiled from: NativeInflater */
public class C2365eb extends C2301a implements C2379b {

    /* renamed from: c */
    private static final String f5024c = "eb";
    @NonNull

    /* renamed from: b */
    public final C2368ec f5025b;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: d */
    public final C2542h f5026d;

    public C2365eb(@NonNull Context context, @NonNull C2426eq eqVar, @NonNull C2542h hVar, @NonNull C2220bg bgVar) {
        this.f5026d = hVar;
        Context context2 = context;
        C2426eq eqVar2 = eqVar;
        C2368ec ecVar = new C2368ec(context2, eqVar2, this.f5026d, bgVar, new C2380c() {
            /* renamed from: a */
            public final void mo28236a(int i, C2214bc bcVar) {
                if (!C2365eb.this.f4857a) {
                    C2365eb.this.f5026d.mo28485a(i, bcVar);
                }
            }
        }, new C2378a() {
            /* renamed from: a */
            public final void mo28237a(View view, C2214bc bcVar) {
                if (!C2365eb.this.f4857a) {
                    C2365eb.this.f5026d.mo28488a(view, bcVar);
                    C2365eb.this.f5026d.mo28489a(bcVar, false);
                }
            }
        }, this);
        this.f5025b = ecVar;
        C2404el.m5010a(hVar.f5602q);
    }

    /* renamed from: a */
    public final View mo28154a(View view, ViewGroup viewGroup, boolean z, C2600j jVar) {
        C2382ee eeVar;
        String str = "InMobiAdView";
        if (view != null) {
            View findViewWithTag = view.findViewWithTag(str);
            if (findViewWithTag != null) {
                C2382ee eeVar2 = (C2382ee) findViewWithTag;
                if (z) {
                    eeVar = this.f5025b.mo28243b(eeVar2, viewGroup, jVar);
                } else {
                    eeVar = this.f5025b.mo28240a(eeVar2, viewGroup, jVar);
                }
            } else if (z) {
                eeVar = this.f5025b.mo28243b(null, viewGroup, jVar);
            } else {
                eeVar = this.f5025b.mo28240a(null, viewGroup, jVar);
            }
        } else if (z) {
            eeVar = this.f5025b.mo28243b(null, viewGroup, jVar);
        } else {
            eeVar = this.f5025b.mo28240a(null, viewGroup, jVar);
        }
        eeVar.setNativeStrandAd(this.f5026d);
        eeVar.setTag(str);
        return eeVar;
    }

    /* renamed from: a */
    public final void mo28155a() {
        this.f5025b.mo28241a();
        super.mo28155a();
    }

    /* renamed from: a */
    public final void mo28235a(C2230bm bmVar) {
        if (bmVar.f4531k == 1) {
            this.f5026d.mo28360b();
        }
    }
}
