package com.tapjoy.internal;

import com.tapjoy.internal.C1812bn.C1814a;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tapjoy.internal.bo */
public final class C2903bo extends C1812bn {

    /* renamed from: a */
    public static final C1814a f6697a = new C1814a() {
        /* renamed from: a */
        public final C1812bn mo18062a(Reader reader) {
            return new C2903bo(reader);
        }

        /* renamed from: a */
        public final C1812bn mo18063a(String str) {
            return new C2903bo(new StringReader(str));
        }
    };

    /* renamed from: b */
    private final C2924cj f6698b = new C2924cj();

    /* renamed from: c */
    private final Reader f6699c;

    /* renamed from: d */
    private boolean f6700d = false;

    /* renamed from: e */
    private final char[] f6701e = new char[1024];

    /* renamed from: f */
    private int f6702f = 0;

    /* renamed from: g */
    private int f6703g = 0;

    /* renamed from: h */
    private int f6704h = 1;

    /* renamed from: i */
    private int f6705i = 1;

    /* renamed from: j */
    private final List f6706j = new ArrayList();

    /* renamed from: k */
    private C2908bs f6707k;

    /* renamed from: l */
    private String f6708l;

    /* renamed from: m */
    private String f6709m;

    /* renamed from: n */
    private int f6710n;

    /* renamed from: o */
    private int f6711o;

    /* renamed from: p */
    private boolean f6712p;

    /* renamed from: com.tapjoy.internal.bo$2 */
    static /* synthetic */ class C29052 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6713a = new int[C2906bq.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.tapjoy.internal.bq[] r0 = com.tapjoy.internal.C2906bq.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6713a = r0
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.EMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.NONEMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.EMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.DANGLING_NAME     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.NONEMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.NONEMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f6713a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.CLOSED     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2903bo.C29052.<clinit>():void");
        }
    }

    public C2903bo(Reader reader) {
        m6619a(C2906bq.EMPTY_DOCUMENT);
        this.f6712p = false;
        if (reader != null) {
            this.f6699c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    /* renamed from: f */
    public final void mo18065f() {
        m6620a(C2908bs.BEGIN_ARRAY);
    }

    /* renamed from: g */
    public final void mo18066g() {
        m6620a(C2908bs.END_ARRAY);
    }

    /* renamed from: h */
    public final void mo18067h() {
        m6620a(C2908bs.BEGIN_OBJECT);
    }

    /* renamed from: i */
    public final void mo18068i() {
        m6620a(C2908bs.END_OBJECT);
    }

    /* renamed from: a */
    private void m6620a(C2908bs bsVar) {
        mo18070k();
        if (this.f6707k == bsVar) {
            m6626t();
            return;
        }
        StringBuilder sb = new StringBuilder("Expected ");
        sb.append(bsVar);
        sb.append(" but was ");
        sb.append(mo18070k());
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: j */
    public final boolean mo18069j() {
        mo18070k();
        return (this.f6707k == C2908bs.END_OBJECT || this.f6707k == C2908bs.END_ARRAY) ? false : true;
    }

    /* renamed from: k */
    public final C2908bs mo18070k() {
        C2908bs bsVar = this.f6707k;
        if (bsVar != null) {
            return bsVar;
        }
        int[] iArr = C29052.f6713a;
        List list = this.f6706j;
        switch (iArr[((C2906bq) list.get(list.size() - 1)).ordinal()]) {
            case 1:
                m6623b(C2906bq.NONEMPTY_DOCUMENT);
                C2908bs v = m6628v();
                if (this.f6700d || this.f6707k == C2908bs.BEGIN_ARRAY || this.f6707k == C2908bs.BEGIN_OBJECT) {
                    return v;
                }
                StringBuilder sb = new StringBuilder("Expected JSON document to start with '[' or '{' but was ");
                sb.append(this.f6707k);
                throw new IOException(sb.toString());
            case 2:
                return m6617a(true);
            case 3:
                return m6617a(false);
            case 4:
                return m6622b(true);
            case 5:
                int y = m6631y();
                if (y != 58) {
                    if (y == 61) {
                        m6632z();
                        if (this.f6702f < this.f6703g || m6621a(1)) {
                            char[] cArr = this.f6701e;
                            int i = this.f6702f;
                            if (cArr[i] == '>') {
                                this.f6702f = i + 1;
                            }
                        }
                    } else {
                        throw m6625d("Expected ':'");
                    }
                }
                m6623b(C2906bq.NONEMPTY_OBJECT);
                return m6628v();
            case 6:
                return m6622b(false);
            case 7:
                try {
                    C2908bs v2 = m6628v();
                    if (this.f6700d) {
                        return v2;
                    }
                    throw m6625d("Expected EOF");
                } catch (EOFException unused) {
                    C2908bs bsVar2 = C2908bs.END_DOCUMENT;
                    this.f6707k = bsVar2;
                    return bsVar2;
                }
            case 8:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: t */
    private C2908bs m6626t() {
        mo18070k();
        C2908bs bsVar = this.f6707k;
        this.f6707k = null;
        this.f6709m = null;
        this.f6708l = null;
        return bsVar;
    }

    /* renamed from: l */
    public final String mo18071l() {
        mo18070k();
        if (this.f6707k == C2908bs.NAME) {
            String str = this.f6708l;
            m6626t();
            return str;
        }
        StringBuilder sb = new StringBuilder("Expected a name but was ");
        sb.append(mo18070k());
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: m */
    public final String mo18072m() {
        mo18070k();
        if (this.f6707k == C2908bs.STRING || this.f6707k == C2908bs.NUMBER) {
            String str = this.f6709m;
            m6626t();
            return str;
        }
        StringBuilder sb = new StringBuilder("Expected a string but was ");
        sb.append(mo18070k());
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: n */
    public final boolean mo18073n() {
        mo18070k();
        if (this.f6707k == C2908bs.BOOLEAN) {
            boolean z = this.f6709m == "true";
            m6626t();
            return z;
        }
        StringBuilder sb = new StringBuilder("Expected a boolean but was ");
        sb.append(this.f6707k);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: o */
    public final void mo18074o() {
        mo18070k();
        if (this.f6707k == C2908bs.NULL) {
            m6626t();
            return;
        }
        StringBuilder sb = new StringBuilder("Expected null but was ");
        sb.append(this.f6707k);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: p */
    public final double mo18075p() {
        mo18070k();
        if (this.f6707k == C2908bs.STRING || this.f6707k == C2908bs.NUMBER) {
            double parseDouble = Double.parseDouble(this.f6709m);
            m6626t();
            return parseDouble;
        }
        StringBuilder sb = new StringBuilder("Expected a double but was ");
        sb.append(this.f6707k);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: q */
    public final long mo18076q() {
        long j;
        mo18070k();
        if (this.f6707k == C2908bs.STRING || this.f6707k == C2908bs.NUMBER) {
            try {
                j = Long.parseLong(this.f6709m);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.f6709m);
                long j2 = (long) parseDouble;
                if (((double) j2) == parseDouble) {
                    j = j2;
                } else {
                    throw new NumberFormatException(this.f6709m);
                }
            }
            m6626t();
            return j;
        }
        StringBuilder sb = new StringBuilder("Expected a long but was ");
        sb.append(this.f6707k);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: r */
    public final int mo18077r() {
        int i;
        mo18070k();
        if (this.f6707k == C2908bs.STRING || this.f6707k == C2908bs.NUMBER) {
            try {
                i = Integer.parseInt(this.f6709m);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.f6709m);
                int i2 = (int) parseDouble;
                if (((double) i2) == parseDouble) {
                    i = i2;
                } else {
                    throw new NumberFormatException(this.f6709m);
                }
            }
            m6626t();
            return i;
        }
        StringBuilder sb = new StringBuilder("Expected an int but was ");
        sb.append(this.f6707k);
        throw new IllegalStateException(sb.toString());
    }

    public final void close() {
        this.f6709m = null;
        this.f6707k = null;
        this.f6706j.clear();
        this.f6706j.add(C2906bq.CLOSED);
        this.f6699c.close();
    }

    /* renamed from: s */
    public final void mo18078s() {
        mo18070k();
        if (this.f6707k == C2908bs.END_ARRAY || this.f6707k == C2908bs.END_OBJECT) {
            StringBuilder sb = new StringBuilder("Expected a value but was ");
            sb.append(this.f6707k);
            throw new IllegalStateException(sb.toString());
        }
        this.f6712p = true;
        int i = 0;
        do {
            try {
                C2908bs t = m6626t();
                if (t != C2908bs.BEGIN_ARRAY) {
                    if (t != C2908bs.BEGIN_OBJECT) {
                        if (t == C2908bs.END_ARRAY || t == C2908bs.END_OBJECT) {
                            i--;
                            continue;
                        }
                    }
                }
                i++;
                continue;
            } finally {
                this.f6712p = false;
            }
        } while (i != 0);
    }

    /* renamed from: u */
    private C2906bq m6627u() {
        List list = this.f6706j;
        return (C2906bq) list.remove(list.size() - 1);
    }

    /* renamed from: a */
    private void m6619a(C2906bq bqVar) {
        this.f6706j.add(bqVar);
    }

    /* renamed from: b */
    private void m6623b(C2906bq bqVar) {
        List list = this.f6706j;
        list.set(list.size() - 1, bqVar);
    }

    /* renamed from: a */
    private C2908bs m6617a(boolean z) {
        if (z) {
            m6623b(C2906bq.NONEMPTY_ARRAY);
        } else {
            int y = m6631y();
            if (y != 44) {
                if (y == 59) {
                    m6632z();
                } else if (y == 93) {
                    m6627u();
                    C2908bs bsVar = C2908bs.END_ARRAY;
                    this.f6707k = bsVar;
                    return bsVar;
                } else {
                    throw m6625d("Unterminated array");
                }
            }
        }
        int y2 = m6631y();
        if (!(y2 == 44 || y2 == 59)) {
            if (y2 != 93) {
                this.f6702f--;
                return m6628v();
            } else if (z) {
                m6627u();
                C2908bs bsVar2 = C2908bs.END_ARRAY;
                this.f6707k = bsVar2;
                return bsVar2;
            }
        }
        m6632z();
        this.f6702f--;
        this.f6709m = "null";
        C2908bs bsVar3 = C2908bs.NULL;
        this.f6707k = bsVar3;
        return bsVar3;
    }

    /* renamed from: b */
    private C2908bs m6622b(boolean z) {
        if (!z) {
            int y = m6631y();
            if (!(y == 44 || y == 59)) {
                if (y == 125) {
                    m6627u();
                    C2908bs bsVar = C2908bs.END_OBJECT;
                    this.f6707k = bsVar;
                    return bsVar;
                }
                throw m6625d("Unterminated object");
            }
        } else if (m6631y() != 125) {
            this.f6702f--;
        } else {
            m6627u();
            C2908bs bsVar2 = C2908bs.END_OBJECT;
            this.f6707k = bsVar2;
            return bsVar2;
        }
        int y2 = m6631y();
        if (y2 != 34) {
            if (y2 != 39) {
                m6632z();
                this.f6702f--;
                this.f6708l = m6624c(false);
                if (this.f6708l.length() == 0) {
                    throw m6625d("Expected name");
                }
                m6623b(C2906bq.DANGLING_NAME);
                C2908bs bsVar3 = C2908bs.NAME;
                this.f6707k = bsVar3;
                return bsVar3;
            }
            m6632z();
        }
        this.f6708l = m6618a((char) y2);
        m6623b(C2906bq.DANGLING_NAME);
        C2908bs bsVar32 = C2908bs.NAME;
        this.f6707k = bsVar32;
        return bsVar32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b7  */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tapjoy.internal.C2908bs m6628v() {
        /*
            r13 = this;
            int r0 = r13.m6631y()
            r1 = 34
            if (r0 == r1) goto L_0x01db
            r1 = 39
            if (r0 == r1) goto L_0x01d8
            r1 = 91
            if (r0 == r1) goto L_0x01ce
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x01c4
            int r0 = r13.f6702f
            r1 = 1
            int r0 = r0 - r1
            r13.f6702f = r0
            java.lang.String r0 = r13.m6624c(r1)
            r13.f6709m = r0
            int r0 = r13.f6711o
            if (r0 == 0) goto L_0x01bd
            int r2 = r13.f6710n
            r3 = -1
            if (r2 == r3) goto L_0x01ad
            r3 = 85
            r4 = 117(0x75, float:1.64E-43)
            r5 = 76
            r6 = 108(0x6c, float:1.51E-43)
            r7 = 4
            if (r0 != r7) goto L_0x0079
            r0 = 110(0x6e, float:1.54E-43)
            char[] r8 = r13.f6701e
            char r9 = r8[r2]
            if (r0 == r9) goto L_0x0042
            r0 = 78
            char r2 = r8[r2]
            if (r0 != r2) goto L_0x0079
        L_0x0042:
            char[] r0 = r13.f6701e
            int r2 = r13.f6710n
            int r8 = r2 + 1
            char r8 = r0[r8]
            if (r4 == r8) goto L_0x0051
            int r2 = r2 + r1
            char r0 = r0[r2]
            if (r3 != r0) goto L_0x0079
        L_0x0051:
            char[] r0 = r13.f6701e
            int r2 = r13.f6710n
            int r8 = r2 + 2
            char r8 = r0[r8]
            if (r6 == r8) goto L_0x0061
            int r2 = r2 + 2
            char r0 = r0[r2]
            if (r5 != r0) goto L_0x0079
        L_0x0061:
            char[] r0 = r13.f6701e
            int r2 = r13.f6710n
            int r8 = r2 + 3
            char r8 = r0[r8]
            if (r6 == r8) goto L_0x0071
            int r2 = r2 + 3
            char r0 = r0[r2]
            if (r5 != r0) goto L_0x0079
        L_0x0071:
            java.lang.String r0 = "null"
            r13.f6709m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.NULL
            goto L_0x01af
        L_0x0079:
            int r0 = r13.f6711o
            r2 = 69
            r8 = 101(0x65, float:1.42E-43)
            if (r0 != r7) goto L_0x00cc
            r0 = 116(0x74, float:1.63E-43)
            char[] r9 = r13.f6701e
            int r10 = r13.f6710n
            char r11 = r9[r10]
            if (r0 == r11) goto L_0x0091
            r0 = 84
            char r9 = r9[r10]
            if (r0 != r9) goto L_0x00cc
        L_0x0091:
            r0 = 114(0x72, float:1.6E-43)
            char[] r9 = r13.f6701e
            int r10 = r13.f6710n
            int r11 = r10 + 1
            char r11 = r9[r11]
            if (r0 == r11) goto L_0x00a4
            r0 = 82
            int r10 = r10 + r1
            char r9 = r9[r10]
            if (r0 != r9) goto L_0x00cc
        L_0x00a4:
            char[] r0 = r13.f6701e
            int r9 = r13.f6710n
            int r10 = r9 + 2
            char r10 = r0[r10]
            if (r4 == r10) goto L_0x00b4
            int r9 = r9 + 2
            char r0 = r0[r9]
            if (r3 != r0) goto L_0x00cc
        L_0x00b4:
            char[] r0 = r13.f6701e
            int r3 = r13.f6710n
            int r4 = r3 + 3
            char r4 = r0[r4]
            if (r8 == r4) goto L_0x00c4
            int r3 = r3 + 3
            char r0 = r0[r3]
            if (r2 != r0) goto L_0x00cc
        L_0x00c4:
            java.lang.String r0 = "true"
            r13.f6709m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.BOOLEAN
            goto L_0x01af
        L_0x00cc:
            int r0 = r13.f6711o
            r3 = 5
            if (r0 != r3) goto L_0x012f
            r0 = 102(0x66, float:1.43E-43)
            char[] r3 = r13.f6701e
            int r4 = r13.f6710n
            char r9 = r3[r4]
            if (r0 == r9) goto L_0x00e1
            r0 = 70
            char r3 = r3[r4]
            if (r0 != r3) goto L_0x012f
        L_0x00e1:
            r0 = 97
            char[] r3 = r13.f6701e
            int r4 = r13.f6710n
            int r9 = r4 + 1
            char r9 = r3[r9]
            if (r0 == r9) goto L_0x00f4
            r0 = 65
            int r4 = r4 + r1
            char r3 = r3[r4]
            if (r0 != r3) goto L_0x012f
        L_0x00f4:
            char[] r0 = r13.f6701e
            int r3 = r13.f6710n
            int r4 = r3 + 2
            char r4 = r0[r4]
            if (r6 == r4) goto L_0x0104
            int r3 = r3 + 2
            char r0 = r0[r3]
            if (r5 != r0) goto L_0x012f
        L_0x0104:
            r0 = 115(0x73, float:1.61E-43)
            char[] r3 = r13.f6701e
            int r4 = r13.f6710n
            int r5 = r4 + 3
            char r5 = r3[r5]
            if (r0 == r5) goto L_0x0118
            r0 = 83
            int r4 = r4 + 3
            char r3 = r3[r4]
            if (r0 != r3) goto L_0x012f
        L_0x0118:
            char[] r0 = r13.f6701e
            int r3 = r13.f6710n
            int r4 = r3 + 4
            char r4 = r0[r4]
            if (r8 == r4) goto L_0x0127
            int r3 = r3 + r7
            char r0 = r0[r3]
            if (r2 != r0) goto L_0x012f
        L_0x0127:
            java.lang.String r0 = "false"
            r13.f6709m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.BOOLEAN
            goto L_0x01af
        L_0x012f:
            com.tapjoy.internal.cj r0 = r13.f6698b
            char[] r3 = r13.f6701e
            int r4 = r13.f6710n
            int r5 = r13.f6711o
            java.lang.String r0 = r0.mo29915a(r3, r4, r5)
            r13.f6709m = r0
            char[] r0 = r13.f6701e
            int r3 = r13.f6710n
            int r4 = r13.f6711o
            char r5 = r0[r3]
            r6 = 45
            if (r5 != r6) goto L_0x0151
            int r5 = r3 + 1
            char r7 = r0[r5]
            r12 = r7
            r7 = r5
            r5 = r12
            goto L_0x0152
        L_0x0151:
            r7 = r3
        L_0x0152:
            r9 = 57
            r10 = 48
            if (r5 != r10) goto L_0x015c
            int r7 = r7 + r1
            char r5 = r0[r7]
            goto L_0x016e
        L_0x015c:
            r11 = 49
            if (r5 < r11) goto L_0x01aa
            if (r5 > r9) goto L_0x01aa
            int r7 = r7 + r1
            char r5 = r0[r7]
        L_0x0165:
            if (r5 < r10) goto L_0x016e
            if (r5 > r9) goto L_0x016e
            int r7 = r7 + 1
            char r5 = r0[r7]
            goto L_0x0165
        L_0x016e:
            r11 = 46
            if (r5 != r11) goto L_0x017f
            int r7 = r7 + 1
            char r5 = r0[r7]
        L_0x0176:
            if (r5 < r10) goto L_0x017f
            if (r5 > r9) goto L_0x017f
            int r7 = r7 + 1
            char r5 = r0[r7]
            goto L_0x0176
        L_0x017f:
            if (r5 == r8) goto L_0x0183
            if (r5 != r2) goto L_0x01a1
        L_0x0183:
            int r7 = r7 + 1
            char r2 = r0[r7]
            r5 = 43
            if (r2 == r5) goto L_0x018d
            if (r2 != r6) goto L_0x0191
        L_0x018d:
            int r7 = r7 + 1
            char r2 = r0[r7]
        L_0x0191:
            if (r2 < r10) goto L_0x01a7
            if (r2 > r9) goto L_0x01a7
            int r7 = r7 + r1
            char r1 = r0[r7]
        L_0x0198:
            if (r1 < r10) goto L_0x01a1
            if (r1 > r9) goto L_0x01a1
            int r7 = r7 + 1
            char r1 = r0[r7]
            goto L_0x0198
        L_0x01a1:
            int r3 = r3 + r4
            if (r7 != r3) goto L_0x01ad
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.NUMBER
            goto L_0x01af
        L_0x01a7:
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.STRING
            goto L_0x01af
        L_0x01aa:
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.STRING
            goto L_0x01af
        L_0x01ad:
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.STRING
        L_0x01af:
            r13.f6707k = r0
            com.tapjoy.internal.bs r0 = r13.f6707k
            com.tapjoy.internal.bs r1 = com.tapjoy.internal.C2908bs.STRING
            if (r0 != r1) goto L_0x01ba
            r13.m6632z()
        L_0x01ba:
            com.tapjoy.internal.bs r0 = r13.f6707k
            return r0
        L_0x01bd:
            java.lang.String r0 = "Expected literal value"
            java.io.IOException r0 = r13.m6625d(r0)
            throw r0
        L_0x01c4:
            com.tapjoy.internal.bq r0 = com.tapjoy.internal.C2906bq.EMPTY_OBJECT
            r13.m6619a(r0)
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.BEGIN_OBJECT
            r13.f6707k = r0
            return r0
        L_0x01ce:
            com.tapjoy.internal.bq r0 = com.tapjoy.internal.C2906bq.EMPTY_ARRAY
            r13.m6619a(r0)
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.BEGIN_ARRAY
            r13.f6707k = r0
            return r0
        L_0x01d8:
            r13.m6632z()
        L_0x01db:
            char r0 = (char) r0
            java.lang.String r0 = r13.m6618a(r0)
            r13.f6709m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C2908bs.STRING
            r13.f6707k = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2903bo.m6628v():com.tapjoy.internal.bs");
    }

    /* renamed from: a */
    private boolean m6621a(int i) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = this.f6702f;
            if (i3 >= i2) {
                break;
            }
            if (this.f6701e[i3] == 10) {
                this.f6704h++;
                this.f6705i = 1;
            } else {
                this.f6705i++;
            }
            i3++;
        }
        int i4 = this.f6703g;
        if (i4 != i2) {
            this.f6703g = i4 - i2;
            char[] cArr = this.f6701e;
            System.arraycopy(cArr, i2, cArr, 0, this.f6703g);
        } else {
            this.f6703g = 0;
        }
        this.f6702f = 0;
        do {
            Reader reader = this.f6699c;
            char[] cArr2 = this.f6701e;
            int i5 = this.f6703g;
            int read = reader.read(cArr2, i5, cArr2.length - i5);
            if (read == -1) {
                return false;
            }
            this.f6703g += read;
            if (this.f6704h == 1) {
                int i6 = this.f6705i;
                if (i6 == 1 && this.f6703g > 0 && this.f6701e[0] == 65279) {
                    this.f6702f++;
                    this.f6705i = i6 - 1;
                }
            }
        } while (this.f6703g < i);
        return true;
    }

    /* renamed from: w */
    private int m6629w() {
        int i = this.f6704h;
        for (int i2 = 0; i2 < this.f6702f; i2++) {
            if (this.f6701e[i2] == 10) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: x */
    private int m6630x() {
        int i = this.f6705i;
        for (int i2 = 0; i2 < this.f6702f; i2++) {
            i = this.f6701e[i2] == 10 ? 1 : i + 1;
        }
        return i;
    }

    /* renamed from: y */
    private int m6631y() {
        while (true) {
            boolean z = true;
            if (this.f6702f < this.f6703g || m6621a(1)) {
                char[] cArr = this.f6701e;
                int i = this.f6702f;
                this.f6702f = i + 1;
                char c = cArr[i];
                if (!(c == 9 || c == 10 || c == 13 || c == ' ')) {
                    if (c == '#') {
                        m6632z();
                        m6616A();
                    } else if (c != '/') {
                        return c;
                    } else {
                        if (this.f6702f == this.f6703g && !m6621a(1)) {
                            return c;
                        }
                        m6632z();
                        char[] cArr2 = this.f6701e;
                        int i2 = this.f6702f;
                        char c2 = cArr2[i2];
                        if (c2 == '*') {
                            this.f6702f = i2 + 1;
                            while (true) {
                                int i3 = 0;
                                if (this.f6702f + 2 > this.f6703g && !m6621a(2)) {
                                    z = false;
                                    break;
                                }
                                while (i3 < 2) {
                                    if (this.f6701e[this.f6702f + i3] == "*/".charAt(i3)) {
                                        i3++;
                                    } else {
                                        this.f6702f++;
                                    }
                                }
                                break;
                            }
                            if (z) {
                                this.f6702f += 2;
                            } else {
                                throw m6625d("Unterminated comment");
                            }
                        } else if (c2 != '/') {
                            return c;
                        } else {
                            this.f6702f = i2 + 1;
                            m6616A();
                        }
                    }
                }
            } else {
                throw new EOFException("End of input");
            }
        }
    }

    /* renamed from: z */
    private void m6632z() {
        if (!this.f6700d) {
            throw m6625d("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: A */
    private void m6616A() {
        char c;
        do {
            if (this.f6702f < this.f6703g || m6621a(1)) {
                char[] cArr = this.f6701e;
                int i = this.f6702f;
                this.f6702f = i + 1;
                c = cArr[i];
                if (c == 13) {
                    return;
                }
            } else {
                return;
            }
        } while (c != 10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bf, code lost:
        if (r0 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c1, code lost:
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c6, code lost:
        r0.append(r6.f6701e, r1, r6.f6702f - r1);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m6618a(char r7) {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            int r1 = r6.f6702f
        L_0x0003:
            int r2 = r6.f6702f
            int r3 = r6.f6703g
            r4 = 1
            if (r2 >= r3) goto L_0x00bf
            char[] r3 = r6.f6701e
            int r5 = r2 + 1
            r6.f6702f = r5
            char r2 = r3[r2]
            if (r2 != r7) goto L_0x0034
            boolean r7 = r6.f6712p
            if (r7 == 0) goto L_0x001b
            java.lang.String r7 = "skipped!"
            return r7
        L_0x001b:
            if (r0 != 0) goto L_0x0028
            com.tapjoy.internal.cj r7 = r6.f6698b
            int r0 = r6.f6702f
            int r0 = r0 - r1
            int r0 = r0 - r4
            java.lang.String r7 = r7.mo29915a(r3, r1, r0)
            return r7
        L_0x0028:
            int r7 = r6.f6702f
            int r7 = r7 - r1
            int r7 = r7 - r4
            r0.append(r3, r1, r7)
            java.lang.String r7 = r0.toString()
            return r7
        L_0x0034:
            r3 = 92
            if (r2 != r3) goto L_0x0003
            if (r0 != 0) goto L_0x003f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x003f:
            char[] r2 = r6.f6701e
            int r3 = r6.f6702f
            int r3 = r3 - r1
            int r3 = r3 - r4
            r0.append(r2, r1, r3)
            int r1 = r6.f6702f
            int r2 = r6.f6703g
            java.lang.String r3 = "Unterminated escape sequence"
            if (r1 != r2) goto L_0x005c
            boolean r1 = r6.m6621a(r4)
            if (r1 == 0) goto L_0x0057
            goto L_0x005c
        L_0x0057:
            java.io.IOException r7 = r6.m6625d(r3)
            throw r7
        L_0x005c:
            char[] r1 = r6.f6701e
            int r2 = r6.f6702f
            int r4 = r2 + 1
            r6.f6702f = r4
            char r1 = r1[r2]
            r2 = 98
            if (r1 == r2) goto L_0x00b6
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x00b3
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x00b0
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L_0x00ad
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L_0x00aa
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L_0x007f
            goto L_0x00b8
        L_0x007f:
            int r1 = r6.f6702f
            r2 = 4
            int r1 = r1 + r2
            int r4 = r6.f6703g
            if (r1 <= r4) goto L_0x0093
            boolean r1 = r6.m6621a(r2)
            if (r1 == 0) goto L_0x008e
            goto L_0x0093
        L_0x008e:
            java.io.IOException r7 = r6.m6625d(r3)
            throw r7
        L_0x0093:
            com.tapjoy.internal.cj r1 = r6.f6698b
            char[] r3 = r6.f6701e
            int r4 = r6.f6702f
            java.lang.String r1 = r1.mo29915a(r3, r4, r2)
            int r3 = r6.f6702f
            int r3 = r3 + r2
            r6.f6702f = r3
            r2 = 16
            int r1 = java.lang.Integer.parseInt(r1, r2)
            char r1 = (char) r1
            goto L_0x00b8
        L_0x00aa:
            r1 = 9
            goto L_0x00b8
        L_0x00ad:
            r1 = 13
            goto L_0x00b8
        L_0x00b0:
            r1 = 10
            goto L_0x00b8
        L_0x00b3:
            r1 = 12
            goto L_0x00b8
        L_0x00b6:
            r1 = 8
        L_0x00b8:
            r0.append(r1)
            int r1 = r6.f6702f
            goto L_0x0003
        L_0x00bf:
            if (r0 != 0) goto L_0x00c6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x00c6:
            char[] r2 = r6.f6701e
            int r3 = r6.f6702f
            int r3 = r3 - r1
            r0.append(r2, r1, r3)
            boolean r1 = r6.m6621a(r4)
            if (r1 == 0) goto L_0x00d6
            goto L_0x0001
        L_0x00d6:
            java.lang.String r7 = "Unterminated string"
            java.io.IOException r7 = r6.m6625d(r7)
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2903bo.m6618a(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        m6632z();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m6624c(boolean r8) {
        /*
            r7 = this;
            r0 = -1
            r7.f6710n = r0
            r0 = 0
            r7.f6711o = r0
            r1 = 0
            r3 = r1
        L_0x0008:
            r2 = 0
        L_0x0009:
            int r4 = r7.f6702f
            int r5 = r4 + r2
            int r6 = r7.f6703g
            if (r5 >= r6) goto L_0x0054
            char[] r5 = r7.f6701e
            int r4 = r4 + r2
            char r4 = r5[r4]
            r5 = 9
            if (r4 == r5) goto L_0x0067
            r5 = 10
            if (r4 == r5) goto L_0x0067
            r5 = 12
            if (r4 == r5) goto L_0x0067
            r5 = 13
            if (r4 == r5) goto L_0x0067
            r5 = 32
            if (r4 == r5) goto L_0x0067
            r5 = 35
            if (r4 == r5) goto L_0x0050
            r5 = 44
            if (r4 == r5) goto L_0x0067
            r5 = 47
            if (r4 == r5) goto L_0x0050
            r5 = 61
            if (r4 == r5) goto L_0x0050
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L_0x0067
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L_0x0067
            r5 = 58
            if (r4 == r5) goto L_0x0067
            r5 = 59
            if (r4 == r5) goto L_0x0050
            switch(r4) {
                case 91: goto L_0x0067;
                case 92: goto L_0x0050;
                case 93: goto L_0x0067;
                default: goto L_0x004d;
            }
        L_0x004d:
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0050:
            r7.m6632z()
            goto L_0x0067
        L_0x0054:
            char[] r4 = r7.f6701e
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0069
            int r4 = r2 + 1
            boolean r4 = r7.m6621a(r4)
            if (r4 != 0) goto L_0x0009
            char[] r4 = r7.f6701e
            int r5 = r7.f6703g
            r4[r5] = r0
        L_0x0067:
            r0 = r2
            goto L_0x0088
        L_0x0069:
            if (r3 != 0) goto L_0x0070
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0070:
            char[] r4 = r7.f6701e
            int r5 = r7.f6702f
            r3.append(r4, r5, r2)
            int r4 = r7.f6711o
            int r4 = r4 + r2
            r7.f6711o = r4
            int r4 = r7.f6702f
            int r4 = r4 + r2
            r7.f6702f = r4
            r2 = 1
            boolean r2 = r7.m6621a(r2)
            if (r2 != 0) goto L_0x0008
        L_0x0088:
            if (r8 == 0) goto L_0x0091
            if (r3 != 0) goto L_0x0091
            int r8 = r7.f6702f
            r7.f6710n = r8
            goto L_0x00b0
        L_0x0091:
            boolean r8 = r7.f6712p
            if (r8 == 0) goto L_0x0098
            java.lang.String r1 = "skipped!"
            goto L_0x00b0
        L_0x0098:
            if (r3 != 0) goto L_0x00a5
            com.tapjoy.internal.cj r8 = r7.f6698b
            char[] r1 = r7.f6701e
            int r2 = r7.f6702f
            java.lang.String r1 = r8.mo29915a(r1, r2, r0)
            goto L_0x00b0
        L_0x00a5:
            char[] r8 = r7.f6701e
            int r1 = r7.f6702f
            r3.append(r8, r1, r0)
            java.lang.String r1 = r3.toString()
        L_0x00b0:
            int r8 = r7.f6711o
            int r8 = r8 + r0
            r7.f6711o = r8
            int r8 = r7.f6702f
            int r8 = r8 + r0
            r7.f6702f = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2903bo.m6624c(boolean):java.lang.String");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" near ");
        StringBuilder sb2 = new StringBuilder();
        int min = Math.min(this.f6702f, 20);
        sb2.append(this.f6701e, this.f6702f - min, min);
        sb2.append(this.f6701e, this.f6702f, Math.min(this.f6703g - this.f6702f, 20));
        sb.append(sb2);
        return sb.toString();
    }

    /* renamed from: d */
    private IOException m6625d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" at line ");
        sb.append(m6629w());
        sb.append(" column ");
        sb.append(m6630x());
        throw new C2911bu(sb.toString());
    }
}
