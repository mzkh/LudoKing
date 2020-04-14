package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcps implements zzdwb<zzcpq> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzddl> zzfck;

    private zzcps(zzdwo<Context> zzdwo, zzdwo<zzddl> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcps zzao(zzdwo<Context> zzdwo, zzdwo<zzddl> zzdwo2) {
        return new zzcps(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcpq((Context) this.zzejy.get(), (zzddl) this.zzfck.get());
    }
}
