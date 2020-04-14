package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblr implements zzbna, zzbnj, zzbog, zzbpc, zztp {
    private final Clock zzbmp;
    private final zzatq zzfgj;

    public zzblr(Clock clock, zzatq zzatq) {
        this.zzbmp = clock;
        this.zzfgj = zzatq;
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzape zzape) {
    }

    public final void zzb(zzapy zzapy, String str, String str2) {
    }

    public final void onAdClicked() {
        this.zzfgj.zzty();
    }

    public final void onAdLoaded() {
        this.zzfgj.zzag(true);
    }

    public final void onAdImpression() {
        this.zzfgj.zztx();
    }

    public final void zzf(zztx zztx) {
        this.zzfgj.zze(zztx);
    }

    public final void zza(zzcvz zzcvz) {
        this.zzfgj.zzes(this.zzbmp.elapsedRealtime());
    }

    public final void onAdClosed() {
        this.zzfgj.zztz();
    }

    public final String zzua() {
        return this.zzfgj.zzua();
    }
}
