package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpo implements zzdwb<zzcpk> {
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<Context> zzfgo;

    private zzcpo(zzdwo<Context> zzdwo, zzdwo<zzddl> zzdwo2) {
        this.zzfgo = zzdwo;
        this.zzfck = zzdwo2;
    }

    public static zzcpo zzan(zzdwo<Context> zzdwo, zzdwo<zzddl> zzdwo2) {
        return new zzcpo(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcpk((Context) this.zzfgo.get(), (zzddl) this.zzfck.get());
    }
}
