package com.inmobi.media;

import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiAdRequestStatus;

/* renamed from: com.inmobi.media.ax */
/* compiled from: AdFetchFailureException */
public final class C2208ax extends RuntimeException {

    /* renamed from: a */
    public final InMobiAdRequestStatus f4511a;

    public C2208ax(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f4511a = inMobiAdRequestStatus;
    }

    public final String getMessage() {
        return this.f4511a.getMessage();
    }
}
