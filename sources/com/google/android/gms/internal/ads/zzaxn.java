package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaxn {
    public static final zzddl zzdwi;
    public static final zzddl zzdwj;
    public static final zzddl zzdwk;
    public static final ScheduledExecutorService zzdwl = new ScheduledThreadPoolExecutor(3, zzex(AppEventsConstants.EVENT_NAME_SCHEDULE));
    public static final zzddl zzdwm = zza(new zzaxp());
    public static final zzddl zzdwn = zza(zzddk.zzapk());

    private static ThreadFactory zzex(String str) {
        return new zzaxq(str);
    }

    private static zzddl zza(Executor executor) {
        return new zzaxs(executor, null);
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), zzex("Default"));
        zzdwi = zza(threadPoolExecutor);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzex("Loader"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        zzdwj = zza(threadPoolExecutor2);
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzex("Activeview"));
        threadPoolExecutor3.allowCoreThreadTimeOut(true);
        zzdwk = zza(threadPoolExecutor3);
    }
}
