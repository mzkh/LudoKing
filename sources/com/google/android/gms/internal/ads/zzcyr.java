package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcyr implements zzdwb<zzcyp> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxm> zzekp;
    private final zzdwo<zzcwc> zzeyy;
    private final zzdwo<Executor> zzfck;
    private final zzdwo<Clock> zzfco;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<String> zzger;
    private final zzdwo<String> zzges;
    private final zzdwo<zzcjf> zzgmz;

    private zzcyr(zzdwo<Executor> zzdwo, zzdwo<zzaxm> zzdwo2, zzdwo<zzcjf> zzdwo3, zzdwo<zzaxl> zzdwo4, zzdwo<String> zzdwo5, zzdwo<String> zzdwo6, zzdwo<Context> zzdwo7, zzdwo<zzcwc> zzdwo8, zzdwo<Clock> zzdwo9) {
        this.zzfck = zzdwo;
        this.zzekp = zzdwo2;
        this.zzgmz = zzdwo3;
        this.zzfcq = zzdwo4;
        this.zzger = zzdwo5;
        this.zzges = zzdwo6;
        this.zzejy = zzdwo7;
        this.zzeyy = zzdwo8;
        this.zzfco = zzdwo9;
    }

    public static zzcyr zzc(zzdwo<Executor> zzdwo, zzdwo<zzaxm> zzdwo2, zzdwo<zzcjf> zzdwo3, zzdwo<zzaxl> zzdwo4, zzdwo<String> zzdwo5, zzdwo<String> zzdwo6, zzdwo<Context> zzdwo7, zzdwo<zzcwc> zzdwo8, zzdwo<Clock> zzdwo9) {
        zzcyr zzcyr = new zzcyr(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5, zzdwo6, zzdwo7, zzdwo8, zzdwo9);
        return zzcyr;
    }

    public final /* synthetic */ Object get() {
        zzcyp zzcyp = new zzcyp((Executor) this.zzfck.get(), (zzaxm) this.zzekp.get(), (zzcjf) this.zzgmz.get(), (zzaxl) this.zzfcq.get(), (String) this.zzger.get(), (String) this.zzges.get(), (Context) this.zzejy.get(), (zzcwc) this.zzeyy.get(), (Clock) this.zzfco.get());
        return zzcyp;
    }
}
