package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2325df.C2326a;
import com.inmobi.media.C2325df.C2328c;
import com.inmobi.media.C2426eq.C2435i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.media.dd */
/* compiled from: NativeAdTracker */
public class C2319dd {

    /* renamed from: a */
    static final Map<Context, C2312da> f4900a = new WeakHashMap();

    /* renamed from: b */
    private static final String f4901b = "dd";

    /* renamed from: c */
    private static final Map<Context, C2325df> f4902c = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Map<View, C2323a> f4903d = new HashMap();

    /* renamed from: e */
    private static final C2314a f4904e = new C2314a() {
        /* renamed from: a */
        public final void mo28171a(View view, Object obj) {
            ((C2542h) obj).mo28487a(view);
        }
    };

    /* renamed from: f */
    private static final C2326a f4905f = new C2326a() {

        /* renamed from: a */
        private final Rect f4908a = new Rect();

        /* renamed from: a */
        public final boolean mo28178a(@Nullable View view, @Nullable View view2, int i, @NonNull Object obj) {
            if (!(obj instanceof C2542h) || ((C2542h) obj).f5595j) {
                return false;
            }
            if (view2 instanceof C2390ej) {
                C2381ed mediaPlayer = ((C2390ej) view2).getMediaPlayer();
                if (!(mediaPlayer == null || 3 == mediaPlayer.f5067a)) {
                    return false;
                }
            }
            if (view2 == null || view == null || !view2.isShown() || view.getParent() == null || !view2.getGlobalVisibleRect(this.f4908a)) {
                return false;
            }
            long height = ((long) this.f4908a.height()) * ((long) this.f4908a.width());
            long width = ((long) view.getWidth()) * ((long) view.getHeight());
            if (width > 0 && height * 100 >= ((long) i) * width) {
                return true;
            }
            return false;
        }
    };

    /* renamed from: g */
    private boolean f4906g;

    /* renamed from: h */
    private int f4907h;

    /* renamed from: com.inmobi.media.dd$a */
    /* compiled from: NativeAdTracker */
    public interface C2323a {
        /* renamed from: a */
        void mo28179a(View view, boolean z);
    }

    C2319dd(int i) {
        this.f4907h = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28176a(@NonNull Context context, @NonNull View view, @NonNull C2542h hVar, @NonNull C2435i iVar) {
        C2312da a = m4761a(context, iVar);
        if (this.f4907h != 0) {
            a.mo28166a(view, hVar, iVar.f5231a, iVar.f5232b);
        } else {
            a.mo28166a(view, hVar, iVar.f5236f, iVar.f5237g);
        }
    }

    /* renamed from: a */
    private C2312da m4761a(@NonNull Context context, @NonNull C2435i iVar) {
        C2312da daVar = (C2312da) f4900a.get(context);
        if (daVar == null) {
            if (context instanceof Activity) {
                daVar = new C2312da(iVar, new C2306cz(f4905f, (Activity) context), f4904e);
                if (!this.f4906g) {
                    this.f4906g = true;
                }
            } else {
                daVar = new C2312da(iVar, new C2324de(f4905f, iVar), f4904e);
            }
            f4900a.put(context, daVar);
        }
        return daVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28177a(@NonNull Context context, @NonNull C2542h hVar) {
        C2312da daVar = (C2312da) f4900a.get(context);
        if (daVar != null) {
            daVar.mo28167a((Object) hVar);
            if (!daVar.mo28168b()) {
                mo28173a(context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28173a(@NonNull Context context) {
        C2312da daVar = (C2312da) f4900a.remove(context);
        if (daVar != null) {
            daVar.mo28169c();
        }
        if ((context instanceof Activity) && f4900a.isEmpty() && this.f4906g) {
            this.f4906g = false;
        }
    }

    /* renamed from: a */
    public final void mo28174a(@NonNull Context context, View view, @NonNull C2542h hVar) {
        C2325df dfVar = (C2325df) f4902c.get(context);
        if (dfVar != null) {
            dfVar.mo28183a((Object) hVar);
            if (!dfVar.mo28185g()) {
                m4765d(context);
            }
        }
        f4903d.remove(view);
    }

    /* renamed from: d */
    private void m4765d(@NonNull Context context) {
        C2325df dfVar = (C2325df) f4902c.remove(context);
        if (dfVar != null) {
            dfVar.mo28160e();
        }
        if ((context instanceof Activity) && f4902c.isEmpty() && this.f4906g) {
            this.f4906g = false;
        }
    }

    /* renamed from: b */
    static void m4763b(Context context) {
        C2312da daVar = (C2312da) f4900a.get(context);
        if (daVar != null) {
            daVar.mo28165a();
        }
    }

    /* renamed from: c */
    static void m4764c(Context context) {
        C2312da daVar = (C2312da) f4900a.get(context);
        if (daVar != null) {
            daVar.f4875a.mo28184f();
            daVar.f4877c.removeCallbacksAndMessages(null);
            daVar.f4876b.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28175a(@NonNull Context context, @NonNull View view, @NonNull C2542h hVar, @NonNull C2323a aVar, @NonNull C2435i iVar) {
        C2325df dfVar;
        C2325df dfVar2 = (C2325df) f4902c.get(context);
        if (dfVar2 == null) {
            boolean z = context instanceof Activity;
            if (z) {
                dfVar = new C2306cz(f4905f, (Activity) context);
            } else {
                dfVar = new C2324de(f4905f, iVar);
            }
            dfVar.f4913c = new C2328c() {
                /* renamed from: a */
                public final void mo28170a(List<View> list, List<View> list2) {
                    for (View view : list) {
                        C2323a aVar = (C2323a) C2319dd.f4903d.get(view);
                        if (aVar != null) {
                            aVar.mo28179a(view, true);
                        }
                    }
                    for (View view2 : list2) {
                        C2323a aVar2 = (C2323a) C2319dd.f4903d.get(view2);
                        if (aVar2 != null) {
                            aVar2.mo28179a(view2, false);
                        }
                    }
                }
            };
            f4902c.put(context, dfVar);
            if (z && !this.f4906g) {
                this.f4906g = true;
            }
            dfVar2 = dfVar;
        }
        f4903d.put(view, aVar);
        if (this.f4907h != 0) {
            dfVar2.mo28182a(view, hVar, iVar.f5235e);
        } else {
            dfVar2.mo28182a(view, hVar, iVar.f5238h);
        }
    }
}
