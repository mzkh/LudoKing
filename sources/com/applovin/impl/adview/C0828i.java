package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.adview.i */
public final class C0828i {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1227o f1462a;

    /* renamed from: b */
    private final Handler f1463b;

    /* renamed from: c */
    private final Set<C0831b> f1464c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicInteger f1465d = new AtomicInteger();

    /* renamed from: com.applovin.impl.adview.i$a */
    interface C0830a {
        /* renamed from: a */
        void mo9088a();

        /* renamed from: b */
        boolean mo9089b();
    }

    /* renamed from: com.applovin.impl.adview.i$b */
    private static class C0831b {

        /* renamed from: a */
        private final String f1469a;

        /* renamed from: b */
        private final C0830a f1470b;

        /* renamed from: c */
        private final long f1471c;

        private C0831b(String str, long j, C0830a aVar) {
            this.f1469a = str;
            this.f1471c = j;
            this.f1470b = aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m1185a() {
            return this.f1469a;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m1187b() {
            return this.f1471c;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public C0830a m1190c() {
            return this.f1470b;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0831b)) {
                return false;
            }
            C0831b bVar = (C0831b) obj;
            String str = this.f1469a;
            if (str != null) {
                z = str.equalsIgnoreCase(bVar.f1469a);
            } else if (bVar.f1469a != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            String str = this.f1469a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CountdownProxy{identifier='");
            sb.append(this.f1469a);
            sb.append('\'');
            sb.append(", countdownStepMillis=");
            sb.append(this.f1471c);
            sb.append('}');
            return sb.toString();
        }
    }

    public C0828i(Handler handler, C1192i iVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (iVar != null) {
            this.f1463b = handler;
            this.f1462a = iVar.mo10249v();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1176a(final C0831b bVar, final int i) {
        this.f1463b.postDelayed(new Runnable() {
            public void run() {
                C0830a b = bVar.m1190c();
                String str = "CountdownManager";
                if (!b.mo9089b()) {
                    C1227o b2 = C0828i.this.f1462a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ending countdown for ");
                    sb.append(bVar.m1185a());
                    b2.mo10378b(str, sb.toString());
                } else if (C0828i.this.f1465d.get() == i) {
                    try {
                        b.mo9088a();
                    } catch (Throwable th) {
                        C1227o b3 = C0828i.this.f1462a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Encountered error on countdown step for: ");
                        sb2.append(bVar.m1185a());
                        b3.mo10379b(str, sb2.toString(), th);
                    }
                    C0828i.this.m1176a(bVar, i);
                } else {
                    C1227o b4 = C0828i.this.f1462a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Killing duplicate countdown from previous generation: ");
                    sb3.append(bVar.m1185a());
                    b4.mo10381d(str, sb3.toString());
                }
            }
        }, bVar.m1187b());
    }

    /* renamed from: a */
    public void mo9083a() {
        HashSet<C0831b> hashSet = new HashSet<>(this.f1464c);
        C1227o oVar = this.f1462a;
        StringBuilder sb = new StringBuilder();
        sb.append("Starting ");
        sb.append(hashSet.size());
        sb.append(" countdowns...");
        String str = "CountdownManager";
        oVar.mo10378b(str, sb.toString());
        int incrementAndGet = this.f1465d.incrementAndGet();
        for (C0831b bVar : hashSet) {
            C1227o oVar2 = this.f1462a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Starting countdown: ");
            sb2.append(bVar.m1185a());
            sb2.append(" for generation ");
            sb2.append(incrementAndGet);
            sb2.append("...");
            oVar2.mo10378b(str, sb2.toString());
            m1176a(bVar, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void mo9084a(String str, long j, C0830a aVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f1463b != null) {
            C1227o oVar = this.f1462a;
            StringBuilder sb = new StringBuilder();
            sb.append("Adding countdown: ");
            sb.append(str);
            oVar.mo10378b("CountdownManager", sb.toString());
            C0831b bVar = new C0831b(str, j, aVar);
            this.f1464c.add(bVar);
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    /* renamed from: b */
    public void mo9085b() {
        this.f1462a.mo10378b("CountdownManager", "Removing all countdowns...");
        mo9086c();
        this.f1464c.clear();
    }

    /* renamed from: c */
    public void mo9086c() {
        this.f1462a.mo10378b("CountdownManager", "Stopping countdowns...");
        this.f1465d.incrementAndGet();
        this.f1463b.removeCallbacksAndMessages(null);
    }
}
