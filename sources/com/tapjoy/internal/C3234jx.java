package com.tapjoy.internal;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tapjoy.internal.jx */
public final class C3234jx {
    /* renamed from: a */
    public static long m7506a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
