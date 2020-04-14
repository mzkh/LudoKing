package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dc */
public final class C2943dc {

    /* renamed from: a */
    private final C2940cz f6798a;

    private C2943dc(C2940cz czVar) {
        this.f6798a = czVar;
    }

    /* renamed from: b */
    private static void m6705b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }

    /* renamed from: a */
    public static C2943dc m6704a(C2933cs csVar) {
        C2940cz czVar = (C2940cz) csVar;
        C2960do.m6754a((Object) csVar, "AdSession is null");
        if (!(C2937cw.NATIVE == czVar.f6779a.f6757b)) {
            throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
        } else if (!czVar.f6782d) {
            C2960do.m6753a(czVar);
            if (czVar.f6781c.f6832c == null) {
                C2943dc dcVar = new C2943dc(czVar);
                czVar.f6781c.f6832c = dcVar;
                return dcVar;
            }
            throw new IllegalStateException("VideoEvents already exists for AdSession");
        } else {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public final void mo29933a(C2942db dbVar) {
        C2960do.m6754a((Object) dbVar, "VastProperties is null");
        C2960do.m6753a(this.f6798a);
        this.f6798a.f6781c.mo29959a("loaded", dbVar.mo29929a());
    }

    /* renamed from: a */
    public final void mo29932a(float f, float f2) {
        if (f > 0.0f) {
            m6705b(f2);
            C2960do.m6756b(this.f6798a);
            JSONObject jSONObject = new JSONObject();
            C2957dm.m6746a(jSONObject, "duration", Float.valueOf(f));
            C2957dm.m6746a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
            C2957dm.m6746a(jSONObject, "deviceVolume", Float.valueOf(C2951dh.m6732a().f6816a));
            this.f6798a.f6781c.mo29959a(String.VIDEO_START, jSONObject);
            return;
        }
        throw new IllegalArgumentException("Invalid Video duration");
    }

    /* renamed from: a */
    public final void mo29930a() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a(String.VIDEO_FIRST_QUARTILE);
    }

    /* renamed from: b */
    public final void mo29934b() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a(String.VIDEO_MIDPOINT);
    }

    /* renamed from: c */
    public final void mo29935c() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a(String.VIDEO_THIRD_QUARTILE);
    }

    /* renamed from: d */
    public final void mo29936d() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a(String.VIDEO_COMPLETE);
    }

    /* renamed from: e */
    public final void mo29937e() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a("pause");
    }

    /* renamed from: f */
    public final void mo29938f() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a("resume");
    }

    /* renamed from: g */
    public final void mo29939g() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a(String.VIDEO_BUFFER_START);
    }

    /* renamed from: h */
    public final void mo29940h() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a("bufferFinish");
    }

    /* renamed from: i */
    public final void mo29941i() {
        C2960do.m6756b(this.f6798a);
        this.f6798a.f6781c.mo29958a(String.VIDEO_SKIPPED);
    }

    /* renamed from: a */
    public final void mo29931a(float f) {
        m6705b(f);
        C2960do.m6756b(this.f6798a);
        JSONObject jSONObject = new JSONObject();
        C2957dm.m6746a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        C2957dm.m6746a(jSONObject, "deviceVolume", Float.valueOf(C2951dh.m6732a().f6816a));
        this.f6798a.f6781c.mo29959a("volumeChange", jSONObject);
    }
}
