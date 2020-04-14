package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsp.zzb;
import com.google.android.gms.internal.ads.zzsp.zzc;
import com.google.android.gms.internal.ads.zzsp.zzd;
import com.google.android.gms.internal.ads.zzsp.zzf;
import com.google.android.gms.internal.ads.zzsp.zzg;
import com.google.android.gms.internal.ads.zzsp.zzi;
import com.google.android.gms.internal.ads.zzsp.zzk;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzth extends zzdul<zzth> {
    public Integer zzbzs;
    private zzsv zzbzt;
    private zzc zzbzu;
    public zztg zzbzv;
    private zzb[] zzbzw;
    private zzd zzbzx;
    private zzk zzbzy;
    private zzi zzbzz;
    private zzf zzcaa;
    private zzg zzcab;
    private zztn[] zzcac;

    public zzth() {
        this.zzbzs = null;
        this.zzbzt = null;
        this.zzbzu = null;
        this.zzbzv = null;
        this.zzbzw = new zzb[0];
        this.zzbzx = null;
        this.zzbzy = null;
        this.zzbzz = null;
        this.zzcaa = null;
        this.zzcab = null;
        this.zzcac = zztn.zzny();
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        Integer num = this.zzbzs;
        if (num != null) {
            zzduj.zzaa(7, num.intValue());
        }
        zztg zztg = this.zzbzv;
        if (zztg != null) {
            zzduj.zza(10, (zzdus) zztg);
        }
        zzb[] zzbArr = this.zzbzw;
        int i = 0;
        if (zzbArr != null && zzbArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzb[] zzbArr2 = this.zzbzw;
                if (i2 >= zzbArr2.length) {
                    break;
                }
                zzb zzb = zzbArr2[i2];
                if (zzb != null) {
                    zzduj.zze(11, zzb);
                }
                i2++;
            }
        }
        zztn[] zztnArr = this.zzcac;
        if (zztnArr != null && zztnArr.length > 0) {
            while (true) {
                zztn[] zztnArr2 = this.zzcac;
                if (i >= zztnArr2.length) {
                    break;
                }
                zztn zztn = zztnArr2[i];
                if (zztn != null) {
                    zzduj.zza(17, (zzdus) zztn);
                }
                i++;
            }
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        Integer num = this.zzbzs;
        if (num != null) {
            zznx += zzduj.zzae(7, num.intValue());
        }
        zztg zztg = this.zzbzv;
        if (zztg != null) {
            zznx += zzduj.zzb(10, zztg);
        }
        zzb[] zzbArr = this.zzbzw;
        int i = 0;
        if (zzbArr != null && zzbArr.length > 0) {
            int i2 = zznx;
            int i3 = 0;
            while (true) {
                zzb[] zzbArr2 = this.zzbzw;
                if (i3 >= zzbArr2.length) {
                    break;
                }
                zzb zzb = zzbArr2[i3];
                if (zzb != null) {
                    i2 += zzdqf.zzc(11, (zzdsg) zzb);
                }
                i3++;
            }
            zznx = i2;
        }
        zztn[] zztnArr = this.zzcac;
        if (zztnArr != null && zztnArr.length > 0) {
            while (true) {
                zztn[] zztnArr2 = this.zzcac;
                if (i >= zztnArr2.length) {
                    break;
                }
                zztn zztn = zztnArr2[i];
                if (zztn != null) {
                    zznx += zzduj.zzb(17, zztn);
                }
                i++;
            }
        }
        return zznx;
    }
}
