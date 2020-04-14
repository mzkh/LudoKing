package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzcy extends zzcv<Status> {
    private zzcy(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* synthetic */ zzcy(GoogleApiClient googleApiClient, zzcb zzcb) {
        this(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
