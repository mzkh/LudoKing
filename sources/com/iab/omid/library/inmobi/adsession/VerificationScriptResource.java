package com.iab.omid.library.inmobi.adsession;

import com.iab.omid.library.inmobi.p034d.C2097e;
import java.net.URL;

public final class VerificationScriptResource {
    private final URL resourceUrl;
    private final String vendorKey;
    private final String verificationParameters;

    private VerificationScriptResource(String str, URL url, String str2) {
        this.vendorKey = str;
        this.resourceUrl = url;
        this.verificationParameters = str2;
    }

    public static VerificationScriptResource createVerificationScriptResourceWithParameters(String str, URL url, String str2) {
        C2097e.m4049a(str, "VendorKey is null or empty");
        C2097e.m4047a((Object) url, "ResourceURL is null");
        C2097e.m4049a(str2, "VerificationParameters is null or empty");
        return new VerificationScriptResource(str, url, str2);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(String str, URL url) {
        C2097e.m4049a(str, "VendorKey is null or empty");
        C2097e.m4047a((Object) url, "ResourceURL is null");
        return new VerificationScriptResource(str, url, null);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL url) {
        C2097e.m4047a((Object) url, "ResourceURL is null");
        return new VerificationScriptResource(null, url, null);
    }

    public final URL getResourceUrl() {
        return this.resourceUrl;
    }

    public final String getVendorKey() {
        return this.vendorKey;
    }

    public final String getVerificationParameters() {
        return this.verificationParameters;
    }
}
