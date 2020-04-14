package com.tapjoy;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.reflect.Method;

public class TapjoyAdIdClient {

    /* renamed from: a */
    private Context f6446a;

    /* renamed from: b */
    private String f6447b;

    /* renamed from: c */
    private boolean f6448c;

    public TapjoyAdIdClient(Context context) {
        this.f6446a = context;
    }

    public boolean setupAdIdInfo() {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f6446a);
            this.f6447b = advertisingIdInfo.getId();
            this.f6448c = !advertisingIdInfo.isLimitAdTrackingEnabled();
            return true;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public boolean setupAdIdInfoReflection() {
        try {
            Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Method method = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
            StringBuilder sb = new StringBuilder("Found method: ");
            sb.append(method);
            TapjoyLog.m6550d("TapjoyAdIdClient", sb.toString());
            Object invoke = method.invoke(cls, new Object[]{this.f6446a});
            Method method2 = invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
            Method method3 = invoke.getClass().getMethod("getId", new Class[0]);
            this.f6448c = !((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
            this.f6447b = (String) method3.invoke(invoke, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String getAdvertisingId() {
        return this.f6447b;
    }

    public boolean isAdTrackingEnabled() {
        return this.f6448c;
    }
}
