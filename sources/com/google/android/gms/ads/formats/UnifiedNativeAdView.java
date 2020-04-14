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
import android.widget.ImageView.ScaleType;
import com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzabm;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbkb;
    private final zzabm zzbkc = zzjf();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbkb = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbkb = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbkb = zzd(context);
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbkb = zzd(context);
    }

    private final void zza(String str, View view) {
        try {
            this.zzbkc.zzc(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbkc.zzi(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
        if (mediaView != null) {
            mediaView.zza((zzaax) new zzd(this));
            mediaView.zza((zzaaz) new zze(this));
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzbkc.zze((IObjectWrapper) unifiedNativeAd.zzjd());
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View zzbk(String str) {
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

    public final View getHeadlineView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getCallToActionView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getIconView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getBodyView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getStoreView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    public final View getPriceView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getAdvertiserView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getImageView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final View getStarRatingView() {
        return zzbk(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final MediaView getMediaView() {
        View zzbk = zzbk(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (zzbk instanceof MediaView) {
            return (MediaView) zzbk;
        }
        if (zzbk != null) {
            zzaxi.zzdv("View is not an instance of MediaView");
        }
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbk = zzbk(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbk instanceof AdChoicesView) {
            return (AdChoicesView) zzbk;
        }
        return null;
    }

    public final void destroy() {
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
        Preconditions.checkNotNull(this.zzbkb, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzuv.zzok().zza(this.zzbkb.getContext(), (FrameLayout) this, this.zzbkb);
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbkb);
    }

    public final void removeView(View view) {
        if (this.zzbkb != view) {
            super.removeView(view);
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbkb);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbkb;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void onVisibilityChanged(View view, int i) {
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

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
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

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(ScaleType scaleType) {
        try {
            if (scaleType instanceof ScaleType) {
                this.zzbkc.zzk(ObjectWrapper.wrap(scaleType));
            }
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setMediaViewImageScaleType on delegate", e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzadk) {
                this.zzbkc.zza(((zzadk) mediaContent).zzqy());
            } else if (mediaContent == null) {
                this.zzbkc.zza(null);
            } else {
                zzaxi.zzdv("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setMediaContent on delegate", e);
        }
    }
}
