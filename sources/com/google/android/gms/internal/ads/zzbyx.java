package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyx implements zzafb {
    private final zzbnr zzffv;
    @Nullable
    private final zzaqt zzfqf;
    private final String zzfqg;
    private final String zzfqh;

    public zzbyx(zzbnr zzbnr, zzcvr zzcvr) {
        this.zzffv = zzbnr;
        this.zzfqf = zzcvr.zzdle;
        this.zzfqg = zzcvr.zzddf;
        this.zzfqh = zzcvr.zzddg;
    }

    public final void zzra() {
        this.zzffv.onRewardedVideoStarted();
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzaqt zzaqt) {
        int i;
        String str;
        zzaqt zzaqt2 = this.zzfqf;
        if (zzaqt2 != null) {
            zzaqt = zzaqt2;
        }
        if (zzaqt != null) {
            str = zzaqt.type;
            i = zzaqt.zzdnv;
        } else {
            str = "";
            i = 1;
        }
        this.zzffv.zzb(new zzapw(str, i), this.zzfqg, this.zzfqh);
    }

    public final void zzrb() {
        this.zzffv.onRewardedVideoCompleted();
    }
}
