package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.cu */
/* compiled from: ViewableAd */
public abstract class C2300cu {
    @NonNull

    /* renamed from: a */
    protected C2452f f4853a;
    @Nullable

    /* renamed from: b */
    C2301a f4854b;
    @NonNull

    /* renamed from: c */
    protected C2426eq f4855c;
    @Nullable

    /* renamed from: d */
    private WeakReference<View> f4856d;

    /* renamed from: com.inmobi.media.cu$a */
    /* compiled from: ViewableAd */
    public static abstract class C2301a {

        /* renamed from: a */
        public boolean f4857a;

        /* renamed from: a */
        public abstract View mo28154a(View view, ViewGroup viewGroup, boolean z, C2600j jVar);

        /* renamed from: a */
        public void mo28155a() {
            if (!this.f4857a) {
                this.f4857a = true;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public abstract View mo28144a(View view, ViewGroup viewGroup, boolean z);

    /* renamed from: a */
    public abstract void mo28146a(int i);

    /* renamed from: a */
    public abstract void mo28147a(Context context, int i);

    /* renamed from: a */
    public abstract void mo28149a(@Nullable View... viewArr);

    @Nullable
    /* renamed from: c */
    public View mo28151c() {
        return null;
    }

    /* renamed from: d */
    public abstract void mo28152d();

    public C2300cu(@NonNull C2452f fVar) {
        this.f4853a = fVar;
        this.f4855c = fVar.getAdConfig();
    }

    @Nullable
    /* renamed from: a */
    public C2301a mo28145a() {
        return this.f4854b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo28148a(View view) {
        this.f4856d = new WeakReference<>(view);
    }

    @Nullable
    /* renamed from: b */
    public View mo28150b() {
        WeakReference<View> weakReference = this.f4856d;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* renamed from: e */
    public void mo28153e() {
        WeakReference<View> weakReference = this.f4856d;
        if (weakReference != null) {
            weakReference.clear();
        }
    }
}
