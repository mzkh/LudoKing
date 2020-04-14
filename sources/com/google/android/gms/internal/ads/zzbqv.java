package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqv extends zzbpm<zzpj> implements zzpj {
    private final zzcvr zzfet;
    @GuardedBy("this")
    private Map<View, zzpf> zzfib = new WeakHashMap(1);
    private final Context zzlk;

    public zzbqv(Context context, Set<zzbqs<zzpj>> set, zzcvr zzcvr) {
        super(set);
        this.zzlk = context;
        this.zzfet = zzcvr;
    }

    public final synchronized void zza(zzpk zzpk) {
        zza((zzbpo<ListenerT>) new zzbqu<ListenerT>(zzpk));
    }

    public final synchronized void zzq(View view) {
        zzpf zzpf = (zzpf) this.zzfib.get(view);
        if (zzpf == null) {
            zzpf = new zzpf(this.zzlk, view);
            zzpf.zza((zzpj) this);
            this.zzfib.put(view, zzpf);
        }
        if (this.zzfet != null && this.zzfet.zzdls) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzclz)).booleanValue()) {
                zzpf.zzeh(((Long) zzuv.zzon().zzd(zzza.zzcly)).longValue());
                return;
            }
        }
        zzpf.zzli();
    }

    public final synchronized void zzr(View view) {
        if (this.zzfib.containsKey(view)) {
            ((zzpf) this.zzfib.get(view)).zzb(this);
            this.zzfib.remove(view);
        }
    }
}
