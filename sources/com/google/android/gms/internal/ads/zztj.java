package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsp.zzo;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zztj extends zzdul<zztj> {
    public String zzcad;
    private zzo zzcae;
    private Integer zzcaf;
    public zztk zzcag;
    private Integer zzcah;
    private zzsv zzcai;
    private zzsv zzcaj;
    private zzsv zzcak;

    public zztj() {
        this.zzcad = null;
        this.zzcae = null;
        this.zzcaf = null;
        this.zzcag = null;
        this.zzcah = null;
        this.zzcai = null;
        this.zzcaj = null;
        this.zzcak = null;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        String str = this.zzcad;
        if (str != null) {
            zzduj.zzg(1, str);
        }
        zztk zztk = this.zzcag;
        if (zztk != null) {
            zzduj.zza(4, (zzdus) zztk);
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        String str = this.zzcad;
        if (str != null) {
            zznx += zzduj.zzh(1, str);
        }
        zztk zztk = this.zzcag;
        return zztk != null ? zznx + zzduj.zzb(4, zztk) : zznx;
    }
}
