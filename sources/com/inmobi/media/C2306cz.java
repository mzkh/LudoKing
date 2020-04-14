package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.NonNull;
import com.inmobi.media.C2325df.C2326a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.cz */
/* compiled from: DecorViewVisibilityTracker */
final class C2306cz extends C2325df {

    /* renamed from: a */
    private static final String f4864a = "cz";
    @NonNull

    /* renamed from: d */
    private OnPreDrawListener f4865d;
    @NonNull

    /* renamed from: e */
    private final WeakReference<View> f4866e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo28156a() {
        return 100;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo28157b() {
    }

    C2306cz(@NonNull C2326a aVar, @NonNull Activity activity) {
        super(aVar);
        View decorView = activity.getWindow().getDecorView();
        this.f4866e = new WeakReference<>(decorView);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f4865d = new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    C2306cz.this.mo28186h();
                    return true;
                }
            };
            viewTreeObserver.addOnPreDrawListener(this.f4865d);
        }
    }

    /* renamed from: i */
    private void m4717i() {
        View view = (View) this.f4866e.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f4865d);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo28160e() {
        m4717i();
        super.mo28160e();
    }

    /* renamed from: c */
    public final void mo28158c() {
        if (!this.f4912b) {
            m4717i();
            super.mo28158c();
        }
    }

    /* renamed from: d */
    public final void mo28159d() {
        if (this.f4912b) {
            View view = (View) this.f4866e.get();
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this.f4865d);
                }
            }
            super.mo28159d();
        }
    }
}
