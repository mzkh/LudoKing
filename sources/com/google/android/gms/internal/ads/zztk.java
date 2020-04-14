package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zztk extends zzdul<zztk> {
    public Integer zzcal;
    public Integer zzcam;
    public Integer zzcan;

    public zztk() {
        this.zzcal = null;
        this.zzcam = null;
        this.zzcan = null;
        this.zzhqy = null;
        this.zzhrh = -1;
    }

    public final void zza(zzduj zzduj) throws IOException {
        Integer num = this.zzcal;
        if (num != null) {
            zzduj.zzaa(1, num.intValue());
        }
        Integer num2 = this.zzcam;
        if (num2 != null) {
            zzduj.zzaa(2, num2.intValue());
        }
        Integer num3 = this.zzcan;
        if (num3 != null) {
            zzduj.zzaa(3, num3.intValue());
        }
        super.zza(zzduj);
    }

    /* access modifiers changed from: protected */
    public final int zznx() {
        int zznx = super.zznx();
        Integer num = this.zzcal;
        if (num != null) {
            zznx += zzduj.zzae(1, num.intValue());
        }
        Integer num2 = this.zzcam;
        if (num2 != null) {
            zznx += zzduj.zzae(2, num2.intValue());
        }
        Integer num3 = this.zzcan;
        return num3 != null ? zznx + zzduj.zzae(3, num3.intValue()) : zznx;
    }
}
