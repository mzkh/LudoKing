package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;

abstract class zzcd extends zza<LoadRequestsResult> {
    private zzcd(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzce(this, status);
    }

    /* synthetic */ zzcd(GoogleApiClient googleApiClient, zzca zzca) {
        this(googleApiClient);
    }
}
