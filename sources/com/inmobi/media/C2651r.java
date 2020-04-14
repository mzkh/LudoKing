package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.inmobi.media.C2620l.C2636a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.r */
/* compiled from: IntLoadMarkupInContainerNative */
final class C2651r extends C2141aa<Boolean> {
    @NonNull

    /* renamed from: a */
    private final WeakReference<C2652s> f5927a;
    @NonNull

    /* renamed from: b */
    private final WeakReference<C2636a> f5928b;
    @Nullable

    /* renamed from: c */
    private int f5929c;

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(Object obj) {
        Boolean bool = (Boolean) obj;
        C2652s sVar = (C2652s) this.f5927a.get();
        if (sVar != null) {
            C2636a aVar = (C2636a) this.f5928b.get();
            if (aVar != null) {
                if (bool.booleanValue()) {
                    C2452f p = sVar.mo28781p();
                    C2600j J = sVar.mo28730J();
                    if (J != null) {
                        if (p instanceof C2542h) {
                            C2542h hVar = (C2542h) p;
                            hVar.f5605t = J;
                            hVar.f5606u = sVar.f5861i;
                        } else {
                            sVar.mo28860g(aVar);
                        }
                    }
                    sVar.mo28859f(aVar);
                } else if (this.f5929c != 0) {
                    sVar.mo28751a(this.f5928b);
                } else {
                    sVar.mo28860g(aVar);
                }
            }
        }
    }

    C2651r(@NonNull C2652s sVar, @NonNull C2636a aVar) {
        this.f5927a = new WeakReference<>(sVar);
        this.f5928b = new WeakReference<>(aVar);
    }

    public final void run() {
        C2652s sVar = (C2652s) this.f5927a.get();
        if (sVar == null) {
            mo27773b(Boolean.FALSE);
            return;
        }
        C2636a aVar = (C2636a) this.f5928b.get();
        if (aVar == null) {
            mo27773b(Boolean.FALSE);
            return;
        }
        C2153ac r = sVar.mo28783r();
        boolean z = true;
        if (r != null && !r.mo27810a(sVar.f5855c.mo28339a(sVar.mo28771g()).f5195a)) {
            this.f5929c = sVar.mo28757b(aVar);
            if (this.f5929c != 0) {
                z = false;
            }
            mo27773b(Boolean.valueOf(z));
            return;
        }
        mo27773b(Boolean.FALSE);
    }
}
