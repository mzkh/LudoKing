package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchk extends zzakc implements zzbnz {
    @GuardedBy("this")
    private zzakd zzdfb;
    @GuardedBy("this")
    private zzboc zzfye;

    public final synchronized void zza(zzakd zzakd) {
        this.zzdfb = zzakd;
    }

    public final synchronized void zza(zzboc zzboc) {
        this.zzfye = zzboc;
    }

    public final synchronized void onAdClicked() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdFailedToLoad(i);
        }
        if (this.zzfye != null) {
            this.zzfye.onAdFailedToLoad(i);
        }
    }

    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdLeftApplication();
        }
    }

    public final synchronized void onAdOpened() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdOpened();
        }
    }

    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdLoaded();
        }
        if (this.zzfye != null) {
            this.zzfye.onAdLoaded();
        }
    }

    public final synchronized void zza(zzake zzake) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zza(zzake);
        }
    }

    public final synchronized void onAdImpression() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAdImpression();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onAppEvent(str, str2);
        }
    }

    public final synchronized void zza(zzace zzace, String str) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zza(zzace, str);
        }
    }

    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onVideoEnd();
        }
    }

    public final synchronized void zzde(String str) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zzde(str);
        }
    }

    public final synchronized void zzrw() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zzrw();
        }
    }

    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onVideoPlay();
        }
    }

    public final synchronized void zzb(zzaqt zzaqt) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zzb(zzaqt);
        }
    }

    public final synchronized void onVideoPause() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.onVideoPause();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zzb(bundle);
        }
    }

    public final synchronized void zzrx() throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zzrx();
        }
    }

    public final synchronized void zzcl(int i) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zzcl(i);
        }
    }

    public final synchronized void zza(zzaqv zzaqv) throws RemoteException {
        if (this.zzdfb != null) {
            this.zzdfb.zza(zzaqv);
        }
    }
}
