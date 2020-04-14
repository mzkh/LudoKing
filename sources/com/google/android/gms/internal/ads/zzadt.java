package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadt extends zzacx {
    /* access modifiers changed from: private */
    public final OnPublisherAdViewLoadedListener zzcwz;

    public zzadt(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzcwz = onPublisherAdViewLoadedListener;
    }

    public final void zza(zzvl zzvl, IObjectWrapper iObjectWrapper) {
        String str = "";
        if (zzvl != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzvl.zzjw() instanceof zztt) {
                    zztt zztt = (zztt) zzvl.zzjw();
                    publisherAdView.setAdListener(zztt != null ? zztt.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzaxi.zzc(str, e);
            }
            try {
                if (zzvl.zzjv() instanceof zzuc) {
                    zzuc zzuc = (zzuc) zzvl.zzjv();
                    if (zzuc != null) {
                        appEventListener = zzuc.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzaxi.zzc(str, e2);
            }
            zzawy.zzzb.post(new zzads(this, publisherAdView, zzvl));
        }
    }
}
