package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.C3145hk.C3146a;
import java.util.Observer;

/* renamed from: com.tapjoy.internal.fx */
public final class C3086fx extends C3145hk {

    /* renamed from: b */
    private final C3088fz f7276b = new C3088fz() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo30140a() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* synthetic */ TJPlacement mo30138a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            C3146a aVar = (C3146a) obj;
            TJPlacement createPlacement = TJPlacementManager.createPlacement(TapjoyConnectCore.getContext(), aVar.f7457b, false, tJPlacementListener);
            createPlacement.pushId = aVar.f7456a;
            return createPlacement;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ String mo30139a(Object obj) {
            C3146a aVar = (C3146a) obj;
            if (aVar != null) {
                return aVar.f7457b;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final /* synthetic */ C3089a mo30153b(Object obj) {
            C3146a aVar = (C3146a) obj;
            return new C3089a(aVar, aVar.f7459d);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo30152a(Observer observer) {
            if (TapjoyConnectCore.isViewOpen()) {
                TJPlacementManager.dismissContentShowing(true);
            }
            return super.mo30152a(observer);
        }
    };

    /* renamed from: a */
    public static void m7117a() {
    }

    static {
        C3145hk.m7273a((C3145hk) new C3086fx());
    }

    private C3086fx() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo30151b() {
        return this.f7276b.f7278b != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30150a(C3146a aVar) {
        this.f7276b.mo30154c(aVar);
    }
}
