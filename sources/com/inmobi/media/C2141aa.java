package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.UiThread;

/* renamed from: com.inmobi.media.aa */
/* compiled from: UiRunnable */
abstract class C2141aa<T> implements Runnable {
    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public abstract void mo27772a(T t);

    C2141aa() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo27773b(final T t) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                C2141aa.this.mo27772a(t);
            }
        });
    }
}
