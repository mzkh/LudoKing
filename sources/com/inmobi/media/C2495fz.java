package com.inmobi.media;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fz */
/* compiled from: CatchEvent */
public final class C2495fz extends C2469ff {

    /* renamed from: g */
    private static final String f5474g = C2504gc.class.getSimpleName();

    public C2495fz(Throwable th) {
        super("crashReporting", "catchEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", th.getClass().getSimpleName());
            jSONObject.put("message", th.getMessage());
            jSONObject.put("stack", Log.getStackTraceString(th));
            jSONObject.put("thread", Thread.currentThread().getName());
            this.f5377f = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }
}
