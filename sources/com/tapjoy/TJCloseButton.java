package com.tapjoy;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import androidx.core.view.ViewCompat;

public class TJCloseButton extends ImageButton {

    /* renamed from: a */
    private static final String f6292a = "TJCloseButton";

    /* renamed from: b */
    private ClosePosition f6293b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f6294c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f6295d;

    public enum ClosePosition {
        TOP_LEFT(new int[]{10, 9}),
        TOP_CENTER(new int[]{10, 14}),
        TOP_RIGHT(new int[]{10, 11}),
        CENTER(new int[]{13}),
        BOTTOM_LEFT(new int[]{12, 9}),
        BOTTOM_CENTER(new int[]{12, 14}),
        BOTTOM_RIGHT(new int[]{12, 11});
        

        /* renamed from: a */
        final LayoutParams f6299a;

        private ClosePosition(int[] iArr) {
            this.f6299a = new LayoutParams(-2, -2);
            for (int addRule : iArr) {
                this.f6299a.addRule(addRule);
            }
            int deviceScreenDensityScale = (int) (TapjoyConnectCore.getDeviceScreenDensityScale() * -10.0f);
            this.f6299a.setMargins(0, deviceScreenDensityScale, deviceScreenDensityScale, 0);
        }
    }

    public TJCloseButton(Context context) {
        this(context, ClosePosition.TOP_RIGHT);
    }

    public TJCloseButton(Context context, ClosePosition closePosition) {
        super(context);
        this.f6294c = true;
        this.f6293b = closePosition;
        Bitmap loadBitmapFromJar = TapjoyUtil.loadBitmapFromJar("tj_close_button.png", context);
        if (loadBitmapFromJar == null) {
            try {
                loadBitmapFromJar = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("tj_close_button", "drawable", context.getPackageName()));
            } catch (Exception unused) {
                TapjoyLog.m6555w(f6292a, "Could not find close button asset");
            }
        }
        setImageBitmap(loadBitmapFromJar);
        setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        setLayoutParams(this.f6293b.f6299a);
    }

    /* access modifiers changed from: protected */
    @TargetApi(11)
    public void onAttachedToWindow() {
        if (VERSION.SDK_INT >= 12) {
            setAlpha(0.0f);
            setVisibility(0);
            this.f6295d = true;
            setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @SuppressLint({"NewApi"})
                public final void run() {
                    TJCloseButton.this.animate().alpha(1.0f).setDuration(500).setListener(new AnimatorListener() {
                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationCancel(Animator animator) {
                            TJCloseButton.this.setClickable(TJCloseButton.this.f6294c);
                            TJCloseButton.this.f6295d = false;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            TJCloseButton.this.setClickable(TJCloseButton.this.f6294c);
                            TJCloseButton.this.f6295d = false;
                        }
                    });
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setClickableRequested(boolean z) {
        this.f6294c = z;
        if (!this.f6295d) {
            setClickable(z);
        }
    }
}
