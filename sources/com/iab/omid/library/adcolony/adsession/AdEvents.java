package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p028d.C2049e;

public final class AdEvents {

    /* renamed from: a */
    private final C2029a f3973a;

    private AdEvents(C2029a aVar) {
        this.f3973a = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession) {
        C2029a aVar = (C2029a) adSession;
        C2049e.m3841a((Object) adSession, "AdSession is null");
        C2049e.m3846d(aVar);
        C2049e.m3844b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo27433a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        C2049e.m3844b(this.f3973a);
        C2049e.m3848f(this.f3973a);
        if (!this.f3973a.mo27368d()) {
            try {
                this.f3973a.start();
            } catch (Exception unused) {
            }
        }
        if (this.f3973a.mo27368d()) {
            this.f3973a.mo27366b();
        }
    }
}
