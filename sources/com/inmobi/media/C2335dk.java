package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.video.VideoEvents;

/* renamed from: com.inmobi.media.dk */
/* compiled from: AdEventHandler */
final class C2335dk {

    /* renamed from: a */
    VideoEvents f4947a;

    /* renamed from: b */
    private AdEvents f4948b;

    public C2335dk(AdSession adSession, String str) {
        if (((str.hashCode() == -1191784049 && str.equals("native_video_ad")) ? (char) 0 : 65535) == 0) {
            this.f4947a = VideoEvents.createVideoEvents(adSession);
        }
        this.f4948b = AdEvents.createAdEvents(adSession);
    }

    /* renamed from: a */
    public final void mo28189a() {
        AdEvents adEvents = this.f4948b;
        if (adEvents != null) {
            adEvents.impressionOccurred();
        }
    }
}
