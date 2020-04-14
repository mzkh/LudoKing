package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;

final class zzce implements LoadRequestsResult {
    private final /* synthetic */ Status zzbd;

    zzce(zzcd zzcd, Status status) {
        this.zzbd = status;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final GameRequestBuffer getRequests(int i) {
        return new GameRequestBuffer(DataHolder.empty(this.zzbd.getStatusCode()));
    }
}
