package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcfu implements zzdwb<zzcft> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcfp> zzemr;
    private final zzdwo<zzcfj> zzepb;
    private final zzdwo<zzddi<Bundle>> zzfwv;

    private zzcfu(zzdwo<Context> zzdwo, zzdwo<zzddi<Bundle>> zzdwo2, zzdwo<zzcfp> zzdwo3, zzdwo<zzcfj> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzfwv = zzdwo2;
        this.zzemr = zzdwo3;
        this.zzepb = zzdwo4;
    }

    public static zzcfu zzc(zzdwo<Context> zzdwo, zzdwo<zzddi<Bundle>> zzdwo2, zzdwo<zzcfp> zzdwo3, zzdwo<zzcfj> zzdwo4) {
        return new zzcfu(zzdwo, zzdwo2, zzdwo3, zzdwo4);
    }

    public final /* synthetic */ Object get() {
        return new zzcft((Context) this.zzejy.get(), (zzddi) this.zzfwv.get(), (zzcfp) this.zzemr.get(), (zzcfj) this.zzepb.get());
    }
}
