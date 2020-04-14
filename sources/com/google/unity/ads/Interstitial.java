package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Interstitial {
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public UnityAdListener adListener;
    /* access modifiers changed from: private */
    public InterstitialAd interstitial;
    /* access modifiers changed from: private */
    public boolean isLoaded = false;

    public void destroy() {
    }

    public Interstitial(Activity activity2, UnityAdListener unityAdListener) {
        this.activity = activity2;
        this.adListener = unityAdListener;
    }

    public void create(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                Interstitial interstitial = Interstitial.this;
                interstitial.interstitial = new InterstitialAd(interstitial.activity);
                Interstitial.this.interstitial.setAdUnitId(str);
                Interstitial.this.interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        Interstitial.this.isLoaded = true;
                        if (Interstitial.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (Interstitial.this.adListener != null) {
                                        Interstitial.this.adListener.onAdLoaded();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onAdFailedToLoad(final int i) {
                        if (Interstitial.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (Interstitial.this.adListener != null) {
                                        Interstitial.this.adListener.onAdFailedToLoad(PluginUtils.getErrorReason(i));
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onAdOpened() {
                        if (Interstitial.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (Interstitial.this.adListener != null) {
                                        Interstitial.this.adListener.onAdOpened();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onAdClosed() {
                        if (Interstitial.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (Interstitial.this.adListener != null) {
                                        Interstitial.this.adListener.onAdClosed();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onAdLeftApplication() {
                        if (Interstitial.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (Interstitial.this.adListener != null) {
                                        Interstitial.this.adListener.onAdLeftApplication();
                                    }
                                }
                            }).start();
                        }
                    }
                });
            }
        });
    }

    public void loadAd(final AdRequest adRequest) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                Interstitial.this.interstitial.loadAd(adRequest);
            }
        });
    }

    public String getMediationAdapterClassName() {
        InterstitialAd interstitialAd = this.interstitial;
        if (interstitialAd != null) {
            return interstitialAd.getMediationAdapterClassName();
        }
        return null;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void show() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                if (Interstitial.this.interstitial.isLoaded()) {
                    Interstitial.this.isLoaded = false;
                    Interstitial.this.interstitial.show();
                    return;
                }
                Log.d(PluginUtils.LOGTAG, "Interstitial was not ready to be shown.");
            }
        });
    }
}
