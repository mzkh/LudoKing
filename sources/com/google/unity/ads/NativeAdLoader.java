package com.google.unity.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

public class NativeAdLoader {
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public AdLoader mAdLoader;
    /* access modifiers changed from: private */
    public Builder mAdLoaderBuilder;
    /* access modifiers changed from: private */
    public UnityAdLoaderListener mListener;

    public NativeAdLoader(final Activity activity, final String str, UnityAdLoaderListener unityAdLoaderListener) {
        this.mActivity = activity;
        this.mListener = unityAdLoaderListener;
        activity.runOnUiThread(new Runnable() {
            public void run() {
                NativeAdLoader.this.mAdLoaderBuilder = new Builder((Context) activity, str);
            }
        });
    }

    public void create() {
        this.mActivity.runOnUiThread(new Runnable() {
            public void run() {
                NativeAdLoader nativeAdLoader = NativeAdLoader.this;
                nativeAdLoader.mAdLoader = nativeAdLoader.mAdLoaderBuilder.build();
            }
        });
    }

    public void configureCustomNativeTemplateAd(final String str, final boolean z) {
        this.mActivity.runOnUiThread(new Runnable() {
            public void run() {
                C19681 r0 = z ? new OnCustomClickListener() {
                    public void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
                        NativeAdLoader.this.mListener.onCustomClick(new CustomNativeAd(NativeAdLoader.this.mActivity, nativeCustomTemplateAd), str);
                    }
                } : null;
                NativeAdLoader nativeAdLoader = NativeAdLoader.this;
                nativeAdLoader.mAdLoaderBuilder = nativeAdLoader.mAdLoaderBuilder.forCustomTemplateAd(str, new OnCustomTemplateAdLoadedListener() {
                    public void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
                        NativeAdLoader.this.mListener.onCustomTemplateAdLoaded(new CustomNativeAd(NativeAdLoader.this.mActivity, nativeCustomTemplateAd));
                    }
                }, r0).withAdListener(new AdListener() {
                    public void onAdFailedToLoad(int i) {
                        NativeAdLoader.this.mListener.onAdFailedToLoad(PluginUtils.getErrorReason(i));
                    }
                });
            }
        });
    }

    public void loadAd(final AdRequest adRequest) {
        this.mActivity.runOnUiThread(new Runnable() {
            public void run() {
                NativeAdLoader.this.mAdLoader.loadAd(adRequest);
            }
        });
    }
}
