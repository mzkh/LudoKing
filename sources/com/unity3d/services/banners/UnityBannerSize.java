package com.unity3d.services.banners;

import android.content.Context;
import android.content.res.Resources;
import com.unity3d.services.core.misc.ViewUtilities;

public class UnityBannerSize {
    private int height;
    private int width;

    /* renamed from: com.unity3d.services.banners.UnityBannerSize$1 */
    static /* synthetic */ class C34251 {

        /* renamed from: $SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize */
        static final /* synthetic */ int[] f8093xd7cd7171 = new int[BannerSize.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.unity3d.services.banners.UnityBannerSize$BannerSize[] r0 = com.unity3d.services.banners.UnityBannerSize.BannerSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8093xd7cd7171 = r0
                int[] r0 = f8093xd7cd7171     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.unity3d.services.banners.UnityBannerSize$BannerSize r1 = com.unity3d.services.banners.UnityBannerSize.BannerSize.BANNER_SIZE_STANDARD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8093xd7cd7171     // Catch:{ NoSuchFieldError -> 0x001f }
                com.unity3d.services.banners.UnityBannerSize$BannerSize r1 = com.unity3d.services.banners.UnityBannerSize.BannerSize.BANNER_SIZE_LEADERBOARD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f8093xd7cd7171     // Catch:{ NoSuchFieldError -> 0x002a }
                com.unity3d.services.banners.UnityBannerSize$BannerSize r1 = com.unity3d.services.banners.UnityBannerSize.BannerSize.BANNER_SIZE_IAB_STANDARD     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.banners.UnityBannerSize.C34251.<clinit>():void");
        }
    }

    private enum BannerSize {
        BANNER_SIZE_STANDARD,
        BANNER_SIZE_LEADERBOARD,
        BANNER_SIZE_IAB_STANDARD,
        BANNER_SIZE_DYNAMIC;
        
        private static final int IAB_STANDARD_HEIGHT = 60;
        private static final int IAB_STANDARD_WIDTH = 468;
        private static final int LEADERBOARD_HEIGHT = 90;
        private static final int LEADERBOARD_WIDTH = 728;
        private static final int STANDARD_HEIGHT = 50;
        private static final int STANDARD_WIDTH = 320;

        private BannerSize getNonDynamicSize(Context context) {
            if (this != BANNER_SIZE_DYNAMIC) {
                return this;
            }
            int round = Math.round(ViewUtilities.dpFromPx(context, (float) Resources.getSystem().getDisplayMetrics().widthPixels));
            if (round >= LEADERBOARD_WIDTH) {
                return BANNER_SIZE_LEADERBOARD;
            }
            if (round >= IAB_STANDARD_WIDTH) {
                return BANNER_SIZE_IAB_STANDARD;
            }
            return BANNER_SIZE_STANDARD;
        }

        /* access modifiers changed from: private */
        public int getWidth(Context context) {
            int i = C34251.f8093xd7cd7171[getNonDynamicSize(context).ordinal()];
            if (i == 1) {
                return STANDARD_WIDTH;
            }
            if (i != 2) {
                return i != 3 ? STANDARD_WIDTH : IAB_STANDARD_WIDTH;
            }
            return LEADERBOARD_WIDTH;
        }

        /* access modifiers changed from: private */
        public int getHeight(Context context) {
            int i = C34251.f8093xd7cd7171[getNonDynamicSize(context).ordinal()];
            if (i == 1) {
                return 50;
            }
            if (i != 2) {
                return i != 3 ? 50 : 60;
            }
            return 90;
        }
    }

    public UnityBannerSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public static UnityBannerSize getDynamicSize(Context context) {
        return new UnityBannerSize(BannerSize.BANNER_SIZE_DYNAMIC.getWidth(context), BannerSize.BANNER_SIZE_DYNAMIC.getHeight(context));
    }
}
