package com.inmobi.media;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.inmobi.media.a */
/* compiled from: AnimationController */
final class C2138a {

    /* renamed from: com.inmobi.media.a$a */
    /* compiled from: AnimationController */
    public static class C2139a extends Animation {

        /* renamed from: a */
        private final float f4282a = 0.0f;

        /* renamed from: b */
        private final float f4283b = 90.0f;

        /* renamed from: c */
        private final float f4284c;

        /* renamed from: d */
        private final float f4285d;

        /* renamed from: e */
        private final float f4286e;

        /* renamed from: f */
        private final boolean f4287f;

        /* renamed from: g */
        private Camera f4288g;

        public C2139a(float f, float f2) {
            this.f4284c = f;
            this.f4285d = f2;
            this.f4286e = 0.0f;
            this.f4287f = true;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.f4288g = new Camera();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.f4282a;
            float f3 = f2 + ((this.f4283b - f2) * f);
            float f4 = this.f4284c;
            float f5 = this.f4285d;
            Camera camera = this.f4288g;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f4287f) {
                camera.translate(0.0f, 0.0f, this.f4286e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f4286e * (1.0f - f));
            }
            camera.rotateX(f3);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
    }

    /* renamed from: com.inmobi.media.a$b */
    /* compiled from: AnimationController */
    public static class C2140b extends Animation {

        /* renamed from: a */
        private final float f4289a = 0.0f;

        /* renamed from: b */
        private final float f4290b = 90.0f;

        /* renamed from: c */
        private final float f4291c;

        /* renamed from: d */
        private final float f4292d;

        /* renamed from: e */
        private final float f4293e;

        /* renamed from: f */
        private final boolean f4294f;

        /* renamed from: g */
        private Camera f4295g;

        public C2140b(float f, float f2) {
            this.f4291c = f;
            this.f4292d = f2;
            this.f4293e = 0.0f;
            this.f4294f = true;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.f4295g = new Camera();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.f4289a;
            float f3 = f2 + ((this.f4290b - f2) * f);
            float f4 = this.f4291c;
            float f5 = this.f4292d;
            Camera camera = this.f4295g;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f4294f) {
                camera.translate(0.0f, 0.0f, this.f4293e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f4293e * (1.0f - f));
            }
            camera.rotateY(f3);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
    }
}
