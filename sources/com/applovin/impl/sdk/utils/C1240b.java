package com.applovin.impl.sdk.utils;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinAdSize;

/* renamed from: com.applovin.impl.sdk.utils.b */
public class C1240b {
    /* renamed from: a */
    public static AppLovinAdSize m2915a(AttributeSet attributeSet) {
        AppLovinAdSize appLovinAdSize = null;
        if (attributeSet == null) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "size");
        if (C1277l.m3042b(attributeValue)) {
            appLovinAdSize = AppLovinAdSize.fromString(attributeValue);
        }
        return appLovinAdSize;
    }

    /* renamed from: a */
    public static void m2916a(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != view) {
                    viewGroup.removeView(childAt);
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m2917b(AttributeSet attributeSet) {
        return attributeSet != null && attributeSet.getAttributeBooleanValue(AppLovinAdView.NAMESPACE, "loadAdOnCreate", false);
    }
}
