package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;

public interface MaxAdapter {

    public enum InitializationStatus {
        ADAPTER_NOT_SUPPORTED(-4),
        DOES_NOT_APPLY(-3),
        INITIALIZING(-2),
        INITIALIZED_UNKNOWN(-1),
        INITIALIZED_FAILURE(0),
        INITIALIZED_SUCCESS(1);
        
        private final int code;

        private InitializationStatus(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public interface OnCompletionListener {
        void onCompletion();

        void onCompletion(InitializationStatus initializationStatus, String str);
    }

    String getAdapterVersion();

    String getSdkVersion();

    void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, OnCompletionListener onCompletionListener);

    void onDestroy();
}
