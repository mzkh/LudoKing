package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadk implements MediaContent {
    private final zzabh zzcwp;

    public zzadk(zzabh zzabh) {
        this.zzcwp = zzabh;
    }

    public final float getAspectRatio() {
        try {
            return this.zzcwp.getAspectRatio();
        } catch (RemoteException unused) {
            return 0.0f;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zzcwp.zzt(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzql = this.zzcwp.zzql();
            if (zzql != null) {
                return (Drawable) ObjectWrapper.unwrap(zzql);
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return null;
    }

    public final zzabh zzqy() {
        return this.zzcwp;
    }
}
