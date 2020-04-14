package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzamm implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzakd zzdew;
    private final /* synthetic */ zzalx zzdez;

    zzamm(zzami zzami, zzalx zzalx, zzakd zzakd) {
        this.zzdez = zzalx;
        this.zzdew = zzakd;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        String str = "";
        if (unifiedNativeAdMapper == null) {
            zzaxi.zzeu("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdez.zzdg("Adapter returned null.");
            } catch (RemoteException e) {
                zzaxi.zzc(str, e);
            }
            return null;
        }
        try {
            this.zzdez.zza(new zzalo(unifiedNativeAdMapper));
        } catch (RemoteException e2) {
            zzaxi.zzc(str, e2);
        }
        return new zzamo(this.zzdew);
    }

    public final void onFailure(String str) {
        try {
            this.zzdez.zzdg(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
