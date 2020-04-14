package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzaml implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzakd zzdew;
    private final /* synthetic */ zzalr zzdey;

    zzaml(zzami zzami, zzalr zzalr, zzakd zzakd) {
        this.zzdey = zzalr;
        this.zzdew = zzakd;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        String str = "";
        if (mediationBannerAd == null) {
            zzaxi.zzeu("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdey.zzdg("Adapter returned null.");
            } catch (RemoteException e) {
                zzaxi.zzc(str, e);
            }
            return null;
        }
        try {
            this.zzdey.zzab(ObjectWrapper.wrap(mediationBannerAd.getView()));
        } catch (RemoteException e2) {
            zzaxi.zzc(str, e2);
        }
        return new zzamo(this.zzdew);
    }

    public final void onFailure(String str) {
        try {
            this.zzdey.zzdg(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
