package com.tapjoy.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;

/* renamed from: com.tapjoy.internal.cp */
public final class C2930cp extends ContentObserver {

    /* renamed from: a */
    public final Context f6750a;

    /* renamed from: b */
    public float f6751b;

    /* renamed from: c */
    private final AudioManager f6752c;

    /* renamed from: d */
    private final C2927cm f6753d;

    /* renamed from: e */
    private final C2929co f6754e;

    public C2930cp(Handler handler, Context context, C2927cm cmVar, C2929co coVar) {
        super(handler);
        this.f6750a = context;
        this.f6752c = (AudioManager) context.getSystemService("audio");
        this.f6753d = cmVar;
        this.f6754e = coVar;
    }

    /* renamed from: a */
    public final float mo29917a() {
        int streamVolume = this.f6752c.getStreamVolume(3);
        int streamMaxVolume = this.f6752c.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = ((float) streamVolume) / ((float) streamMaxVolume);
        if (f > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    /* renamed from: b */
    public final void mo29918b() {
        this.f6754e.mo29916a(this.f6751b);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float a = mo29917a();
        if (a != this.f6751b) {
            this.f6751b = a;
            mo29918b();
        }
    }
}
