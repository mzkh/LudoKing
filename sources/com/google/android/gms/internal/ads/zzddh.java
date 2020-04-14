package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzddh<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzgrq = new zzddj();
    private static final Runnable zzgrr = new zzddj();
    private static final Runnable zzgrs = new zzddj();

    zzddh() {
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean isDone();

    /* access modifiers changed from: 0000 */
    public abstract T zzapg() throws Exception;

    /* access modifiers changed from: 0000 */
    public abstract String zzaph();

    /* access modifiers changed from: 0000 */
    public abstract void zzb(@NullableDecl T t, @NullableDecl Throwable th);

    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    obj = zzapg();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zzgrq)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != zzgrr && runnable != zzgrs) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = zzgrs;
                                if (runnable == runnable2 || compareAndSet(zzgrr, runnable2)) {
                                    boolean z3 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                    z2 = z3;
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        zzb(null, null);
                    }
                    throw th;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, zzgrq)) {
                Runnable runnable3 = (Runnable) get();
                boolean z4 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != zzgrr && runnable3 != zzgrs) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = zzgrs;
                        if (runnable3 == runnable4 || compareAndSet(zzgrr, runnable4)) {
                            boolean z5 = Thread.interrupted() || z4;
                            LockSupport.park(this);
                            z4 = z5;
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = (Runnable) get();
                }
                if (z4) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                zzb(obj, null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzgrr)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(zzgrq)) == zzgrs) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zzgrq) {
            str = "running=[DONE]";
        } else if (runnable == zzgrr) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzaph = zzaph();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzaph).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzaph);
        return sb2.toString();
    }
}
