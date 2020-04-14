package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzart implements MediationRewardedAdCallback {
    private final zzakd zzdea;

    public zzart(zzakd zzakd) {
        this.zzdea = zzakd;
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdOpened.");
        try {
            this.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClosed.");
        try {
            this.zzdea.onAdClosed();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onUserEarnedReward.");
        try {
            this.zzdea.zza((zzaqv) new zzarw(rewardItem));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called reportAdClicked.");
        try {
            this.zzdea.onAdClicked();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called reportAdImpression.");
        try {
            this.zzdea.onAdImpression();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        String str2 = "Mediation ad failed to show: ";
        zzaxi.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        try {
            this.zzdea.zzcl(0);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onVideoStart.");
        try {
            this.zzdea.zzrw();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onVideoComplete.");
        try {
            this.zzdea.zzrx();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
