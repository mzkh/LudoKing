package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabt;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzuv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbke = new WeakHashMap<>();
    private zzabt zzbkd;
    private WeakReference<View> zzbkf;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzaxi.zzes("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbke.get(view) != null) {
            zzaxi.zzes("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbke.put(view, this);
            this.zzbkf = new WeakReference<>(view);
            this.zzbkd = zzuv.zzok().zza(view, zzb(map), zzb(map2));
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zze((IObjectWrapper) nativeAd.zzjd());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zze((IObjectWrapper) unifiedNativeAd.zzjd());
    }

    private final void zze(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbkf;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzaxi.zzeu("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbke.containsKey(view)) {
            zzbke.put(view, this);
        }
        zzabt zzabt = this.zzbkd;
        if (zzabt != null) {
            try {
                zzabt.zze(iObjectWrapper);
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzabt zzabt = this.zzbkd;
        if (zzabt != null) {
            try {
                zzabt.unregisterNativeAd();
            } catch (RemoteException e) {
                zzaxi.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzbkf;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zzbke.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbkd.zzi(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }
}
