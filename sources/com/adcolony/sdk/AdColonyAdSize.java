package com.adcolony.sdk;

import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.android.gms.nearby.messages.Strategy;

public class AdColonyAdSize {
    public static final AdColonyAdSize BANNER = new AdColonyAdSize(320, 50);
    public static final AdColonyAdSize LEADERBOARD = new AdColonyAdSize(728, 90);
    public static final AdColonyAdSize MEDIUM_RECTANGLE = new AdColonyAdSize(Strategy.TTL_SECONDS_DEFAULT, Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    public static final AdColonyAdSize SKYSCRAPER = new AdColonyAdSize(160, 600);

    /* renamed from: a */
    int f68a;

    /* renamed from: b */
    int f69b;

    public AdColonyAdSize(int i, int i2) {
        this.f68a = i;
        this.f69b = i2;
    }

    public int getWidth() {
        return this.f68a;
    }

    public int getHeight() {
        return this.f69b;
    }
}
