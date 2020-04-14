package com.inmobi.media;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.media.bn */
/* compiled from: NativeTimerView */
public class C2231bn extends View {

    /* renamed from: a */
    public long f4611a;

    /* renamed from: b */
    public long f4612b;

    /* renamed from: c */
    public ValueAnimator f4613c;

    /* renamed from: d */
    private Bitmap f4614d;

    /* renamed from: e */
    private Canvas f4615e;

    /* renamed from: f */
    private RectF f4616f;

    /* renamed from: g */
    private RectF f4617g;

    /* renamed from: h */
    private Rect f4618h;

    /* renamed from: i */
    private Paint f4619i;

    /* renamed from: j */
    private Paint f4620j;

    /* renamed from: k */
    private Paint f4621k;

    /* renamed from: l */
    private Paint f4622l;

    /* renamed from: m */
    private Paint f4623m;

    /* renamed from: n */
    private float f4624n;

    /* renamed from: o */
    private C2233b f4625o;

    /* renamed from: com.inmobi.media.bn$a */
    /* compiled from: NativeTimerView */
    public static class C2232a implements AnimatorUpdateListener {

        /* renamed from: a */
        public WeakReference<C2231bn> f4626a;

        public C2232a(C2231bn bnVar) {
            this.f4626a = new WeakReference<>(bnVar);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2231bn bnVar = (C2231bn) this.f4626a.get();
            if (bnVar != null) {
                int visibility = bnVar.getVisibility();
                if (visibility != 4 && visibility != 8) {
                    bnVar.mo27970a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                } else if (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) >= 1.0d) {
                    bnVar.m4548c();
                }
            }
        }
    }

    /* renamed from: com.inmobi.media.bn$b */
    /* compiled from: NativeTimerView */
    public interface C2233b {
        /* renamed from: a */
        void mo27978a();
    }

    public C2231bn(Context context) {
        this(context, 0);
    }

    private C2231bn(Context context, byte b) {
        this(context, 0);
    }

    private C2231bn(Context context, char c) {
        super(context, null, 0);
        this.f4611a = 0;
        this.f4619i = new Paint();
        this.f4619i.setAntiAlias(true);
        this.f4619i.setColor(-723724);
        this.f4623m = new Paint();
        this.f4623m.setAntiAlias(true);
        this.f4623m.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4623m.setTextAlign(Align.CENTER);
        this.f4623m.setAntiAlias(true);
        this.f4618h = new Rect();
        this.f4620j = new Paint();
        this.f4620j.setAntiAlias(true);
        this.f4620j.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4621k = new Paint();
        this.f4621k.setAntiAlias(true);
        this.f4621k.setColor(0);
        this.f4621k.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f4622l = new Paint();
        this.f4622l.setStyle(Style.STROKE);
        this.f4622l.setAntiAlias(true);
        this.f4622l.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void setTimerEventsListener(C2233b bVar) {
        this.f4625o = bVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == i3 && i2 == i4)) {
            this.f4614d = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.f4614d.eraseColor(0);
            this.f4615e = new Canvas(this.f4614d);
        }
        super.onSizeChanged(i, i2, i3, i4);
        float a = (float) C2528gq.m5392a((int) (((float) getWidth()) * 4.0f * 0.007f));
        float a2 = (float) C2528gq.m5392a((int) (((float) getWidth()) * 14.0f * 0.007f));
        float a3 = (float) C2528gq.m5392a((int) (((float) getWidth()) * 5.0f * 0.007f));
        float a4 = (float) C2528gq.m5392a((int) (((float) getWidth()) * 1.5f * 0.007f));
        this.f4616f = new RectF(a3, a3, ((float) getWidth()) - a3, ((float) getHeight()) - a3);
        this.f4617g = new RectF(this.f4616f.left + a, this.f4616f.top + a, this.f4616f.right - a, this.f4616f.bottom - a);
        this.f4622l.setStrokeWidth(a4);
        this.f4623m.setTextSize(a2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f4615e.drawColor(0, Mode.CLEAR);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(width, height);
        int a = C2528gq.m5392a((int) (((float) getWidth()) * 7.0f * 0.007f));
        float f = (float) width;
        float f2 = (float) height;
        canvas.drawCircle(f, f2, (float) min, this.f4619i);
        canvas.drawCircle(f, f2, (float) (min - a), this.f4622l);
        ValueAnimator valueAnimator = this.f4613c;
        if (valueAnimator != null) {
            int currentPlayTime = (int) (this.f4611a - (valueAnimator.getCurrentPlayTime() / 1000));
            if (((double) ((Float) this.f4613c.getAnimatedValue()).floatValue()) >= 1.0d) {
                currentPlayTime = 0;
            }
            Paint paint = this.f4623m;
            Rect rect = this.f4618h;
            String valueOf = String.valueOf(currentPlayTime);
            paint.getTextBounds(valueOf, 0, valueOf.length(), rect);
            canvas.drawText(valueOf, (float) (getWidth() / 2), ((float) (getHeight() / 2)) + (((paint.descent() - paint.ascent()) / 2.0f) - paint.descent()), paint);
            if (((double) ((Float) this.f4613c.getAnimatedValue()).floatValue()) >= 1.0d) {
                m4548c();
            }
        }
        float f3 = this.f4624n;
        if (f3 > 0.0f) {
            this.f4615e.drawArc(this.f4616f, 270.0f, f3, true, this.f4620j);
            this.f4615e.drawOval(this.f4617g, this.f4621k);
        }
        canvas.drawBitmap(this.f4614d, 0.0f, 0.0f, null);
    }

    public void setTimerValue(long j) {
        this.f4611a = j;
    }

    /* renamed from: a */
    public final void mo27969a() {
        this.f4613c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f4613c.setDuration(TimeUnit.SECONDS.toMillis(this.f4611a));
        this.f4613c.setInterpolator(new LinearInterpolator());
        this.f4613c.addUpdateListener(new C2232a(this));
        this.f4613c.start();
    }

    /* renamed from: b */
    public final void mo27971b() {
        ValueAnimator valueAnimator = this.f4613c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f4612b = this.f4613c.getCurrentPlayTime();
            this.f4613c.cancel();
        }
    }

    /* renamed from: a */
    public final void mo27970a(float f) {
        this.f4624n = f * 360.0f;
        invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4548c() {
        C2233b bVar = this.f4625o;
        if (bVar != null) {
            bVar.mo27978a();
            this.f4613c.cancel();
            this.f4613c = null;
        }
    }
}
