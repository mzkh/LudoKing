package com.google.ads.mediation.inmobi;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.inmobi.ads.InMobiNative;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class InMobiUnifiedNativeAdMapper extends UnifiedNativeAdMapper {
    /* access modifiers changed from: private */
    public final InMobiAdapter mInMobiAdapter;
    /* access modifiers changed from: private */
    public final InMobiNative mInMobiNative;
    private final boolean mIsOnlyURL;
    /* access modifiers changed from: private */
    public final MediationNativeListener mMediationNativeListener;

    public void recordImpression() {
    }

    public InMobiUnifiedNativeAdMapper(InMobiAdapter inMobiAdapter, InMobiNative inMobiNative, Boolean bool, MediationNativeListener mediationNativeListener) {
        this.mInMobiAdapter = inMobiAdapter;
        this.mInMobiNative = inMobiNative;
        this.mIsOnlyURL = bool.booleanValue();
        this.mMediationNativeListener = mediationNativeListener;
    }

    /* access modifiers changed from: 0000 */
    public void mapUnifiedNativeAd(final Context context) {
        String str = "price";
        String str2 = InMobiNetworkValues.RATING;
        String str3 = InMobiNetworkValues.LANDING_URL;
        try {
            if (this.mInMobiNative.getCustomAdContent() != null) {
                JSONObject customAdContent = this.mInMobiNative.getCustomAdContent();
                setHeadline((String) InMobiAdapterUtils.mandatoryChecking(this.mInMobiNative.getAdTitle(), "title"));
                setBody((String) InMobiAdapterUtils.mandatoryChecking(this.mInMobiNative.getAdDescription(), "description"));
                setCallToAction((String) InMobiAdapterUtils.mandatoryChecking(this.mInMobiNative.getAdCtaText(), InMobiNetworkValues.CTA));
                String str4 = (String) InMobiAdapterUtils.mandatoryChecking(this.mInMobiNative.getAdLandingPageUrl(), str3);
                Bundle bundle = new Bundle();
                bundle.putString(str3, str4);
                setExtras(bundle);
                HashMap hashMap = new HashMap();
                URL url = new URL(this.mInMobiNative.getAdIconUrl());
                final Uri parse = Uri.parse(url.toURI().toString());
                final Double valueOf = Double.valueOf(1.0d);
                if (!this.mIsOnlyURL) {
                    hashMap.put("icon_key", url);
                } else {
                    setIcon(new InMobiNativeMappedImage(null, parse, valueOf.doubleValue()));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new InMobiNativeMappedImage(new ColorDrawable(0), null, 1.0d));
                    setImages(arrayList);
                }
                try {
                    if (customAdContent.has(str2)) {
                        setStarRating(Double.valueOf(Double.parseDouble(customAdContent.getString(str2))));
                    }
                    if (customAdContent.has(InMobiNetworkValues.PACKAGE_NAME)) {
                        setStore("Google Play");
                    } else {
                        setStore("Others");
                    }
                    if (customAdContent.has(str)) {
                        setPrice(customAdContent.getString(str));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
                ViewTreeObserver viewTreeObserver = relativeLayout.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (VERSION.SDK_INT >= 16) {
                                relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            } else {
                                relativeLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            }
                            int width = ((View) relativeLayout.getParent()).getWidth();
                            String str = InMobiMediationAdapter.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("parent layout width is ");
                            sb.append(width);
                            Log.d(str, sb.toString());
                            View primaryViewOfWidth = InMobiUnifiedNativeAdMapper.this.mInMobiNative.getPrimaryViewOfWidth(context, null, relativeLayout, width);
                            primaryViewOfWidth.measure(0, 0);
                            if (primaryViewOfWidth != null) {
                                relativeLayout.addView(primaryViewOfWidth);
                                int measuredHeight = primaryViewOfWidth.getMeasuredHeight();
                                if (measuredHeight > 0) {
                                    InMobiUnifiedNativeAdMapper.this.setMediaContentAspectRatio((float) (primaryViewOfWidth.getMeasuredWidth() / measuredHeight));
                                }
                            }
                        }
                    });
                }
                setMediaView(relativeLayout);
                setHasVideoContent(this.mInMobiNative.isVideo() == null ? false : this.mInMobiNative.isVideo().booleanValue());
                setOverrideClickHandling(false);
                if (!this.mIsOnlyURL) {
                    new ImageDownloaderAsyncTask(new DrawableDownloadListener() {
                        public void onDownloadSuccess(HashMap<String, Drawable> hashMap) {
                            Drawable drawable = (Drawable) hashMap.get("icon_key");
                            InMobiUnifiedNativeAdMapper.this.setIcon(new InMobiNativeMappedImage(drawable, parse, valueOf.doubleValue()));
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new InMobiNativeMappedImage(new ColorDrawable(0), null, 1.0d));
                            InMobiUnifiedNativeAdMapper.this.setImages(arrayList);
                            if (drawable != null) {
                                InMobiUnifiedNativeAdMapper.this.mMediationNativeListener.onAdLoaded((MediationNativeAdapter) InMobiUnifiedNativeAdMapper.this.mInMobiAdapter, (UnifiedNativeAdMapper) InMobiUnifiedNativeAdMapper.this);
                            } else {
                                InMobiUnifiedNativeAdMapper.this.mMediationNativeListener.onAdFailedToLoad(InMobiUnifiedNativeAdMapper.this.mInMobiAdapter, 2);
                            }
                        }

                        public void onDownloadFailure() {
                            InMobiUnifiedNativeAdMapper.this.mMediationNativeListener.onAdFailedToLoad(InMobiUnifiedNativeAdMapper.this.mInMobiAdapter, 3);
                        }
                    }).execute(new Object[]{hashMap});
                } else {
                    this.mMediationNativeListener.onAdLoaded((MediationNativeAdapter) this.mInMobiAdapter, (UnifiedNativeAdMapper) this);
                }
                return;
            }
            this.mMediationNativeListener.onAdFailedToLoad(this.mInMobiAdapter, 3);
        } catch (MandatoryParamException | MalformedURLException | URISyntaxException e2) {
            e2.printStackTrace();
            this.mMediationNativeListener.onAdFailedToLoad(this.mInMobiAdapter, 3);
        }
    }

    public void handleClick(View view) {
        this.mInMobiNative.reportAdClickAndOpenLandingPage();
    }

    public void untrackView(View view) {
        this.mInMobiNative.destroy();
    }
}
