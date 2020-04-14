package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaai extends zzaag {
    private final OnCustomRenderedAdLoadedListener zzcep;

    public zzaai(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcep = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzaac zzaac) {
        this.zzcep.onCustomRenderedAdLoaded(new zzaad(zzaac));
    }
}
