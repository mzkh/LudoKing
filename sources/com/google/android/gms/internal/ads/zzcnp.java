package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnp implements zzdwb<zzcnn> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<ViewGroup> zzfzd;
    private final zzdwo<zzddl> zzgdx;

    public zzcnp(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<ViewGroup> zzdwo4) {
        this.zzgdx = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfef = zzdwo3;
        this.zzfzd = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzcnn((zzddl) this.zzgdx.get(), (Context) this.zzejy.get(), (zzcwe) this.zzfef.get(), (ViewGroup) this.zzfzd.get());
    }
}
