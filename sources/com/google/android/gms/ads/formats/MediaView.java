package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzaaz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class MediaView extends FrameLayout {
    private MediaContent zzbjo;
    private boolean zzbjp;
    private zzaax zzbjq;
    private ScaleType zzbjr;
    private boolean zzbjs;
    private zzaaz zzbjt;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbjp = true;
        this.zzbjo = mediaContent;
        zzaax zzaax = this.zzbjq;
        if (zzaax != null) {
            zzaax.setMediaContent(mediaContent);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzaax zzaax) {
        this.zzbjq = zzaax;
        if (this.zzbjp) {
            zzaax.setMediaContent(this.zzbjo);
        }
    }

    public void setImageScaleType(ScaleType scaleType) {
        this.zzbjs = true;
        this.zzbjr = scaleType;
        zzaaz zzaaz = this.zzbjt;
        if (zzaaz != null) {
            zzaaz.setImageScaleType(this.zzbjr);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzaaz zzaaz) {
        this.zzbjt = zzaaz;
        if (this.zzbjs) {
            zzaaz.setImageScaleType(this.zzbjr);
        }
    }
}
