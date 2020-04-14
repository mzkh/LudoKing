package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AdView.AdViewLoadConfigBuilder;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadConfigBuilder;
import com.facebook.ads.InterstitialAd.InterstitialAdLoadConfigBuilder;
import com.facebook.ads.InterstitialAd.InterstitialLoadAdConfig;
import com.facebook.ads.NativeAdBase.MediaCacheFlag;
import com.facebook.ads.NativeAdBase.NativeAdLoadConfigBuilder;
import com.facebook.ads.NativeAdBase.NativeLoadAdConfig;
import com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder;
import com.facebook.ads.RewardedVideoAd.RewardedVideoLoadAdConfig;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
class DynamicLoaderFallback {
    /* access modifiers changed from: private */
    public static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    private static class SimpleMethodCaptor {
        private final InvocationHandler mInvocationHandler;
        /* access modifiers changed from: private */
        @Nullable
        public Method mLastInvokedMethod;

        private SimpleMethodCaptor() {
            this.mInvocationHandler = new InvocationHandler() {
                @Nullable
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (!"toString".equals(method.getName())) {
                        SimpleMethodCaptor.this.mLastInvokedMethod = method;
                    }
                    return null;
                }
            };
        }

        public <T> T mock(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.mInvocationHandler));
        }

        /* access modifiers changed from: 0000 */
        @Nullable
        public Method getLastMethod() {
            return this.mLastInvokedMethod;
        }
    }

    DynamicLoaderFallback() {
    }

    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    static DynamicLoader makeFallbackLoader() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        final ArrayList arrayList6 = new ArrayList();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        SimpleMethodCaptor simpleMethodCaptor = new SimpleMethodCaptor();
        DynamicLoader dynamicLoader = (DynamicLoader) simpleMethodCaptor.mock(DynamicLoader.class);
        dynamicLoader.createInterstitialAd(null, null, null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createRewardedVideoAd(null, null, null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createInstreamVideoAdViewApi(null, null, null, null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createNativeAdApi(null, null);
        Method lastMethod = simpleMethodCaptor.getLastMethod();
        dynamicLoader.createNativeBannerAdApi(null, null);
        Method lastMethod2 = simpleMethodCaptor.getLastMethod();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) simpleMethodCaptor.mock(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAd((NativeLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAd((MediaCacheFlag) null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAdFromBid(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAdFromBid(null, null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.buildLoadAdConfig(null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.setAdListener(null, null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) simpleMethodCaptor.mock(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAd(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAd((InterstitialLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAdFromBid(null, null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) simpleMethodCaptor.mock(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAd((RewardedVideoLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAd(false);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAdFromBid(null, false);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        InstreamVideoAdViewApi instreamVideoAdViewApi = (InstreamVideoAdViewApi) simpleMethodCaptor.mock(InstreamVideoAdViewApi.class);
        instreamVideoAdViewApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.loadAdFromBid(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        AdViewApi adViewApi = (AdViewApi) simpleMethodCaptor.mock(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        adViewApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        adViewApi.loadAdFromBid(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        adViewApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        adViewApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        ((AdViewLoadConfigBuilder) simpleMethodCaptor.mock(AdViewLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        NativeAdLoadConfigBuilder nativeAdLoadConfigBuilder = (NativeAdLoadConfigBuilder) simpleMethodCaptor.mock(NativeAdLoadConfigBuilder.class);
        nativeAdLoadConfigBuilder.withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((InterstitialAdLoadConfigBuilder) simpleMethodCaptor.mock(InterstitialAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((RewardedVideoAdLoadConfigBuilder) simpleMethodCaptor.mock(RewardedVideoAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((InstreamVideoLoadConfigBuilder) simpleMethodCaptor.mock(InstreamVideoLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        nativeAdLoadConfigBuilder.loadAd();
        final Method lastMethod3 = simpleMethodCaptor.getLastMethod();
        final Method method = lastMethod;
        final Method method2 = lastMethod2;
        C14421 r0 = new InvocationHandler() {
            @Nullable
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Object obj2;
                if (method.getReturnType().isPrimitive()) {
                    if (!method.getReturnType().equals(Void.TYPE)) {
                        return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                    }
                    Iterator it = arrayList3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (DynamicLoaderFallback.equalsMethods(method, (Method) it.next())) {
                                DynamicLoaderFallback.sApiProxyToAdListenersMap.put(obj, objArr[0]);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it2.next()) || !DynamicLoaderFallback.reportError(obj, hashMap))) {
                    }
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it3.next()) || !DynamicLoaderFallback.reportError(obj, hashMap))) {
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, lastMethod3)) {
                        DynamicLoaderFallback.reportError(hashMap2.get(obj), hashMap);
                    }
                    return null;
                } else if (method.getReturnType().equals(String.class)) {
                    return "";
                } else {
                    if (method.getReturnType().equals(obj.getClass().getInterfaces()[0])) {
                        obj2 = obj;
                    } else {
                        obj2 = Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
                    }
                    Iterator it4 = arrayList4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (DynamicLoaderFallback.equalsMethods(method, (Method) it4.next())) {
                                DynamicLoaderFallback.sApiProxyToAdListenersMap.put(hashMap2.get(obj), objArr[0]);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    for (Method access$100 : arrayList5) {
                        if (DynamicLoaderFallback.equalsMethods(method, access$100)) {
                            hashMap2.put(obj2, obj);
                        }
                    }
                    for (Method access$1002 : arrayList6) {
                        if (DynamicLoaderFallback.equalsMethods(method, access$1002)) {
                            for (C1431Ad ad : objArr) {
                                if (ad instanceof C1431Ad) {
                                    hashMap.put(obj2, ad);
                                }
                            }
                        }
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, method)) {
                        hashMap.put(objArr[1], objArr[0]);
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, method2)) {
                        hashMap.put(objArr[1], objArr[0]);
                    }
                    return obj2;
                }
            }
        };
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{DynamicLoader.class}, r0);
    }

    /* access modifiers changed from: private */
    public static boolean reportError(@Nullable Object obj, Map<Object, C1431Ad> map) {
        if (obj == null) {
            return false;
        }
        final AdListener adListener = (AdListener) sApiProxyToAdListenersMap.get(obj);
        final C1431Ad ad = (C1431Ad) map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                adListener.onError(ad, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
            }
        }, 500);
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }
}
