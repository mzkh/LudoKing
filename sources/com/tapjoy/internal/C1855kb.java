package com.tapjoy.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.kb */
public abstract class C1855kb implements C1857ke {

    /* renamed from: a */
    private final C1856a f3905a = new C1856a();

    /* renamed from: b */
    private final C3243kd f3906b = new C3243kd();

    /* renamed from: com.tapjoy.internal.kb$a */
    static final class C1856a extends AbstractQueuedSynchronizer {

        /* renamed from: a */
        private Object f3907a;

        /* renamed from: b */
        private Throwable f3908b;

        C1856a() {
        }

        /* access modifiers changed from: protected */
        public final int tryAcquireShared(int i) {
            return mo18204b() ? 1 : -1;
        }

        /* access modifiers changed from: protected */
        public final boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final Object mo18202a() {
            int state = getState();
            if (state == 2) {
                Throwable th = this.f3908b;
                if (th == null) {
                    return this.f3907a;
                }
                throw new ExecutionException(th);
            } else if (state != 4) {
                StringBuilder sb = new StringBuilder("Error, synchronizer in invalid state: ");
                sb.append(state);
                throw new IllegalStateException(sb.toString());
            } else {
                throw new CancellationException("Task was cancelled.");
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final boolean mo18204b() {
            return (getState() & 6) != 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public final boolean mo18205c() {
            return getState() == 4;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final boolean mo18203a(@Nullable Object obj, @Nullable Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.f3907a = obj;
                this.f3908b = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }

    public Object get(long j, TimeUnit timeUnit) {
        C1856a aVar = this.f3905a;
        if (aVar.tryAcquireSharedNanos(-1, timeUnit.toNanos(j))) {
            return aVar.mo18202a();
        }
        throw new TimeoutException("Timeout waiting for task.");
    }

    public Object get() {
        C1856a aVar = this.f3905a;
        aVar.acquireSharedInterruptibly(-1);
        return aVar.mo18202a();
    }

    public boolean isDone() {
        return this.f3905a.mo18204b();
    }

    public boolean isCancelled() {
        return this.f3905a.mo18205c();
    }

    public boolean cancel(boolean z) {
        if (!this.f3905a.mo18203a(null, null, 4)) {
            return false;
        }
        this.f3906b.mo30361a();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo18195a(@Nullable Object obj) {
        boolean a = this.f3905a.mo18203a(obj, null, 2);
        if (a) {
            this.f3906b.mo30361a();
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo18196a(Throwable th) {
        boolean a = this.f3905a.mo18203a(null, (Throwable) C3226jp.m7500a(th), 2);
        if (a) {
            this.f3906b.mo30361a();
        }
        if (!(th instanceof Error)) {
            return a;
        }
        throw ((Error) th);
    }
}
