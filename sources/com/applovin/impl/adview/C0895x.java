package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C0826h.C0827a;
import com.applovin.impl.sdk.C1192i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.x */
public final class C0895x extends C0826h {

    /* renamed from: d */
    private static final Paint f1625d = new Paint(1);

    /* renamed from: e */
    private static final Paint f1626e = new Paint(1);

    /* renamed from: f */
    private static final Paint f1627f = new Paint(1);

    /* renamed from: c */
    private float f1628c = 1.0f;

    public C0895x(C1192i iVar, Context context) {
        super(iVar, context);
        f1625d.setColor(-1);
        f1626e.setColor(ViewCompat.MEASURED_STATE_MASK);
        f1627f.setColor(-1);
        f1627f.setStyle(Style.STROKE);
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
        return this.f1628c * 10.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.f1628c * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    /* access modifiers changed from: protected */
    public float getSize() {
        return this.f1628c * 30.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f1628c * 3.0f;
    }

    public C0827a getStyle() {
        return C0827a.WhiteXOnOpaqueBlack;
    }

    public float getViewScale() {
        return this.f1628c;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f1625d);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f1626e);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        f1627f.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        canvas2.drawLine(f, crossOffset, f2, size, f1627f);
        canvas2.drawLine(f, size, f2, crossOffset, f1627f);
    }

    public void setViewScale(float f) {
        this.f1628c = f;
    }
}
