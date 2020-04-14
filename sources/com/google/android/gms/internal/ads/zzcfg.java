package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfg implements zzdwb<zzcfh> {
    private final zzdwo<Context> zzejy;

    private zzcfg(zzdwo<Context> zzdwo) {
        this.zzejy = zzdwo;
    }

    public static zzcfg zzac(zzdwo<Context> zzdwo) {
        return new zzcfg(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzcfh((Context) this.zzejy.get());
    }
}
