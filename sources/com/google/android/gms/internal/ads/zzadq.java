package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadq extends zzacs {
    private final OnCustomTemplateAdLoadedListener zzcwu;

    public zzadq(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzcwu = onCustomTemplateAdLoadedListener;
    }

    public final void zzb(zzace zzace) {
        this.zzcwu.onCustomTemplateAdLoaded(zzacj.zza(zzace));
    }
}
