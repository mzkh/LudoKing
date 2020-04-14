package com.facebook.ads.internal.bridge.fbsdk;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;

@Keep
public class FBLoginASID {
    @SuppressLint({"CatchGeneralException"})
    @Nullable
    public static String getFBLoginASID() {
        String str = "com.facebook.AccessToken";
        try {
            Object invoke = Class.forName(str).getDeclaredMethod("getCurrentAccessToken", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                return (String) Class.forName(str).getDeclaredMethod("getUserId", new Class[0]).invoke(invoke, new Object[0]);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
