package com.google.ads.mediation.inmobi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.mediation.inmobi.rtb.InMobiBannerAd;
import com.google.ads.mediation.inmobi.rtb.InMobiInterstitialAd;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class InMobiMediationAdapter extends RtbAdapter {
    public static final String TAG = "InMobiMediationAdapter";
    public static AtomicBoolean isSdkInitialized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public InMobiBannerAd mInMobiBanner;
    /* access modifiers changed from: private */
    public InMobiInterstitialAd mInMobiInterstitial;
    /* access modifiers changed from: private */
    public InMobiRewardedAd mInMobiRewarded;

    /* renamed from: com.google.ads.mediation.inmobi.InMobiMediationAdapter$4 */
    static /* synthetic */ class C17574 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$gms$ads$AdFormat = new int[AdFormat.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.google.android.gms.ads.AdFormat[] r0 = com.google.android.gms.ads.AdFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$android$gms$ads$AdFormat = r0
                int[] r0 = $SwitchMap$com$google$android$gms$ads$AdFormat     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.android.gms.ads.AdFormat r1 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$android$gms$ads$AdFormat     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.android.gms.ads.AdFormat r1 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$android$gms$ads$AdFormat     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.android.gms.ads.AdFormat r1 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.mediation.inmobi.InMobiMediationAdapter.C17574.<clinit>():void");
        }
    }

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.VERSION_NAME.split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
    }

    public VersionInfo getSDKVersionInfo() {
        String[] split = InMobiSdk.getVersion().split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        String str;
        if (!(context instanceof Activity)) {
            initializationCompleteCallback.onInitializationFailed("InMobi SDK requires an Activity context to initialize");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (true) {
            str = "accountid";
            if (!it.hasNext()) {
                break;
            }
            String string = ((MediationConfiguration) it.next()).getServerParameters().getString(str);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            String str2 = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the InMobi SDK", new Object[]{str, hashSet, str2}));
            }
            InMobiSdk.init(context, str2, InMobiConsent.getConsentObj());
            isSdkInitialized.set(true);
            initializationCompleteCallback.onInitializationSucceeded();
        } else {
            String str3 = "Initialization failed: Missing or invalid Account ID.";
            Log.d(TAG, str3);
            initializationCompleteCallback.onInitializationFailed(str3);
        }
    }

    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        MediationConfiguration configuration = rtbSignalData.getConfiguration();
        Bundle serverParameters = configuration.getServerParameters();
        String string = serverParameters.getString("accountid");
        final Context context = rtbSignalData.getContext();
        InMobiSdk.init(context, string);
        InMobiSdk.setLogLevel(LogLevel.DEBUG);
        final long parseLong = Long.parseLong(serverParameters.getString("placementid"));
        Handler handler = new Handler(context.getMainLooper());
        int i = C17574.$SwitchMap$com$google$android$gms$ads$AdFormat[configuration.getFormat().ordinal()];
        if (i == 1) {
            final AdSize adSize = rtbSignalData.getAdSize();
            final SignalCallbacks signalCallbacks2 = signalCallbacks;
            C17541 r3 = new Runnable() {
                public void run() {
                    InMobiMediationAdapter.this.mInMobiBanner = new InMobiBannerAd(context, parseLong, adSize);
                    InMobiMediationAdapter.this.mInMobiBanner.collectSignals(signalCallbacks2);
                }
            };
            handler.post(r3);
        } else if (i == 2) {
            final SignalCallbacks signalCallbacks3 = signalCallbacks;
            C17552 r32 = new Runnable() {
                public void run() {
                    InMobiMediationAdapter.this.mInMobiInterstitial = new InMobiInterstitialAd(context, parseLong);
                    InMobiMediationAdapter.this.mInMobiInterstitial.collectSignals(signalCallbacks3);
                }
            };
            handler.post(r32);
        } else if (i == 3) {
            final SignalCallbacks signalCallbacks4 = signalCallbacks;
            C17563 r33 = new Runnable() {
                public void run() {
                    InMobiMediationAdapter.this.mInMobiRewarded = new InMobiRewardedAd(context, parseLong);
                    InMobiMediationAdapter.this.mInMobiRewarded.collectSignals(signalCallbacks4);
                }
            };
            handler.post(r33);
        }
    }

    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.mInMobiBanner = new InMobiBannerAd(mediationBannerAdConfiguration.getContext(), Long.parseLong(mediationBannerAdConfiguration.getServerParameters().getString("placementid")), mediationBannerAdConfiguration.getAdSize());
        this.mInMobiBanner.load(mediationBannerAdConfiguration, mediationAdLoadCallback);
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mInMobiInterstitial = new InMobiInterstitialAd(mediationInterstitialAdConfiguration.getContext(), Long.parseLong(mediationInterstitialAdConfiguration.getServerParameters().getString("placementid")));
        this.mInMobiInterstitial.load(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mInMobiRewarded = new InMobiRewardedAd(mediationRewardedAdConfiguration.getContext(), Long.parseLong(mediationRewardedAdConfiguration.getServerParameters().getString("placementid")));
        this.mInMobiRewarded.load(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
}
