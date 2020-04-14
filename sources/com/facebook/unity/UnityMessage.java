package com.facebook.unity;

import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UnityMessage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String methodName;
    private Map<String, Serializable> params = new HashMap();

    public UnityMessage(String str) {
        this.methodName = str;
    }

    public UnityMessage put(String str, Serializable serializable) {
        this.params.put(str, serializable);
        return this;
    }

    public UnityMessage putCancelled() {
        put(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, Boolean.valueOf(true));
        return this;
    }

    public UnityMessage putID(String str) {
        put("id", str);
        return this;
    }

    public void sendError(String str) {
        put("error", str);
        send();
    }

    public void send() {
        String unityParams = new UnityParams(this.params).toString();
        String str = C1713FB.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("sending to Unity ");
        sb.append(this.methodName);
        sb.append("(");
        sb.append(unityParams);
        sb.append(")");
        Log.v(str, sb.toString());
        try {
            UnityReflection.SendMessage("UnityFacebookSDKPlugin", this.methodName, unityParams);
        } catch (UnsatisfiedLinkError unused) {
            Log.v(C1713FB.TAG, "message not send, Unity not initialized");
        }
    }

    public static UnityMessage createWithCallbackFromParams(String str, UnityParams unityParams) {
        UnityMessage unityMessage = new UnityMessage(str);
        String str2 = Constants.CALLBACK_ID_KEY;
        if (unityParams.hasString(str2).booleanValue()) {
            unityMessage.put(str2, unityParams.getString(str2));
        }
        return unityMessage;
    }
}
