package com.inmobi.media;

import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.w */
/* compiled from: NativeLoadMarkupInContainerNative */
final class C2665w extends C2141aa<Integer> {
    @NonNull

    /* renamed from: a */
    private final WeakReference<C2663v> f5953a;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(Object obj) {
        Integer num = (Integer) obj;
        C2663v vVar = (C2663v) this.f5953a.get();
        if (vVar != null) {
            if (num.intValue() != 0) {
                vVar.mo28751a(new WeakReference<>(vVar.mo28777l()));
            } else if (2 == vVar.mo28770f()) {
                vVar.f5854b = 5;
                C2452f p = vVar.mo28781p();
                C2600j J = vVar.mo28730J();
                C2636a l = vVar.mo28777l();
                if (p instanceof C2542h) {
                    C2542h hVar = (C2542h) p;
                    hVar.f5605t = J;
                    hVar.f5606u = vVar.f5861i;
                    vVar.mo28728H();
                    if (l != null) {
                        String str = C2663v.f5947r;
                        l.mo27783b();
                    }
                    return;
                }
                if (l != null) {
                    String str2 = C2663v.f5947r;
                    l.mo27778a((C2620l) vVar, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                }
            }
        }
    }

    C2665w(@NonNull C2663v vVar) {
        this.f5953a = new WeakReference<>(vVar);
    }

    public final void run() {
        C2663v vVar = (C2663v) this.f5953a.get();
        if (vVar == null) {
            mo27773b(Integer.valueOf(13));
        } else {
            mo27773b(Integer.valueOf(vVar.mo28757b(vVar.mo28777l())));
        }
    }
}
