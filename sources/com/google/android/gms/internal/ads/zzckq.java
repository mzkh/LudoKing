package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbnz;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzckq<AdT, AdapterT, ListenerT extends zzbnz> implements zzdwb<zzckm<AdT, AdapterT, ListenerT>> {
    private final zzdwo<zzcge<AdapterT, ListenerT>> zzfao;
    private final zzdwo<zzddl> zzfdx;
    private final zzdwo<zzcyg> zzfek;
    private final zzdwo<zzcgh<AdT, AdapterT, ListenerT>> zzgaj;

    private zzckq(zzdwo<zzcyg> zzdwo, zzdwo<zzddl> zzdwo2, zzdwo<zzcge<AdapterT, ListenerT>> zzdwo3, zzdwo<zzcgh<AdT, AdapterT, ListenerT>> zzdwo4) {
        this.zzfek = zzdwo;
        this.zzfdx = zzdwo2;
        this.zzfao = zzdwo3;
        this.zzgaj = zzdwo4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbnz> zzckq<AdT, AdapterT, ListenerT> zzd(zzdwo<zzcyg> zzdwo, zzdwo<zzddl> zzdwo2, zzdwo<zzcge<AdapterT, ListenerT>> zzdwo3, zzdwo<zzcgh<AdT, AdapterT, ListenerT>> zzdwo4) {
        return new zzckq<>(zzdwo, zzdwo2, zzdwo3, zzdwo4);
    }

    public final /* synthetic */ Object get() {
        return new zzckm((zzcyg) this.zzfek.get(), (zzddl) this.zzfdx.get(), (zzcge) this.zzfao.get(), (zzcgh) this.zzgaj.get());
    }
}
