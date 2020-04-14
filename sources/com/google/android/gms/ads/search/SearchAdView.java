package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzxb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class SearchAdView extends ViewGroup {
    private final zzxb zzabz;

    public SearchAdView(Context context) {
        super(context);
        this.zzabz = new zzxb(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzabz = new zzxb(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzabz = new zzxb(this, attributeSet, false);
    }

    public final void destroy() {
        this.zzabz.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzabz.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzabz.getAdSize();
    }

    public final String getAdUnitId() {
        return this.zzabz.getAdUnitId();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(SearchAdRequest searchAdRequest) {
        this.zzabz.zza(searchAdRequest.zzdb());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.zzabz.zza(dynamicHeightSearchAdRequest.zzdb());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public final void pause() {
        this.zzabz.pause();
    }

    public final void resume() {
        this.zzabz.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzabz.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.zzabz.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.zzabz.setAdUnitId(str);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    public final void onMeasure(int i, int i2) {
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
