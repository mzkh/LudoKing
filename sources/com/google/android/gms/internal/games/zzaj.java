package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;

abstract class zzaj extends zza<LoadInvitationsResult> {
    private zzaj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzak(this, status);
    }

    /* synthetic */ zzaj(GoogleApiClient googleApiClient, zzai zzai) {
        this(googleApiClient);
    }
}
