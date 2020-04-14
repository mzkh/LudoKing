package com.tapjoy.internal;

import android.support.p000v4.media.session.PlaybackStateCompat;

/* renamed from: com.tapjoy.internal.iz */
final class C3204iz {

    /* renamed from: a */
    static C3203iy f7650a;

    /* renamed from: b */
    static long f7651b;

    private C3204iz() {
    }

    /* renamed from: a */
    static C3203iy m7441a() {
        synchronized (C3204iz.class) {
            if (f7650a == null) {
                return new C3203iy();
            }
            C3203iy iyVar = f7650a;
            f7650a = iyVar.f7648f;
            iyVar.f7648f = null;
            f7651b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return iyVar;
        }
    }

    /* renamed from: a */
    static void m7442a(C3203iy iyVar) {
        if (iyVar.f7648f != null || iyVar.f7649g != null) {
            throw new IllegalArgumentException();
        } else if (!iyVar.f7646d) {
            synchronized (C3204iz.class) {
                if (f7651b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f7651b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    iyVar.f7648f = f7650a;
                    iyVar.f7645c = 0;
                    iyVar.f7644b = 0;
                    f7650a = iyVar;
                }
            }
        }
    }
}
