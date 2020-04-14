package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzem extends zzfl {
    private static final zzfk<zzcf> zzzt = new zzfk<>();
    private final Context zzzu;
    private zza zzzv = null;

    public zzem(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2, Context context, zza zza) {
        super(zzdx, str, str2, zzb, i, 27);
        this.zzzu = context;
        this.zzzv = zza;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcu() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzfk<com.google.android.gms.internal.ads.zzcf> r0 = zzzt
            android.content.Context r1 = r8.zzzu
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzau(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcf r1 = (com.google.android.gms.internal.ads.zzcf) r1     // Catch:{ all -> 0x011e }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zzno     // Catch:{ all -> 0x011e }
            boolean r4 = com.google.android.gms.internal.ads.zzee.zzat(r4)     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zzno     // Catch:{ all -> 0x011e }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zzno     // Catch:{ all -> 0x011e }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00ea
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.zzzv     // Catch:{ all -> 0x011e }
            java.lang.String r1 = zza(r1)     // Catch:{ all -> 0x011e }
            boolean r1 = com.google.android.gms.internal.ads.zzee.zzat(r1)     // Catch:{ all -> 0x011e }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x011e }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.zzzv     // Catch:{ all -> 0x011e }
            java.lang.String r4 = zza(r1)     // Catch:{ all -> 0x011e }
            boolean r4 = com.google.android.gms.internal.ads.zzee.zzat(r4)     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzt()     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzbk$zzb r1 = r1.zzu()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbm r1 = r1.zzy()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbm r4 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011e }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x011e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzdx r1 = r8.zzvo     // Catch:{ all -> 0x011e }
            boolean r1 = r1.zzck()     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011e }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011e }
        L_0x0082:
            java.lang.reflect.Method r4 = r8.zzaal     // Catch:{ all -> 0x011e }
            r5 = 0
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x011e }
            android.content.Context r7 = r8.zzzu     // Catch:{ all -> 0x011e }
            r6[r2] = r7     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbm r7 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011e }
            if (r1 != r7) goto L_0x0091
            r2 = 1
        L_0x0091:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x011e }
            r6[r3] = r2     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzza.zzcnf     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzyw r7 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r7.zzd(r2)     // Catch:{ all -> 0x011e }
            r7 = 2
            r6[r7] = r2     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r4.invoke(r5, r6)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcf r4 = new com.google.android.gms.internal.ads.zzcf     // Catch:{ all -> 0x011e }
            r4.<init>(r2)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r4.zzno     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.ads.zzee.zzat(r2)     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00c1
            java.lang.String r2 = r4.zzno     // Catch:{ all -> 0x011e }
            java.lang.String r5 = "E"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00e7
        L_0x00c1:
            int[] r2 = com.google.android.gms.internal.ads.zzep.zzzx     // Catch:{ all -> 0x011e }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x011e }
            r1 = r2[r1]     // Catch:{ all -> 0x011e }
            if (r1 == r3) goto L_0x00db
            if (r1 == r7) goto L_0x00ce
            goto L_0x00e7
        L_0x00ce:
            java.lang.String r1 = r8.zzcv()     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.ads.zzee.zzat(r1)     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00e7
            r4.zzno = r1     // Catch:{ all -> 0x011e }
            goto L_0x00e7
        L_0x00db:
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.zzzv     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbk$zzc r1 = r1.zzw()     // Catch:{ all -> 0x011e }
            java.lang.String r1 = r1.zzad()     // Catch:{ all -> 0x011e }
            r4.zzno = r1     // Catch:{ all -> 0x011e }
        L_0x00e7:
            r0.set(r4)     // Catch:{ all -> 0x011e }
        L_0x00ea:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcf r1 = (com.google.android.gms.internal.ads.zzcf) r1     // Catch:{ all -> 0x011e }
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbo$zza$zzb r2 = r8.zzaaa
            monitor-enter(r2)
            if (r1 == 0) goto L_0x0119
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r8.zzaaa     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zzno     // Catch:{ all -> 0x011b }
            r0.zzab(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r8.zzaaa     // Catch:{ all -> 0x011b }
            long r3 = r1.zznp     // Catch:{ all -> 0x011b }
            r0.zzba(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r8.zzaaa     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznq     // Catch:{ all -> 0x011b }
            r0.zzad(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r8.zzaaa     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznr     // Catch:{ all -> 0x011b }
            r0.zzae(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r8.zzaaa     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.zzns     // Catch:{ all -> 0x011b }
            r0.zzaf(r1)     // Catch:{ all -> 0x011b }
        L_0x0119:
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            return
        L_0x011b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            throw r0
        L_0x011e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzem.zzcu():void");
    }

    private static String zza(zza zza) {
        if (zza == null || !zza.zzv() || zzee.zzat(zza.zzw().zzad())) {
            return null;
        }
        return zza.zzw().zzad();
    }

    private final String zzcv() {
        try {
            if (this.zzvo.zzcn() != null) {
                this.zzvo.zzcn().get();
            }
            zzbo.zza zzcm = this.zzvo.zzcm();
            if (zzcm != null && zzcm.zzah()) {
                return zzcm.zzad();
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        return null;
    }
}
