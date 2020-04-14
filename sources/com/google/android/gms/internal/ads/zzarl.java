package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzarl {
    private final zzara zzdoc;
    private final Context zzzc;

    public zzarl(Context context, String str) {
        this.zzzc = context.getApplicationContext();
        this.zzdoc = zzuv.zzok().zzc(context, str, new zzaju());
    }

    public final void zza(zzwz zzwz, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdoc.zza(zzty.zza(this.zzzc, zzwz), (zzari) new zzars(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdoc.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdoc.zza(new zzarr(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdoc.zza((zzwm) new zzya(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzdoc.getAdMetadata();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzdoc.isLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzdoc.zza((zzarb) new zzarn(rewardedAdCallback));
            this.zzdoc.zzl(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzdoc.zza((zzarb) new zzarn(rewardedAdCallback));
            this.zzdoc.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzaqv zzpk = this.zzdoc.zzpk();
            if (zzpk == null) {
                return null;
            }
            return new zzaro(zzpk);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
