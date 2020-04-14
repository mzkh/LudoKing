package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdcf {
    private static final Logger zzgqc = Logger.getLogger(zzdcf.class.getName());
    private static final zza zzgqw;
    /* access modifiers changed from: private */
    public volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static abstract class zza {
        private zza() {
        }

        /* access modifiers changed from: 0000 */
        public abstract void zza(zzdcf zzdcf, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: 0000 */
        public abstract int zzd(zzdcf zzdcf);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzb extends zza {
        private zzb() {
            super();
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzdcf zzdcf, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdcf) {
                if (zzdcf.seenExceptions == null) {
                    zzdcf.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public final int zzd(zzdcf zzdcf) {
            int zzc;
            synchronized (zzdcf) {
                zzdcf.remaining = zzdcf.remaining - 1;
                zzc = zzdcf.remaining;
            }
            return zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzc extends zza {
        private final AtomicReferenceFieldUpdater<zzdcf, Set<Throwable>> zzgra;
        private final AtomicIntegerFieldUpdater<zzdcf> zzgrb;

        zzc(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzgra = atomicReferenceFieldUpdater;
            this.zzgrb = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzdcf zzdcf, Set<Throwable> set, Set<Throwable> set2) {
            this.zzgra.compareAndSet(zzdcf, null, set2);
        }

        /* access modifiers changed from: 0000 */
        public final int zzd(zzdcf zzdcf) {
            return this.zzgrb.decrementAndGet(zzdcf);
        }
    }

    zzdcf(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: 0000 */
    public abstract void zzg(Set<Throwable> set);

    /* access modifiers changed from: 0000 */
    public final Set<Throwable> zzape() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzg(newSetFromMap);
        zzgqw.zza(this, null, newSetFromMap);
        return this.seenExceptions;
    }

    /* access modifiers changed from: 0000 */
    public final int zzapf() {
        return zzgqw.zzd(this);
    }

    static {
        Throwable th;
        zza zza2;
        try {
            zza2 = new zzc(AtomicReferenceFieldUpdater.newUpdater(zzdcf.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdcf.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zza2 = new zzb();
        }
        zzgqw = zza2;
        if (th != null) {
            zzgqc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
