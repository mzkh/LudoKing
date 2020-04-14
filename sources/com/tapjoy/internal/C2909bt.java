package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tapjoy.internal.bt */
public final class C2909bt implements Closeable {

    /* renamed from: a */
    final Writer f6734a;

    /* renamed from: b */
    private final List f6735b = new ArrayList();

    /* renamed from: c */
    private String f6736c;

    /* renamed from: d */
    private String f6737d;

    /* renamed from: e */
    private boolean f6738e;

    /* renamed from: com.tapjoy.internal.bt$1 */
    static /* synthetic */ class C29101 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6739a = new int[C2906bq.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.tapjoy.internal.bq[] r0 = com.tapjoy.internal.C2906bq.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6739a = r0
                int[] r0 = f6739a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.EMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6739a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f6739a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.NONEMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f6739a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.DANGLING_NAME     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f6739a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C2906bq.NONEMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2909bt.C29101.<clinit>():void");
        }
    }

    public C2909bt(Writer writer) {
        this.f6735b.add(C2906bq.EMPTY_DOCUMENT);
        this.f6737d = ":";
        if (writer != null) {
            this.f6734a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    /* renamed from: a */
    public final C2909bt mo29889a() {
        return m6650a(C2906bq.EMPTY_ARRAY, "[");
    }

    /* renamed from: b */
    public final C2909bt mo29897b() {
        return m6649a(C2906bq.EMPTY_ARRAY, C2906bq.NONEMPTY_ARRAY, "]");
    }

    /* renamed from: c */
    public final C2909bt mo29899c() {
        return m6650a(C2906bq.EMPTY_OBJECT, "{");
    }

    /* renamed from: d */
    public final C2909bt mo29901d() {
        return m6649a(C2906bq.EMPTY_OBJECT, C2906bq.NONEMPTY_OBJECT, "}");
    }

    /* renamed from: a */
    private C2909bt m6650a(C2906bq bqVar, String str) {
        m6653a(true);
        this.f6735b.add(bqVar);
        this.f6734a.write(str);
        return this;
    }

    /* renamed from: a */
    private C2909bt m6649a(C2906bq bqVar, C2906bq bqVar2, String str) {
        C2906bq e = m6655e();
        if (e == bqVar2 || e == bqVar) {
            List list = this.f6735b;
            list.remove(list.size() - 1);
            if (e == bqVar2) {
                m6657g();
            }
            this.f6734a.write(str);
            return this;
        }
        StringBuilder sb = new StringBuilder("Nesting problem: ");
        sb.append(this.f6735b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: e */
    private C2906bq m6655e() {
        List list = this.f6735b;
        return (C2906bq) list.get(list.size() - 1);
    }

    /* renamed from: a */
    private void m6652a(C2906bq bqVar) {
        List list = this.f6735b;
        list.set(list.size() - 1, bqVar);
    }

    /* renamed from: b */
    public final C2909bt mo29898b(String str) {
        if (str == null) {
            return m6656f();
        }
        m6653a(false);
        m6654c(str);
        return this;
    }

    /* renamed from: f */
    private C2909bt m6656f() {
        m6653a(false);
        this.f6734a.write("null");
        return this;
    }

    /* renamed from: a */
    public final C2909bt mo29890a(long j) {
        m6653a(false);
        this.f6734a.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public final C2909bt mo29892a(Number number) {
        if (number == null) {
            return m6656f();
        }
        String obj = number.toString();
        if (this.f6738e || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m6653a(false);
            this.f6734a.append(obj);
            return this;
        }
        StringBuilder sb = new StringBuilder("Numeric values must be finite, but was ");
        sb.append(number);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void close() {
        this.f6734a.close();
        if (m6655e() != C2906bq.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    /* renamed from: c */
    private void m6654c(String str) {
        String str2 = "\"";
        this.f6734a.write(str2);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                this.f6734a.write("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '\\') {
                    String str3 = "\\u%04x";
                    if (charAt != 8232 && charAt != 8233) {
                        switch (charAt) {
                            case 8:
                                this.f6734a.write("\\b");
                                continue;
                            case 9:
                                this.f6734a.write("\\t");
                                continue;
                            case 10:
                                this.f6734a.write("\\n");
                                continue;
                            default:
                                if (charAt <= 31) {
                                    this.f6734a.write(String.format(str3, new Object[]{Integer.valueOf(charAt)}));
                                    continue;
                                }
                                break;
                        }
                    } else {
                        this.f6734a.write(String.format(str3, new Object[]{Integer.valueOf(charAt)}));
                    }
                } else {
                    this.f6734a.write(92);
                }
                this.f6734a.write(charAt);
            } else {
                this.f6734a.write("\\r");
            }
        }
        this.f6734a.write(str2);
    }

    /* renamed from: g */
    private void m6657g() {
        if (this.f6736c != null) {
            this.f6734a.write("\n");
            for (int i = 1; i < this.f6735b.size(); i++) {
                this.f6734a.write(this.f6736c);
            }
        }
    }

    /* renamed from: a */
    private void m6653a(boolean z) {
        int i = C29101.f6739a[m6655e().ordinal()];
        if (i != 1) {
            if (i == 2) {
                m6652a(C2906bq.NONEMPTY_ARRAY);
                m6657g();
            } else if (i == 3) {
                this.f6734a.append(',');
                m6657g();
            } else if (i == 4) {
                this.f6734a.append(this.f6737d);
                m6652a(C2906bq.NONEMPTY_OBJECT);
            } else if (i != 5) {
                StringBuilder sb = new StringBuilder("Nesting problem: ");
                sb.append(this.f6735b);
                throw new IllegalStateException(sb.toString());
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (this.f6738e || z) {
            m6652a(C2906bq.NONEMPTY_DOCUMENT);
        } else {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
    }

    /* renamed from: a */
    public final C2909bt mo29893a(Object obj) {
        if (obj == null) {
            return m6656f();
        }
        if (obj instanceof C2907br) {
            if (this.f6735b.size() == this.f6735b.size()) {
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(obj.getClass().getName());
            sb.append(".writeToJson(JsonWriter) wrote incomplete value");
            throw new IllegalStateException(sb.toString());
        } else if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            m6653a(false);
            this.f6734a.write(booleanValue ? "true" : "false");
            return this;
        } else if (obj instanceof Number) {
            if (obj instanceof Long) {
                return mo29890a(((Number) obj).longValue());
            }
            if (!(obj instanceof Double)) {
                return mo29892a((Number) obj);
            }
            double doubleValue = ((Number) obj).doubleValue();
            if (this.f6738e || (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue))) {
                m6653a(false);
                this.f6734a.append(Double.toString(doubleValue));
                return this;
            }
            StringBuilder sb2 = new StringBuilder("Numeric values must be finite, but was ");
            sb2.append(doubleValue);
            throw new IllegalArgumentException(sb2.toString());
        } else if (obj instanceof String) {
            return mo29898b((String) obj);
        } else {
            if (obj instanceof C2901bl) {
                return mo29891a((C2901bl) obj);
            }
            if (obj instanceof Collection) {
                return mo29895a((Collection) obj);
            }
            if (obj instanceof Map) {
                return mo29896a((Map) obj);
            }
            if (obj instanceof Date) {
                Date date = (Date) obj;
                if (date == null) {
                    return m6656f();
                }
                return mo29898b(C3257w.m7571a(date));
            } else if (obj instanceof Object[]) {
                return m6651a((Object[]) obj);
            } else {
                StringBuilder sb3 = new StringBuilder("Unknown type: ");
                sb3.append(obj.getClass().getName());
                throw new IllegalArgumentException(sb3.toString());
            }
        }
    }

    /* renamed from: a */
    private C2909bt m6651a(Object[] objArr) {
        if (objArr == null) {
            return m6656f();
        }
        mo29889a();
        for (Object a : objArr) {
            mo29893a(a);
        }
        mo29897b();
        return this;
    }

    /* renamed from: a */
    public final C2909bt mo29891a(C2901bl blVar) {
        m6653a(false);
        blVar.mo29879a(this.f6734a);
        return this;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Collection, code=java.util.Collection<java.lang.Object>, for r2v0, types: [java.util.Collection<java.lang.Object>, java.util.Collection] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tapjoy.internal.C2909bt mo29895a(java.util.Collection<java.lang.Object> r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0007
            com.tapjoy.internal.bt r2 = r1.m6656f()
            return r2
        L_0x0007:
            r1.mo29889a()
            java.util.Iterator r2 = r2.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r2.next()
            r1.mo29893a(r0)
            goto L_0x000e
        L_0x001c:
            r1.mo29897b()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2909bt.mo29895a(java.util.Collection):com.tapjoy.internal.bt");
    }

    /* renamed from: a */
    public final C2909bt mo29894a(String str) {
        if (str != null) {
            C2906bq e = m6655e();
            if (e == C2906bq.NONEMPTY_OBJECT) {
                this.f6734a.write(44);
            } else if (e != C2906bq.EMPTY_OBJECT) {
                StringBuilder sb = new StringBuilder("Nesting problem: ");
                sb.append(this.f6735b);
                throw new IllegalStateException(sb.toString());
            }
            m6657g();
            m6652a(C2906bq.DANGLING_NAME);
            m6654c(str);
            return this;
        }
        throw new NullPointerException("name == null");
    }

    /* renamed from: a */
    public final C2909bt mo29896a(Map map) {
        if (map == null) {
            return m6656f();
        }
        mo29899c();
        for (Entry entry : map.entrySet()) {
            mo29894a(String.valueOf(entry.getKey()));
            mo29893a(entry.getValue());
        }
        mo29901d();
        return this;
    }
}
