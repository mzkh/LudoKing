package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C1773R;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzuh {
    private final String zzbqy;
    private final AdSize[] zzcdc;

    private static AdSize[] zzbx(String str) {
        int i;
        int i2;
        String[] split = str.split("\\s*,\\s*");
        AdSize[] adSizeArr = new AdSize[split.length];
        int i3 = 0;
        while (true) {
            String str2 = "Could not parse XML attribute \"adSize\": ";
            if (i3 < split.length) {
                String trim = split[i3].trim();
                if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                    String[] split2 = trim.split("[xX]");
                    split2[0] = split2[0].trim();
                    split2[1] = split2[1].trim();
                    try {
                        if ("FULL_WIDTH".equals(split2[0])) {
                            i = -1;
                        } else {
                            i = Integer.parseInt(split2[0]);
                        }
                        if ("AUTO_HEIGHT".equals(split2[1])) {
                            i2 = -2;
                        } else {
                            i2 = Integer.parseInt(split2[1]);
                        }
                        adSizeArr[i3] = new AdSize(i, i2);
                    } catch (NumberFormatException unused) {
                        String valueOf = String.valueOf(trim);
                        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    }
                } else if ("BANNER".equals(trim)) {
                    adSizeArr[i3] = AdSize.BANNER;
                } else if ("LARGE_BANNER".equals(trim)) {
                    adSizeArr[i3] = AdSize.LARGE_BANNER;
                } else if ("FULL_BANNER".equals(trim)) {
                    adSizeArr[i3] = AdSize.FULL_BANNER;
                } else if ("LEADERBOARD".equals(trim)) {
                    adSizeArr[i3] = AdSize.LEADERBOARD;
                } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                    adSizeArr[i3] = AdSize.MEDIUM_RECTANGLE;
                } else if ("SMART_BANNER".equals(trim)) {
                    adSizeArr[i3] = AdSize.SMART_BANNER;
                } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                    adSizeArr[i3] = AdSize.WIDE_SKYSCRAPER;
                } else if ("FLUID".equals(trim)) {
                    adSizeArr[i3] = AdSize.FLUID;
                } else if ("ICON".equals(trim)) {
                    adSizeArr[i3] = AdSize.zzabc;
                } else {
                    String valueOf2 = String.valueOf(trim);
                    throw new IllegalArgumentException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                }
                i3++;
            } else if (adSizeArr.length != 0) {
                return adSizeArr;
            } else {
                String valueOf3 = String.valueOf(str);
                throw new IllegalArgumentException(valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
            }
        }
    }

    public zzuh(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1773R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(C1773R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C1773R.styleable.AdsAttrs_adSizes);
        boolean z = !TextUtils.isEmpty(string);
        boolean z2 = !TextUtils.isEmpty(string2);
        if (z && !z2) {
            this.zzcdc = zzbx(string);
        } else if (!z && z2) {
            this.zzcdc = zzbx(string2);
        } else if (z) {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.zzbqy = obtainAttributes.getString(C1773R.styleable.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.zzbqy)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    public final AdSize[] zzr(boolean z) {
        if (z || this.zzcdc.length == 1) {
            return this.zzcdc;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }

    public final String getAdUnitId() {
        return this.zzbqy;
    }
}
