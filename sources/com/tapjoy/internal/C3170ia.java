package com.tapjoy.internal;

import android.graphics.PointF;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tapjoy.internal.ia */
public final class C3170ia {

    /* renamed from: d */
    public static final C2896bi f7524d = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            return new C3170ia(bnVar);
        }
    };

    /* renamed from: a */
    public C2859aa f7525a = C2859aa.UNSPECIFIED;

    /* renamed from: b */
    public PointF f7526b;

    /* renamed from: c */
    public ArrayList f7527c = new ArrayList();

    public C3170ia(C1812bn bnVar) {
        bnVar.mo18067h();
        while (bnVar.mo18069j()) {
            String l = bnVar.mo18071l();
            if ("buttons".equals(l)) {
                if (bnVar.mo18070k() == C2908bs.BEGIN_ARRAY) {
                    bnVar.mo18053a((List) this.f7527c, C3167hz.f7509n);
                } else {
                    bnVar.mo18078s();
                }
            } else if ("window_aspect_ratio".equals(l)) {
                if (bnVar.mo18055a()) {
                    PointF pointF = new PointF();
                    bnVar.mo18067h();
                    while (bnVar.mo18069j()) {
                        String l2 = bnVar.mo18071l();
                        if ("width".equals(l2)) {
                            pointF.x = (float) bnVar.mo18075p();
                        } else if ("height".equals(l2)) {
                            pointF.y = (float) bnVar.mo18075p();
                        } else {
                            bnVar.mo18078s();
                        }
                    }
                    bnVar.mo18068i();
                    if (!(pointF.x == 0.0f || pointF.y == 0.0f)) {
                        this.f7526b = pointF;
                    }
                } else {
                    bnVar.mo18078s();
                }
            } else if ("orientation".equals(l)) {
                String m = bnVar.mo18072m();
                if (String.LANDSCAPE.equals(m)) {
                    this.f7525a = C2859aa.LANDSCAPE;
                } else if (String.PORTRAIT.equals(m)) {
                    this.f7525a = C2859aa.PORTRAIT;
                }
            } else {
                bnVar.mo18078s();
            }
        }
        bnVar.mo18068i();
    }
}
