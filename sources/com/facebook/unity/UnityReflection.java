package com.facebook.unity;

import android.app.Activity;
import android.util.Log;

public class UnityReflection {
    private static Class<?> unityPlayer;

    public static void SendMessage(String str, String str2, String str3) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            unityPlayer.getMethod("UnitySendMessage", new Class[]{String.class, String.class, String.class}).invoke(unityPlayer, new Object[]{str, str2, str3});
        } catch (Exception e) {
            Log.d("TODO", e.toString());
        }
    }

    public static Activity GetUnityActivity() {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            Activity activity = (Activity) unityPlayer.getField("currentActivity").get(null);
            if (activity == null) {
                Log.d(C1713FB.TAG, "Current unity activity is null");
            }
            return activity;
        } catch (Exception e) {
            Log.d(C1713FB.TAG, e.toString());
            return null;
        }
    }
}
