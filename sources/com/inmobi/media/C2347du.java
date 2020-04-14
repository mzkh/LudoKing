package com.inmobi.media;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.inmobi.media.C2353dw.C2354a;
import java.io.File;
import java.io.IOException;

/* renamed from: com.inmobi.media.du */
/* compiled from: AnimatedDrawable */
public final class C2347du implements C2353dw {

    /* renamed from: a */
    AnimatedImageDrawable f4977a;

    /* renamed from: b */
    private C2354a f4978b;

    /* renamed from: a */
    public final void mo28203a(boolean z) {
    }

    /* renamed from: e */
    public final void mo28207e() {
    }

    @SuppressLint({"NewApi"})
    public C2347du(String str) throws IOException {
        this.f4977a = (AnimatedImageDrawable) ImageDecoder.decodeDrawable(ImageDecoder.createSource(new File(str)));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public final void mo28200a() {
        this.f4977a.registerAnimationCallback(new AnimationCallback() {
            public final void onAnimationStart(Drawable drawable) {
                super.onAnimationStart(drawable);
            }

            public final void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                C2347du.this.f4977a.start();
            }
        });
        this.f4977a.start();
    }

    /* renamed from: b */
    public final int mo28204b() {
        return this.f4977a.getIntrinsicWidth();
    }

    /* renamed from: c */
    public final int mo28205c() {
        return this.f4977a.getIntrinsicHeight();
    }

    /* renamed from: a */
    public final void mo28201a(Canvas canvas, float f, float f2) {
        canvas.translate(f, f2);
        this.f4977a.draw(canvas);
    }

    /* renamed from: d */
    public final boolean mo28206d() {
        return this.f4977a.isRunning();
    }

    /* renamed from: a */
    public final void mo28202a(C2354a aVar) {
        this.f4978b = aVar;
    }
}
