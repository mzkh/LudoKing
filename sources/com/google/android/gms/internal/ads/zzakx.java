package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzakx extends zzakc {
    private final zzaqp zzddx;
    private final Adapter zzdeg;

    zzakx(Adapter adapter, zzaqp zzaqp) {
        this.zzdeg = adapter;
        this.zzddx = zzaqp;
    }

    public final void onAdImpression() throws RemoteException {
    }

    public final void onAdLeftApplication() throws RemoteException {
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    public final void onVideoEnd() throws RemoteException {
    }

    public final void onVideoPause() throws RemoteException {
    }

    public final void onVideoPlay() throws RemoteException {
    }

    public final void zza(zzace zzace, String str) throws RemoteException {
    }

    public final void zza(zzake zzake) throws RemoteException {
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public final void zzb(zzaqt zzaqt) throws RemoteException {
    }

    public final void zzcl(int i) throws RemoteException {
    }

    public final void zzde(String str) throws RemoteException {
    }

    public final void onAdLoaded() throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zzaj(ObjectWrapper.wrap(this.zzdeg));
        }
    }

    public final void onAdOpened() throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zzak(ObjectWrapper.wrap(this.zzdeg));
        }
    }

    public final void onAdClosed() throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zzam(ObjectWrapper.wrap(this.zzdeg));
        }
    }

    public final void zza(zzaqv zzaqv) throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zza(ObjectWrapper.wrap(this.zzdeg), new zzaqt(zzaqv.getType(), zzaqv.getAmount()));
        }
    }

    public final void zzrw() throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zzal(ObjectWrapper.wrap(this.zzdeg));
        }
    }

    public final void zzrx() throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zzap(ObjectWrapper.wrap(this.zzdeg));
        }
    }

    public final void onAdClicked() throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zzan(ObjectWrapper.wrap(this.zzdeg));
        }
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzaqp zzaqp = this.zzddx;
        if (zzaqp != null) {
            zzaqp.zze(ObjectWrapper.wrap(this.zzdeg), i);
        }
    }
}
