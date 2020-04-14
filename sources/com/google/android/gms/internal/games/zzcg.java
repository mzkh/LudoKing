package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.Set;

final class zzcg implements UpdateRequestsResult {
    private final /* synthetic */ Status zzbd;

    zzcg(zzcf zzcf, Status status) {
        this.zzbd = status;
    }

    public final Set<String> getRequestIds() {
        return null;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final int getRequestOutcome(String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Unknown request ID ";
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
