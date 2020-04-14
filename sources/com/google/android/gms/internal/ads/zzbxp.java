package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbxp implements zzpj {
    private final zzbbw zzehv;

    zzbxp(zzbbw zzbbw) {
        this.zzehv = zzbbw;
    }

    public final void zza(zzpk zzpk) {
        zzbbw zzbbw = this.zzehv;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzpk.zzbnp ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzbbw.zza("onAdVisibilityChanged", hashMap);
    }
}
