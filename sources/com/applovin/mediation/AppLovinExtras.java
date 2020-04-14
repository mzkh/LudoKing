package com.applovin.mediation;

import android.os.Bundle;

public class AppLovinExtras {

    public static class Builder {
        private boolean mMuteAudio;

        public Builder setMuteAudio(boolean z) {
            this.mMuteAudio = z;
            return this;
        }

        public Bundle build() {
            Bundle bundle = new Bundle(1);
            bundle.putBoolean("mute_audio", this.mMuteAudio);
            return bundle;
        }
    }

    static class Keys {
        static final String MUTE_AUDIO = "mute_audio";

        Keys() {
        }
    }
}
