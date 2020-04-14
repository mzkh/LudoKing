package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzbax implements Releasable {
    protected Context mContext;
    protected String zzdvd;
    protected WeakReference<zzazj> zzedf;

    public zzbax(zzazj zzazj) {
        this.mContext = zzazj.getContext();
        this.zzdvd = zzq.zzkj().zzr(this.mContext, zzazj.zzxr().zzblz);
        this.zzedf = new WeakReference<>(zzazj);
    }

    public abstract void abort();

    public void release() {
    }

    /* access modifiers changed from: protected */
    public void zzcs(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzct(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzcu(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzcv(int i) {
    }

    public abstract boolean zzfd(String str);

    public boolean zze(String str, String[] strArr) {
        return zzfd(str);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        Handler handler = zzawy.zzzb;
        zzbaz zzbaz = new zzbaz(this, str, str2, j, j2, z, i, i2);
        handler.post(zzbaz);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        Handler handler = zzawy.zzzb;
        zzbbc zzbbc = new zzbbc(this, str, str2, i, i2, j, j2, z, i3, i4);
        handler.post(zzbbc);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzawy.zzzb.post(new zzbbb(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zzb(String str, String str2, long j) {
        Handler handler = zzawy.zzzb;
        zzbbe zzbbe = new zzbbe(this, str, str2, j);
        handler.post(zzbbe);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        Handler handler = zzawy.zzzb;
        zzbbd zzbbd = new zzbbd(this, str, str2, str3, str4);
        handler.post(zzbbd);
    }

    /* access modifiers changed from: protected */
    public String zzfe(String str) {
        zzuv.zzoj();
        return zzawy.zzen(str);
    }

    /* access modifiers changed from: private */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zzff(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1947652542: goto L_0x007d;
                case -1396664534: goto L_0x0072;
                case -1347010958: goto L_0x0068;
                case -918817863: goto L_0x005d;
                case -659376217: goto L_0x0053;
                case -642208130: goto L_0x0049;
                case -354048396: goto L_0x003e;
                case -32082395: goto L_0x0033;
                case 3387234: goto L_0x0029;
                case 96784904: goto L_0x001f;
                case 580119100: goto L_0x0014;
                case 725497484: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0087
        L_0x0009:
            java.lang.String r0 = "noCacheDir"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 7
            goto L_0x0088
        L_0x0014:
            java.lang.String r0 = "expireFailed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 6
            goto L_0x0088
        L_0x001f:
            java.lang.String r0 = "error"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 1
            goto L_0x0088
        L_0x0029:
            java.lang.String r0 = "noop"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 4
            goto L_0x0088
        L_0x0033:
            java.lang.String r0 = "externalAbort"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 10
            goto L_0x0088
        L_0x003e:
            java.lang.String r0 = "sizeExceeded"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 11
            goto L_0x0088
        L_0x0049:
            java.lang.String r0 = "playerFailed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 5
            goto L_0x0088
        L_0x0053:
            java.lang.String r0 = "contentLengthMissing"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 0
            goto L_0x0088
        L_0x005d:
            java.lang.String r0 = "downloadTimeout"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 9
            goto L_0x0088
        L_0x0068:
            java.lang.String r0 = "inProgress"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 2
            goto L_0x0088
        L_0x0072:
            java.lang.String r0 = "badUrl"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 8
            goto L_0x0088
        L_0x007d:
            java.lang.String r0 = "interrupted"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 3
            goto L_0x0088
        L_0x0087:
            r1 = -1
        L_0x0088:
            java.lang.String r0 = "internal"
            switch(r1) {
                case 0: goto L_0x0096;
                case 1: goto L_0x0096;
                case 2: goto L_0x0096;
                case 3: goto L_0x0096;
                case 4: goto L_0x0096;
                case 5: goto L_0x0096;
                case 6: goto L_0x0094;
                case 7: goto L_0x0094;
                case 8: goto L_0x0091;
                case 9: goto L_0x0091;
                case 10: goto L_0x008e;
                case 11: goto L_0x008e;
                default: goto L_0x008d;
            }
        L_0x008d:
            goto L_0x0096
        L_0x008e:
            java.lang.String r0 = "policy"
            goto L_0x0096
        L_0x0091:
            java.lang.String r0 = "network"
            goto L_0x0096
        L_0x0094:
            java.lang.String r0 = "io"
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbax.zzff(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzazj zzazj = (zzazj) this.zzedf.get();
        if (zzazj != null) {
            zzazj.zza(str, map);
        }
    }
}
