package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class MediationConfiguration {
    private final Bundle zzeik;
    private final AdFormat zzeio;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzeio = adFormat;
        this.zzeik = bundle;
    }

    public AdFormat getFormat() {
        return this.zzeio;
    }

    public Bundle getServerParameters() {
        return this.zzeik;
    }
}
