package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.tapjoy.internal.af */
public final class C2868af extends Animation {

    /* renamed from: a */
    private final boolean f6641a;

    /* renamed from: b */
    private final float f6642b;

    /* renamed from: c */
    private final float f6643c;

    /* renamed from: d */
    private final int f6644d;

    /* renamed from: e */
    private final float f6645e;

    /* renamed from: f */
    private final int f6646f;

    /* renamed from: g */
    private final float f6647g;

    /* renamed from: h */
    private float f6648h;

    /* renamed from: i */
    private float f6649i;

    /* renamed from: j */
    private Camera f6650j;

    public C2868af(boolean z, float f, float f2, int i, float f3, int i2, float f4) {
        this.f6641a = z;
        this.f6642b = f;
        this.f6643c = f2;
        this.f6644d = i;
        this.f6645e = f3;
        this.f6646f = i2;
        this.f6647g = f4;
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f6648h = resolveSize(this.f6644d, this.f6645e, i, i3);
        this.f6649i = resolveSize(this.f6646f, this.f6647g, i2, i4);
        this.f6650j = new Camera();
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f6642b;
        float f3 = f2 + ((this.f6643c - f2) * f);
        Matrix matrix = transformation.getMatrix();
        Camera camera = this.f6650j;
        camera.save();
        if (this.f6641a) {
            camera.rotateX(f3);
        } else {
            camera.rotateY(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        float f4 = this.f6648h;
        float f5 = this.f6649i;
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
