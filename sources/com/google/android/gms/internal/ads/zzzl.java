package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.consent.ConsentSdkUtil.ConsentInformationCallback;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzzl {
    @GuardedBy("InternalConsentSdkUtil.class")
    private static zzzl zzcty;
    private final zzzg zzctz;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|(2:6|7)|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.google.android.gms.internal.ads.zzzl zzj(android.content.Context r3) {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzzl> r0 = com.google.android.gms.internal.ads.zzzl.class
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzzl r1 = zzcty     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0030
            java.lang.String r1 = "com.google.android.gms.ads.consent.DynamiteConsentUtil"
            com.google.android.gms.internal.ads.zzaxk r2 = com.google.android.gms.internal.ads.zzzk.zzbty     // Catch:{ zzaxj -> 0x0012 }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzaxh.zza(r3, r1, r2)     // Catch:{ zzaxj -> 0x0012 }
            com.google.android.gms.internal.ads.zzzg r1 = (com.google.android.gms.internal.ads.zzzg) r1     // Catch:{ zzaxj -> 0x0012 }
            goto L_0x001e
        L_0x0012:
            r1 = move-exception
            java.lang.String r2 = "Loading exception"
            com.google.android.gms.internal.ads.zzaxi.zzb(r2, r1)     // Catch:{ all -> 0x0034 }
            com.google.android.gms.internal.ads.zzzp r1 = new com.google.android.gms.internal.ads.zzzp     // Catch:{ all -> 0x0034 }
            r2 = 0
            r1.<init>()     // Catch:{ all -> 0x0034 }
        L_0x001e:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ RemoteException -> 0x0029 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ RemoteException -> 0x0029 }
            r1.zzr(r3)     // Catch:{ RemoteException -> 0x0029 }
        L_0x0029:
            com.google.android.gms.internal.ads.zzzl r3 = new com.google.android.gms.internal.ads.zzzl     // Catch:{ all -> 0x0034 }
            r3.<init>(r1)     // Catch:{ all -> 0x0034 }
            zzcty = r3     // Catch:{ all -> 0x0034 }
        L_0x0030:
            com.google.android.gms.internal.ads.zzzl r3 = zzcty     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)
            return r3
        L_0x0034:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzl.zzj(android.content.Context):com.google.android.gms.internal.ads.zzzl");
    }

    private zzzl(zzzg zzzg) {
        this.zzctz = zzzg;
    }

    public final void zza(Map<String, String> map, ConsentInformationCallback consentInformationCallback) {
        Bundle bundle = new Bundle();
        for (Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        zzzm zzzm = new zzzm(consentInformationCallback);
        try {
            this.zzctz.zza(bundle, zzzm);
        } catch (RemoteException e) {
            zzaxi.zzb("Remote exception: ", e);
            zzzm.onFailure(3);
        }
    }
}
