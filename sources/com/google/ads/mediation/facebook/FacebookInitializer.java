package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.AudienceNetworkAds.InitListener;
import com.facebook.ads.AudienceNetworkAds.InitResult;
import java.util.ArrayList;
import java.util.Iterator;

class FacebookInitializer implements InitListener {
    private static FacebookInitializer instance;
    private boolean mIsInitialized = false;
    private boolean mIsInitializing = false;
    private ArrayList<Listener> mListeners = new ArrayList<>();

    interface Listener {
        void onInitializeError(String str);

        void onInitializeSuccess();
    }

    static FacebookInitializer getInstance() {
        if (instance == null) {
            instance = new FacebookInitializer();
        }
        return instance;
    }

    private FacebookInitializer() {
    }

    /* access modifiers changed from: 0000 */
    public void initialize(Context context, String str, Listener listener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        getInstance().initialize(context, arrayList, listener);
    }

    /* access modifiers changed from: 0000 */
    public void initialize(Context context, ArrayList<String> arrayList, Listener listener) {
        if (this.mIsInitializing) {
            this.mListeners.add(listener);
        } else if (this.mIsInitialized) {
            listener.onInitializeSuccess();
        } else {
            this.mIsInitializing = true;
            getInstance().mListeners.add(listener);
            AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:5.6.0.0").withPlacementIds(arrayList).withInitListener(this).initialize();
        }
    }

    public void onInitialized(InitResult initResult) {
        this.mIsInitializing = false;
        this.mIsInitialized = initResult.isSuccess();
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            Listener listener = (Listener) it.next();
            if (initResult.isSuccess()) {
                listener.onInitializeSuccess();
            } else {
                listener.onInitializeError(initResult.getMessage());
            }
        }
        this.mListeners.clear();
    }
}
