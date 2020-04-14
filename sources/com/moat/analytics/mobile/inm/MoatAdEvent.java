package com.moat.analytics.mobile.inm;

import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: a */
    static final Integer f5995a = Integer.valueOf(Integer.MIN_VALUE);

    /* renamed from: e */
    private static final Double f5996e = Double.valueOf(Double.NaN);

    /* renamed from: b */
    Integer f5997b;

    /* renamed from: c */
    Double f5998c;

    /* renamed from: d */
    MoatAdEventType f5999d;

    /* renamed from: f */
    private final Double f6000f;

    /* renamed from: g */
    private final Long f6001g;

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f5995a, f5996e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f5996e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f6001g = Long.valueOf(System.currentTimeMillis());
        this.f5999d = moatAdEventType;
        this.f5998c = d;
        this.f5997b = num;
        this.f6000f = Double.valueOf(C2738s.m6318a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, Object> mo28935a() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f5998c);
        hashMap.put("playhead", this.f5997b);
        hashMap.put("aTimeStamp", this.f6001g);
        hashMap.put("type", this.f5999d.toString());
        hashMap.put("deviceVolume", this.f6000f);
        return hashMap;
    }
}
