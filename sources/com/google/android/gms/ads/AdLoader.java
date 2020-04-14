package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaay;
import com.google.android.gms.internal.ads.zzaci;
import com.google.android.gms.internal.ads.zzacn;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzado;
import com.google.android.gms.internal.ads.zzadp;
import com.google.android.gms.internal.ads.zzadq;
import com.google.android.gms.internal.ads.zzadr;
import com.google.android.gms.internal.ads.zzadt;
import com.google.android.gms.internal.ads.zzadv;
import com.google.android.gms.internal.ads.zzaju;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zztt;
import com.google.android.gms.internal.ads.zzty;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzuy;
import com.google.android.gms.internal.ads.zzvd;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzwz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class AdLoader {
    private final zzty zzaax;
    private final zzvd zzaay;
    private final Context zzlk;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static class Builder {
        private final zzve zzaba;
        private final Context zzlk;

        @KeepForSdk
        @Deprecated
        public Builder withCorrelator(@NonNull Correlator correlator) {
            return this;
        }

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzuv.zzok().zzb(context, str, new zzaju()));
        }

        private Builder(Context context, zzve zzve) {
            this.zzlk = context;
            this.zzaba = zzve;
        }

        @Deprecated
        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzaba.zza((zzacn) new zzado(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzaba.zza((zzaci) new zzadp(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzaba.zza((zzacz) new zzadv(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            zzadr zzadr;
            try {
                zzve zzve = this.zzaba;
                zzadq zzadq = new zzadq(onCustomTemplateAdLoadedListener);
                if (onCustomClickListener == null) {
                    zzadr = null;
                } else {
                    zzadr = new zzadr(onCustomClickListener);
                }
                zzve.zza(str, zzadq, zzadr);
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzaba.zza(new zzadt(onPublisherAdViewLoadedListener), new zzua(this.zzlk, adSizeArr));
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzaba.zzb((zzuy) new zztt(adListener));
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzaba.zza(new zzaay(nativeAdOptions));
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzaba.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzaxi.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzlk, this.zzaba.zzor());
            } catch (RemoteException e) {
                zzaxi.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzvd zzvd) {
        this(context, zzvd, zzty.zzccl);
    }

    private AdLoader(Context context, zzvd zzvd, zzty zzty) {
        this.zzlk = context;
        this.zzaay = zzvd;
        this.zzaax = zzty;
    }

    private final void zza(zzwz zzwz) {
        try {
            this.zzaay.zzb(zzty.zza(this.zzlk, zzwz));
        } catch (RemoteException e) {
            zzaxi.zzc("Failed to load ad.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdb());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzaay.zza(zzty.zza(this.zzlk, adRequest.zzdb()), i);
        } catch (RemoteException e) {
            zzaxi.zzc("Failed to load ads.", e);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdb());
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzaay.zzju();
        } catch (RemoteException e) {
            zzaxi.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzaay.isLoading();
        } catch (RemoteException e) {
            zzaxi.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
