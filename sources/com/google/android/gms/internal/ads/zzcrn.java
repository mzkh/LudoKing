package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrn implements zzdwb<zzcrl> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<zzddl> zzfck;

    private zzcrn(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzaxl> zzdwo3) {
        this.zzfck = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfan = zzdwo3;
    }

    public static zzcrn zzr(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzaxl> zzdwo3) {
        return new zzcrn(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzcrl((zzddl) this.zzfck.get(), (Context) this.zzejy.get(), (zzaxl) this.zzfan.get());
    }
}
