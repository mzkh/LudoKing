package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.inmobi.media.ht */
/* compiled from: BitmapDetector */
public class C2585ht {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f5699b = "ht";

    /* renamed from: a */
    public final WeakReference<View> f5700a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final WeakReference<C2590a> f5701c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f5702d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f5703e = false;

    /* renamed from: com.inmobi.media.ht$a */
    /* compiled from: BitmapDetector */
    public interface C2590a {
        /* renamed from: k */
        void mo28587k();

        /* renamed from: l */
        void mo28588l();
    }

    public C2585ht(@NonNull View view, @NonNull C2590a aVar) {
        this.f5701c = new WeakReference<>(aVar);
        this.f5700a = new WeakReference<>(view);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: b */
    public static Bitmap m5630b(final View view) throws IllegalStateException {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            throw new IllegalStateException();
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
        final Canvas canvas = new Canvas(createBitmap);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        view.post(new Runnable() {
            public final void run() {
                view.draw(canvas);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return createBitmap;
    }
}
