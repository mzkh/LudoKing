package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.q */
/* compiled from: GetSignalsWorker */
final class C2650q extends C2141aa<byte[]> {
    @NonNull

    /* renamed from: a */
    private final WeakReference<C2620l> f5924a;

    /* renamed from: b */
    private final long f5925b;
    @Nullable

    /* renamed from: c */
    private C2209ay f5926c;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(Object obj) {
        byte[] bArr = (byte[]) obj;
        C2620l lVar = (C2620l) this.f5924a.get();
        if (lVar != null) {
            if (this.f5926c != null) {
                lVar.f5854b = 3;
            }
            C2636a l = lVar.mo28777l();
            if (l != null) {
                if (this.f5926c != null) {
                    l.mo27784b(new InMobiAdRequestStatus(StatusCode.GDPR_COMPLIANCE_ENFORCED));
                } else if (bArr == null) {
                    lVar.f5854b = 3;
                    l.mo27784b(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                } else {
                    l.mo27781a(bArr);
                    lVar.f5854b = 11;
                }
            }
        }
    }

    C2650q(@NonNull C2620l lVar, long j) {
        this.f5924a = new WeakReference<>(lVar);
        this.f5925b = j;
    }

    public final void run() {
        C2620l lVar = (C2620l) this.f5924a.get();
        if (lVar == null || lVar.f5866n == null) {
            mo27773b(null);
        } else if (lVar.mo28777l() == null) {
            mo27773b(null);
        } else {
            try {
                mo27773b(lVar.f5866n.mo27938a());
            } catch (C2209ay e) {
                this.f5926c = e;
                mo27773b(null);
            }
        }
    }
}
