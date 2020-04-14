package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1241c;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1281o;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.d.r */
public class C1159r {

    /* renamed from: a */
    private final String f2800a = "TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1192i f2801b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1227o f2802c;

    /* renamed from: d */
    private final ScheduledThreadPoolExecutor f2803d;

    /* renamed from: e */
    private final ScheduledThreadPoolExecutor f2804e;

    /* renamed from: f */
    private final ScheduledThreadPoolExecutor f2805f;

    /* renamed from: g */
    private final ScheduledThreadPoolExecutor f2806g;

    /* renamed from: h */
    private final ScheduledThreadPoolExecutor f2807h;

    /* renamed from: i */
    private final ScheduledThreadPoolExecutor f2808i;

    /* renamed from: j */
    private final ScheduledThreadPoolExecutor f2809j;

    /* renamed from: k */
    private final ScheduledThreadPoolExecutor f2810k;

    /* renamed from: l */
    private final ScheduledThreadPoolExecutor f2811l;

    /* renamed from: m */
    private final ScheduledThreadPoolExecutor f2812m;

    /* renamed from: n */
    private final ScheduledThreadPoolExecutor f2813n;

    /* renamed from: o */
    private final ScheduledThreadPoolExecutor f2814o;

    /* renamed from: p */
    private final ScheduledThreadPoolExecutor f2815p;

    /* renamed from: q */
    private final ScheduledThreadPoolExecutor f2816q;

    /* renamed from: r */
    private final ScheduledThreadPoolExecutor f2817r;

    /* renamed from: s */
    private final ScheduledThreadPoolExecutor f2818s;

    /* renamed from: t */
    private final ScheduledThreadPoolExecutor f2819t;

    /* renamed from: u */
    private final ScheduledThreadPoolExecutor f2820u;

    /* renamed from: v */
    private final ScheduledThreadPoolExecutor f2821v;

    /* renamed from: w */
    private final ScheduledThreadPoolExecutor f2822w;

    /* renamed from: x */
    private final List<C1164c> f2823x = new ArrayList(5);

    /* renamed from: y */
    private final Object f2824y = new Object();

    /* renamed from: z */
    private boolean f2825z;

    /* renamed from: com.applovin.impl.sdk.d.r$a */
    public enum C1161a {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARD
    }

    /* renamed from: com.applovin.impl.sdk.d.r$b */
    private class C1162b implements ThreadFactory {

        /* renamed from: b */
        private final String f2848b;

        C1162b(String str) {
            this.f2848b = str;
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppLovinSdk:");
            sb.append(this.f2848b);
            sb.append(":");
            sb.append(C1281o.m3075a(C1159r.this.f2801b.mo10246t()));
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    C1159r.this.f2802c.mo10379b("TaskManager", "Caught unhandled exception", th);
                }
            });
            return thread;
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.r$c */
    private class C1164c implements Runnable {

        /* renamed from: b */
        private final String f2851b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C1122a f2852c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C1161a f2853d;

        C1164c(C1122a aVar, C1161a aVar2) {
            this.f2851b = aVar.mo10074f();
            this.f2852c = aVar;
            this.f2853d = aVar2;
        }

        public void run() {
            long a;
            C1227o b;
            StringBuilder sb;
            String str = "ms.";
            String str2 = " with queue size ";
            String str3 = " queue finished task ";
            String str4 = "TaskManager";
            long currentTimeMillis = System.currentTimeMillis();
            try {
                C1245f.m2929a();
                if (C1159r.this.f2801b.mo10229c()) {
                    if (!this.f2852c.mo10076h()) {
                        C1159r.this.f2802c.mo10380c(this.f2851b, "Task re-scheduled...");
                        C1159r.this.mo10132a(this.f2852c, this.f2853d, 2000);
                        a = C1159r.this.m2457a(this.f2853d) - 1;
                        b = C1159r.this.f2802c;
                        sb = new StringBuilder();
                        sb.append(this.f2853d);
                        sb.append(str3);
                        sb.append(this.f2852c.mo10074f());
                        sb.append(str2);
                        sb.append(a);
                        b.mo10380c(str4, sb.toString());
                    }
                }
                C1159r.this.f2802c.mo10380c(this.f2851b, "Task started execution...");
                this.f2852c.run();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                C1159r.this.f2801b.mo10187M().mo10048a(this.f2852c.mo9338a(), currentTimeMillis2);
                C1227o b2 = C1159r.this.f2802c;
                String str5 = this.f2851b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Task executed successfully in ");
                sb2.append(currentTimeMillis2);
                sb2.append(str);
                b2.mo10380c(str5, sb2.toString());
                a = C1159r.this.m2457a(this.f2853d) - 1;
                b = C1159r.this.f2802c;
                sb = new StringBuilder();
            } catch (Throwable th) {
                long a2 = C1159r.this.m2457a(this.f2853d) - 1;
                C1227o b3 = C1159r.this.f2802c;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f2853d);
                sb3.append(str3);
                sb3.append(this.f2852c.mo10074f());
                sb3.append(str2);
                sb3.append(a2);
                b3.mo10380c(str4, sb3.toString());
                throw th;
            }
            sb.append(this.f2853d);
            sb.append(str3);
            sb.append(this.f2852c.mo10074f());
            sb.append(str2);
            sb.append(a);
            b.mo10380c(str4, sb.toString());
        }
    }

    public C1159r(C1192i iVar) {
        this.f2801b = iVar;
        this.f2802c = iVar.mo10249v();
        this.f2803d = m2460a("main");
        this.f2804e = m2460a("timeout");
        this.f2805f = m2460a("back");
        this.f2806g = m2460a("advertising_info_collection");
        this.f2807h = m2460a("postbacks");
        this.f2808i = m2460a("caching_interstitial");
        this.f2809j = m2460a("caching_incentivized");
        this.f2810k = m2460a("caching_other");
        this.f2811l = m2460a("reward");
        this.f2812m = m2460a("mediation_main");
        this.f2813n = m2460a("mediation_timeout");
        this.f2814o = m2460a("mediation_background");
        this.f2815p = m2460a("mediation_postbacks");
        this.f2816q = m2460a("mediation_banner");
        this.f2817r = m2460a("mediation_interstitial");
        this.f2818s = m2460a("mediation_incentivized");
        this.f2819t = m2460a("mediation_reward");
        this.f2820u = m2461a("auxiliary_operations", ((Integer) iVar.mo10202a(C1096c.f2442cz)).intValue());
        this.f2821v = m2461a("caching_operations", ((Integer) iVar.mo10202a(C1096c.f2391cA)).intValue());
        this.f2822w = m2461a("shared_thread_pool", ((Integer) iVar.mo10202a(C1096c.f2321aj)).intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m2457a(C1161a aVar) {
        long taskCount;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (aVar == C1161a.MAIN) {
            taskCount = this.f2803d.getTaskCount();
            scheduledThreadPoolExecutor = this.f2803d;
        } else if (aVar == C1161a.TIMEOUT) {
            taskCount = this.f2804e.getTaskCount();
            scheduledThreadPoolExecutor = this.f2804e;
        } else if (aVar == C1161a.BACKGROUND) {
            taskCount = this.f2805f.getTaskCount();
            scheduledThreadPoolExecutor = this.f2805f;
        } else if (aVar == C1161a.ADVERTISING_INFO_COLLECTION) {
            taskCount = this.f2806g.getTaskCount();
            scheduledThreadPoolExecutor = this.f2806g;
        } else if (aVar == C1161a.POSTBACKS) {
            taskCount = this.f2807h.getTaskCount();
            scheduledThreadPoolExecutor = this.f2807h;
        } else if (aVar == C1161a.CACHING_INTERSTITIAL) {
            taskCount = this.f2808i.getTaskCount();
            scheduledThreadPoolExecutor = this.f2808i;
        } else if (aVar == C1161a.CACHING_INCENTIVIZED) {
            taskCount = this.f2809j.getTaskCount();
            scheduledThreadPoolExecutor = this.f2809j;
        } else if (aVar == C1161a.CACHING_OTHER) {
            taskCount = this.f2810k.getTaskCount();
            scheduledThreadPoolExecutor = this.f2810k;
        } else if (aVar == C1161a.REWARD) {
            taskCount = this.f2811l.getTaskCount();
            scheduledThreadPoolExecutor = this.f2811l;
        } else if (aVar == C1161a.MEDIATION_MAIN) {
            taskCount = this.f2812m.getTaskCount();
            scheduledThreadPoolExecutor = this.f2812m;
        } else if (aVar == C1161a.MEDIATION_TIMEOUT) {
            taskCount = this.f2813n.getTaskCount();
            scheduledThreadPoolExecutor = this.f2813n;
        } else if (aVar == C1161a.MEDIATION_BACKGROUND) {
            taskCount = this.f2814o.getTaskCount();
            scheduledThreadPoolExecutor = this.f2814o;
        } else if (aVar == C1161a.MEDIATION_POSTBACKS) {
            taskCount = this.f2815p.getTaskCount();
            scheduledThreadPoolExecutor = this.f2815p;
        } else if (aVar == C1161a.MEDIATION_BANNER) {
            taskCount = this.f2816q.getTaskCount();
            scheduledThreadPoolExecutor = this.f2816q;
        } else if (aVar == C1161a.MEDIATION_INTERSTITIAL) {
            taskCount = this.f2817r.getTaskCount();
            scheduledThreadPoolExecutor = this.f2817r;
        } else if (aVar == C1161a.MEDIATION_INCENTIVIZED) {
            taskCount = this.f2818s.getTaskCount();
            scheduledThreadPoolExecutor = this.f2818s;
        } else if (aVar != C1161a.MEDIATION_REWARD) {
            return 0;
        } else {
            taskCount = this.f2819t.getTaskCount();
            scheduledThreadPoolExecutor = this.f2819t;
        }
        return taskCount - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m2460a(String str) {
        return m2461a(str, 1);
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m2461a(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new C1162b(str));
    }

    /* renamed from: a */
    private void m2462a(final Runnable runnable, long j, final ScheduledExecutorService scheduledExecutorService, boolean z) {
        if (j <= 0) {
            scheduledExecutorService.submit(runnable);
        } else if (z) {
            C1241c.m2918a(j, this.f2801b, new Runnable() {
                public void run() {
                    scheduledExecutorService.execute(runnable);
                }
            });
        } else {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    private boolean m2463a(C1164c cVar) {
        if (cVar.f2852c.mo10076h()) {
            return false;
        }
        synchronized (this.f2824y) {
            if (this.f2825z) {
                return false;
            }
            this.f2823x.add(cVar);
            return true;
        }
    }

    /* renamed from: a */
    public void mo10130a(C1122a aVar) {
        String str = "TaskManager";
        if (aVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                C1227o oVar = this.f2802c;
                StringBuilder sb = new StringBuilder();
                sb.append("Executing ");
                sb.append(aVar.mo10074f());
                sb.append(" immediately...");
                oVar.mo10380c(str, sb.toString());
                aVar.run();
                this.f2801b.mo10187M().mo10048a(aVar.mo9338a(), System.currentTimeMillis() - currentTimeMillis);
                C1227o oVar2 = this.f2802c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar.mo10074f());
                sb2.append(" finished executing...");
                oVar2.mo10380c(str, sb2.toString());
            } catch (Throwable th) {
                this.f2802c.mo10379b(aVar.mo10074f(), "Task failed execution", th);
                this.f2801b.mo10187M().mo10049a(aVar.mo9338a(), true, System.currentTimeMillis() - currentTimeMillis);
            }
        } else {
            this.f2802c.mo10382e(str, "Attempted to execute null task immediately");
        }
    }

    /* renamed from: a */
    public void mo10131a(C1122a aVar, C1161a aVar2) {
        mo10132a(aVar, aVar2, 0);
    }

    /* renamed from: a */
    public void mo10132a(C1122a aVar, C1161a aVar2, long j) {
        mo10133a(aVar, aVar2, j, false);
    }

    /* renamed from: a */
    public void mo10133a(C1122a aVar, C1161a aVar2, long j, boolean z) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        C1159r rVar;
        Runnable runnable;
        long j2;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2;
        C1161a aVar3 = aVar2;
        long j3 = j;
        if (aVar == 0) {
            throw new IllegalArgumentException("No task specified");
        } else if (j3 >= 0) {
            C1164c cVar = new C1164c(aVar, aVar2);
            if (!m2463a(cVar)) {
                if (((Boolean) this.f2801b.mo10202a(C1096c.f2322ak)).booleanValue()) {
                    scheduledThreadPoolExecutor2 = this.f2822w;
                    rVar = this;
                    runnable = aVar;
                    j2 = j;
                } else {
                    long a = m2457a(aVar2) + 1;
                    C1227o oVar = this.f2802c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Scheduling ");
                    sb.append(aVar.mo10074f());
                    sb.append(" on ");
                    sb.append(aVar2);
                    sb.append(" queue in ");
                    sb.append(j);
                    sb.append("ms with new queue size ");
                    sb.append(a);
                    oVar.mo10378b("TaskManager", sb.toString());
                    if (aVar3 == C1161a.MAIN) {
                        scheduledThreadPoolExecutor = this.f2803d;
                    } else if (aVar3 == C1161a.TIMEOUT) {
                        scheduledThreadPoolExecutor = this.f2804e;
                    } else if (aVar3 == C1161a.BACKGROUND) {
                        scheduledThreadPoolExecutor = this.f2805f;
                    } else if (aVar3 == C1161a.ADVERTISING_INFO_COLLECTION) {
                        scheduledThreadPoolExecutor = this.f2806g;
                    } else if (aVar3 == C1161a.POSTBACKS) {
                        scheduledThreadPoolExecutor = this.f2807h;
                    } else if (aVar3 == C1161a.CACHING_INTERSTITIAL) {
                        scheduledThreadPoolExecutor = this.f2808i;
                    } else if (aVar3 == C1161a.CACHING_INCENTIVIZED) {
                        scheduledThreadPoolExecutor = this.f2809j;
                    } else if (aVar3 == C1161a.CACHING_OTHER) {
                        scheduledThreadPoolExecutor = this.f2810k;
                    } else if (aVar3 == C1161a.REWARD) {
                        scheduledThreadPoolExecutor = this.f2811l;
                    } else if (aVar3 == C1161a.MEDIATION_MAIN) {
                        scheduledThreadPoolExecutor = this.f2812m;
                    } else if (aVar3 == C1161a.MEDIATION_TIMEOUT) {
                        scheduledThreadPoolExecutor = this.f2813n;
                    } else if (aVar3 == C1161a.MEDIATION_BACKGROUND) {
                        scheduledThreadPoolExecutor = this.f2814o;
                    } else if (aVar3 == C1161a.MEDIATION_POSTBACKS) {
                        scheduledThreadPoolExecutor = this.f2815p;
                    } else if (aVar3 == C1161a.MEDIATION_BANNER) {
                        scheduledThreadPoolExecutor = this.f2816q;
                    } else if (aVar3 == C1161a.MEDIATION_INTERSTITIAL) {
                        scheduledThreadPoolExecutor = this.f2817r;
                    } else if (aVar3 == C1161a.MEDIATION_INCENTIVIZED) {
                        scheduledThreadPoolExecutor = this.f2818s;
                    } else if (aVar3 == C1161a.MEDIATION_REWARD) {
                        scheduledThreadPoolExecutor = this.f2819t;
                    } else {
                        return;
                    }
                    rVar = this;
                    runnable = cVar;
                    j2 = j;
                    scheduledThreadPoolExecutor2 = scheduledThreadPoolExecutor;
                }
                rVar.m2462a(runnable, j2, (ScheduledExecutorService) scheduledThreadPoolExecutor2, z);
                return;
            }
            C1227o oVar2 = this.f2802c;
            String f = aVar.mo10074f();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Task ");
            sb2.append(aVar.mo10074f());
            sb2.append(" execution delayed until after init");
            oVar2.mo10380c(f, sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid delay specified: ");
            sb3.append(j);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: a */
    public boolean mo10134a() {
        return this.f2825z;
    }

    /* renamed from: b */
    public ScheduledExecutorService mo10135b() {
        return this.f2820u;
    }

    /* renamed from: c */
    public ScheduledExecutorService mo10136c() {
        return this.f2821v;
    }

    /* renamed from: d */
    public void mo10137d() {
        synchronized (this.f2824y) {
            this.f2825z = false;
        }
    }

    /* renamed from: e */
    public void mo10138e() {
        synchronized (this.f2824y) {
            this.f2825z = true;
            for (C1164c cVar : this.f2823x) {
                mo10131a(cVar.f2852c, cVar.f2853d);
            }
            this.f2823x.clear();
        }
    }
}
