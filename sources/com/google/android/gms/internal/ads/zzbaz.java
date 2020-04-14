package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbaz implements Runnable {
    private final /* synthetic */ String zzduo;
    private final /* synthetic */ String zzedh;
    private final /* synthetic */ long zzedi;
    private final /* synthetic */ long zzedj;
    private final /* synthetic */ boolean zzedk;
    private final /* synthetic */ int zzedl;
    private final /* synthetic */ int zzedm;
    private final /* synthetic */ zzbax zzedn;

    zzbaz(zzbax zzbax, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.zzedn = zzbax;
        this.zzduo = str;
        this.zzedh = str2;
        this.zzedi = j;
        this.zzedj = j2;
        this.zzedk = z;
        this.zzedl = i;
        this.zzedm = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzduo);
        hashMap.put("cachedSrc", this.zzedh);
        hashMap.put("bufferedDuration", Long.toString(this.zzedi));
        hashMap.put("totalDuration", Long.toString(this.zzedj));
        hashMap.put("cacheReady", this.zzedk ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("playerCount", Integer.toString(this.zzedl));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzedm));
        this.zzedn.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
