package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/* renamed from: com.tapjoy.internal.ah */
public final class C2870ah {

    /* renamed from: a */
    protected int f6658a = 0;

    /* renamed from: b */
    protected float f6659b = 0.0f;

    /* renamed from: c */
    protected int f6660c = 0;

    /* renamed from: d */
    protected float f6661d = 0.0f;

    /* renamed from: e */
    protected int f6662e = 0;

    /* renamed from: f */
    protected float f6663f = 0.0f;

    /* renamed from: g */
    protected int f6664g = 0;

    /* renamed from: h */
    protected float f6665h = 0.0f;

    /* renamed from: a */
    public final Animation mo29800a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f6658a, this.f6659b, this.f6660c, this.f6661d, this.f6662e, this.f6663f, this.f6664g, this.f6665h);
        return translateAnimation;
    }

    /* renamed from: a */
    public final C2870ah mo29801a(float f) {
        this.f6658a = 1;
        this.f6659b = f;
        return this;
    }

    /* renamed from: b */
    public final C2870ah mo29802b(float f) {
        this.f6662e = 1;
        this.f6663f = f;
        return this;
    }
}
