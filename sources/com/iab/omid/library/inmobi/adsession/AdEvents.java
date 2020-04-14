package com.iab.omid.library.inmobi.adsession;

import com.iab.omid.library.inmobi.p034d.C2097e;

public final class AdEvents {
    private final C2077a adSession;

    private AdEvents(C2077a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession2) {
        C2077a aVar = (C2077a) adSession2;
        C2097e.m4047a((Object) adSession2, "AdSession is null");
        C2097e.m4052d(aVar);
        C2097e.m4050b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo27597a(adEvents);
        return adEvents;
    }

    public final void impressionOccurred() {
        C2097e.m4050b(this.adSession);
        C2097e.m4054f(this.adSession);
        if (!this.adSession.mo27531d()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.mo27531d()) {
            this.adSession.mo27529b();
        }
    }
}
