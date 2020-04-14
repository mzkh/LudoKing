package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

abstract class zzcn extends zza<CommitSnapshotResult> {
    private zzcn(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzco(this, status);
    }

    /* synthetic */ zzcn(GoogleApiClient googleApiClient, zzci zzci) {
        this(googleApiClient);
    }
}
