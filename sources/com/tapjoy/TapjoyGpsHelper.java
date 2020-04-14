package com.tapjoy;

import android.content.Context;

public class TapjoyGpsHelper {

    /* renamed from: a */
    private Context f6585a;

    /* renamed from: b */
    private String f6586b;

    /* renamed from: c */
    private boolean f6587c;

    /* renamed from: d */
    private int f6588d = 0;

    /* renamed from: e */
    private int f6589e = 0;

    /* renamed from: f */
    private boolean f6590f;

    /* renamed from: g */
    private Boolean f6591g;

    /* renamed from: h */
    private Boolean f6592h;

    public TapjoyGpsHelper(Context context) {
        this.f6585a = context;
    }

    public void loadAdvertisingId(boolean z) {
        String str = "TapjoyGpsHelper";
        TapjoyLog.m6553i(str, "Looking for Google Play Services...");
        if (!isGooglePlayServicesAvailable() || !isGooglePlayManifestConfigured()) {
            TapjoyLog.m6553i(str, "Google Play Services not found");
            return;
        }
        TapjoyLog.m6553i(str, "Packaged Google Play Services found, fetching advertisingID...");
        StringBuilder sb = new StringBuilder("Packaged Google Play Services version: ");
        sb.append(this.f6589e);
        TapjoyLog.m6553i(str, sb.toString());
        TapjoyAdIdClient tapjoyAdIdClient = new TapjoyAdIdClient(this.f6585a);
        this.f6590f = tapjoyAdIdClient.setupAdIdInfo();
        try {
            this.f6588d = this.f6585a.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            StringBuilder sb2 = new StringBuilder("Device's Google Play Services version: ");
            sb2.append(this.f6588d);
            TapjoyLog.m6553i(str, sb2.toString());
        } catch (Exception unused) {
            TapjoyLog.m6553i(str, "Error getting device's Google Play Services version");
        }
        if (this.f6590f) {
            this.f6587c = tapjoyAdIdClient.isAdTrackingEnabled();
            this.f6586b = tapjoyAdIdClient.getAdvertisingId();
            StringBuilder sb3 = new StringBuilder("Found advertising ID: ");
            sb3.append(this.f6586b);
            TapjoyLog.m6553i(str, sb3.toString());
            StringBuilder sb4 = new StringBuilder("Is ad tracking enabled: ");
            sb4.append(Boolean.toString(this.f6587c));
            TapjoyLog.m6553i(str, sb4.toString());
            return;
        }
        TapjoyLog.m6553i(str, "Error getting advertisingID from Google Play Services");
        if (z) {
            this.f6587c = false;
            this.f6586b = "00000000-0000-0000-0000-000000000000";
            this.f6590f = true;
        }
    }

    public void checkGooglePlayIntegration() {
        if (!isGooglePlayServicesAvailable()) {
            throw new TapjoyIntegrationException("Tapjoy SDK is disabled because Google Play Services was not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
        } else if (!isGooglePlayManifestConfigured()) {
            throw new TapjoyIntegrationException("Failed to load manifest.xml meta-data, 'com.google.android.gms.version' not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
        }
    }

    public boolean isGooglePlayServicesAvailable() {
        if (this.f6591g == null) {
            try {
                this.f6585a.getClassLoader().loadClass("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                this.f6591g = Boolean.valueOf(true);
            } catch (Exception unused) {
                this.f6591g = Boolean.valueOf(false);
            } catch (Error unused2) {
                this.f6591g = Boolean.valueOf(false);
            }
        }
        return this.f6591g.booleanValue();
    }

    public boolean isGooglePlayManifestConfigured() {
        if (this.f6592h == null) {
            try {
                this.f6589e = this.f6585a.getPackageManager().getApplicationInfo(this.f6585a.getPackageName(), 128).metaData.getInt("com.google.android.gms.version");
                this.f6592h = Boolean.valueOf(true);
            } catch (Exception unused) {
                this.f6592h = Boolean.valueOf(false);
            }
        }
        return this.f6592h.booleanValue();
    }

    public String getAdvertisingId() {
        return this.f6586b;
    }

    public boolean isAdTrackingEnabled() {
        return this.f6587c;
    }

    public boolean isAdIdAvailable() {
        return this.f6590f;
    }

    public int getDeviceGooglePlayServicesVersion() {
        return this.f6588d;
    }

    public int getPackagedGooglePlayServicesVersion() {
        return this.f6589e;
    }
}
