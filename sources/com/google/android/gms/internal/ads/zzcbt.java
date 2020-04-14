package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbt {
    @GuardedBy("this")
    private List<Map<String, String>> zzfsk = new ArrayList();
    @GuardedBy("this")
    private boolean zzfsl = false;
    @GuardedBy("this")
    private boolean zzfsm = false;
    private String zzfsn;
    private zzcbo zzfso;

    public zzcbt(String str, zzcbo zzcbo) {
        this.zzfsn = str;
        this.zzfso = zzcbo;
    }

    public final synchronized void zzfy(String str) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcmt)).booleanValue()) {
            Map zzajz = zzajz();
            zzajz.put(NativeProtocol.WEB_DIALOG_ACTION, "adapter_init_started");
            zzajz.put("ancn", str);
            this.zzfsk.add(zzajz);
        }
    }

    public final synchronized void zzfz(String str) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcmt)).booleanValue()) {
            Map zzajz = zzajz();
            zzajz.put(NativeProtocol.WEB_DIALOG_ACTION, "adapter_init_finished");
            zzajz.put("ancn", str);
            this.zzfsk.add(zzajz);
        }
    }

    public final synchronized void zzr(String str, String str2) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcmt)).booleanValue()) {
            Map zzajz = zzajz();
            zzajz.put(NativeProtocol.WEB_DIALOG_ACTION, "adapter_init_finished");
            zzajz.put("ancn", str);
            zzajz.put("rqe", str2);
            this.zzfsk.add(zzajz);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzajx() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcmt     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.zzfsl     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            java.util.Map r0 = r3.zzajz()     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x002e }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzfsk     // Catch:{ all -> 0x002e }
            r1.add(r0)     // Catch:{ all -> 0x002e }
            r0 = 1
            r3.zzfsl = r0     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r3)
            return
        L_0x002e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zzajx():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzajy() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcmt     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.zzfsm     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0044
            java.util.Map r0 = r3.zzajz()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0046 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzfsk     // Catch:{ all -> 0x0046 }
            r1.add(r0)     // Catch:{ all -> 0x0046 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.zzfsk     // Catch:{ all -> 0x0046 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0046 }
        L_0x002f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0041
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0046 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcbo r2 = r3.zzfso     // Catch:{ all -> 0x0046 }
            r2.zzm(r1)     // Catch:{ all -> 0x0046 }
            goto L_0x002f
        L_0x0041:
            r0 = 1
            r3.zzfsm = r0     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zzajy():void");
    }

    private final Map<String, String> zzajz() {
        Map<String, String> zzajv = this.zzfso.zzajv();
        zzajv.put("tms", Long.toString(zzq.zzkq().elapsedRealtime(), 10));
        zzajv.put("tid", this.zzfsn);
        return zzajv;
    }
}
