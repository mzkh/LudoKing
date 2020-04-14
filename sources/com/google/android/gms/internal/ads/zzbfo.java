package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbfo {
    private zzbel zzekb;
    private zzbfx zzexq;
    private zzcyn zzexr;
    private zzbge zzexs;
    private zzcwq zzext;

    private zzbfo() {
    }

    public final zzbfo zzc(zzbel zzbel) {
        this.zzekb = (zzbel) zzdwh.checkNotNull(zzbel);
        return this;
    }

    public final zzbfo zza(zzbfx zzbfx) {
        this.zzexq = (zzbfx) zzdwh.checkNotNull(zzbfx);
        return this;
    }

    public final zzbei zzadg() {
        zzdwh.zza(this.zzekb, zzbel.class);
        zzdwh.zza(this.zzexq, zzbfx.class);
        if (this.zzexr == null) {
            this.zzexr = new zzcyn();
        }
        if (this.zzexs == null) {
            this.zzexs = new zzbge();
        }
        if (this.zzext == null) {
            this.zzext = new zzcwq();
        }
        zzbfa zzbfa = new zzbfa(this.zzekb, this.zzexq, this.zzexr, this.zzexs, this.zzext);
        return zzbfa;
    }
}
