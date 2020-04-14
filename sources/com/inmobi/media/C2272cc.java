package com.inmobi.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;

/* renamed from: com.inmobi.media.cc */
/* compiled from: MraidResizeProcessor */
public final class C2272cc {

    /* renamed from: d */
    private static final String f4762d = "cc";

    /* renamed from: a */
    public C2600j f4763a;

    /* renamed from: b */
    public ViewGroup f4764b;

    /* renamed from: c */
    public int f4765c;

    public C2272cc(C2600j jVar) {
        this.f4763a = jVar;
    }

    /* renamed from: a */
    public final void mo28104a() {
        if (this.f4764b == null) {
            this.f4764b = (ViewGroup) this.f4763a.getParent();
            this.f4765c = this.f4764b.indexOfChild(this.f4763a);
        }
        C2275ce resizeProperties = this.f4763a.getResizeProperties();
        m4609b();
        m4608a(resizeProperties);
    }

    /* renamed from: b */
    private void m4609b() {
        FrameLayout frameLayout = new FrameLayout(this.f4763a.getContainerContext());
        LayoutParams layoutParams = new LayoutParams(this.f4763a.getWidth(), this.f4763a.getHeight());
        frameLayout.setId(65535);
        this.f4764b.addView(frameLayout, this.f4765c, layoutParams);
        this.f4764b.removeView(this.f4763a);
    }

    /* renamed from: a */
    private void m4608a(C2275ce ceVar) {
        float f = C2528gq.m5393a().f5543c;
        int i = (int) ((((float) ceVar.f4774b) * f) + 0.5f);
        int i2 = (int) ((((float) ceVar.f4775c) * f) + 0.5f);
        FrameLayout frameLayout = (FrameLayout) this.f4764b.getRootView().findViewById(16908290);
        FrameLayout frameLayout2 = new FrameLayout(this.f4763a.getContainerContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f4763a.getContainerContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i2);
        frameLayout2.setId(65534);
        if (this.f4763a.getParent() != null) {
            ((ViewGroup) this.f4763a.getParent()).removeAllViews();
        }
        relativeLayout.addView(this.f4763a, layoutParams3);
        m4606a((ViewGroup) relativeLayout, ceVar.f4773a);
        frameLayout2.addView(relativeLayout, layoutParams2);
        frameLayout.addView(frameLayout2, layoutParams);
        m4607a(frameLayout, frameLayout2, ceVar);
        frameLayout2.setBackgroundColor(0);
    }

    /* renamed from: a */
    private void m4606a(ViewGroup viewGroup, String str) {
        float f = C2528gq.m5393a().f5543c;
        C2242bv bvVar = new C2242bv(this.f4763a.getContainerContext(), f, 1);
        bvVar.setId(65531);
        bvVar.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                C2272cc.this.f4763a.mo28360b();
            }
        });
        viewGroup.addView(bvVar, m4603a(str, f));
    }

    /* renamed from: a */
    private static RelativeLayout.LayoutParams m4603a(String str, float f) {
        String a = m4605a(str);
        int i = (int) (f * 50.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        String str2 = "bottom-right";
        if ("top-right".equals(a) || str2.equals(a)) {
            layoutParams.addRule(11);
        }
        boolean equals = str2.equals(a);
        String str3 = "bottom-center";
        if (equals || "bottom-left".equals(a) || str3.equals(a)) {
            layoutParams.addRule(12);
            layoutParams.addRule(4);
        }
        boolean equals2 = str3.equals(a);
        String str4 = "top-center";
        if (equals2 || str4.equals(a) || "center".equals(a)) {
            layoutParams.addRule(13);
        }
        if (str4.equals(a)) {
            layoutParams.addRule(10);
        }
        return layoutParams;
    }

    /* renamed from: a */
    private static String m4605a(String str) {
        String str2 = "top-right";
        if (str == null || str.length() == 0) {
            return str2;
        }
        return ("top-left".equals(str) || str2.equals(str) || "bottom-left".equals(str) || "bottom-right".equals(str) || "top-center".equals(str) || "bottom-center".equals(str) || "center".equals(str)) ? str : str2;
    }

    /* renamed from: a */
    private void m4607a(FrameLayout frameLayout, FrameLayout frameLayout2, C2275ce ceVar) {
        float f = C2528gq.m5393a().f5543c;
        int i = (int) ((((float) ceVar.f4774b) * f) + 0.5f);
        int i2 = (int) ((((float) ceVar.f4775c) * f) + 0.5f);
        int i3 = (int) ((((float) ceVar.f4776d) * f) + 0.5f);
        int i4 = (int) ((((float) ceVar.f4777e) * f) + 0.5f);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.f4764b.getLocationOnScreen(iArr);
        frameLayout.getLocationOnScreen(iArr2);
        iArr[1] = iArr[1] - iArr2[1];
        iArr[0] = iArr[0] - iArr2[0];
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (!ceVar.f4778f) {
            if (i > frameLayout.getWidth() - iArr[0]) {
                iArr[0] = frameLayout.getWidth() - i;
            }
            if (i2 > frameLayout.getHeight() - iArr[1]) {
                iArr[1] = frameLayout.getHeight() - i2;
            }
            if (iArr[0] < 0) {
                iArr[0] = 0;
            }
            if (iArr[1] < 0) {
                iArr[1] = 0;
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        layoutParams.gravity = GravityCompat.START;
        frameLayout2.setLayoutParams(layoutParams);
    }
}
