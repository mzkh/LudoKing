package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzalo extends zzakp {
    private final UnifiedNativeAdMapper zzdep;

    public zzalo(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdep = unifiedNativeAdMapper;
    }

    public final zzaba zzqo() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdep.getHeadline();
    }

    public final List getImages() {
        List<Image> images = this.zzdep.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (Image image : images) {
                zzaau zzaau = new zzaau(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight());
                arrayList.add(zzaau);
            }
        }
        return arrayList;
    }

    public final String getBody() {
        return this.zzdep.getBody();
    }

    public final zzabi zzqn() {
        Image icon = this.zzdep.getIcon();
        if (icon == null) {
            return null;
        }
        zzaau zzaau = new zzaau(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        return zzaau;
    }

    public final String getCallToAction() {
        return this.zzdep.getCallToAction();
    }

    public final String getAdvertiser() {
        return this.zzdep.getAdvertiser();
    }

    public final double getStarRating() {
        if (this.zzdep.getStarRating() != null) {
            return this.zzdep.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.zzdep.getStore();
    }

    public final String getPrice() {
        return this.zzdep.getPrice();
    }

    public final zzwr getVideoController() {
        if (this.zzdep.getVideoController() != null) {
            return this.zzdep.getVideoController().zzde();
        }
        return null;
    }

    public final IObjectWrapper zzry() {
        View adChoicesContent = this.zzdep.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzrz() {
        View zzaba = this.zzdep.zzaba();
        if (zzaba == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaba);
    }

    public final float getMediaContentAspectRatio() {
        return this.zzdep.getMediaContentAspectRatio();
    }

    public final IObjectWrapper zzqp() {
        Object zzji = this.zzdep.zzji();
        if (zzji == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzji);
    }

    public final Bundle getExtras() {
        return this.zzdep.getExtras();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdep.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdep.getOverrideClickHandling();
    }

    public final void recordImpression() {
        this.zzdep.recordImpression();
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
        this.zzdep.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdep.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzdep.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
