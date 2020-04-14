package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcte implements Callable {
    private final zzddi zzfoe;
    private final zzddi zzfov;

    zzcte(zzddi zzddi, zzddi zzddi2) {
        this.zzfov = zzddi;
        this.zzfoe = zzddi2;
    }

    public final Object call() {
        return new zzctc((String) this.zzfov.get(), (String) this.zzfoe.get());
    }
}
