package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.m */
/* compiled from: AuctionCloseWorker */
final class C2639m extends C2141aa<InMobiAdRequestStatus> {
    @NonNull

    /* renamed from: a */
    private final WeakReference<C2620l> f5905a;
    @NonNull

    /* renamed from: b */
    private final JSONObject f5906b;

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public final /* synthetic */ void mo27772a(Object obj) {
        InMobiAdRequestStatus inMobiAdRequestStatus = (InMobiAdRequestStatus) obj;
        C2620l lVar = (C2620l) this.f5905a.get();
        if (lVar != null) {
            C2636a l = lVar.mo28777l();
            if (l != null) {
                if (inMobiAdRequestStatus == null) {
                    lVar.f5854b = 2;
                    l.mo28805a();
                    return;
                }
                l.mo28806a(inMobiAdRequestStatus);
            }
        }
    }

    C2639m(@NonNull C2620l lVar, @NonNull JSONObject jSONObject) {
        this.f5905a = new WeakReference<>(lVar);
        this.f5906b = jSONObject;
    }

    public final void run() {
        C2620l lVar = (C2620l) this.f5905a.get();
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
        if (lVar == null || lVar.f5868p == null) {
            mo27773b(inMobiAdRequestStatus);
            return;
        }
        try {
            lVar.f5868p.mo27874a(this.f5906b, lVar.f5855c);
            mo27773b(null);
        } catch (Exception unused) {
            String str = C2620l.f5846a;
            mo27773b(inMobiAdRequestStatus);
        }
    }
}
