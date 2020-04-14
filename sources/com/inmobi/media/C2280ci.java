package com.inmobi.media;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.inmobi.media.ci */
/* compiled from: TimeOutManager */
public final class C2280ci {

    /* renamed from: a */
    C2279ch f4788a;

    /* renamed from: b */
    private HashMap<Integer, Timer> f4789b = new HashMap<>();

    @SuppressLint({"UseSparseArrays"})
    public C2280ci(C2279ch chVar) {
        this.f4788a = chVar;
    }

    @WorkerThread
    /* renamed from: a */
    public final void mo28118a(final int i, long j) {
        if (this.f4789b.containsKey(Integer.valueOf(i))) {
            mo28117a(i);
        }
        Timer timer = new Timer();
        this.f4789b.put(Integer.valueOf(i), timer);
        timer.schedule(new TimerTask() {
            public final void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable(i) {

                    /* renamed from: a */
                    final /* synthetic */ int f4792a;

                    {
                        this.f4792a = r2;
                    }

                    public final void run() {
                        C2280ci.this.f4788a.mo28116a(this.f4792a);
                    }
                });
            }
        }, j);
    }

    @WorkerThread
    /* renamed from: a */
    public final void mo28117a(int i) {
        Timer timer = (Timer) this.f4789b.get(Integer.valueOf(i));
        if (timer != null) {
            timer.cancel();
            this.f4789b.remove(Integer.valueOf(i));
        }
    }
}
