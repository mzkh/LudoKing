package com.iab.omid.library.adcolony.adsession.video;

import com.facebook.internal.ServerProtocol;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.p026b.C2038e;
import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.p028d.C2049e;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

public final class VideoEvents {

    /* renamed from: a */
    private final C2029a f4014a;

    private VideoEvents(C2029a aVar) {
        this.f4014a = aVar;
    }

    /* renamed from: a */
    private void m3752a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Video duration");
        }
    }

    /* renamed from: b */
    private void m3753b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }

    public static VideoEvents createVideoEvents(AdSession adSession) {
        C2029a aVar = (C2029a) adSession;
        C2049e.m3841a((Object) adSession, "AdSession is null");
        C2049e.m3849g(aVar);
        C2049e.m3840a(aVar);
        C2049e.m3844b(aVar);
        C2049e.m3847e(aVar);
        VideoEvents videoEvents = new VideoEvents(aVar);
        aVar.getAdSessionStatePublisher().mo27437a(videoEvents);
        return videoEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        C2049e.m3841a((Object) interactionType, "InteractionType is null");
        C2049e.m3845c(this.f4014a);
        JSONObject jSONObject = new JSONObject();
        C2045b.m3825a(jSONObject, "interactionType", interactionType);
        this.f4014a.getAdSessionStatePublisher().mo27440a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a("bufferFinish");
    }

    public void bufferStart() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a(String.VIDEO_BUFFER_START);
    }

    public void complete() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a(String.VIDEO_COMPLETE);
    }

    public void firstQuartile() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a(String.VIDEO_FIRST_QUARTILE);
    }

    public void loaded(VastProperties vastProperties) {
        C2049e.m3841a((Object) vastProperties, "VastProperties is null");
        C2049e.m3844b(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27440a("loaded", vastProperties.mo27376a());
    }

    public void midpoint() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a(String.VIDEO_MIDPOINT);
    }

    public void pause() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        C2049e.m3841a((Object) playerState, "PlayerState is null");
        C2049e.m3845c(this.f4014a);
        JSONObject jSONObject = new JSONObject();
        C2045b.m3825a(jSONObject, ServerProtocol.DIALOG_PARAM_STATE, playerState);
        this.f4014a.getAdSessionStatePublisher().mo27440a("playerStateChange", jSONObject);
    }

    public void resume() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a("resume");
    }

    public void skipped() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a(String.VIDEO_SKIPPED);
    }

    public void start(float f, float f2) {
        m3752a(f);
        m3753b(f2);
        C2049e.m3845c(this.f4014a);
        JSONObject jSONObject = new JSONObject();
        C2045b.m3825a(jSONObject, "duration", Float.valueOf(f));
        C2045b.m3825a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
        C2045b.m3825a(jSONObject, "deviceVolume", Float.valueOf(C2038e.m3797a().mo27424d()));
        this.f4014a.getAdSessionStatePublisher().mo27440a(String.VIDEO_START, jSONObject);
    }

    public void thirdQuartile() {
        C2049e.m3845c(this.f4014a);
        this.f4014a.getAdSessionStatePublisher().mo27438a(String.VIDEO_THIRD_QUARTILE);
    }

    public void volumeChange(float f) {
        m3753b(f);
        C2049e.m3845c(this.f4014a);
        JSONObject jSONObject = new JSONObject();
        C2045b.m3825a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        C2045b.m3825a(jSONObject, "deviceVolume", Float.valueOf(C2038e.m3797a().mo27424d()));
        this.f4014a.getAdSessionStatePublisher().mo27440a("volumeChange", jSONObject);
    }
}
