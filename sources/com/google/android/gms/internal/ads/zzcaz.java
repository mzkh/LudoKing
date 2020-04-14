package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcaz implements zzdwb<Set<zzbqs<zzcym>>> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<String> zzfrp;
    private final zzdwo<Map<zzcyd, zzcba>> zzfrq;

    public zzcaz(zzdwo<String> zzdwo, zzdwo<Context> zzdwo2, zzdwo<Executor> zzdwo3, zzdwo<Map<zzcyd, zzcba>> zzdwo4) {
        this.zzfrp = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfck = zzdwo3;
        this.zzfrq = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = (String) this.zzfrp.get();
        Context context = (Context) this.zzejy.get();
        Executor executor = (Executor) this.zzfck.get();
        Map map = (Map) this.zzfrq.get();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcql)).booleanValue()) {
            zzsd zzsd = new zzsd(new zzsi(context));
            zzsd.zza((zzsg) new zzcbb(str));
            set = Collections.singleton(new zzbqs(new zzcay(zzsd, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzdwh.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
