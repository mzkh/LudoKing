package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.tapjoy.TJAdUnitConstants.String;

/* renamed from: com.tapjoy.internal.bj */
public final class C2897bj {

    /* renamed from: a */
    public static final C2896bi f6693a = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            Point point = new Point();
            bnVar.mo18067h();
            while (bnVar.mo18069j()) {
                String l = bnVar.mo18071l();
                if ("x".equals(l)) {
                    point.x = bnVar.mo18077r();
                } else if ("y".equals(l)) {
                    point.y = bnVar.mo18077r();
                } else {
                    bnVar.mo18078s();
                }
            }
            bnVar.mo18068i();
            return point;
        }
    };

    /* renamed from: b */
    public static final C2896bi f6694b = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            Rect rect = new Rect();
            int i = C29003.f6695a[bnVar.mo18070k().ordinal()];
            if (i == 1) {
                bnVar.mo18065f();
                rect.left = bnVar.mo18077r();
                rect.top = bnVar.mo18077r();
                rect.right = bnVar.mo18077r();
                rect.bottom = bnVar.mo18077r();
                while (bnVar.mo18069j()) {
                    bnVar.mo18078s();
                }
                bnVar.mo18066g();
            } else if (i == 2) {
                bnVar.mo18067h();
                while (bnVar.mo18069j()) {
                    String l = bnVar.mo18071l();
                    if ("left".equals(l)) {
                        rect.left = bnVar.mo18077r();
                    } else if ("top".equals(l)) {
                        rect.top = bnVar.mo18077r();
                    } else if (String.RIGHT.equals(l)) {
                        rect.right = bnVar.mo18077r();
                    } else if (String.BOTTOM.equals(l)) {
                        rect.bottom = bnVar.mo18077r();
                    } else {
                        bnVar.mo18078s();
                    }
                }
                bnVar.mo18068i();
            } else {
                StringBuilder sb = new StringBuilder("Unexpected token: ");
                sb.append(bnVar.mo18070k());
                throw new IllegalStateException(sb.toString());
            }
            return rect;
        }
    };

    /* renamed from: com.tapjoy.internal.bj$3 */
    static /* synthetic */ class C29003 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6695a = new int[C2908bs.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.tapjoy.internal.bs[] r0 = com.tapjoy.internal.C2908bs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6695a = r0
                int[] r0 = f6695a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C2908bs.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6695a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C2908bs.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2897bj.C29003.<clinit>():void");
        }
    }
}
