package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzeh {
    private final Object zzlh = new Object();
    private Handler zzli;
    private boolean zzlj;
    private HashMap<String, AtomicInteger> zzlk;
    private int zzll;

    public zzeh(Looper looper, int i) {
        this.zzli = new zzen(looper);
        this.zzlk = new HashMap<>();
        this.zzll = 1000;
    }

    /* access modifiers changed from: protected */
    public abstract void zzf(String str, int i);

    public final void zzg(String str, int i) {
        synchronized (this.zzlh) {
            if (!this.zzlj) {
                this.zzlj = true;
                this.zzli.postDelayed(new zzei(this), (long) this.zzll);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzlk.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzlk.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    public final void flush() {
        synchronized (this.zzlh) {
            for (Entry entry : this.zzlk.entrySet()) {
                zzf((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzlk.clear();
        }
    }

    /* access modifiers changed from: private */
    public final void zzct() {
        synchronized (this.zzlh) {
            this.zzlj = false;
            flush();
        }
    }
}
