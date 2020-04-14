package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbis implements zzdwb<zzbiq> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzbqw> zzesk;
    private final zzdwo<zzbkn> zzesy;
    private final zzdwo<zzclw> zzexk;
    private final zzdwo<zzcvu> zzfds;
    private final zzdwo<View> zzfdt;
    private final zzdwo<zzbbw> zzfdu;
    private final zzdwo<zzbkl> zzfdv;
    private final zzdwo<zzbuy> zzfdw;
    private final zzdwo<Executor> zzfdx;

    public zzbis(zzdwo<zzbkn> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzcvu> zzdwo3, zzdwo<View> zzdwo4, zzdwo<zzbbw> zzdwo5, zzdwo<zzbkl> zzdwo6, zzdwo<zzbuy> zzdwo7, zzdwo<zzbqw> zzdwo8, zzdwo<zzclw> zzdwo9, zzdwo<Executor> zzdwo10) {
        this.zzesy = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfds = zzdwo3;
        this.zzfdt = zzdwo4;
        this.zzfdu = zzdwo5;
        this.zzfdv = zzdwo6;
        this.zzfdw = zzdwo7;
        this.zzesk = zzdwo8;
        this.zzexk = zzdwo9;
        this.zzfdx = zzdwo10;
    }

    public static zzbiq zza(zzbkn zzbkn, Context context, zzcvu zzcvu, View view, zzbbw zzbbw, zzbkl zzbkl, zzbuy zzbuy, zzbqw zzbqw, zzdvv<zzclw> zzdvv, Executor executor) {
        zzbiq zzbiq = new zzbiq(zzbkn, context, zzcvu, view, zzbbw, zzbkl, zzbuy, zzbqw, zzdvv, executor);
        return zzbiq;
    }

    public final /* synthetic */ Object get() {
        zzbiq zzbiq = new zzbiq((zzbkn) this.zzesy.get(), (Context) this.zzejy.get(), (zzcvu) this.zzfds.get(), (View) this.zzfdt.get(), (zzbbw) this.zzfdu.get(), (zzbkl) this.zzfdv.get(), (zzbuy) this.zzfdw.get(), (zzbqw) this.zzesk.get(), zzdwc.zzao(this.zzexk), (Executor) this.zzfdx.get());
        return zzbiq;
    }
}
