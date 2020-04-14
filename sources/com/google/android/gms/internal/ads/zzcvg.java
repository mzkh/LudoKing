package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvg implements zzdwb<zzcvb> {
    private final zzdwo<zzbei> zzejx;
    private final zzdwo<zzcwc> zzeyy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<Context> zzgim;
    private final zzdwo<zzcud<zzbzc, zzbyz>> zzgin;
    private final zzdwo<zzcui> zzgio;
    private final zzdwo<zzcwg> zzgip;

    public zzcvg(zzdwo<Context> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<zzbei> zzdwo3, zzdwo<zzcud<zzbzc, zzbyz>> zzdwo4, zzdwo<zzcui> zzdwo5, zzdwo<zzcwg> zzdwo6, zzdwo<zzcwc> zzdwo7) {
        this.zzgim = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzejx = zzdwo3;
        this.zzgin = zzdwo4;
        this.zzgio = zzdwo5;
        this.zzgip = zzdwo6;
        this.zzeyy = zzdwo7;
    }

    public final /* synthetic */ Object get() {
        zzcvb zzcvb = new zzcvb((Context) this.zzgim.get(), (Executor) this.zzfdx.get(), (zzbei) this.zzejx.get(), (zzcud) this.zzgin.get(), (zzcui) this.zzgio.get(), (zzcwg) this.zzgip.get(), (zzcwc) this.zzeyy.get());
        return zzcvb;
    }
}
