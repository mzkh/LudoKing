package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.event.Events.LoadEventsResult;

abstract class zzy extends zza<LoadEventsResult> {
    private zzy(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzz(this, status);
    }

    /* synthetic */ zzy(GoogleApiClient googleApiClient, zzv zzv) {
        this(googleApiClient);
    }
}
