package com.applovin.sdk;

import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdSize {
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(Strategy.TTL_SECONDS_DEFAULT, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "MREC");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize("NATIVE");
    public static final int SPAN = -1;

    /* renamed from: a */
    private final int f3271a;

    /* renamed from: b */
    private final int f3272b;

    /* renamed from: c */
    private final String f3273c;

    private AppLovinAdSize(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ad width must be a positive number. Number provided: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i > 9999) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ad width must be less then 9999. Number provided: ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 < 0 && i2 != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Ad height must be a positive number. Number provided: ");
            sb3.append(i2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (i2 > 9999) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Ad height must be less then 9999. Number provided: ");
            sb4.append(i2);
            throw new IllegalArgumentException(sb4.toString());
        } else if (str == null) {
            throw new IllegalArgumentException("No label specified");
        } else if (str.length() <= 9) {
            this.f3271a = i;
            this.f3272b = i2;
            this.f3273c = str;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Provided label is too long. Label provided: ");
            sb5.append(str);
            throw new IllegalArgumentException(sb5.toString());
        }
    }

    private AppLovinAdSize(String str) {
        this(0, 0, str);
    }

    public static Set<AppLovinAdSize> allSizes() {
        HashSet hashSet = new HashSet(4);
        hashSet.add(BANNER);
        hashSet.add(MREC);
        hashSet.add(INTERSTITIAL);
        hashSet.add(LEADER);
        return hashSet;
    }

    public static AppLovinAdSize fromString(String str) {
        if ("BANNER".equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown Ad Size: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public int getHeight() {
        return this.f3272b;
    }

    public String getLabel() {
        return this.f3273c.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f3271a;
    }

    public String toString() {
        return getLabel();
    }
}
