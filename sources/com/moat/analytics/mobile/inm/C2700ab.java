package com.moat.analytics.mobile.inm;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.moat.analytics.mobile.inm.p037a.p039b.C2698a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.inm.ab */
class C2700ab {

    /* renamed from: a */
    private static final LinkedHashSet<String> f6014a = new LinkedHashSet<>();

    C2700ab() {
    }

    @NonNull
    /* renamed from: a */
    static C2698a<WebView> m6157a(ViewGroup viewGroup, boolean z) {
        String str = "WebViewHound";
        if (viewGroup == null) {
            try {
                return C2698a.m6150a();
            } catch (Exception unused) {
                return C2698a.m6150a();
            }
        } else if (viewGroup instanceof WebView) {
            return C2698a.m6151a((WebView) viewGroup);
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.add(viewGroup);
            Object obj = null;
            int i = 0;
            while (!linkedList.isEmpty() && i < 100) {
                i++;
                ViewGroup viewGroup2 = (ViewGroup) linkedList.poll();
                int childCount = viewGroup2.getChildCount();
                Object obj2 = obj;
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        obj = obj2;
                        break;
                    }
                    View childAt = viewGroup2.getChildAt(i2);
                    if (childAt instanceof WebView) {
                        C2735p.m6310a(3, str, (Object) childAt, "Found WebView");
                        if (z || m6158a(String.valueOf(childAt.hashCode()))) {
                            if (obj2 != null) {
                                C2735p.m6310a(3, str, (Object) childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                                C2735p.m6313a("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                                obj = null;
                                break;
                            }
                            obj2 = (WebView) childAt;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        linkedList.add((ViewGroup) childAt);
                    }
                    i2++;
                }
            }
            return C2698a.m6152b(obj);
        }
    }

    /* renamed from: a */
    private static boolean m6158a(String str) {
        try {
            boolean add = f6014a.add(str);
            if (f6014a.size() > 50) {
                Iterator it = f6014a.iterator();
                for (int i = 0; i < 25 && it.hasNext(); i++) {
                    it.next();
                    it.remove();
                }
            }
            C2735p.m6310a(3, "WebViewHound", (Object) null, add ? "Newly Found WebView" : "Already Found WebView");
            return add;
        } catch (Exception e) {
            C2726m.m6274a(e);
            return false;
        }
    }
}
