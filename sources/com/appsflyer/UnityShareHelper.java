package com.appsflyer;

import android.content.Context;
import android.util.Log;
import com.appsflyer.CreateOneLinkHttpTask.ResponseListener;
import com.appsflyer.share.CrossPromotionHelper;
import com.appsflyer.share.LinkGenerator;
import com.appsflyer.share.ShareInviteHelper;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UnityShareHelper {
    /* access modifiers changed from: private */
    public static String callbackMethodFailedName;
    /* access modifiers changed from: private */
    public static String callbackMethodName;
    /* access modifiers changed from: private */
    public static String callbackObjectName;
    private static UnityShareHelper instance;

    private class inviteCallbacksImpl implements ResponseListener {
        private inviteCallbacksImpl() {
        }

        public void onResponse(String str) {
            Log.i("AppsFlyerLibUnityhelper", "CreateOneLinkHttpTask.ResponseListener called.");
            UnityPlayer.UnitySendMessage(UnityShareHelper.callbackObjectName, UnityShareHelper.callbackMethodName, str);
        }

        public void onResponseError(String str) {
            Log.i("AppsFlyerLibUnityhelper", "onValidateInAppFailure called.");
            UnityPlayer.UnitySendMessage(UnityShareHelper.callbackObjectName, UnityShareHelper.callbackMethodFailedName, str);
        }
    }

    public static UnityShareHelper getInstance() {
        UnityShareHelper unityShareHelper = instance;
        if (unityShareHelper != null) {
            return unityShareHelper;
        }
        instance = new UnityShareHelper();
        return instance;
    }

    public void trackAndOpenStore(Context context, String str, String str2, Map<String, Object> map) {
        if (str2 != null && str != null) {
            if (map != null) {
                HashMap hashMap = new HashMap();
                for (Entry entry : map.entrySet()) {
                    if (!(entry.getKey().toString() == null || entry.getValue().toString() == null)) {
                        hashMap.put(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
                CrossPromotionHelper.trackAndOpenStore(context, str, str2, hashMap);
                return;
            }
            CrossPromotionHelper.trackAndOpenStore(context, str, str2);
        }
    }

    public void createOneLinkInviteListener(Context context, Map<String, Object> map, String str, String str2, String str3) {
        callbackObjectName = str;
        callbackMethodName = str2;
        callbackMethodFailedName = str3;
        LinkGenerator generateInviteUrl = ShareInviteHelper.generateInviteUrl(context);
        String str4 = AppsFlyerProperties.CHANNEL;
        Object obj = map.get(str4);
        String str5 = Param.CAMPAIGN;
        Object obj2 = map.get(str5);
        String str6 = "referrerName";
        Object obj3 = map.get(str6);
        String str7 = "referrerImageUrl";
        Object obj4 = map.get(str7);
        String str8 = "customerID";
        Object obj5 = map.get(str8);
        String str9 = "baseDeepLink";
        Object obj6 = map.get(str9);
        if (obj != null) {
            generateInviteUrl.setChannel(obj.toString());
            map.remove(str4);
        }
        if (obj2 != null) {
            generateInviteUrl.setCampaign(obj2.toString());
            map.remove(str5);
        }
        if (obj3 != null) {
            generateInviteUrl.setReferrerName(obj3.toString());
            map.remove(str6);
        }
        if (obj4 != null) {
            generateInviteUrl.setReferrerImageURL(obj4.toString());
            map.remove(str7);
        }
        if (obj5 != null) {
            generateInviteUrl.setReferrerCustomerId(obj5.toString());
            map.remove(str8);
        }
        if (obj6 != null) {
            generateInviteUrl.setBaseDeeplink(obj6.toString());
            map.remove(str9);
        }
        for (Entry entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                generateInviteUrl.addParameter(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        generateInviteUrl.generateLink(context, new inviteCallbacksImpl());
    }
}
