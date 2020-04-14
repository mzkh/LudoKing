package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.impl.sdk.utils.C1282p;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxAdView extends RelativeLayout {

    /* renamed from: a */
    private MaxAdViewImpl f3261a;

    /* renamed from: b */
    private View f3262b;

    /* renamed from: c */
    private int f3263c;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adUnitId");
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (attributeValue == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(attributeValue)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            m3156a(attributeValue, attributeIntValue, AppLovinSdk.getInstance(activity), activity);
        } else {
            throw new IllegalArgumentException("Max ad view context is not an activity");
        }
    }

    public MaxAdView(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Activity activity) {
        super(activity);
        m3156a(str, 49, appLovinSdk, activity);
    }

    /* renamed from: a */
    private void m3155a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int applyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i, applyDimension);
    }

    /* renamed from: a */
    private void m3156a(String str, int i, AppLovinSdk appLovinSdk, Activity activity) {
        if (!isInEditMode()) {
            this.f3262b = new View(activity);
            this.f3262b.setBackgroundColor(0);
            addView(this.f3262b);
            this.f3262b.setLayoutParams(new LayoutParams(-1, -1));
            this.f3263c = getVisibility();
            MaxAdViewImpl maxAdViewImpl = new MaxAdViewImpl(str, this, this.f3262b, C1281o.m3071a(appLovinSdk), activity);
            this.f3261a = maxAdViewImpl;
            setGravity(i);
            if (getBackground() instanceof ColorDrawable) {
                setBackgroundColor(((ColorDrawable) getBackground()).getColor());
            }
            super.setBackgroundColor(0);
            return;
        }
        m3155a(activity);
    }

    public void destroy() {
        this.f3261a.destroy();
    }

    public String getPlacement() {
        return this.f3261a.getPlacement();
    }

    public void loadAd() {
        this.f3261a.loadAd();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f3261a != null && C1282p.m3119a(this.f3263c, i)) {
            this.f3261a.onWindowVisibilityChanged(i);
        }
        this.f3263c = i;
    }

    public void setAlpha(float f) {
        View view = this.f3262b;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public void setBackgroundColor(int i) {
        MaxAdViewImpl maxAdViewImpl = this.f3261a;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i);
        }
        View view = this.f3262b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setExtraParameter(String str, String str2) {
        this.f3261a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.f3261a.setListener(maxAdViewAdListener);
    }

    public void setPlacement(String str) {
        this.f3261a.setPlacement(str);
    }

    public void startAutoRefresh() {
        this.f3261a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f3261a.stopAutoRefresh();
    }

    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f3261a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }
}
