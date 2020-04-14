package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzakt extends zzakb {
    private final Object zzddv;
    private zzaku zzddw;
    private zzaqp zzddx;
    private IObjectWrapper zzddy;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzddz;

    public zzakt(@NonNull MediationAdapter mediationAdapter) {
        this.zzddv = mediationAdapter;
    }

    public zzakt(@NonNull Adapter adapter) {
        this.zzddv = adapter;
    }

    public final IObjectWrapper zzro() throws RemoteException {
        Object obj = this.zzddv;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzua zzua, zztx zztx, String str, zzakd zzakd) throws RemoteException {
        zza(iObjectWrapper, zzua, zztx, str, null, zzakd);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzua zzua, zztx zztx, String str, String str2, zzakd zzakd) throws RemoteException {
        Date date;
        zzua zzua2 = zzua;
        zztx zztx2 = zztx;
        String str3 = str;
        if (this.zzddv instanceof MediationBannerAdapter) {
            zzaxi.zzdv("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzddv;
                Bundle bundle = null;
                Set hashSet = zztx2.zzcbz != null ? new HashSet(zztx2.zzcbz) : null;
                if (zztx2.zzcbx == -1) {
                    date = null;
                } else {
                    date = new Date(zztx2.zzcbx);
                }
                zzakq zzakq = new zzakq(date, zztx2.zzcby, hashSet, zztx2.zzng, zzc(zztx), zztx2.zzabj, zztx2.zzccj, zztx2.zzabk, zza(str3, zztx2));
                if (zztx2.zzcce != null) {
                    bundle = zztx2.zzcce.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaku(zzakd), zza(str3, zztx2, str2), zzb.zza(zzua2.width, zzua2.height, zzua2.zzabd), zzakq, bundle);
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzrr() {
        Object obj = this.zzddv;
        if (obj instanceof zzbeh) {
            return ((zzbeh) obj).zzrr();
        }
        String canonicalName = zzbeh.class.getCanonicalName();
        String canonicalName2 = this.zzddv.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzaxi.zzeu(sb.toString());
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, zzakd zzakd) throws RemoteException {
        zza(iObjectWrapper, zztx, str, (String) null, zzakd);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, String str2, zzakd zzakd) throws RemoteException {
        Date date;
        zztx zztx2 = zztx;
        String str3 = str;
        if (this.zzddv instanceof MediationInterstitialAdapter) {
            zzaxi.zzdv("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzddv;
                Bundle bundle = null;
                Set hashSet = zztx2.zzcbz != null ? new HashSet(zztx2.zzcbz) : null;
                if (zztx2.zzcbx == -1) {
                    date = null;
                } else {
                    date = new Date(zztx2.zzcbx);
                }
                zzakq zzakq = new zzakq(date, zztx2.zzcby, hashSet, zztx2.zzng, zzc(zztx), zztx2.zzabj, zztx2.zzccj, zztx2.zzabk, zza(str3, zztx2));
                if (zztx2.zzcce != null) {
                    bundle = zztx2.zzcce.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaku(zzakd), zza(str3, zztx2, str2), zzakq, bundle);
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzddv;
        if (obj instanceof zzbej) {
            return ((zzbej) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbej.class.getCanonicalName();
        String canonicalName2 = this.zzddv.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzaxi.zzeu(sb.toString());
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, String str2, zzakd zzakd, zzaay zzaay, List<String> list) throws RemoteException {
        Date date;
        zztx zztx2 = zztx;
        String str3 = str;
        Object obj = this.zzddv;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                Bundle bundle = null;
                Set hashSet = zztx2.zzcbz != null ? new HashSet(zztx2.zzcbz) : null;
                if (zztx2.zzcbx == -1) {
                    date = null;
                } else {
                    date = new Date(zztx2.zzcbx);
                }
                zzaky zzaky = new zzaky(date, zztx2.zzcby, hashSet, zztx2.zzng, zzc(zztx), zztx2.zzabj, zzaay, list, zztx2.zzccj, zztx2.zzabk, zza(str3, zztx2));
                if (zztx2.zzcce != null) {
                    bundle = zztx2.zzcce.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.zzddw = new zzaku(zzakd);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzddw, zza(str3, zztx2, str2), zzaky, bundle);
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzrs() {
        return new Bundle();
    }

    public final zzakg zzrp() {
        NativeAdMapper zzsa = this.zzddw.zzsa();
        if (zzsa instanceof NativeAppInstallAdMapper) {
            return new zzakw((NativeAppInstallAdMapper) zzsa);
        }
        return null;
    }

    public final zzakm zzrv() {
        UnifiedNativeAdMapper zzsb = this.zzddw.zzsb();
        if (zzsb != null) {
            return new zzalo(zzsb);
        }
        return null;
    }

    public final zzakl zzrq() {
        NativeAdMapper zzsa = this.zzddw.zzsa();
        if (zzsa instanceof NativeContentAdMapper) {
            return new zzakz((NativeContentAdMapper) zzsa);
        }
        return null;
    }

    public final zzace zzru() {
        NativeCustomTemplateAd zzsc = this.zzddw.zzsc();
        if (zzsc instanceof zzacj) {
            return ((zzacj) zzsc).zzqv();
        }
        return null;
    }

    public final boolean zzrt() {
        return this.zzddv instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zztx zztx, String str, zzaqp zzaqp, String str2) throws RemoteException {
        Bundle bundle;
        zzakq zzakq;
        Date date;
        zztx zztx2 = zztx;
        zzaqp zzaqp2 = zzaqp;
        String str3 = str2;
        Object obj = this.zzddv;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaxi.zzdv("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzddv;
                Bundle zza = zza(str3, zztx2, (String) null);
                if (zztx2 != null) {
                    Set hashSet = zztx2.zzcbz != null ? new HashSet(zztx2.zzcbz) : null;
                    if (zztx2.zzcbx == -1) {
                        date = null;
                    } else {
                        date = new Date(zztx2.zzcbx);
                    }
                    zzakq zzakq2 = new zzakq(date, zztx2.zzcby, hashSet, zztx2.zzng, zzc(zztx), zztx2.zzabj, zztx2.zzccj, zztx2.zzabk, zza(str3, zztx2));
                    bundle = zztx2.zzcce != null ? zztx2.zzcce.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzakq = zzakq2;
                } else {
                    zzakq = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzakq, str, new zzaqu(zzaqp2), zza, bundle);
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.zzddy = iObjectWrapper;
            this.zzddx = zzaqp2;
            zzaqp2.zzai(ObjectWrapper.wrap(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaqp zzaqp, List<String> list) throws RemoteException {
        if (this.zzddv instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzaxi.zzdv("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzddv;
                ArrayList arrayList = new ArrayList();
                for (String zza : list) {
                    arrayList.add(zza(zza, (zztx) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaqu(zzaqp), arrayList);
            } catch (Throwable th) {
                zzaxi.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(zztx zztx, String str) throws RemoteException {
        zza(zztx, str, (String) null);
    }

    public final void zza(zztx zztx, String str, String str2) throws RemoteException {
        Date date;
        zztx zztx2 = zztx;
        String str3 = str;
        Object obj = this.zzddv;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaxi.zzdv("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzddv;
                Bundle bundle = null;
                Set hashSet = zztx2.zzcbz != null ? new HashSet(zztx2.zzcbz) : null;
                if (zztx2.zzcbx == -1) {
                    date = null;
                } else {
                    date = new Date(zztx2.zzcbx);
                }
                zzakq zzakq = new zzakq(date, zztx2.zzcby, hashSet, zztx2.zzng, zzc(zztx), zztx2.zzabj, zztx2.zzccj, zztx2.zzabk, zza(str3, zztx2));
                if (zztx2.zzcce != null) {
                    bundle = zztx2.zzcce.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzakq, zza(str3, zztx2, str2), bundle);
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            zzb(this.zzddy, zztx2, str3, new zzakx((Adapter) obj, this.zzddx));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() throws RemoteException {
        Object obj = this.zzddv;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaxi.zzdv("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzddv).showVideo();
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzddz;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzddy));
            } else {
                zzaxi.zzes("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() throws RemoteException {
        Object obj = this.zzddv;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaxi.zzdv("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzddv).isInitialized();
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.zzddx != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zztx zztx, String str, zzakd zzakd) throws RemoteException {
        Bundle bundle;
        zztx zztx2 = zztx;
        String str2 = str;
        if (this.zzddv instanceof Adapter) {
            zzaxi.zzdv("Requesting rewarded ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zzddv;
                zzaks zzaks = new zzaks(this, zzakd, adapter);
                Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
                String str3 = "";
                Bundle zza = zza(str2, zztx2, (String) null);
                if (zztx2.zzcce != null) {
                    bundle = zztx2.zzcce.getBundle(this.zzddv.getClass().getName());
                    if (bundle != null) {
                        Bundle bundle2 = bundle;
                        boolean zzc = zzc(zztx);
                        Location location = zztx2.zzng;
                        int i = zztx2.zzabj;
                        int i2 = zztx2.zzabk;
                        String zza2 = zza(str2, zztx2);
                        MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                        MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration(context, str3, zza, bundle2, zzc, location, i, i2, zza2, "");
                        adapter.loadRewardedAd(mediationRewardedAdConfiguration, zzaks);
                    }
                }
                bundle = new Bundle();
                Bundle bundle22 = bundle;
                boolean zzc2 = zzc(zztx);
                Location location2 = zztx2.zzng;
                int i3 = zztx2.zzabj;
                int i22 = zztx2.zzabk;
                String zza22 = zza(str2, zztx2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration3 = mediationRewardedAdConfiguration2;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration22 = new MediationRewardedAdConfiguration(context, str3, zza, bundle22, zzc2, location2, i3, i22, zza22, "");
                adapter.loadRewardedAd(mediationRewardedAdConfiguration3, zzaks);
            } catch (Exception e) {
                zzaxi.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzddv instanceof Adapter) {
            zzaxi.zzdv("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzddz;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzaxi.zzes("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.zzddv;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzaxi.zzc("", th);
        }
    }

    public final zzwr getVideoController() {
        Object obj = this.zzddv;
        if (!(obj instanceof zza)) {
            return null;
        }
        try {
            return ((zza) obj).getVideoController();
        } catch (Throwable th) {
            zzaxi.zzc("", th);
            return null;
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (this.zzddv instanceof MediationInterstitialAdapter) {
            zzaxi.zzdv("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzddv).showInterstitial();
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzddv.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaxi.zzeu(sb.toString());
            throw new RemoteException();
        }
    }

    public final void destroy() throws RemoteException {
        Object obj = this.zzddv;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void pause() throws RemoteException {
        Object obj = this.zzddv;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() throws RemoteException {
        Object obj = this.zzddv;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzaxi.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzddv;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaft zzaft, List<zzagb> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzddv instanceof Adapter) {
            zzakv zzakv = new zzakv(this, zzaft);
            ArrayList arrayList = new ArrayList();
            for (zzagb zzagb : list) {
                String str = zzagb.zzcys;
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
                    throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, zzagb.extras));
            }
            ((Adapter) this.zzddv).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzakv, arrayList);
            return;
        }
        throw new RemoteException();
    }

    private final Bundle zza(String str, zztx zztx, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        String str3 = "Server parameters: ";
        zzaxi.zzdv(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    bundle.putString(str4, jSONObject.getString(str4));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzddv instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zztx != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zztx.zzabj);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzaxi.zzc("", th);
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
}
