package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaqu implements MediationRewardedVideoAdListener {
    private final zzaqp zzdob;

    public zzaqu(zzaqp zzaqp) {
        this.zzdob = zzaqp;
    }

    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onInitializationSucceeded.");
        try {
            this.zzdob.zzai(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onInitializationFailed.");
        try {
            this.zzdob.zzd(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLoaded.");
        try {
            this.zzdob.zzaj(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdOpened.");
        try {
            this.zzdob.zzak(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onVideoStarted.");
        try {
            this.zzdob.zzal(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClosed.");
        try {
            this.zzdob.zzam(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.zzdob.zza(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), new zzaqt(rewardItem));
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        } else {
            this.zzdob.zza(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), new zzaqt("", 1));
        }
    }

    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClicked.");
        try {
            this.zzdob.zzan(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdFailedToLoad.");
        try {
            this.zzdob.zze(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLeftApplication.");
        try {
            this.zzdob.zzao(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onVideoCompleted.");
        try {
            this.zzdob.zzap(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdMetadataChanged.");
        try {
            this.zzdob.zzb(bundle);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
