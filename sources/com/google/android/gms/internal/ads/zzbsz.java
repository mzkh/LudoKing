package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsz implements zzbna {
    private final zzbni zzfiv;
    private final zzcvr zzfiw;

    public zzbsz(zzbni zzbni, zzcvr zzcvr) {
        this.zzfiv = zzbni;
        this.zzfiw = zzcvr;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzapy zzapy, String str, String str2) {
    }

    public final void onAdOpened() {
        if (this.zzfiw.zzgjp == 0 || this.zzfiw.zzgjp == 1) {
            this.zzfiv.onAdImpression();
        }
    }
}
