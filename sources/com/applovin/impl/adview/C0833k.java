package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.impl.adview.C0826h.C0827a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1078a;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.k */
class C0833k extends Dialog implements C0832j {

    /* renamed from: a */
    private final Activity f1472a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1192i f1473b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1227o f1474c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0801c f1475d;

    /* renamed from: e */
    private final C1078a f1476e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RelativeLayout f1477f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0826h f1478g;

    C0833k(C1078a aVar, C0801c cVar, Activity activity, C1192i iVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (cVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (iVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.f1473b = iVar;
            this.f1474c = iVar.mo10249v();
            this.f1472a = activity;
            this.f1475d = cVar;
            this.f1476e = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* renamed from: a */
    private int m1191a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f1472a, i);
    }

    /* renamed from: a */
    private void m1193a(C0827a aVar) {
        if (this.f1478g != null) {
            this.f1474c.mo10381d("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        this.f1478g = C0826h.m1172a(this.f1473b, getContext(), aVar);
        this.f1478g.setVisibility(8);
        this.f1478g.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C0833k.this.m1196c();
            }
        });
        this.f1478g.setClickable(false);
        int a = m1191a(((Integer) this.f1473b.mo10202a(C1096c.f2436ct)).intValue());
        LayoutParams layoutParams = new LayoutParams(a, a);
        layoutParams.addRule(10);
        int i = 9;
        layoutParams.addRule(((Boolean) this.f1473b.mo10202a(C1096c.f2439cw)).booleanValue() ? 9 : 11);
        this.f1478g.mo9078a(a);
        int a2 = m1191a(((Integer) this.f1473b.mo10202a(C1096c.f2438cv)).intValue());
        int a3 = m1191a(((Integer) this.f1473b.mo10202a(C1096c.f2437cu)).intValue());
        layoutParams.setMargins(a3, a2, a3, 0);
        this.f1477f.addView(this.f1478g, layoutParams);
        this.f1478g.bringToFront();
        int a4 = m1191a(((Integer) this.f1473b.mo10202a(C1096c.f2440cx)).intValue());
        View view = new View(this.f1472a);
        view.setBackgroundColor(0);
        int i2 = a + a4;
        LayoutParams layoutParams2 = new LayoutParams(i2, i2);
        layoutParams2.addRule(10);
        if (!((Boolean) this.f1473b.mo10202a(C1096c.f2439cw)).booleanValue()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(a3 - m1191a(5), a2 - m1191a(5), a3 - m1191a(5), 0);
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C0833k.this.f1478g.isClickable()) {
                    C0833k.this.f1478g.performClick();
                }
            }
        });
        this.f1477f.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: b */
    private void m1195b() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f1475d.setLayoutParams(layoutParams);
        this.f1477f = new RelativeLayout(this.f1472a);
        this.f1477f.setLayoutParams(new LayoutParams(-1, -1));
        this.f1477f.setBackgroundColor(-1157627904);
        this.f1477f.addView(this.f1475d);
        if (!this.f1476e.mo9836j()) {
            m1193a(this.f1476e.mo9837k());
            m1198d();
        }
        setContentView(this.f1477f);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1196c() {
        this.f1475d.mo9006a("javascript:al_onCloseTapped();", (Runnable) new Runnable() {
            public void run() {
                C0833k.this.dismiss();
            }
        });
    }

    /* renamed from: d */
    private void m1198d() {
        this.f1472a.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C0833k.this.f1478g == null) {
                        C0833k.this.m1196c();
                    }
                    C0833k.this.f1478g.setVisibility(0);
                    C0833k.this.f1478g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(((Long) C0833k.this.f1473b.mo10202a(C1096c.f2435cs)).longValue());
                    alphaAnimation.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            C0833k.this.f1478g.setClickable(true);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    C0833k.this.f1478g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    C0833k.this.f1474c.mo10379b("ExpandedAdDialog", "Unable to fade in close button", th);
                    C0833k.this.m1196c();
                }
            }
        });
    }

    /* renamed from: a */
    public C1078a mo9094a() {
        return this.f1476e;
    }

    public void dismiss() {
        C1108d b = this.f1475d.mo9007b();
        if (b != null) {
            b.mo10013e();
        }
        this.f1472a.runOnUiThread(new Runnable() {
            public void run() {
                C0833k.this.f1477f.removeView(C0833k.this.f1475d);
                C0833k.super.dismiss();
            }
        });
    }

    public void onBackPressed() {
        this.f1475d.mo9006a("javascript:al_onBackPressed();", (Runnable) new Runnable() {
            public void run() {
                C0833k.this.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m1195b();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        String str = "ExpandedAdDialog";
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f1472a.getWindow().getAttributes().flags, this.f1472a.getWindow().getAttributes().flags);
                if (this.f1476e.mo9933v()) {
                    window.addFlags(16777216);
                    return;
                }
                return;
            }
            this.f1474c.mo10382e(str, "Unable to turn on hardware acceleration - window is null");
        } catch (Throwable th) {
            this.f1474c.mo10379b(str, "Setting window flags failed.", th);
        }
    }
}
