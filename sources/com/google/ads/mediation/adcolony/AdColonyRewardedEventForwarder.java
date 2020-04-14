package com.google.ads.mediation.adcolony;

import androidx.annotation.NonNull;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class AdColonyRewardedEventForwarder extends AdColonyInterstitialListener implements AdColonyRewardListener {
    private static AdColonyRewardedEventForwarder instance;
    private static HashMap<String, WeakReference<AdColonyRewardedRenderer>> mListeners;

    static AdColonyRewardedEventForwarder getInstance() {
        if (instance == null) {
            instance = new AdColonyRewardedEventForwarder();
        }
        return instance;
    }

    private AdColonyRewardedEventForwarder() {
        mListeners = new HashMap<>();
        AdColony.setRewardListener(this);
    }

    /* access modifiers changed from: 0000 */
    public void addListener(@NonNull String str, @NonNull AdColonyRewardedRenderer adColonyRewardedRenderer) {
        mListeners.put(str, new WeakReference(adColonyRewardedRenderer));
    }

    /* access modifiers changed from: 0000 */
    public boolean isListenerAvailable(@NonNull String str) {
        return mListeners.containsKey(str) && ((WeakReference) mListeners.get(str)).get() != null;
    }

    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onRequestFilled(adColonyInterstitial);
        }
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        String zoneID = adColonyZone.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onRequestNotFilled(adColonyZone);
            mListeners.remove(zoneID);
        }
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onExpiring(adColonyInterstitial);
        }
    }

    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onClicked(adColonyInterstitial);
        }
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onOpened(adColonyInterstitial);
        }
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onLeftApplication(adColonyInterstitial);
        }
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onClosed(adColonyInterstitial);
            mListeners.remove(zoneID);
        }
    }

    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
        String zoneID = adColonyInterstitial.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onIAPEvent(adColonyInterstitial, str, i);
        }
    }

    public void onReward(AdColonyReward adColonyReward) {
        String zoneID = adColonyReward.getZoneID();
        if (isListenerAvailable(zoneID)) {
            ((AdColonyRewardedRenderer) ((WeakReference) mListeners.get(zoneID)).get()).onReward(adColonyReward);
        }
    }
}
