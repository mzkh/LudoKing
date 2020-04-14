package com.adcolony.sdk;

import androidx.annotation.NonNull;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

public class AdColonyCustomMessage {

    /* renamed from: a */
    String f102a;

    /* renamed from: b */
    String f103b;

    public AdColonyCustomMessage(@NonNull String str, @NonNull String str2) {
        if (C0543at.m325d(str) || C0543at.m325d(str2)) {
            this.f102a = str;
            this.f103b = str2;
        }
    }

    public String getMessage() {
        return this.f103b;
    }

    public String getType() {
        return this.f102a;
    }

    public AdColonyCustomMessage set(String str, String str2) {
        this.f102a = str;
        this.f103b = str2;
        return this;
    }

    public void send() {
        try {
            AdColony.f41a.execute(new Runnable() {
                public void run() {
                    AdColony.m11a();
                    JSONObject a = C0746u.m892a();
                    C0746u.m902a(a, "type", AdColonyCustomMessage.this.f102a);
                    C0746u.m902a(a, "message", AdColonyCustomMessage.this.f103b);
                    new C0480ab("CustomMessage.native_send", 1, a).mo8217b();
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }
}
