package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.u */
/* compiled from: LoadWithResponseWorker */
final class C2662u extends C2141aa<C2162aj> {
    @NonNull

    /* renamed from: a */
    private final WeakReference<C2212ba> f5945a;
    @NonNull

    /* renamed from: b */
    private byte[] f5946b;

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(@Nullable Object obj) {
        C2162aj ajVar = (C2162aj) obj;
        C2212ba baVar = (C2212ba) this.f5945a.get();
        if (baVar != null) {
            baVar.f4514a.mo28764c(ajVar);
        }
    }

    C2662u(@NonNull C2212ba baVar, @NonNull byte[] bArr) {
        this.f5945a = new WeakReference<>(baVar);
        this.f5946b = bArr;
    }

    public final void run() {
        C2240bt btVar;
        C2212ba baVar = (C2212ba) this.f5945a.get();
        if (baVar == null) {
            mo27773b(null);
            return;
        }
        C2213bb bbVar = baVar.f4516c;
        if (bbVar == null) {
            String str = C2620l.f5846a;
            mo27773b(null);
            return;
        }
        byte[] a = bbVar.f4518a.mo28408a(this.f5946b);
        if (a == null || a.length == 0) {
            btVar = null;
        } else {
            C2487fs fsVar = new C2487fs();
            fsVar.mo28419b(a);
            btVar = new C2240bt(bbVar.f4518a, fsVar);
        }
        if (btVar == null) {
            String str2 = C2620l.f5846a;
            mo27773b(null);
            return;
        }
        try {
            mo27773b(baVar.f4514a.mo28780o().mo27886a(btVar));
        } catch (C2208ax unused) {
            String str3 = C2620l.f5846a;
            mo27773b(null);
        }
    }
}
