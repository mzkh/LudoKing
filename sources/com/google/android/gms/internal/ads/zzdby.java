package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdby<V> extends zzdea implements zzddi<V> {
    /* access modifiers changed from: private */
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final Logger zzgqc = Logger.getLogger(zzdby.class.getName());
    /* access modifiers changed from: private */
    public static final zza zzgqd;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile Object value;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzk waiters;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzc {
        static final zzc zzgqf;
        static final zzc zzgqg;
        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        zzc(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }

        static {
            if (zzdby.GENERATE_CANCELLATION_CAUSES) {
                zzgqg = null;
                zzgqf = null;
                return;
            }
            zzgqg = new zzc(false, null);
            zzgqf = new zzc(true, null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzd {
        static final zzd zzgqh = new zzd(null, null);
        final Executor executor;
        @NullableDecl
        zzd next;
        final Runnable task;

        zzd(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    interface zzg<V> extends zzddi<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static abstract class zzj<V> extends zzdby<V> implements zzg<V> {
        zzj() {
        }

        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return zzdby.super.get(j, timeUnit);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzk {
        static final zzk zzgqp = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        private zzk(boolean z) {
        }

        zzk() {
            zzdby.zzgqd.zza(this, Thread.currentThread());
        }

        /* access modifiers changed from: 0000 */
        public final void zzb(zzk zzk) {
            zzdby.zzgqd.zza(this, zzk);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static abstract class zza {
        private zza() {
        }

        /* access modifiers changed from: 0000 */
        public abstract void zza(zzk zzk, zzk zzk2);

        /* access modifiers changed from: 0000 */
        public abstract void zza(zzk zzk, Thread thread);

        /* access modifiers changed from: 0000 */
        public abstract boolean zza(zzdby<?> zzdby, zzd zzd, zzd zzd2);

        /* access modifiers changed from: 0000 */
        public abstract boolean zza(zzdby<?> zzdby, zzk zzk, zzk zzk2);

        /* access modifiers changed from: 0000 */
        public abstract boolean zza(zzdby<?> zzdby, Object obj, Object obj2);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzb {
        static final zzb zzgqe = new zzb(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzb(Throwable th) {
            this.exception = (Throwable) zzdaq.checkNotNull(th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zze<V> implements Runnable {
        final zzddi<? extends V> future;
        final zzdby<V> zzgqi;

        zze(zzdby<V> zzdby, zzddi<? extends V> zzddi) {
            this.zzgqi = zzdby;
            this.future = zzddi;
        }

        public final void run() {
            if (this.zzgqi.value == this) {
                if (zzdby.zzgqd.zza(this.zzgqi, (Object) this, zzdby.getFutureValue(this.future))) {
                    zzdby.zza(this.zzgqi);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzf extends zza {
        final AtomicReferenceFieldUpdater<zzdby, zzd> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzdby, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzdby, zzk> waitersUpdater;

        zzf(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdby, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdby, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdby, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzk zzk, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzk, thread);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzk zzk, zzk zzk2) {
            this.waiterNextUpdater.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, zzk zzk, zzk zzk2) {
            return this.waitersUpdater.compareAndSet(zzdby, zzk, zzk2);
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, zzd zzd, zzd zzd2) {
            return this.listenersUpdater.compareAndSet(zzdby, zzd, zzd2);
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdby, obj, obj2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzh extends zza {
        private zzh() {
            super();
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, zzk zzk, zzk zzk2) {
            synchronized (zzdby) {
                if (zzdby.waiters != zzk) {
                    return false;
                }
                zzdby.waiters = zzk2;
                return true;
            }
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, zzd zzd, zzd zzd2) {
            synchronized (zzdby) {
                if (zzdby.listeners != zzd) {
                    return false;
                }
                zzdby.listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, Object obj, Object obj2) {
            synchronized (zzdby) {
                if (zzdby.value != obj) {
                    return false;
                }
                zzdby.value = obj2;
                return true;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    static final class zzi extends zza {
        static final Unsafe zzgqj;
        static final long zzgqk;
        static final long zzgql;
        static final long zzgqm;
        static final long zzgqn;
        static final long zzgqo;

        private zzi() {
            super();
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzk zzk, Thread thread) {
            zzgqj.putObject(zzk, zzgqn, thread);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzk zzk, zzk zzk2) {
            zzgqj.putObject(zzk, zzgqo, zzk2);
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, zzk zzk, zzk zzk2) {
            return zzgqj.compareAndSwapObject(zzdby, zzgql, zzk, zzk2);
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, zzd zzd, zzd zzd2) {
            return zzgqj.compareAndSwapObject(zzdby, zzgqk, zzd, zzd2);
        }

        /* access modifiers changed from: 0000 */
        public final boolean zza(zzdby<?> zzdby, Object obj, Object obj2) {
            return zzgqj.compareAndSwapObject(zzdby, zzgqm, obj, obj2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x005f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x006b, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:?, code lost:
            r0 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzdby.zzi.C17911());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
        static {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                goto L_0x0010
            L_0x0005:
                com.google.android.gms.internal.ads.zzdby$zzi$1 r0 = new com.google.android.gms.internal.ads.zzdby$zzi$1     // Catch:{ PrivilegedActionException -> 0x005f }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x005f }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x005f }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x005f }
            L_0x0010:
                java.lang.Class<com.google.android.gms.internal.ads.zzdby> r1 = com.google.android.gms.internal.ads.zzdby.class
                java.lang.String r2 = "waiters"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0055 }
                zzgql = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = "listeners"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0055 }
                zzgqk = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = "value"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                zzgqm = r1     // Catch:{ Exception -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.ads.zzdby$zzk> r1 = com.google.android.gms.internal.ads.zzdby.zzk.class
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                zzgqn = r1     // Catch:{ Exception -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.ads.zzdby$zzk> r1 = com.google.android.gms.internal.ads.zzdby.zzk.class
                java.lang.String r2 = "next"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                zzgqo = r1     // Catch:{ Exception -> 0x0055 }
                zzgqj = r0     // Catch:{ Exception -> 0x0055 }
                return
            L_0x0055:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzdav.zzf(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005f:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdby.zzi.<clinit>():void");
        }
    }

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zzgqp) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (zzgqd.zza(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    protected zzdby() {
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof zze))) {
                return zzaf(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zzgqp) {
                    zzk zzk3 = new zzk();
                    do {
                        zzk3.zzb(zzk2);
                        if (zzgqd.zza(this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zze))) {
                                        return zzaf(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zzgqp);
                }
                return zzaf(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof zze))) {
                    return zzaf(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdby = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j2);
            String str = " ";
            sb.append(str);
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                boolean z = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(str);
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(str);
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzdby).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zzdby);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zze))) {
                return zzaf(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zzgqp) {
                zzk zzk3 = new zzk();
                do {
                    zzk3.zzb(zzk2);
                    if (zzgqd.zza(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zze))));
                        return zzaf(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zzgqp);
            }
            return zzaf(this.value);
        }
        throw new InterruptedException();
    }

    private static V zzaf(Object obj) throws ExecutionException {
        if (obj instanceof zzc) {
            Throwable th = ((zzc) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzb) {
            throw new ExecutionException(((zzb) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public boolean isDone() {
        Object obj = this.value;
        boolean z = true;
        boolean z2 = obj != null;
        if (obj instanceof zze) {
            z = false;
        }
        return z2 & z;
    }

    public boolean isCancelled() {
        return this.value instanceof zzc;
    }

    public boolean cancel(boolean z) {
        zzc zzc2;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zze)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            zzc2 = new zzc(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            zzc2 = zzc.zzgqf;
        } else {
            zzc2 = zzc.zzgqg;
        }
        boolean z2 = false;
        Object obj2 = obj;
        zzdby zzdby = this;
        while (true) {
            if (zzgqd.zza(zzdby, obj2, (Object) zzc2)) {
                zza(zzdby);
                if (!(obj2 instanceof zze)) {
                    return true;
                }
                zzddi<? extends V> zzddi = ((zze) obj2).future;
                if (zzddi instanceof zzg) {
                    zzdby = (zzdby) zzddi;
                    obj2 = zzdby.value;
                    if (!(obj2 == null) && !(obj2 instanceof zze)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzddi.cancel(z);
                    return true;
                }
            } else {
                obj2 = zzdby.value;
                if (!(obj2 instanceof zze)) {
                    return z2;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zzc) && ((zzc) obj).wasInterrupted;
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzdaq.checkNotNull(runnable, "Runnable was null.");
        zzdaq.checkNotNull(executor, "Executor was null.");
        if (!isDone()) {
            zzd zzd2 = this.listeners;
            if (zzd2 != zzd.zzgqh) {
                zzd zzd3 = new zzd(runnable, executor);
                do {
                    zzd3.next = zzd2;
                    if (!zzgqd.zza(this, zzd2, zzd3)) {
                        zzd2 = this.listeners;
                    } else {
                        return;
                    }
                } while (zzd2 != zzd.zzgqh);
            }
        }
        zza(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = NULL;
        }
        if (!zzgqd.zza(this, (Object) null, (Object) v)) {
            return false;
        }
        zza(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!zzgqd.zza(this, (Object) null, (Object) new zzb((Throwable) zzdaq.checkNotNull(th)))) {
            return false;
        }
        zza(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean setFuture(zzddi<? extends V> zzddi) {
        zze zze2;
        zzb zzb2;
        zzdaq.checkNotNull(zzddi);
        Object obj = this.value;
        if (obj == null) {
            if (zzddi.isDone()) {
                if (!zzgqd.zza(this, (Object) null, getFutureValue(zzddi))) {
                    return false;
                }
                zza(this);
                return true;
            }
            zze2 = new zze(this, zzddi);
            if (zzgqd.zza(this, (Object) null, (Object) zze2)) {
                try {
                    zzddi.addListener(zze2, zzdcq.INSTANCE);
                } catch (Throwable unused) {
                    zzb2 = zzb.zzgqe;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzc) {
            zzddi.cancel(((zzc) obj).wasInterrupted);
        }
        return false;
        zzgqd.zza(this, (Object) zze2, (Object) zzb2);
        return true;
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(zzddi<?> zzddi) {
        String str = "get() did not throw CancellationException, despite reporting isCancelled() == true: ";
        if (zzddi instanceof zzg) {
            Object obj = ((zzdby) zzddi).value;
            if (obj instanceof zzc) {
                zzc zzc2 = (zzc) obj;
                if (zzc2.wasInterrupted) {
                    obj = zzc2.cause != null ? new zzc(false, zzc2.cause) : zzc.zzgqg;
                }
            }
            return obj;
        }
        if (zzddi instanceof zzdea) {
            Throwable zza2 = zzded.zza((zzdea) zzddi);
            if (zza2 != null) {
                return new zzb(zza2);
            }
        }
        boolean isCancelled = zzddi.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return zzc.zzgqg;
        }
        try {
            Object zza3 = zza((Future<V>) zzddi);
            if (!isCancelled) {
                return zza3 == null ? NULL : zza3;
            }
            String valueOf = String.valueOf(zzddi);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
            sb.append(str);
            sb.append(valueOf);
            return new zzc(false, new IllegalArgumentException(sb.toString()));
        } catch (ExecutionException e) {
            if (!isCancelled) {
                return new zzb(e.getCause());
            }
            String valueOf2 = String.valueOf(zzddi);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 84);
            sb2.append(str);
            sb2.append(valueOf2);
            return new zzc(false, new IllegalArgumentException(sb2.toString(), e));
        } catch (CancellationException e2) {
            if (isCancelled) {
                return new zzc(false, e2);
            }
            String valueOf3 = String.valueOf(zzddi);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 77);
            sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
            sb3.append(valueOf3);
            return new zzb(new IllegalArgumentException(sb3.toString(), e2));
        } catch (Throwable th) {
            return new zzb(th);
        }
    }

    private static <V> V zza(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.android.gms.internal.ads.zzdby<?>, code=com.google.android.gms.internal.ads.zzdby, for r5v0, types: [com.google.android.gms.internal.ads.zzdby<?>, com.google.android.gms.internal.ads.zzdby] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.internal.ads.zzdby r5) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            com.google.android.gms.internal.ads.zzdby$zzk r2 = r5.waiters
            com.google.android.gms.internal.ads.zzdby$zza r3 = zzgqd
            com.google.android.gms.internal.ads.zzdby$zzk r4 = com.google.android.gms.internal.ads.zzdby.zzk.zzgqp
            boolean r3 = r3.zza(r5, r2, r4)
            if (r3 == 0) goto L_0x0002
        L_0x000e:
            if (r2 == 0) goto L_0x001c
            java.lang.Thread r3 = r2.thread
            if (r3 == 0) goto L_0x0019
            r2.thread = r0
            java.util.concurrent.locks.LockSupport.unpark(r3)
        L_0x0019:
            com.google.android.gms.internal.ads.zzdby$zzk r2 = r2.next
            goto L_0x000e
        L_0x001c:
            r5.afterDone()
        L_0x001f:
            com.google.android.gms.internal.ads.zzdby$zzd r2 = r5.listeners
            com.google.android.gms.internal.ads.zzdby$zza r3 = zzgqd
            com.google.android.gms.internal.ads.zzdby$zzd r4 = com.google.android.gms.internal.ads.zzdby.zzd.zzgqh
            boolean r3 = r3.zza(r5, r2, r4)
            if (r3 == 0) goto L_0x001f
        L_0x002b:
            r5 = r1
            r1 = r2
            if (r1 == 0) goto L_0x0034
            com.google.android.gms.internal.ads.zzdby$zzd r2 = r1.next
            r1.next = r5
            goto L_0x002b
        L_0x0034:
            if (r5 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzdby$zzd r1 = r5.next
            java.lang.Runnable r2 = r5.task
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzdby.zze
            if (r3 == 0) goto L_0x0055
            com.google.android.gms.internal.ads.zzdby$zze r2 = (com.google.android.gms.internal.ads.zzdby.zze) r2
            com.google.android.gms.internal.ads.zzdby<V> r5 = r2.zzgqi
            java.lang.Object r3 = r5.value
            if (r3 != r2) goto L_0x005a
            com.google.android.gms.internal.ads.zzddi<? extends V> r3 = r2.future
            java.lang.Object r3 = getFutureValue(r3)
            com.google.android.gms.internal.ads.zzdby$zza r4 = zzgqd
            boolean r2 = r4.zza(r5, r2, r3)
            if (r2 != 0) goto L_0x0002
            goto L_0x005a
        L_0x0055:
            java.util.concurrent.Executor r5 = r5.executor
            zza(r2, r5)
        L_0x005a:
            r5 = r1
            goto L_0x0034
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdby.zza(com.google.android.gms.internal.ads.zzdby):void");
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public final Throwable zzaow() {
        if (this instanceof zzg) {
            Object obj = this.value;
            if (obj instanceof zzb) {
                return ((zzb) obj).exception;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        String str2 = "]";
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zza(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(e.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                sb2.append("Exception thrown from implementation: ");
                sb2.append(valueOf);
                str = sb2.toString();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append(str2);
            } else if (isDone()) {
                zza(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof zze) {
            String zzag = zzag(((zze) obj).future);
            StringBuilder sb = new StringBuilder(String.valueOf(zzag).length() + 12);
            sb.append("setFuture=[");
            sb.append(zzag);
            sb.append("]");
            return sb.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("remaining delay=[");
            sb2.append(delay);
            sb2.append(" ms]");
            return sb2.toString();
        }
    }

    private final void zza(StringBuilder sb) {
        String str = "]";
        try {
            Object zza2 = zza((Future<V>) this);
            sb.append("SUCCESS, result=[");
            sb.append(zzag(zza2));
            sb.append(str);
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append(str);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final String zzag(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzgqc;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), e);
        }
    }

    static {
        Throwable th;
        Throwable th2;
        zza zza2;
        try {
            th2 = null;
            th = null;
            zza2 = new zzi();
        } catch (Throwable th3) {
            th = th;
            th2 = th3;
            zza2 = new zzh();
        }
        zzgqd = zza2;
        if (th2 != null) {
            zzgqc.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            zzgqc.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
    }
}
