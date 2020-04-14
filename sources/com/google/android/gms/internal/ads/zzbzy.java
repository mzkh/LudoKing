package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbzy extends FrameLayout {
    private final zzavd zzdhs;

    public zzbzy(Context context, @NonNull View view, @NonNull zzavd zzavd) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        addView(view);
        this.zzdhs = zzavd;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zzdhs.zzd(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzbbw)) {
                arrayList.add((zzbbw) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzbbw) obj).destroy();
        }
    }
}
