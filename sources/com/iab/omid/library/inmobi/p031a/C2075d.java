package com.iab.omid.library.inmobi.p031a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;

/* renamed from: com.iab.omid.library.inmobi.a.d */
public final class C2075d extends ContentObserver {

    /* renamed from: a */
    private final Context f4100a;

    /* renamed from: b */
    private final AudioManager f4101b;

    /* renamed from: c */
    private final C2072a f4102c;

    /* renamed from: d */
    private final C2074c f4103d;

    /* renamed from: e */
    private float f4104e;

    public C2075d(Handler handler, Context context, C2072a aVar, C2074c cVar) {
        super(handler);
        this.f4100a = context;
        this.f4101b = (AudioManager) context.getSystemService("audio");
        this.f4102c = aVar;
        this.f4103d = cVar;
    }

    /* renamed from: a */
    private boolean m3939a(float f) {
        return f != this.f4104e;
    }

    /* renamed from: c */
    private float m3940c() {
        return this.f4102c.mo27494a(this.f4101b.getStreamVolume(3), this.f4101b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m3941d() {
        this.f4103d.mo27496a(this.f4104e);
    }

    /* renamed from: a */
    public final void mo27497a() {
        this.f4104e = m3940c();
        m3941d();
        this.f4100a.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public final void mo27498b() {
        this.f4100a.getContentResolver().unregisterContentObserver(this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float c = m3940c();
        if (m3939a(c)) {
            this.f4104e = c;
            m3941d();
        }
    }
}
