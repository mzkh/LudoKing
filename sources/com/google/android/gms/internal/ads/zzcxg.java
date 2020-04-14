package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcxg implements ThreadFactory {
    private final AtomicInteger zzyl = new AtomicInteger(1);

    zzcxg() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzyl.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
