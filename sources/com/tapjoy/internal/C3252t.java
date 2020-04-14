package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tapjoy.internal.t */
public final class C3252t implements C2892bd {

    /* renamed from: a */
    public static final C3252t f7773a = new C3252t();

    /* renamed from: a */
    public final /* synthetic */ void mo18182a(OutputStream outputStream, Object obj) {
        if (!((Bitmap) obj).compress(CompressFormat.PNG, 100, outputStream)) {
            throw new RuntimeException();
        }
    }

    private C3252t() {
    }

    /* renamed from: a */
    public final Bitmap mo18183b(final InputStream inputStream) {
        try {
            return (Bitmap) C3260y.m7572a(new C2890bb() {
                public final /* synthetic */ Object call() {
                    InputStream inputStream = inputStream;
                    if (inputStream instanceof C2891bc) {
                        return BitmapFactory.decodeStream(inputStream);
                    }
                    return BitmapFactory.decodeStream(new C2891bc(inputStream));
                }
            });
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
