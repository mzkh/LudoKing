package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;

abstract class zzaa extends zza<Result> {
    private zzaa(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public Result createFailedResult(Status status) {
        return new zzab(this, status);
    }

    /* synthetic */ zzaa(GoogleApiClient googleApiClient, zzv zzv) {
        this(googleApiClient);
    }
}
