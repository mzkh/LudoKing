package com.google.android.gms.ads.appopen;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzrg;
import com.google.android.gms.internal.ads.zzvl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class AppOpenAd {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static abstract class AppOpenAdLoadCallback {
        public void onAppOpenAdFailedToLoad(int i) {
        }

        public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface AppOpenAdOrientation {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzrc zzrc);

    /* access modifiers changed from: protected */
    public abstract zzvl zzdg();

    public static void load(Context context, String str, AdRequest adRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        zzrg zzrg = new zzrg(context, str, adRequest.zzdb(), i, appOpenAdLoadCallback);
        zzrg.zzmg();
    }

    public static void load(Context context, String str, PublisherAdRequest publisherAdRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(publisherAdRequest, "PublisherAdRequest cannot be null.");
        zzrg zzrg = new zzrg(context, str, publisherAdRequest.zzdb(), i, appOpenAdLoadCallback);
        zzrg.zzmg();
    }
}
