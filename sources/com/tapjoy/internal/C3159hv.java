package com.tapjoy.internal;

import android.graphics.Point;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnitConstants.String;
import java.net.URL;

/* renamed from: com.tapjoy.internal.hv */
public final class C3159hv {

    /* renamed from: d */
    public static final C2896bi f7491d = new C2896bi() {
        /* renamed from: b */
        private static Point m7301b(C1812bn bnVar) {
            bnVar.mo18067h();
            Point point = null;
            while (bnVar.mo18069j()) {
                if ("offset".equals(bnVar.mo18071l())) {
                    bnVar.mo18067h();
                    int i = 0;
                    int i2 = 0;
                    while (bnVar.mo18069j()) {
                        String l = bnVar.mo18071l();
                        if ("x".equals(l)) {
                            i = bnVar.mo18077r();
                        } else if ("y".equals(l)) {
                            i2 = bnVar.mo18077r();
                        } else {
                            bnVar.mo18078s();
                        }
                    }
                    bnVar.mo18068i();
                    point = new Point(i, i2);
                } else {
                    bnVar.mo18078s();
                }
            }
            bnVar.mo18068i();
            return point;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            bnVar.mo18067h();
            C3163hx hxVar = null;
            Point point = null;
            Point point2 = null;
            while (bnVar.mo18069j()) {
                String l = bnVar.mo18071l();
                if (MessengerShareContentUtility.MEDIA_IMAGE.equals(l)) {
                    String m = bnVar.mo18072m();
                    if (!C1852jq.m3669c(m)) {
                        hxVar = new C3163hx(new URL(m));
                    }
                } else if (String.LANDSCAPE.equals(l)) {
                    point = m7301b(bnVar);
                } else if (String.PORTRAIT.equals(l)) {
                    point2 = m7301b(bnVar);
                } else {
                    bnVar.mo18078s();
                }
            }
            bnVar.mo18068i();
            return new C3159hv(hxVar, point, point2);
        }
    };

    /* renamed from: a */
    public final C3163hx f7492a;

    /* renamed from: b */
    public final Point f7493b;

    /* renamed from: c */
    public final Point f7494c;

    public C3159hv(C3163hx hxVar, Point point, Point point2) {
        this.f7492a = hxVar;
        this.f7493b = point;
        this.f7494c = point2;
    }
}
