package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmi implements zzbna, zzbnb, zzbnj, zzbog, zztp {
    @GuardedBy("this")
    private zzuy zzgcm;

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzapy zzapy, String str, String str2) {
    }

    public final synchronized void zzc(zzuy zzuy) {
        this.zzgcm = zzuy;
    }

    public final synchronized zzuy zzalh() {
        return this.zzgcm;
    }

    public final synchronized void onAdClosed() {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdClosed();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdLeftApplication();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdLoaded();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    public final synchronized void onAdOpened() {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdOpened();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    public final synchronized void onAdClicked() {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdClicked();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void onAdImpression() {
        if (this.zzgcm != null) {
            try {
                this.zzgcm.onAdImpression();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdImpression.", e);
            }
        }
    }
}
