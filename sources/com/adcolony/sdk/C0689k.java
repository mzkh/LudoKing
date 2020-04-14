package com.adcolony.sdk;

import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.k */
class C0689k implements C0484ad {
    C0689k() {
        C0476a.m81a("CustomMessage.controller_send", (C0484ad) this);
    }

    /* renamed from: a */
    public void mo8235a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        final String b = C0746u.m908b(c, "type");
        final String b2 = C0746u.m908b(c, "message");
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                new C0749a().mo8726a("Received custom message ").mo8726a(b2).mo8726a(" of type ").mo8726a(b).mo8728a(C0748w.f1168d);
                try {
                    AdColonyCustomMessageListener adColonyCustomMessageListener = (AdColonyCustomMessageListener) C0476a.m77a().mo8544A().get(b);
                    if (adColonyCustomMessageListener != null) {
                        adColonyCustomMessageListener.onAdColonyCustomMessage(new AdColonyCustomMessage(b, b2));
                    }
                } catch (RuntimeException unused) {
                }
            }
        });
    }
}
