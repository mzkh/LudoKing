package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public interface zzddl extends ExecutorService {
    <T> zzddi<T> zzd(Callable<T> callable);

    zzddi<?> zzf(Runnable runnable);
}
