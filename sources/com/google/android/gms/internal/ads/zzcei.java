package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcei implements zzdwb<zzcej> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzasl> zzfaq;

    private zzcei(zzdwo<Context> zzdwo, zzdwo<zzasl> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzfaq = zzdwo2;
    }

    public static zzcei zzae(zzdwo<Context> zzdwo, zzdwo<zzasl> zzdwo2) {
        return new zzcei(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcej((Context) this.zzejy.get(), (zzasl) this.zzfaq.get());
    }
}
