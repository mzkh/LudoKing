package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsy implements zzdwb<zzcsw> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzrr> zzeqj;
    private final zzdwo<zzddl> zzfck;

    public zzcsy(zzdwo<zzrr> zzdwo, zzdwo<zzddl> zzdwo2, zzdwo<Context> zzdwo3) {
        this.zzeqj = zzdwo;
        this.zzfck = zzdwo2;
        this.zzejy = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzcsw((zzrr) this.zzeqj.get(), (zzddl) this.zzfck.get(), (Context) this.zzejy.get());
    }
}
