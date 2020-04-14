package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzabn extends Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzcvy;
    private final zzabi zzcwd;
    private final Drawable zzcwe;

    public zzabn(zzabi zzabi) {
        Drawable drawable;
        int i;
        String str = "";
        this.zzcwd = zzabi;
        Uri uri2 = null;
        try {
            IObjectWrapper zzqi = this.zzcwd.zzqi();
            if (zzqi != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzqi);
                this.zzcwe = drawable;
                uri2 = this.zzcwd.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzcwd.getScale();
                this.zzcvy = d;
                int i2 = -1;
                i = this.zzcwd.getWidth();
                this.width = i;
                i2 = this.zzcwd.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzaxi.zzc(str, e);
        }
        drawable = null;
        this.zzcwe = drawable;
        try {
            uri2 = this.zzcwd.getUri();
        } catch (RemoteException e2) {
            zzaxi.zzc(str, e2);
        }
        this.uri = uri2;
        double d2 = 1.0d;
        try {
            d2 = this.zzcwd.getScale();
        } catch (RemoteException e3) {
            zzaxi.zzc(str, e3);
        }
        this.zzcvy = d2;
        int i22 = -1;
        try {
            i = this.zzcwd.getWidth();
        } catch (RemoteException e4) {
            zzaxi.zzc(str, e4);
            i = -1;
        }
        this.width = i;
        try {
            i22 = this.zzcwd.getHeight();
        } catch (RemoteException e5) {
            zzaxi.zzc(str, e5);
        }
        this.height = i22;
    }

    public final Drawable getDrawable() {
        return this.zzcwe;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final double getScale() {
        return this.zzcvy;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
