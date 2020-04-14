package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzala<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzakd zzdea;

    public zzala(zzakd zzakd) {
        this.zzdea = zzakd;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaxi.zzdv("Adapter called onClick.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzald(this));
            return;
        }
        try {
            this.zzdea.onAdClicked();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaxi.zzdv("Adapter called onDismissScreen.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zzeu("#008 Must be called on the main UI thread.");
            zzawy.zzzb.post(new zzale(this));
            return;
        }
        try {
            this.zzdea.onAdClosed();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzaxi.zzdv(sb.toString());
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzalh(this, errorCode));
            return;
        }
        try {
            this.zzdea.onAdFailedToLoad(zzalm.zza(errorCode));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaxi.zzdv("Adapter called onLeaveApplication.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzalg(this));
            return;
        }
        try {
            this.zzdea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaxi.zzdv("Adapter called onPresentScreen.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzalj(this));
            return;
        }
        try {
            this.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaxi.zzdv("Adapter called onReceivedAd.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzali(this));
            return;
        }
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaxi.zzdv("Adapter called onDismissScreen.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzall(this));
            return;
        }
        try {
            this.zzdea.onAdClosed();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzaxi.zzdv(sb.toString());
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzalk(this, errorCode));
            return;
        }
        try {
            this.zzdea.onAdFailedToLoad(zzalm.zza(errorCode));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaxi.zzdv("Adapter called onLeaveApplication.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzaln(this));
            return;
        }
        try {
            this.zzdea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaxi.zzdv("Adapter called onPresentScreen.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzalc(this));
            return;
        }
        try {
            this.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaxi.zzdv("Adapter called onReceivedAd.");
        zzuv.zzoj();
        if (!zzawy.zzwk()) {
            zzaxi.zze("#008 Must be called on the main UI thread.", null);
            zzawy.zzzb.post(new zzalf(this));
            return;
        }
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
