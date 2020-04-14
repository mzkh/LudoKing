package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbba implements Runnable {
    private final /* synthetic */ String zzduo;
    private final /* synthetic */ String zzedh;
    private final /* synthetic */ boolean zzedk = false;
    private final /* synthetic */ zzbax zzedn;
    private final /* synthetic */ int zzedo;
    private final /* synthetic */ int zzedp;

    zzbba(zzbax zzbax, String str, String str2, int i, int i2, boolean z) {
        this.zzedn = zzbax;
        this.zzduo = str;
        this.zzedh = str2;
        this.zzedo = i;
        this.zzedp = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzduo);
        hashMap.put("cachedSrc", this.zzedh);
        hashMap.put("bytesLoaded", Integer.toString(this.zzedo));
        hashMap.put("totalBytes", Integer.toString(this.zzedp));
        hashMap.put("cacheReady", this.zzedk ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zzedn.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
