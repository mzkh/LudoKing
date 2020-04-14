package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbhn implements Runnable {
    private final zzbbw zzehv;
    private final JSONObject zzfch;

    zzbhn(zzbbw zzbbw, JSONObject jSONObject) {
        this.zzehv = zzbbw;
        this.zzfch = jSONObject;
    }

    public final void run() {
        this.zzehv.zza("AFMA_updateActiveView", this.zzfch);
    }
}
