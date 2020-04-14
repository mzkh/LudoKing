package com.inmobi.media;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2325df.C2328c;
import com.inmobi.media.C2426eq.C2435i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.media.da */
/* compiled from: ImpressionTracker */
class C2312da {

    /* renamed from: d */
    private static final String f4874d = "da";
    @NonNull

    /* renamed from: a */
    final C2325df f4875a;
    /* access modifiers changed from: 0000 */
    @NonNull

    /* renamed from: b */
    public final Map<View, C2315b> f4876b;
    @NonNull

    /* renamed from: c */
    final Handler f4877c;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: e */
    public final Map<View, C2315b> f4878e;
    @NonNull

    /* renamed from: f */
    private final C2316c f4879f;

    /* renamed from: g */
    private final long f4880g;
    @Nullable

    /* renamed from: h */
    private C2328c f4881h;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: i */
    public C2314a f4882i;

    /* renamed from: com.inmobi.media.da$a */
    /* compiled from: ImpressionTracker */
    interface C2314a {
        /* renamed from: a */
        void mo28171a(View view, Object obj);
    }

    /* renamed from: com.inmobi.media.da$b */
    /* compiled from: ImpressionTracker */
    static class C2315b {

        /* renamed from: a */
        Object f4884a;

        /* renamed from: b */
        int f4885b;

        /* renamed from: c */
        int f4886c;

        /* renamed from: d */
        long f4887d = Long.MAX_VALUE;

        C2315b(Object obj, int i, int i2) {
            this.f4884a = obj;
            this.f4885b = i;
            this.f4886c = i2;
        }
    }

    /* renamed from: com.inmobi.media.da$c */
    /* compiled from: ImpressionTracker */
    static class C2316c implements Runnable {
        @NonNull

        /* renamed from: a */
        private final ArrayList<View> f4888a = new ArrayList<>();

        /* renamed from: b */
        private WeakReference<C2312da> f4889b;

        C2316c(C2312da daVar) {
            this.f4889b = new WeakReference<>(daVar);
        }

        public final void run() {
            C2312da daVar = (C2312da) this.f4889b.get();
            if (daVar != null) {
                for (Entry entry : daVar.f4876b.entrySet()) {
                    View view = (View) entry.getKey();
                    C2315b bVar = (C2315b) entry.getValue();
                    if (C2312da.m4733a(bVar.f4887d, bVar.f4886c) && this.f4889b.get() != null) {
                        daVar.f4882i.mo28171a(view, bVar.f4884a);
                        this.f4888a.add(view);
                    }
                }
                Iterator it = this.f4888a.iterator();
                while (it.hasNext()) {
                    daVar.m4731a((View) it.next());
                }
                this.f4888a.clear();
                if (!daVar.f4876b.isEmpty()) {
                    daVar.m4737d();
                }
            }
        }
    }

    C2312da(C2435i iVar, @NonNull C2325df dfVar, @NonNull C2314a aVar) {
        this(new WeakHashMap(), new WeakHashMap(), dfVar, new Handler(), iVar, aVar);
    }

    private C2312da(@NonNull Map<View, C2315b> map, @NonNull Map<View, C2315b> map2, @NonNull C2325df dfVar, @NonNull Handler handler, @NonNull C2435i iVar, @NonNull C2314a aVar) {
        this.f4878e = map;
        this.f4876b = map2;
        this.f4875a = dfVar;
        this.f4880g = (long) iVar.f5234d;
        this.f4881h = new C2328c() {
            /* renamed from: a */
            public final void mo28170a(@NonNull List<View> list, @NonNull List<View> list2) {
                for (View view : list) {
                    C2315b bVar = (C2315b) C2312da.this.f4878e.get(view);
                    if (bVar == null) {
                        C2312da.this.m4731a(view);
                    } else {
                        C2315b bVar2 = (C2315b) C2312da.this.f4876b.get(view);
                        if (bVar2 == null || !bVar.f4884a.equals(bVar2.f4884a)) {
                            bVar.f4887d = SystemClock.uptimeMillis();
                            C2312da.this.f4876b.put(view, bVar);
                        }
                    }
                }
                for (View remove : list2) {
                    C2312da.this.f4876b.remove(remove);
                }
                C2312da.this.m4737d();
            }
        };
        this.f4875a.f4913c = this.f4881h;
        this.f4877c = handler;
        this.f4879f = new C2316c(this);
        this.f4882i = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28166a(View view, @NonNull Object obj, int i, int i2) {
        C2315b bVar = (C2315b) this.f4878e.get(view);
        if (bVar == null || !bVar.f4884a.equals(obj)) {
            m4731a(view);
            C2315b bVar2 = new C2315b(obj, i, i2);
            this.f4878e.put(view, bVar2);
            this.f4875a.mo28182a(view, obj, bVar2.f4885b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4731a(View view) {
        this.f4878e.remove(view);
        this.f4876b.remove(view);
        this.f4875a.mo28180a(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28167a(@NonNull Object obj) {
        View view;
        Iterator it = this.f4878e.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            Entry entry = (Entry) it.next();
            if (((C2315b) entry.getValue()).f4884a.equals(obj)) {
                view = (View) entry.getKey();
                break;
            }
        }
        if (view != null) {
            m4731a(view);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28165a() {
        for (Entry entry : this.f4878e.entrySet()) {
            this.f4875a.mo28182a((View) entry.getKey(), ((C2315b) entry.getValue()).f4884a, ((C2315b) entry.getValue()).f4885b);
        }
        m4737d();
        this.f4875a.mo28159d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo28168b() {
        return !this.f4878e.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m4737d() {
        if (!this.f4877c.hasMessages(0)) {
            this.f4877c.postDelayed(this.f4879f, this.f4880g);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo28169c() {
        this.f4878e.clear();
        this.f4876b.clear();
        this.f4875a.mo28184f();
        this.f4877c.removeMessages(0);
        this.f4875a.mo28160e();
        this.f4881h = null;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m4733a(long j, int i) {
        return SystemClock.uptimeMillis() - j >= ((long) i);
    }
}
