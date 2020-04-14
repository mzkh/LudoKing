package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsp.zza;
import com.google.android.gms.internal.ads.zzsp.zzh;
import com.google.android.gms.internal.ads.zzsp.zzj;
import com.google.android.gms.internal.ads.zzsp.zzw;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zztl extends zzdul<zztl> {
    private Integer zzcao;
    public String zzcap;
    private Integer zzcaq;
    private zzsv zzcar;
    private zztk zzcas;
    public long[] zzcat;
    public zztj zzcau;
    private zzti zzcav;
    private zzh zzcaw;
    public zzth zzcax;
    public zzj zzcay;
    public zzw zzcaz;
    private zza zzcba;

    public zztl() {
        this.zzcao = null;
        this.zzcap = null;
        this.zzcaq = null;
        this.zzcar = null;
        this.zzcas = null;
        this.zzcat = zzduu.zzhrm;
        this.zzcau = null;
        this.zzcav = null;
        this.zzcaw = null;
        this.zzcax = null;
        this.zzcay = null;
        this.zzcaz = null;
        this.zzcba = null;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        String str = this.zzcap;
        if (str != null) {
            zzduj.zzg(10, str);
        }
        long[] jArr = this.zzcat;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.zzcat;
                if (i >= jArr2.length) {
                    break;
                }
                long j = jArr2[i];
                zzduj.zzz(14, 0);
                zzduj.zzfm(j);
                i++;
            }
        }
        zztj zztj = this.zzcau;
        if (zztj != null) {
            zzduj.zza(15, (zzdus) zztj);
        }
        zzth zzth = this.zzcax;
        if (zzth != null) {
            zzduj.zza(18, (zzdus) zzth);
        }
        zzj zzj = this.zzcay;
        if (zzj != null) {
            zzduj.zze(19, zzj);
        }
        zzw zzw = this.zzcaz;
        if (zzw != null) {
            zzduj.zze(20, zzw);
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        long[] jArr;
        int zznx = super.zznx();
        String str = this.zzcap;
        if (str != null) {
            zznx += zzduj.zzh(10, str);
        }
        long[] jArr2 = this.zzcat;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                jArr = this.zzcat;
                if (i >= jArr.length) {
                    break;
                }
                long j = jArr[i];
                int i3 = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
                i2 += i3;
                i++;
            }
            zznx = zznx + i2 + (jArr.length * 1);
        }
        zztj zztj = this.zzcau;
        if (zztj != null) {
            zznx += zzduj.zzb(15, zztj);
        }
        zzth zzth = this.zzcax;
        if (zzth != null) {
            zznx += zzduj.zzb(18, zzth);
        }
        zzj zzj = this.zzcay;
        if (zzj != null) {
            zznx += zzdqf.zzc(19, (zzdsg) zzj);
        }
        zzw zzw = this.zzcaz;
        return zzw != null ? zznx + zzdqf.zzc(20, (zzdsg) zzw) : zznx;
    }
}
