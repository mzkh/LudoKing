package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavy {
    private static zzu zzdui;
    private static final Object zzduj = new Object();
    @Deprecated
    private static final zzawc<Void> zzduk = new zzavx();

    public zzavy(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        zzbh(context);
    }

    public static zzddi<zzo> zzel(String str) {
        zzaxv zzaxv = new zzaxv();
        zzdui.zze(new zzawe(str, zzaxv));
        return zzaxv;
    }

    public final zzddi<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        String str2 = str;
        zzawb zzawb = new zzawb(null);
        zzawa zzawa = new zzawa(this, str2, zzawb);
        zzaxc zzaxc = new zzaxc(null);
        zzavz zzavz = new zzavz(this, i, str, zzawb, zzawa, bArr, map, zzaxc);
        if (zzaxc.isEnabled()) {
            try {
                zzaxc.zza(str2, "GET", zzavz.getHeaders(), zzavz.zzf());
            } catch (zzb e) {
                zzaug.zzeu(e.getMessage());
            }
        }
        zzdui.zze(zzavz);
        return zzawb;
    }

    public final zzddi<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzu zzbh(android.content.Context r4) {
        /*
            java.lang.Object r0 = zzduj
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzu r1 = zzdui     // Catch:{ all -> 0x0054 }
            if (r1 != 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzza.initialize(r4)     // Catch:{ all -> 0x0054 }
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ all -> 0x0054 }
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzza.zzcpv     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzyw r2 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x0054 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0054 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0054 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzu r4 = com.google.android.gms.internal.ads.zzavn.zzbg(r4)     // Catch:{ all -> 0x0054 }
            goto L_0x004e
        L_0x002c:
            com.google.android.gms.internal.ads.zzak r1 = new com.google.android.gms.internal.ads.zzak     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzar r2 = new com.google.android.gms.internal.ads.zzar     // Catch:{ all -> 0x0054 }
            r2.<init>()     // Catch:{ all -> 0x0054 }
            r1.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.io.File r4 = r4.getCacheDir()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = "volley"
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzu r4 = new com.google.android.gms.internal.ads.zzu     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzal r3 = new com.google.android.gms.internal.ads.zzal     // Catch:{ all -> 0x0054 }
            r3.<init>(r2)     // Catch:{ all -> 0x0054 }
            r4.<init>(r3, r1)     // Catch:{ all -> 0x0054 }
            r4.start()     // Catch:{ all -> 0x0054 }
        L_0x004e:
            zzdui = r4     // Catch:{ all -> 0x0054 }
        L_0x0050:
            com.google.android.gms.internal.ads.zzu r4 = zzdui     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return r4
        L_0x0054:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavy.zzbh(android.content.Context):com.google.android.gms.internal.ads.zzu");
    }
}
