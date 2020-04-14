package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class zzuu extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcdn;

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcdn = adListener;
        }
    }

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzcdn != null) {
                this.zzcdn.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzcdn != null) {
                this.zzcdn.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzcdn != null) {
                this.zzcdn.onAdLeftApplication();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzcdn != null) {
                this.zzcdn.onAdOpened();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzcdn != null) {
                this.zzcdn.onAdLoaded();
            }
        }
    }
}
