package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.inmobi.media.C2663v;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzzo {
    private String zzblz = null;
    private String zzcub;
    private Map<String, String> zzcuc;
    private Context zzlk = null;

    public zzzo(Context context, String str) {
        String str2;
        this.zzlk = context;
        this.zzblz = str;
        this.zzcub = (String) zzuv.zzon().zzd(zzza.zzcil);
        this.zzcuc = new LinkedHashMap();
        this.zzcuc.put("s", "gmob_sdk");
        this.zzcuc.put(C2663v.f5947r, ExifInterface.GPS_MEASUREMENT_3D);
        this.zzcuc.put("os", VERSION.RELEASE);
        this.zzcuc.put("sdk", VERSION.SDK);
        Map<String, String> map = this.zzcuc;
        zzq.zzkj();
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zzaul.zzvn());
        Map<String, String> map2 = this.zzcuc;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put(TapjoyConstants.TJC_APP_PLACEMENT, str2);
        Map<String, String> map3 = this.zzcuc;
        zzq.zzkj();
        map3.put("is_lite_sdk", zzaul.zzay(context) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Future zzt = zzq.zzku().zzt(this.zzlk);
        try {
            this.zzcuc.put("network_coarse", Integer.toString(((zzapj) zzt.get()).zzdms));
            this.zzcuc.put("network_fine", Integer.toString(((zzapj) zzt.get()).zzdmt));
        } catch (Exception e) {
            zzq.zzkn().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzpv() {
        return this.zzcub;
    }

    /* access modifiers changed from: 0000 */
    public final Context getContext() {
        return this.zzlk;
    }

    /* access modifiers changed from: 0000 */
    public final String zzkd() {
        return this.zzblz;
    }

    /* access modifiers changed from: 0000 */
    public final Map<String, String> zzpw() {
        return this.zzcuc;
    }
}
