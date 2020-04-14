package com.google.android.gms.ads;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.nearby.messages.Strategy;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(Strategy.TTL_SECONDS_DEFAULT, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize zzabc = new AdSize(50, 50, "50x50_mb");
    private final int height;
    private final int width;
    private final String zzabd;
    private boolean zzabe;

    public AdSize(int i, int i2) {
        String str;
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        if (i2 == -2) {
            str = "AUTO";
        } else {
            str = String.valueOf(i2);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append("x");
        sb.append(str);
        sb.append("_as");
        this(i, i2, sb.toString());
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.width = i;
            this.height = i2;
            this.zzabd = str;
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static AdSize getPortraitBannerAdSizeWithWidth(Context context, int i) {
        AdSize zza = zzawy.zza(context, i, 50, 1);
        zza.zzabe = true;
        return zza;
    }

    public static AdSize getLandscapeBannerAdSizeWithWidth(Context context, int i) {
        AdSize zza = zzawy.zza(context, i, 50, 2);
        zza.zzabe = true;
        return zza;
    }

    public static AdSize getCurrentOrientationBannerAdSizeWithWidth(Context context, int i) {
        AdSize zza = zzawy.zza(context, i, 50, 0);
        zza.zzabe = true;
        return zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.width == adSize.width && this.height == adSize.height && this.zzabd.equals(adSize.zzabd);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHeightInPixels(Context context) {
        int i = this.height;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzua.zzc(context.getResources().getDisplayMetrics());
        }
        zzuv.zzoj();
        return zzawy.zza(context, this.height);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.width;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -1) {
            return zzua.zzb(context.getResources().getDisplayMetrics());
        }
        zzuv.zzoj();
        return zzawy.zza(context, this.width);
    }

    public final int hashCode() {
        return this.zzabd.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.height == -2;
    }

    public final boolean isFullWidth() {
        return this.width == -1;
    }

    public final boolean isFluid() {
        return this.width == -3 && this.height == -4;
    }

    public final boolean zzdc() {
        return this.zzabe;
    }

    public final String toString() {
        return this.zzabd;
    }
}
