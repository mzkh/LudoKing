package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadp extends zzacl {
    private final OnAppInstallAdLoadedListener zzcwt;

    public zzadp(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzcwt = onAppInstallAdLoadedListener;
    }

    public final void zza(zzabw zzabw) {
        this.zzcwt.onAppInstallAdLoaded(new zzacb(zzabw));
    }
}
