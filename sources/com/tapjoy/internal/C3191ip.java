package com.tapjoy.internal;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.tapjoy.internal.ip */
public final class C3191ip extends C2871ai {

    /* renamed from: a */
    private final C1845hu f7612a;

    /* renamed from: b */
    private final C3192iq f7613b;

    /* renamed from: c */
    private C2859aa f7614c = null;

    public C3191ip(Context context, C1845hu huVar, C3192iq iqVar) {
        super(context);
        this.f7612a = huVar;
        this.f7613b = iqVar;
        addView(iqVar, new LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        C2859aa aaVar;
        C2859aa aaVar2;
        C2859aa a = C2859aa.m6557a(getContext());
        if (!this.f7612a.mo18187a()) {
            aaVar = C2859aa.LANDSCAPE;
            if (!a.mo29787a()) {
                setRotationCount(0);
            } else if (a.mo29789c() == 3) {
                setRotationCount(1);
            } else {
                setRotationCount(1);
            }
        } else if (this.f7612a.mo18188b()) {
            if (a.mo29787a()) {
                aaVar2 = C2859aa.PORTRAIT;
            } else if (a.mo29788b() || !C2859aa.m6558b(getContext()).mo29787a()) {
                aaVar2 = C2859aa.LANDSCAPE;
            } else {
                aaVar2 = C2859aa.PORTRAIT;
            }
            setRotationCount(0);
            aaVar = aaVar2;
        } else {
            aaVar = C2859aa.PORTRAIT;
            if (!a.mo29788b()) {
                setRotationCount(0);
            } else if (a.mo29789c() == 3) {
                setRotationCount(1);
            } else {
                setRotationCount(3);
            }
        }
        if (this.f7614c != aaVar) {
            this.f7614c = aaVar;
            this.f7613b.setLandscape(this.f7614c.mo29788b());
        }
        super.onMeasure(i, i2);
    }
}
