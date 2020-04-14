package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaad implements CustomRenderedAd {
    private final zzaac zzcux;

    public zzaad(zzaac zzaac) {
        this.zzcux = zzaac;
    }

    public final String getBaseUrl() {
        try {
            return this.zzcux.zzqb();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final String getContent() {
        try {
            return this.zzcux.getContent();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void onAdRendered(View view) {
        try {
            this.zzcux.zzs(view != null ? ObjectWrapper.wrap(view) : null);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordClick() {
        try {
            this.zzcux.recordClick();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzcux.recordImpression();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
