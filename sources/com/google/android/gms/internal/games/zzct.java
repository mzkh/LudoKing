package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

abstract class zzct extends zza<OpenSnapshotResult> {
    private zzct(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcu(this, status);
    }

    /* synthetic */ zzct(GoogleApiClient googleApiClient, zzci zzci) {
        this(googleApiClient);
    }
}
