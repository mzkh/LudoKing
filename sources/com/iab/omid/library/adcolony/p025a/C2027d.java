package com.iab.omid.library.adcolony.p025a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;

/* renamed from: com.iab.omid.library.adcolony.a.d */
public final class C2027d extends ContentObserver {

    /* renamed from: a */
    private final Context f3968a;

    /* renamed from: b */
    private final AudioManager f3969b;

    /* renamed from: c */
    private final C2024a f3970c;

    /* renamed from: d */
    private final C2026c f3971d;

    /* renamed from: e */
    private float f3972e;

    public C2027d(Handler handler, Context context, C2024a aVar, C2026c cVar) {
        super(handler);
        this.f3968a = context;
        this.f3969b = (AudioManager) context.getSystemService("audio");
        this.f3970c = aVar;
        this.f3971d = cVar;
    }

    /* renamed from: a */
    private boolean m3732a(float f) {
        return f != this.f3972e;
    }

    /* renamed from: c */
    private float m3733c() {
        return this.f3970c.mo27331a(this.f3969b.getStreamVolume(3), this.f3969b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m3734d() {
        this.f3971d.mo27333a(this.f3972e);
    }

    /* renamed from: a */
    public void mo27334a() {
        this.f3972e = m3733c();
        m3734d();
        this.f3968a.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public void mo27335b() {
        this.f3968a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = m3733c();
        if (m3732a(c)) {
            this.f3972e = c;
            m3734d();
        }
    }
}
