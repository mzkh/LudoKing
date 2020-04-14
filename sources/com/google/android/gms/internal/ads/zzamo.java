package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzamo implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback {
    private zzakd zzdfb;

    zzamo(zzakd zzakd) {
        this.zzdfb = zzakd;
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdImpression() {
    }

    public final void reportAdClicked() {
        try {
            this.zzdfb.onAdClicked();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zzdfb.onAdOpened();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdClosed() {
        try {
            this.zzdfb.onAdClosed();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zzdfb.onAdLeftApplication();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zzdfb.onVideoPlay();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zzdfb.zza((zzaqv) new zzarw(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zzdfb.zzrw();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zzdfb.onVideoEnd();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        String str2 = "Mediated ad failed to show: ";
        try {
            String valueOf = String.valueOf(str);
            zzaxi.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            this.zzdfb.zzcl(0);
        } catch (RemoteException unused) {
        }
    }
}
