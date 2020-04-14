package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsf.zza.C3512zza;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcaq implements zzbnb, zzbnj, zzbog, zzbpc, zztp {
    private final zzsd zzfrg;
    @GuardedBy("this")
    private boolean zzfrh = false;
    @GuardedBy("this")
    private boolean zzfri = false;

    public zzcaq(zzsd zzsd, @Nullable zzcuf zzcuf) {
        this.zzfrg = zzsd;
        zzsd.zza(C3512zza.AD_REQUEST);
        if (zzcuf != null && zzcuf.zzggg) {
            zzsd.zza(C3512zza.REQUEST_IS_PREFETCH);
        }
    }

    public final void zzb(zzape zzape) {
    }

    public final void zza(zzcvz zzcvz) {
        this.zzfrg.zza((zzsg) new zzcat(zzcvz));
    }

    public final void onAdLoaded() {
        this.zzfrg.zza(C3512zza.AD_LOADED);
    }

    public final void onAdFailedToLoad(int i) {
        switch (i) {
            case 1:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzfrg.zza(C3512zza.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final synchronized void onAdImpression() {
        this.zzfrg.zza(C3512zza.AD_IMPRESSION);
    }

    public final synchronized void onAdClicked() {
        if (!this.zzfri) {
            this.zzfrg.zza(C3512zza.AD_FIRST_CLICK);
            this.zzfri = true;
            return;
        }
        this.zzfrg.zza(C3512zza.AD_SUBSEQUENT_CLICK);
    }
}
