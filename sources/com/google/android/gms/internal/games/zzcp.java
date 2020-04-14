package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;

abstract class zzcp extends zza<DeleteSnapshotResult> {
    private zzcp(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcq(this, status);
    }

    /* synthetic */ zzcp(GoogleApiClient googleApiClient, zzci zzci) {
        this(googleApiClient);
    }
}
