package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;

abstract class zzcf extends zza<UpdateRequestsResult> {
    private zzcf(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcg(this, status);
    }

    /* synthetic */ zzcf(GoogleApiClient googleApiClient, zzca zzca) {
        this(googleApiClient);
    }
}
