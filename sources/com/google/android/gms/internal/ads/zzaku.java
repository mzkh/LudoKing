package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaku implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzakd zzdea;
    private NativeAdMapper zzdeb;
    private UnifiedNativeAdMapper zzdec;
    private NativeCustomTemplateAd zzded;

    public zzaku(zzakd zzakd) {
        this.zzdea = zzakd;
    }

    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAppEvent.");
        try {
            this.zzdea.onAppEvent(str, str2);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClicked.");
        try {
            this.zzdea.onAdClicked();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClosed.");
        try {
            this.zzdea.onAdClosed();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        zzaxi.zzdv(sb.toString());
        try {
            this.zzdea.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLeftApplication.");
        try {
            this.zzdea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdOpened.");
        try {
            this.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLoaded.");
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClicked.");
        try {
            this.zzdea.onAdClicked();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClosed.");
        try {
            this.zzdea.onAdClosed();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzaxi.zzdv(sb.toString());
        try {
            this.zzdea.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLeftApplication.");
        try {
            this.zzdea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdOpened.");
        try {
            this.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLoaded.");
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLoaded.");
        this.zzdeb = nativeAdMapper;
        this.zzdec = null;
        zza(mediationNativeAdapter, this.zzdec, this.zzdeb);
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLoaded.");
        this.zzdec = unifiedNativeAdMapper;
        this.zzdeb = null;
        zza(mediationNativeAdapter, this.zzdec, this.zzdeb);
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    private static void zza(MediationNativeAdapter mediationNativeAdapter, @Nullable UnifiedNativeAdMapper unifiedNativeAdMapper, @Nullable NativeAdMapper nativeAdMapper) {
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            VideoController videoController = new VideoController();
            videoController.zza(new zzakr());
            if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.hasVideoContent()) {
                unifiedNativeAdMapper.zza(videoController);
            }
            if (nativeAdMapper != null && nativeAdMapper.hasVideoContent()) {
                nativeAdMapper.zza(videoController);
            }
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        String str = "Adapter called onAdLoaded with template id ";
        zzaxi.zzdv(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.zzded = nativeCustomTemplateAd;
        try {
            this.zzdea.onAdLoaded();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzacj) {
            try {
                this.zzdea.zza(((zzacj) nativeCustomTemplateAd).zzqv(), str);
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        } else {
            zzaxi.zzeu("Unexpected native custom template ad type.");
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzaxi.zzdv(sb.toString());
        try {
            this.zzdea.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdOpened.");
        try {
            this.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdClosed.");
        try {
            this.zzdea.onAdClosed();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onAdLeftApplication.");
        try {
            this.zzdea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzdeb;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzdec;
        String str = "#007 Could not call remote method.";
        if (this.zzded == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzaxi.zze(str, null);
                return;
            }
            String str2 = "Could not call onAdClicked since setOverrideClickHandling is not set to true";
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.getOverrideClickHandling()) {
                zzaxi.zzdv(str2);
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.getOverrideClickHandling()) {
                zzaxi.zzdv(str2);
                return;
            }
        }
        zzaxi.zzdv("Adapter called onAdClicked.");
        try {
            this.zzdea.onAdClicked();
        } catch (RemoteException e) {
            zzaxi.zze(str, e);
        }
    }

    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzdeb;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzdec;
        String str = "#007 Could not call remote method.";
        if (this.zzded == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzaxi.zze(str, null);
                return;
            }
            String str2 = "Could not call onAdImpression since setOverrideImpressionRecording is not set to true";
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.getOverrideImpressionRecording()) {
                zzaxi.zzdv(str2);
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.getOverrideImpressionRecording()) {
                zzaxi.zzdv(str2);
                return;
            }
        }
        zzaxi.zzdv("Adapter called onAdImpression.");
        try {
            this.zzdea.onAdImpression();
        } catch (RemoteException e) {
            zzaxi.zze(str, e);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaxi.zzdv("Adapter called onVideoEnd.");
        try {
            this.zzdea.onVideoEnd();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final NativeAdMapper zzsa() {
        return this.zzdeb;
    }

    public final UnifiedNativeAdMapper zzsb() {
        return this.zzdec;
    }

    public final NativeCustomTemplateAd zzsc() {
        return this.zzded;
    }
}
