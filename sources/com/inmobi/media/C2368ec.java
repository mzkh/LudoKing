package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.media.C2231bn.C2233b;
import com.inmobi.media.C2349dv.C2352a;
import com.inmobi.media.C2390ej.C2400b;
import com.inmobi.media.C2542h.C2552c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.inmobi.media.ec */
/* compiled from: NativeLayoutInflater */
public final class C2368ec implements C2384a {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f5029d = "ec";

    /* renamed from: m */
    private static Handler f5030m = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    int f5031a = 0;

    /* renamed from: b */
    public final C2349dv f5032b;

    /* renamed from: c */
    C2404el f5033c;
    @NonNull

    /* renamed from: e */
    private final WeakReference<Context> f5034e;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: f */
    public final C2220bg f5035f;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: g */
    public final C2542h f5036g;
    @NonNull

    /* renamed from: h */
    private final C2426eq f5037h;
    @NonNull

    /* renamed from: i */
    private C2380c f5038i;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: j */
    public C2378a f5039j;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: k */
    public C2379b f5040k;

    /* renamed from: l */
    private C2385eg f5041l;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f5042n = false;

    /* renamed from: o */
    private C2600j f5043o;

    /* renamed from: com.inmobi.media.ec$a */
    /* compiled from: NativeLayoutInflater */
    interface C2378a {
        /* renamed from: a */
        void mo28237a(View view, C2214bc bcVar);
    }

    /* renamed from: com.inmobi.media.ec$b */
    /* compiled from: NativeLayoutInflater */
    interface C2379b {
        /* renamed from: a */
        void mo28235a(C2230bm bmVar);
    }

    /* renamed from: com.inmobi.media.ec$c */
    /* compiled from: NativeLayoutInflater */
    interface C2380c {
        /* renamed from: a */
        void mo28236a(int i, C2214bc bcVar);
    }

    public C2368ec(@NonNull Context context, @NonNull C2426eq eqVar, @NonNull C2542h hVar, @NonNull C2220bg bgVar, @NonNull C2380c cVar, @NonNull C2378a aVar, @NonNull C2379b bVar) {
        this.f5034e = new WeakReference<>(context);
        this.f5036g = hVar;
        this.f5035f = bgVar;
        this.f5038i = cVar;
        this.f5039j = aVar;
        this.f5040k = bVar;
        this.f5032b = new C2349dv();
        this.f5037h = eqVar;
        this.f5033c = C2404el.m5007a(context);
    }

    /* renamed from: c */
    private Context m4940c() {
        return (Context) this.f5034e.get();
    }

    /* renamed from: a */
    public final C2382ee mo28240a(@Nullable C2382ee eeVar, @NonNull ViewGroup viewGroup, C2600j jVar) {
        this.f5043o = jVar;
        C2382ee a = m4931a(eeVar, viewGroup);
        if (!this.f5042n) {
            mo28242b(a, this.f5035f.f4567d);
        }
        return a;
    }

    /* renamed from: b */
    public final C2382ee mo28243b(@Nullable C2382ee eeVar, @NonNull final ViewGroup viewGroup, C2600j jVar) {
        this.f5043o = jVar;
        final C2382ee a = m4931a(eeVar, viewGroup);
        f5030m.post(new Runnable() {
            public final void run() {
                if (!C2368ec.this.f5042n) {
                    C2368ec ecVar = C2368ec.this;
                    ecVar.mo28242b(a, ecVar.f5035f.f4567d);
                }
            }
        });
        return a;
    }

    /* renamed from: a */
    private C2382ee m4931a(@Nullable C2382ee eeVar, @NonNull ViewGroup viewGroup) {
        C2382ee eeVar2 = eeVar == null ? (C2382ee) this.f5033c.mo28321a(m4940c(), (C2214bc) this.f5035f.f4567d, this.f5037h) : eeVar;
        if (!(eeVar2 == null || eeVar == null)) {
            m4936a(eeVar2);
            this.f5033c.mo28323a((ViewGroup) eeVar2);
            C2404el.m5013a((View) eeVar2, this.f5035f.f4567d.f4523c);
        }
        C2404el.m5025b(this.f5035f.f4567d.f4523c.f4546a.x);
        eeVar2.setLayoutParams(C2404el.m5006a((C2214bc) this.f5035f.f4567d, viewGroup));
        return eeVar2;
    }

    /* renamed from: a */
    private static void m4936a(@NonNull C2382ee eeVar) {
        ViewParent parent = eeVar.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(eeVar);
        }
    }

    /* renamed from: a */
    public final ViewGroup mo28239a(@NonNull ViewGroup viewGroup, @NonNull C2216be beVar) {
        ViewGroup viewGroup2 = (ViewGroup) this.f5033c.mo28321a(m4940c(), (C2214bc) beVar, this.f5037h);
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(C2404el.m5006a((C2214bc) beVar, viewGroup));
        }
        return viewGroup2;
    }

    /* renamed from: a */
    public final int mo28238a(int i) {
        this.f5031a = i;
        this.f5038i.mo28236a(i, this.f5035f.mo27957a(i));
        return m4942d();
    }

    /* renamed from: a */
    private void m4934a(final C2230bm bmVar, C2231bn bnVar) {
        bnVar.setTimerEventsListener(new C2233b() {
            /* renamed from: a */
            public final void mo27978a() {
                if (C2368ec.this.f5040k != null) {
                    C2368ec.this.f5040k.mo28235a(bmVar);
                }
            }
        });
    }

    /* renamed from: a */
    private void m4932a(View view, final C2214bc bcVar) {
        boolean z;
        final List a = this.f5032b.mo28210a(view, bcVar);
        if (a == null) {
            Iterator it = bcVar.f4541u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if ("creativeView".equals(((C2234bo) it.next()).f4631d)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return;
            }
        }
        view.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
                C2368ec.this.f5032b.mo28212a(a);
                C2368ec.this.f5036g;
                C2214bc a = C2542h.m5452a(C2368ec.this.f5036g.mo28500k(), bcVar);
                C2214bc bcVar = bcVar;
                C2542h e = C2368ec.this.f5036g;
                if (a == null) {
                    a = bcVar;
                }
                bcVar.mo27940a("creativeView", e.mo28484a(a));
            }

            public final void onViewDetachedFromWindow(View view) {
                view.removeOnAttachStateChangeListener(this);
                C2349dv d = C2368ec.this.f5032b;
                List<C2352a> list = a;
                if (list != null) {
                    for (C2352a aVar : list) {
                        aVar.f4989a.cancel();
                    }
                    d.f4981a.removeAll(list);
                }
            }
        });
    }

    /* renamed from: b */
    public final ViewGroup mo28242b(@NonNull ViewGroup viewGroup, @NonNull C2216be beVar) {
        m4933a((C2214bc) beVar, (View) viewGroup);
        Iterator it = beVar.iterator();
        while (it.hasNext()) {
            C2214bc bcVar = (C2214bc) it.next();
            if (!"CONTAINER".equals(bcVar.f4522b)) {
                String str = "WEBVIEW";
                View view = null;
                if (str.equals(bcVar.f4522b)) {
                    C2237bq bqVar = (C2237bq) bcVar;
                    if (bqVar.f4643A) {
                        View view2 = this.f5043o;
                        if (view2 != null) {
                            if (view2.getParent() != null) {
                                ((ViewGroup) view2.getParent()).removeView(view2);
                            }
                            this.f5043o = null;
                            view = view2;
                        }
                    }
                    if ("UNKNOWN".equals(bqVar.f4645z)) {
                    }
                } else {
                    if (ShareConstants.IMAGE_URL.equals(bcVar.f4522b) && bcVar.f4525e == null) {
                    }
                }
                if (view == null) {
                    view = this.f5033c.mo28321a(m4940c(), bcVar, this.f5037h);
                }
                if (view != null) {
                    final WeakReference weakReference = new WeakReference(view);
                    if (bcVar.f4535o != -1) {
                        view.setVisibility(4);
                        f5030m.postDelayed(new Runnable() {
                            public final void run() {
                                View view = (View) weakReference.get();
                                if (view != null) {
                                    view.setVisibility(0);
                                }
                            }
                        }, (long) (bcVar.f4535o * 1000));
                    } else if (bcVar.f4536p != -1) {
                        f5030m.postDelayed(new Runnable() {
                            public final void run() {
                                View view = (View) weakReference.get();
                                if (view != null) {
                                    view.setVisibility(4);
                                }
                            }
                        }, (long) (bcVar.f4536p * 1000));
                    }
                    view.setLayoutParams(C2404el.m5006a(bcVar, viewGroup));
                    m4932a(view, bcVar);
                    viewGroup.addView(view);
                    String str2 = bcVar.f4522b;
                    String str3 = ShareConstants.VIDEO_URL;
                    if (str3.equals(str2)) {
                        m4935a((C2235bp) bcVar, ((C2403ek) view).getVideoView());
                    }
                    m4933a(bcVar, view);
                    if ("TIMER".equals(bcVar.f4522b)) {
                        view.setTag("timerView");
                        m4934a((C2230bm) bcVar, (C2231bn) view);
                    }
                    if (str3.equals(bcVar.f4522b)) {
                        ((C2403ek) view).mo28316a();
                    }
                    if (str.equals(bcVar.f4522b) && (view instanceof C2600j)) {
                        C2600j jVar = (C2600j) view;
                        C2237bq bqVar2 = (C2237bq) bcVar;
                        jVar.setScrollable(bqVar2.f4644B);
                        jVar.setReferenceContainer(this.f5036g.f5597l);
                        jVar.setRenderViewEventListener(this.f5036g.mo28520x());
                        jVar.setPlacementId(this.f5036g.f5589d);
                        jVar.setAllowAutoRedirection(this.f5036g.f5591f);
                        jVar.setCreativeId(this.f5036g.f5590e);
                        jVar.setImpressionId(this.f5036g.f5588c);
                        if (!bqVar2.f4643A) {
                            this.f5036g.mo28492a(jVar);
                        }
                    }
                }
            } else if (bcVar.f4524d.equalsIgnoreCase("card_scrollable")) {
                C2383ef efVar = (C2383ef) this.f5033c.mo28321a(m4940c(), bcVar, this.f5037h);
                if (efVar != null) {
                    this.f5041l = C2386eh.m4963a(efVar.getType(), this.f5035f, this);
                    C2385eg egVar = this.f5041l;
                    if (egVar != null) {
                        efVar.mo28256a((C2216be) bcVar, egVar, this.f5031a, m4942d(), this);
                        efVar.setLayoutParams(C2404el.m5006a(bcVar, viewGroup));
                        m4932a((View) efVar, bcVar);
                        viewGroup.addView(efVar);
                    }
                }
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.f5033c.mo28321a(m4940c(), bcVar, this.f5037h);
                if (viewGroup2 != null) {
                    ViewGroup b = mo28242b(viewGroup2, (C2216be) bcVar);
                    b.setLayoutParams(C2404el.m5006a(bcVar, viewGroup));
                    m4932a((View) b, bcVar);
                    viewGroup.addView(b);
                }
            }
        }
        return viewGroup;
    }

    /* renamed from: d */
    private int m4942d() {
        if (this.f5031a == 0) {
            return GravityCompat.START;
        }
        if (this.f5035f.mo27961c() - 1 == this.f5031a) {
            return GravityCompat.END;
        }
        return 1;
    }

    /* renamed from: a */
    public final void mo28241a() {
        this.f5042n = true;
        this.f5034e.clear();
        this.f5040k = null;
        C2385eg egVar = this.f5041l;
        if (egVar != null) {
            egVar.destroy();
            this.f5041l = null;
        }
    }

    /* renamed from: a */
    private void m4933a(final C2214bc bcVar, View view) {
        if (bcVar.f4528h) {
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C2368ec.this.f5039j.mo28237a(view, bcVar);
                }
            });
        }
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    private void m4935a(@NonNull final C2235bp bpVar, @NonNull C2390ej ejVar) {
        C2216be beVar = (C2216be) bpVar.f4540t;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(beVar == null || 0 == beVar.f4560z)) {
            currentTimeMillis = beVar.f4560z;
        }
        if (beVar != null) {
            beVar.f4560z = currentTimeMillis;
        }
        ejVar.setClickable(false);
        ejVar.setId(Integer.MAX_VALUE);
        ejVar.mo28271a(bpVar);
        if (bpVar.f4545y != null) {
            bpVar.mo27980a((C2235bp) bpVar.f4545y);
        }
        ejVar.setQuartileCompletedListener(new C2401c() {
            /* renamed from: a */
            public final void mo28250a(int i) {
                if (!C2368ec.this.f5036g.f5595j && (C2368ec.this.f5036g instanceof C2596i)) {
                    ((C2596i) C2368ec.this.f5036g).mo28613a(bpVar, i);
                    if (3 == i) {
                        try {
                            C2596i iVar = (C2596i) C2368ec.this.f5036g;
                            C2235bp bpVar = bpVar;
                            if (!((Boolean) bpVar.f4542v.get("didSignalVideoCompleted")).booleanValue()) {
                                iVar.mo28514r();
                                C2552c h = iVar.mo28497h();
                                if (h != null) {
                                    h.mo28551h();
                                }
                            }
                            if (1 == iVar.getPlacementType()) {
                                iVar.mo28495c((C2214bc) bpVar);
                            }
                        } catch (Exception unused) {
                            C2368ec.f5029d;
                        }
                    }
                }
            }
        });
        ejVar.setPlaybackEventListener(new C2400b() {
            @SuppressLint({"SwitchIntDef"})
            /* renamed from: a */
            public final void mo28251a(int i) {
                if (!C2368ec.this.f5036g.f5595j && (C2368ec.this.f5036g instanceof C2596i)) {
                    if (i == 0) {
                        ((C2596i) C2368ec.this.f5036g).mo28621z();
                    } else if (i == 1) {
                        ((C2596i) C2368ec.this.f5036g).mo28615b(bpVar);
                    } else if (i == 2) {
                        ((C2596i) C2368ec.this.f5036g).mo28616c(bpVar);
                    } else if (i == 3) {
                        ((C2596i) C2368ec.this.f5036g).mo28617d(bpVar);
                    } else if (i == 5) {
                        try {
                            ((C2596i) C2368ec.this.f5036g).mo28620g(bpVar);
                        } catch (Exception e) {
                            C2368ec.f5029d;
                            C2463fd.m5161a().mo28382a(new C2495fz(e));
                        }
                    }
                }
            }
        });
        ejVar.setMediaErrorListener(new C2399a() {
            /* renamed from: a */
            public final void mo28252a() {
                if (!C2368ec.this.f5036g.f5595j && (C2368ec.this.f5036g instanceof C2596i)) {
                    try {
                        ((C2596i) C2368ec.this.f5036g).mo28612a(bpVar);
                    } catch (Exception unused) {
                        C2368ec.f5029d;
                    }
                }
            }
        });
        if (!this.f5036g.f5595j) {
            C2542h hVar = this.f5036g;
            if (hVar instanceof C2596i) {
                try {
                    ((C2596i) hVar).mo28614a(ejVar);
                } catch (Exception unused) {
                }
            }
        }
    }
}
