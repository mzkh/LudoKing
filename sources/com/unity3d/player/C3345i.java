package com.unity3d.player;

import android.os.Build.VERSION;

/* renamed from: com.unity3d.player.i */
public final class C3345i {

    /* renamed from: a */
    static final boolean f8003a = (VERSION.SDK_INT >= 19);

    /* renamed from: b */
    static final boolean f8004b = (VERSION.SDK_INT >= 21);

    /* renamed from: c */
    static final boolean f8005c = (VERSION.SDK_INT >= 23);

    /* renamed from: d */
    static final boolean f8006d;

    /* renamed from: e */
    static final C3340d f8007e = (f8005c ? new C3343g() : null);

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 24) {
            z = false;
        }
        f8006d = z;
    }
}
