package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbys implements zzdwb<zzbyr> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfdx;
    private final zzdwo<zzaxl> zzfgx;
    private final zzdwo<zzdf> zzfkh;
    private final zzdwo<zza> zzfox;
    private final zzdwo<zzbcb> zzfqe;

    public zzbys(zzdwo<Context> zzdwo, zzdwo<Executor> zzdwo2, zzdwo<zzdf> zzdwo3, zzdwo<zzaxl> zzdwo4, zzdwo<zza> zzdwo5, zzdwo<zzbcb> zzdwo6) {
        this.zzejy = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzfkh = zzdwo3;
        this.zzfgx = zzdwo4;
        this.zzfox = zzdwo5;
        this.zzfqe = zzdwo6;
    }

    public final /* synthetic */ Object get() {
        zzbyr zzbyr = new zzbyr((Context) this.zzejy.get(), (Executor) this.zzfdx.get(), (zzdf) this.zzfkh.get(), (zzaxl) this.zzfgx.get(), (zza) this.zzfox.get(), (zzbcb) this.zzfqe.get());
        return zzbyr;
    }
}
