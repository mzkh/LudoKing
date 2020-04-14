package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UnityRewardedAd {
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public UnityRewardedAdCallback callback;
    /* access modifiers changed from: private */
    public RewardedAd rewardedAd;

    public UnityRewardedAd(Activity activity2, UnityRewardedAdCallback unityRewardedAdCallback) {
        this.activity = activity2;
        this.callback = unityRewardedAdCallback;
    }

    public void create(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityRewardedAd unityRewardedAd = UnityRewardedAd.this;
                unityRewardedAd.rewardedAd = new RewardedAd(unityRewardedAd.activity, str);
            }
        });
    }

    public void loadAd(final AdRequest adRequest) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityRewardedAd.this.rewardedAd.loadAd(adRequest, (RewardedAdLoadCallback) new RewardedAdLoadCallback() {
                    public void onRewardedAdLoaded() {
                        if (UnityRewardedAd.this.callback != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (UnityRewardedAd.this.callback != null) {
                                        UnityRewardedAd.this.callback.onRewardedAdLoaded();
                                    }
                                }
                            }).start();
                        }
                    }

                    public void onRewardedAdFailedToLoad(final int i) {
                        if (UnityRewardedAd.this.callback != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    if (UnityRewardedAd.this.callback != null) {
                                        UnityRewardedAd.this.callback.onRewardedAdFailedToLoad(PluginUtils.getErrorReason(i));
                                    }
                                }
                            }).start();
                        }
                    }
                });
            }
        });
    }

    public boolean isLoaded() {
        String str = "Unable to check if rewarded as has loaded: %s";
        String str2 = PluginUtils.LOGTAG;
        FutureTask futureTask = new FutureTask(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(UnityRewardedAd.this.rewardedAd.isLoaded());
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return ((Boolean) futureTask.get()).booleanValue();
        } catch (InterruptedException e) {
            Log.e(str2, String.format(str, new Object[]{e.getLocalizedMessage()}));
            return false;
        } catch (ExecutionException e2) {
            Log.e(str2, String.format(str, new Object[]{e2.getLocalizedMessage()}));
            return false;
        }
    }

    public void show() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                if (UnityRewardedAd.this.rewardedAd.isLoaded()) {
                    UnityRewardedAd.this.rewardedAd.show(UnityRewardedAd.this.activity, new RewardedAdCallback() {
                        public void onRewardedAdOpened() {
                            if (UnityRewardedAd.this.callback != null) {
                                new Thread(new Runnable() {
                                    public void run() {
                                        if (UnityRewardedAd.this.callback != null) {
                                            UnityRewardedAd.this.callback.onRewardedAdOpened();
                                        }
                                    }
                                }).start();
                            }
                        }

                        public void onRewardedAdClosed() {
                            if (UnityRewardedAd.this.callback != null) {
                                new Thread(new Runnable() {
                                    public void run() {
                                        if (UnityRewardedAd.this.callback != null) {
                                            UnityRewardedAd.this.callback.onRewardedAdClosed();
                                        }
                                    }
                                }).start();
                            }
                        }

                        public void onUserEarnedReward(@NonNull final RewardItem rewardItem) {
                            if (UnityRewardedAd.this.callback != null) {
                                new Thread(new Runnable() {
                                    public void run() {
                                        if (UnityRewardedAd.this.callback != null) {
                                            UnityRewardedAd.this.callback.onUserEarnedReward(rewardItem.getType(), (float) rewardItem.getAmount());
                                        }
                                    }
                                }).start();
                            }
                        }

                        public void onRewardedAdFailedToShow(final int i) {
                            if (UnityRewardedAd.this.callback != null) {
                                new Thread(new Runnable() {
                                    public void run() {
                                        if (UnityRewardedAd.this.callback != null) {
                                            UnityRewardedAd.this.callback.onRewardedAdFailedToShow(PluginUtils.getErrorReason(i));
                                        }
                                    }
                                }).start();
                            }
                        }
                    });
                } else {
                    Log.w(PluginUtils.LOGTAG, "Rewarded ad is not ready to be shown.");
                }
            }
        });
    }

    public void setServerSideVerificationOptions(final ServerSideVerificationOptions serverSideVerificationOptions) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityRewardedAd.this.rewardedAd.setServerSideVerificationOptions(serverSideVerificationOptions);
            }
        });
    }

    public String getMediationAdapterClassName() {
        RewardedAd rewardedAd2 = this.rewardedAd;
        if (rewardedAd2 != null) {
            return rewardedAd2.getMediationAdapterClassName();
        }
        return null;
    }
}
