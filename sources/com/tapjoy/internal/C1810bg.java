package com.tapjoy.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.bg */
public final class C1810bg {
    /* renamed from: a */
    public static String m3458a(File file, Charset charset) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return C3235jy.m7508a(new InputStreamReader(fileInputStream, charset));
        } finally {
            C1854jz.m3672a(fileInputStream);
        }
    }

    /* renamed from: a */
    public static void m3459a(OutputStream outputStream, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, C2873ak.f6671c);
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
    }

    @Nullable
    /* renamed from: a */
    public static String m3457a(File file) {
        try {
            return m3458a(file, C2873ak.f6671c);
        } catch (IOException unused) {
            return null;
        }
    }
}
