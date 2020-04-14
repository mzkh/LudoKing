package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* renamed from: com.tapjoy.internal.in */
public final class C3186in extends View {

    /* renamed from: a */
    public boolean f7588a = false;

    /* renamed from: b */
    private Bitmap f7589b = null;

    /* renamed from: c */
    private Rect f7590c = null;

    /* renamed from: d */
    private Rect f7591d = null;

    /* renamed from: e */
    private Rect f7592e = null;

    /* renamed from: f */
    private Rect f7593f = new Rect();

    public C3186in(Context context) {
        super(context);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.f7589b = bitmap;
        int width = this.f7589b.getWidth();
        int height = this.f7589b.getHeight();
        int i = width / 2;
        this.f7591d = new Rect(0, 0, i, height);
        this.f7590c = new Rect(i, 0, width, height);
        mo30258a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30258a() {
        if (this.f7588a) {
            this.f7592e = this.f7590c;
        } else {
            this.f7592e = this.f7591d;
        }
    }

    public final void onDraw(Canvas canvas) {
        if (this.f7592e != null && this.f7589b != null) {
            getDrawingRect(this.f7593f);
            canvas.drawBitmap(this.f7589b, this.f7592e, this.f7593f, null);
        }
    }
}
