package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.C0898a;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import java.util.Collections;
import java.util.List;

public final class AppLovinCommunicator {

    /* renamed from: a */
    private static AppLovinCommunicator f1214a;

    /* renamed from: b */
    private static final Object f1215b = new Object();

    /* renamed from: c */
    private C1192i f1216c;

    /* renamed from: d */
    private final C0898a f1217d;

    /* renamed from: e */
    private final MessagingServiceImpl f1218e;

    private AppLovinCommunicator(Context context) {
        this.f1217d = new C0898a(context);
        this.f1218e = new MessagingServiceImpl(context);
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f1215b) {
            if (f1214a == null) {
                f1214a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return f1214a;
    }

    /* renamed from: a */
    public void mo8862a(C1192i iVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Attaching SDK instance: ");
        sb.append(iVar);
        sb.append("...");
        C1227o.m2838f("AppLovinCommunicator", sb.toString());
        this.f1216c = iVar;
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f1218e;
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("Subscribing ");
            sb.append(appLovinCommunicatorSubscriber);
            String str2 = " to topic: ";
            sb.append(str2);
            sb.append(str);
            String str3 = "AppLovinCommunicator";
            C1227o.m2838f(str3, sb.toString());
            if (this.f1217d.mo9252a(appLovinCommunicatorSubscriber, str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Subscribed ");
                sb2.append(appLovinCommunicatorSubscriber);
                sb2.append(str2);
                sb2.append(str);
                C1227o.m2838f(str3, sb2.toString());
                this.f1218e.maybeFlushStickyMessages(str);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to subscribe ");
                sb3.append(appLovinCommunicatorSubscriber);
                sb3.append(str2);
                sb3.append(str);
                C1227o.m2838f(str3, sb3.toString());
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinCommunicator{sdk=");
        sb.append(this.f1216c);
        sb.append('}');
        return sb.toString();
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsubscribing ");
            sb.append(appLovinCommunicatorSubscriber);
            sb.append(" from topic: ");
            sb.append(str);
            C1227o.m2838f("AppLovinCommunicator", sb.toString());
            this.f1217d.mo9253b(appLovinCommunicatorSubscriber, str);
        }
    }
}
