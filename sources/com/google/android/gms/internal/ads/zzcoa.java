package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoa implements zzcru<zzcnx> {
    private final zzatr zzbml;
    private final zzcwe zzfga;
    private final zzcru<zzcrx> zzgee;
    private final Context zzlk;

    public zzcoa(zzcpd<zzcrx> zzcpd, zzcwe zzcwe, Context context, zzatr zzatr) {
        this.zzgee = zzcpd;
        this.zzfga = zzcwe;
        this.zzlk = context;
        this.zzbml = zzatr;
    }

    public final zzddi<zzcnx> zzalv() {
        return zzdcy.zzb(this.zzgee.zzalv(), (zzdal<? super I, ? extends O>) new zzcnz<Object,Object>(this), (Executor) zzaxn.zzdwn);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzcnx zza(com.google.android.gms.internal.ads.zzcrx r17) {
        /*
            r16 = this;
            r0 = r16
            com.google.android.gms.internal.ads.zzcwe r1 = r0.zzfga
            com.google.android.gms.internal.ads.zzua r3 = r1.zzbll
            com.google.android.gms.internal.ads.zzua[] r1 = r3.zzccn
            r2 = 0
            if (r1 != 0) goto L_0x0012
            java.lang.String r1 = r3.zzabd
            boolean r6 = r3.zzcco
            r10 = r1
            r11 = r6
            goto L_0x0037
        L_0x0012:
            com.google.android.gms.internal.ads.zzua[] r1 = r3.zzccn
            int r6 = r1.length
            r10 = r2
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
        L_0x001a:
            if (r7 >= r6) goto L_0x0037
            r12 = r1[r7]
            boolean r13 = r12.zzcco
            if (r13 != 0) goto L_0x0028
            if (r8 != 0) goto L_0x0028
            java.lang.String r8 = r12.zzabd
            r10 = r8
            r8 = 1
        L_0x0028:
            boolean r12 = r12.zzcco
            if (r12 == 0) goto L_0x0030
            if (r9 != 0) goto L_0x0030
            r9 = 1
            r11 = 1
        L_0x0030:
            if (r8 == 0) goto L_0x0034
            if (r9 != 0) goto L_0x0037
        L_0x0034:
            int r7 = r7 + 1
            goto L_0x001a
        L_0x0037:
            android.content.Context r1 = r0.zzlk
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x005a
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            if (r1 == 0) goto L_0x005a
            float r2 = r1.density
            int r7 = r1.widthPixels
            int r1 = r1.heightPixels
            com.google.android.gms.internal.ads.zzatr r8 = r0.zzbml
            com.google.android.gms.internal.ads.zzaui r8 = r8.zzuh()
            java.lang.String r8 = r8.zzvk()
            r9 = r1
            r1 = r8
            r8 = r7
            r7 = r2
            goto L_0x005e
        L_0x005a:
            r1 = r2
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x005e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.internal.ads.zzua[] r12 = r3.zzccn
            if (r12 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzua[] r12 = r3.zzccn
            int r13 = r12.length
            r14 = 0
            r15 = 0
        L_0x006c:
            java.lang.String r4 = "|"
            if (r14 >= r13) goto L_0x00b5
            r5 = r12[r14]
            boolean r6 = r5.zzcco
            if (r6 == 0) goto L_0x0079
            r6 = 0
            r15 = 1
            goto L_0x00b2
        L_0x0079:
            int r6 = r2.length()
            if (r6 == 0) goto L_0x0082
            r2.append(r4)
        L_0x0082:
            int r4 = r5.width
            r6 = -1
            if (r4 != r6) goto L_0x0092
            r4 = 0
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0092
            int r4 = r5.widthPixels
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            goto L_0x0094
        L_0x0092:
            int r4 = r5.width
        L_0x0094:
            r2.append(r4)
            java.lang.String r4 = "x"
            r2.append(r4)
            int r4 = r5.height
            r6 = -2
            if (r4 != r6) goto L_0x00ac
            r6 = 0
            int r4 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x00ad
            int r4 = r5.heightPixels
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            goto L_0x00af
        L_0x00ac:
            r6 = 0
        L_0x00ad:
            int r4 = r5.height
        L_0x00af:
            r2.append(r4)
        L_0x00b2:
            int r14 = r14 + 1
            goto L_0x006c
        L_0x00b5:
            if (r15 == 0) goto L_0x00c8
            int r5 = r2.length()
            if (r5 == 0) goto L_0x00c2
            r5 = 0
            r2.insert(r5, r4)
            goto L_0x00c3
        L_0x00c2:
            r5 = 0
        L_0x00c3:
            java.lang.String r4 = "320x50"
            r2.insert(r5, r4)
        L_0x00c8:
            java.lang.String r6 = r2.toString()
            com.google.android.gms.internal.ads.zzcnx r12 = new com.google.android.gms.internal.ads.zzcnx
            r2 = r12
            r4 = r10
            r5 = r11
            r10 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcoa.zza(com.google.android.gms.internal.ads.zzcrx):com.google.android.gms.internal.ads.zzcnx");
    }
}
