package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaxp implements Executor {
    private final Handler zzdwo = new zzauf(Looper.getMainLooper());

    zzaxp() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzq.zzkj();
                zzaul.zza(zzq.zzkn().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzdwo.post(runnable);
        }
    }
}
