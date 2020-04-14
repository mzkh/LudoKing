package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrt<T> {
    private final Executor executor;
    private final Set<zzcru<? extends zzcrr<T>>> zzggh;

    public zzcrt(Executor executor2, Set<zzcru<? extends zzcrr<T>>> set) {
        this.executor = executor2;
        this.zzggh = set;
    }

    public final zzddi<T> zzs(T t) {
        ArrayList arrayList = new ArrayList(this.zzggh.size());
        for (zzcru zzcru : this.zzggh) {
            zzddi zzalv = zzcru.zzalv();
            if (((Boolean) zzuv.zzon().zzd(zzza.zzclv)).booleanValue()) {
                zzalv.addListener(new zzcrw(zzcru, zzq.zzkq().elapsedRealtime()), zzaxn.zzdwn);
            }
            arrayList.add(zzalv);
        }
        return zzdcy.zzh(arrayList).zza(new zzcrv(arrayList, t), this.executor);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.google.android.gms.internal.ads.zzddi>, for r1v0, types: [java.util.List, java.util.List<com.google.android.gms.internal.ads.zzddi>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ java.lang.Object zza(java.util.List<com.google.android.gms.internal.ads.zzddi> r1, java.lang.Object r2) throws java.lang.Exception {
        /*
            java.util.Iterator r1 = r1.iterator()
        L_0x0004:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r1.next()
            com.google.android.gms.internal.ads.zzddi r0 = (com.google.android.gms.internal.ads.zzddi) r0
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x001c }
            com.google.android.gms.internal.ads.zzcrr r0 = (com.google.android.gms.internal.ads.zzcrr) r0     // Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x001c }
            if (r0 == 0) goto L_0x0004
            r0.zzr(r2)     // Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x001c }
            goto L_0x0004
        L_0x001c:
            r1 = move-exception
            goto L_0x001f
        L_0x001e:
            r1 = move-exception
        L_0x001f:
            java.lang.String r2 = "Derive quality signals error."
            com.google.android.gms.internal.ads.zzaug.zzc(r2, r1)
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>(r1)
            throw r2
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrt.zza(java.util.List, java.lang.Object):java.lang.Object");
    }
}
