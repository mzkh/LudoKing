package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrf implements zzdwb<zzcrc> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzclr> zzekl;
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<String> zzfcr;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<ScheduledExecutorService> zzfoz;
    private final zzdwo<zzclp> zzgah;

    private zzcrf(zzdwo<zzddl> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<String> zzdwo3, zzdwo<zzclr> zzdwo4, zzdwo<Context> zzdwo5, zzdwo<zzcwe> zzdwo6, zzdwo<zzclp> zzdwo7) {
        this.zzfck = zzdwo;
        this.zzfoz = zzdwo2;
        this.zzfcr = zzdwo3;
        this.zzekl = zzdwo4;
        this.zzejy = zzdwo5;
        this.zzfef = zzdwo6;
        this.zzgah = zzdwo7;
    }

    public static zzcrf zza(zzdwo<zzddl> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<String> zzdwo3, zzdwo<zzclr> zzdwo4, zzdwo<Context> zzdwo5, zzdwo<zzcwe> zzdwo6, zzdwo<zzclp> zzdwo7) {
        zzcrf zzcrf = new zzcrf(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5, zzdwo6, zzdwo7);
        return zzcrf;
    }

    public final /* synthetic */ Object get() {
        zzcrc zzcrc = new zzcrc((zzddl) this.zzfck.get(), (ScheduledExecutorService) this.zzfoz.get(), (String) this.zzfcr.get(), (zzclr) this.zzekl.get(), (Context) this.zzejy.get(), (zzcwe) this.zzfef.get(), (zzclp) this.zzgah.get());
        return zzcrc;
    }
}
