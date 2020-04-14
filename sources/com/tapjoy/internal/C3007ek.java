package com.tapjoy.internal;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.tapjoy.internal.ek */
public final class C3007ek {

    /* renamed from: a */
    final C3196it f6919a;

    /* renamed from: b */
    private long f6920b = 0;

    /* renamed from: c */
    private long f6921c = Long.MAX_VALUE;

    /* renamed from: d */
    private int f6922d;

    /* renamed from: e */
    private int f6923e = 2;

    /* renamed from: f */
    private int f6924f = -1;

    /* renamed from: g */
    private long f6925g = -1;

    /* renamed from: h */
    private C2986eg f6926h;

    public C3007ek(C3196it itVar) {
        this.f6919a = itVar;
    }

    /* renamed from: a */
    public final long mo29995a() {
        if (this.f6923e == 2) {
            int i = this.f6922d + 1;
            this.f6922d = i;
            if (i <= 65) {
                long j = this.f6925g;
                this.f6925g = -1;
                this.f6923e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    /* renamed from: a */
    public final void mo29996a(long j) {
        if (this.f6923e == 6) {
            int i = this.f6922d - 1;
            this.f6922d = i;
            if (i < 0 || this.f6925g != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            } else if (this.f6920b == this.f6921c || this.f6922d == 0) {
                this.f6921c = j;
            } else {
                StringBuilder sb = new StringBuilder("Expected to end at ");
                sb.append(this.f6921c);
                sb.append(" but was ");
                sb.append(this.f6920b);
                throw new IOException(sb.toString());
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    /* renamed from: b */
    public final int mo29997b() {
        int i = this.f6923e;
        if (i == 7) {
            this.f6923e = 2;
            return this.f6924f;
        } else if (i == 6) {
            while (this.f6920b < this.f6921c && !this.f6919a.mo30282b()) {
                int i2 = m6864i();
                if (i2 != 0) {
                    this.f6924f = i2 >> 3;
                    int i3 = i2 & 7;
                    if (i3 == 0) {
                        this.f6926h = C2986eg.VARINT;
                        this.f6923e = 0;
                        return this.f6924f;
                    } else if (i3 == 1) {
                        this.f6926h = C2986eg.FIXED64;
                        this.f6923e = 1;
                        return this.f6924f;
                    } else if (i3 == 2) {
                        this.f6926h = C2986eg.LENGTH_DELIMITED;
                        this.f6923e = 2;
                        int i4 = m6864i();
                        if (i4 < 0) {
                            StringBuilder sb = new StringBuilder("Negative length: ");
                            sb.append(i4);
                            throw new ProtocolException(sb.toString());
                        } else if (this.f6925g == -1) {
                            this.f6925g = this.f6921c;
                            this.f6921c = this.f6920b + ((long) i4);
                            if (this.f6921c <= this.f6925g) {
                                return this.f6924f;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i3 == 3) {
                        m6862a(this.f6924f);
                    } else if (i3 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i3 == 5) {
                        this.f6926h = C2986eg.FIXED32;
                        this.f6923e = 5;
                        return this.f6924f;
                    } else {
                        StringBuilder sb2 = new StringBuilder("Unexpected field encoding: ");
                        sb2.append(i3);
                        throw new ProtocolException(sb2.toString());
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    /* renamed from: c */
    public final C2986eg mo29998c() {
        return this.f6926h;
    }

    /* renamed from: a */
    private void m6862a(int i) {
        while (this.f6920b < this.f6921c && !this.f6919a.mo30282b()) {
            int i2 = m6864i();
            if (i2 != 0) {
                int i3 = i2 >> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    this.f6923e = 0;
                    mo30000e();
                } else if (i4 == 1) {
                    this.f6923e = 1;
                    mo30002g();
                } else if (i4 == 2) {
                    long i5 = (long) m6864i();
                    this.f6920b += i5;
                    this.f6919a.mo30290d(i5);
                } else if (i4 == 3) {
                    m6862a(i3);
                } else if (i4 != 4) {
                    if (i4 == 5) {
                        this.f6923e = 5;
                        mo30001f();
                    } else {
                        StringBuilder sb = new StringBuilder("Unexpected field encoding: ");
                        sb.append(i4);
                        throw new ProtocolException(sb.toString());
                    }
                } else if (i3 != i) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    /* renamed from: d */
    public final int mo29999d() {
        int i = this.f6923e;
        if (i == 0 || i == 2) {
            int i2 = m6864i();
            m6863b(0);
            return i2;
        }
        StringBuilder sb = new StringBuilder("Expected VARINT or LENGTH_DELIMITED but was ");
        sb.append(this.f6923e);
        throw new ProtocolException(sb.toString());
    }

    /* renamed from: i */
    private int m6864i() {
        byte b;
        int i;
        this.f6920b++;
        byte c = this.f6919a.mo30283c();
        if (c >= 0) {
            return c;
        }
        byte b2 = c & Byte.MAX_VALUE;
        this.f6920b++;
        byte c2 = this.f6919a.mo30283c();
        if (c2 >= 0) {
            i = c2 << 7;
        } else {
            b2 |= (c2 & Byte.MAX_VALUE) << 7;
            this.f6920b++;
            byte c3 = this.f6919a.mo30283c();
            if (c3 >= 0) {
                i = c3 << 14;
            } else {
                b2 |= (c3 & Byte.MAX_VALUE) << 14;
                this.f6920b++;
                byte c4 = this.f6919a.mo30283c();
                if (c4 >= 0) {
                    i = c4 << 21;
                } else {
                    byte b3 = b2 | ((c4 & Byte.MAX_VALUE) << 21);
                    this.f6920b++;
                    byte c5 = this.f6919a.mo30283c();
                    b = b3 | (c5 << 28);
                    if (c5 < 0) {
                        for (int i2 = 0; i2 < 5; i2++) {
                            this.f6920b++;
                            if (this.f6919a.mo30283c() >= 0) {
                                return b;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return b;
                }
            }
        }
        b = b2 | i;
        return b;
    }

    /* renamed from: e */
    public final long mo30000e() {
        int i = this.f6923e;
        if (i == 0 || i == 2) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.f6920b++;
                byte c = this.f6919a.mo30283c();
                j |= ((long) (c & Byte.MAX_VALUE)) << i2;
                if ((c & 128) == 0) {
                    m6863b(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        StringBuilder sb = new StringBuilder("Expected VARINT or LENGTH_DELIMITED but was ");
        sb.append(this.f6923e);
        throw new ProtocolException(sb.toString());
    }

    /* renamed from: f */
    public final int mo30001f() {
        int i = this.f6923e;
        if (i == 5 || i == 2) {
            this.f6919a.mo30275a(4);
            this.f6920b += 4;
            int e = this.f6919a.mo30291e();
            m6863b(5);
            return e;
        }
        StringBuilder sb = new StringBuilder("Expected FIXED32 or LENGTH_DELIMITED but was ");
        sb.append(this.f6923e);
        throw new ProtocolException(sb.toString());
    }

    /* renamed from: g */
    public final long mo30002g() {
        int i = this.f6923e;
        if (i == 1 || i == 2) {
            this.f6919a.mo30275a(8);
            this.f6920b += 8;
            long f = this.f6919a.mo30295f();
            m6863b(1);
            return f;
        }
        StringBuilder sb = new StringBuilder("Expected FIXED64 or LENGTH_DELIMITED but was ");
        sb.append(this.f6923e);
        throw new ProtocolException(sb.toString());
    }

    /* renamed from: b */
    private void m6863b(int i) {
        if (this.f6923e == i) {
            this.f6923e = 6;
            return;
        }
        long j = this.f6920b;
        long j2 = this.f6921c;
        if (j > j2) {
            StringBuilder sb = new StringBuilder("Expected to end at ");
            sb.append(this.f6921c);
            sb.append(" but was ");
            sb.append(this.f6920b);
            throw new IOException(sb.toString());
        } else if (j == j2) {
            this.f6921c = this.f6925g;
            this.f6925g = -1;
            this.f6923e = 6;
        } else {
            this.f6923e = 7;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final long mo30003h() {
        if (this.f6923e == 2) {
            long j = this.f6921c - this.f6920b;
            this.f6919a.mo30275a(j);
            this.f6923e = 6;
            this.f6920b = this.f6921c;
            this.f6921c = this.f6925g;
            this.f6925g = -1;
            return j;
        }
        StringBuilder sb = new StringBuilder("Expected LENGTH_DELIMITED but was ");
        sb.append(this.f6923e);
        throw new ProtocolException(sb.toString());
    }
}
