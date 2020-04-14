package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.iq */
public final class C3192iq extends RelativeLayout implements OnClickListener {

    /* renamed from: a */
    private boolean f7615a;

    /* renamed from: b */
    private float f7616b = 1.0f;

    /* renamed from: c */
    private View f7617c;

    /* renamed from: d */
    private View f7618d;

    /* renamed from: e */
    private FrameLayout f7619e;

    /* renamed from: f */
    private ImageView f7620f;

    /* renamed from: g */
    private C3186in f7621g;

    /* renamed from: h */
    private C1845hu f7622h;

    /* renamed from: i */
    private C3193a f7623i;

    /* renamed from: com.tapjoy.internal.iq$a */
    public interface C3193a {
        /* renamed from: a */
        void mo30213a();

        /* renamed from: a */
        void mo30214a(C3153hs hsVar);

        /* renamed from: b */
        void mo30215b();
    }

    public C3192iq(Context context, C1845hu huVar, C3193a aVar) {
        super(context);
        this.f7622h = huVar;
        this.f7623i = aVar;
        Context context2 = getContext();
        this.f7617c = new View(context2);
        boolean z = true;
        this.f7617c.setId(1);
        LayoutParams layoutParams = new LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.f7617c, layoutParams);
        this.f7618d = new View(context2);
        LayoutParams layoutParams2 = new LayoutParams(0, 0);
        layoutParams2.addRule(13);
        addView(this.f7618d, layoutParams2);
        this.f7619e = new FrameLayout(context2);
        LayoutParams layoutParams3 = new LayoutParams(0, 0);
        layoutParams3.addRule(13);
        addView(this.f7619e, layoutParams3);
        this.f7620f = new ImageView(context2);
        this.f7620f.setOnClickListener(this);
        LayoutParams layoutParams4 = new LayoutParams(0, 0);
        layoutParams4.addRule(7, this.f7617c.getId());
        layoutParams4.addRule(6, this.f7617c.getId());
        addView(this.f7620f, layoutParams4);
        if (this.f7622h.f3878m != null) {
            C3159hv hvVar = this.f7622h.f3878m;
            if (hvVar.f7492a == null || (hvVar.f7493b == null && hvVar.f7494c == null)) {
                z = false;
            }
            if (z) {
                this.f7621g = new C3186in(context2);
                this.f7621g.setOnClickListener(this);
                LayoutParams layoutParams5 = new LayoutParams(0, 0);
                layoutParams5.addRule(5, this.f7618d.getId());
                layoutParams5.addRule(8, this.f7618d.getId());
                addView(this.f7621g, layoutParams5);
            }
        }
        this.f7620f.setImageBitmap(huVar.f3868c.f7501b);
        if (this.f7621g != null && huVar.f3878m != null && huVar.f3878m.f7492a != null) {
            this.f7621g.setImageBitmap(huVar.f3878m.f7492a.f7501b);
        }
    }

    public final void setLandscape(boolean z) {
        Bitmap bitmap;
        ArrayList arrayList;
        Bitmap bitmap2;
        this.f7615a = z;
        if (z) {
            bitmap = this.f7622h.f3867b.f7501b;
            bitmap2 = this.f7622h.f3871f.f7501b;
            arrayList = this.f7622h.f3875j;
        } else {
            bitmap = this.f7622h.f3866a.f7501b;
            bitmap2 = this.f7622h.f3870e.f7501b;
            arrayList = this.f7622h.f3874i;
        }
        C2860ab.m6562a(this.f7617c, new BitmapDrawable(null, bitmap));
        C2860ab.m6562a(this.f7618d, new BitmapDrawable(null, bitmap2));
        if (this.f7619e.getChildCount() > 0) {
            this.f7619e.removeAllViews();
        }
        Context context = getContext();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3153hs hsVar = (C3153hs) it.next();
            View view = new View(context);
            view.setTag(hsVar);
            view.setOnClickListener(this);
            this.f7619e.addView(view, new FrameLayout.LayoutParams(0, 0, 51));
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        Point point;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f7615a) {
            this.f7616b = Math.min(((float) size) / 480.0f, ((float) size2) / 320.0f);
        } else {
            this.f7616b = Math.min(((float) size) / 320.0f, ((float) size2) / 480.0f);
        }
        LayoutParams layoutParams = (LayoutParams) this.f7617c.getLayoutParams();
        int i4 = 480;
        layoutParams.width = m7360a(this.f7615a ? 480 : 320);
        if (this.f7615a) {
            i4 = 320;
        }
        layoutParams.height = m7360a(i4);
        LayoutParams layoutParams2 = (LayoutParams) this.f7618d.getLayoutParams();
        int i5 = 448;
        layoutParams2.width = m7360a(this.f7615a ? 448 : 290);
        if (this.f7615a) {
            i5 = 290;
        }
        layoutParams2.height = m7360a(i5);
        LayoutParams layoutParams3 = (LayoutParams) this.f7619e.getLayoutParams();
        layoutParams3.width = layoutParams2.width;
        layoutParams3.height = layoutParams2.height;
        for (View view : C2861ac.m6563a(this.f7619e)) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view.getLayoutParams();
            Rect rect = ((C3153hs) view.getTag()).f7472a;
            layoutParams4.width = m7360a(rect.width());
            layoutParams4.height = m7360a(rect.height());
            layoutParams4.leftMargin = m7360a(rect.left);
            layoutParams4.topMargin = m7360a(rect.top);
        }
        int i6 = 0;
        int a = m7360a(0);
        this.f7620f.setPadding(a, a, a, a);
        LayoutParams layoutParams5 = (LayoutParams) this.f7620f.getLayoutParams();
        layoutParams5.width = m7360a(30);
        layoutParams5.height = layoutParams5.width;
        int i7 = -a;
        layoutParams5.rightMargin = m7360a(this.f7622h.f3869d.x) + i7;
        layoutParams5.topMargin = i7 + m7360a(this.f7622h.f3869d.y);
        if (this.f7621g != null) {
            int i8 = 16;
            int a2 = m7360a(this.f7615a ? 16 : 15);
            if (this.f7615a) {
                i8 = 15;
            }
            int a3 = m7360a(i8);
            this.f7621g.setPadding(a, a, a, a);
            LayoutParams layoutParams6 = (LayoutParams) this.f7621g.getLayoutParams();
            layoutParams6.width = m7360a(26);
            layoutParams6.height = layoutParams6.width;
            if (this.f7622h.f3878m != null) {
                if (this.f7615a) {
                    C3159hv hvVar = this.f7622h.f3878m;
                    if (hvVar.f7493b == null) {
                        point = hvVar.f7494c;
                    } else {
                        point = hvVar.f7493b;
                    }
                } else {
                    C3159hv hvVar2 = this.f7622h.f3878m;
                    if (hvVar2.f7494c == null) {
                        point = hvVar2.f7493b;
                    } else {
                        point = hvVar2.f7494c;
                    }
                }
                if (point != null) {
                    i6 = point.x;
                    i3 = point.y;
                    layoutParams6.leftMargin = a2 + m7360a(i6);
                    layoutParams6.topMargin = a3 + m7360a(i3);
                }
            }
            i3 = 0;
            layoutParams6.leftMargin = a2 + m7360a(i6);
            layoutParams6.topMargin = a3 + m7360a(i3);
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private int m7360a(int i) {
        return (int) (((float) i) * this.f7616b);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void onClick(View view) {
        if (view == this.f7620f) {
            this.f7623i.mo30213a();
            return;
        }
        if (view != null) {
            C3186in inVar = this.f7621g;
            if (view == inVar) {
                inVar.f7588a = !inVar.f7588a;
                inVar.mo30258a();
                inVar.invalidate();
                this.f7623i.mo30215b();
                return;
            }
        }
        if (view.getTag() instanceof C3153hs) {
            this.f7623i.mo30214a((C3153hs) view.getTag());
        }
    }
}
