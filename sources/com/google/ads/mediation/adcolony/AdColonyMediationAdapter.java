package com.google.ads.mediation.adcolony;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyCustomMessage;
import com.adcolony.sdk.AdColonyCustomMessageListener;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
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
import com.jirbo.adcolony.AdColonyManager;
import com.jirbo.adcolony.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AdColonyMediationAdapter extends RtbAdapter {
    public static final String TAG = "AdColonyMediationAdapter";
    private static AdColonyAppOptions appOptions = new AdColonyAppOptions();
    /* access modifiers changed from: private */
    public static HashMap<String, String> bidResponseDetailsHashMap = new HashMap<>();

    public VersionInfo getVersionInfo() {
        String str = BuildConfig.VERSION_NAME;
        String[] split = str.split("\\.");
        if (split.length >= 4) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s.Returning 0.0.0 for adapter version.", new Object[]{str}));
        return new VersionInfo(0, 0, 0);
    }

    public VersionInfo getSDKVersionInfo() {
        String sDKVersion = AdColony.getSDKVersion();
        String[] split = sDKVersion.split("\\.");
        if (split.length >= 3) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s.Returning 0.0.0 for SDK version.", new Object[]{sDKVersion}));
        return new VersionInfo(0, 0, 0);
    }

    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        String str;
        if (!(context instanceof Activity)) {
            initializationCompleteCallback.onInitializationFailed("AdColony SDK requires an Activity context to initialize");
            return;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            str = "app_id";
            if (!it.hasNext()) {
                break;
            }
            Bundle serverParameters = ((MediationConfiguration) it.next()).getServerParameters();
            String string = serverParameters.getString(str);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
            ArrayList parseZoneList = AdColonyManager.getInstance().parseZoneList(serverParameters);
            if (parseZoneList != null && parseZoneList.size() > 0) {
                arrayList.addAll(parseZoneList);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            String str2 = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the AdColony SDK.", new Object[]{str, hashSet.toString(), str2}));
            }
            if (arrayList.isEmpty()) {
                initializationCompleteCallback.onInitializationFailed("Initialization Failed: No zones provided to initialize the AdColony SDK.");
                return;
            }
            appOptions.setMediationNetwork(AdColonyAppOptions.ADMOB, BuildConfig.VERSION_NAME);
            if (AdColony.configure((Activity) context, appOptions, str2, (String[]) arrayList.toArray(new String[0]))) {
                initializationCompleteCallback.onInitializationSucceeded();
            } else {
                initializationCompleteCallback.onInitializationFailed("Initialization Failed: Internal Error on Configuration");
            }
            return;
        }
        initializationCompleteCallback.onInitializationFailed("Initialization Failed: Missing or Invalid App ID.");
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        new AdColonyInterstitialRenderer(mediationInterstitialAdConfiguration.getServerParameters().getString(AdColonyAdapterUtils.KEY_ZONE_ID)).requestInterstitial(mediationAdLoadCallback);
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        new AdColonyRewardedRenderer(mediationRewardedAdConfiguration, mediationAdLoadCallback).render();
    }

    public static AdColonyAppOptions getAppOptions() {
        return appOptions;
    }

    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        String str;
        AdColony.addCustomMessageListener(new AdColonyCustomMessageListener() {
            public void onAdColonyCustomMessage(AdColonyCustomMessage adColonyCustomMessage) {
                try {
                    AdColonyMediationAdapter.bidResponseDetailsHashMap.put(new JSONObject(adColonyCustomMessage.getMessage()).getString("zone"), adColonyCustomMessage.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, "bid");
        HashMap<String, String> hashMap = bidResponseDetailsHashMap;
        if (hashMap == null || hashMap.size() <= 0) {
            str = "";
        } else {
            str = (String) bidResponseDetailsHashMap.get(rtbSignalData.getConfiguration().getServerParameters().getString(AdColonyAdapterUtils.KEY_ZONE_ID));
        }
        signalCallbacks.onSuccess(str);
    }
}
