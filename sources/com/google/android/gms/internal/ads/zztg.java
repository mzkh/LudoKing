package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsp.zzb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zztg extends zzdul<zztg> {
    public String zzbzn;
    private zzb[] zzbzo;
    private zzsv zzbzp;
    private zzsv zzbzq;
    private zzsv zzbzr;

    public zztg() {
        this.zzbzn = null;
        this.zzbzo = new zzb[0];
        this.zzbzp = null;
        this.zzbzq = null;
        this.zzbzr = null;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        String str = this.zzbzn;
        if (str != null) {
            zzduj.zzg(1, str);
        }
        zzb[] zzbArr = this.zzbzo;
        if (zzbArr != null && zzbArr.length > 0) {
            int i = 0;
            while (true) {
                zzb[] zzbArr2 = this.zzbzo;
                if (i >= zzbArr2.length) {
                    break;
                }
                zzb zzb = zzbArr2[i];
                if (zzb != null) {
                    zzduj.zze(2, zzb);
                }
                i++;
            }
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        String str = this.zzbzn;
        if (str != null) {
            zznx += zzduj.zzh(1, str);
        }
        zzb[] zzbArr = this.zzbzo;
        if (zzbArr != null && zzbArr.length > 0) {
            int i = 0;
            while (true) {
                zzb[] zzbArr2 = this.zzbzo;
                if (i >= zzbArr2.length) {
                    break;
                }
                zzb zzb = zzbArr2[i];
                if (zzb != null) {
                    zznx += zzdqf.zzc(2, (zzdsg) zzb);
                }
                i++;
            }
        }
        return zznx;
    }
}
