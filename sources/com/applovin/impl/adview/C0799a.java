package com.applovin.impl.adview;

import android.app.Activity;
import android.graphics.PorterDuff.Mode;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.a */
public class C0799a extends RelativeLayout {

    /* renamed from: a */
    private final ProgressBar f1370a;

    public C0799a(Activity activity, int i, int i2) {
        LayoutParams layoutParams;
        super(activity);
        setClickable(false);
        this.f1370a = new ProgressBar(activity, null, i2);
        this.f1370a.setIndeterminate(true);
        this.f1370a.setClickable(false);
        if (i == -2 || i == -1) {
            layoutParams = new LayoutParams(i, i);
        } else {
            int dpToPx = AppLovinSdkUtils.dpToPx(activity, i);
            layoutParams = new LayoutParams(dpToPx, dpToPx);
        }
        layoutParams.addRule(13);
        this.f1370a.setLayoutParams(layoutParams);
        addView(this.f1370a);
    }

    /* renamed from: a */
    public void mo8994a() {
        setVisibility(0);
    }

    /* renamed from: b */
    public void mo8995b() {
        setVisibility(8);
    }

    public void setColor(int i) {
        this.f1370a.getIndeterminateDrawable().setColorFilter(i, Mode.SRC_IN);
    }
}
