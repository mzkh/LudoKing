package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;

abstract class zzdk extends zza<CancelMatchResult> {
    /* access modifiers changed from: private */
    public final String zzfr;

    public zzdk(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzfr = str;
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdl(this, status);
    }
}
