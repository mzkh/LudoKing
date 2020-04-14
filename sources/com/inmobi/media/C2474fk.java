package com.inmobi.media;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.media.fk */
/* compiled from: EventProcessor */
public class C2474fk implements C2479fm {

    /* renamed from: f */
    private static final String f5395f = "fk";

    /* renamed from: a */
    public AtomicBoolean f5396a = new AtomicBoolean(false);

    /* renamed from: b */
    public AtomicBoolean f5397b = new AtomicBoolean(false);

    /* renamed from: c */
    public HashMap<String, C2471fh> f5398c = new HashMap<>(1);

    /* renamed from: d */
    public List<String> f5399d = new LinkedList();

    /* renamed from: e */
    public ScheduledExecutorService f5400e;

    /* renamed from: g */
    private C2472fi f5401g;

    /* renamed from: h */
    private C2480fn f5402h;

    public C2474fk(@NonNull C2472fi fiVar, @NonNull C2480fn fnVar, @NonNull C2471fh fhVar) {
        this.f5401g = fiVar;
        this.f5402h = fnVar;
        mo28397a(fhVar);
    }

    /* renamed from: a */
    public final void mo28400a(@NonNull String str, boolean z) {
        if (!this.f5397b.get()) {
            m5191a(str, m5192b(str).f5385f, z);
        }
    }

    /* renamed from: a */
    private void m5191a(@NonNull final String str, long j, final boolean z) {
        if (!this.f5399d.contains(str)) {
            this.f5399d.add(str);
            if (this.f5400e == null) {
                this.f5400e = Executors.newSingleThreadScheduledExecutor();
            }
            this.f5400e.scheduleAtFixedRate(new Runnable() {

                /* renamed from: b */
                final /* synthetic */ C2540gy f5404b = null;

                public final void run() {
                    C2474fk.m5190a(C2474fk.this, str, this.f5404b, z);
                }
            }, m5189a(str), j, TimeUnit.SECONDS);
        }
    }

    /* renamed from: a */
    private long m5189a(@NonNull String str) {
        C2471fh b = m5192b(str);
        long c = this.f5401g.mo28392c();
        if (c == -1) {
            this.f5401g.mo28393c(System.currentTimeMillis());
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c) + b.f5385f;
        if (seconds - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) > 0) {
            return seconds - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
        return 0;
    }

    @NonNull
    /* renamed from: b */
    private C2471fh m5192b(@NonNull String str) {
        return (C2471fh) this.f5398c.get(str);
    }

    /* renamed from: a */
    public final void mo28397a(@NonNull C2471fh fhVar) {
        String str = fhVar.f5381b;
        if (str == null) {
            str = "default";
        }
        this.f5398c.put(str, fhVar);
    }

    /* renamed from: a */
    public final void mo28398a(C2473fj fjVar) {
        ((Integer) fjVar.f5392a.get(0)).intValue();
        this.f5401g.mo28388a(fjVar.f5392a);
        this.f5401g.mo28393c(System.currentTimeMillis());
        this.f5396a.set(false);
    }

    /* renamed from: a */
    public final void mo28399a(C2473fj fjVar, boolean z) {
        ((Integer) fjVar.f5392a.get(0)).intValue();
        if (fjVar.f5394c && z) {
            this.f5401g.mo28388a(fjVar.f5392a);
        }
        this.f5401g.mo28393c(System.currentTimeMillis());
        this.f5396a.set(false);
    }

    /* renamed from: a */
    static /* synthetic */ void m5190a(C2474fk fkVar, String str, C2540gy gyVar, boolean z) {
        int i;
        long j;
        if (!fkVar.f5397b.get() && !fkVar.f5396a.get()) {
            fkVar.f5401g.mo28391b(fkVar.m5192b(str).f5380a);
            int a = fkVar.f5401g.mo28387a();
            int a2 = C2527gp.m5386a();
            if (a2 != 1) {
                i = fkVar.m5192b(str).f5388i;
            } else {
                i = fkVar.m5192b(str).f5386g;
            }
            if (a2 != 1) {
                j = fkVar.m5192b(str).f5389j;
            } else {
                j = fkVar.m5192b(str).f5387h;
            }
            long j2 = j;
            if (i <= a || fkVar.f5401g.mo28389a(fkVar.m5192b(str).f5382c) || fkVar.f5401g.mo28390a(fkVar.m5192b(str).f5385f, fkVar.m5192b(str).f5382c)) {
                C2473fj b = fkVar.f5402h.mo28383b();
                if (b != null) {
                    fkVar.f5396a.set(true);
                    C2471fh b2 = fkVar.m5192b(str);
                    int i2 = b2.f5383d + 1;
                    C2476fl.m5197a().mo28402a(b, b2.f5384e, i2, i2, j2, gyVar, fkVar, z);
                }
            }
        }
    }
}
