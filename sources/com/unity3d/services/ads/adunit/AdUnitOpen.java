package com.unity3d.services.ads.adunit;

import android.os.ConditionVariable;
import com.unity3d.ads.properties.AdsProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class AdUnitOpen {
    private static ConditionVariable _waitShowStatus;

    public static synchronized boolean open(String str, JSONObject jSONObject) throws NoSuchMethodException {
        boolean block;
        synchronized (AdUnitOpen.class) {
            Method method = AdUnitOpen.class.getMethod("showCallback", new Class[]{CallbackStatus.class});
            _waitShowStatus = new ConditionVariable();
            WebViewApp.getCurrentApp().invokeMethod("webview", "show", method, str, jSONObject);
            block = _waitShowStatus.block((long) AdsProperties.getShowTimeout());
            _waitShowStatus = null;
        }
        return block;
    }

    public static void showCallback(CallbackStatus callbackStatus) {
        if (_waitShowStatus != null && callbackStatus.equals(CallbackStatus.OK)) {
            _waitShowStatus.open();
        }
    }
}
