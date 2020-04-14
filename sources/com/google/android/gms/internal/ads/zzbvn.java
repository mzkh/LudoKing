package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvn implements zzdwb<zzbvj> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaui> zzemh;
    private final zzdwo<zzbuv> zzete;
    private final zzdwo<zzbvr> zzetf;
    private final zzdwo<zzbup> zzeth;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzbur> zzfkg;

    private zzbvn(zzdwo<Context> zzdwo, zzdwo<zzaui> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<zzbuv> zzdwo4, zzdwo<zzbur> zzdwo5, zzdwo<zzbvr> zzdwo6, zzdwo<Executor> zzdwo7, zzdwo<Executor> zzdwo8, zzdwo<zzbup> zzdwo9) {
        this.zzejy = zzdwo;
        this.zzemh = zzdwo2;
        this.zzfef = zzdwo3;
        this.zzete = zzdwo4;
        this.zzfkg = zzdwo5;
        this.zzetf = zzdwo6;
        this.zzfdx = zzdwo7;
        this.zzfck = zzdwo8;
        this.zzeth = zzdwo9;
    }

    public static zzbvn zza(zzdwo<Context> zzdwo, zzdwo<zzaui> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<zzbuv> zzdwo4, zzdwo<zzbur> zzdwo5, zzdwo<zzbvr> zzdwo6, zzdwo<Executor> zzdwo7, zzdwo<Executor> zzdwo8, zzdwo<zzbup> zzdwo9) {
        zzbvn zzbvn = new zzbvn(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5, zzdwo6, zzdwo7, zzdwo8, zzdwo9);
        return zzbvn;
    }

    public final /* synthetic */ Object get() {
        zzbvj zzbvj = new zzbvj((Context) this.zzejy.get(), (zzaui) this.zzemh.get(), (zzcwe) this.zzfef.get(), (zzbuv) this.zzete.get(), (zzbur) this.zzfkg.get(), (zzbvr) this.zzetf.get(), (Executor) this.zzfdx.get(), (Executor) this.zzfck.get(), (zzbup) this.zzeth.get());
        return zzbvj;
    }
}
