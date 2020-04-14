package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoq implements zzdwb<zzcoo> {
    private final zzdwo<zzblr> zzelz;
    private final zzdwo<zzcwu> zzenj;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<String> zzger;
    private final zzdwo<String> zzges;

    private zzcoq(zzdwo<String> zzdwo, zzdwo<String> zzdwo2, zzdwo<zzblr> zzdwo3, zzdwo<zzcwu> zzdwo4, zzdwo<zzcwe> zzdwo5) {
        this.zzger = zzdwo;
        this.zzges = zzdwo2;
        this.zzelz = zzdwo3;
        this.zzenj = zzdwo4;
        this.zzfef = zzdwo5;
    }

    public static zzcoq zzh(zzdwo<String> zzdwo, zzdwo<String> zzdwo2, zzdwo<zzblr> zzdwo3, zzdwo<zzcwu> zzdwo4, zzdwo<zzcwe> zzdwo5) {
        zzcoq zzcoq = new zzcoq(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzcoq;
    }

    public final /* synthetic */ Object get() {
        zzcoo zzcoo = new zzcoo((String) this.zzger.get(), (String) this.zzges.get(), (zzblr) this.zzelz.get(), (zzcwu) this.zzenj.get(), (zzcwe) this.zzfef.get());
        return zzcoo;
    }
}
