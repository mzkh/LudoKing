package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkConfiguration.ConsentDialogState;

public class SdkConfigurationImpl implements AppLovinSdkConfiguration {

    /* renamed from: a */
    private final C1192i f2088a;

    public SdkConfigurationImpl(C1192i iVar) {
        this.f2088a = iVar;
    }

    public ConsentDialogState getConsentDialogState() {
        String str = (String) this.f2088a.mo10202a(C1096c.f2520eZ);
        return "applies".equalsIgnoreCase(str) ? ConsentDialogState.APPLIES : "does_not_apply".equalsIgnoreCase(str) ? ConsentDialogState.DOES_NOT_APPLY : ConsentDialogState.UNKNOWN;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinSdkConfiguration{consentDialogState=");
        sb.append(getConsentDialogState());
        sb.append('}');
        return sb.toString();
    }
}
