package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdut.zzb.zzf.C3510zzb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdvi extends zzdul<zzdvi> {
    public String mimeType;
    public C3510zzb zzhwk;
    public byte[] zzhwl;

    public zzdvi() {
        this.zzhwk = null;
        this.mimeType = null;
        this.zzhwl = null;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        C3510zzb zzb = this.zzhwk;
        if (!(zzb == null || zzb == null)) {
            zzduj.zzaa(1, zzb.zzab());
        }
        String str = this.mimeType;
        if (str != null) {
            zzduj.zzg(2, str);
        }
        byte[] bArr = this.zzhwl;
        if (bArr != null) {
            zzduj.zza(3, bArr);
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        C3510zzb zzb = this.zzhwk;
        if (!(zzb == null || zzb == null)) {
            zznx += zzduj.zzae(1, zzb.zzab());
        }
        String str = this.mimeType;
        if (str != null) {
            zznx += zzduj.zzh(2, str);
        }
        byte[] bArr = this.zzhwl;
        return bArr != null ? zznx + zzduj.zzgd(3) + zzduj.zzgl(bArr.length) + bArr.length : zznx;
    }
}
