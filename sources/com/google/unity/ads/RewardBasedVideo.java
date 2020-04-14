package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardBasedVideo {
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public UnityRewardBasedVideoAdListener adListener;
    /* access modifiers changed from: private */
    public boolean isLoaded = false;
    /* access modifiers changed from: private */
    public RewardedVideoAd rewardBasedVideo;

    public void destroy() {
    }

    public RewardBasedVideo(Activity activity2, UnityRewardBasedVideoAdListener unityRewardBasedVideoAdListener) {
        this.activity = activity2;
        this.adListener = unityRewardBasedVideoAdListener;
    }

    public void create() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                RewardBasedVideo rewardBasedVideo = RewardBasedVideo.this;
                rewardBasedVideo.rewardBasedVideo = MobileAds.getRewardedVideoAdInstance(rewardBasedVideo.activity);
                RewardBasedVideo.this.rewardBasedVideo.setRewardedVideoAdListener(new RewardedVideoAdListener() {
                    public void onRewardedVideoAdLoaded() {
                        RewardBasedVideo.this.isLoaded = true;
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdLoaded();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedVideoAdFailedToLoad(final int i) {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdFailedToLoad(PluginUtils.getErrorReason(i));
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedVideoAdOpened() {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdOpened();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedVideoStarted() {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdStarted();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedVideoAdClosed() {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdClosed();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewarded(final RewardItem rewardItem) {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdRewarded(rewardItem.getType(), (float) rewardItem.getAmount());
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedVideoAdLeftApplication() {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdLeftApplication();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedVideoCompleted() {
                        if (RewardBasedVideo.this.adListener != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (RewardBasedVideo.this.adListener != null) {
                                        RewardBasedVideo.this.adListener.onAdCompleted();
                                    }
                                }
                            }).start();
                        }
                    }
                });
            }
        });
    }

    public void loadAd(final AdRequest adRequest, final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                RewardBasedVideo.this.rewardBasedVideo.loadAd(str, adRequest);
            }
        });
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void setUserId(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                RewardBasedVideo.this.rewardBasedVideo.setUserId(str);
            }
        });
    }

    public void show() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                if (RewardBasedVideo.this.rewardBasedVideo.isLoaded()) {
                    RewardBasedVideo.this.isLoaded = false;
                    RewardBasedVideo.this.rewardBasedVideo.show();
                    return;
                }
                Log.w(PluginUtils.LOGTAG, "Reward based video ad is not ready to be shown.");
            }
        });
    }

    public String getMediationAdapterClassName() {
        RewardedVideoAd rewardedVideoAd = this.rewardBasedVideo;
        if (rewardedVideoAd != null) {
            return rewardedVideoAd.getMediationAdapterClassName();
        }
        return null;
    }
}
