package com.unity3d.services.banners.api;

import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.banners.properties.BannerRefreshInfo;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Banner {

    /* renamed from: com.unity3d.services.banners.api.Banner$1 */
    static /* synthetic */ class C34321 {

        /* renamed from: $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType */
        static final /* synthetic */ int[] f8094xf0b64357 = new int[BannerViewType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.unity3d.services.banners.api.Banner$BannerViewType[] r0 = com.unity3d.services.banners.api.Banner.BannerViewType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8094xf0b64357 = r0
                int[] r0 = f8094xf0b64357     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.unity3d.services.banners.api.Banner$BannerViewType r1 = com.unity3d.services.banners.api.Banner.BannerViewType.WEB_PLAYER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8094xf0b64357     // Catch:{ NoSuchFieldError -> 0x001f }
                com.unity3d.services.banners.api.Banner$BannerViewType r1 = com.unity3d.services.banners.api.Banner.BannerViewType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.banners.api.Banner.C34321.<clinit>():void");
        }
    }

    private enum BannerViewType {
        WEB_PLAYER,
        UNKNOWN;

        public static BannerViewType fromString(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return UNKNOWN;
            }
        }
    }

    @WebViewExposed
    public static void load(String str, Integer num, Integer num2, String str2, WebViewCallback webViewCallback) {
        if (C34321.f8094xf0b64357[BannerViewType.fromString(str).ordinal()] == 1 && BannerViewCache.getInstance().loadWebPlayer(str2, new UnityBannerSize(num.intValue(), num2.intValue()))) {
            BannerBridge.didLoad(str2);
        }
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setRefreshRate(String str, Integer num, WebViewCallback webViewCallback) {
        if (!(str == null || num == null)) {
            BannerRefreshInfo.getInstance().setRefreshRate(str, num);
        }
        webViewCallback.invoke(new Object[0]);
    }
}
