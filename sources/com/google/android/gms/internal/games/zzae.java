package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

abstract class zzae extends zza<LoadGamesResult> {
    private zzae(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzaf(this, status);
    }

    /* synthetic */ zzae(GoogleApiClient googleApiClient, zzad zzad) {
        this(googleApiClient);
    }
}
