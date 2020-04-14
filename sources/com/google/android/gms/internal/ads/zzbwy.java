package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwy implements zzdwb<zzbwq> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzbwl> zzepw;
    private final zzdwo<zzbxe> zzepy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzdf> zzfkh;
    private final zzdwo<zza> zzfox;
    private final zzdwo<zzsd> zzfoy;
    private final zzdwo<ScheduledExecutorService> zzfoz;

    public zzbwy(zzdwo<Context> zzdwo, zzdwo<zzbwl> zzdwo2, zzdwo<zzdf> zzdwo3, zzdwo<zzaxl> zzdwo4, zzdwo<zza> zzdwo5, zzdwo<zzsd> zzdwo6, zzdwo<Executor> zzdwo7, zzdwo<zzcwe> zzdwo8, zzdwo<zzbxe> zzdwo9, zzdwo<ScheduledExecutorService> zzdwo10) {
        this.zzejy = zzdwo;
        this.zzepw = zzdwo2;
        this.zzfkh = zzdwo3;
        this.zzfan = zzdwo4;
        this.zzfox = zzdwo5;
        this.zzfoy = zzdwo6;
        this.zzfck = zzdwo7;
        this.zzfef = zzdwo8;
        this.zzepy = zzdwo9;
        this.zzfoz = zzdwo10;
    }

    public final /* synthetic */ Object get() {
        zzbwq zzbwq = new zzbwq((Context) this.zzejy.get(), (zzbwl) this.zzepw.get(), (zzdf) this.zzfkh.get(), (zzaxl) this.zzfan.get(), (zza) this.zzfox.get(), (zzsd) this.zzfoy.get(), (Executor) this.zzfck.get(), (zzcwe) this.zzfef.get(), (zzbxe) this.zzepy.get(), (ScheduledExecutorService) this.zzfoz.get());
        return zzbwq;
    }
}
