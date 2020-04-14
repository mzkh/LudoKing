package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbb implements Runnable {
    private final /* synthetic */ String zzduo;
    private final /* synthetic */ String zzedh;
    private final /* synthetic */ zzbax zzedn;
    private final /* synthetic */ int zzedp;

    zzbbb(zzbax zzbax, String str, String str2, int i) {
        this.zzedn = zzbax;
        this.zzduo = str;
        this.zzedh = str2;
        this.zzedp = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzduo);
        hashMap.put("cachedSrc", this.zzedh);
        hashMap.put("totalBytes", Integer.toString(this.zzedp));
        this.zzedn.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
