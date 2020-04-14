package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzami extends zzamc {
    /* access modifiers changed from: private */
    public MediationRewardedAd zzddz;
    private final RtbAdapter zzdes;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdet;
    private String zzdeu = "";

    public zzami(RtbAdapter rtbAdapter) {
        this.zzdes = rtbAdapter;
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzalr zzalr, zzakd zzakd, zzua zzua) throws RemoteException {
        zztx zztx2 = zztx;
        zzua zzua2 = zzua;
        try {
            zzaml zzaml = new zzaml(this, zzalr, zzakd);
            RtbAdapter rtbAdapter = this.zzdes;
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            Bundle zzdj = zzdj(str2);
            Bundle zzd = zzd(zztx2);
            boolean zzc = zzc(zztx);
            Location location = zztx2.zzng;
            int i = zztx2.zzabj;
            int i2 = zztx2.zzabk;
            String zza = zza(str2, zztx);
            AdSize zza2 = zzb.zza(zzua2.width, zzua2.height, zzua2.zzabd);
            String str3 = this.zzdeu;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration(context, str, zzdj, zzd, zzc, location, i, i2, zza, zza2, str3);
            rtbAdapter.loadBannerAd(mediationBannerAdConfiguration, zzaml);
        } catch (Throwable th) {
            zzaxi.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzals zzals, zzakd zzakd) throws RemoteException {
        zztx zztx2 = zztx;
        try {
            zzamk zzamk = new zzamk(this, zzals, zzakd);
            RtbAdapter rtbAdapter = this.zzdes;
            MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration = new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdj(str2), zzd(zztx2), zzc(zztx), zztx2.zzng, zztx2.zzabj, zztx2.zzabk, zza(str2, zztx), this.zzdeu);
            rtbAdapter.loadInterstitialAd(mediationInterstitialAdConfiguration, zzamk);
        } catch (Throwable th) {
            zzaxi.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzaly zzaly, zzakd zzakd) throws RemoteException {
        zztx zztx2 = zztx;
        try {
            zzamn zzamn = new zzamn(this, zzaly, zzakd);
            RtbAdapter rtbAdapter = this.zzdes;
            MediationRewardedAdConfiguration mediationRewardedAdConfiguration = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdj(str2), zzd(zztx2), zzc(zztx), zztx2.zzng, zztx2.zzabj, zztx2.zzabk, zza(str2, zztx), this.zzdeu);
            rtbAdapter.loadRewardedAd(mediationRewardedAdConfiguration, zzamn);
        } catch (Throwable th) {
            zzaxi.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzalx zzalx, zzakd zzakd) throws RemoteException {
        zztx zztx2 = zztx;
        try {
            zzamm zzamm = new zzamm(this, zzalx, zzakd);
            RtbAdapter rtbAdapter = this.zzdes;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdj(str2), zzd(zztx2), zzc(zztx), zztx2.zzng, zztx2.zzabj, zztx2.zzabk, zza(str2, zztx), this.zzdeu);
            rtbAdapter.loadNativeAd(mediationNativeAdConfiguration, zzamm);
        } catch (Throwable th) {
            zzaxi.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final boolean zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdet;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } catch (Throwable th) {
            zzaxi.zzc("", th);
        }
        return true;
    }

    public final boolean zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzddz;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } catch (Throwable th) {
            zzaxi.zzc("", th);
        }
        return true;
    }

    public final zzwr getVideoController() {
        RtbAdapter rtbAdapter = this.zzdes;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            return null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzua zzua, zzame zzame) throws RemoteException {
        AdFormat adFormat;
        try {
            zzamp zzamp = new zzamp(this, zzame);
            RtbAdapter rtbAdapter = this.zzdes;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 3;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zzb.zza(zzua.width, zzua.height, zzua.zzabd)), zzamp);
        } catch (Throwable th) {
            zzaxi.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    public final zzamr zzsg() throws RemoteException {
        return zzamr.zza(this.zzdes.getVersionInfo());
    }

    public final zzamr zzsh() throws RemoteException {
        return zzamr.zza(this.zzdes.getSDKVersionInfo());
    }

    public final void zzdh(String str) {
        this.zzdeu = str;
    }

    private static Bundle zzdj(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        String str2 = "Server parameters: ";
        zzaxi.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                bundle2.putString(str3, jSONObject.getString(str3));
            }
            return bundle2;
        } catch (JSONException e) {
            zzaxi.zzc("", e);
            throw new RemoteException();
        }
    }

    private static boolean zzc(zztx zztx) {
        if (!zztx.zzcca) {
            zzuv.zzoj();
            if (!zzawy.zzwj()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static String zza(String str, zztx zztx) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zztx.zzabl;
        }
    }

    private final Bundle zzd(zztx zztx) {
        if (zztx.zzcce != null) {
            Bundle bundle = zztx.zzcce.getBundle(this.zzdes.getClass().getName());
            if (bundle != null) {
                return bundle;
            }
        }
        return new Bundle();
    }
}
