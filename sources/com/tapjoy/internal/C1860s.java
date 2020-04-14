package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.s */
public final class C1860s extends ContentHandler {

    /* renamed from: a */
    public static final C1860s f3912a = new C1860s();

    @Nullable
    public final /* synthetic */ Object getContent(URLConnection uRLConnection) {
        return m3696a(uRLConnection);
    }

    private C1860s() {
    }

    @Nullable
    /* renamed from: a */
    private static Bitmap m3696a(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            return C3252t.f7773a.mo18183b(inputStream);
        } finally {
            inputStream.close();
        }
    }

    @Nullable
    /* renamed from: a */
    public static Bitmap m3695a(InputStream inputStream) {
        try {
            return C3252t.f7773a.mo18183b(inputStream);
        } finally {
            inputStream.close();
        }
    }
}
