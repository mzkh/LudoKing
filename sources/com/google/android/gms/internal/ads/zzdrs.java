package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdrs extends zzdrq {
    private static final Class<?> zzhmn = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdrs() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzdtt.zzp(obj, j);
        if (list instanceof zzdrn) {
            obj2 = ((zzdrn) list).zzbao();
        } else if (!zzhmn.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzdss) || !(list instanceof zzdrd)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzdrd zzdrd = (zzdrd) list;
                if (zzdrd.zzaxi()) {
                    zzdrd.zzaxj();
                }
                return;
            }
        } else {
            return;
        }
        zzdtt.zza(obj, j, obj2);
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzdro, java.lang.Object, com.google.android.gms.internal.ads.zzdpg] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.List<L>] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzd(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzdrn
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzdro r0 = new com.google.android.gms.internal.ads.zzdro
            r0.<init>(r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzdss
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzdrd
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzdrd r0 = (com.google.android.gms.internal.ads.zzdrd) r0
            com.google.android.gms.internal.ads.zzdrd r6 = r0.zzfl(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.ads.zzdtt.zza(r3, r4, r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = zzhmn
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.ads.zzdtt.zza(r3, r4, r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzdts
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzdro r1 = new com.google.android.gms.internal.ads.zzdro
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            com.google.android.gms.internal.ads.zzdts r0 = (com.google.android.gms.internal.ads.zzdts) r0
            r1.addAll(r0)
            com.google.android.gms.internal.ads.zzdtt.zza(r3, r4, r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzdss
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzdrd
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.ads.zzdrd r1 = (com.google.android.gms.internal.ads.zzdrd) r1
            boolean r2 = r1.zzaxi()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.ads.zzdrd r0 = r1.zzfl(r0)
            com.google.android.gms.internal.ads.zzdtt.zza(r3, r4, r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrs.zza(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzdtt.zza(obj, j, (Object) zzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzdtt.zzp(obj, j);
    }
}
