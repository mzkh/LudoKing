package com.appsflyer;

import android.content.Context;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerUnityHelper {
    private static String TAG = "AppsFlyerUnityHelper";

    public static void createConversionDataListener(Context context, final String str) {
        AppsFlyerLib.getInstance().registerConversionListener(context, new AppsFlyerConversionListener() {
            public void onConversionDataSuccess(Map<String, Object> map) {
                String str = "didReceiveConversionData";
                UnityPlayer.UnitySendMessage(str, str, new JSONObject(map).toString());
            }

            public void onConversionDataFail(String str) {
                UnityPlayer.UnitySendMessage(str, "didReceiveConversionDataWithError", str);
            }

            public void onAppOpenAttribution(Map<String, String> map) {
                String str = "onAppOpenAttribution";
                UnityPlayer.UnitySendMessage(str, str, new JSONObject(map).toString());
            }

            public void onAttributionFailure(String str) {
                UnityPlayer.UnitySendMessage(str, "onAppOpenAttributionFailure", str);
            }
        });
    }

    public static void createValidateInAppListener(Context context, final String str, final String str2, final String str3) {
        AppsFlyerLib.getInstance().registerValidatorListener(context, new AppsFlyerInAppPurchaseValidatorListener() {
            public void onValidateInApp() {
                Log.i("AppsFlyerLibUnityhelper", "onValidateInApp called.");
                UnityPlayer.UnitySendMessage(str, str2, "Validate success");
            }

            public void onValidateInAppFailure(String str) {
                Log.i("AppsFlyerLibUnityhelper", "onValidateInAppFailure called.");
                UnityPlayer.UnitySendMessage(str, str3, str);
            }
        });
    }
}
