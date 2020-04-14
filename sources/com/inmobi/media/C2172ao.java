package com.inmobi.media;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.inmobi.media.C2154ad.C2155a;
import com.inmobi.media.C2426eq.C2427a;
import com.inmobi.media.C2426eq.C2434h;
import com.inmobi.media.C2438es.C2441c;
import com.inmobi.media.C2519gm.C2523c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.media.ao */
/* compiled from: AssetStore */
public final class C2172ao implements C2441c {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f4413b = "ao";

    /* renamed from: m */
    private static final Object f4414m = new Object();

    /* renamed from: a */
    public ExecutorService f4415a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C2169am f4416c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2427a f4417d;

    /* renamed from: e */
    private C2434h f4418e;

    /* renamed from: f */
    private ExecutorService f4419f;

    /* renamed from: g */
    private C2178a f4420g;

    /* renamed from: h */
    private HandlerThread f4421h;

    /* renamed from: i */
    private AtomicBoolean f4422i;

    /* renamed from: j */
    private AtomicBoolean f4423j;

    /* renamed from: k */
    private ConcurrentHashMap<String, C2154ad> f4424k;

    /* renamed from: l */
    private C2523c f4425l;

    /* renamed from: n */
    private List<C2156ae> f4426n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final C2171an f4427o;

    /* renamed from: com.inmobi.media.ao$a */
    /* compiled from: AssetStore */
    static final class C2178a extends Handler {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public WeakReference<C2172ao> f4437a;

        /* renamed from: b */
        private final C2171an f4438b = new C2171an() {
            /* renamed from: a */
            public final void mo27895a(C2487fs fsVar, String str, C2154ad adVar) {
                C2172ao aoVar = (C2172ao) C2178a.this.f4437a.get();
                if (aoVar != null) {
                    C2172ao.f4413b;
                    C2154ad a = new C2155a().mo27837a(adVar.f4336d, str, fsVar, aoVar.f4417d.f5188a, aoVar.f4417d.f5192e).mo27838a();
                    aoVar.f4416c;
                    C2169am.m4359b(a);
                    a.f4343k = adVar.f4343k;
                    a.f4333a = adVar.f4333a;
                    aoVar.m4374a(a, true);
                    C2178a.this.m4415a();
                    return;
                }
                C2172ao.f4413b;
            }

            /* renamed from: a */
            public final void mo27894a(C2154ad adVar) {
                C2172ao aoVar = (C2172ao) C2178a.this.f4437a.get();
                if (aoVar != null) {
                    C2172ao.f4413b;
                    aoVar.m4393c(adVar.f4336d);
                    if (adVar.f4335c > 0) {
                        adVar.f4335c--;
                        adVar.f4338f = System.currentTimeMillis();
                        aoVar.f4416c;
                        C2169am.m4359b(adVar);
                        C2178a.this.m4418b();
                        return;
                    }
                    aoVar.m4374a(adVar, false);
                    C2178a.this.m4416a(adVar);
                    return;
                }
                C2172ao.f4413b;
            }
        };

        C2178a(@NonNull Looper looper, @NonNull C2172ao aoVar) {
            super(looper);
            this.f4437a = new WeakReference<>(aoVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            com.inmobi.media.C2172ao.m4396e();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0110 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r10) {
            /*
                r9 = this;
                java.lang.ref.WeakReference<com.inmobi.media.ao> r0 = r9.f4437a     // Catch:{ Exception -> 0x0114 }
                java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.ao r0 = (com.inmobi.media.C2172ao) r0     // Catch:{ Exception -> 0x0114 }
                int r1 = r10.what     // Catch:{ Exception -> 0x0114 }
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == r4) goto L_0x0085
                if (r1 == r2) goto L_0x002d
                r2 = 3
                if (r1 == r2) goto L_0x0028
                r2 = 4
                if (r1 == r2) goto L_0x0018
                return
            L_0x0018:
                if (r0 == 0) goto L_0x0024
                java.lang.Object r10 = r10.obj     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.ad r10 = (com.inmobi.media.C2154ad) r10     // Catch:{ Exception -> 0x0114 }
                r0.f4416c     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.C2169am.m4363c(r10)     // Catch:{ Exception -> 0x0114 }
            L_0x0024:
                r9.m4418b()     // Catch:{ Exception -> 0x0114 }
                return
            L_0x0028:
                r9.m4418b()     // Catch:{ Exception -> 0x0114 }
                goto L_0x0113
            L_0x002d:
                if (r0 == 0) goto L_0x0113
                java.lang.Object r10 = r10.obj     // Catch:{ Exception -> 0x0114 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0114 }
                r0.f4416c     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.ad r10 = com.inmobi.media.C2169am.m4361b(r10)     // Catch:{ Exception -> 0x0114 }
                if (r10 != 0) goto L_0x0040
                r9.m4418b()     // Catch:{ Exception -> 0x0114 }
                return
            L_0x0040:
                boolean r1 = r10.mo27832a()     // Catch:{ Exception -> 0x0114 }
                if (r1 != 0) goto L_0x007b
                r0.f4417d     // Catch:{ Exception -> 0x0114 }
                int r1 = r10.f4335c     // Catch:{ Exception -> 0x0114 }
                if (r1 != 0) goto L_0x0058
                r1 = 11
                r10.f4344l = r1     // Catch:{ Exception -> 0x0114 }
                r0.m4374a(r10, r3)     // Catch:{ Exception -> 0x0114 }
                r9.m4416a(r10)     // Catch:{ Exception -> 0x0114 }
                return
            L_0x0058:
                boolean r1 = com.inmobi.media.C2515gi.m5353a()     // Catch:{ Exception -> 0x0114 }
                if (r1 != 0) goto L_0x0065
                r0.m4374a(r10, r3)     // Catch:{ Exception -> 0x0114 }
                r0.m4406j()     // Catch:{ Exception -> 0x0114 }
                return
            L_0x0065:
                com.inmobi.media.an r1 = r9.f4438b     // Catch:{ Exception -> 0x0114 }
                boolean r10 = r0.m4383a(r10, r1)     // Catch:{ Exception -> 0x0114 }
                if (r10 == 0) goto L_0x0074
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
                return
            L_0x0074:
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
                r9.m4418b()     // Catch:{ Exception -> 0x0114 }
                return
            L_0x007b:
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
                r9.m4415a()     // Catch:{ Exception -> 0x0114 }
                r0.m4374a(r10, r4)     // Catch:{ Exception -> 0x0114 }
                return
            L_0x0085:
                if (r0 == 0) goto L_0x0113
                com.inmobi.media.eq$a r10 = r0.f4417d     // Catch:{ Exception -> 0x0114 }
                if (r10 != 0) goto L_0x009c
                java.lang.String r10 = "ads"
                java.lang.String r1 = com.inmobi.media.C2505gd.m5306f()     // Catch:{ Exception -> 0x0114 }
                r5 = 0
                com.inmobi.media.er r10 = com.inmobi.media.C2438es.m5087a(r10, r1, r5)     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.eq r10 = (com.inmobi.media.C2426eq) r10     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.eq$a r10 = r10.f5184k     // Catch:{ Exception -> 0x0114 }
            L_0x009c:
                r0.f4416c     // Catch:{ Exception -> 0x0114 }
                java.util.List r1 = com.inmobi.media.C2169am.m4362c()     // Catch:{ Exception -> 0x0114 }
                int r5 = r1.size()     // Catch:{ Exception -> 0x0114 }
                if (r5 > 0) goto L_0x00b0
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
                r0.m4406j()     // Catch:{ Exception -> 0x0114 }
                return
            L_0x00b0:
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
                java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.ad r3 = (com.inmobi.media.C2154ad) r3     // Catch:{ Exception -> 0x0114 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0114 }
            L_0x00bd:
                boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x0114 }
                if (r5 == 0) goto L_0x00d0
                java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x0114 }
                com.inmobi.media.ad r5 = (com.inmobi.media.C2154ad) r5     // Catch:{ Exception -> 0x0114 }
                boolean r6 = r0.f4424k.containsKey(r3.f4336d)     // Catch:{ Exception -> 0x0114 }
                if (r6 != 0) goto L_0x00bd
                r3 = r5
            L_0x00d0:
                android.os.Message r1 = android.os.Message.obtain()     // Catch:{ Exception -> 0x0114 }
                r1.what = r4     // Catch:{ Exception -> 0x0114 }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0114 }
                long r6 = r3.f4338f     // Catch:{ Exception -> 0x0114 }
                long r4 = r4 - r6
                int r6 = r10.f5189b     // Catch:{ Exception -> 0x0110 }
                int r6 = r6 * 1000
                long r6 = (long) r6     // Catch:{ Exception -> 0x0110 }
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 >= 0) goto L_0x00f0
                int r10 = r10.f5189b     // Catch:{ Exception -> 0x0110 }
                int r10 = r10 * 1000
                long r2 = (long) r10     // Catch:{ Exception -> 0x0110 }
                long r2 = r2 - r4
                r9.sendMessageDelayed(r1, r2)     // Catch:{ Exception -> 0x0110 }
                return
            L_0x00f0:
                boolean r0 = r0.f4424k.containsKey(r3.f4336d)     // Catch:{ Exception -> 0x0110 }
                if (r0 == 0) goto L_0x00ff
                int r10 = r10.f5189b     // Catch:{ Exception -> 0x0110 }
                int r10 = r10 * 1000
                long r2 = (long) r10     // Catch:{ Exception -> 0x0110 }
                r9.sendMessageDelayed(r1, r2)     // Catch:{ Exception -> 0x0110 }
                return
            L_0x00ff:
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0110 }
                android.os.Message r10 = android.os.Message.obtain()     // Catch:{ Exception -> 0x0110 }
                r10.what = r2     // Catch:{ Exception -> 0x0110 }
                java.lang.String r0 = r3.f4336d     // Catch:{ Exception -> 0x0110 }
                r10.obj = r0     // Catch:{ Exception -> 0x0110 }
                r9.sendMessage(r10)     // Catch:{ Exception -> 0x0110 }
                return
            L_0x0110:
                com.inmobi.media.C2172ao.f4413b     // Catch:{ Exception -> 0x0114 }
            L_0x0113:
                return
            L_0x0114:
                r10 = move-exception
                com.inmobi.media.C2172ao.f4413b
                com.inmobi.media.fd r0 = com.inmobi.media.C2463fd.m5161a()
                com.inmobi.media.fz r1 = new com.inmobi.media.fz
                r1.<init>(r10)
                r0.mo28382a(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2172ao.C2178a.handleMessage(android.os.Message):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4416a(C2154ad adVar) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = adVar;
                sendMessage(obtain);
            } catch (Exception unused) {
                C2172ao.f4413b;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4415a() {
            try {
                sendEmptyMessage(3);
            } catch (Exception unused) {
                C2172ao.f4413b;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m4418b() {
            try {
                sendEmptyMessage(1);
            } catch (Exception unused) {
                C2172ao.f4413b;
            }
        }
    }

    /* renamed from: com.inmobi.media.ao$b */
    /* compiled from: AssetStore */
    static class C2180b {

        /* renamed from: a */
        static final C2172ao f4440a = new C2172ao(0);
    }

    /* renamed from: com.inmobi.media.ao$c */
    /* compiled from: AssetStore */
    class C2181c implements InvocationHandler {

        /* renamed from: b */
        private CountDownLatch f4442b;

        /* renamed from: c */
        private String f4443c;

        /* renamed from: d */
        private long f4444d;

        /* renamed from: e */
        private String f4445e;

        C2181c(CountDownLatch countDownLatch, String str, long j, String str2) {
            this.f4442b = countDownLatch;
            this.f4443c = str;
            this.f4444d = j;
            this.f4445e = str2;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            C2172ao.f4413b;
            if (method != null) {
                if ("onSuccess".equalsIgnoreCase(method.getName())) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f4444d));
                    hashMap.put("size", Integer.valueOf(0));
                    hashMap.put("assetType", MessengerShareContentUtility.MEDIA_IMAGE);
                    hashMap.put("networkType", C2527gp.m5390b());
                    hashMap.put("adType", this.f4445e);
                    C2497ga.m5260a().mo28447a("AssetDownloaded", hashMap);
                    C2172ao.this.m4381a(this.f4443c);
                    this.f4442b.countDown();
                } else {
                    if ("onError".equalsIgnoreCase(method.getName())) {
                        C2172ao.this.m4388b(this.f4443c);
                        this.f4442b.countDown();
                    }
                }
            }
            return null;
        }
    }

    /* synthetic */ C2172ao(byte b) {
        this();
    }

    private C2172ao() {
        this.f4422i = new AtomicBoolean(false);
        this.f4423j = new AtomicBoolean(false);
        this.f4426n = new ArrayList();
        this.f4427o = new C2171an() {
            /* renamed from: a */
            public final void mo27895a(@NonNull C2487fs fsVar, @NonNull String str, @NonNull C2154ad adVar) {
                C2172ao.f4413b;
                C2154ad a = new C2155a().mo27837a(adVar.f4336d, str, fsVar, C2172ao.this.f4417d.f5188a, C2172ao.this.f4417d.f5192e).mo27838a();
                C2172ao.this.f4416c;
                C2169am.m4359b(a);
                a.f4343k = adVar.f4343k;
                a.f4333a = adVar.f4333a;
                C2172ao.this.m4374a(a, true);
                try {
                    C2172ao.m4391c(C2172ao.this);
                } catch (Exception e) {
                    C2172ao.f4413b;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }

            /* renamed from: a */
            public final void mo27894a(@NonNull C2154ad adVar) {
                C2172ao.f4413b;
                C2172ao.this.m4393c(adVar.f4336d);
                if (adVar.f4335c <= 0) {
                    C2172ao.f4413b;
                    C2172ao.this.m4374a(adVar, false);
                    C2172ao.this.f4416c;
                    C2169am.m4363c(adVar);
                } else {
                    C2172ao.f4413b;
                    adVar.f4338f = System.currentTimeMillis();
                    C2172ao.this.f4416c;
                    C2169am.m4359b(adVar);
                    if (!C2515gi.m5353a()) {
                        C2172ao.this.m4374a(adVar, false);
                    }
                }
                try {
                    C2172ao.m4391c(C2172ao.this);
                } catch (Exception e) {
                    C2172ao.f4413b;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        };
        C2426eq eqVar = (C2426eq) C2438es.m5087a("ads", C2505gd.m5306f(), this);
        this.f4417d = eqVar.f5184k;
        this.f4418e = eqVar.f5183j;
        this.f4416c = C2169am.m4358a();
        this.f4415a = Executors.newCachedThreadPool();
        this.f4419f = Executors.newFixedThreadPool(1);
        this.f4421h = new HandlerThread("assetFetcher");
        this.f4421h.start();
        this.f4420g = new C2178a(this.f4421h.getLooper(), this);
        this.f4425l = new C2523c() {
            /* renamed from: a */
            public final void mo27900a(boolean z) {
                if (z) {
                    C2172ao.m4391c(C2172ao.this);
                } else {
                    C2172ao.this.m4406j();
                }
            }
        };
        this.f4424k = new ConcurrentHashMap<>(2, 0.9f, 2);
    }

    /* renamed from: a */
    public static C2172ao m4371a() {
        return C2180b.f4440a;
    }

    /* renamed from: a */
    public final void mo27896a(C2436er erVar) {
        C2426eq eqVar = (C2426eq) erVar;
        this.f4417d = eqVar.f5184k;
        this.f4418e = eqVar.f5183j;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4381a(String str) {
        boolean z;
        for (int i = 0; i < this.f4426n.size(); i++) {
            C2156ae aeVar = (C2156ae) this.f4426n.get(i);
            Set<C2206av> set = aeVar.f4354b;
            Set<String> set2 = aeVar.f4355c;
            Iterator it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((C2206av) it.next()).f4510b.equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z && !set2.contains(str)) {
                aeVar.f4355c.add(str);
                aeVar.f4356d++;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m4388b(String str) {
        boolean z;
        for (int i = 0; i < this.f4426n.size(); i++) {
            C2156ae aeVar = (C2156ae) this.f4426n.get(i);
            Iterator it = aeVar.f4354b.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((C2206av) it.next()).f4510b.equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                aeVar.f4357e++;
            }
        }
    }

    /* renamed from: a */
    private synchronized void m4373a(C2154ad adVar) {
        boolean z;
        for (int i = 0; i < this.f4426n.size(); i++) {
            C2156ae aeVar = (C2156ae) this.f4426n.get(i);
            Iterator it = aeVar.f4354b.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((C2206av) it.next()).f4510b.equals(adVar.f4336d)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z && !aeVar.f4353a.contains(adVar)) {
                aeVar.f4353a.add(adVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4375a(C2156ae aeVar) {
        if (!this.f4426n.contains(aeVar)) {
            this.f4426n.add(aeVar);
        }
    }

    /* renamed from: a */
    private synchronized void m4382a(List<C2156ae> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.f4426n.remove(list.get(i));
        }
    }

    /* JADX INFO: used method not loaded: com.inmobi.media.gi.a(java.io.Closeable):null, types can be incorrect */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f8, code lost:
        r8.f4344l = 7;
        r8.f4335c = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0100, code lost:
        if (r11.exists() == false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0102, code lost:
        r11.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0105, code lost:
        r4.disconnect();
        com.inmobi.media.C2515gi.m5350a((java.io.Closeable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0167, code lost:
        r8.f4344l = 0;
        r10.f4364a.mo27894a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0170, code lost:
        r8.f4344l = 8;
        r10.f4364a.mo27894a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0179, code lost:
        r8.f4344l = 8;
        r10.f4364a.mo27894a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0182, code lost:
        r8.f4344l = 3;
        r10.f4364a.mo27894a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x018c, code lost:
        r8.f4344l = 4;
        r10.f4364a.mo27894a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0196, code lost:
        r8.f4344l = 4;
        r10.f4364a.mo27894a(r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[ExcHandler: IOException (unused java.io.IOException), SYNTHETIC, Splitter:B:11:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[ExcHandler: ProtocolException (unused java.net.ProtocolException), SYNTHETIC, Splitter:B:11:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[ExcHandler: MalformedURLException (unused java.net.MalformedURLException), SYNTHETIC, Splitter:B:11:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:11:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:11:0x0052] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m4383a(com.inmobi.media.C2154ad r24, com.inmobi.media.C2171an r25) {
        /*
            r23 = this;
            r1 = r23
            r8 = r24
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.inmobi.media.ad> r0 = r1.f4424k
            java.lang.String r2 = r8.f4336d
            java.lang.Object r0 = r0.putIfAbsent(r2, r8)
            com.inmobi.media.ad r0 = (com.inmobi.media.C2154ad) r0
            r9 = 0
            if (r0 != 0) goto L_0x01ab
            com.inmobi.media.af r10 = new com.inmobi.media.af
            r0 = r25
            r10.<init>(r0)
            com.inmobi.media.eq$h r0 = r1.f4418e
            long r2 = r0.f5228c
            com.inmobi.media.eq$h r0 = r1.f4418e
            java.util.ArrayList<java.lang.String> r0 = r0.f5230e
            boolean r4 = com.inmobi.media.C2515gi.m5353a()
            r12 = 8
            if (r4 != 0) goto L_0x0032
            r8.f4344l = r12
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
        L_0x002f:
            r2 = 1
            goto L_0x01aa
        L_0x0032:
            java.lang.String r4 = r8.f4336d
            java.lang.String r5 = ""
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01a0
            java.lang.String r4 = r8.f4336d
            boolean r4 = android.webkit.URLUtil.isValidUrl(r4)
            if (r4 != 0) goto L_0x0046
            goto L_0x01a0
        L_0x0046:
            int r4 = r0.size()
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r4)
            java.lang.String[] r0 = (java.lang.String[]) r0
            long r21 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.net.URL r4 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.lang.String r5 = r8.f4336d     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r4.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.lang.String r5 = "GET"
            r4.setRequestMethod(r5)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r5 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r4.setReadTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            int r5 = r4.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r6 = 400(0x190, float:5.6E-43)
            if (r5 >= r6) goto L_0x00aa
            java.lang.String r5 = r4.getContentType()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            int r6 = r0.length     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r7 = 0
        L_0x007f:
            if (r7 >= r6) goto L_0x009c
            r15 = r0[r7]     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            if (r5 == 0) goto L_0x0099
            java.util.Locale r11 = java.util.Locale.ENGLISH     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.lang.String r11 = r15.toLowerCase(r11)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.util.Locale r15 = java.util.Locale.ENGLISH     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.lang.String r15 = r5.toLowerCase(r15)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            boolean r11 = r11.equals(r15)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            if (r11 == 0) goto L_0x0099
            r0 = 1
            goto L_0x009d
        L_0x0099:
            int r7 = r7 + 1
            goto L_0x007f
        L_0x009c:
            r0 = 0
        L_0x009d:
            if (r0 != 0) goto L_0x00aa
            r0 = 6
            r8.f4344l = r0     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r8.f4335c = r9     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.an r0 = r10.f4364a     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r0.mo27894a(r8)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            goto L_0x002f
        L_0x00aa:
            int r0 = r4.getContentLength()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            long r5 = (long) r0     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r0 = 7
            r15 = 0
            int r7 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r7 < 0) goto L_0x00c5
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x00c5
            r8.f4344l = r0     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r8.f4335c = r9     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.an r0 = r10.f4364a     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r0.mo27894a(r8)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            goto L_0x002f
        L_0x00c5:
            r4.connect()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.lang.String r5 = r8.f4336d     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.io.File r11 = com.inmobi.media.C2505gd.m5284a(r5)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            boolean r5 = r11.exists()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            if (r5 == 0) goto L_0x00d7
            r11.delete()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
        L_0x00d7:
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r7.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r17 = r15
        L_0x00eb:
            int r15 = r5.read(r7)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            if (r15 <= 0) goto L_0x012d
            long r13 = (long) r15     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            long r17 = r17 + r13
            int r13 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0129
            r8.f4344l = r0     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r8.f4335c = r9     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            boolean r0 = r11.exists()     // Catch:{ Exception -> 0x010c, SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170 }
            if (r0 == 0) goto L_0x0105
            r11.delete()     // Catch:{ Exception -> 0x010c, SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170 }
        L_0x0105:
            r4.disconnect()     // Catch:{ Exception -> 0x010c, SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170 }
            com.inmobi.media.C2515gi.m5350a(r6)     // Catch:{ Exception -> 0x010c, SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170 }
            goto L_0x0119
        L_0x010c:
            r0 = move-exception
            com.inmobi.media.fd r2 = com.inmobi.media.C2463fd.m5161a()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.fz r3 = new com.inmobi.media.fz     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r3.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r2.mo28382a(r3)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
        L_0x0119:
            long r19 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r15 = r21
            com.inmobi.media.C2157af.m4278a(r15, r17, r19)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.an r0 = r10.f4364a     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r0.mo27894a(r8)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            goto L_0x002f
        L_0x0129:
            r6.write(r7, r9, r15)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            goto L_0x00eb
        L_0x012d:
            r6.flush()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r4.disconnect()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.C2515gi.m5350a(r6)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r15 = r21
            r19 = r13
            com.inmobi.media.C2157af.m4278a(r15, r17, r19)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.fs r0 = new com.inmobi.media.fs     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.util.Map r2 = r4.getHeaderFields()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r0.f5454c = r2     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r2 = r24
            r3 = r11
            r4 = r21
            r6 = r13
            java.lang.String r2 = com.inmobi.media.C2157af.m4277a(r2, r3, r4, r6)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r8.f4343k = r2     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            long r13 = r13 - r21
            r8.f4333a = r13     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            com.inmobi.media.an r2 = r10.f4364a     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            java.lang.String r3 = r11.getAbsolutePath()     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            r2.mo27895a(r0, r3, r8)     // Catch:{ SocketTimeoutException -> 0x0196, FileNotFoundException -> 0x018c, MalformedURLException -> 0x0182, ProtocolException -> 0x0179, IOException -> 0x0170, Exception -> 0x0167 }
            goto L_0x002f
        L_0x0167:
            r8.f4344l = r9
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x0170:
            r8.f4344l = r12
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x0179:
            r8.f4344l = r12
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x0182:
            r2 = 3
            r8.f4344l = r2
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x018c:
            r2 = 4
            r8.f4344l = r2
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x0196:
            r2 = 4
            r8.f4344l = r2
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x01a0:
            r2 = 3
            r8.f4344l = r2
            com.inmobi.media.an r0 = r10.f4364a
            r0.mo27894a(r8)
            goto L_0x002f
        L_0x01aa:
            return r2
        L_0x01ab:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2172ao.m4383a(com.inmobi.media.ad, com.inmobi.media.an):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4393c(String str) {
        this.f4424k.remove(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4374a(@NonNull C2154ad adVar, boolean z) {
        m4373a(adVar);
        m4393c(adVar.f4336d);
        if (z) {
            m4381a(adVar.f4336d);
            m4398f();
            return;
        }
        m4388b(adVar.f4336d);
        m4401g();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m4398f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f4426n.size(); i++) {
            C2156ae aeVar = (C2156ae) this.f4426n.get(i);
            if (aeVar.f4356d == aeVar.f4354b.size()) {
                try {
                    C2182ap a = aeVar.mo27839a();
                    if (a != null) {
                        a.mo27889b(aeVar);
                    }
                    arrayList.add(aeVar);
                } catch (Exception e) {
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        }
        m4382a((List<C2156ae>) arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m4401g() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f4426n.size(); i++) {
            C2156ae aeVar = (C2156ae) this.f4426n.get(i);
            if (aeVar.f4357e > 0) {
                try {
                    C2182ap a = aeVar.mo27839a();
                    if (a != null) {
                        a.mo27888a(aeVar);
                    }
                    arrayList.add(aeVar);
                } catch (Exception e) {
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        }
        m4382a((List<C2156ae>) arrayList);
    }

    /* renamed from: b */
    public final void mo27897b() {
        this.f4423j.set(false);
        if (!C2515gi.m5353a()) {
            m4403h();
            m4405i();
            return;
        }
        synchronized (f4414m) {
            if (this.f4422i.compareAndSet(false, true)) {
                if (this.f4421h == null) {
                    this.f4421h = new HandlerThread("assetFetcher");
                    this.f4421h.start();
                }
                if (this.f4420g == null) {
                    this.f4420g = new C2178a(this.f4421h.getLooper(), this);
                }
                if (C2169am.m4362c().isEmpty()) {
                    m4406j();
                } else {
                    m4403h();
                    m4405i();
                    this.f4420g.sendEmptyMessage(1);
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo27898c() {
        this.f4423j.set(true);
        m4406j();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ad, code lost:
        return;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27899d() {
        /*
            r11 = this;
            java.lang.Object r0 = f4414m
            monitor-enter(r0)
            java.util.List r1 = com.inmobi.media.C2169am.m4365d()     // Catch:{ all -> 0x00ae }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            return
        L_0x000f:
            java.util.Iterator r2 = r1.iterator()     // Catch:{ all -> 0x00ae }
        L_0x0013:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00ae }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00ae }
            com.inmobi.media.ad r3 = (com.inmobi.media.C2154ad) r3     // Catch:{ all -> 0x00ae }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ae }
            long r8 = r3.f4340h     // Catch:{ all -> 0x00ae }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0013
            m4386b(r3)     // Catch:{ all -> 0x00ae }
            goto L_0x0013
        L_0x0033:
            java.util.List r2 = com.inmobi.media.C2169am.m4365d()     // Catch:{ all -> 0x00ae }
            r6 = 0
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00ae }
        L_0x003d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00ae }
            if (r3 == 0) goto L_0x0056
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00ae }
            com.inmobi.media.ad r3 = (com.inmobi.media.C2154ad) r3     // Catch:{ all -> 0x00ae }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x00ae }
            java.lang.String r3 = r3.f4337e     // Catch:{ all -> 0x00ae }
            r8.<init>(r3)     // Catch:{ all -> 0x00ae }
            long r8 = r8.length()     // Catch:{ all -> 0x00ae }
            long r6 = r6 + r8
            goto L_0x003d
        L_0x0056:
            com.inmobi.media.eq$a r2 = r11.f4417d     // Catch:{ all -> 0x00ae }
            long r2 = r2.f5191d     // Catch:{ all -> 0x00ae }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0068
            com.inmobi.media.ad r2 = com.inmobi.media.C2169am.m4360b()     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x0068
            m4386b(r2)     // Catch:{ all -> 0x00ae }
            goto L_0x0033
        L_0x0068:
            android.content.Context r2 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ all -> 0x00ae }
            java.io.File r2 = com.inmobi.media.C2505gd.m5293b(r2)     // Catch:{ all -> 0x00ae }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x00ae }
            if (r3 == 0) goto L_0x00ac
            java.io.File[] r2 = r2.listFiles()     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x00ac
            int r3 = r2.length     // Catch:{ all -> 0x00ae }
            r6 = 0
        L_0x007e:
            if (r6 >= r3) goto L_0x00ac
            r7 = r2[r6]     // Catch:{ all -> 0x00ae }
            java.util.Iterator r8 = r1.iterator()     // Catch:{ all -> 0x00ae }
        L_0x0086:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x00ae }
            if (r9 == 0) goto L_0x00a0
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x00ae }
            com.inmobi.media.ad r9 = (com.inmobi.media.C2154ad) r9     // Catch:{ all -> 0x00ae }
            java.lang.String r10 = r7.getAbsolutePath()     // Catch:{ all -> 0x00ae }
            java.lang.String r9 = r9.f4337e     // Catch:{ all -> 0x00ae }
            boolean r9 = r10.equals(r9)     // Catch:{ all -> 0x00ae }
            if (r9 == 0) goto L_0x0086
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r8 != 0) goto L_0x00a9
            r7.getAbsolutePath()     // Catch:{ all -> 0x00ae }
            r7.delete()     // Catch:{ all -> 0x00ae }
        L_0x00a9:
            int r6 = r6 + 1
            goto L_0x007e
        L_0x00ac:
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            return
        L_0x00ae:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2172ao.mo27899d():void");
    }

    /* renamed from: b */
    private static void m4386b(C2154ad adVar) {
        C2169am.m4363c(adVar);
        File file = new File(adVar.f4337e);
        if (file.exists()) {
            file.delete();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4390c(C2154ad adVar) {
        File file = new File(adVar.f4337e);
        long min = Math.min(System.currentTimeMillis() + (adVar.f4340h - adVar.f4338f), System.currentTimeMillis() + (this.f4417d.f5192e * 1000));
        C2155a aVar = new C2155a();
        String str = adVar.f4336d;
        String str2 = adVar.f4337e;
        int i = this.f4417d.f5188a;
        long j = adVar.f4341i;
        aVar.f4347c = str;
        aVar.f4348d = str2;
        aVar.f4346b = i;
        aVar.f4351g = min;
        aVar.f4352h = j;
        C2154ad a = aVar.mo27838a();
        a.f4338f = System.currentTimeMillis();
        C2169am.m4359b(a);
        a.f4343k = C2157af.m4277a(adVar, file, adVar.f4338f, adVar.f4338f);
        a.f4342j = true;
        m4374a(a, true);
    }

    @TargetApi(23)
    /* renamed from: h */
    private void m4403h() {
        C2519gm.m5364a();
        C2519gm.m5365a(this.f4425l, "android.net.conn.CONNECTIVITY_CHANGE");
        if (VERSION.SDK_INT >= 23) {
            C2519gm.m5364a();
            C2519gm.m5369b(this.f4425l);
        }
    }

    @TargetApi(23)
    /* renamed from: i */
    private void m4405i() {
        C2519gm.m5364a().mo28471a("android.net.conn.CONNECTIVITY_CHANGE", this.f4425l);
        if (VERSION.SDK_INT >= 23) {
            C2519gm.m5364a().mo28470a(this.f4425l);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m4406j() {
        synchronized (f4414m) {
            this.f4422i.set(false);
            this.f4424k.clear();
            if (this.f4421h != null) {
                this.f4421h.getLooper().quit();
                this.f4421h.interrupt();
                this.f4421h = null;
                this.f4420g = null;
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m4391c(C2172ao aoVar) {
        if (!aoVar.f4423j.get()) {
            aoVar.mo27897b();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4387b(C2172ao aoVar, final String str) {
        C2154ad a = C2169am.m4357a(str);
        if (a == null || !a.mo27832a()) {
            C2154ad a2 = new C2155a().mo27836a(str, aoVar.f4417d.f5188a, aoVar.f4417d.f5192e).mo27838a();
            if (C2169am.m4357a(str) == null) {
                aoVar.f4416c.mo27893a(a2);
            }
            aoVar.f4419f.execute(new Runnable() {
                public final void run() {
                    C2172ao.this.f4416c;
                    C2154ad a = C2169am.m4357a(str);
                    if (a != null) {
                        if (a.mo27832a()) {
                            C2172ao.this.m4390c(a);
                            return;
                        }
                        C2172ao aoVar = C2172ao.this;
                        if (aoVar.m4383a(a, aoVar.f4427o)) {
                            C2172ao.f4413b;
                            return;
                        }
                        C2172ao.f4413b;
                    }
                }
            });
            return;
        }
        aoVar.m4390c(a);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r11v0, types: [java.util.List, java.util.List<java.lang.String>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m4380a(com.inmobi.media.C2172ao r10, java.util.List<java.lang.String> r11, java.lang.String r12) {
        /*
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch
            int r0 = r11.size()
            r7.<init>(r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x000d:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r11.next()
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x003d }
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ Exception -> 0x003d }
            com.squareup.picasso.Picasso r0 = com.inmobi.media.C2277cg.m4616a(r0)     // Catch:{ Exception -> 0x003d }
            com.squareup.picasso.RequestCreator r8 = r0.load(r3)     // Catch:{ Exception -> 0x003d }
            com.inmobi.media.ao$c r9 = new com.inmobi.media.ao$c     // Catch:{ Exception -> 0x003d }
            r0 = r9
            r1 = r10
            r2 = r7
            r6 = r12
            r0.<init>(r2, r3, r4, r6)     // Catch:{ Exception -> 0x003d }
            java.lang.Object r0 = com.inmobi.media.C2277cg.m4618a(r9)     // Catch:{ Exception -> 0x003d }
            com.squareup.picasso.Callback r0 = (com.squareup.picasso.Callback) r0     // Catch:{ Exception -> 0x003d }
            r8.fetch(r0)     // Catch:{ Exception -> 0x003d }
            goto L_0x000d
        L_0x003d:
            r7.countDown()
            goto L_0x000d
        L_0x0041:
            r7.await()     // Catch:{ InterruptedException -> 0x0044 }
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2172ao.m4380a(com.inmobi.media.ao, java.util.List, java.lang.String):void");
    }
}
