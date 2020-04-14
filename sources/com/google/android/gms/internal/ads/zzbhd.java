package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhd implements zzbna, zzbnj, zzbog, zztp {
    private final zzcvz zzfbd;
    private final zzcyp zzfbe;
    private final zzcvr zzfbi;
    @GuardedBy("this")
    private boolean zzfbj;
    @GuardedBy("this")
    private boolean zzfbk;

    public zzbhd(zzcvz zzcvz, zzcvr zzcvr, zzcyp zzcyp) {
        this.zzfbd = zzcvz;
        this.zzfbi = zzcvr;
        this.zzfbe = zzcyp;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
    }

    public final synchronized void onAdLoaded() {
        if (this.zzfbj) {
            ArrayList arrayList = new ArrayList(this.zzfbi.zzdbz);
            arrayList.addAll(this.zzfbi.zzgja);
            this.zzfbe.zza(this.zzfbd, this.zzfbi, true, (List<String>) arrayList);
        } else {
            this.zzfbe.zza(this.zzfbd, this.zzfbi, this.zzfbi.zzgjc);
            this.zzfbe.zza(this.zzfbd, this.zzfbi, this.zzfbi.zzgja);
        }
        this.zzfbj = true;
    }

    public final void onAdClicked() {
        zzcyp zzcyp = this.zzfbe;
        zzcvz zzcvz = this.zzfbd;
        zzcvr zzcvr = this.zzfbi;
        zzcyp.zza(zzcvz, zzcvr, zzcvr.zzdby);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfbk) {
            this.zzfbe.zza(this.zzfbd, this.zzfbi, this.zzfbi.zzdbz);
            this.zzfbk = true;
        }
    }

    public final void zzb(zzapy zzapy, String str, String str2) {
        zzcyp zzcyp = this.zzfbe;
        zzcvz zzcvz = this.zzfbd;
        zzcvr zzcvr = this.zzfbi;
        zzcyp.zza(zzcvz, zzcvr, zzcvr.zzdlg, zzapy);
    }

    public final void onRewardedVideoStarted() {
        zzcyp zzcyp = this.zzfbe;
        zzcvz zzcvz = this.zzfbd;
        zzcvr zzcvr = this.zzfbi;
        zzcyp.zza(zzcvz, zzcvr, zzcvr.zzdlf);
    }

    public final void onRewardedVideoCompleted() {
        zzcyp zzcyp = this.zzfbe;
        zzcvz zzcvz = this.zzfbd;
        zzcvr zzcvr = this.zzfbi;
        zzcyp.zza(zzcvz, zzcvr, zzcvr.zzgjb);
    }
}
