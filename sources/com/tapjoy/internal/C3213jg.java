package com.tapjoy.internal;

import java.io.PrintStream;
import java.util.Map;

/* renamed from: com.tapjoy.internal.jg */
public final class C3213jg {
    /* renamed from: a */
    public static void m7463a(StringBuffer stringBuffer, Object obj, Map map) {
        if (obj == null) {
            stringBuffer.append("null");
        } else if (!obj.getClass().isArray()) {
            try {
                stringBuffer.append(obj.toString());
            } catch (Throwable th) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder("SLF4J: Failed toString() invocation on an object of type [");
                sb.append(obj.getClass().getName());
                sb.append("]");
                printStream.println(sb.toString());
                th.printStackTrace();
                stringBuffer.append("[FAILED toString()]");
            }
        } else if (obj instanceof boolean[]) {
            m7472a(stringBuffer, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            m7464a(stringBuffer, (byte[]) obj);
        } else if (obj instanceof char[]) {
            m7465a(stringBuffer, (char[]) obj);
        } else if (obj instanceof short[]) {
            m7471a(stringBuffer, (short[]) obj);
        } else if (obj instanceof int[]) {
            m7468a(stringBuffer, (int[]) obj);
        } else if (obj instanceof long[]) {
            m7469a(stringBuffer, (long[]) obj);
        } else if (obj instanceof float[]) {
            m7467a(stringBuffer, (float[]) obj);
        } else if (obj instanceof double[]) {
            m7466a(stringBuffer, (double[]) obj);
        } else {
            m7470a(stringBuffer, (Object[]) obj, map);
        }
    }

    /* renamed from: a */
    private static void m7470a(StringBuffer stringBuffer, Object[] objArr, Map map) {
        stringBuffer.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m7463a(stringBuffer, objArr[i], map);
                if (i != length - 1) {
                    stringBuffer.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            stringBuffer.append("...");
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7472a(StringBuffer stringBuffer, boolean[] zArr) {
        stringBuffer.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(zArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7464a(StringBuffer stringBuffer, byte[] bArr) {
        stringBuffer.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(bArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7465a(StringBuffer stringBuffer, char[] cArr) {
        stringBuffer.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(cArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7471a(StringBuffer stringBuffer, short[] sArr) {
        stringBuffer.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(sArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7468a(StringBuffer stringBuffer, int[] iArr) {
        stringBuffer.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(iArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7469a(StringBuffer stringBuffer, long[] jArr) {
        stringBuffer.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(jArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7467a(StringBuffer stringBuffer, float[] fArr) {
        stringBuffer.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(fArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m7466a(StringBuffer stringBuffer, double[] dArr) {
        stringBuffer.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(dArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }
}
