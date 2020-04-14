package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.media.df */
/* compiled from: VisibilityTracker */
public abstract class C2325df {

    /* renamed from: a */
    private static final String f4911a = "df";

    /* renamed from: b */
    boolean f4912b;
    @Nullable

    /* renamed from: c */
    public C2328c f4913c;
    @NonNull

    /* renamed from: d */
    private final ArrayList<View> f4914d;

    /* renamed from: e */
    private long f4915e;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: f */
    public final Map<View, C2329d> f4916f;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: g */
    public final C2326a f4917g;
    @NonNull

    /* renamed from: h */
    private final C2327b f4918h;
    @NonNull

    /* renamed from: i */
    private final Handler f4919i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f4920j;

    /* renamed from: com.inmobi.media.df$a */
    /* compiled from: VisibilityTracker */
    public interface C2326a {
        /* renamed from: a */
        boolean mo28178a(@Nullable View view, @Nullable View view2, int i, Object obj);
    }

    /* renamed from: com.inmobi.media.df$b */
    /* compiled from: VisibilityTracker */
    static class C2327b implements Runnable {
        @NonNull

        /* renamed from: a */
        private final ArrayList<View> f4921a = new ArrayList<>();
        @NonNull

        /* renamed from: b */
        private final ArrayList<View> f4922b = new ArrayList<>();

        /* renamed from: c */
        private WeakReference<C2325df> f4923c;

        C2327b(C2325df dfVar) {
            this.f4923c = new WeakReference<>(dfVar);
        }

        public final void run() {
            C2325df dfVar = (C2325df) this.f4923c.get();
            if (dfVar != null) {
                dfVar.f4920j = false;
                for (Entry entry : dfVar.f4916f.entrySet()) {
                    View view = (View) entry.getKey();
                    int i = ((C2329d) entry.getValue()).f4924a;
                    if (dfVar.f4917g.mo28178a(((C2329d) entry.getValue()).f4926c, view, i, ((C2329d) entry.getValue()).f4927d)) {
                        this.f4921a.add(view);
                    } else {
                        this.f4922b.add(view);
                    }
                }
            }
            if (dfVar != null) {
                C2328c d = dfVar.f4913c;
                if (d != null) {
                    d.mo28170a(this.f4921a, this.f4922b);
                }
            }
            this.f4921a.clear();
            this.f4922b.clear();
            if (dfVar != null) {
                dfVar.mo28157b();
            }
        }
    }

    /* renamed from: com.inmobi.media.df$c */
    /* compiled from: VisibilityTracker */
    public interface C2328c {
        /* renamed from: a */
        void mo28170a(List<View> list, List<View> list2);
    }

    /* renamed from: com.inmobi.media.df$d */
    /* compiled from: VisibilityTracker */
    static class C2329d {

        /* renamed from: a */
        int f4924a;

        /* renamed from: b */
        long f4925b;

        /* renamed from: c */
        View f4926c;

        /* renamed from: d */
        Object f4927d;

        C2329d() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo28156a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo28157b();

    C2325df(C2326a aVar) {
        this(new WeakHashMap(10), aVar, new Handler(Looper.getMainLooper()));
    }

    private C2325df(@NonNull Map<View, C2329d> map, @NonNull C2326a aVar, @NonNull Handler handler) {
        this.f4915e = 0;
        this.f4912b = true;
        this.f4916f = map;
        this.f4917g = aVar;
        this.f4919i = handler;
        this.f4918h = new C2327b(this);
        this.f4914d = new ArrayList<>(50);
    }

    /* renamed from: c */
    public void mo28158c() {
        this.f4918h.run();
        this.f4919i.removeCallbacksAndMessages(null);
        this.f4920j = false;
        this.f4912b = true;
    }

    /* renamed from: d */
    public void mo28159d() {
        this.f4912b = false;
        mo28186h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo28182a(@NonNull View view, @Nullable Object obj, int i) {
        mo28181a(view, view, obj, i);
    }

    /* renamed from: a */
    public final void mo28181a(@NonNull View view, @NonNull View view2, @Nullable Object obj, int i) {
        C2329d dVar = (C2329d) this.f4916f.get(view2);
        if (dVar == null) {
            dVar = new C2329d();
            this.f4916f.put(view2, dVar);
            this.f4915e++;
        }
        dVar.f4924a = i;
        long j = this.f4915e;
        dVar.f4925b = j;
        dVar.f4926c = view;
        dVar.f4927d = obj;
        if (j % 50 == 0) {
            m4777a(j - 50);
        }
        if (1 == this.f4916f.size()) {
            mo28159d();
        }
    }

    /* renamed from: a */
    private void m4777a(long j) {
        for (Entry entry : this.f4916f.entrySet()) {
            if (((C2329d) entry.getValue()).f4925b < j) {
                this.f4914d.add(entry.getKey());
            }
        }
        Iterator it = this.f4914d.iterator();
        while (it.hasNext()) {
            mo28180a((View) it.next());
        }
        this.f4914d.clear();
    }

    /* renamed from: a */
    public final void mo28180a(@NonNull View view) {
        if (((C2329d) this.f4916f.remove(view)) != null) {
            this.f4915e--;
            if (this.f4916f.size() == 0) {
                mo28158c();
            }
        }
    }

    /* renamed from: f */
    public final void mo28184f() {
        this.f4916f.clear();
        this.f4919i.removeMessages(0);
        this.f4920j = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28183a(@Nullable Object obj) {
        if (obj != null) {
            View view = null;
            Iterator it = this.f4916f.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((C2329d) entry.getValue()).f4927d.equals(obj)) {
                    view = (View) entry.getKey();
                    break;
                }
            }
            if (view != null) {
                mo28180a(view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final boolean mo28185g() {
        return !this.f4916f.isEmpty();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo28160e() {
        mo28184f();
        this.f4913c = null;
        this.f4912b = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final void mo28186h() {
        if (!this.f4920j && !this.f4912b) {
            this.f4920j = true;
            this.f4919i.postDelayed(this.f4918h, (long) mo28156a());
        }
    }
}
