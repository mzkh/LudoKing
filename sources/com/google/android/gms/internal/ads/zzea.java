package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzea implements ThreadFactory {
    private final ThreadFactory zzyk = Executors.defaultThreadFactory();
    private final AtomicInteger zzyl = new AtomicInteger(1);

    zzea() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzyk.newThread(runnable);
        int andIncrement = this.zzyl.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
