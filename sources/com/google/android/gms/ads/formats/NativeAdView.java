package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabm;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzbkb;
    private final zzabm zzbkc = zzjf();

    public NativeAdView(Context context) {
        super(context);
        this.zzbkb = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbkb = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbkb = zzd(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbkb = zzd(context);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View zzbk = zzbk(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbk instanceof AdChoicesView) {
            return (AdChoicesView) zzbk;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzbkc.zzc(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final View zzbk(String str) {
        try {
            IObjectWrapper zzcj = this.zzbkc.zzcj(str);
            if (zzcj != null) {
                return (View) ObjectWrapper.unwrap(zzcj);
            }
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzbkc.zze((IObjectWrapper) nativeAd.zzjd());
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public void destroy() {
        try {
            this.zzbkc.destroy();
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to destroy native ad view", e);
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzabm zzjf() {
        Preconditions.checkNotNull(this.zzbkb, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzuv.zzok().zza(this.zzbkb.getContext(), (FrameLayout) this, this.zzbkb);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbkb);
    }

    public void removeView(View view) {
        if (this.zzbkb != view) {
            super.removeView(view);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbkb);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbkb;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzabm zzabm = this.zzbkc;
        if (zzabm != null) {
            try {
                zzabm.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnp)).booleanValue()) {
            zzabm zzabm = this.zzbkc;
            if (zzabm != null) {
                try {
                    zzabm.zzj(ObjectWrapper.wrap(motionEvent));
                } catch (RemoteException e) {
                    zzaxi.zzc("Unable to call handleTouchEvent on delegate", e);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
