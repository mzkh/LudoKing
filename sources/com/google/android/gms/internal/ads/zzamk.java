package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzamk implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzals zzdev;
    private final /* synthetic */ zzakd zzdew;
    private final /* synthetic */ zzami zzdex;

    zzamk(zzami zzami, zzals zzals, zzakd zzakd) {
        this.zzdex = zzami;
        this.zzdev = zzals;
        this.zzdew = zzakd;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        String str = "";
        if (mediationInterstitialAd == null) {
            zzaxi.zzeu("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdev.zzdg("Adapter returned null.");
            } catch (RemoteException e) {
                zzaxi.zzc(str, e);
            }
            return null;
        }
        try {
            this.zzdex.zzdet = mediationInterstitialAd;
            this.zzdev.zzsf();
        } catch (RemoteException e2) {
            zzaxi.zzc(str, e2);
        }
        return new zzamo(this.zzdew);
    }

    public final void onFailure(String str) {
        try {
            this.zzdev.zzdg(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
