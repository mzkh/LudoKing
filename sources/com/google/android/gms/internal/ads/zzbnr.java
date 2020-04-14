package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbnr extends zzbpm<zzbna> {
    public zzbnr(Set<zzbqs<zzbna>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbnu.zzfgz);
    }

    public final void onAdLeftApplication() {
        zza(zzbnt.zzfgz);
    }

    public final void onAdOpened() {
        zza(zzbnw.zzfgz);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbnv.zzfgz);
    }

    public final void zzb(zzapy zzapy, String str, String str2) {
        zza((zzbpo<ListenerT>) new zzbny<ListenerT>(zzapy, str, str2));
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbnx.zzfgz);
    }
}
