package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbuh extends zzabg {
    private final zzbur zzfjl;
    private IObjectWrapper zzfkn;

    public zzbuh(zzbur zzbur) {
        this.zzfjl = zzbur;
    }

    public final float getAspectRatio() throws RemoteException {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzctg)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzfjl.getMediaContentAspectRatio() != 0.0f) {
            return this.zzfjl.getMediaContentAspectRatio();
        }
        if (this.zzfjl.getVideoController() != null) {
            return zzahj();
        }
        IObjectWrapper iObjectWrapper = this.zzfkn;
        if (iObjectWrapper != null) {
            return zzar(iObjectWrapper);
        }
        zzabi zzahr = this.zzfjl.zzahr();
        if (zzahr == null) {
            return 0.0f;
        }
        float width = (zzahr == null || zzahr.getWidth() == -1 || zzahr.getHeight() == -1) ? 0.0f : ((float) zzahr.getWidth()) / ((float) zzahr.getHeight());
        if (width != 0.0f) {
            return width;
        }
        return zzar(zzahr.zzqi());
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcoh)).booleanValue()) {
            this.zzfkn = iObjectWrapper;
        }
    }

    public final IObjectWrapper zzql() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzfkn;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzabi zzahr = this.zzfjl.zzahr();
        if (zzahr == null) {
            return null;
        }
        return zzahr.zzqi();
    }

    private final float zzahj() {
        try {
            return this.zzfjl.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzaug.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float zzar(IObjectWrapper iObjectWrapper) {
        float f = 0.0f;
        if (iObjectWrapper == null) {
            return 0.0f;
        }
        Drawable drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper);
        if (!(drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1)) {
            f = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        }
        return f;
    }
}
