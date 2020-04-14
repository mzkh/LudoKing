package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tapjoy.internal.hr */
public final class C3151hr extends C1844hq {

    /* renamed from: d */
    public static final C2896bi f7467d = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            return new C3151hr(bnVar);
        }
    };

    /* renamed from: a */
    public ArrayList f7468a = new ArrayList();

    /* renamed from: b */
    public Map f7469b;

    /* renamed from: c */
    public float f7470c;

    public C3151hr(C1812bn bnVar) {
        bnVar.mo18067h();
        String str = null;
        String str2 = null;
        while (bnVar.mo18069j()) {
            String l = bnVar.mo18071l();
            if ("layouts".equals(l)) {
                bnVar.mo18053a((List) this.f7468a, C3170ia.f7524d);
            } else if ("meta".equals(l)) {
                this.f7469b = bnVar.mo18059d();
            } else if ("max_show_time".equals(l)) {
                this.f7470c = (float) bnVar.mo18075p();
            } else if ("ad_content".equals(l)) {
                str = bnVar.mo18056b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str2 = bnVar.mo18056b();
            } else {
                bnVar.mo18078s();
            }
        }
        bnVar.mo18068i();
        ArrayList arrayList = this.f7468a;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C3170ia iaVar = (C3170ia) it.next();
                if (iaVar.f7527c != null) {
                    Iterator it2 = iaVar.f7527c.iterator();
                    while (it2.hasNext()) {
                        C3167hz hzVar = (C3167hz) it2.next();
                        if (hzVar.f7518i == null) {
                            hzVar.f7518i = str;
                        }
                        if (hzVar.f7517h == null) {
                            hzVar.f7517h = str2;
                        }
                    }
                }
            }
        }
    }
}
