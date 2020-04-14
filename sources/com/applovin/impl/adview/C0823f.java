package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinMediationProvider;

/* renamed from: com.applovin.impl.adview.f */
public class C0823f extends View {

    /* renamed from: s */
    private static final int f1429s = Color.rgb(66, 145, 241);

    /* renamed from: t */
    private static final int f1430t = Color.rgb(66, 145, 241);

    /* renamed from: u */
    private static final int f1431u = Color.rgb(66, 145, 241);

    /* renamed from: a */
    protected Paint f1432a;

    /* renamed from: b */
    protected Paint f1433b;

    /* renamed from: c */
    private Paint f1434c;

    /* renamed from: d */
    private Paint f1435d;

    /* renamed from: e */
    private RectF f1436e;

    /* renamed from: f */
    private float f1437f;

    /* renamed from: g */
    private int f1438g;

    /* renamed from: h */
    private int f1439h;

    /* renamed from: i */
    private int f1440i;

    /* renamed from: j */
    private int f1441j;

    /* renamed from: k */
    private int f1442k;

    /* renamed from: l */
    private float f1443l;

    /* renamed from: m */
    private int f1444m;

    /* renamed from: n */
    private String f1445n;

    /* renamed from: o */
    private String f1446o;

    /* renamed from: p */
    private float f1447p;

    /* renamed from: q */
    private String f1448q;

    /* renamed from: r */
    private float f1449r;

    /* renamed from: v */
    private final float f1450v;

    /* renamed from: w */
    private final float f1451w;

    /* renamed from: x */
    private final float f1452x;

    /* renamed from: y */
    private final int f1453y;

    /* renamed from: com.applovin.impl.adview.f$a */
    private static class C0824a {
        /* access modifiers changed from: private */
        /* renamed from: c */
        public static float m1170c(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public static float m1171d(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public C0823f(Context context) {
        this(context, null);
    }

    public C0823f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0823f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1436e = new RectF();
        this.f1440i = 0;
        String str = "";
        this.f1445n = str;
        this.f1446o = str;
        this.f1448q = str;
        this.f1451w = C0824a.m1171d(getResources(), 14.0f);
        this.f1453y = (int) C0824a.m1170c(getResources(), 100.0f);
        this.f1450v = C0824a.m1170c(getResources(), 4.0f);
        this.f1452x = C0824a.m1171d(getResources(), 18.0f);
        mo9046b();
        mo9045a();
    }

    /* renamed from: a */
    private int m1165a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f1453y;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private float getProgressAngle() {
        return (((float) getProgress()) / ((float) this.f1441j)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9045a() {
        this.f1432a = new TextPaint();
        this.f1432a.setColor(this.f1438g);
        this.f1432a.setTextSize(this.f1437f);
        this.f1432a.setAntiAlias(true);
        this.f1433b = new TextPaint();
        this.f1433b.setColor(this.f1439h);
        this.f1433b.setTextSize(this.f1447p);
        this.f1433b.setAntiAlias(true);
        this.f1434c = new Paint();
        this.f1434c.setColor(this.f1442k);
        this.f1434c.setStyle(Style.STROKE);
        this.f1434c.setAntiAlias(true);
        this.f1434c.setStrokeWidth(this.f1443l);
        this.f1435d = new Paint();
        this.f1435d.setColor(this.f1444m);
        this.f1435d.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9046b() {
        this.f1442k = f1429s;
        this.f1438g = f1430t;
        this.f1437f = this.f1451w;
        setMax(100);
        setProgress(0);
        this.f1443l = this.f1450v;
        this.f1444m = 0;
        this.f1447p = this.f1452x;
        this.f1439h = f1431u;
    }

    public int getFinishedStrokeColor() {
        return this.f1442k;
    }

    public float getFinishedStrokeWidth() {
        return this.f1443l;
    }

    public int getInnerBackgroundColor() {
        return this.f1444m;
    }

    public String getInnerBottomText() {
        return this.f1448q;
    }

    public int getInnerBottomTextColor() {
        return this.f1439h;
    }

    public float getInnerBottomTextSize() {
        return this.f1447p;
    }

    public int getMax() {
        return this.f1441j;
    }

    public String getPrefixText() {
        return this.f1445n;
    }

    public int getProgress() {
        return this.f1440i;
    }

    public String getSuffixText() {
        return this.f1446o;
    }

    public int getTextColor() {
        return this.f1438g;
    }

    public float getTextSize() {
        return this.f1437f;
    }

    public void invalidate() {
        mo9045a();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f1443l;
        this.f1436e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        float width = (float) getWidth();
        float f2 = this.f1443l;
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((width - f2) + f2) / 2.0f, this.f1435d);
        canvas.drawArc(this.f1436e, 270.0f, -getProgressAngle(), false, this.f1434c);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1445n);
        sb.append(this.f1440i);
        sb.append(this.f1446o);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            canvas.drawText(sb2, (((float) getWidth()) - this.f1432a.measureText(sb2)) / 2.0f, (((float) getWidth()) - (this.f1432a.descent() + this.f1432a.ascent())) / 2.0f, this.f1432a);
        }
        if (!TextUtils.isEmpty(getInnerBottomText())) {
            this.f1433b.setTextSize(this.f1447p);
            canvas.drawText(getInnerBottomText(), (((float) getWidth()) - this.f1433b.measureText(getInnerBottomText())) / 2.0f, (((float) getHeight()) - this.f1449r) - ((this.f1432a.descent() + this.f1432a.ascent()) / 2.0f), this.f1433b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m1165a(i), m1165a(i2));
        this.f1449r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f1438g = bundle.getInt("text_color");
            this.f1437f = bundle.getFloat("text_size");
            this.f1447p = bundle.getFloat("inner_bottom_text_size");
            this.f1448q = bundle.getString("inner_bottom_text");
            this.f1439h = bundle.getInt("inner_bottom_text_color");
            this.f1442k = bundle.getInt("finished_stroke_color");
            this.f1443l = bundle.getFloat("finished_stroke_width");
            this.f1444m = bundle.getInt("inner_background_color");
            mo9045a();
            setMax(bundle.getInt(AppLovinMediationProvider.MAX));
            setProgress(bundle.getInt(NotificationCompat.CATEGORY_PROGRESS));
            this.f1445n = bundle.getString("prefix");
            this.f1446o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        String str = "inner_bottom_text_color";
        bundle.putFloat(str, (float) getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt(str, getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt(NotificationCompat.CATEGORY_PROGRESS, getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i) {
        this.f1442k = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.f1443l = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.f1444m = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f1448q = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.f1439h = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.f1447p = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f1441j = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f1445n = str;
        invalidate();
    }

    public void setProgress(int i) {
        this.f1440i = i;
        if (this.f1440i > getMax()) {
            this.f1440i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f1446o = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f1438g = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f1437f = f;
        invalidate();
    }
}
