package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class CustomEventServerParameters extends MediationServerParameters {
    @Parameter(name = "class_name", required = true)
    public String className;
    @Parameter(name = "label", required = true)
    public String label;
    @Parameter(name = "parameter", required = false)
    public String parameter = null;
}
