package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzamz extends zzanj {
    private static final Set<String> zzdfp = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzani zzcxz;
    private final zzbbw zzczi;
    private final Activity zzdff;
    private String zzdfq = "top-right";
    private boolean zzdfr = true;
    private int zzdfs = 0;
    private int zzdft = 0;
    private int zzdfu = 0;
    private int zzdfv = 0;
    private zzbdj zzdfw;
    private ImageView zzdfx;
    private LinearLayout zzdfy;
    private PopupWindow zzdfz;
    private RelativeLayout zzdga;
    private ViewGroup zzdgb;

    public zzamz(zzbbw zzbbw, zzani zzani) {
        super(zzbbw, "resize");
        this.zzczi = zzbbw;
        this.zzdff = zzbbw.zzxn();
        this.zzcxz = zzani;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a8, code lost:
        if (r5 == 5) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01aa, code lost:
        r5 = ((r1.zzdfs + r1.zzdfu) + r1.width) - 50;
        r8 = r1.zzdft;
        r15 = r1.zzdfv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b8, code lost:
        r5 = ((r1.zzdfs + r1.zzdfu) + r1.width) - 50;
        r8 = r1.zzdft + r1.zzdfv;
        r15 = r1.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c9, code lost:
        r5 = ((r1.zzdfs + r1.zzdfu) + (r1.width / 2)) - 25;
        r8 = r1.zzdft + r1.zzdfv;
        r15 = r1.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01dc, code lost:
        r5 = r1.zzdfs + r1.zzdfu;
        r8 = r1.zzdft + r1.zzdfv;
        r15 = r1.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e8, code lost:
        r8 = (r8 + r15) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01eb, code lost:
        r5 = ((r1.zzdfs + r1.zzdfu) + (r1.width / 2)) - 25;
        r8 = ((r1.zzdft + r1.zzdfv) + (r1.height / 2)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0202, code lost:
        r5 = ((r1.zzdfs + r1.zzdfu) + (r1.width / 2)) - 25;
        r8 = r1.zzdft;
        r15 = r1.zzdfv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0212, code lost:
        r5 = r1.zzdfs + r1.zzdfu;
        r8 = r1.zzdft;
        r15 = r1.zzdfv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x021b, code lost:
        r8 = r8 + r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x021c, code lost:
        if (r5 < 0) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x021f, code lost:
        if ((r5 + 50) > r7) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0223, code lost:
        if (r8 < r6[0]) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0228, code lost:
        if ((r8 + 50) <= r6[1]) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x019d, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019e, code lost:
        if (r5 == 0) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a0, code lost:
        if (r5 == 1) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a2, code lost:
        if (r5 == 2) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (r5 == 3) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a6, code lost:
        if (r5 == 4) goto L_0x01c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x023b A[Catch:{ RuntimeException -> 0x046d }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x023d A[Catch:{ RuntimeException -> 0x046d }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x029d A[Catch:{ RuntimeException -> 0x046d }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02a4 A[Catch:{ RuntimeException -> 0x046d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbbw r3 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbdj r3 = r3.zzzn()     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbbw r3 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbdj r3 = r3.zzzn()     // Catch:{ all -> 0x04c3 }
            boolean r3 = r3.zzaau()     // Catch:{ all -> 0x04c3 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbbw r3 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            boolean r3 = r3.zzzu()     // Catch:{ all -> 0x04c3 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04c3 }
            int r3 = com.google.android.gms.internal.ads.zzaul.zzed(r3)     // Catch:{ all -> 0x04c3 }
            r1.width = r3     // Catch:{ all -> 0x04c3 }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04c3 }
            int r3 = com.google.android.gms.internal.ads.zzaul.zzed(r3)     // Catch:{ all -> 0x04c3 }
            r1.height = r3     // Catch:{ all -> 0x04c3 }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04c3 }
            int r3 = com.google.android.gms.internal.ads.zzaul.zzed(r3)     // Catch:{ all -> 0x04c3 }
            r1.zzdfu = r3     // Catch:{ all -> 0x04c3 }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04c3 }
            int r3 = com.google.android.gms.internal.ads.zzaul.zzed(r3)     // Catch:{ all -> 0x04c3 }
            r1.zzdfv = r3     // Catch:{ all -> 0x04c3 }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04c3 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04c3 }
            r1.zzdfr = r3     // Catch:{ all -> 0x04c3 }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04c3 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04c3 }
            if (r3 != 0) goto L_0x00eb
            r1.zzdfq = r0     // Catch:{ all -> 0x04c3 }
        L_0x00eb:
            int r0 = r1.width     // Catch:{ all -> 0x04c3 }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.height     // Catch:{ all -> 0x04c3 }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x0101:
            android.app.Activity r0 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04c3 }
            if (r0 == 0) goto L_0x04bc
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04c3 }
            if (r5 != 0) goto L_0x0111
            goto L_0x04bc
        L_0x0111:
            com.google.android.gms.internal.ads.zzaul r5 = com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r6 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int[] r5 = r5.zze(r6)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzaul r6 = com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r7 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04c3 }
            r7 = r5[r4]     // Catch:{ all -> 0x04c3 }
            r5 = r5[r3]     // Catch:{ all -> 0x04c3 }
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0233
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            if (r8 <= r7) goto L_0x013a
            goto L_0x0233
        L_0x013a:
            int r8 = r1.height     // Catch:{ all -> 0x04c3 }
            if (r8 < r14) goto L_0x022d
            int r8 = r1.height     // Catch:{ all -> 0x04c3 }
            if (r8 <= r5) goto L_0x0144
            goto L_0x022d
        L_0x0144:
            int r8 = r1.height     // Catch:{ all -> 0x04c3 }
            if (r8 != r5) goto L_0x0153
            int r5 = r1.width     // Catch:{ all -> 0x04c3 }
            if (r5 != r7) goto L_0x0153
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.ads.zzaug.zzeu(r5)     // Catch:{ all -> 0x04c3 }
            goto L_0x0238
        L_0x0153:
            boolean r5 = r1.zzdfr     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x022b
            java.lang.String r5 = r1.zzdfq     // Catch:{ all -> 0x04c3 }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04c3 }
            switch(r8) {
                case -1364013995: goto L_0x0193;
                case -1012429441: goto L_0x0189;
                case -655373719: goto L_0x017f;
                case 1163912186: goto L_0x0175;
                case 1288627767: goto L_0x016b;
                case 1755462605: goto L_0x0161;
                default: goto L_0x0160;
            }     // Catch:{ all -> 0x04c3 }
        L_0x0160:
            goto L_0x019d
        L_0x0161:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x019d
            r5 = 1
            goto L_0x019e
        L_0x016b:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x019d
            r5 = 4
            goto L_0x019e
        L_0x0175:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x019d
            r5 = 5
            goto L_0x019e
        L_0x017f:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x019d
            r5 = 3
            goto L_0x019e
        L_0x0189:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x019d
            r5 = 0
            goto L_0x019e
        L_0x0193:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x019d
            r5 = 2
            goto L_0x019e
        L_0x019d:
            r5 = -1
        L_0x019e:
            if (r5 == 0) goto L_0x0212
            if (r5 == r3) goto L_0x0202
            if (r5 == r13) goto L_0x01eb
            if (r5 == r11) goto L_0x01dc
            if (r5 == r10) goto L_0x01c9
            if (r5 == r9) goto L_0x01b8
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            goto L_0x021b
        L_0x01b8:
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04c3 }
            goto L_0x01e8
        L_0x01c9:
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04c3 }
            goto L_0x01e8
        L_0x01dc:
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04c3 }
        L_0x01e8:
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x021c
        L_0x01eb:
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04c3 }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x021c
        L_0x0202:
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04c3 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            goto L_0x021b
        L_0x0212:
            int r5 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r5 = r5 + r8
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
        L_0x021b:
            int r8 = r8 + r15
        L_0x021c:
            if (r5 < 0) goto L_0x0238
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x0238
            r5 = r6[r4]     // Catch:{ all -> 0x04c3 }
            if (r8 < r5) goto L_0x0238
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04c3 }
            if (r8 <= r5) goto L_0x022b
            goto L_0x0238
        L_0x022b:
            r5 = 1
            goto L_0x0239
        L_0x022d:
            java.lang.String r5 = "Height is too small or too large."
            com.google.android.gms.internal.ads.zzaug.zzeu(r5)     // Catch:{ all -> 0x04c3 }
            goto L_0x0238
        L_0x0233:
            java.lang.String r5 = "Width is too small or too large."
            com.google.android.gms.internal.ads.zzaug.zzeu(r5)     // Catch:{ all -> 0x04c3 }
        L_0x0238:
            r5 = 0
        L_0x0239:
            if (r5 != 0) goto L_0x023d
            r5 = 0
            goto L_0x029b
        L_0x023d:
            boolean r5 = r1.zzdfr     // Catch:{ all -> 0x04c3 }
            if (r5 == 0) goto L_0x0252
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04c3 }
            int r6 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r7 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04c3 }
            int r6 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r7 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04c3 }
            goto L_0x029b
        L_0x0252:
            com.google.android.gms.internal.ads.zzaul r5 = com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r6 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int[] r5 = r5.zze(r6)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzaul r6 = com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r7 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04c3 }
            r5 = r5[r4]     // Catch:{ all -> 0x04c3 }
            int r7 = r1.zzdfs     // Catch:{ all -> 0x04c3 }
            int r8 = r1.zzdfu     // Catch:{ all -> 0x04c3 }
            int r7 = r7 + r8
            int r8 = r1.zzdft     // Catch:{ all -> 0x04c3 }
            int r15 = r1.zzdfv     // Catch:{ all -> 0x04c3 }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x0276
            r5 = 0
            goto L_0x0280
        L_0x0276:
            int r15 = r1.width     // Catch:{ all -> 0x04c3 }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x027f
            int r7 = r1.width     // Catch:{ all -> 0x04c3 }
            int r5 = r5 - r7
            goto L_0x0280
        L_0x027f:
            r5 = r7
        L_0x0280:
            r7 = r6[r4]     // Catch:{ all -> 0x04c3 }
            if (r8 >= r7) goto L_0x0287
            r8 = r6[r4]     // Catch:{ all -> 0x04c3 }
            goto L_0x0294
        L_0x0287:
            int r7 = r1.height     // Catch:{ all -> 0x04c3 }
            int r7 = r7 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x04c3 }
            if (r7 <= r15) goto L_0x0294
            r6 = r6[r3]     // Catch:{ all -> 0x04c3 }
            int r7 = r1.height     // Catch:{ all -> 0x04c3 }
            int r8 = r6 - r7
        L_0x0294:
            int[] r6 = new int[r13]     // Catch:{ all -> 0x04c3 }
            r6[r4] = r5     // Catch:{ all -> 0x04c3 }
            r6[r3] = r8     // Catch:{ all -> 0x04c3 }
            r5 = r6
        L_0x029b:
            if (r5 != 0) goto L_0x02a4
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x02a4:
            com.google.android.gms.internal.ads.zzuv.zzoj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r6 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int r7 = r1.width     // Catch:{ all -> 0x04c3 }
            int r6 = com.google.android.gms.internal.ads.zzawy.zza(r6, r7)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzuv.zzoj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r7 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int r8 = r1.height     // Catch:{ all -> 0x04c3 }
            int r7 = com.google.android.gms.internal.ads.zzawy.zza(r7, r8)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r8 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04c3 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04c3 }
            if (r8 == 0) goto L_0x04b5
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04c3 }
            if (r15 == 0) goto L_0x04b5
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r9 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04c3 }
            r15.removeView(r9)     // Catch:{ all -> 0x04c3 }
            android.widget.PopupWindow r9 = r1.zzdfz     // Catch:{ all -> 0x04c3 }
            if (r9 != 0) goto L_0x0309
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04c3 }
            r1.zzdgb = r8     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r8 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04c3 }
            android.graphics.Bitmap r8 = com.google.android.gms.internal.ads.zzaul.zzk(r8)     // Catch:{ all -> 0x04c3 }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04c3 }
            android.app.Activity r15 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            r9.<init>(r15)     // Catch:{ all -> 0x04c3 }
            r1.zzdfx = r9     // Catch:{ all -> 0x04c3 }
            android.widget.ImageView r9 = r1.zzdfx     // Catch:{ all -> 0x04c3 }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r8 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbdj r8 = r8.zzzn()     // Catch:{ all -> 0x04c3 }
            r1.zzdfw = r8     // Catch:{ all -> 0x04c3 }
            android.view.ViewGroup r8 = r1.zzdgb     // Catch:{ all -> 0x04c3 }
            android.widget.ImageView r9 = r1.zzdfx     // Catch:{ all -> 0x04c3 }
            r8.addView(r9)     // Catch:{ all -> 0x04c3 }
            goto L_0x030e
        L_0x0309:
            android.widget.PopupWindow r8 = r1.zzdfz     // Catch:{ all -> 0x04c3 }
            r8.dismiss()     // Catch:{ all -> 0x04c3 }
        L_0x030e:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04c3 }
            android.app.Activity r9 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            r8.<init>(r9)     // Catch:{ all -> 0x04c3 }
            r1.zzdga = r8     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout r8 = r1.zzdga     // Catch:{ all -> 0x04c3 }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout r8 = r1.zzdga     // Catch:{ all -> 0x04c3 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04c3 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04c3 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout r8 = r1.zzdga     // Catch:{ all -> 0x04c3 }
            android.widget.PopupWindow r8 = com.google.android.gms.internal.ads.zzaul.zza(r8, r6, r7, r4)     // Catch:{ all -> 0x04c3 }
            r1.zzdfz = r8     // Catch:{ all -> 0x04c3 }
            android.widget.PopupWindow r8 = r1.zzdfz     // Catch:{ all -> 0x04c3 }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04c3 }
            android.widget.PopupWindow r8 = r1.zzdfz     // Catch:{ all -> 0x04c3 }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04c3 }
            android.widget.PopupWindow r8 = r1.zzdfz     // Catch:{ all -> 0x04c3 }
            boolean r9 = r1.zzdfr     // Catch:{ all -> 0x04c3 }
            if (r9 != 0) goto L_0x0343
            r9 = 1
            goto L_0x0344
        L_0x0343:
            r9 = 0
        L_0x0344:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout r8 = r1.zzdga     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r9 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04c3 }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04c3 }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04c3 }
            android.app.Activity r9 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            r8.<init>(r9)     // Catch:{ all -> 0x04c3 }
            r1.zzdfy = r8     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzuv.zzoj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r9 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int r9 = com.google.android.gms.internal.ads.zzawy.zza(r9, r14)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzuv.zzoj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r15 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int r14 = com.google.android.gms.internal.ads.zzawy.zza(r15, r14)     // Catch:{ all -> 0x04c3 }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04c3 }
            java.lang.String r9 = r1.zzdfq     // Catch:{ all -> 0x04c3 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04c3 }
            switch(r14) {
                case -1364013995: goto L_0x03ae;
                case -1012429441: goto L_0x03a4;
                case -655373719: goto L_0x039a;
                case 1163912186: goto L_0x0390;
                case 1288627767: goto L_0x0386;
                case 1755462605: goto L_0x037c;
                default: goto L_0x037b;
            }     // Catch:{ all -> 0x04c3 }
        L_0x037b:
            goto L_0x03b7
        L_0x037c:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x03b7
            r12 = 1
            goto L_0x03b7
        L_0x0386:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x03b7
            r12 = 4
            goto L_0x03b7
        L_0x0390:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x03b7
            r12 = 5
            goto L_0x03b7
        L_0x039a:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x03b7
            r12 = 3
            goto L_0x03b7
        L_0x03a4:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x03b7
            r12 = 0
            goto L_0x03b7
        L_0x03ae:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x03b7
            r12 = 2
        L_0x03b7:
            r9 = 9
            r14 = 10
            if (r12 == 0) goto L_0x03f7
            r15 = 14
            if (r12 == r3) goto L_0x03f0
            if (r12 == r13) goto L_0x03ea
            r13 = 12
            if (r12 == r11) goto L_0x03e3
            if (r12 == r10) goto L_0x03dc
            r9 = 11
            r10 = 5
            if (r12 == r10) goto L_0x03d5
            r8.addRule(r14)     // Catch:{ all -> 0x04c3 }
            r8.addRule(r9)     // Catch:{ all -> 0x04c3 }
            goto L_0x03fd
        L_0x03d5:
            r8.addRule(r13)     // Catch:{ all -> 0x04c3 }
            r8.addRule(r9)     // Catch:{ all -> 0x04c3 }
            goto L_0x03fd
        L_0x03dc:
            r8.addRule(r13)     // Catch:{ all -> 0x04c3 }
            r8.addRule(r15)     // Catch:{ all -> 0x04c3 }
            goto L_0x03fd
        L_0x03e3:
            r8.addRule(r13)     // Catch:{ all -> 0x04c3 }
            r8.addRule(r9)     // Catch:{ all -> 0x04c3 }
            goto L_0x03fd
        L_0x03ea:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04c3 }
            goto L_0x03fd
        L_0x03f0:
            r8.addRule(r14)     // Catch:{ all -> 0x04c3 }
            r8.addRule(r15)     // Catch:{ all -> 0x04c3 }
            goto L_0x03fd
        L_0x03f7:
            r8.addRule(r14)     // Catch:{ all -> 0x04c3 }
            r8.addRule(r9)     // Catch:{ all -> 0x04c3 }
        L_0x03fd:
            android.widget.LinearLayout r9 = r1.zzdfy     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzamy r10 = new com.google.android.gms.internal.ads.zzamy     // Catch:{ all -> 0x04c3 }
            r10.<init>(r1)     // Catch:{ all -> 0x04c3 }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04c3 }
            android.widget.LinearLayout r9 = r1.zzdfy     // Catch:{ all -> 0x04c3 }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout r9 = r1.zzdga     // Catch:{ all -> 0x04c3 }
            android.widget.LinearLayout r10 = r1.zzdfy     // Catch:{ all -> 0x04c3 }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04c3 }
            android.widget.PopupWindow r8 = r1.zzdfz     // Catch:{ RuntimeException -> 0x046d }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x046d }
            com.google.android.gms.internal.ads.zzuv.zzoj()     // Catch:{ RuntimeException -> 0x046d }
            android.app.Activity r9 = r1.zzdff     // Catch:{ RuntimeException -> 0x046d }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x046d }
            int r9 = com.google.android.gms.internal.ads.zzawy.zza(r9, r10)     // Catch:{ RuntimeException -> 0x046d }
            com.google.android.gms.internal.ads.zzuv.zzoj()     // Catch:{ RuntimeException -> 0x046d }
            android.app.Activity r10 = r1.zzdff     // Catch:{ RuntimeException -> 0x046d }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x046d }
            int r10 = com.google.android.gms.internal.ads.zzawy.zza(r10, r11)     // Catch:{ RuntimeException -> 0x046d }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x046d }
            r0 = r5[r4]     // Catch:{ all -> 0x04c3 }
            r8 = r5[r3]     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzani r9 = r1.zzcxz     // Catch:{ all -> 0x04c3 }
            if (r9 == 0) goto L_0x0445
            com.google.android.gms.internal.ads.zzani r9 = r1.zzcxz     // Catch:{ all -> 0x04c3 }
            int r10 = r1.width     // Catch:{ all -> 0x04c3 }
            int r11 = r1.height     // Catch:{ all -> 0x04c3 }
            r9.zza(r0, r8, r10, r11)     // Catch:{ all -> 0x04c3 }
        L_0x0445:
            com.google.android.gms.internal.ads.zzbbw r0 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbdj r6 = com.google.android.gms.internal.ads.zzbdj.zzp(r6, r7)     // Catch:{ all -> 0x04c3 }
            r0.zza(r6)     // Catch:{ all -> 0x04c3 }
            r0 = r5[r4]     // Catch:{ all -> 0x04c3 }
            r3 = r5[r3]     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzaul r5 = com.google.android.gms.ads.internal.zzq.zzkj()     // Catch:{ all -> 0x04c3 }
            android.app.Activity r6 = r1.zzdff     // Catch:{ all -> 0x04c3 }
            int[] r5 = r5.zzf(r6)     // Catch:{ all -> 0x04c3 }
            r4 = r5[r4]     // Catch:{ all -> 0x04c3 }
            int r3 = r3 - r4
            int r4 = r1.width     // Catch:{ all -> 0x04c3 }
            int r5 = r1.height     // Catch:{ all -> 0x04c3 }
            r1.zzb(r0, r3, r4, r5)     // Catch:{ all -> 0x04c3 }
            java.lang.String r0 = "resized"
            r1.zzdp(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x046d:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x04c3 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04c3 }
            int r4 = r0.length()     // Catch:{ all -> 0x04c3 }
            if (r4 == 0) goto L_0x0483
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x04c3 }
            goto L_0x0488
        L_0x0483:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x04c3 }
            r0.<init>(r3)     // Catch:{ all -> 0x04c3 }
        L_0x0488:
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            android.widget.RelativeLayout r0 = r1.zzdga     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r3 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04c3 }
            r0.removeView(r3)     // Catch:{ all -> 0x04c3 }
            android.view.ViewGroup r0 = r1.zzdgb     // Catch:{ all -> 0x04c3 }
            if (r0 == 0) goto L_0x04b3
            android.view.ViewGroup r0 = r1.zzdgb     // Catch:{ all -> 0x04c3 }
            android.widget.ImageView r3 = r1.zzdfx     // Catch:{ all -> 0x04c3 }
            r0.removeView(r3)     // Catch:{ all -> 0x04c3 }
            android.view.ViewGroup r0 = r1.zzdgb     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r3 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04c3 }
            r0.addView(r3)     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbbw r0 = r1.zzczi     // Catch:{ all -> 0x04c3 }
            com.google.android.gms.internal.ads.zzbdj r3 = r1.zzdfw     // Catch:{ all -> 0x04c3 }
            r0.zza(r3)     // Catch:{ all -> 0x04c3 }
        L_0x04b3:
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x04b5:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x04bc:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdn(r0)     // Catch:{ all -> 0x04c3 }
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            return
        L_0x04c3:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04c3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamz.zzg(java.util.Map):void");
    }

    public final void zzv(boolean z) {
        synchronized (this.lock) {
            if (this.zzdfz != null) {
                this.zzdfz.dismiss();
                this.zzdga.removeView(this.zzczi.getView());
                if (this.zzdgb != null) {
                    this.zzdgb.removeView(this.zzdfx);
                    this.zzdgb.addView(this.zzczi.getView());
                    this.zzczi.zza(this.zzdfw);
                }
                if (z) {
                    zzdp("default");
                    if (this.zzcxz != null) {
                        this.zzcxz.zzsl();
                    }
                }
                this.zzdfz = null;
                this.zzdga = null;
                this.zzdgb = null;
                this.zzdfy = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdfs = i;
            this.zzdft = i2;
            PopupWindow popupWindow = this.zzdfz;
        }
    }

    public final boolean zzsk() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdfz != null;
        }
        return z;
    }

    public final void zzh(int i, int i2) {
        this.zzdfs = i;
        this.zzdft = i2;
    }
}
