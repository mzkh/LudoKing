package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyUserMetadata;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.ads.mediation.adcolony.AdColonyMediationAdapter;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class AdColonyManager {
    private static final String TAG = AdColonyAdapter.class.getSimpleName();
    private static AdColonyManager _instance = null;
    private ArrayList<String> configuredZones = new ArrayList<>();
    private boolean isConfigured = false;

    private AdColonyManager() {
    }

    public static AdColonyManager getInstance() {
        if (_instance == null) {
            _instance = new AdColonyManager();
        }
        return _instance;
    }

    private boolean configureAdColony(Context context, AdColonyAppOptions adColonyAppOptions, String str, ArrayList<String> arrayList) {
        boolean z;
        boolean z2 = context instanceof Activity;
        if (!z2 && !(context instanceof Application)) {
            Log.w(TAG, "Context must be of type Activity or Application.");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "A valid appId wasn't provided.");
            return false;
        } else if (arrayList == null || arrayList.isEmpty()) {
            Log.w(TAG, "No zones provided to request ad.");
            return false;
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!this.configuredZones.contains(str2)) {
                    this.configuredZones.add(str2);
                    this.isConfigured = false;
                }
            }
            if (this.isConfigured) {
                AdColony.setAppOptions(adColonyAppOptions);
            } else {
                String[] strArr = (String[]) this.configuredZones.toArray(new String[0]);
                adColonyAppOptions.setMediationNetwork(AdColonyAppOptions.ADMOB, BuildConfig.VERSION_NAME);
                if (z2) {
                    z = AdColony.configure((Activity) context, adColonyAppOptions, str, strArr);
                } else {
                    z = AdColony.configure((Application) context, adColonyAppOptions, str, strArr);
                }
                this.isConfigured = z;
            }
            return this.isConfigured;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean configureAdColony(Context context, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        return configureAdColony(context, buildAppOptions(mediationAdRequest), bundle.getString("app_id"), parseZoneList(bundle));
    }

    public boolean configureAdColony(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        Context context = mediationRewardedAdConfiguration.getContext();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        return configureAdColony(context, buildAppOptions(mediationRewardedAdConfiguration), serverParameters.getString("app_id"), parseZoneList(serverParameters));
    }

    private AdColonyAppOptions buildAppOptions(MediationAdRequest mediationAdRequest) {
        AdColonyAppOptions appOptions = AdColonyMediationAdapter.getAppOptions();
        if (mediationAdRequest != null) {
            if (mediationAdRequest.isTesting()) {
                appOptions.setTestModeEnabled(true);
            }
            AdColonyUserMetadata adColonyUserMetadata = new AdColonyUserMetadata();
            int gender = mediationAdRequest.getGender();
            if (gender == 2) {
                adColonyUserMetadata.setUserGender(AdColonyUserMetadata.USER_FEMALE);
            } else if (gender == 1) {
                adColonyUserMetadata.setUserGender(AdColonyUserMetadata.USER_MALE);
            }
            Location location = mediationAdRequest.getLocation();
            if (location != null) {
                adColonyUserMetadata.setUserLocation(location);
            }
            Date birthday = mediationAdRequest.getBirthday();
            if (birthday != null) {
                long currentTimeMillis = System.currentTimeMillis() - birthday.getTime();
                if (currentTimeMillis > 0) {
                    adColonyUserMetadata.setUserAge((int) ((currentTimeMillis / 86400000) / 365));
                }
            }
            appOptions.setUserMetadata(adColonyUserMetadata);
        }
        return appOptions;
    }

    private AdColonyAppOptions buildAppOptions(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        AdColonyAppOptions appOptions = AdColonyMediationAdapter.getAppOptions();
        if (mediationRewardedAdConfiguration.isTestRequest()) {
            appOptions.setTestModeEnabled(true);
        }
        AdColonyUserMetadata adColonyUserMetadata = new AdColonyUserMetadata();
        Location location = mediationRewardedAdConfiguration.getLocation();
        if (location != null) {
            adColonyUserMetadata.setUserLocation(location);
        }
        appOptions.setUserMetadata(adColonyUserMetadata);
        return appOptions;
    }

    public ArrayList<String> parseZoneList(Bundle bundle) {
        String str;
        if (bundle != null) {
            String str2 = AdColonyAdapterUtils.KEY_ZONE_IDS;
            if (bundle.getString(str2) != null) {
                str = bundle.getString(str2);
            } else {
                str = bundle.getString(AdColonyAdapterUtils.KEY_ZONE_ID);
            }
            if (str != null) {
                return new ArrayList<>(Arrays.asList(str.split(";")));
            }
        }
        return null;
    }

    public String getZoneFromRequest(ArrayList<String> arrayList, Bundle bundle) {
        String str = (arrayList == null || arrayList.isEmpty()) ? null : (String) arrayList.get(0);
        if (bundle == null) {
            return str;
        }
        String str2 = AdColonyAdapterUtils.KEY_ZONE_ID;
        return bundle.getString(str2) != null ? bundle.getString(str2) : str;
    }
}
