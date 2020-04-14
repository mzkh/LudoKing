package com.google.ads.mediation.inmobi;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;

class InMobiNativeMappedImage extends Image {
    private final Drawable mInMobiDrawable;
    private final double mInMobiScale;
    private final Uri mInmobiImageUri;

    public InMobiNativeMappedImage(Drawable drawable, Uri uri, double d) {
        this.mInMobiDrawable = drawable;
        this.mInmobiImageUri = uri;
        this.mInMobiScale = d;
    }

    public Drawable getDrawable() {
        return this.mInMobiDrawable;
    }

    public Uri getUri() {
        return this.mInmobiImageUri;
    }

    public double getScale() {
        return this.mInMobiScale;
    }
}
