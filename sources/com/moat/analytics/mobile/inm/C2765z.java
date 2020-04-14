package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.graphics.Rect;
import android.location.Location;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.z */
class C2765z {

    /* renamed from: a */
    String f6195a = "{}";

    /* renamed from: b */
    private C2769c f6196b = new C2769c();

    /* renamed from: c */
    private JSONObject f6197c;

    /* renamed from: d */
    private Rect f6198d;

    /* renamed from: e */
    private Rect f6199e;

    /* renamed from: f */
    private JSONObject f6200f;

    /* renamed from: g */
    private JSONObject f6201g;

    /* renamed from: h */
    private Location f6202h;

    /* renamed from: i */
    private Map<String, Object> f6203i = new HashMap();

    /* renamed from: com.moat.analytics.mobile.inm.z$a */
    static class C2767a {

        /* renamed from: a */
        int f6204a = 0;

        /* renamed from: b */
        final Set<Rect> f6205b = new HashSet();

        /* renamed from: c */
        boolean f6206c = false;

        C2767a() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.z$b */
    static class C2768b {

        /* renamed from: a */
        final View f6207a;

        /* renamed from: b */
        final Rect f6208b;

        C2768b(View view, C2768b bVar) {
            this.f6207a = view;
            this.f6208b = bVar != null ? C2765z.m6401b(view, bVar.f6208b.left, bVar.f6208b.top) : C2765z.m6412k(view);
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.z$c */
    static class C2769c {

        /* renamed from: a */
        Rect f6209a = new Rect(0, 0, 0, 0);

        /* renamed from: b */
        double f6210b = 0.0d;

        /* renamed from: c */
        double f6211c = 0.0d;

        C2769c() {
        }
    }

    C2765z() {
    }

    @VisibleForTesting
    /* renamed from: a */
    static int m6386a(Rect rect, Set<Rect> set) {
        int i = 0;
        if (set.isEmpty()) {
            return 0;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        arrayList.addAll(set);
        Collections.sort(arrayList, new Comparator<Rect>() {
            /* renamed from: a */
            public final int compare(Rect rect, Rect rect2) {
                return Integer.valueOf(rect.top).compareTo(Integer.valueOf(rect2.top));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Rect rect2 : arrayList) {
            arrayList2.add(Integer.valueOf(rect2.left));
            arrayList2.add(Integer.valueOf(rect2.right));
        }
        Collections.sort(arrayList2);
        int i2 = 0;
        while (i < arrayList2.size() - 1) {
            int i3 = i + 1;
            if (!((Integer) arrayList2.get(i)).equals(arrayList2.get(i3))) {
                Rect rect3 = new Rect(((Integer) arrayList2.get(i)).intValue(), rect.top, ((Integer) arrayList2.get(i3)).intValue(), rect.bottom);
                int i4 = rect.top;
                for (Rect rect4 : arrayList) {
                    if (Rect.intersects(rect4, rect3)) {
                        if (rect4.bottom > i4) {
                            i2 += rect3.width() * (rect4.bottom - Math.max(i4, rect4.top));
                            i4 = rect4.bottom;
                        }
                        if (rect4.bottom == rect3.bottom) {
                            break;
                        }
                    }
                }
            }
            i = i3;
        }
        return i2;
    }

    /* renamed from: a */
    private static Rect m6387a(DisplayMetrics displayMetrics) {
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* renamed from: a */
    static Rect m6388a(View view) {
        return view != null ? m6412k(view) : new Rect(0, 0, 0, 0);
    }

    @VisibleForTesting
    /* renamed from: a */
    static C2767a m6390a(Rect rect, @NonNull View view) {
        String str = "VisibilityInfo";
        C2767a aVar = new C2767a();
        try {
            ArrayDeque i = m6410i(view);
            if (i != null) {
                if (!i.isEmpty()) {
                    C2735p.m6314b(2, str, view, "starting covering rect search");
                    C2768b bVar = null;
                    loop0:
                    while (true) {
                        if (i.isEmpty()) {
                            break;
                        }
                        View view2 = (View) i.pollLast();
                        C2768b bVar2 = new C2768b(view2, bVar);
                        if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                            ViewGroup viewGroup = (ViewGroup) view2.getParent();
                            int childCount = viewGroup.getChildCount();
                            boolean z = false;
                            for (int i2 = 0; i2 < childCount; i2++) {
                                if (aVar.f6204a >= 500) {
                                    C2735p.m6310a(3, str, (Object) null, "Short-circuiting cover retrieval, reached max");
                                    break loop0;
                                }
                                View childAt = viewGroup.getChildAt(i2);
                                if (childAt == view2) {
                                    z = true;
                                } else {
                                    aVar.f6204a++;
                                    if (m6397a(childAt, view2, z)) {
                                        m6403b(new C2768b(childAt, bVar), rect, aVar);
                                        if (aVar.f6206c) {
                                            return aVar;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                        bVar = bVar2;
                    }
                    return aVar;
                }
            }
            return aVar;
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: a */
    private static C2769c m6391a(View view, Rect rect, boolean z, boolean z2, boolean z3) {
        C2769c cVar = new C2769c();
        int b = m6398b(rect);
        if (view != null && z && z2 && !z3 && b > 0) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            if (m6396a(view, rect2)) {
                int b2 = m6398b(rect2);
                if (b2 < b) {
                    C2735p.m6314b(2, "VisibilityInfo", null, "Ad is clipped");
                }
                if (view.getRootView() instanceof ViewGroup) {
                    cVar.f6209a = rect2;
                    C2767a a = m6390a(rect2, view);
                    if (a.f6206c) {
                        cVar.f6211c = 1.0d;
                    } else {
                        int a2 = m6386a(rect2, a.f6205b);
                        if (a2 > 0) {
                            double d = (double) a2;
                            double d2 = (double) b2;
                            Double.isNaN(d2);
                            double d3 = d2 * 1.0d;
                            Double.isNaN(d);
                            cVar.f6211c = d / d3;
                        }
                        double d4 = (double) (b2 - a2);
                        double d5 = (double) b;
                        Double.isNaN(d5);
                        double d6 = d5 * 1.0d;
                        Double.isNaN(d4);
                        cVar.f6210b = d4 / d6;
                    }
                }
            }
        }
        return cVar;
    }

    /* renamed from: a */
    private static Map<String, String> m6392a(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put("x", String.valueOf(rect.left));
        hashMap.put("y", String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, String> m6393a(Rect rect, DisplayMetrics displayMetrics) {
        return m6392a(m6399b(rect, displayMetrics));
    }

    /* renamed from: a */
    private static JSONObject m6394a(Location location) {
        Map b = m6402b(location);
        if (b == null) {
            return null;
        }
        return new JSONObject(b);
    }

    /* renamed from: a */
    private static void m6395a(C2768b bVar, Rect rect, C2767a aVar) {
        Rect rect2 = bVar.f6208b;
        if (rect2.setIntersect(rect, rect2)) {
            if (VERSION.SDK_INT >= 22) {
                Rect rect3 = new Rect(0, 0, 0, 0);
                if (m6396a(bVar.f6207a, rect3)) {
                    Rect rect4 = bVar.f6208b;
                    if (rect4.setIntersect(rect3, rect4)) {
                        rect2 = rect4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (C2750w.m6348a().f6157c) {
                C2735p.m6314b(2, "VisibilityInfo", bVar.f6207a, String.format(Locale.ROOT, "Covered by %s-%s alpha=%f", new Object[]{bVar.f6207a.getClass().getName(), rect2.toString(), Float.valueOf(bVar.f6207a.getAlpha())}));
            }
            aVar.f6205b.add(rect2);
            if (rect2.contains(rect)) {
                aVar.f6206c = true;
            }
        }
    }

    /* renamed from: a */
    private static boolean m6396a(View view, Rect rect) {
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationInWindow(iArr);
        int[] iArr2 = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(iArr2);
        rect.offset(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
        return true;
    }

    /* renamed from: a */
    private static boolean m6397a(View view, View view2, boolean z) {
        return z ? VERSION.SDK_INT < 21 || view.getZ() >= view2.getZ() : VERSION.SDK_INT >= 21 && view.getZ() > view2.getZ();
    }

    /* renamed from: b */
    private static int m6398b(Rect rect) {
        return rect.width() * rect.height();
    }

    /* renamed from: b */
    private static Rect m6399b(Rect rect, DisplayMetrics displayMetrics) {
        float f = displayMetrics.density;
        if (f == 0.0f) {
            return rect;
        }
        return new Rect(Math.round(((float) rect.left) / f), Math.round(((float) rect.top) / f), Math.round(((float) rect.right) / f), Math.round(((float) rect.bottom) / f));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Rect m6401b(View view, int i, int i2) {
        int left = i + view.getLeft();
        int top = i2 + view.getTop();
        return new Rect(left, top, view.getWidth() + left, view.getHeight() + top);
    }

    /* renamed from: b */
    private static Map<String, String> m6402b(Location location) {
        if (location == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.toString(location.getLatitude()));
        hashMap.put("longitude", Double.toString(location.getLongitude()));
        hashMap.put("timestamp", Long.toString(location.getTime()));
        hashMap.put("horizontalAccuracy", Float.toString(location.getAccuracy()));
        return hashMap;
    }

    /* renamed from: b */
    private static void m6403b(C2768b bVar, Rect rect, C2767a aVar) {
        boolean z;
        if (m6409h(bVar.f6207a)) {
            if (bVar.f6207a instanceof ViewGroup) {
                int i = 0;
                z = !ViewGroup.class.equals(bVar.f6207a.getClass().getSuperclass()) || !m6411j(bVar.f6207a);
                ViewGroup viewGroup = (ViewGroup) bVar.f6207a;
                int childCount = viewGroup.getChildCount();
                while (i < childCount) {
                    int i2 = aVar.f6204a + 1;
                    aVar.f6204a = i2;
                    if (i2 <= 500) {
                        m6403b(new C2768b(viewGroup.getChildAt(i), bVar), rect, aVar);
                        if (!aVar.f6206c) {
                            i++;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                m6395a(bVar, rect, aVar);
            }
        }
    }

    /* renamed from: c */
    private static boolean m6404c(View view) {
        return VERSION.SDK_INT >= 19 ? view != null && view.isAttachedToWindow() : (view == null || view.getWindowToken() == null) ? false : true;
    }

    /* renamed from: d */
    private static boolean m6405d(View view) {
        return view != null && view.hasWindowFocus();
    }

    /* renamed from: e */
    private static boolean m6406e(View view) {
        return view == null || !view.isShown();
    }

    /* renamed from: f */
    private static float m6407f(View view) {
        if (view == null) {
            return 0.0f;
        }
        return m6408g(view);
    }

    /* renamed from: g */
    private static float m6408g(View view) {
        float alpha = view.getAlpha();
        while (view != null && view.getParent() != null && ((double) alpha) != 0.0d && (view.getParent() instanceof View)) {
            alpha *= ((View) view.getParent()).getAlpha();
            view = (View) view.getParent();
        }
        return alpha;
    }

    /* renamed from: h */
    private static boolean m6409h(View view) {
        return view.isShown() && ((double) view.getAlpha()) > 0.0d;
    }

    /* renamed from: i */
    private static ArrayDeque<View> m6410i(@NonNull View view) {
        ArrayDeque<View> arrayDeque = new ArrayDeque<>();
        int i = 0;
        View view2 = view;
        while (true) {
            if (view2.getParent() == null && view2 != view.getRootView()) {
                break;
            }
            i++;
            if (i <= 50) {
                arrayDeque.add(view2);
                if (!(view2.getParent() instanceof View)) {
                    break;
                }
                view2 = (View) view2.getParent();
            } else {
                C2735p.m6310a(3, "VisibilityInfo", (Object) null, "Short-circuiting chain retrieval, reached max");
                break;
            }
        }
        return arrayDeque;
    }

    /* renamed from: j */
    private static boolean m6411j(View view) {
        return VERSION.SDK_INT < 19 || view.getBackground() == null || view.getBackground().getAlpha() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static Rect m6412k(View view) {
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    /* renamed from: l */
    private static DisplayMetrics m6413l(View view) {
        if (VERSION.SDK_INT >= 17 && C2695a.f6007a != null) {
            Activity activity = (Activity) C2695a.f6007a.get();
            if (activity != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                return displayMetrics;
            }
        }
        return view.getContext().getResources().getDisplayMetrics();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29095a(String str, View view) {
        HashMap hashMap = new HashMap();
        String str2 = "{}";
        if (view != null) {
            try {
                DisplayMetrics l = m6413l(view);
                boolean c = m6404c(view);
                boolean d = m6405d(view);
                boolean e = m6406e(view);
                float f = m6407f(view);
                hashMap.put("dr", Float.valueOf(l.density));
                hashMap.put("dv", Double.valueOf(C2738s.m6318a()));
                hashMap.put("adKey", str);
                boolean z = false;
                hashMap.put("isAttached", Integer.valueOf(c ? 1 : 0));
                hashMap.put("inFocus", Integer.valueOf(d ? 1 : 0));
                hashMap.put("isHidden", Integer.valueOf(e ? 1 : 0));
                hashMap.put("opacity", Float.valueOf(f));
                Rect a = m6387a(l);
                Rect a2 = m6388a(view);
                C2769c a3 = m6391a(view, a2, c, d, e);
                if (this.f6197c == null || a3.f6210b != this.f6196b.f6210b || !a3.f6209a.equals(this.f6196b.f6209a) || a3.f6211c != this.f6196b.f6211c) {
                    this.f6196b = a3;
                    this.f6197c = new JSONObject(m6393a(this.f6196b.f6209a, l));
                    z = true;
                }
                hashMap.put("coveredPercent", Double.valueOf(a3.f6211c));
                if (this.f6201g == null || !a.equals(this.f6199e)) {
                    this.f6199e = a;
                    this.f6201g = new JSONObject(m6393a(a, l));
                    z = true;
                }
                if (this.f6200f == null || !a2.equals(this.f6198d)) {
                    this.f6198d = a2;
                    this.f6200f = new JSONObject(m6393a(a2, l));
                    z = true;
                }
                if (this.f6203i == null || !hashMap.equals(this.f6203i)) {
                    this.f6203i = hashMap;
                    z = true;
                }
                Location b = C2732o.m6286a().mo29073b();
                if (!C2732o.m6291a(b, this.f6202h)) {
                    this.f6202h = b;
                    z = true;
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject(this.f6203i);
                    jSONObject.accumulate("screen", this.f6201g);
                    jSONObject.accumulate(ViewHierarchyConstants.VIEW_KEY, this.f6200f);
                    jSONObject.accumulate(String.VISIBLE, this.f6197c);
                    jSONObject.accumulate("maybe", this.f6197c);
                    jSONObject.accumulate("visiblePercent", Double.valueOf(this.f6196b.f6210b));
                    if (b != null) {
                        jSONObject.accumulate(Param.LOCATION, m6394a(b));
                    }
                    this.f6195a = jSONObject.toString();
                }
            } catch (Exception e2) {
                C2726m.m6274a(e2);
                this.f6195a = str2;
            }
        }
    }
}
