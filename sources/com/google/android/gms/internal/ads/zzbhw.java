package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbhw implements Runnable {
    private final JSONObject zzfch;
    private final zzbhx zzfcv;

    zzbhw(zzbhx zzbhx, JSONObject jSONObject) {
        this.zzfcv = zzbhx;
        this.zzfch = jSONObject;
    }

    public final void run() {
        this.zzfcv.zzh(this.zzfch);
    }
}
