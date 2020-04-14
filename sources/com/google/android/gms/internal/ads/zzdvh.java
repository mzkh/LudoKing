package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdut.zzb.zzh.zza;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdvh extends zzdul<zzdvh> {
    private static volatile zzdvh[] zzhwb;
    public String url;
    public Integer zzhwc;
    public zzdvg zzhwd;
    private zzdvf zzhwe;
    private Integer zzhwf;
    private int[] zzhwg;
    private String zzhwh;
    public zza zzhwi;
    public String[] zzhwj;

    public static zzdvh[] zzbcz() {
        if (zzhwb == null) {
            synchronized (zzdup.zzhre) {
                if (zzhwb == null) {
                    zzhwb = new zzdvh[0];
                }
            }
        }
        return zzhwb;
    }

    public zzdvh() {
        this.zzhwc = null;
        this.url = null;
        this.zzhwd = null;
        this.zzhwe = null;
        this.zzhwf = null;
        this.zzhwg = zzduu.zzhmz;
        this.zzhwh = null;
        this.zzhwi = null;
        this.zzhwj = zzduu.zzhrq;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        zzduj.zzaa(1, this.zzhwc.intValue());
        String str = this.url;
        if (str != null) {
            zzduj.zzg(2, str);
        }
        zzdvg zzdvg = this.zzhwd;
        if (zzdvg != null) {
            zzduj.zza(3, (zzdus) zzdvg);
        }
        int[] iArr = this.zzhwg;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.zzhwg;
                if (i2 >= iArr2.length) {
                    break;
                }
                zzduj.zzaa(6, iArr2[i2]);
                i2++;
            }
        }
        zza zza = this.zzhwi;
        if (!(zza == null || zza == null)) {
            zzduj.zzaa(8, zza.zzab());
        }
        String[] strArr = this.zzhwj;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.zzhwj;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzduj.zzg(9, str2);
                }
                i++;
            }
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int[] iArr;
        int zznx = super.zznx() + zzduj.zzae(1, this.zzhwc.intValue());
        String str = this.url;
        if (str != null) {
            zznx += zzduj.zzh(2, str);
        }
        zzdvg zzdvg = this.zzhwd;
        if (zzdvg != null) {
            zznx += zzduj.zzb(3, zzdvg);
        }
        int[] iArr2 = this.zzhwg;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = this.zzhwg;
                if (i2 >= iArr.length) {
                    break;
                }
                i3 += zzduj.zzge(iArr[i2]);
                i2++;
            }
            zznx = zznx + i3 + (iArr.length * 1);
        }
        zza zza = this.zzhwi;
        if (!(zza == null || zza == null)) {
            zznx += zzduj.zzae(8, zza.zzab());
        }
        String[] strArr = this.zzhwj;
        if (strArr == null || strArr.length <= 0) {
            return zznx;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.zzhwj;
            if (i >= strArr2.length) {
                return zznx + i4 + (i5 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i5++;
                i4 += zzduj.zzhj(str2);
            }
            i++;
        }
    }
}
