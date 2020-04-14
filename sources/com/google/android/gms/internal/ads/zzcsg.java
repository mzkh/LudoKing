package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsg implements zzdwb<zzcse> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzddl> zzfck;

    private zzcsg(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzejy = zzdwo2;
    }

    public static zzcsg zzau(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2) {
        return new zzcsg(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcse((zzddl) this.zzfck.get(), (Context) this.zzejy.get());
    }
}
