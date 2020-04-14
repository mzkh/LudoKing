package com.adcolony.sdk;

import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.facebook.AccessToken;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyAppOptions {
    public static final String ADMARVEL = "AdMarvel";
    public static final String ADMOB = "AdMob";
    public static final String ADOBEAIR = "Adobe AIR";
    public static final String AERSERVE = "AerServe";
    public static final int ALL = 2;
    public static final String APPODEAL = "Appodeal";
    public static final String COCOS2DX = "Cocos2d-x";
    public static final String CORONA = "Corona";
    public static final String FUSEPOWERED = "Fuse Powered";
    public static final String FYBER = "Fyber";
    public static final String IRONSOURCE = "ironSource";
    public static final int LANDSCAPE = 1;
    public static final String MOPUB = "MoPub";
    public static final int PORTRAIT = 0;
    @Deprecated
    public static final int SENSOR = 2;
    public static final String UNITY = "Unity";

    /* renamed from: a */
    String f97a = "";

    /* renamed from: b */
    String[] f98b;

    /* renamed from: c */
    JSONArray f99c = C0746u.m909b();

    /* renamed from: d */
    JSONObject f100d = C0746u.m892a();

    /* renamed from: e */
    AdColonyUserMetadata f101e;

    public AdColonyAppOptions() {
        setOriginStore("google");
        if (C0476a.m84b()) {
            C0666j a = C0476a.m77a();
            if (a.mo8571e()) {
                mo8081a(a.mo8567d().f97a);
                mo8082a(a.mo8567d().f98b);
            }
        }
    }

    public AdColonyAppOptions setGDPRRequired(boolean z) {
        setOption("gdpr_required", z);
        return this;
    }

    public boolean getGDPRRequired() {
        return C0746u.m918d(this.f100d, "gdpr_required");
    }

    public AdColonyAppOptions setGDPRConsentString(@NonNull String str) {
        C0746u.m902a(this.f100d, "consent_string", str);
        return this;
    }

    public String getGDPRConsentString() {
        return C0746u.m908b(this.f100d, "consent_string");
    }

    public AdColonyAppOptions setAppVersion(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setOption(TapjoyConstants.TJC_APP_VERSION_NAME, str);
        }
        return this;
    }

    public String getAppVersion() {
        return C0746u.m908b(this.f100d, TapjoyConstants.TJC_APP_VERSION_NAME);
    }

    public AdColonyAppOptions setUserID(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setOption(AccessToken.USER_ID_KEY, str);
        }
        return this;
    }

    public String getUserID() {
        return C0746u.m908b(this.f100d, AccessToken.USER_ID_KEY);
    }

    public AdColonyAppOptions setOption(@NonNull String str, boolean z) {
        if (C0543at.m325d(str)) {
            C0746u.m913b(this.f100d, str, z);
        }
        return this;
    }

    public Object getOption(@NonNull String str) {
        return C0746u.m889a(this.f100d, str);
    }

    public AdColonyAppOptions setOption(@NonNull String str, double d) {
        if (C0543at.m325d(str)) {
            C0746u.m900a(this.f100d, str, d);
        }
        return this;
    }

    public AdColonyAppOptions setOption(@NonNull String str, @NonNull String str2) {
        if (str != null && C0543at.m325d(str) && C0543at.m325d(str2)) {
            C0746u.m902a(this.f100d, str, str2);
        }
        return this;
    }

    public AdColonyAppOptions setOriginStore(@NonNull String str) {
        if (C0543at.m325d(str)) {
            setOption("origin_store", str);
        }
        return this;
    }

    public String getOriginStore() {
        return C0746u.m908b(this.f100d, "origin_store");
    }

    public AdColonyAppOptions setRequestedAdOrientation(@IntRange(from = 0, mo668to = 2) int i) {
        setOption("orientation", (double) i);
        return this;
    }

    public int getRequestedAdOrientation() {
        return C0746u.m888a(this.f100d, "orientation", -1);
    }

    public AdColonyAppOptions setAppOrientation(@IntRange(from = 0, mo668to = 2) int i) {
        setOption("app_orientation", (double) i);
        return this;
    }

    public int getAppOrientation() {
        return C0746u.m888a(this.f100d, "app_orientation", -1);
    }

    public AdColonyAppOptions setUserMetadata(@NonNull AdColonyUserMetadata adColonyUserMetadata) {
        this.f101e = adColonyUserMetadata;
        C0746u.m904a(this.f100d, "user_metadata", adColonyUserMetadata.f128c);
        return this;
    }

    public AdColonyAppOptions setTestModeEnabled(boolean z) {
        C0746u.m913b(this.f100d, "test_mode", z);
        return this;
    }

    public boolean getTestModeEnabled() {
        return C0746u.m918d(this.f100d, "test_mode");
    }

    public AdColonyAppOptions setMultiWindowEnabled(boolean z) {
        C0746u.m913b(this.f100d, "multi_window_enabled", z);
        return this;
    }

    public boolean getMultiWindowEnabled() {
        return C0746u.m918d(this.f100d, "multi_window_enabled");
    }

    public AdColonyUserMetadata getUserMetadata() {
        return this.f101e;
    }

    public AdColonyAppOptions setMediationNetwork(@NonNull String str, @NonNull String str2) {
        if (C0543at.m325d(str) && C0543at.m325d(str2)) {
            C0746u.m902a(this.f100d, "mediation_network", str);
            C0746u.m902a(this.f100d, "mediation_network_version", str2);
        }
        return this;
    }

    public JSONObject getMediationInfo() {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "name", C0746u.m908b(this.f100d, "mediation_network"));
        C0746u.m902a(a, "version", C0746u.m908b(this.f100d, "mediation_network_version"));
        return a;
    }

    public AdColonyAppOptions setPlugin(@NonNull String str, @NonNull String str2) {
        if (C0543at.m325d(str) && C0543at.m325d(str2)) {
            C0746u.m902a(this.f100d, TapjoyConstants.TJC_PLUGIN, str);
            C0746u.m902a(this.f100d, "plugin_version", str2);
        }
        return this;
    }

    public JSONObject getPluginInfo() {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "name", C0746u.m908b(this.f100d, TapjoyConstants.TJC_PLUGIN));
        C0746u.m902a(a, "version", C0746u.m908b(this.f100d, "plugin_version"));
        return a;
    }

    public AdColonyAppOptions setKeepScreenOn(boolean z) {
        C0746u.m913b(this.f100d, "keep_screen_on", z);
        return this;
    }

    public boolean getKeepScreenOn() {
        return C0746u.m918d(this.f100d, "keep_screen_on");
    }

    public static AdColonyAppOptions getMoPubAppOptions(@NonNull String str) {
        AdColonyAppOptions mediationNetwork = new AdColonyAppOptions().setMediationNetwork(MOPUB, "1.0");
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(":");
                String str2 = "AdColonyMoPub";
                if (split2.length == 2) {
                    String str3 = split2[0];
                    char c = 65535;
                    int hashCode = str3.hashCode();
                    if (hashCode != 109770977) {
                        if (hashCode == 351608024 && str3.equals("version")) {
                            c = 1;
                        }
                    } else if (str3.equals("store")) {
                        c = 0;
                    }
                    if (c == 0) {
                        mediationNetwork.setOriginStore(split2[1]);
                    } else if (c != 1) {
                        Log.e(str2, "AdColony client options in wrong format - please check your MoPub dashboard");
                        return mediationNetwork;
                    } else {
                        mediationNetwork.setAppVersion(split2[1]);
                    }
                    i++;
                } else {
                    Log.e(str2, "AdColony client options not recognized - please check your MoPub dashboard");
                    return null;
                }
            }
        }
        return mediationNetwork;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public AdColonyAppOptions mo8081a(String str) {
        if (str == null) {
            return this;
        }
        this.f97a = str;
        C0746u.m902a(this.f100d, "app_id", str);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public AdColonyAppOptions mo8082a(String... strArr) {
        if (strArr == null) {
            return this;
        }
        this.f98b = strArr;
        this.f99c = C0746u.m909b();
        for (String a : strArr) {
            C0746u.m898a(this.f99c, a);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo8083a() {
        return this.f97a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String[] mo8084b() {
        return this.f98b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public JSONArray mo8085c() {
        return this.f99c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public JSONObject mo8086d() {
        return this.f100d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8087e() {
        setOption("bundle_id", C0476a.m77a().mo8579m().mo8617H());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8088f() {
        String str = "use_forced_controller";
        if (C0746u.m924i(this.f100d, str)) {
            C0557av.f465a = C0746u.m918d(this.f100d, str);
        }
        String str2 = "use_staging_launch_server";
        if (C0746u.m924i(this.f100d, str2) && C0746u.m918d(this.f100d, str2)) {
            C0666j.f932e = "https://adc3-launch-staging.adcolony.com/v4/launch";
        }
    }
}
