package com.appsflyer.internal;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.appsflyer.internal.w */
public final class C1388w {

    /* renamed from: ˊ */
    static final BitSet f3605 = new BitSet(6);

    /* renamed from: ˊॱ */
    private static final Handler f3606 = new Handler(Looper.getMainLooper());
    @VisibleForTesting

    /* renamed from: ˋॱ */
    private static volatile C1388w f3607;

    /* renamed from: ʻ */
    boolean f3608;

    /* renamed from: ʼ */
    boolean f3609;

    /* renamed from: ʽ */
    public final Runnable f3610 = new Runnable() {
        public final void run() {
            synchronized (C1388w.this.f3611) {
                C1388w.this.mo10847();
            }
        }
    };

    /* renamed from: ˋ */
    final Object f3611 = new Object();

    /* renamed from: ˎ */
    public final Handler f3612;

    /* renamed from: ˏ */
    final Map<C1395y, C1395y> f3613 = new HashMap(f3605.size());

    /* renamed from: ˏॱ */
    public long f3614 = 0;

    /* renamed from: ͺ */
    public int f3615 = 1;

    /* renamed from: ॱ */
    final SensorManager f3616;

    /* renamed from: ॱˊ */
    private final Map<C1395y, Map<String, Object>> f3617 = new ConcurrentHashMap(f3605.size());
    /* access modifiers changed from: private */

    /* renamed from: ॱˋ */
    public final Runnable f3618 = new Runnable() {
        public final void run() {
            synchronized (C1388w.this.f3611) {
                if (C1388w.this.f3615 == 0) {
                    C1388w.this.f3615 = 1;
                }
                C1388w.this.f3612.postDelayed(C1388w.this.f3610, ((long) C1388w.this.f3615) * 500);
            }
        }
    };

    /* renamed from: ॱॱ */
    public final Runnable f3619 = new Runnable() {
        /* JADX WARNING: Can't wrap try/catch for region: R(9:2|3|4|5|6|(5:9|(1:14)(1:13)|(4:16|(1:18)|19|29)(1:28)|27|7)|20|21|22) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x005f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r10 = this;
                com.appsflyer.internal.w r0 = com.appsflyer.internal.C1388w.this
                java.lang.Object r0 = r0.f3611
                monitor-enter(r0)
                com.appsflyer.internal.w r1 = com.appsflyer.internal.C1388w.this     // Catch:{ all -> 0x0076 }
                r2 = 1
                android.hardware.SensorManager r3 = r1.f3616     // Catch:{ Throwable -> 0x005f }
                r4 = -1
                java.util.List r3 = r3.getSensorList(r4)     // Catch:{ Throwable -> 0x005f }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ Throwable -> 0x005f }
            L_0x0013:
                boolean r4 = r3.hasNext()     // Catch:{ Throwable -> 0x005f }
                if (r4 == 0) goto L_0x005f
                java.lang.Object r4 = r3.next()     // Catch:{ Throwable -> 0x005f }
                android.hardware.Sensor r4 = (android.hardware.Sensor) r4     // Catch:{ Throwable -> 0x005f }
                int r5 = r4.getType()     // Catch:{ Throwable -> 0x005f }
                r6 = 0
                if (r5 < 0) goto L_0x0030
                java.util.BitSet r7 = com.appsflyer.internal.C1388w.f3605     // Catch:{ Throwable -> 0x005f }
                boolean r5 = r7.get(r5)     // Catch:{ Throwable -> 0x005f }
                if (r5 == 0) goto L_0x0030
                r5 = 1
                goto L_0x0031
            L_0x0030:
                r5 = 0
            L_0x0031:
                if (r5 == 0) goto L_0x0013
                int r5 = r4.getType()     // Catch:{ Throwable -> 0x005f }
                java.lang.String r7 = r4.getName()     // Catch:{ Throwable -> 0x005f }
                java.lang.String r8 = r4.getVendor()     // Catch:{ Throwable -> 0x005f }
                com.appsflyer.internal.y r9 = new com.appsflyer.internal.y     // Catch:{ Throwable -> 0x005f }
                r9.<init>(r5, r7, r8)     // Catch:{ Throwable -> 0x005f }
                java.util.Map<com.appsflyer.internal.y, com.appsflyer.internal.y> r5 = r1.f3613     // Catch:{ Throwable -> 0x005f }
                boolean r5 = r5.containsKey(r9)     // Catch:{ Throwable -> 0x005f }
                if (r5 != 0) goto L_0x0051
                java.util.Map<com.appsflyer.internal.y, com.appsflyer.internal.y> r5 = r1.f3613     // Catch:{ Throwable -> 0x005f }
                r5.put(r9, r9)     // Catch:{ Throwable -> 0x005f }
            L_0x0051:
                java.util.Map<com.appsflyer.internal.y, com.appsflyer.internal.y> r5 = r1.f3613     // Catch:{ Throwable -> 0x005f }
                java.lang.Object r5 = r5.get(r9)     // Catch:{ Throwable -> 0x005f }
                android.hardware.SensorEventListener r5 = (android.hardware.SensorEventListener) r5     // Catch:{ Throwable -> 0x005f }
                android.hardware.SensorManager r7 = r1.f3616     // Catch:{ Throwable -> 0x005f }
                r7.registerListener(r5, r4, r6)     // Catch:{ Throwable -> 0x005f }
                goto L_0x0013
            L_0x005f:
                r1.f3608 = r2     // Catch:{ all -> 0x0076 }
                com.appsflyer.internal.w r1 = com.appsflyer.internal.C1388w.this     // Catch:{ all -> 0x0076 }
                android.os.Handler r1 = r1.f3612     // Catch:{ all -> 0x0076 }
                com.appsflyer.internal.w r3 = com.appsflyer.internal.C1388w.this     // Catch:{ all -> 0x0076 }
                java.lang.Runnable r3 = r3.f3618     // Catch:{ all -> 0x0076 }
                r4 = 100
                r1.postDelayed(r3, r4)     // Catch:{ all -> 0x0076 }
                com.appsflyer.internal.w r1 = com.appsflyer.internal.C1388w.this     // Catch:{ all -> 0x0076 }
                r1.f3609 = r2     // Catch:{ all -> 0x0076 }
                monitor-exit(r0)     // Catch:{ all -> 0x0076 }
                return
            L_0x0076:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1388w.C13891.run():void");
        }
    };

    /* renamed from: ᐝ */
    public final Runnable f3620 = new Runnable() {
        public final void run() {
            synchronized (C1388w.this.f3611) {
                if (C1388w.this.f3609) {
                    C1388w.this.f3612.removeCallbacks(C1388w.this.f3619);
                    C1388w.this.f3612.removeCallbacks(C1388w.this.f3610);
                    C1388w.this.mo10847();
                    C1388w.this.f3609 = false;
                }
            }
        }
    };

    static {
        f3605.set(1);
        f3605.set(2);
        f3605.set(4);
    }

    private C1388w(@NonNull SensorManager sensorManager, Handler handler) {
        this.f3616 = sensorManager;
        this.f3612 = handler;
    }

    /* renamed from: ˏ */
    public static C1388w m3355(Context context) {
        if (f3607 != null) {
            return f3607;
        }
        return m3356((SensorManager) context.getApplicationContext().getSystemService("sensor"), f3606);
    }

    /* renamed from: ˏ */
    private static C1388w m3356(SensorManager sensorManager, Handler handler) {
        if (f3607 == null) {
            synchronized (C1388w.class) {
                if (f3607 == null) {
                    f3607 = new C1388w(sensorManager, handler);
                }
            }
        }
        return f3607;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final void mo10847() {
        try {
            if (!this.f3613.isEmpty()) {
                for (C1395y yVar : this.f3613.values()) {
                    this.f3616.unregisterListener(yVar);
                    yVar.mo10858(this.f3617, true);
                }
            }
        } catch (Throwable unused) {
        }
        this.f3615 = 0;
        this.f3608 = false;
    }

    /* renamed from: ˋ */
    public final List<Map<String, Object>> mo10845() {
        for (C1395y r1 : this.f3613.values()) {
            r1.mo10858(this.f3617, true);
        }
        if (this.f3617.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.f3617.values());
    }

    @NonNull
    /* renamed from: ˎ */
    public final List<Map<String, Object>> mo10846() {
        synchronized (this.f3611) {
            if (!this.f3613.isEmpty() && this.f3608) {
                for (C1395y r2 : this.f3613.values()) {
                    r2.mo10858(this.f3617, false);
                }
            }
            if (this.f3617.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.f3617.values());
            return copyOnWriteArrayList2;
        }
    }
}
