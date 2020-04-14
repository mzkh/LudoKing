package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbtc implements zzdwb<zzbtd> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzasl> zzfaq;
    private final zzdwo<Integer> zzfcr;
    private final zzdwo<View> zzfdt;
    private final zzdwo<zzasm> zzffe;

    private zzbtc(zzdwo<zzasm> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzasl> zzdwo3, zzdwo<View> zzdwo4, zzdwo<Integer> zzdwo5) {
        this.zzffe = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfaq = zzdwo3;
        this.zzfdt = zzdwo4;
        this.zzfcr = zzdwo5;
    }

    public static zzbtc zze(zzdwo<zzasm> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzasl> zzdwo3, zzdwo<View> zzdwo4, zzdwo<Integer> zzdwo5) {
        zzbtc zzbtc = new zzbtc(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzbtc;
    }

    public final /* synthetic */ Object get() {
        zzbtd zzbtd = new zzbtd((zzasm) this.zzffe.get(), (Context) this.zzejy.get(), (zzasl) this.zzfaq.get(), (View) this.zzfdt.get(), ((Integer) this.zzfcr.get()).intValue());
        return zzbtd;
    }
}
