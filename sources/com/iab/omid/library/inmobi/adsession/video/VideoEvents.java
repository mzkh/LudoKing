package com.iab.omid.library.inmobi.adsession.video;

import com.facebook.internal.ServerProtocol;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.p032b.C2086e;
import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.p034d.C2097e;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

public final class VideoEvents {
    private final C2077a adSession;

    private VideoEvents(C2077a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Video duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }

    public static VideoEvents createVideoEvents(AdSession adSession2) {
        C2077a aVar = (C2077a) adSession2;
        C2097e.m4047a((Object) adSession2, "AdSession is null");
        C2097e.m4055g(aVar);
        C2097e.m4046a(aVar);
        C2097e.m4050b(aVar);
        C2097e.m4053e(aVar);
        VideoEvents videoEvents = new VideoEvents(aVar);
        aVar.getAdSessionStatePublisher().mo27601a(videoEvents);
        return videoEvents;
    }

    public final void adUserInteraction(InteractionType interactionType) {
        C2097e.m4047a((Object) interactionType, "InteractionType is null");
        C2097e.m4051c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2093b.m4030a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().mo27604a("adUserInteraction", jSONObject);
    }

    public final void bufferFinish() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a("bufferFinish");
    }

    public final void bufferStart() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a(String.VIDEO_BUFFER_START);
    }

    public final void complete() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a(String.VIDEO_COMPLETE);
    }

    public final void firstQuartile() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a(String.VIDEO_FIRST_QUARTILE);
    }

    public final void loaded(VastProperties vastProperties) {
        C2097e.m4047a((Object) vastProperties, "VastProperties is null");
        C2097e.m4050b(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27604a("loaded", vastProperties.toJSON());
    }

    public final void midpoint() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a(String.VIDEO_MIDPOINT);
    }

    public final void pause() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a("pause");
    }

    public final void playerStateChange(PlayerState playerState) {
        C2097e.m4047a((Object) playerState, "PlayerState is null");
        C2097e.m4051c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2093b.m4030a(jSONObject, ServerProtocol.DIALOG_PARAM_STATE, playerState);
        this.adSession.getAdSessionStatePublisher().mo27604a("playerStateChange", jSONObject);
    }

    public final void resume() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a("resume");
    }

    public final void skipped() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a(String.VIDEO_SKIPPED);
    }

    public final void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        C2097e.m4051c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2093b.m4030a(jSONObject, "duration", Float.valueOf(f));
        C2093b.m4030a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
        C2093b.m4030a(jSONObject, "deviceVolume", Float.valueOf(C2086e.m4001a().mo27587d()));
        this.adSession.getAdSessionStatePublisher().mo27604a(String.VIDEO_START, jSONObject);
    }

    public final void thirdQuartile() {
        C2097e.m4051c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo27602a(String.VIDEO_THIRD_QUARTILE);
    }

    public final void volumeChange(float f) {
        confirmValidVolume(f);
        C2097e.m4051c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2093b.m4030a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        C2093b.m4030a(jSONObject, "deviceVolume", Float.valueOf(C2086e.m4001a().mo27587d()));
        this.adSession.getAdSessionStatePublisher().mo27604a("volumeChange", jSONObject);
    }
}
