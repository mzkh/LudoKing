package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tapjoy.TapjoyConstants;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaty {
    private final Object lock = new Object();
    @VisibleForTesting
    private long zzdrj = -1;
    @VisibleForTesting
    private long zzdrk = -1;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzdrl = -1;
    @VisibleForTesting
    int zzdrm = -1;
    @VisibleForTesting
    private long zzdrn = 0;
    @VisibleForTesting
    private final String zzdro;
    private final zzaui zzdrp;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzdrq = 0;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzdrr = 0;

    public zzaty(String str, zzaui zzaui) {
        this.zzdro = str;
        this.zzdrp = zzaui;
    }

    public final void zzty() {
        synchronized (this.lock) {
            this.zzdrq++;
        }
    }

    public final void zztx() {
        synchronized (this.lock) {
            this.zzdrr++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zztx r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaui r1 = r10.zzdrp     // Catch:{ all -> 0x007b }
            long r1 = r1.zzvf()     // Catch:{ all -> 0x007b }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzkq()     // Catch:{ all -> 0x007b }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x007b }
            long r5 = r10.zzdrk     // Catch:{ all -> 0x007b }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0042
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzyp<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzza.zzcko     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.ads.zzyw r6 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x007b }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x007b }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x007b }
            long r5 = r5.longValue()     // Catch:{ all -> 0x007b }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.zzdrm = r1     // Catch:{ all -> 0x007b }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.internal.ads.zzaui r1 = r10.zzdrp     // Catch:{ all -> 0x007b }
            int r1 = r1.zzvg()     // Catch:{ all -> 0x007b }
            r10.zzdrm = r1     // Catch:{ all -> 0x007b }
        L_0x003b:
            r10.zzdrk = r12     // Catch:{ all -> 0x007b }
            long r12 = r10.zzdrk     // Catch:{ all -> 0x007b }
            r10.zzdrj = r12     // Catch:{ all -> 0x007b }
            goto L_0x0044
        L_0x0042:
            r10.zzdrj = r12     // Catch:{ all -> 0x007b }
        L_0x0044:
            r12 = 1
            if (r11 == 0) goto L_0x0058
            android.os.Bundle r13 = r11.extras     // Catch:{ all -> 0x007b }
            if (r13 == 0) goto L_0x0058
            android.os.Bundle r11 = r11.extras     // Catch:{ all -> 0x007b }
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x007b }
            if (r11 != r12) goto L_0x0058
            monitor-exit(r0)     // Catch:{ all -> 0x007b }
            return
        L_0x0058:
            int r11 = r10.zzdrl     // Catch:{ all -> 0x007b }
            int r11 = r11 + r12
            r10.zzdrl = r11     // Catch:{ all -> 0x007b }
            int r11 = r10.zzdrm     // Catch:{ all -> 0x007b }
            int r11 = r11 + r12
            r10.zzdrm = r11     // Catch:{ all -> 0x007b }
            int r11 = r10.zzdrm     // Catch:{ all -> 0x007b }
            if (r11 != 0) goto L_0x0070
            r11 = 0
            r10.zzdrn = r11     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.ads.zzaui r11 = r10.zzdrp     // Catch:{ all -> 0x007b }
            r11.zzeu(r3)     // Catch:{ all -> 0x007b }
            goto L_0x0079
        L_0x0070:
            com.google.android.gms.internal.ads.zzaui r11 = r10.zzdrp     // Catch:{ all -> 0x007b }
            long r11 = r11.zzvh()     // Catch:{ all -> 0x007b }
            long r3 = r3 - r11
            r10.zzdrn = r3     // Catch:{ all -> 0x007b }
        L_0x0079:
            monitor-exit(r0)     // Catch:{ all -> 0x007b }
            return
        L_0x007b:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007b }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaty.zza(com.google.android.gms.internal.ads.zztx, long):void");
    }

    public final Bundle zzo(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString(TapjoyConstants.TJC_SESSION_ID, this.zzdro);
            bundle.putLong("basets", this.zzdrk);
            bundle.putLong("currts", this.zzdrj);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdrl);
            bundle.putInt("preqs_in_session", this.zzdrm);
            bundle.putLong("time_in_session", this.zzdrn);
            bundle.putInt("pclick", this.zzdrq);
            bundle.putInt("pimp", this.zzdrr);
            bundle.putBoolean("support_transparent_background", zzam(context));
        }
        return bundle;
    }

    private static boolean zzam(Context context) {
        Context zzaa = zzapv.zzaa(context);
        int identifier = zzaa.getResources().getIdentifier("Theme.Translucent", "style", "android");
        String str = "Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.";
        if (identifier == 0) {
            zzaug.zzet(str);
            return false;
        }
        try {
            if (identifier == zzaa.getPackageManager().getActivityInfo(new ComponentName(zzaa.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzaug.zzet(str);
            return false;
        } catch (NameNotFoundException unused) {
            zzaug.zzeu("Fail to fetch AdActivity theme");
            zzaug.zzet(str);
            return false;
        }
    }
}
