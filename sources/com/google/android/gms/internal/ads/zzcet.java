package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcet implements Callable {
    private final zzddi zzffr;
    private final zzddi zzfoe;
    private final zzddi zzfov;

    zzcet(zzddi zzddi, zzddi zzddi2, zzddi zzddi3) {
        this.zzfov = zzddi;
        this.zzfoe = zzddi2;
        this.zzffr = zzddi3;
    }

    public final Object call() {
        return new zzcew((zzcfd) this.zzfov.get(), (JSONObject) this.zzfoe.get(), (zzapk) this.zzffr.get());
    }
}
