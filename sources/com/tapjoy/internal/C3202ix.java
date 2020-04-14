package com.tapjoy.internal;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;

/* renamed from: com.tapjoy.internal.ix */
final class C3202ix implements C3196it {

    /* renamed from: a */
    public final C3194ir f7640a = new C3194ir();

    /* renamed from: b */
    public final C3208jc f7641b;

    /* renamed from: c */
    boolean f7642c;

    C3202ix(C3208jc jcVar) {
        if (jcVar != null) {
            this.f7641b = jcVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public final long mo30277b(C3194ir irVar, long j) {
        if (irVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder sb = new StringBuilder("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f7642c) {
            throw new IllegalStateException("closed");
        } else if (this.f7640a.f7626b == 0 && this.f7641b.mo30277b(this.f7640a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f7640a.mo30277b(irVar, Math.min(j, this.f7640a.f7626b));
        }
    }

    /* renamed from: b */
    public final boolean mo30282b() {
        if (!this.f7642c) {
            return this.f7640a.mo30282b() && this.f7641b.mo30277b(this.f7640a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public final byte mo30283c() {
        mo30275a(1);
        return this.f7640a.mo30283c();
    }

    /* renamed from: b */
    public final C3197iu mo30281b(long j) {
        mo30275a(j);
        return this.f7640a.mo30281b(j);
    }

    /* renamed from: c */
    public final String mo30285c(long j) {
        mo30275a(j);
        return this.f7640a.mo30285c(j);
    }

    /* renamed from: e */
    public final int mo30291e() {
        mo30275a(4);
        return C3211je.m7458a(this.f7640a.mo30288d());
    }

    /* renamed from: f */
    public final long mo30295f() {
        mo30275a(8);
        return this.f7640a.mo30295f();
    }

    /* renamed from: d */
    public final void mo30290d(long j) {
        if (!this.f7642c) {
            while (j > 0) {
                if (this.f7640a.f7626b == 0 && this.f7641b.mo30277b(this.f7640a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f7640a.f7626b);
                this.f7640a.mo30290d(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final void close() {
        if (!this.f7642c) {
            this.f7642c = true;
            this.f7641b.close();
            C3194ir irVar = this.f7640a;
            try {
                irVar.mo30290d(irVar.f7626b);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("buffer(");
        sb.append(this.f7641b);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo30275a(long j) {
        boolean z;
        if (j < 0) {
            StringBuilder sb = new StringBuilder("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f7642c) {
            while (true) {
                if (this.f7640a.f7626b < j) {
                    if (this.f7641b.mo30277b(this.f7640a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                throw new EOFException();
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }
}
