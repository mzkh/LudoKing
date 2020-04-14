package com.tapjoy.internal;

import com.google.android.gms.games.Notifications;

/* renamed from: com.tapjoy.internal.el */
public final class C3008el {

    /* renamed from: a */
    final C3195is f6927a;

    /* renamed from: a */
    static int m6874a(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    static int m6876a(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: b */
    static int m6877b(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: b */
    static long m6878b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: a */
    static int m6875a(int i, C2986eg egVar) {
        return (i << 3) | egVar.f6891e;
    }

    public C3008el(C3195is isVar) {
        this.f6927a = isVar;
    }

    /* renamed from: a */
    public final void mo30004a(C3197iu iuVar) {
        this.f6927a.mo30279b(iuVar);
    }

    /* renamed from: c */
    public final void mo30005c(int i) {
        while ((i & -128) != 0) {
            this.f6927a.mo30293e((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            i >>>= 7;
        }
        this.f6927a.mo30293e(i);
    }

    /* renamed from: c */
    public final void mo30006c(long j) {
        while ((-128 & j) != 0) {
            this.f6927a.mo30293e((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            j >>>= 7;
        }
        this.f6927a.mo30293e((int) j);
    }

    /* renamed from: d */
    public final void mo30007d(int i) {
        this.f6927a.mo30289d(i);
    }

    /* renamed from: d */
    public final void mo30008d(long j) {
        this.f6927a.mo30296f(j);
    }
}
