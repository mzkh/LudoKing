package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import com.applovin.impl.adview.C0826h.C0827a;
import com.applovin.impl.sdk.C1192i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.o */
public final class C0882o extends C0826h {

    /* renamed from: c */
    private float f1596c = 1.0f;

    public C0882o(C1192i iVar, Context context) {
        super(iVar, context);
    }

    /* renamed from: a */
    public void mo9078a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    public C0827a getStyle() {
        return C0827a.Invisible;
    }

    public float getViewScale() {
        return this.f1596c;
    }

    public void setViewScale(float f) {
        this.f1596c = f;
    }
}
