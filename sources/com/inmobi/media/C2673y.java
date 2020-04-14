package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.media.C2620l.C2636a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.y */
/* compiled from: ParseAdResponseWorker */
final class C2673y extends C2141aa<Boolean> {
    @NonNull

    /* renamed from: a */
    final C2153ac f5964a;
    @NonNull

    /* renamed from: b */
    private final WeakReference<C2620l> f5965b;

    /* renamed from: c */
    private final boolean f5966c;
    @Nullable

    /* renamed from: d */
    private InMobiAdRequestStatus f5967d;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(Object obj) {
        Boolean bool = (Boolean) obj;
        C2620l lVar = (C2620l) this.f5965b.get();
        if (lVar != null) {
            if (this.f5966c) {
                boolean booleanValue = bool.booleanValue();
                InMobiAdRequestStatus inMobiAdRequestStatus = this.f5967d;
                if (booleanValue) {
                    lVar.f5854b = 2;
                }
                C2636a l = lVar.mo28777l();
                if (l != null) {
                    l.mo27779a(lVar, booleanValue, inMobiAdRequestStatus);
                }
                return;
            }
            lVar.mo28754a(bool.booleanValue());
        }
    }

    C2673y(@NonNull C2620l lVar, @NonNull C2153ac acVar, boolean z, @Nullable InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f5965b = new WeakReference<>(lVar);
        this.f5964a = acVar;
        this.f5966c = z;
        this.f5967d = inMobiAdRequestStatus;
    }

    public final void run() {
        C2620l lVar = (C2620l) this.f5965b.get();
        if (lVar == null) {
            mo27773b(Boolean.FALSE);
        } else {
            mo27773b(Boolean.valueOf(lVar.mo28756a(this.f5964a)));
        }
    }
}
