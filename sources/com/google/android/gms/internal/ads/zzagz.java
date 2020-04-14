package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzagz<ReferenceT> implements zzagw {
    @GuardedBy("this")
    private final Map<String, CopyOnWriteArrayList<zzaer<? super ReferenceT>>> zzczf = new HashMap();
    private ReferenceT zzczg;

    public final void zzg(ReferenceT referencet) {
        this.zzczg = referencet;
    }

    public final boolean zzcx(@Nullable String str) {
        return str != null && zzg(Uri.parse(str));
    }

    public final boolean zzg(Uri uri) {
        if ("gmsg".equalsIgnoreCase(uri.getScheme())) {
            if ("mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
                zzh(uri);
                return true;
            }
        }
        return false;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        zzq.zzkj();
        zzb(path, zzaul.zzi(uri));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzb(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 2
            boolean r0 = com.google.android.gms.internal.ads.zzaug.isLoggable(r0)     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = "Received GMSG: "
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00c4 }
            int r2 = r1.length()     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x0019
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x00c4 }
            goto L_0x001f
        L_0x0019:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00c4 }
            r1.<init>(r0)     // Catch:{ all -> 0x00c4 }
            r0 = r1
        L_0x001f:
            com.google.android.gms.internal.ads.zzaug.zzdy(r0)     // Catch:{ all -> 0x00c4 }
            java.util.Set r0 = r7.keySet()     // Catch:{ all -> 0x00c4 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00c4 }
        L_0x002a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object r2 = r7.get(r1)     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00c4 }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c4 }
            int r3 = r3.length()     // Catch:{ all -> 0x00c4 }
            int r3 = r3 + 4
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00c4 }
            int r4 = r4.length()     // Catch:{ all -> 0x00c4 }
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r4.<init>(r3)     // Catch:{ all -> 0x00c4 }
            java.lang.String r3 = "  "
            r4.append(r3)     // Catch:{ all -> 0x00c4 }
            r4.append(r1)     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = ": "
            r4.append(r1)     // Catch:{ all -> 0x00c4 }
            r4.append(r2)     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzaug.zzdy(r1)     // Catch:{ all -> 0x00c4 }
            goto L_0x002a
        L_0x006c:
            java.util.Map<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.google.android.gms.internal.ads.zzaer<? super ReferenceT>>> r0 = r5.zzczf     // Catch:{ all -> 0x00c4 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x00c4 }
            java.util.concurrent.CopyOnWriteArrayList r0 = (java.util.concurrent.CopyOnWriteArrayList) r0     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x0099
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x0099
            java.util.Iterator r6 = r0.iterator()     // Catch:{ all -> 0x00c4 }
        L_0x0080:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x0097
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzaer r0 = (com.google.android.gms.internal.ads.zzaer) r0     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzddl r1 = com.google.android.gms.internal.ads.zzaxn.zzdwm     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzagy r2 = new com.google.android.gms.internal.ads.zzagy     // Catch:{ all -> 0x00c4 }
            r2.<init>(r5, r0, r7)     // Catch:{ all -> 0x00c4 }
            r1.execute(r2)     // Catch:{ all -> 0x00c4 }
            goto L_0x0080
        L_0x0097:
            monitor-exit(r5)
            return
        L_0x0099:
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzza.zzctw     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzyw r0 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x00c4 }
            java.lang.Object r7 = r0.zzd(r7)     // Catch:{ all -> 0x00c4 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00c4 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00c4 }
            if (r7 == 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzatr r7 = com.google.android.gms.ads.internal.zzq.zzkn()     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzzr r7 = r7.zzub()     // Catch:{ all -> 0x00c4 }
            if (r7 != 0) goto L_0x00b6
            goto L_0x00c2
        L_0x00b6:
            com.google.android.gms.internal.ads.zzddl r7 = com.google.android.gms.internal.ads.zzaxn.zzdwi     // Catch:{ all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzahb r0 = new com.google.android.gms.internal.ads.zzahb     // Catch:{ all -> 0x00c4 }
            r0.<init>(r6)     // Catch:{ all -> 0x00c4 }
            r7.execute(r0)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r5)
            return
        L_0x00c2:
            monitor-exit(r5)
            return
        L_0x00c4:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagz.zzb(java.lang.String, java.util.Map):void");
    }

    public final synchronized void zza(String str, zzaer<? super ReferenceT> zzaer) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.zzczf.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.zzczf.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzaer);
    }

    public final synchronized void zzb(String str, zzaer<? super ReferenceT> zzaer) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.zzczf.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(zzaer);
        }
    }

    public final synchronized void zza(String str, Predicate<zzaer<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.zzczf.get(str);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzaer zzaer = (zzaer) it.next();
                if (predicate.apply(zzaer)) {
                    arrayList.add(zzaer);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    public final synchronized void reset() {
        this.zzczf.clear();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzaer zzaer, Map map) {
        zzaer.zza(this.zzczg, map);
    }
}
