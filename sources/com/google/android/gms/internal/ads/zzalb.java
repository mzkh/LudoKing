package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzalb<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzakb {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdel;
    private final NETWORK_EXTRAS zzdem;

    public zzalb(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdel = mediationAdapter;
        this.zzdem = network_extras;
    }

    public final zzwr getVideoController() {
        return null;
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaft zzaft, List<zzagb> list) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaqp zzaqp, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, zzaqp zzaqp, String str2) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, String str2, zzakd zzakd, zzaay zzaay, List<String> list) {
    }

    public final void zza(zztx zztx, String str) {
    }

    public final void zza(zztx zztx, String str, String str2) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zztx zztx, String str, zzakd zzakd) throws RemoteException {
    }

    public final zzakg zzrp() {
        return null;
    }

    public final zzakl zzrq() {
        return null;
    }

    public final boolean zzrt() {
        return false;
    }

    public final zzace zzru() {
        return null;
    }

    public final zzakm zzrv() {
        return null;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final IObjectWrapper zzro() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdel;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String str = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaxi.zzeu(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzua zzua, zztx zztx, String str, zzakd zzakd) throws RemoteException {
        zza(iObjectWrapper, zzua, zztx, str, null, zzakd);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzua zzua, zztx zztx, String str, String str2, zzakd zzakd) throws RemoteException {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdel;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String str3 = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaxi.zzeu(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
        zzaxi.zzdv("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdel;
            zzala zzala = new zzala(zzakd);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzdf = zzdf(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzua.width && adSizeArr[i].getHeight() == zzua.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zzb.zza(zzua.width, zzua.height, zzua.zzabd));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzala, activity, zzdf, adSize, zzalm.zza(zztx, zzc(zztx)), this.zzdem);
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzrr() {
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, zzakd zzakd) throws RemoteException {
        zza(iObjectWrapper, zztx, str, (String) null, zzakd);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, String str2, zzakd zzakd) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdel;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String str3 = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaxi.zzeu(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
        zzaxi.zzdv("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdel).requestInterstitialAd(new zzala(zzakd), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdf(str), zzalm.zza(zztx, zzc(zztx)), this.zzdem);
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdel;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String str = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzaxi.zzeu(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
        zzaxi.zzdv("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdel).showInterstitial();
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzrs() {
        return new Bundle();
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzdel.destroy();
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS zzdf(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, jSONObject.getString(str2));
                }
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.zzdel.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
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
}
