package com.google.ads.mediation.unity;

import android.app.Activity;
import android.util.Log;
import com.adcolony.sdk.AdColonyAppOptions;
import com.tapjoy.TapjoyConstants;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class UnitySingleton {
    private static UnitySingleton unitySingletonInstance;
    private int impressionOrdinal;
    /* access modifiers changed from: private */
    public WeakReference<UnityAdapterDelegate> mAdShowingAdapterDelegate;
    /* access modifiers changed from: private */
    public HashMap<String, WeakReference<UnityAdapterDelegate>> mPlacementsInUse = new HashMap<>();
    private int missedImpressionOrdinal;
    private UnitySingletonListener unitySingletonListenerInstance;

    private final class UnitySingletonListener implements IUnityAdsExtendedListener {
        public void onUnityAdsPlacementStateChanged(String str, PlacementState placementState, PlacementState placementState2) {
        }

        private UnitySingletonListener() {
        }

        public void onUnityAdsReady(String str) {
            if (UnitySingleton.this.mPlacementsInUse.containsKey(str) && ((WeakReference) UnitySingleton.this.mPlacementsInUse.get(str)).get() != null) {
                ((UnityAdapterDelegate) ((WeakReference) UnitySingleton.this.mPlacementsInUse.get(str)).get()).onUnityAdsReady(str);
            }
        }

        public void onUnityAdsStart(String str) {
            if (UnitySingleton.this.mAdShowingAdapterDelegate != null) {
                UnityAdapterDelegate unityAdapterDelegate = (UnityAdapterDelegate) UnitySingleton.this.mAdShowingAdapterDelegate.get();
                if (unityAdapterDelegate != null) {
                    unityAdapterDelegate.onUnityAdsStart(str);
                }
            }
        }

        public void onUnityAdsClick(String str) {
            if (UnitySingleton.this.mAdShowingAdapterDelegate != null) {
                UnityAdapterDelegate unityAdapterDelegate = (UnityAdapterDelegate) UnitySingleton.this.mAdShowingAdapterDelegate.get();
                if (unityAdapterDelegate != null) {
                    unityAdapterDelegate.onUnityAdsClick(str);
                }
            }
        }

        public void onUnityAdsFinish(String str, FinishState finishState) {
            if (UnitySingleton.this.mAdShowingAdapterDelegate != null) {
                UnityAdapterDelegate unityAdapterDelegate = (UnityAdapterDelegate) UnitySingleton.this.mAdShowingAdapterDelegate.get();
                if (unityAdapterDelegate != null) {
                    unityAdapterDelegate.onUnityAdsFinish(str, finishState);
                    UnitySingleton.this.mPlacementsInUse.remove(str);
                }
            }
        }

        public void onUnityAdsError(UnityAdsError unityAdsError, String str) {
            if (UnitySingleton.this.mPlacementsInUse.containsKey(str) && ((WeakReference) UnitySingleton.this.mPlacementsInUse.get(str)).get() != null) {
                ((UnityAdapterDelegate) ((WeakReference) UnitySingleton.this.mPlacementsInUse.get(str)).get()).onUnityAdsError(unityAdsError, str);
                UnitySingleton.this.mPlacementsInUse.remove(str);
            }
        }
    }

    public static UnitySingleton getInstance() {
        if (unitySingletonInstance == null) {
            unitySingletonInstance = new UnitySingleton();
        }
        return unitySingletonInstance;
    }

    private UnitySingleton() {
    }

    private UnitySingletonListener getUnitySingletonListenerInstance() {
        if (this.unitySingletonListenerInstance == null) {
            this.unitySingletonListenerInstance = new UnitySingletonListener();
        }
        return this.unitySingletonListenerInstance;
    }

    public boolean initializeUnityAds(Activity activity, String str) {
        if (!UnityAds.isSupported()) {
            Log.w(UnityAdapter.TAG, "The current device is not supported by Unity Ads.");
            return false;
        } else if (UnityAds.isInitialized()) {
            return true;
        } else {
            MediationMetaData mediationMetaData = new MediationMetaData(activity);
            mediationMetaData.setName(AdColonyAppOptions.ADMOB);
            mediationMetaData.setVersion(BuildConfig.VERSION_NAME);
            mediationMetaData.set(TapjoyConstants.TJC_ADAPTER_VERSION, "3.3.0");
            mediationMetaData.commit();
            UnityAds.initialize(activity, str, unitySingletonInstance.getUnitySingletonListenerInstance(), false, true);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void loadAd(UnityAdapterDelegate unityAdapterDelegate) {
        UnityAds.load(unityAdapterDelegate.getPlacementId());
        if (UnityAds.isInitialized()) {
            if (!this.mPlacementsInUse.containsKey(unityAdapterDelegate.getPlacementId()) || ((WeakReference) this.mPlacementsInUse.get(unityAdapterDelegate.getPlacementId())).get() == null) {
                this.mPlacementsInUse.put(unityAdapterDelegate.getPlacementId(), new WeakReference(unityAdapterDelegate));
                if (UnityAds.isReady(unityAdapterDelegate.getPlacementId())) {
                    unityAdapterDelegate.onUnityAdsReady(unityAdapterDelegate.getPlacementId());
                }
            } else {
                String str = UnityMediationAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("An ad is already loading for placement ID: ");
                sb.append(unityAdapterDelegate.getPlacementId());
                Log.e(str, sb.toString());
                unityAdapterDelegate.onUnityAdsError(UnityAdsError.INTERNAL_ERROR, unityAdapterDelegate.getPlacementId());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showAd(UnityAdapterDelegate unityAdapterDelegate, Activity activity) {
        this.mAdShowingAdapterDelegate = new WeakReference<>(unityAdapterDelegate);
        if (UnityAds.isReady(unityAdapterDelegate.getPlacementId())) {
            MediationMetaData mediationMetaData = new MediationMetaData(activity);
            int i = this.impressionOrdinal + 1;
            this.impressionOrdinal = i;
            mediationMetaData.setOrdinal(i);
            mediationMetaData.commit();
            UnityAds.show(activity, unityAdapterDelegate.getPlacementId());
            return;
        }
        MediationMetaData mediationMetaData2 = new MediationMetaData(activity);
        int i2 = this.missedImpressionOrdinal + 1;
        this.missedImpressionOrdinal = i2;
        mediationMetaData2.setMissedImpressionOrdinal(i2);
        mediationMetaData2.commit();
    }
}
