package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;

abstract class zzcr extends zza<LoadSnapshotsResult> {
    private zzcr(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcs(this, status);
    }

    /* synthetic */ zzcr(GoogleApiClient googleApiClient, zzci zzci) {
        this(googleApiClient);
    }
}
