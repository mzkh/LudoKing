package com.inmobi.media;

import android.media.MediaPlayer;

/* renamed from: com.inmobi.media.ed */
/* compiled from: NativeMediaPlayer */
public final class C2381ed extends MediaPlayer {

    /* renamed from: d */
    private static final Object f5064d = new Object();

    /* renamed from: e */
    private static C2381ed f5065e;

    /* renamed from: f */
    private static int f5066f = 0;

    /* renamed from: a */
    public int f5067a = 0;

    /* renamed from: b */
    public int f5068b = 0;

    /* renamed from: c */
    private C2381ed f5069c;

    /* renamed from: a */
    public static C2381ed m4959a() {
        synchronized (f5064d) {
            if (f5065e == null) {
                return new C2381ed();
            }
            C2381ed edVar = f5065e;
            f5065e = edVar.f5069c;
            edVar.f5069c = null;
            f5066f--;
            return edVar;
        }
    }

    /* renamed from: b */
    public final void mo28253b() {
        if (!(3 == this.f5067a)) {
            synchronized (f5064d) {
                if (f5066f < 5) {
                    this.f5069c = f5065e;
                    f5065e = this;
                    f5066f++;
                }
            }
        }
    }
}
