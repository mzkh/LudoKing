package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzou {
    private final zzot zzbiu;
    private final boolean zzbiv;
    private final long zzbiw;
    private final long zzbix;
    private long zzbiy;
    private long zzbiz;
    private long zzbja;
    private boolean zzbjb;
    private long zzbjc;
    private long zzbjd;
    private long zzbje;

    public zzou() {
        this(-1.0d);
    }

    public zzou(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this(windowManager.getDefaultDisplay() != null ? (double) windowManager.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private zzou(double d) {
        this.zzbiv = d != -1.0d;
        if (this.zzbiv) {
            this.zzbiu = zzot.zzja();
            this.zzbiw = (long) (1.0E9d / d);
            this.zzbix = (this.zzbiw * 80) / 100;
            return;
        }
        this.zzbiu = null;
        this.zzbiw = -1;
        this.zzbix = -1;
    }

    public final void enable() {
        this.zzbjb = false;
        if (this.zzbiv) {
            this.zzbiu.zzjb();
        }
    }

    public final void disable() {
        if (this.zzbiv) {
            this.zzbiu.zzjc();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.zzbjb
            if (r2 == 0) goto L_0x0042
            long r2 = r11.zzbiy
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r11.zzbje
            r4 = 1
            long r2 = r2 + r4
            r11.zzbje = r2
            long r2 = r11.zzbja
            r11.zzbiz = r2
        L_0x0019:
            long r2 = r11.zzbje
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r11.zzbjd
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.zzbiz
            long r2 = r2 + r4
            boolean r4 = r11.zzg(r2, r14)
            if (r4 == 0) goto L_0x0033
            r11.zzbjb = r6
            goto L_0x0042
        L_0x0033:
            long r4 = r11.zzbjc
            long r4 = r4 + r2
            long r6 = r11.zzbjd
            long r4 = r4 - r6
            goto L_0x0044
        L_0x003a:
            boolean r2 = r11.zzg(r0, r14)
            if (r2 == 0) goto L_0x0042
            r11.zzbjb = r6
        L_0x0042:
            r4 = r14
            r2 = r0
        L_0x0044:
            boolean r6 = r11.zzbjb
            r7 = 0
            if (r6 != 0) goto L_0x0053
            r11.zzbjd = r0
            r11.zzbjc = r14
            r11.zzbje = r7
            r14 = 1
            r11.zzbjb = r14
        L_0x0053:
            r11.zzbiy = r12
            r11.zzbja = r2
            com.google.android.gms.internal.ads.zzot r12 = r11.zzbiu
            if (r12 == 0) goto L_0x0086
            long r12 = r12.zzbip
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L_0x0062
            goto L_0x0086
        L_0x0062:
            com.google.android.gms.internal.ads.zzot r12 = r11.zzbiu
            long r12 = r12.zzbip
            long r14 = r11.zzbiw
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            long r14 = r12 - r14
            goto L_0x0079
        L_0x0075:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L_0x0079:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r12 = r14
        L_0x0082:
            long r14 = r11.zzbix
            long r12 = r12 - r14
            return r12
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzou.zzf(long, long):long");
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbjc) - (j - this.zzbjd)) > 20000000;
    }
}
