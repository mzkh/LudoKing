package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.RequestConfiguration.Builder;
import com.google.android.gms.ads.initialization.AdapterStatus.State;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxc {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    private static zzxc zzces;
    private zzwb zzcet;
    private RewardedVideoAd zzceu;
    @NonNull
    private RequestConfiguration zzcev = new Builder().build();
    private InitializationStatus zzcew;

    private zzxc() {
    }

    public static zzxc zzph() {
        zzxc zzxc;
        synchronized (lock) {
            if (zzces == null) {
                zzces = new zzxc();
            }
            zzxc = zzces;
        }
        return zzxc;
    }

    public final void zza(Context context, String str, zzxl zzxl, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (lock) {
            if (this.zzcet == null) {
                if (context != null) {
                    try {
                        zzajp.zzrn().zzc(context, str);
                        boolean z = false;
                        this.zzcet = (zzwb) new zzuo(zzuv.zzok(), context).zzd(context, false);
                        if (onInitializationCompleteListener != null) {
                            this.zzcet.zza((zzafu) new zzxj(this, onInitializationCompleteListener, null));
                        }
                        this.zzcet.zza((zzajx) new zzaju());
                        this.zzcet.initialize();
                        this.zzcet.zzb(str, ObjectWrapper.wrap(new zzxf(this, context)));
                        if (!(this.zzcev.getTagForChildDirectedTreatment() == -1 && this.zzcev.getTagForUnderAgeOfConsent() == -1)) {
                            zza(this.zzcev);
                        }
                        zzza.initialize(context);
                        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqx)).booleanValue()) {
                            if (((Boolean) zzuv.zzon().zzd(zzza.zzcrf)).booleanValue()) {
                                z = true;
                            }
                        }
                        if (!z || zzpi()) {
                            zzaxi.zzes("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                            this.zzcew = new zzxh(this);
                            if (onInitializationCompleteListener != null) {
                                zzawy.zzzb.post(new zzxe(this, onInitializationCompleteListener));
                            }
                        }
                    } catch (RemoteException e) {
                        zzaxi.zzd("MobileAdsSettingManager initialization failed", e);
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            }
        }
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (lock) {
            if (this.zzceu != null) {
                RewardedVideoAd rewardedVideoAd = this.zzceu;
                return rewardedVideoAd;
            }
            this.zzceu = new zzaqq(context, (zzaqb) new zzut(zzuv.zzok(), context, new zzaju()).zzd(context, false));
            RewardedVideoAd rewardedVideoAd2 = this.zzceu;
            return rewardedVideoAd2;
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzcet == null) {
            z = false;
        }
        Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzcet.setAppVolume(f);
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to set app volume.", e);
        }
    }

    public final float zzos() {
        zzwb zzwb = this.zzcet;
        float f = 1.0f;
        if (zzwb == null) {
            return 1.0f;
        }
        try {
            f = zzwb.zzos();
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to get app volume.", e);
        }
        return f;
    }

    public final void setAppMuted(boolean z) {
        Preconditions.checkState(this.zzcet != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.zzcet.setAppMuted(z);
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to set app mute state.", e);
        }
    }

    public final boolean zzot() {
        zzwb zzwb = this.zzcet;
        boolean z = false;
        if (zzwb == null) {
            return false;
        }
        try {
            z = zzwb.zzot();
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to get app mute state.", e);
        }
        return z;
    }

    public final void openDebugMenu(Context context, String str) {
        Preconditions.checkState(this.zzcet != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzcet.zzc(ObjectWrapper.wrap(context), str);
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to open debug menu.", e);
        }
    }

    public final String getVersionString() {
        Preconditions.checkState(this.zzcet != null, "MobileAds.initialize() must be called prior to getting version string.");
        try {
            return this.zzcet.getVersionString();
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to get version string.", e);
            return "";
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        try {
            this.zzcet.zzbz(cls.getCanonicalName());
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to register RtbAdapter", e);
        }
    }

    public final InitializationStatus getInitializationStatus() {
        Preconditions.checkState(this.zzcet != null, "MobileAds.initialize() must be called prior to getting initialization status.");
        try {
            if (this.zzcew != null) {
                return this.zzcew;
            }
            return zzb(this.zzcet.zzou());
        } catch (RemoteException unused) {
            zzaxi.zzes("Unable to get Initialization status.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzb(List<zzafr> list) {
        HashMap hashMap = new HashMap();
        for (zzafr zzafr : list) {
            hashMap.put(zzafr.zzcyn, new zzafz(zzafr.zzcyo ? State.READY : State.NOT_READY, zzafr.description, zzafr.zzcyp));
        }
        return new zzafy(hashMap);
    }

    @NonNull
    public final RequestConfiguration getRequestConfiguration() {
        return this.zzcev;
    }

    public final void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        RequestConfiguration requestConfiguration2 = this.zzcev;
        this.zzcev = requestConfiguration;
        if (this.zzcet != null) {
            if (!(requestConfiguration2.getTagForChildDirectedTreatment() == requestConfiguration.getTagForChildDirectedTreatment() && requestConfiguration2.getTagForUnderAgeOfConsent() == requestConfiguration.getTagForUnderAgeOfConsent())) {
                zza(requestConfiguration);
            }
        }
    }

    private final void zza(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.zzcet.zza(new zzyd(requestConfiguration));
        } catch (RemoteException e) {
            zzaxi.zzc("Unable to set request configuration parcel.", e);
        }
    }

    private final boolean zzpi() throws RemoteException {
        try {
            return this.zzcet.getVersionString().endsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } catch (RemoteException unused) {
            zzaxi.zzes("Unable to get version string.");
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzcew);
    }
}
