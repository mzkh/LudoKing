package com.inmobi.media;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.media.fl */
/* compiled from: EventSubmitter */
public class C2476fl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f5407a = "fl";

    /* renamed from: b */
    private static ScheduledExecutorService f5408b;

    /* renamed from: com.inmobi.media.fl$a */
    /* compiled from: EventSubmitter */
    static class C2478a {

        /* renamed from: a */
        static final C2476fl f5419a = new C2476fl(0);
    }

    /* synthetic */ C2476fl(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2476fl m5197a() {
        return C2478a.f5419a;
    }

    private C2476fl() {
        f5408b = Executors.newSingleThreadScheduledExecutor();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28402a(C2473fj fjVar, String str, int i, int i2, long j, C2540gy gyVar, C2479fm fmVar, boolean z) {
        C2473fj fjVar2 = fjVar;
        int i3 = i;
        int i4 = i2;
        if (!C2515gi.m5353a() || !C2505gd.m5312j()) {
            fmVar.mo28399a(fjVar2, false);
            return;
        }
        final C2486fr frVar = new C2486fr("POST", str, false, gyVar);
        HashMap hashMap = new HashMap();
        hashMap.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, fjVar2.f5393b);
        frVar.mo28410c(hashMap);
        int i5 = i3 - i4;
        if (i5 > 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("X-im-retry-count", String.valueOf(i5));
            frVar.mo28407a((Map<String, String>) hashMap2);
        }
        frVar.f5450v = false;
        frVar.f5444p = false;
        long j2 = 0;
        if (z) {
            if (i4 != i3) {
                j2 = ((long) Math.pow(2.0d, (double) i5)) * j;
            }
        } else if (i4 != i3) {
            j2 = j;
        }
        long j3 = j2;
        ScheduledExecutorService scheduledExecutorService = f5408b;
        final int i6 = i2;
        final C2473fj fjVar3 = fjVar;
        final String str2 = str;
        final int i7 = i;
        final long j4 = j;
        final C2540gy gyVar2 = gyVar;
        final C2479fm fmVar2 = fmVar;
        final boolean z2 = z;
        C24771 r0 = new Runnable() {
            public final void run() {
                C2487fs a = new C2488ft(frVar).mo28422a();
                if (!a.mo28417a()) {
                    fmVar2.mo28398a(fjVar3);
                } else if (i6 > 1) {
                    C2476fl.f5407a;
                    a.mo28418b();
                    C2476fl.this.mo28402a(fjVar3, str2, i7, i6 - 1, j4, gyVar2, fmVar2, z2);
                } else {
                    fmVar2.mo28399a(fjVar3, true);
                }
            }
        };
        scheduledExecutorService.schedule(r0, j3, TimeUnit.SECONDS);
    }
}
