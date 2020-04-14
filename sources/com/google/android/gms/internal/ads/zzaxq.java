package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaxq implements ThreadFactory {
    private final /* synthetic */ String zzdwp;
    private final AtomicInteger zzyl = new AtomicInteger(1);

    zzaxq(String str) {
        this.zzdwp = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzdwp;
        int andIncrement = this.zzyl.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
