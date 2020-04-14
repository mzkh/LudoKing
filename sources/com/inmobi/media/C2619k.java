package com.inmobi.media;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.media.k */
/* compiled from: AdFetcherTask */
final class C2619k extends C2141aa<C2162aj> {
    @NonNull

    /* renamed from: a */
    private final WeakReference<C2620l> f5843a;
    @NonNull

    /* renamed from: b */
    private final C2239bs f5844b;
    @Nullable

    /* renamed from: c */
    private C2208ax f5845c;

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(Object obj) {
        C2162aj ajVar = (C2162aj) obj;
        C2620l lVar = (C2620l) this.f5843a.get();
        if (lVar != null) {
            if (this.f5845c != null) {
                lVar.mo28744a(lVar.mo28769e(), this.f5845c.f4511a);
            } else if (ajVar == null) {
                lVar.mo28744a(lVar.mo28769e(), new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            } else if (ajVar.mo27875b()) {
                lVar.mo28745a(ajVar);
            } else {
                if (!lVar.f5865m && lVar.mo28767d() != null) {
                    lVar.mo28763c(0);
                    if (lVar.mo28770f() == 1) {
                        lVar.f5868p = ajVar;
                        C2636a l = lVar.mo28777l();
                        if (l != null) {
                            l.mo28807a(lVar.f5867o, ajVar);
                        }
                    }
                }
            }
        }
    }

    C2619k(@NonNull C2620l lVar, @NonNull C2239bs bsVar) {
        this.f5843a = new WeakReference<>(lVar);
        this.f5844b = bsVar;
    }

    public final void run() {
        C2620l lVar = (C2620l) this.f5843a.get();
        if (lVar == null) {
            this.f5845c = new C2208ax(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            mo27773b(null);
            return;
        }
        if (!((C2454fa) C2438es.m5087a("root", C2505gd.m5306f(), null)).f5304f) {
            lVar.f5857e = System.currentTimeMillis();
            boolean z = false;
            try {
                lVar.mo28758b(0);
                C2163ak o = lVar.mo28780o();
                C2239bs bsVar = this.f5844b;
                Integer u = lVar.mo28786u();
                o.f4401b = bsVar;
                if (u != null) {
                    if (SystemClock.elapsedRealtime() - o.f4402c < ((long) (u.intValue() * 1000))) {
                        z = true;
                    }
                    if (z) {
                        throw new C2208ax(new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST));
                    }
                }
                C2239bs bsVar2 = o.f4401b;
                C2163ak.m4345a(bsVar2);
                o.f4402c = SystemClock.elapsedRealtime();
                C2240bt a = new C2238br(bsVar2).mo27983a();
                if (a == null) {
                    throw new C2208ax(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                } else if (a.f4660a.f5452a == null) {
                    mo27773b(o.mo27886a(a));
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("errorCode", String.valueOf(a.f4660a.f5452a.f5427a));
                    o.mo27887a((Map<String, Object>) hashMap);
                    throw new C2208ax(a.f4661b);
                }
            } catch (C2208ax e) {
                String str = C2620l.f5846a;
                this.f5845c = e;
                mo27773b(null);
            }
        } else {
            C2514gh.m5342a(1, C2620l.f5846a, "SDK will not perform this load operation as monetization has been disabled. Please contact InMobi for further info.");
            this.f5845c = new C2208ax(new InMobiAdRequestStatus(StatusCode.MONETIZATION_DISABLED));
            mo27773b(null);
        }
    }
}
