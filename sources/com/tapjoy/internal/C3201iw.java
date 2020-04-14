package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.iw */
final class C3201iw implements C3195is {

    /* renamed from: a */
    public final C3194ir f7637a = new C3194ir();

    /* renamed from: b */
    public final C3207jb f7638b;

    /* renamed from: c */
    boolean f7639c;

    C3201iw(C3207jb jbVar) {
        if (jbVar != null) {
            this.f7638b = jbVar;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public final void mo30276a(C3194ir irVar, long j) {
        if (!this.f7639c) {
            this.f7637a.mo30276a(irVar, j);
            m7421b();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C3195is mo30279b(C3197iu iuVar) {
        if (!this.f7639c) {
            this.f7637a.mo30279b(iuVar);
            return m7421b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C3195is mo30280b(String str) {
        if (!this.f7639c) {
            this.f7637a.mo30280b(str);
            return m7421b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: e */
    public final C3195is mo30293e(int i) {
        if (!this.f7639c) {
            this.f7637a.mo30293e(i);
            return m7421b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: d */
    public final C3195is mo30289d(int i) {
        if (!this.f7639c) {
            this.f7637a.mo30289d(i);
            return m7421b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: f */
    public final C3195is mo30296f(long j) {
        if (!this.f7639c) {
            this.f7637a.mo30296f(j);
            return m7421b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    private C3195is m7421b() {
        if (!this.f7639c) {
            C3194ir irVar = this.f7637a;
            long j = irVar.f7626b;
            if (j == 0) {
                j = 0;
            } else {
                C3203iy iyVar = irVar.f7625a.f7649g;
                if (iyVar.f7645c < 8192 && iyVar.f7647e) {
                    j -= (long) (iyVar.f7645c - iyVar.f7644b);
                }
            }
            if (j > 0) {
                this.f7638b.mo30276a(this.f7637a, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public final C3195is mo30274a() {
        if (!this.f7639c) {
            long j = this.f7637a.f7626b;
            if (j > 0) {
                this.f7638b.mo30276a(this.f7637a, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final void flush() {
        if (!this.f7639c) {
            if (this.f7637a.f7626b > 0) {
                C3207jb jbVar = this.f7638b;
                C3194ir irVar = this.f7637a;
                jbVar.mo30276a(irVar, irVar.f7626b);
            }
            this.f7638b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final void close() {
        if (!this.f7639c) {
            Throwable th = null;
            try {
                if (this.f7637a.f7626b > 0) {
                    this.f7638b.mo30276a(this.f7637a, this.f7637a.f7626b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f7638b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f7639c = true;
            if (th != null) {
                C3211je.m7461a(th);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("buffer(");
        sb.append(this.f7638b);
        sb.append(")");
        return sb.toString();
    }
}
