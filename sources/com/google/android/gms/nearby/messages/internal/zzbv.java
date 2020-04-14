package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.Nearby;

abstract class zzbv extends ApiMethodImpl<Status, zzah> {
    private final ListenerHolder<ResultHolder<Status>> zzir;

    public zzbv(GoogleApiClient googleApiClient) {
        super(Nearby.MESSAGES_API, googleApiClient);
        this.zzir = googleApiClient.registerListener(this);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: 0000 */
    public final ListenerHolder<ResultHolder<Status>> zzah() {
        return this.zzir;
    }
}
