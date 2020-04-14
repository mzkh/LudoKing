package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzm extends Thread {
    private final zzn zzaa;
    private final zza zzc;
    private final zzaa zzd;
    private volatile boolean zze = false;
    private final BlockingQueue<zzq<?>> zzz;

    public zzm(BlockingQueue<zzq<?>> blockingQueue, zzn zzn, zza zza, zzaa zzaa2) {
        this.zzz = blockingQueue;
        this.zzaa = zzn;
        this.zzc = zza;
        this.zzd = zzaa2;
    }

    public final void quit() {
        this.zze = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    zzag.m3712e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    private final void processRequest() throws InterruptedException {
        zzq zzq = (zzq) this.zzz.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzq.zza(3);
        try {
            zzq.zzb("network-queue-take");
            zzq.isCanceled();
            TrafficStats.setThreadStatsTag(zzq.zzc());
            zzo zzc2 = this.zzaa.zzc(zzq);
            zzq.zzb("network-http-complete");
            if (!zzc2.zzac || !zzq.zzk()) {
                zzz zza = zzq.zza(zzc2);
                zzq.zzb("network-parse-complete");
                if (zzq.zzg() && zza.zzbh != null) {
                    this.zzc.zza(zzq.zzd(), zza.zzbh);
                    zzq.zzb("network-cache-written");
                }
                zzq.zzj();
                this.zzd.zzb(zzq, zza);
                zzq.zza(zza);
                zzq.zza(4);
                return;
            }
            zzq.zzc("not-modified");
            zzq.zzl();
        } catch (zzae e) {
            e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzd.zza(zzq, e);
            zzq.zzl();
        } catch (Exception e2) {
            zzag.zza(e2, "Unhandled exception %s", e2.toString());
            zzae zzae = new zzae((Throwable) e2);
            zzae.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzd.zza(zzq, zzae);
            zzq.zzl();
        } finally {
            zzq.zza(4);
        }
    }
}
