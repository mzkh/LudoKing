package com.google.unity.mediation.adcolony;

import android.os.Bundle;
import com.google.unity.ads.AdNetworkExtras;
import com.jirbo.adcolony.AdColonyAdapter;
import com.jirbo.adcolony.AdColonyBundleBuilder;
import java.util.HashMap;

public class AdColonyUnityExtrasBuilder implements AdNetworkExtras {
    private static final String KEY_GDPR_CONSENT_STRING = "gdpr_consent_string";
    private static final String KEY_GDPR_REQUIRED = "gdpr_required";
    private static final String KEY_SHOW_POST_POPUP = "show_post_popup";
    private static final String KEY_SHOW_PRE_POPUP = "show_pre_popup";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_ZONE_ID = "zone_id";

    public Bundle buildExtras(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get("zone_id");
        if (str != null) {
            AdColonyBundleBuilder.setZoneId(str);
        }
        String str2 = (String) hashMap.get("user_id");
        if (str2 != null) {
            AdColonyBundleBuilder.setUserId(str2);
        }
        String str3 = (String) hashMap.get(KEY_SHOW_PRE_POPUP);
        if (str3 != null) {
            AdColonyBundleBuilder.setShowPostPopup(Boolean.valueOf(str3).booleanValue());
        }
        String str4 = (String) hashMap.get(KEY_SHOW_POST_POPUP);
        if (str4 != null) {
            AdColonyBundleBuilder.setShowPostPopup(Boolean.valueOf(str4).booleanValue());
        }
        String str5 = (String) hashMap.get(KEY_GDPR_REQUIRED);
        if (str5 != null) {
            AdColonyBundleBuilder.setGdprRequired(Boolean.valueOf(str5).booleanValue());
        }
        String str6 = (String) hashMap.get(KEY_GDPR_CONSENT_STRING);
        if (str6 != null) {
            AdColonyBundleBuilder.setGdprConsentString(str6);
        }
        return AdColonyBundleBuilder.build();
    }

    public Class getAdapterClass() {
        return AdColonyAdapter.class;
    }
}
