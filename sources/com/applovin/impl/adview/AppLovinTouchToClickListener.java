package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1096c;

public class AppLovinTouchToClickListener implements OnTouchListener {

    /* renamed from: a */
    private final long f1360a;

    /* renamed from: b */
    private final int f1361b;

    /* renamed from: c */
    private long f1362c;

    /* renamed from: d */
    private PointF f1363d;

    /* renamed from: e */
    private final Context f1364e;

    /* renamed from: f */
    private final OnClickListener f1365f;

    public interface OnClickListener {
        void onClick(View view, PointF pointF);
    }

    public AppLovinTouchToClickListener(C1192i iVar, Context context, OnClickListener onClickListener) {
        this.f1360a = ((Long) iVar.mo10202a(C1096c.f2289aD)).longValue();
        this.f1361b = ((Integer) iVar.mo10202a(C1096c.f2290aE)).intValue();
        this.f1364e = context;
        this.f1365f = onClickListener;
    }

    /* renamed from: a */
    private float m1142a(float f) {
        return f / this.f1364e.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m1143a(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return m1142a((float) Math.sqrt((double) ((f * f) + (f2 * f2))));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f1362c = SystemClock.elapsedRealtime();
            this.f1363d = new PointF(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f1362c;
            float a = m1143a(this.f1363d, new PointF(motionEvent.getX(), motionEvent.getY()));
            long j = this.f1360a;
            if (j < 0 || elapsedRealtime < j) {
                int i = this.f1361b;
                if (i < 0 || a < ((float) i)) {
                    this.f1365f.onClick(view, new PointF(motionEvent.getRawX(), motionEvent.getRawY()));
                }
            }
        }
        return true;
    }
}
