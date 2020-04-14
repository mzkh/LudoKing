package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzakw extends zzakj {
    private final NativeAppInstallAdMapper zzdef;

    public zzakw(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdef = nativeAppInstallAdMapper;
    }

    public final zzaba zzqo() {
        return null;
    }

    public final IObjectWrapper zzqp() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdef.getHeadline();
    }

    public final List getImages() {
        List<Image> images = this.zzdef.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Image image : images) {
            zzaau zzaau = new zzaau(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight());
            arrayList.add(zzaau);
        }
        return arrayList;
    }

    public final String getBody() {
        return this.zzdef.getBody();
    }

    public final zzabi zzqn() {
        Image icon = this.zzdef.getIcon();
        if (icon == null) {
            return null;
        }
        zzaau zzaau = new zzaau(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        return zzaau;
    }

    public final String getCallToAction() {
        return this.zzdef.getCallToAction();
    }

    public final double getStarRating() {
        return this.zzdef.getStarRating();
    }

    public final String getStore() {
        return this.zzdef.getStore();
    }

    public final String getPrice() {
        return this.zzdef.getPrice();
    }

    public final void recordImpression() {
        this.zzdef.recordImpression();
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
        this.zzdef.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zzdef.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdef.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzdef.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdef.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdef.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.zzdef.getExtras();
    }

    public final zzwr getVideoController() {
        if (this.zzdef.getVideoController() != null) {
            return this.zzdef.getVideoController().zzde();
        }
        return null;
    }

    public final IObjectWrapper zzry() {
        View adChoicesContent = this.zzdef.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzrz() {
        View zzaba = this.zzdef.zzaba();
        if (zzaba == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaba);
    }
}
