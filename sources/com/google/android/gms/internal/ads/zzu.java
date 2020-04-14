package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzu {
    private final zzn zzaa;
    private final AtomicInteger zzav;
    private final Set<zzq<?>> zzaw;
    private final PriorityBlockingQueue<zzq<?>> zzax;
    private final PriorityBlockingQueue<zzq<?>> zzay;
    private final zzm[] zzaz;
    private final List<zzw> zzba;
    private final List<zzx> zzbb;
    private final zza zzc;
    private final zzaa zzd;
    private zzc zzo;

    private zzu(zza zza, zzn zzn, int i, zzaa zzaa2) {
        this.zzav = new AtomicInteger();
        this.zzaw = new HashSet();
        this.zzax = new PriorityBlockingQueue<>();
        this.zzay = new PriorityBlockingQueue<>();
        this.zzba = new ArrayList();
        this.zzbb = new ArrayList();
        this.zzc = zza;
        this.zzaa = zzn;
        this.zzaz = new zzm[4];
        this.zzd = zzaa2;
    }

    private zzu(zza zza, zzn zzn, int i) {
        this(zza, zzn, 4, new zzj(new Handler(Looper.getMainLooper())));
    }

    public zzu(zza zza, zzn zzn) {
        this(zza, zzn, 4);
    }

    public final void start() {
        zzm[] zzmArr;
        zzc zzc2 = this.zzo;
        if (zzc2 != null) {
            zzc2.quit();
        }
        for (zzm zzm : this.zzaz) {
            if (zzm != null) {
                zzm.quit();
            }
        }
        this.zzo = new zzc(this.zzax, this.zzay, this.zzc, this.zzd);
        this.zzo.start();
        for (int i = 0; i < this.zzaz.length; i++) {
            zzm zzm2 = new zzm(this.zzay, this.zzaa, this.zzc, this.zzd);
            this.zzaz[i] = zzm2;
            zzm2.start();
        }
    }

    public final <T> zzq<T> zze(zzq<T> zzq) {
        zzq.zza(this);
        synchronized (this.zzaw) {
            this.zzaw.add(zzq);
        }
        zzq.zzb(this.zzav.incrementAndGet());
        zzq.zzb("add-to-queue");
        zza(zzq, 0);
        if (!zzq.zzg()) {
            this.zzay.add(zzq);
            return zzq;
        }
        this.zzax.add(zzq);
        return zzq;
    }

    /* access modifiers changed from: 0000 */
    public final <T> void zzf(zzq<T> zzq) {
        synchronized (this.zzaw) {
            this.zzaw.remove(zzq);
        }
        synchronized (this.zzba) {
            for (zzw zzg : this.zzba) {
                zzg.zzg(zzq);
            }
        }
        zza(zzq, 5);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzq<?> zzq, int i) {
        synchronized (this.zzbb) {
            for (zzx zzb : this.zzbb) {
                zzb.zzb(zzq, i);
            }
        }
    }
}
