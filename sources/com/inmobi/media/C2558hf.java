package com.inmobi.media;

import android.content.Context;
import androidx.annotation.NonNull;
import com.inmobi.media.C2457fb.C2458a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.media.hf */
/* compiled from: CarbWorker */
public class C2558hf {

    /* renamed from: a */
    private static final String f5634a = "hf";

    /* renamed from: b */
    private C2458a f5635b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f5636c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2517gk f5637d;

    /* renamed from: e */
    private C2556hd f5638e;

    public C2558hf(@NonNull Context context) {
        this.f5637d = new C2517gk(context, "carb_store");
        this.f5638e = new C2556hd();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo28553a(com.inmobi.media.C2457fb.C2458a r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.f5635b = r6     // Catch:{ all -> 0x003b }
            boolean r6 = r5.f5636c     // Catch:{ all -> 0x003b }
            if (r6 != 0) goto L_0x0039
            com.inmobi.media.gk r6 = r5.f5637d     // Catch:{ all -> 0x003b }
            long r0 = r6.mo28466a()     // Catch:{ all -> 0x003b }
            r2 = 0
            r6 = 1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0027
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003b }
            long r2 = r2 - r0
            com.inmobi.media.fb$a r0 = r5.f5635b     // Catch:{ all -> 0x003b }
            int r0 = r0.f5320d     // Catch:{ all -> 0x003b }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ all -> 0x003b }
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            if (r0 == 0) goto L_0x0039
            r5.f5636c = r6     // Catch:{ all -> 0x003b }
            java.lang.Thread r6 = new java.lang.Thread     // Catch:{ all -> 0x003b }
            com.inmobi.media.hf$1 r0 = new com.inmobi.media.hf$1     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
            r6.<init>(r0)     // Catch:{ all -> 0x003b }
            r6.start()     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r5)
            return
        L_0x003b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2558hf.mo28553a(com.inmobi.media.fb$a):void");
    }

    /* renamed from: a */
    private static boolean m5550a(String str) {
        Context c = C2505gd.m5298c();
        boolean z = false;
        if (c == null) {
            return false;
        }
        try {
            c.getPackageManager().getPackageInfo(str, 256);
            z = true;
        } catch (Exception unused) {
        }
        return z;
    }

    /* renamed from: a */
    static /* synthetic */ C2554hb m5547a(C2558hf hfVar) {
        String str = hfVar.f5635b.f5318b;
        int i = hfVar.f5635b.f5321e;
        int i2 = hfVar.f5635b.f5322f;
        C2568hj.m5581a();
        C2553ha haVar = new C2553ha(str, i, i2, C2568hj.m5582d());
        haVar.f5445q = hfVar.f5635b.f5324h;
        haVar.f5441m = hfVar.f5635b.f5323g * 1000;
        haVar.f5442n = hfVar.f5635b.f5323g * 1000;
        return C2556hd.m5545a(haVar);
    }

    /* renamed from: a */
    static /* synthetic */ List m5548a(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!m5550a(((C2555hc) list.get(i)).f5628a)) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m5549a(C2558hf hfVar, C2554hb hbVar, List list) {
        String str = hfVar.f5635b.f5319c;
        int i = hfVar.f5635b.f5321e;
        int i2 = hfVar.f5635b.f5322f;
        C2568hj.m5581a();
        C2557he heVar = new C2557he(str, i, i2, C2568hj.m5582d(), list, hbVar);
        heVar.f5441m = hfVar.f5635b.f5323g * 1000;
        heVar.f5442n = hfVar.f5635b.f5323g * 1000;
        C2556hd.m5546a(heVar);
    }
}
