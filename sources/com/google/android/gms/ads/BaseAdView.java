package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zztp;
import com.google.android.gms.internal.ads.zzxb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
class BaseAdView extends ViewGroup {
    protected final zzxb zzabf;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzabf = new zzxb(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzabf = new zzxb(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzabf = new zzxb(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzabf.destroy();
    }

    public AdListener getAdListener() {
        return this.zzabf.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzabf.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzabf.getAdUnitId();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzabf.zza(adRequest.zzdb());
    }

    public void pause() {
        this.zzabf.pause();
    }

    public void resume() {
        this.zzabf.resume();
    }

    public boolean isLoading() {
        return this.zzabf.isLoading();
    }

    public void setAdListener(AdListener adListener) {
        this.zzabf.setAdListener(adListener);
        if (adListener == null) {
            this.zzabf.zza((zztp) null);
            this.zzabf.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zztp) {
            this.zzabf.zza((zztp) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzabf.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzabf.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzabf.setAdUnitId(str);
    }

    public String getMediationAdapterClassName() {
        return this.zzabf.getMediationAdapterClassName();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzaxi.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
