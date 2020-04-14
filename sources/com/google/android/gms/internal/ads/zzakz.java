package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzakz extends zzakk {
    private final NativeContentAdMapper zzdek;

    public zzakz(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdek = nativeContentAdMapper;
    }

    public final zzaba zzqo() {
        return null;
    }

    public final IObjectWrapper zzqp() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdek.getHeadline();
    }

    public final List getImages() {
        List<Image> images = this.zzdek.getImages();
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
        return this.zzdek.getBody();
    }

    public final zzabi zzqq() {
        Image logo = this.zzdek.getLogo();
        if (logo == null) {
            return null;
        }
        zzaau zzaau = new zzaau(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        return zzaau;
    }

    public final String getCallToAction() {
        return this.zzdek.getCallToAction();
    }

    public final String getAdvertiser() {
        return this.zzdek.getAdvertiser();
    }

    public final void recordImpression() {
        this.zzdek.recordImpression();
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
        this.zzdek.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zzdek.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdek.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzdek.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdek.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdek.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.zzdek.getExtras();
    }

    public final IObjectWrapper zzry() {
        View adChoicesContent = this.zzdek.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final zzwr getVideoController() {
        if (this.zzdek.getVideoController() != null) {
            return this.zzdek.getVideoController().zzde();
        }
        return null;
    }

    public final IObjectWrapper zzrz() {
        View zzaba = this.zzdek.zzaba();
        if (zzaba == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaba);
    }
}
