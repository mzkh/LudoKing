package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdut.zza.zzc;
import com.google.android.gms.internal.ads.zzdut.zzb.C3507zzb;
import com.google.android.gms.internal.ads.zzdut.zzb.zzg;
import com.google.android.gms.internal.ads.zzdut.zzb.zzi;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdve extends zzdul<zzdve> {
    public String url;
    public zzg zzhvf;
    private zzc zzhvg;
    public String zzhvh;
    private String zzhvi;
    public C3507zzb zzhvj;
    public zzdvh[] zzhvk;
    public String zzhvl;
    public zzdvi zzhvm;
    private Boolean zzhvn;
    private String[] zzhvo;
    private String zzhvp;
    private Boolean zzhvq;
    private Boolean zzhvr;
    private byte[] zzhvs;
    public zzi zzhvt;
    public String[] zzhvu;
    public String[] zzhvv;

    public zzdve() {
        this.zzhvf = null;
        this.zzhvg = null;
        this.url = null;
        this.zzhvh = null;
        this.zzhvi = null;
        this.zzhvj = null;
        this.zzhvk = zzdvh.zzbcz();
        this.zzhvl = null;
        this.zzhvm = null;
        this.zzhvn = null;
        this.zzhvo = zzduu.zzhrq;
        this.zzhvp = null;
        this.zzhvq = null;
        this.zzhvr = null;
        this.zzhvs = null;
        this.zzhvt = null;
        this.zzhvu = zzduu.zzhrq;
        this.zzhvv = zzduu.zzhrq;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        String str = this.url;
        if (str != null) {
            zzduj.zzg(1, str);
        }
        String str2 = this.zzhvh;
        if (str2 != null) {
            zzduj.zzg(2, str2);
        }
        zzdvh[] zzdvhArr = this.zzhvk;
        int i = 0;
        if (zzdvhArr != null && zzdvhArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzdvh[] zzdvhArr2 = this.zzhvk;
                if (i2 >= zzdvhArr2.length) {
                    break;
                }
                zzdvh zzdvh = zzdvhArr2[i2];
                if (zzdvh != null) {
                    zzduj.zza(4, (zzdus) zzdvh);
                }
                i2++;
            }
        }
        String[] strArr = this.zzhvo;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.zzhvo;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i3];
                if (str3 != null) {
                    zzduj.zzg(6, str3);
                }
                i3++;
            }
        }
        zzg zzg = this.zzhvf;
        if (!(zzg == null || zzg == null)) {
            zzduj.zzaa(10, zzg.zzab());
        }
        C3507zzb zzb = this.zzhvj;
        if (zzb != null) {
            zzduj.zze(12, zzb);
        }
        String str4 = this.zzhvl;
        if (str4 != null) {
            zzduj.zzg(13, str4);
        }
        zzdvi zzdvi = this.zzhvm;
        if (zzdvi != null) {
            zzduj.zza(14, (zzdus) zzdvi);
        }
        zzi zzi = this.zzhvt;
        if (zzi != null) {
            zzduj.zze(17, zzi);
        }
        String[] strArr3 = this.zzhvu;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.zzhvu;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i4];
                if (str5 != null) {
                    zzduj.zzg(20, str5);
                }
                i4++;
            }
        }
        String[] strArr5 = this.zzhvv;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzhvv;
                if (i >= strArr6.length) {
                    break;
                }
                String str6 = strArr6[i];
                if (str6 != null) {
                    zzduj.zzg(21, str6);
                }
                i++;
            }
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        String str = this.url;
        if (str != null) {
            zznx += zzduj.zzh(1, str);
        }
        String str2 = this.zzhvh;
        if (str2 != null) {
            zznx += zzduj.zzh(2, str2);
        }
        zzdvh[] zzdvhArr = this.zzhvk;
        int i = 0;
        if (zzdvhArr != null && zzdvhArr.length > 0) {
            int i2 = zznx;
            int i3 = 0;
            while (true) {
                zzdvh[] zzdvhArr2 = this.zzhvk;
                if (i3 >= zzdvhArr2.length) {
                    break;
                }
                zzdvh zzdvh = zzdvhArr2[i3];
                if (zzdvh != null) {
                    i2 += zzduj.zzb(4, zzdvh);
                }
                i3++;
            }
            zznx = i2;
        }
        String[] strArr = this.zzhvo;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.zzhvo;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    i6++;
                    i5 += zzduj.zzhj(str3);
                }
                i4++;
            }
            zznx = zznx + i5 + (i6 * 1);
        }
        zzg zzg = this.zzhvf;
        if (!(zzg == null || zzg == null)) {
            zznx += zzduj.zzae(10, zzg.zzab());
        }
        C3507zzb zzb = this.zzhvj;
        if (zzb != null) {
            zznx += zzdqf.zzc(12, (zzdsg) zzb);
        }
        String str4 = this.zzhvl;
        if (str4 != null) {
            zznx += zzduj.zzh(13, str4);
        }
        zzdvi zzdvi = this.zzhvm;
        if (zzdvi != null) {
            zznx += zzduj.zzb(14, zzdvi);
        }
        zzi zzi = this.zzhvt;
        if (zzi != null) {
            zznx += zzdqf.zzc(17, (zzdsg) zzi);
        }
        String[] strArr3 = this.zzhvu;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.zzhvu;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i7];
                if (str5 != null) {
                    i9++;
                    i8 += zzduj.zzhj(str5);
                }
                i7++;
            }
            zznx = zznx + i8 + (i9 * 2);
        }
        String[] strArr5 = this.zzhvv;
        if (strArr5 == null || strArr5.length <= 0) {
            return zznx;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr6 = this.zzhvv;
            if (i >= strArr6.length) {
                return zznx + i10 + (i11 * 2);
            }
            String str6 = strArr6[i];
            if (str6 != null) {
                i11++;
                i10 += zzduj.zzhj(str6);
            }
            i++;
        }
    }
}
