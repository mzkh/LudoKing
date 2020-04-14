package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.internal.C3081fs.C3082a;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.tapjoy.internal.fp */
public final class C3076fp extends C3118gt implements Observer {

    /* renamed from: b */
    private final Map f7255b = new HashMap();

    /* renamed from: c */
    private final C3065fi f7256c = new C3065fi();

    /* renamed from: d */
    private boolean f7257d;

    /* renamed from: e */
    private final C3088fz f7258e = new C3088fz() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ String mo30139a(Object obj) {
            return "AppLaunch";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo30140a() {
            return super.mo30140a() && !C3145hk.m7275c();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* synthetic */ TJPlacement mo30138a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "AppLaunch", true, tJPlacementListener);
        }
    };

    /* renamed from: a */
    public static void m7102a() {
    }

    static {
        C3118gt.f7350a = new C3076fp();
    }

    private C3076fp() {
    }

    public final void update(Observable observable, Object obj) {
        C3082a aVar = C3081fs.f7267d;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r3 == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        if (r5.f7256c.mo30120a() != false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        r5.f7258e.mo30154c(null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30136a(android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 == 0) goto L_0x0055
            int r1 = r6.getTaskId()
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            goto L_0x0053
        L_0x000c:
            android.content.Intent r6 = r6.getIntent()
            if (r6 == 0) goto L_0x0053
            java.util.Set r2 = r6.getCategories()
            if (r2 == 0) goto L_0x002e
            java.lang.String r4 = "android.intent.category.LAUNCHER"
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = r6.getAction()
            java.lang.String r4 = "android.intent.action.MAIN"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x002e
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            if (r2 != 0) goto L_0x0032
            goto L_0x0053
        L_0x0032:
            android.content.ComponentName r6 = r6.getComponent()
            if (r6 != 0) goto L_0x0039
            goto L_0x0053
        L_0x0039:
            java.lang.String r6 = r6.getClassName()
            java.util.Map r2 = r5.f7255b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Object r6 = r2.put(r6, r4)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x0052
            int r6 = r6.intValue()
            if (r6 != r1) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r3 = 1
        L_0x0053:
            if (r3 != 0) goto L_0x0061
        L_0x0055:
            boolean r6 = r5.f7257d
            if (r6 != 0) goto L_0x0067
            com.tapjoy.internal.fi r6 = r5.f7256c
            boolean r6 = r6.mo30120a()
            if (r6 == 0) goto L_0x0067
        L_0x0061:
            com.tapjoy.internal.fz r6 = r5.f7258e
            r1 = 0
            r6.mo30154c(r1)
        L_0x0067:
            r5.f7257d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3076fp.mo30136a(android.app.Activity):void");
    }
}
