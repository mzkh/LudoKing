package com.tapjoy.internal;

import java.nio.CharBuffer;

/* renamed from: com.tapjoy.internal.jy */
public final class C3235jy {
    /* renamed from: a */
    private static long m7507a(Readable readable, Appendable appendable) {
        CharBuffer allocate = CharBuffer.allocate(2048);
        long j = 0;
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return j;
            }
            allocate.flip();
            appendable.append(allocate, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static String m7508a(Readable readable) {
        StringBuilder sb = new StringBuilder();
        m7507a(readable, sb);
        return sb.toString();
    }
}
