package com.adcolony.sdk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class AdColonyEventTracker {
    public static final String CUSTOM_EVENT_1 = "ADCT_CUSTOM_EVENT_1";
    public static final String CUSTOM_EVENT_2 = "ADCT_CUSTOM_EVENT_2";
    public static final String CUSTOM_EVENT_3 = "ADCT_CUSTOM_EVENT_3";
    public static final String CUSTOM_EVENT_4 = "ADCT_CUSTOM_EVENT_4";
    public static final String CUSTOM_EVENT_5 = "ADCT_CUSTOM_EVENT_5";
    public static final String LOGIN_DEFAULT = "ADCT_DEFAULT_LOGIN";
    public static final String LOGIN_FACEBOOK = "ADCT_FACEBOOK_LOGIN";
    public static final String LOGIN_GOOGLE = "ADCT_GOOGLE_LOGIN";
    public static final String LOGIN_LINKEDIN = "ADCT_LINKEDIN_LOGIN";
    public static final String LOGIN_OPENID = "ADCT_OPENID_LOGIN";
    public static final String LOGIN_TWITTER = "ADCT_TWITTER_LOGIN";
    public static final String REGISTRATION_CUSTOM = "ADCT_CUSTOM_REGISTRATION";
    public static final String REGISTRATION_DEFAULT = "ADCT_DEFAULT_REGISTRATION";
    public static final String REGISTRATION_FACEBOOK = "ADCT_FACEBOOK_REGISTRATION";
    public static final String REGISTRATION_GOOGLE = "ADCT_GOOGLE_REGISTRATION";
    public static final String REGISTRATION_LINKEDIN = "ADCT_LINKEDIN_REGISTRATION";
    public static final String REGISTRATION_OPENID = "ADCT_OPENID_REGISTRATION";
    public static final String REGISTRATION_TWITTER = "ADCT_TWITTER_REGISTRATION";
    public static final String SOCIAL_SHARING_CUSTOM = "ADCT_CUSTOM_SHARING";
    public static final String SOCIAL_SHARING_FACEBOOK = "ADCT_FACEBOOK_SHARING";
    public static final String SOCIAL_SHARING_FLICKR = "ADCT_FLICKR_SHARING";
    public static final String SOCIAL_SHARING_FOURSQUARE = "ADCT_FOURSQUARE_SHARING";
    public static final String SOCIAL_SHARING_GOOGLE = "ADCT_GOOGLE_SHARING";
    public static final String SOCIAL_SHARING_INSTAGRAM = "ADCT_INSTAGRAM_SHARING";
    public static final String SOCIAL_SHARING_LINKEDIN = "ADCT_LINKEDIN_SHARING";
    public static final String SOCIAL_SHARING_PINTEREST = "ADCT_PINTEREST_SHARING";
    public static final String SOCIAL_SHARING_SNAPCHAT = "ADCT_SNAPCHAT_SHARING";
    public static final String SOCIAL_SHARING_TUMBLR = "ADCT_TUMBLR_SHARING";
    public static final String SOCIAL_SHARING_TWITTER = "ADCT_TWITTER_SHARING";
    public static final String SOCIAL_SHARING_VIMEO = "ADCT_VIMEO_SHARING";
    public static final String SOCIAL_SHARING_VINE = "ADCT_VINE_SHARING";
    public static final String SOCIAL_SHARING_YOUTUBE = "ADCT_YOUTUBE_SHARING";

    /* renamed from: a */
    private static final List<JSONObject> f105a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private static final int f106b = 200;

    /* renamed from: a */
    static void m39a(JSONObject jSONObject) {
        synchronized (f105a) {
            if (200 > f105a.size()) {
                f105a.add(jSONObject);
            }
        }
    }

    /* renamed from: a */
    static void m38a() {
        if (!C0666j.m637C().equals("")) {
            synchronized (f105a) {
                for (JSONObject b : f105a) {
                    m41b(b);
                }
                f105a.clear();
            }
        }
    }

    /* renamed from: b */
    static boolean m42b() {
        boolean z;
        synchronized (f105a) {
            z = f105a.size() != 0;
        }
        return z;
    }

    public static void logTransaction(@Nullable String str, @Nullable Integer num, @Nullable Double d, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        if (!m40a(str5, "logTransaction")) {
            if (str2 == null || str2.length() == 3) {
                HashMap hashMap = new HashMap();
                hashMap.put(Param.ITEM_ID, str);
                hashMap.put(Param.QUANTITY, String.valueOf(num));
                hashMap.put("price", String.valueOf(d));
                hashMap.put("currency_code", str2);
                hashMap.put(TransactionDetailsUtilities.RECEIPT, str3);
                hashMap.put("store", str4);
                hashMap.put("description", str5);
                logEvent("transaction", hashMap);
                return;
            }
            new C0749a().mo8726a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").mo8728a(C0748w.f1171g);
        }
    }

    public static void logCreditsSpent(@Nullable String str, @Nullable Integer num, @Nullable Double d, @Nullable String str2) {
        if (str2 == null || str2.length() == 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put(Param.QUANTITY, String.valueOf(num));
            hashMap.put("value", String.valueOf(d));
            hashMap.put("currency_code", str2);
            logEvent("credits_spent", hashMap);
            return;
        }
        new C0749a().mo8726a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").mo8728a(C0748w.f1171g);
    }

    public static void logPaymentInfoAdded() {
        logEvent("payment_info_added");
    }

    public static void logAchievementUnlocked(@Nullable String str) {
        if (!m40a(str, "logAchievementUnlocked")) {
            HashMap hashMap = new HashMap();
            hashMap.put("description", str);
            logEvent("achievement_unlocked", hashMap);
        }
    }

    public static void logLevelAchieved(@Nullable Integer num) {
        HashMap hashMap = new HashMap();
        String str = "level_achieved";
        hashMap.put(str, String.valueOf(num));
        logEvent(str, hashMap);
    }

    public static void logAppRated() {
        logEvent("app_rated");
    }

    public static void logActivated() {
        logEvent("activated");
    }

    public static void logTutorialCompleted() {
        logEvent("tutorial_completed");
    }

    public static void logSocialSharingEvent(@Nullable String str, @Nullable String str2) {
        if (!m40a(str2, "logSocialSharingEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put("network", str);
            hashMap.put("description", str2);
            logEvent("social_sharing_event", hashMap);
        }
    }

    public static void logRegistrationCompleted(@Nullable String str, @Nullable String str2) {
        if (!m40a(str2, "logRegistrationCompleted")) {
            HashMap hashMap = new HashMap();
            hashMap.put("method", str);
            hashMap.put("description", str2);
            logEvent("registration_completed", hashMap);
        }
    }

    public static void logCustomEvent(@Nullable String str, @Nullable String str2) {
        if (!m40a(str2, "logCustomEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", str);
            hashMap.put("description", str2);
            logEvent("custom_event", hashMap);
        }
    }

    public static void logAddToCart(@Nullable String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Param.ITEM_ID, str);
        logEvent(Event.ADD_TO_CART, hashMap);
    }

    public static void logAddToWishlist(@Nullable String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Param.ITEM_ID, str);
        logEvent(Event.ADD_TO_WISHLIST, hashMap);
    }

    public static void logCheckoutInitiated() {
        logEvent("checkout_initiated");
    }

    public static void logContentView(@Nullable String str, @Nullable String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppLovinEventParameters.CONTENT_IDENTIFIER, str);
        hashMap.put(Param.CONTENT_TYPE, str2);
        logEvent("content_view", hashMap);
    }

    public static void logInvite() {
        logEvent(AppLovinEventTypes.USER_SENT_INVITATION);
    }

    public static void logLogin(@Nullable String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", str);
        logEvent("login", hashMap);
    }

    public static void logReservation() {
        logEvent(AppLovinEventTypes.USER_CREATED_RESERVATION);
    }

    public static void logSearch(@Nullable String str) {
        if (str == null || str.length() <= 512) {
            HashMap hashMap = new HashMap();
            hashMap.put("search_string", str);
            logEvent("search", hashMap);
            return;
        }
        new C0749a().mo8726a("logSearch searchString cannot exceed 512 characters. Event will ").mo8726a("not be sent.").mo8728a(C0748w.f1171g);
    }

    public static void logEvent(@Nullable String str) {
        logEvent(str, null);
    }

    public static void logEvent(@NonNull String str, @Nullable HashMap<String, String> hashMap) {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "event_name", str);
        JSONObject a2 = C0746u.m892a();
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                if (entry.getValue() != null && !((String) entry.getValue()).equals("null")) {
                    C0746u.m902a(a2, (String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m44d(a2);
        C0746u.m904a(a, MessengerShareContentUtility.ATTACHMENT_PAYLOAD, a2);
        m41b(a);
    }

    /* renamed from: b */
    private static void m41b(JSONObject jSONObject) {
        C0476a.m77a();
        if (C0666j.m637C().equals("")) {
            m39a(jSONObject);
            return;
        }
        m43c(jSONObject);
        new C0480ab("AdColony.log_event", 1, jSONObject).mo8217b();
    }

    /* renamed from: c */
    private static void m43c(JSONObject jSONObject) {
        String str = MessengerShareContentUtility.ATTACHMENT_PAYLOAD;
        JSONObject f = C0746u.m921f(jSONObject, str);
        boolean z = C0557av.f465a;
        String str2 = TapjoyConstants.TJC_API_KEY;
        if (z) {
            C0746u.m902a(f, str2, "bb2cf0647ba654d7228dd3f9405bbc6a");
        } else {
            C0746u.m902a(f, str2, C0666j.m637C());
        }
        try {
            jSONObject.remove(str);
            jSONObject.put(str, f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private static void m44d(JSONObject jSONObject) {
        C0746u.m902a(jSONObject, TapjoyConstants.TJC_DEVICE_TIMEZONE, TimeZone.getDefault().getID());
        C0746u.m902a(jSONObject, "action_time", String.valueOf(Math.round((float) (System.currentTimeMillis() / 1000))));
    }

    /* renamed from: a */
    private static boolean m40a(String str, String str2) {
        if (str == null || str.length() <= 512) {
            return false;
        }
        new C0749a().mo8726a("Description of event ").mo8726a(str2).mo8726a(" must be less").mo8726a(" than 512 characters").mo8728a(C0748w.f1171g);
        return true;
    }
}
