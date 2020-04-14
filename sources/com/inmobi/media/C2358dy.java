package com.inmobi.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.inmobi.media.C2353dw.C2354a;

/* renamed from: com.inmobi.media.dy */
/* compiled from: GifView */
public class C2358dy extends ImageView implements C2354a {

    /* renamed from: a */
    private C2353dw f5002a;

    /* renamed from: b */
    private float f5003b;

    /* renamed from: c */
    private boolean f5004c;

    /* renamed from: d */
    private String f5005d;

    public C2358dy(Context context) {
        this(context, 0);
    }

    private C2358dy(Context context, byte b) {
        super(context, null);
        this.f5003b = 1.0f;
        this.f5004c = true;
        this.f5005d = "unspecified";
        setLayerType(1, null);
    }

    public void setPaused(boolean z) {
        this.f5002a.mo28203a(z);
    }

    public void setGifImpl(C2353dw dwVar) {
        this.f5002a = dwVar;
        C2353dw dwVar2 = this.f5002a;
        if (dwVar2 != null) {
            dwVar2.mo28202a((C2354a) this);
            this.f5002a.mo28200a();
        }
        requestLayout();
    }

    public void setContentMode(String str) {
        this.f5005d = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0075  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float[] m4916a(android.graphics.Canvas r10) {
        /*
            r9 = this;
            int r0 = r9.getWidth()
            float r0 = (float) r0
            int r1 = r9.getHeight()
            float r1 = (float) r1
            com.inmobi.media.dw r2 = r9.f5002a
            int r2 = r2.mo28204b()
            float r2 = (float) r2
            float r3 = r9.f5003b
            float r2 = r2 * r3
            com.inmobi.media.dw r3 = r9.f5002a
            int r3 = r3.mo28205c()
            float r3 = (float) r3
            float r4 = r9.f5003b
            float r3 = r3 * r4
            java.lang.String r4 = r9.f5005d
            int r5 = r4.hashCode()
            r6 = -1362001767(0xffffffffaed18099, float:-9.527063E-11)
            r7 = 0
            r8 = 1
            if (r5 == r6) goto L_0x003d
            r6 = 727618043(0x2b5e91fb, float:7.907283E-13)
            if (r5 == r6) goto L_0x0033
            goto L_0x0047
        L_0x0033:
            java.lang.String r5 = "aspectFill"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0047
            r4 = 0
            goto L_0x0048
        L_0x003d:
            java.lang.String r5 = "aspectFit"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0047
            r4 = 1
            goto L_0x0048
        L_0x0047:
            r4 = -1
        L_0x0048:
            r5 = 0
            r6 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L_0x0075
            if (r4 == r8) goto L_0x0057
            float r0 = r0 / r2
            float r1 = r1 / r3
            r10.scale(r0, r1)
            r4 = r1
            r0 = 0
            goto L_0x0092
        L_0x0057:
            float r4 = r1 / r3
            float r5 = r0 / r2
            float r4 = java.lang.Math.min(r4, r5)
            float r2 = r2 * r4
            float r0 = r0 - r2
            float r0 = r0 / r6
            float r2 = r9.f5003b
            float r5 = r4 * r2
            float r5 = r0 / r5
            float r3 = r3 * r4
            float r1 = r1 - r3
            float r1 = r1 / r6
            float r2 = r2 * r4
            float r0 = r1 / r2
            r10.scale(r4, r4)
            goto L_0x0092
        L_0x0075:
            float r4 = r1 / r3
            float r5 = r0 / r2
            float r4 = java.lang.Math.max(r4, r5)
            float r2 = r2 * r4
            float r0 = r0 - r2
            float r0 = r0 / r6
            float r2 = r9.f5003b
            float r5 = r4 * r2
            float r5 = r0 / r5
            float r3 = r3 * r4
            float r1 = r1 - r3
            float r1 = r1 / r6
            float r2 = r2 * r4
            float r0 = r1 / r2
            r10.scale(r4, r4)
        L_0x0092:
            r10 = 3
            float[] r10 = new float[r10]
            r10[r7] = r5
            r10[r8] = r0
            r0 = 2
            r10[r0] = r4
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2358dy.m4916a(android.graphics.Canvas):float[]");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f5003b = getScale();
        Drawable drawable = getDrawable();
        int i3 = 0;
        int i4 = 1;
        if (drawable != null) {
            i3 = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (i3 <= 0) {
                i3 = 1;
            }
            if (intrinsicHeight > 0) {
                i4 = intrinsicHeight;
            }
        } else {
            C2353dw dwVar = this.f5002a;
            if (dwVar != null) {
                int b = dwVar.mo28204b();
                int c = this.f5002a.mo28205c();
                if (b <= 0) {
                    b = 1;
                }
                if (c > 0) {
                    i4 = c;
                }
                i3 = b;
            } else {
                i4 = 0;
            }
        }
        int paddingTop = i4 + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSize(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i), resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i2));
    }

    private int getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(getContext() instanceof Activity)) {
            return 240;
        }
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    private float getScale() {
        this.f5003b = ((float) getContext().getResources().getDisplayMetrics().densityDpi) / ((float) getDensity());
        if (this.f5003b < 0.1f) {
            this.f5003b = 0.1f;
        }
        if (this.f5003b > 5.0f) {
            this.f5003b = 5.0f;
        }
        return this.f5003b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5004c = getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C2353dw dwVar = this.f5002a;
        if (dwVar != null) {
            if (dwVar.mo28206d()) {
                this.f5002a.mo28207e();
                m4918b(canvas);
                m4917b();
                return;
            }
            m4918b(canvas);
        }
    }

    /* renamed from: b */
    private void m4918b(Canvas canvas) {
        canvas.save();
        float f = this.f5003b;
        canvas.scale(f, f);
        float[] a = m4916a(canvas);
        this.f5002a.mo28201a(canvas, a[0], a[1]);
        canvas.restore();
    }

    /* renamed from: b */
    private void m4917b() {
        if (this.f5004c) {
            if (VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
                return;
            }
            invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f5004c = z;
        m4917b();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        this.f5004c = i == 0;
        m4917b();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f5004c = i == 0;
        m4917b();
    }

    /* renamed from: a */
    public final void mo28216a() {
        invalidate();
    }
}
