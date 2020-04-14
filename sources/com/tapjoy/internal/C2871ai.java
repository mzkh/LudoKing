package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.view.MotionEvent;

/* renamed from: com.tapjoy.internal.ai */
public class C2871ai extends C2872aj {

    /* renamed from: a */
    private int f6666a = 0;

    /* renamed from: b */
    private final Matrix f6667b = new Matrix();

    /* renamed from: c */
    private final float[] f6668c = new float[2];

    public C2871ai(Context context) {
        super(context);
    }

    public int getRotationCount() {
        return this.f6666a;
    }

    public void setRotationCount(int i) {
        this.f6666a = i & 3;
    }

    public void onMeasure(int i, int i2) {
        if (this.f6666a % 2 == 0) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:4|5|6|7|8|(1:12)|13|14|15|(1:(1:(1:20)(2:21|22))(1:23))(1:24)|25|(1:(1:(1:29)(2:30|31))(1:32))(1:33)|34|35) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.f6666a
            if (r0 != 0) goto L_0x0008
            super.dispatchDraw(r9)
            return
        L_0x0008:
            r9.save()
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            r2 = 0
            r9.clipRect(r2, r2, r0, r1)
            android.view.ViewParent r3 = r8.getParent()     // Catch:{ Exception -> 0x004e }
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3     // Catch:{ Exception -> 0x004e }
            android.view.ViewParent r4 = r3.getParent()     // Catch:{ Exception -> 0x002c }
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ Exception -> 0x002c }
            boolean r5 = r4 instanceof android.widget.ScrollView     // Catch:{ Exception -> 0x002c }
            if (r5 != 0) goto L_0x002b
            boolean r5 = r4 instanceof android.widget.HorizontalScrollView     // Catch:{ Exception -> 0x002c }
            if (r5 == 0) goto L_0x002c
        L_0x002b:
            r3 = r4
        L_0x002c:
            int r4 = r8.getLeft()     // Catch:{ Exception -> 0x004e }
            int r5 = r3.getScrollX()     // Catch:{ Exception -> 0x004e }
            int r4 = r4 - r5
            int r5 = r8.getTop()     // Catch:{ Exception -> 0x004e }
            int r6 = r3.getScrollY()     // Catch:{ Exception -> 0x004e }
            int r5 = r5 - r6
            int r6 = 0 - r4
            int r2 = r2 - r5
            int r7 = r3.getWidth()     // Catch:{ Exception -> 0x004e }
            int r7 = r7 - r4
            int r3 = r3.getHeight()     // Catch:{ Exception -> 0x004e }
            int r3 = r3 - r5
            r9.clipRect(r6, r2, r7, r3)     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            int r2 = r8.f6666a
            int r2 = r2 * 90
            float r2 = (float) r2
            r9.rotate(r2)
            int r2 = r8.f6666a
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == r6) goto L_0x0076
            if (r2 == r4) goto L_0x006e
            if (r2 != r3) goto L_0x0068
            int r2 = -r1
            float r2 = (float) r2
            r9.translate(r2, r5)
            goto L_0x007b
        L_0x0068:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x006e:
            int r2 = -r0
            float r2 = (float) r2
            int r7 = -r1
            float r7 = (float) r7
            r9.translate(r2, r7)
            goto L_0x007b
        L_0x0076:
            int r2 = -r0
            float r2 = (float) r2
            r9.translate(r5, r2)
        L_0x007b:
            android.graphics.Matrix r2 = r8.f6667b
            int r7 = r8.f6666a
            int r7 = r7 * -90
            float r7 = (float) r7
            r2.setRotate(r7)
            int r2 = r8.f6666a
            if (r2 == r6) goto L_0x00a5
            if (r2 == r4) goto L_0x009b
            if (r2 != r3) goto L_0x0095
            android.graphics.Matrix r0 = r8.f6667b
            int r1 = r1 - r6
            float r1 = (float) r1
            r0.postTranslate(r1, r5)
            goto L_0x00ac
        L_0x0095:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x009b:
            android.graphics.Matrix r2 = r8.f6667b
            int r0 = r0 - r6
            float r0 = (float) r0
            int r1 = r1 - r6
            float r1 = (float) r1
            r2.postTranslate(r0, r1)
            goto L_0x00ac
        L_0x00a5:
            android.graphics.Matrix r1 = r8.f6667b
            int r0 = r0 - r6
            float r0 = (float) r0
            r1.postTranslate(r5, r0)
        L_0x00ac:
            super.dispatchDraw(r9)
            r9.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2871ai.dispatchDraw(android.graphics.Canvas):void");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f6666a == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float[] fArr = this.f6668c;
        fArr[0] = motionEvent.getX();
        fArr[1] = motionEvent.getY();
        this.f6667b.mapPoints(fArr);
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }
}
