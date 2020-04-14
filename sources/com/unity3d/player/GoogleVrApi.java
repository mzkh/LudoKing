package com.unity3d.player;

import java.util.concurrent.atomic.AtomicReference;

public class GoogleVrApi {

    /* renamed from: a */
    private static AtomicReference f7793a = new AtomicReference();

    private GoogleVrApi() {
    }

    /* renamed from: a */
    static void m7577a() {
        f7793a.set(null);
    }

    /* renamed from: a */
    static void m7578a(C3341e eVar) {
        f7793a.compareAndSet(null, new GoogleVrProxy(eVar));
    }

    /* renamed from: b */
    static GoogleVrProxy m7579b() {
        return (GoogleVrProxy) f7793a.get();
    }

    public static GoogleVrVideo getGoogleVrVideo() {
        return (GoogleVrVideo) f7793a.get();
    }
}
