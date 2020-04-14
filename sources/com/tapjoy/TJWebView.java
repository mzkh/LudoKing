package com.tapjoy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.webkit.WebView;

public class TJWebView extends WebView {

    /* renamed from: a */
    private int f6438a;

    /* renamed from: com.tapjoy.TJWebView$a */
    class C2835a extends SimpleOnGestureListener {
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        C2835a() {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public TJWebView(Context context) {
        super(context);
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        new GestureDetector(new C2835a());
        if (getSettings() != null) {
            getSettings().setJavaScriptEnabled(true);
            if (VERSION.SDK_INT >= 17) {
                getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
        }
        setBackgroundColor(0);
    }

    public void setBackgroundColor(int i) {
        this.f6438a = i;
        super.setBackgroundColor(i);
    }

    public int getBackgroundColor() {
        return this.f6438a;
    }

    public TJWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
