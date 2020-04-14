package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzasz implements ThreadFactory {
    private final AtomicInteger zzyl = new AtomicInteger(1);

    zzasz(zzasl zzasl) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        int andIncrement = this.zzyl.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
