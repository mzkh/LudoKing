package com.inmobi.media;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/* renamed from: com.inmobi.media.ea */
/* compiled from: NativeDataSource */
final class C2362ea extends PagerAdapter implements C2385eg {

    /* renamed from: a */
    private static final String f5011a = "ea";

    /* renamed from: e */
    private static Handler f5012e = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f5013b;
    @NonNull

    /* renamed from: c */
    private final C2220bg f5014c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2368ec f5015d;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: f */
    public SparseArray<Runnable> f5016f = new SparseArray<>();

    C2362ea(@NonNull C2220bg bgVar, @NonNull C2368ec ecVar) {
        this.f5014c = bgVar;
        this.f5015d = ecVar;
    }

    public final int getItemPosition(Object obj) {
        Object tag = obj == null ? null : ((View) obj).getTag();
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -2;
    }

    public final int getCount() {
        return this.f5014c.mo27961c();
    }

    public final boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view.equals(obj);
    }

    @TargetApi(21)
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        C2216be a = this.f5014c.mo27957a(i);
        if (a == null) {
            return null;
        }
        ViewGroup a2 = this.f5015d.mo28239a(viewGroup, a);
        int abs = Math.abs(this.f5015d.f5031a - i);
        final int i2 = i;
        final ViewGroup viewGroup2 = a2;
        final ViewGroup viewGroup3 = viewGroup;
        final C2216be beVar = a;
        C23642 r1 = new Runnable() {
            public final void run() {
                if (!C2362ea.this.f5013b) {
                    C2362ea.this.f5016f.remove(i2);
                    C2362ea.this.f5015d.mo28242b(viewGroup2, beVar);
                }
            }
        };
        this.f5016f.put(i, r1);
        f5012e.postDelayed(r1, (long) (abs * 50));
        a2.setLayoutParams(C2404el.m5006a((C2214bc) a, viewGroup));
        a2.setTag(Integer.valueOf(i));
        viewGroup.addView(a2);
        return a2;
    }

    public final void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull final Object obj) {
        viewGroup.removeView((View) obj);
        Runnable runnable = (Runnable) this.f5016f.get(i);
        if (runnable != null) {
            f5012e.removeCallbacks(runnable);
            C2404el.class.getSimpleName();
        }
        f5012e.post(new Runnable() {
            public final void run() {
                View view = (View) obj;
                C2362ea.this.f5015d.f5033c.mo28322a(view);
            }
        });
    }

    public final void destroy() {
        this.f5013b = true;
        int size = this.f5016f.size();
        for (int i = 0; i < size; i++) {
            f5012e.removeCallbacks((Runnable) this.f5016f.get(this.f5016f.keyAt(i)));
        }
        this.f5016f.clear();
    }
}
