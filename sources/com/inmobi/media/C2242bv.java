package com.inmobi.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.inmobi.media.bv */
/* compiled from: CustomView */
public class C2242bv extends View {

    /* renamed from: a */
    private static final String f4667a = "bv";

    /* renamed from: b */
    private float f4668b;

    /* renamed from: c */
    private float f4669c;

    /* renamed from: d */
    private float f4670d;

    /* renamed from: e */
    private float f4671e;

    /* renamed from: f */
    private float f4672f;

    /* renamed from: g */
    private int f4673g;

    /* renamed from: h */
    private int f4674h;

    /* renamed from: i */
    private Paint f4675i;

    /* renamed from: j */
    private Path f4676j;

    /* renamed from: k */
    private RectF f4677k;

    private C2242bv(Context context) {
        super(context);
    }

    public C2242bv(Context context, float f, int i) {
        this(context);
        this.f4673g = i;
        this.f4668b = f;
        this.f4674h = 15;
        this.f4675i = new Paint(1);
        this.f4677k = new RectF();
        this.f4676j = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        this.f4675i.reset();
        switch (this.f4673g) {
            case 0:
                float f = this.f4668b;
                float f2 = (50.0f * f) / 2.0f;
                float f3 = (f * 30.0f) / 2.0f;
                float f4 = f3 / 3.0f;
                float f5 = f2 - f4;
                float f6 = f2 + f4;
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f4675i.setStrokeWidth(3.0f);
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawCircle(f2, f2, f3, this.f4675i);
                this.f4675i.setColor(-1);
                this.f4675i.setStyle(Style.STROKE);
                Canvas canvas3 = canvas;
                float f7 = f5;
                float f8 = f6;
                canvas3.drawLine(f7, f5, f8, f6, this.f4675i);
                canvas3.drawLine(f7, f6, f8, f5, this.f4675i);
                canvas2.drawCircle(f2, f2, f3, this.f4675i);
                break;
            case 1:
                float f9 = (this.f4668b * 50.0f) / 2.0f;
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(0);
                this.f4675i.setStrokeWidth(3.0f);
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawCircle(f9, f9, f9, this.f4675i);
                return;
            case 2:
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(-1);
                this.f4675i.setStrokeWidth(5.0f);
                this.f4675i.setStyle(Style.STROKE);
                Canvas canvas4 = canvas;
                canvas4.drawLine(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((((float) this.f4674h) * this.f4668b) / 2.0f) + ((float) (getWidth() / 2)), ((((float) this.f4674h) * this.f4668b) / 2.0f) + ((float) (getHeight() / 2)), this.f4675i);
                Canvas canvas5 = canvas;
                canvas5.drawLine(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((((float) this.f4674h) * this.f4668b) / 2.0f) + ((float) (getHeight() / 2)), ((((float) this.f4674h) * this.f4668b) / 2.0f) + ((float) (getWidth() / 2)), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), this.f4675i);
                break;
            case 3:
                float f10 = this.f4668b;
                float f11 = (50.0f * f10) / 2.0f;
                float f12 = (f10 * 30.0f) / 2.0f;
                this.f4676j.reset();
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f4675i.setStrokeWidth(3.0f);
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawCircle(f11, f11, f12, this.f4675i);
                this.f4675i.setColor(-1);
                this.f4675i.setStyle(Style.STROKE);
                canvas2.drawCircle(f11, f11, f12, this.f4675i);
                this.f4677k.set(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f));
                canvas.drawArc(this.f4677k, 0.0f, 270.0f, false, this.f4675i);
                this.f4676j.setFillType(FillType.EVEN_ODD);
                this.f4676j.moveTo(((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - (this.f4668b * 2.0f));
                Path path = this.f4676j;
                float width = (float) (getWidth() / 2);
                float f13 = (float) this.f4674h;
                float f14 = this.f4668b;
                path.lineTo((width + ((f13 * f14) / 2.0f)) - (f14 * 2.0f), (float) (getHeight() / 2));
                Path path2 = this.f4676j;
                float width2 = (float) (getWidth() / 2);
                float f15 = (float) this.f4674h;
                float f16 = this.f4668b;
                path2.lineTo(width2 + ((f15 * f16) / 2.0f) + (f16 * 2.0f), (float) (getHeight() / 2));
                this.f4676j.lineTo(((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - (this.f4668b * 2.0f));
                this.f4676j.close();
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 4:
                this.f4676j.reset();
                this.f4676j.setFillType(FillType.EVEN_ODD);
                this.f4676j.moveTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), (float) (getHeight() / 2));
                this.f4676j.lineTo(((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.lineTo(((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.lineTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), (float) (getHeight() / 2));
                this.f4676j.close();
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f4675i.setStrokeWidth(3.0f);
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 5:
                this.f4676j.reset();
                this.f4676j.setFillType(FillType.EVEN_ODD);
                this.f4676j.moveTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.lineTo(((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), (float) (getHeight() / 2));
                this.f4676j.lineTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.lineTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.close();
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f4675i.setStrokeWidth(3.0f);
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 6:
                this.f4676j.reset();
                this.f4676j.setFillType(FillType.EVEN_ODD);
                this.f4676j.moveTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.lineTo(((float) (getWidth() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f), (float) (getHeight() / 2));
                this.f4676j.lineTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.lineTo(((float) (getWidth() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f4674h) * this.f4668b) / 2.0f));
                this.f4676j.close();
                this.f4675i.setAntiAlias(true);
                this.f4675i.setColor(-12303292);
                this.f4675i.setStrokeWidth(3.0f);
                this.f4675i.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 7:
                m4566b(canvas);
                float f17 = this.f4672f;
                this.f4669c = f17 / 3.0f;
                this.f4670d = f17 / 3.0f;
                this.f4675i.setStyle(Style.FILL);
                Path path3 = this.f4676j;
                float f18 = this.f4671e;
                path3.moveTo(this.f4669c + f18, f18);
                Path path4 = this.f4676j;
                float f19 = this.f4671e;
                path4.lineTo(f19 - this.f4669c, f19 - this.f4670d);
                Path path5 = this.f4676j;
                float f20 = this.f4671e;
                path5.lineTo(f20 - this.f4669c, f20 + this.f4670d);
                Path path6 = this.f4676j;
                float f21 = this.f4671e;
                path6.lineTo(this.f4669c + f21, f21);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 8:
                m4566b(canvas);
                float f22 = this.f4672f;
                this.f4669c = f22 / 4.0f;
                this.f4670d = f22 / 3.0f;
                float f23 = this.f4671e;
                float f24 = this.f4669c;
                float f25 = f23 - f24;
                float f26 = this.f4670d;
                canvas.drawLine(f25, f23 - f26, f23 - f24, f23 + f26, this.f4675i);
                float f27 = this.f4671e;
                float f28 = this.f4669c;
                float f29 = f27 + f28;
                float f30 = this.f4670d;
                canvas.drawLine(f29, f27 - f30, f27 + f28, f27 + f30, this.f4675i);
                return;
            case 9:
                m4565a(canvas);
                float f31 = this.f4671e;
                float f32 = this.f4668b;
                float f33 = f31 - (f32 * 10.0f);
                float f34 = this.f4670d;
                RectF rectF = new RectF(f33, (f31 - f34) - (f32 * 2.0f), (14.0f * f32) + f31, f31 + f34 + (f32 * 2.0f));
                float f35 = this.f4671e;
                float f36 = this.f4668b;
                float f37 = f35 - (10.0f * f36);
                float f38 = this.f4670d;
                RectF rectF2 = new RectF(f37, (f35 - f38) - (f36 * 4.0f), (18.0f * f36) + f35, f35 + f38 + (f36 * 4.0f));
                this.f4675i.setColor(-1);
                this.f4675i.setStrokeWidth(4.0f);
                this.f4675i.setStyle(Style.STROKE);
                Canvas canvas6 = canvas;
                canvas6.drawArc(rectF, -45.0f, 90.0f, false, this.f4675i);
                canvas6.drawArc(rectF2, -45.0f, 90.0f, false, this.f4675i);
                canvas2.drawPath(this.f4676j, this.f4675i);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 11:
                m4565a(canvas);
                this.f4675i.setColor(-1);
                this.f4675i.setStrokeWidth(4.0f);
                this.f4675i.setStyle(Style.STROKE);
                Path path7 = this.f4676j;
                float f39 = this.f4671e;
                path7.moveTo((this.f4668b * 10.0f) + f39, f39 - this.f4670d);
                Path path8 = this.f4676j;
                float f40 = this.f4671e;
                path8.lineTo((this.f4668b * 18.0f) + f40, f40 + this.f4670d);
                Path path9 = this.f4676j;
                float f41 = this.f4671e;
                path9.moveTo((this.f4668b * 18.0f) + f41, f41 - this.f4670d);
                Path path10 = this.f4676j;
                float f42 = this.f4671e;
                path10.lineTo((this.f4668b * 10.0f) + f42, f42 + this.f4670d);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
            case 12:
                float f43 = this.f4668b;
                this.f4671e = (50.0f * f43) / 2.0f;
                this.f4669c = f43 * 3.0f;
                this.f4670d = f43 * 3.0f;
                this.f4675i.setStyle(Style.STROKE);
                this.f4675i.setStrokeWidth(4.0f);
                this.f4675i.setColor(-1);
                Path path11 = this.f4676j;
                float f44 = this.f4671e;
                path11.moveTo(f44 - this.f4669c, (f44 - this.f4670d) - (this.f4668b * 5.0f));
                Path path12 = this.f4676j;
                float f45 = this.f4671e;
                path12.lineTo(f45 - this.f4669c, f45 - this.f4670d);
                Path path13 = this.f4676j;
                float f46 = this.f4671e;
                path13.lineTo((f46 - this.f4669c) - (this.f4668b * 5.0f), f46 - this.f4670d);
                Path path14 = this.f4676j;
                float f47 = this.f4671e;
                path14.moveTo(this.f4669c + f47, (f47 - this.f4670d) - (this.f4668b * 5.0f));
                Path path15 = this.f4676j;
                float f48 = this.f4671e;
                path15.lineTo(this.f4669c + f48, f48 - this.f4670d);
                Path path16 = this.f4676j;
                float f49 = this.f4671e;
                path16.lineTo(this.f4669c + f49 + (this.f4668b * 5.0f), f49 - this.f4670d);
                Path path17 = this.f4676j;
                float f50 = this.f4671e;
                path17.moveTo(f50 - this.f4669c, f50 + this.f4670d + (this.f4668b * 5.0f));
                Path path18 = this.f4676j;
                float f51 = this.f4671e;
                path18.lineTo(f51 - this.f4669c, f51 + this.f4670d);
                Path path19 = this.f4676j;
                float f52 = this.f4671e;
                path19.lineTo((f52 - this.f4669c) - (this.f4668b * 5.0f), f52 + this.f4670d);
                Path path20 = this.f4676j;
                float f53 = this.f4671e;
                path20.moveTo(this.f4669c + f53, f53 + this.f4670d + (this.f4668b * 5.0f));
                Path path21 = this.f4676j;
                float f54 = this.f4671e;
                path21.lineTo(this.f4669c + f54, f54 + this.f4670d);
                Path path22 = this.f4676j;
                float f55 = this.f4671e;
                path22.lineTo(this.f4669c + f55 + (this.f4668b * 5.0f), f55 + this.f4670d);
                canvas2.drawPath(this.f4676j, this.f4675i);
                return;
        }
    }

    /* renamed from: a */
    private void m4565a(Canvas canvas) {
        float f = this.f4668b;
        this.f4671e = ((30.0f * f) / 2.0f) - (f * 5.0f);
        this.f4669c = f * 5.0f;
        this.f4670d = f * 5.0f;
        this.f4675i.setStyle(Style.FILL);
        this.f4675i.setColor(-1);
        this.f4675i.setStrokeWidth(4.0f);
        this.f4675i.setAntiAlias(true);
        Path path = this.f4676j;
        float f2 = this.f4671e;
        path.moveTo(f2 - this.f4669c, f2 - this.f4670d);
        Path path2 = this.f4676j;
        float f3 = this.f4671e;
        path2.lineTo(f3, f3 - this.f4670d);
        Path path3 = this.f4676j;
        float f4 = this.f4671e;
        float f5 = this.f4668b;
        path3.lineTo((f5 * 6.0f) + f4, (f4 - this.f4670d) - (f5 * 4.0f));
        Path path4 = this.f4676j;
        float f6 = this.f4671e;
        float f7 = this.f4668b;
        path4.lineTo((6.0f * f7) + f6, f6 + this.f4670d + (f7 * 4.0f));
        Path path5 = this.f4676j;
        float f8 = this.f4671e;
        path5.lineTo(f8, this.f4670d + f8);
        Path path6 = this.f4676j;
        float f9 = this.f4671e;
        path6.lineTo(f9 - this.f4669c, f9 + this.f4670d);
        Path path7 = this.f4676j;
        float f10 = this.f4671e;
        path7.lineTo(f10 - this.f4669c, f10 - this.f4670d);
        canvas.drawPath(this.f4676j, this.f4675i);
    }

    /* renamed from: b */
    private void m4566b(Canvas canvas) {
        float f = this.f4668b;
        this.f4672f = 25.0f * f;
        this.f4671e = f * 30.0f;
        this.f4675i.setAntiAlias(true);
        this.f4675i.setColor(-1);
        this.f4675i.setStrokeWidth(7.0f);
        this.f4675i.setStyle(Style.STROKE);
        float f2 = this.f4671e;
        canvas.drawCircle(f2, f2, this.f4672f, this.f4675i);
    }

    public void setSwitchInt(int i) {
        this.f4673g = i;
    }
}
