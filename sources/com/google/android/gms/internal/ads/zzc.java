package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzc extends Thread {
    private static final boolean DEBUG = zzag.DEBUG;
    private final BlockingQueue<zzq<?>> zza;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzq<?>> zzb;
    private final zza zzc;
    /* access modifiers changed from: private */
    public final zzaa zzd;
    private volatile boolean zze = false;
    private final zze zzf;

    public zzc(BlockingQueue<zzq<?>> blockingQueue, BlockingQueue<zzq<?>> blockingQueue2, zza zza2, zzaa zzaa) {
        this.zza = blockingQueue;
        this.zzb = blockingQueue2;
        this.zzc = zza2;
        this.zzd = zzaa;
        this.zzf = new zze(this);
    }

    public final void quit() {
        this.zze = true;
        interrupt();
    }

    public final void run() {
        if (DEBUG) {
            zzag.m3713v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzc.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    zzag.m3712e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    private final void processRequest() throws InterruptedException {
        zzq zzq = (zzq) this.zza.take();
        zzq.zzb("cache-queue-take");
        zzq.zza(1);
        try {
            zzq.isCanceled();
            zzd zza2 = this.zzc.zza(zzq.zzd());
            if (zza2 == null) {
                zzq.zzb("cache-miss");
                if (!this.zzf.zzb(zzq)) {
                    this.zzb.put(zzq);
                }
            } else if (zza2.isExpired()) {
                zzq.zzb("cache-hit-expired");
                zzq.zza(zza2);
                if (!this.zzf.zzb(zzq)) {
                    this.zzb.put(zzq);
                }
                zzq.zza(2);
            } else {
                zzq.zzb("cache-hit");
                zzz zza3 = zzq.zza(new zzo(zza2.data, zza2.zzl));
                zzq.zzb("cache-hit-parsed");
                if (!(zza2.zzk < System.currentTimeMillis())) {
                    this.zzd.zzb(zzq, zza3);
                } else {
                    zzq.zzb("cache-hit-refresh-needed");
                    zzq.zza(zza2);
                    zza3.zzbj = true;
                    if (!this.zzf.zzb(zzq)) {
                        this.zzd.zza(zzq, zza3, new zzf(this, zzq));
                    } else {
                        this.zzd.zzb(zzq, zza3);
                    }
                }
                zzq.zza(2);
            }
        } finally {
            zzq.zza(2);
        }
    }
}
