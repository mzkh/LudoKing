package com.google.unity.ads;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Banner {
    /* access modifiers changed from: private */
    public AdView mAdView;
    /* access modifiers changed from: private */
    public boolean mHidden;
    /* access modifiers changed from: private */
    public int mHorizontalOffset;
    private OnLayoutChangeListener mLayoutChangeListener;
    /* access modifiers changed from: private */
    public int mPositionCode;
    /* access modifiers changed from: private */
    public UnityAdListener mUnityListener;
    /* access modifiers changed from: private */
    public Activity mUnityPlayerActivity;
    /* access modifiers changed from: private */
    public int mVerticalOffset;

    private static class Insets {
        int bottom;
        int left;
        int right;
        int top;

        private Insets() {
            this.top = 0;
            this.bottom = 0;
            this.left = 0;
            this.right = 0;
        }
    }

    public Banner(Activity activity, UnityAdListener unityAdListener) {
        this.mUnityPlayerActivity = activity;
        this.mUnityListener = unityAdListener;
    }

    public void create(final String str, final AdSize adSize, final int i) {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Banner.this.createAdView(str, adSize);
                Banner.this.mHorizontalOffset = 0;
                Banner.this.mVerticalOffset = 0;
                Banner.this.mPositionCode = i;
                Banner.this.mHidden = false;
            }
        });
    }

    public void create(String str, AdSize adSize, int i, int i2) {
        Activity activity = this.mUnityPlayerActivity;
        final String str2 = str;
        final AdSize adSize2 = adSize;
        final int i3 = i;
        final int i4 = i2;
        C19412 r1 = new Runnable() {
            public void run() {
                Banner.this.createAdView(str2, adSize2);
                Banner.this.mPositionCode = -1;
                Banner.this.mHorizontalOffset = i3;
                Banner.this.mVerticalOffset = i4;
                Banner.this.mHidden = false;
            }
        };
        activity.runOnUiThread(r1);
    }

    /* access modifiers changed from: private */
    public void createAdView(String str, AdSize adSize) {
        this.mAdView = new AdView(this.mUnityPlayerActivity);
        this.mAdView.setBackgroundColor(0);
        this.mAdView.setAdUnitId(str);
        this.mAdView.setAdSize(adSize);
        this.mAdView.setVisibility(8);
        this.mUnityPlayerActivity.addContentView(this.mAdView, getLayoutParams());
        this.mAdView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                if (Banner.this.mUnityListener != null) {
                    if (!Banner.this.mHidden) {
                        Banner.this.show();
                    }
                    new Thread(new Runnable() {
                        public void run() {
                            if (Banner.this.mUnityListener != null) {
                                Banner.this.mUnityListener.onAdLoaded();
                            }
                        }
                    }).start();
                }
            }

            public void onAdFailedToLoad(final int i) {
                if (Banner.this.mUnityListener != null) {
                    new Thread(new Runnable() {
                        public void run() {
                            if (Banner.this.mUnityListener != null) {
                                Banner.this.mUnityListener.onAdFailedToLoad(PluginUtils.getErrorReason(i));
                            }
                        }
                    }).start();
                }
            }

            public void onAdOpened() {
                if (Banner.this.mUnityListener != null) {
                    new Thread(new Runnable() {
                        public void run() {
                            if (Banner.this.mUnityListener != null) {
                                Banner.this.mUnityListener.onAdOpened();
                            }
                        }
                    }).start();
                }
            }

            public void onAdClosed() {
                if (Banner.this.mUnityListener != null) {
                    new Thread(new Runnable() {
                        public void run() {
                            if (Banner.this.mUnityListener != null) {
                                Banner.this.mUnityListener.onAdClosed();
                            }
                        }
                    }).start();
                }
            }

            public void onAdLeftApplication() {
                if (Banner.this.mUnityListener != null) {
                    new Thread(new Runnable() {
                        public void run() {
                            if (Banner.this.mUnityListener != null) {
                                Banner.this.mUnityListener.onAdLeftApplication();
                            }
                        }
                    }).start();
                }
            }
        });
        this.mLayoutChangeListener = new OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (((i == i5 && i3 == i7 && i4 == i8 && i2 == i6) ? false : true) && !Banner.this.mHidden) {
                    Banner.this.updatePosition();
                }
            }
        };
        this.mUnityPlayerActivity.getWindow().getDecorView().getRootView().addOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    public void loadAd(final AdRequest adRequest) {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling loadAd() on Android");
                Banner.this.mAdView.loadAd(adRequest);
            }
        });
    }

    public void show() {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling show() on Android");
                Banner.this.mHidden = false;
                Banner.this.mAdView.setVisibility(0);
                Banner.this.updatePosition();
                Banner.this.mAdView.resume();
            }
        });
    }

    public void hide() {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling hide() on Android");
                Banner.this.mHidden = true;
                Banner.this.mAdView.setVisibility(8);
                Banner.this.mAdView.pause();
            }
        });
    }

    public void destroy() {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling destroy() on Android");
                if (Banner.this.mAdView != null) {
                    Banner.this.mAdView.destroy();
                    ViewParent parent = Banner.this.mAdView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(Banner.this.mAdView);
                    }
                }
            }
        });
        this.mUnityPlayerActivity.getWindow().getDecorView().getRootView().removeOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    public float getHeightInPixels() {
        String str = "Failed to get ad view height: %s";
        String str2 = PluginUtils.LOGTAG;
        FutureTask futureTask = new FutureTask(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Integer.valueOf(Banner.this.mAdView.getAdSize().getHeightInPixels(Banner.this.mUnityPlayerActivity));
            }
        });
        this.mUnityPlayerActivity.runOnUiThread(futureTask);
        try {
            return (float) ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e) {
            Log.e(str2, String.format(str, new Object[]{e.getLocalizedMessage()}));
            return -1.0f;
        } catch (ExecutionException e2) {
            Log.e(str2, String.format(str, new Object[]{e2.getLocalizedMessage()}));
            return -1.0f;
        }
    }

    public float getWidthInPixels() {
        String str = "Failed to get ad view width: %s";
        String str2 = PluginUtils.LOGTAG;
        FutureTask futureTask = new FutureTask(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Integer.valueOf(Banner.this.mAdView.getAdSize().getWidthInPixels(Banner.this.mUnityPlayerActivity));
            }
        });
        this.mUnityPlayerActivity.runOnUiThread(futureTask);
        try {
            return (float) ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e) {
            Log.e(str2, String.format(str, new Object[]{e.getLocalizedMessage()}));
            return -1.0f;
        } catch (ExecutionException e2) {
            Log.e(str2, String.format(str, new Object[]{e2.getLocalizedMessage()}));
            return -1.0f;
        }
    }

    public void setPosition(final int i) {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Banner.this.mPositionCode = i;
                Banner.this.updatePosition();
            }
        });
    }

    public void setPosition(final int i, final int i2) {
        this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
            public void run() {
                Banner.this.mPositionCode = -1;
                Banner.this.mHorizontalOffset = i;
                Banner.this.mVerticalOffset = i2;
                Banner.this.updatePosition();
            }
        });
    }

    /* access modifiers changed from: private */
    public LayoutParams getLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = PluginUtils.getLayoutGravityForPositionCode(this.mPositionCode);
        Insets safeInsets = getSafeInsets();
        int i = safeInsets.left;
        int i2 = safeInsets.top;
        layoutParams.bottomMargin = safeInsets.bottom;
        layoutParams.rightMargin = safeInsets.right;
        int i3 = this.mPositionCode;
        if (i3 == -1) {
            int convertDpToPixel = (int) PluginUtils.convertDpToPixel((float) this.mHorizontalOffset);
            if (convertDpToPixel < i) {
                convertDpToPixel = i;
            }
            int convertDpToPixel2 = (int) PluginUtils.convertDpToPixel((float) this.mVerticalOffset);
            if (convertDpToPixel2 < i2) {
                convertDpToPixel2 = i2;
            }
            layoutParams.leftMargin = convertDpToPixel;
            layoutParams.topMargin = convertDpToPixel2;
        } else {
            layoutParams.leftMargin = i;
            if (i3 == 0 || i3 == 2 || i3 == 3) {
                layoutParams.topMargin = i2;
            }
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public void updatePosition() {
        if (this.mAdView != null && !this.mHidden) {
            this.mUnityPlayerActivity.runOnUiThread(new Runnable() {
                public void run() {
                    Banner.this.mAdView.setLayoutParams(Banner.this.getLayoutParams());
                }
            });
        }
    }

    private Insets getSafeInsets() {
        Insets insets = new Insets();
        if (VERSION.SDK_INT < 28) {
            return insets;
        }
        Window window = this.mUnityPlayerActivity.getWindow();
        if (window == null) {
            return insets;
        }
        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        if (rootWindowInsets == null) {
            return insets;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        if (displayCutout == null) {
            return insets;
        }
        insets.top = displayCutout.getSafeInsetTop();
        insets.left = displayCutout.getSafeInsetLeft();
        insets.bottom = displayCutout.getSafeInsetBottom();
        insets.right = displayCutout.getSafeInsetRight();
        return insets;
    }

    public String getMediationAdapterClassName() {
        AdView adView = this.mAdView;
        if (adView != null) {
            return adView.getMediationAdapterClassName();
        }
        return null;
    }
}
