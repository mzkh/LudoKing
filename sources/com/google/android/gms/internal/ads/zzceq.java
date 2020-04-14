package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzceq implements Callable {
    private final zzddi zzfoe;
    private final zzddi zzfov;

    zzceq(zzddi zzddi, zzddi zzddi2) {
        this.zzfov = zzddi;
        this.zzfoe = zzddi2;
    }

    public final Object call() {
        return new zzcfa((JSONObject) this.zzfov.get(), (zzapk) this.zzfoe.get());
    }
}
