package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p028d.C2049e;
import java.net.URL;

public final class VerificationScriptResource {

    /* renamed from: a */
    private final String f3991a;

    /* renamed from: b */
    private final URL f3992b;

    /* renamed from: c */
    private final String f3993c;

    private VerificationScriptResource(String str, URL url, String str2) {
        this.f3991a = str;
        this.f3992b = url;
        this.f3993c = str2;
    }

    public static VerificationScriptResource createVerificationScriptResourceWithParameters(String str, URL url, String str2) {
        C2049e.m3843a(str, "VendorKey is null or empty");
        C2049e.m3841a((Object) url, "ResourceURL is null");
        C2049e.m3843a(str2, "VerificationParameters is null or empty");
        return new VerificationScriptResource(str, url, str2);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(String str, URL url) {
        C2049e.m3843a(str, "VendorKey is null or empty");
        C2049e.m3841a((Object) url, "ResourceURL is null");
        return new VerificationScriptResource(str, url, null);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL url) {
        C2049e.m3841a((Object) url, "ResourceURL is null");
        return new VerificationScriptResource(null, url, null);
    }

    public URL getResourceUrl() {
        return this.f3992b;
    }

    public String getVendorKey() {
        return this.f3991a;
    }

    public String getVerificationParameters() {
        return this.f3993c;
    }
}
