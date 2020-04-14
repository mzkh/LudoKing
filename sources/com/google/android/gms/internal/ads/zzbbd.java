package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbd implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzduo;
    private final /* synthetic */ String zzedh;
    private final /* synthetic */ zzbax zzedn;
    private final /* synthetic */ String zzedq;

    zzbbd(zzbax zzbax, String str, String str2, String str3, String str4) {
        this.zzedn = zzbax;
        this.zzduo = str;
        this.zzedh = str2;
        this.zzedq = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.zzduo);
        if (!TextUtils.isEmpty(this.zzedh)) {
            hashMap.put("cachedSrc", this.zzedh);
        }
        hashMap.put("type", zzbax.zzff(this.zzedq));
        hashMap.put("reason", this.zzedq);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzedn.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
