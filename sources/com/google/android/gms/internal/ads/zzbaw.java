package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbaw extends zzauc {
    final zzazj zzdya;
    private final String zzdym;
    private final String[] zzdyn;
    final zzbax zzede;

    zzbaw(zzazj zzazj, zzbax zzbax, String str, String[] strArr) {
        this.zzdya = zzazj;
        this.zzede = zzbax;
        this.zzdym = str;
        this.zzdyn = strArr;
        zzq.zzlf().zza(this);
    }

    public final void zzsx() {
        try {
            this.zzede.zze(this.zzdym, this.zzdyn);
        } finally {
            zzaul.zzdsu.post(new zzbav(this));
        }
    }
}
