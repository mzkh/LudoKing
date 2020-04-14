package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzaks implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzakd zzdds;
    private final /* synthetic */ Adapter zzddt;
    private final /* synthetic */ zzakt zzddu;

    zzaks(zzakt zzakt, zzakd zzakd, Adapter adapter) {
        this.zzddu = zzakt;
        this.zzdds = zzakd;
        this.zzddt = adapter;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.zzddu.zzddz = mediationRewardedAd;
            this.zzdds.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return new zzart(this.zzdds);
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzddt.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded medation ad: ");
            sb.append(str);
            zzaxi.zzdv(sb.toString());
            this.zzdds.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
