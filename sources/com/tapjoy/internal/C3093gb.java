package com.tapjoy.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tapjoy.internal.gb */
public abstract class C3093gb {

    /* renamed from: a */
    private final ReentrantLock f7292a = new ReentrantLock();

    /* renamed from: b */
    volatile int f7293b = C3101c.f7315a;

    /* renamed from: c */
    C3098b f7294c;

    /* renamed from: d */
    long f7295d = 1000;

    /* renamed from: e */
    C3097a f7296e;

    /* renamed from: f */
    private final Condition f7297f = this.f7292a.newCondition();

    /* renamed from: g */
    private final LinkedList f7298g = new LinkedList();

    /* renamed from: h */
    private C3097a f7299h;

    /* renamed from: com.tapjoy.internal.gb$3 */
    static /* synthetic */ class C30963 {

        /* renamed from: a */
        static final /* synthetic */ int[] f7302a = new int[C3101c.m7155a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
                int[] r0 = com.tapjoy.internal.C3093gb.C3101c.m7155a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7302a = r0
                r0 = 1
                int[] r1 = f7302a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.tapjoy.internal.C3093gb.C3101c.f7319e     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = f7302a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = com.tapjoy.internal.C3093gb.C3101c.f7315a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = f7302a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = com.tapjoy.internal.C3093gb.C3101c.f7316b     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = f7302a     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = com.tapjoy.internal.C3093gb.C3101c.f7317c     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = r2 - r0
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                int[] r1 = f7302a     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = com.tapjoy.internal.C3093gb.C3101c.f7318d     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = r2 - r0
                r0 = 5
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3093gb.C30963.<clinit>():void");
        }
    }

    /* renamed from: com.tapjoy.internal.gb$a */
    class C3097a {

        /* renamed from: a */
        public final Context f7303a;

        /* renamed from: b */
        public final String f7304b;

        /* renamed from: c */
        public final Hashtable f7305c;

        public C3097a(Context context, String str, Hashtable hashtable) {
            Context context2;
            if (context == null) {
                context2 = null;
            } else if (context instanceof Application) {
                context2 = context;
            } else {
                context2 = context.getApplicationContext();
            }
            if (context2 == null) {
                context2 = context;
            }
            this.f7303a = context2;
            this.f7304b = str;
            this.f7305c = hashtable;
        }
    }

    /* renamed from: com.tapjoy.internal.gb$b */
    class C3098b extends C3237ka {

        /* renamed from: b */
        private boolean f7308b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f7309c;

        /* renamed from: d */
        private Context f7310d;

        /* renamed from: e */
        private BroadcastReceiver f7311e;

        private C3098b() {
            this.f7311e = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    C3093gb.this.mo30171b();
                }
            };
        }

        /* synthetic */ C3098b(C3093gb gbVar, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo30174a() {
            this.f7308b = true;
            C3093gb.this.mo30171b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final void mo30175b() {
            C3093gb gbVar = C3093gb.this;
            int i = C3101c.f7317c;
            int i2 = C3101c.f7316b;
            gbVar.mo30168a(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public final void mo30176c() {
            if (C3093gb.this.f7294c == this) {
                C3093gb.this.f7294c = null;
            }
            if (C3093gb.this.f7293b == C3101c.f7317c) {
                C3093gb gbVar = C3093gb.this;
                int i = C3101c.f7315a;
                int i2 = C3101c.f7317c;
                gbVar.mo30168a(i);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004e */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[SYNTHETIC, Splitter:B:17:0x0064] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC] */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo30177d() {
            /*
                r7 = this;
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C3093gb.this
                com.tapjoy.internal.gb$a r0 = r0.mo30167a()
                android.content.Context r0 = r0.f7303a
                r7.f7310d = r0
                android.content.IntentFilter r0 = new android.content.IntentFilter
                java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
                r0.<init>(r1)
                android.content.Context r1 = r7.f7310d
                android.content.BroadcastReceiver r2 = r7.f7311e
                r1.registerReceiver(r2, r0)
            L_0x0018:
                boolean r0 = r7.f7308b     // Catch:{ all -> 0x008b }
                if (r0 != 0) goto L_0x0087
                java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x008b }
                r1 = 1
                r0.<init>(r1)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.fs$a r2 = com.tapjoy.internal.C3081fs.f7265b     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb$b$1 r3 = new com.tapjoy.internal.gb$b$1     // Catch:{ all -> 0x008b }
                r3.<init>(r0)     // Catch:{ all -> 0x008b }
                r2.addObserver(r3)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r2 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb$a r2 = r2.mo30167a()     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r3 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                android.content.Context r4 = r2.f7303a     // Catch:{ all -> 0x008b }
                java.lang.String r5 = r2.f7304b     // Catch:{ all -> 0x008b }
                java.util.Hashtable r2 = r2.f7305c     // Catch:{ all -> 0x008b }
                r6 = 0
                boolean r2 = r3.mo30079a(r4, r5, r2, r6)     // Catch:{ all -> 0x008b }
                r3 = 0
                if (r2 != 0) goto L_0x004b
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                r0.mo30169a(r3)     // Catch:{ all -> 0x008b }
                r7.m7150h()
                return
            L_0x004b:
                r0.await()     // Catch:{ InterruptedException -> 0x004e }
            L_0x004e:
                boolean r0 = r7.f7309c     // Catch:{ all -> 0x008b }
                if (r0 == 0) goto L_0x0064
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                int r2 = com.tapjoy.internal.C3093gb.C3101c.f7319e     // Catch:{ all -> 0x008b }
                int r3 = com.tapjoy.internal.C3093gb.C3101c.f7317c     // Catch:{ all -> 0x008b }
                r0.mo30168a(r2)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                r0.mo30169a(r1)     // Catch:{ all -> 0x008b }
                r7.m7150h()
                return
            L_0x0064:
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                r0.mo30169a(r3)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                long r0 = r0.f7295d     // Catch:{ all -> 0x008b }
                r2 = 1000(0x3e8, double:4.94E-321)
                long r0 = java.lang.Math.max(r0, r2)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r2 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                r3 = 2
                long r3 = r0 << r3
                r5 = 3600000(0x36ee80, double:1.7786363E-317)
                long r3 = java.lang.Math.min(r3, r5)     // Catch:{ all -> 0x008b }
                r2.f7295d = r3     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r2 = com.tapjoy.internal.C3093gb.this     // Catch:{ all -> 0x008b }
                r2.mo30170a(r0)     // Catch:{ all -> 0x008b }
                goto L_0x0018
            L_0x0087:
                r7.m7150h()
                return
            L_0x008b:
                r0 = move-exception
                r7.m7150h()
                throw r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3093gb.C3098b.mo30177d():void");
        }

        /* renamed from: h */
        private void m7150h() {
            this.f7310d.unregisterReceiver(this.f7311e);
        }
    }

    /* renamed from: com.tapjoy.internal.gb$c */
    enum C3101c {
        ;
        

        /* renamed from: a */
        public static final int f7315a = 1;

        /* renamed from: b */
        public static final int f7316b = 2;

        /* renamed from: c */
        public static final int f7317c = 3;

        /* renamed from: d */
        public static final int f7318d = 4;

        /* renamed from: e */
        public static final int f7319e = 5;

        static {
            f7320f = new int[]{f7315a, f7316b, f7317c, f7318d, f7319e};
        }

        /* renamed from: a */
        public static int[] m7155a() {
            return (int[]) f7320f.clone();
        }
    }

    /* renamed from: a */
    public abstract boolean mo30079a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    /* renamed from: b */
    public final boolean mo30172b(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        this.f7292a.lock();
        if (tJConnectListener != null) {
            try {
                this.f7298g.addLast(C3072fn.m7099a(tJConnectListener, TJConnectListener.class));
            } catch (Throwable th) {
                this.f7292a.unlock();
                throw th;
            }
        }
        C3097a aVar = new C3097a(context, str, hashtable);
        int i = C30963.f7302a[this.f7293b - 1];
        if (i != 1) {
            if (i == 2) {
                this.f7296e = aVar;
                C3081fs.f7265b.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        C3081fs.f7265b.deleteObserver(this);
                        if (!Boolean.valueOf(Boolean.TRUE.equals(obj)).booleanValue() && C3093gb.this.f7296e != null && C3093gb.this.f7296e.f7303a != null) {
                            C3093gb gbVar = C3093gb.this;
                            gbVar.f7294c = new C3098b(gbVar, 0);
                            C3093gb.this.f7294c.mo30350e();
                        }
                    }
                });
                if (mo30079a(aVar.f7303a, aVar.f7304b, aVar.f7305c, new TJConnectListener() {
                    public final void onConnectSuccess() {
                        C3093gb gbVar = C3093gb.this;
                        int i = C3101c.f7319e;
                        int i2 = C3101c.f7316b;
                        gbVar.mo30168a(i);
                        C3093gb.this.mo30169a(true);
                    }

                    public final void onConnectFailure() {
                        C3093gb.this.mo30169a(false);
                    }
                })) {
                    int i2 = C3101c.f7316b;
                    int i3 = C3101c.f7315a;
                    mo30168a(i2);
                } else {
                    this.f7298g.clear();
                }
            } else if (i == 3 || i == 4) {
                this.f7299h = aVar;
            } else if (i != 5) {
                mo30168a(C3101c.f7315a);
            } else {
                this.f7299h = aVar;
                mo30171b();
            }
            this.f7292a.unlock();
            return false;
        }
        mo30169a(true);
        this.f7292a.unlock();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30168a(int i) {
        this.f7292a.lock();
        try {
            int i2 = this.f7293b;
            this.f7293b = i;
        } finally {
            this.f7292a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C3097a mo30167a() {
        this.f7292a.lock();
        try {
            if (this.f7299h != null) {
                this.f7296e = this.f7299h;
                this.f7299h = null;
            }
            return this.f7296e;
        } finally {
            this.f7292a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30169a(boolean z) {
        this.f7292a.lock();
        try {
            if (this.f7298g.size() != 0) {
                ArrayList arrayList = new ArrayList(this.f7298g);
                this.f7298g.clear();
                this.f7292a.unlock();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    TJConnectListener tJConnectListener = (TJConnectListener) it.next();
                    if (z) {
                        tJConnectListener.onConnectSuccess();
                    } else {
                        tJConnectListener.onConnectFailure();
                    }
                }
            }
        } finally {
            this.f7292a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo30171b() {
        this.f7292a.lock();
        try {
            this.f7295d = 1000;
            this.f7297f.signal();
        } finally {
            this.f7292a.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo30170a(long j) {
        this.f7292a.lock();
        try {
            int i = C3101c.f7318d;
            int i2 = C3101c.f7317c;
            mo30168a(i);
            if (this.f7297f.await(j, TimeUnit.MILLISECONDS)) {
                this.f7295d = 1000;
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            int i3 = C3101c.f7317c;
            int i4 = C3101c.f7318d;
            mo30168a(i3);
            this.f7292a.unlock();
            throw th;
        }
        int i5 = C3101c.f7317c;
        int i6 = C3101c.f7318d;
        mo30168a(i5);
        this.f7292a.unlock();
        return false;
    }
}
