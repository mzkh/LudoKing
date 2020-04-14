package com.tapjoy.internal;

import com.google.firebase.messaging.cpp.SerializedEventUnion;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.tapjoy.internal.if */
public final class C3175if {

    /* renamed from: a */
    private final byte[] f7554a = new byte[256];

    /* renamed from: b */
    private ByteBuffer f7555b;

    /* renamed from: c */
    private C3174ie f7556c;

    /* renamed from: d */
    private int f7557d = 0;

    /* renamed from: a */
    public final C3175if mo30236a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f7555b = null;
            Arrays.fill(this.f7554a, 0);
            this.f7556c = new C3174ie();
            this.f7557d = 0;
            this.f7555b = wrap.asReadOnlyBuffer();
            this.f7555b.position(0);
            this.f7555b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f7555b = null;
            this.f7556c.f7542b = 2;
        }
        return this;
    }

    /* renamed from: a */
    public final C3174ie mo30235a() {
        if (this.f7555b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m7329h()) {
            return this.f7556c;
        } else {
            m7325d();
            if (!m7329h()) {
                m7323b();
                if (this.f7556c.f7543c < 0) {
                    this.f7556c.f7542b = 1;
                }
            }
            return this.f7556c;
        }
    }

    /* renamed from: b */
    private void m7323b() {
        boolean z = false;
        while (!z && !m7329h() && this.f7556c.f7543c <= Integer.MAX_VALUE) {
            int g = m7328g();
            if (g == 33) {
                int g2 = m7328g();
                if (g2 == 1) {
                    m7326e();
                } else if (g2 == 249) {
                    this.f7556c.f7544d = new C3173id();
                    m7328g();
                    int g3 = m7328g();
                    this.f7556c.f7544d.f7536g = (g3 & 28) >> 2;
                    if (this.f7556c.f7544d.f7536g == 0) {
                        this.f7556c.f7544d.f7536g = 1;
                    }
                    this.f7556c.f7544d.f7535f = (g3 & 1) != 0;
                    short s = this.f7555b.getShort();
                    if (s < 2) {
                        s = 10;
                    }
                    this.f7556c.f7544d.f7538i = s * 10;
                    this.f7556c.f7544d.f7537h = m7328g();
                    m7328g();
                } else if (g2 == 254) {
                    m7326e();
                } else if (g2 != 255) {
                    m7326e();
                } else {
                    m7327f();
                    String str = "";
                    for (int i = 0; i < 11; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append((char) this.f7554a[i]);
                        str = sb.toString();
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        m7324c();
                    } else {
                        m7326e();
                    }
                }
            } else if (g == 44) {
                if (this.f7556c.f7544d == null) {
                    this.f7556c.f7544d = new C3173id();
                }
                this.f7556c.f7544d.f7530a = this.f7555b.getShort();
                this.f7556c.f7544d.f7531b = this.f7555b.getShort();
                this.f7556c.f7544d.f7532c = this.f7555b.getShort();
                this.f7556c.f7544d.f7533d = this.f7555b.getShort();
                int g4 = m7328g();
                boolean z2 = (g4 & 128) != 0;
                int pow = (int) Math.pow(2.0d, (double) ((g4 & 7) + 1));
                this.f7556c.f7544d.f7534e = (g4 & 64) != 0;
                if (z2) {
                    this.f7556c.f7544d.f7540k = m7322a(pow);
                } else {
                    this.f7556c.f7544d.f7540k = null;
                }
                this.f7556c.f7544d.f7539j = this.f7555b.position();
                m7328g();
                m7326e();
                if (!m7329h()) {
                    this.f7556c.f7543c++;
                    this.f7556c.f7545e.add(this.f7556c.f7544d);
                }
            } else if (g != 59) {
                this.f7556c.f7542b = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: c */
    private void m7324c() {
        do {
            m7327f();
            byte[] bArr = this.f7554a;
            if (bArr[0] == 1) {
                byte b = bArr[1] & 255;
                byte b2 = bArr[2] & 255;
                C3174ie ieVar = this.f7556c;
                ieVar.f7553m = (b2 << 8) | b;
                if (ieVar.f7553m == 0) {
                    this.f7556c.f7553m = -1;
                }
            }
            if (this.f7557d <= 0) {
                return;
            }
        } while (!m7329h());
    }

    /* renamed from: d */
    private void m7325d() {
        boolean z = false;
        String str = "";
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append((char) m7328g());
            str = sb.toString();
        }
        if (!str.startsWith("GIF")) {
            this.f7556c.f7542b = 1;
            return;
        }
        this.f7556c.f7546f = this.f7555b.getShort();
        this.f7556c.f7547g = this.f7555b.getShort();
        int g = m7328g();
        C3174ie ieVar = this.f7556c;
        if ((g & 128) != 0) {
            z = true;
        }
        ieVar.f7548h = z;
        C3174ie ieVar2 = this.f7556c;
        ieVar2.f7549i = 2 << (g & 7);
        ieVar2.f7550j = m7328g();
        this.f7556c.f7551k = m7328g();
        if (this.f7556c.f7548h && !m7329h()) {
            C3174ie ieVar3 = this.f7556c;
            ieVar3.f7541a = m7322a(ieVar3.f7549i);
            C3174ie ieVar4 = this.f7556c;
            ieVar4.f7552l = ieVar4.f7541a[this.f7556c.f7550j];
        }
    }

    /* renamed from: a */
    private int[] m7322a(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.f7555b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | SerializedEventUnion.NONE | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            new Object[1][0] = e;
            this.f7556c.f7542b = 1;
        }
        return iArr;
    }

    /* renamed from: e */
    private void m7326e() {
        int g;
        do {
            try {
                g = m7328g();
                this.f7555b.position(this.f7555b.position() + g);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (g > 0);
    }

    /* renamed from: f */
    private int m7327f() {
        this.f7557d = m7328g();
        if (this.f7557d <= 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.f7557d) {
            try {
                i2 = this.f7557d - i;
                this.f7555b.get(this.f7554a, i, i2);
                i += i2;
            } catch (Exception e) {
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f7557d), e};
                this.f7556c.f7542b = 1;
                return i;
            }
        }
        return i;
    }

    /* renamed from: g */
    private int m7328g() {
        try {
            return this.f7555b.get() & 255;
        } catch (Exception unused) {
            this.f7556c.f7542b = 1;
            return 0;
        }
    }

    /* renamed from: h */
    private boolean m7329h() {
        return this.f7556c.f7542b != 0;
    }
}
