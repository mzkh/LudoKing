package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.applovin.impl.adview.C0826h.C0827a;
import com.applovin.impl.sdk.C1192i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.q */
public final class C0886q extends C0826h {

    /* renamed from: d */
    private static final Paint f1606d = new Paint(1);

    /* renamed from: e */
    private static final Paint f1607e = new Paint(1);

    /* renamed from: c */
    private float f1608c = 1.0f;

    public C0886q(C1192i iVar, Context context) {
        super(iVar, context);
        f1606d.setARGB(80, 0, 0, 0);
        f1607e.setColor(-1);
        f1607e.setStyle(Style.STROKE);
    }

    /* renamed from: a */
    public void mo9078a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f1608c * 8.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.f1608c * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    /* access modifiers changed from: protected */
    public float getSize() {
        return this.f1608c * 30.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f1608c * 2.0f;
    }

    public C0827a getStyle() {
        return C0827a.WhiteXOnTransparentGrey;
    }

    public float getViewScale() {
        return this.f1608c;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f1606d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        f1607e.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        canvas2.drawLine(f, crossOffset, f2, size, f1607e);
        canvas2.drawLine(f, size, f2, crossOffset, f1607e);
    }

    public void setViewScale(float f) {
        this.f1608c = f;
    }
}
