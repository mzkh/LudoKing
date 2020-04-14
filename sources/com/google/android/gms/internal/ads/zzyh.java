package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyh extends zzadd {
    private final ShouldDelayBannerRenderingListener zzcfo;

    public zzyh(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzcfo = shouldDelayBannerRenderingListener;
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.zzcfo.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
