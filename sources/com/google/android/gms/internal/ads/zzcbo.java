package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.inmobi.media.C2663v;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbo {
    private final Executor executor;
    private final String packageName;
    private final String zzcub = ((String) zzuv.zzon().zzd(zzza.zzcil));
    private final zzaxm zzduy;
    private final Map<String, String> zzfse = new HashMap();
    private final Context zzlk;

    public zzcbo(Executor executor2, zzaxm zzaxm, Context context) {
        this.executor = executor2;
        this.zzduy = zzaxm;
        this.zzlk = context;
        this.packageName = context.getPackageName();
        this.zzfse.put("s", "gmob_sdk");
        this.zzfse.put(C2663v.f5947r, ExifInterface.GPS_MEASUREMENT_3D);
        this.zzfse.put("os", VERSION.RELEASE);
        this.zzfse.put("sdk", VERSION.SDK);
        Map<String, String> map = this.zzfse;
        zzq.zzkj();
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zzaul.zzvn());
        this.zzfse.put(TapjoyConstants.TJC_APP_PLACEMENT, this.packageName);
        Map<String, String> map2 = this.zzfse;
        zzq.zzkj();
        map2.put("is_lite_sdk", zzaul.zzay(this.zzlk) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zzfse.put("e", TextUtils.join(",", zzza.zzps()));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.zzcub
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0012:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r0.appendQueryParameter(r2, r1)
            goto L_0x0012
        L_0x002e:
            android.net.Uri r4 = r0.build()
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcik
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x005d
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcmt
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r0 = 0
            goto L_0x005e
        L_0x005d:
            r0 = 1
        L_0x005e:
            if (r0 == 0) goto L_0x006a
            java.util.concurrent.Executor r0 = r3.executor
            com.google.android.gms.internal.ads.zzcbr r1 = new com.google.android.gms.internal.ads.zzcbr
            r1.<init>(r3, r4)
            r0.execute(r1)
        L_0x006a:
            com.google.android.gms.internal.ads.zzaug.zzdy(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbo.zzm(java.util.Map):void");
    }

    public final Map<String, String> zzajv() {
        return new HashMap(this.zzfse);
    }

    public final ConcurrentHashMap<String, String> zzajw() {
        return new ConcurrentHashMap<>(this.zzfse);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzfx(String str) {
        this.zzduy.zzei(str);
    }
}
