package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsu implements zzdwb<zzcss> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaph> zzeqj;
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<String> zzfrb;

    public zzcsu(zzdwo<zzaph> zzdwo, zzdwo<Context> zzdwo2, zzdwo<String> zzdwo3, zzdwo<zzddl> zzdwo4) {
        this.zzeqj = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfrb = zzdwo3;
        this.zzfck = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzcss((zzaph) this.zzeqj.get(), (Context) this.zzejy.get(), (String) this.zzfrb.get(), (zzddl) this.zzfck.get());
    }
}
