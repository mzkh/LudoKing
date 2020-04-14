package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdut.zzb.zzc;
import com.google.android.gms.internal.ads.zzdut.zzb.zzd.C3508zzb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdvg extends zzdul<zzdvg> {
    private C3508zzb zzhvw;
    public zzc[] zzhvx;
    private byte[] zzhvy;
    private byte[] zzhvz;
    private Integer zzhwa;

    public zzdvg() {
        this.zzhvw = null;
        this.zzhvx = new zzc[0];
        this.zzhvy = null;
        this.zzhvz = null;
        this.zzhwa = null;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        zzc[] zzcArr = this.zzhvx;
        if (zzcArr != null && zzcArr.length > 0) {
            int i = 0;
            while (true) {
                zzc[] zzcArr2 = this.zzhvx;
                if (i >= zzcArr2.length) {
                    break;
                }
                zzc zzc = zzcArr2[i];
                if (zzc != null) {
                    zzduj.zze(2, zzc);
                }
                i++;
            }
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        zzc[] zzcArr = this.zzhvx;
        if (zzcArr != null && zzcArr.length > 0) {
            int i = 0;
            while (true) {
                zzc[] zzcArr2 = this.zzhvx;
                if (i >= zzcArr2.length) {
                    break;
                }
                zzc zzc = zzcArr2[i];
                if (zzc != null) {
                    zznx += zzdqf.zzc(2, (zzdsg) zzc);
                }
                i++;
            }
        }
        return zznx;
    }
}
