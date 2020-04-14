package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.inmobi.media.dz */
/* compiled from: NativeContainerLayout */
public class C2359dz extends ViewGroup {

    /* renamed from: a */
    private static final String f5006a = "dz";

    /* renamed from: com.inmobi.media.dz$a */
    /* compiled from: NativeContainerLayout */
    public static class C2360a extends LayoutParams {

        /* renamed from: a */
        public int f5007a;

        /* renamed from: b */
        public int f5008b;

        public C2360a(int i, int i2) {
            super(i, i2);
        }

        public C2360a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public C2359dz(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C2360a aVar = (C2360a) childAt.getLayoutParams();
                int measuredWidth = aVar.f5007a + childAt.getMeasuredWidth();
                int measuredHeight = aVar.f5008b + childAt.getMeasuredHeight();
                i4 = Math.max(i4, measuredWidth);
                i3 = Math.max(i3, measuredHeight);
            }
        }
        setMeasuredDimension(resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new C2360a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C2360a aVar = (C2360a) childAt.getLayoutParams();
                childAt.layout(aVar.f5007a, aVar.f5008b, aVar.f5007a + childAt.getMeasuredWidth(), aVar.f5008b + childAt.getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C2360a;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C2360a(layoutParams);
    }
}
