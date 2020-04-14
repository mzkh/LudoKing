package com.inmobi.media;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.inmobi.media.hg */
/* compiled from: IceCollector */
class C2560hg {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f5640b = "hg";

    /* renamed from: a */
    C2561a f5641a;

    /* renamed from: com.inmobi.media.hg$a */
    /* compiled from: IceCollector */
    static class C2561a extends Handler {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f5642a;

        C2561a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                C2560hg.f5640b;
                sendEmptyMessage(3);
            } else if (i == 2) {
                C2560hg.f5640b;
                removeMessages(3);
            } else if (i != 3) {
                C2560hg.f5640b;
                int i2 = message.what;
            } else {
                C2560hg.f5640b;
                if (this.f5642a) {
                    sendEmptyMessage(2);
                    return;
                }
                C2575hp.m5605a();
                C2568hj.m5581a();
                sendEmptyMessageDelayed(3, (long) (C2568hj.m5583e().f5325a * 1000));
            }
        }
    }

    C2560hg() {
        HandlerThread handlerThread = new HandlerThread("DataCollectionHandler");
        handlerThread.start();
        this.f5641a = new C2561a(handlerThread.getLooper());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[SYNTHETIC, Splitter:B:20:0x0048] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo28555a() {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = com.inmobi.media.C2505gd.m5292a()     // Catch:{ all -> 0x0061 }
            r1 = 2
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0043
            java.lang.String[] r0 = new java.lang.String[r2]     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "android.permission.ACCESS_WIFI_STATE"
            r0[r4] = r5     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "android.permission.CHANGE_WIFI_STATE"
            r0[r3] = r5     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            r0[r1] = r5     // Catch:{ all -> 0x0061 }
            android.content.Context r5 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r5 = com.inmobi.media.C2516gj.m5357a(r5, r6)     // Catch:{ all -> 0x0061 }
            r6 = 0
            r7 = 1
        L_0x0025:
            if (r6 >= r2) goto L_0x0037
            r8 = r0[r6]     // Catch:{ all -> 0x0061 }
            android.content.Context r9 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ all -> 0x0061 }
            boolean r8 = com.inmobi.media.C2516gj.m5357a(r9, r8)     // Catch:{ all -> 0x0061 }
            if (r8 != 0) goto L_0x0034
            r7 = 0
        L_0x0034:
            int r6 = r6 + 1
            goto L_0x0025
        L_0x0037:
            if (r7 == 0) goto L_0x0043
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0061 }
            r6 = 29
            if (r0 < r6) goto L_0x0041
            if (r5 == 0) goto L_0x0043
        L_0x0041:
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            if (r0 != 0) goto L_0x0048
            monitor-exit(r10)
            return
        L_0x0048:
            com.inmobi.media.hg$a r0 = r10.f5641a     // Catch:{ all -> 0x0061 }
            r0.f5642a = r4     // Catch:{ all -> 0x0061 }
            com.inmobi.media.hg$a r0 = r10.f5641a     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.hasMessages(r2)     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x005f
            com.inmobi.media.hg$a r0 = r10.f5641a     // Catch:{ all -> 0x0061 }
            r0.removeMessages(r1)     // Catch:{ all -> 0x0061 }
            com.inmobi.media.hg$a r0 = r10.f5641a     // Catch:{ all -> 0x0061 }
            r0.sendEmptyMessage(r3)     // Catch:{ all -> 0x0061 }
        L_0x005f:
            monitor-exit(r10)
            return
        L_0x0061:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2560hg.mo28555a():void");
    }
}
