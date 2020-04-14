package com.inmobi.media;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.ei */
/* compiled from: NativeVideoController */
public class C2387ei extends FrameLayout {

    /* renamed from: b */
    private static final String f5072b = "ei";

    /* renamed from: a */
    boolean f5073a;

    /* renamed from: c */
    private C2596i f5074c;

    /* renamed from: d */
    private C2389a f5075d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2390ej f5076e;

    /* renamed from: f */
    private C2242bv f5077f;

    /* renamed from: g */
    private C2242bv f5078g;

    /* renamed from: h */
    private ProgressBar f5079h;

    /* renamed from: i */
    private RelativeLayout f5080i;

    /* renamed from: j */
    private boolean f5081j;

    /* renamed from: k */
    private float f5082k;

    /* renamed from: l */
    private final OnClickListener f5083l;

    /* renamed from: com.inmobi.media.ei$a */
    /* compiled from: NativeVideoController */
    static final class C2389a extends Handler {
        @NonNull

        /* renamed from: a */
        private final WeakReference<C2387ei> f5085a;

        C2389a(@NonNull C2387ei eiVar) {
            this.f5085a = new WeakReference<>(eiVar);
        }

        public final void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            C2387ei eiVar = (C2387ei) this.f5085a.get();
            if (eiVar != null) {
                eiVar.m4969e();
                if (eiVar.f5073a && eiVar.f5076e.isPlaying()) {
                    sendMessageDelayed(obtainMessage(2), 200);
                }
            }
        }
    }

    public C2387ei(Context context) {
        this(context, 0);
    }

    private C2387ei(Context context, byte b) {
        this(context, 0);
    }

    private C2387ei(Context context, char c) {
        super(context, null, 0);
        this.f5081j = false;
        this.f5083l = new OnClickListener() {
            public final void onClick(View view) {
                C2387ei.m4967c(C2387ei.this);
            }
        };
        this.f5080i = new RelativeLayout(getContext());
        addView(this.f5080i, new LayoutParams(-1, -1));
        this.f5080i.setPadding(0, 0, 0, 0);
        if (this.f5080i != null) {
            this.f5082k = C2528gq.m5393a().f5543c;
            this.f5077f = new C2242bv(getContext(), this.f5082k, 9);
            this.f5078g = new C2242bv(getContext(), this.f5082k, 11);
            this.f5079h = new ProgressBar(getContext(), null, 16842872);
            this.f5079h.setScaleY(0.8f);
            m4966c();
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            float f = C2528gq.m5393a().f5543c;
            layoutParams.setMargins(0, (int) (-6.0f * f), 0, (int) (f * -8.0f));
            LayerDrawable layerDrawable = (LayerDrawable) this.f5079h.getProgressDrawable();
            if (layerDrawable != null) {
                layerDrawable.getDrawable(0).setColorFilter(-1, Mode.SRC_IN);
                layerDrawable.getDrawable(2).setColorFilter(-327674, Mode.SRC_IN);
            }
            this.f5080i.addView(this.f5079h, layoutParams);
        }
        this.f5075d = new C2389a(this);
    }

    public void setMediaPlayer(@NonNull C2390ej ejVar) {
        this.f5076e = ejVar;
        C2235bp bpVar = (C2235bp) this.f5076e.getTag();
        if (bpVar != null && bpVar.f4635B && !bpVar.mo27981a()) {
            this.f5081j = true;
            this.f5080i.removeView(this.f5078g);
            this.f5080i.removeView(this.f5077f);
            m4968d();
        }
    }

    /* renamed from: c */
    private void m4966c() {
        float f = this.f5082k;
        LayoutParams layoutParams = new LayoutParams((int) (f * 30.0f), (int) (f * 30.0f));
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.f5080i.addView(this.f5077f, layoutParams);
        this.f5077f.setOnClickListener(this.f5083l);
    }

    /* renamed from: d */
    private void m4968d() {
        float f = this.f5082k;
        LayoutParams layoutParams = new LayoutParams((int) (f * 30.0f), (int) (f * 30.0f));
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.f5080i.addView(this.f5078g, layoutParams);
        this.f5078g.setOnClickListener(this.f5083l);
    }

    /* renamed from: a */
    public final void mo28258a() {
        if (!this.f5073a) {
            m4969e();
            this.f5073a = true;
            C2235bp bpVar = (C2235bp) this.f5076e.getTag();
            if (bpVar != null) {
                int i = 4;
                this.f5077f.setVisibility(bpVar.f4635B ? 0 : 4);
                ProgressBar progressBar = this.f5079h;
                if (bpVar.f4637D) {
                    i = 0;
                }
                progressBar.setVisibility(i);
            }
            setVisibility(0);
        }
        this.f5075d.sendEmptyMessage(2);
    }

    /* renamed from: b */
    public final void mo28259b() {
        if (this.f5073a) {
            try {
                this.f5075d.removeMessages(2);
                setVisibility(8);
            } catch (IllegalArgumentException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
            this.f5073a = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4969e() {
        C2390ej ejVar = this.f5076e;
        if (ejVar != null) {
            int currentPosition = ejVar.getCurrentPosition();
            int duration = this.f5076e.getDuration();
            ProgressBar progressBar = this.f5079h;
            if (!(progressBar == null || duration == 0)) {
                progressBar.setProgress((currentPosition * 100) / duration);
            }
        }
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        C2390ej ejVar = this.f5076e;
        if (ejVar != null && ejVar.mo28272b()) {
            if (this.f5073a) {
                mo28259b();
            } else {
                mo28258a();
            }
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z) {
                if (this.f5076e.isPlaying()) {
                    this.f5076e.pause();
                } else {
                    this.f5076e.start();
                }
                mo28258a();
            }
            return true;
        } else if (keyCode == 126) {
            if (z && !this.f5076e.isPlaying()) {
                this.f5076e.start();
                mo28258a();
            }
            return true;
        } else if (keyCode == 86 || keyCode == 127) {
            if (z && this.f5076e.isPlaying()) {
                this.f5076e.pause();
                mo28258a();
            }
            return true;
        } else if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            mo28258a();
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C2387ei.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(C2387ei.class.getName());
    }

    public void setVideoAd(C2596i iVar) {
        this.f5074c = iVar;
    }

    /* renamed from: c */
    static /* synthetic */ void m4967c(C2387ei eiVar) {
        C2390ej ejVar = eiVar.f5076e;
        if (ejVar != null) {
            C2235bp bpVar = (C2235bp) ejVar.getTag();
            if (eiVar.f5081j) {
                eiVar.f5076e.mo28278e();
                eiVar.f5081j = false;
                eiVar.f5080i.removeView(eiVar.f5078g);
                eiVar.f5080i.removeView(eiVar.f5077f);
                eiVar.m4966c();
                if (bpVar != null) {
                    C2596i iVar = eiVar.f5074c;
                    if (iVar != null) {
                        try {
                            iVar.mo28619f(bpVar);
                            bpVar.f4634A = true;
                        } catch (Exception e) {
                            C2463fd.m5161a().mo28382a(new C2495fz(e));
                        }
                    }
                }
            } else {
                eiVar.f5076e.mo28277d();
                eiVar.f5081j = true;
                eiVar.f5080i.removeView(eiVar.f5077f);
                eiVar.f5080i.removeView(eiVar.f5078g);
                eiVar.m4968d();
                if (bpVar != null) {
                    C2596i iVar2 = eiVar.f5074c;
                    if (iVar2 != null) {
                        try {
                            iVar2.mo28618e(bpVar);
                            bpVar.f4634A = false;
                        } catch (Exception e2) {
                            C2463fd.m5161a().mo28382a(new C2495fz(e2));
                        }
                    }
                }
            }
        }
    }
}
