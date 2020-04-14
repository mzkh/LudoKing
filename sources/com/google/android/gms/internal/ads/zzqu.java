package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzqu extends zzra {
    private final WeakReference<AppOpenAdLoadCallback> zzbqv;

    public zzqu(AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzbqv = new WeakReference<>(appOpenAdLoadCallback);
    }

    public final void zza(zzqw zzqw) {
        AppOpenAdLoadCallback appOpenAdLoadCallback = (AppOpenAdLoadCallback) this.zzbqv.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdLoaded(new zzrd(zzqw));
        }
    }

    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAdLoadCallback appOpenAdLoadCallback = (AppOpenAdLoadCallback) this.zzbqv.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }
}
