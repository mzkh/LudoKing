package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.tapjoy.TJAdUnitConstants;

/* renamed from: com.inmobi.media.bt */
/* compiled from: AdNetworkResponse */
public final class C2240bt {

    /* renamed from: a */
    public C2487fs f4660a;

    /* renamed from: b */
    public InMobiAdRequestStatus f4661b;

    /* renamed from: c */
    public C2239bs f4662c;

    public C2240bt(C2239bs bsVar, C2487fs fsVar) {
        this.f4662c = bsVar;
        this.f4660a = fsVar;
        if (this.f4660a.f5452a != null) {
            int i = this.f4660a.f5452a.f5427a;
            if (i == -8) {
                this.f4661b = new InMobiAdRequestStatus(StatusCode.GDPR_COMPLIANCE_ENFORCED);
            } else if (i == -7) {
                this.f4661b = new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID);
                if (this.f4660a.f5452a.f5428b != null) {
                    this.f4661b.setCustomMessage(this.f4660a.f5452a.f5428b);
                }
            } else if (i != 0) {
                switch (i) {
                    case TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL /*500*/:
                    case 501:
                    case 502:
                    case 503:
                    case 505:
                        this.f4661b = new InMobiAdRequestStatus(StatusCode.SERVER_ERROR);
                        return;
                    case 504:
                        this.f4661b = new InMobiAdRequestStatus(StatusCode.REQUEST_TIMED_OUT);
                        return;
                    default:
                        this.f4661b = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
                        break;
                }
            } else {
                this.f4661b = new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE);
            }
        }
    }
}
