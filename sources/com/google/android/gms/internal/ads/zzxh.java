package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzxh implements InitializationStatus {
    private final zzxc zzcez;

    zzxh(zzxc zzxc) {
        this.zzcez = zzxc;
    }

    public final Map getAdapterStatusMap() {
        zzxc zzxc = this.zzcez;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzxg(zzxc));
        return hashMap;
    }
}
