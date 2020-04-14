package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;

final class zzdl implements CancelMatchResult {
    private final /* synthetic */ Status zzbd;
    private final /* synthetic */ zzdk zzlf;

    zzdl(zzdk zzdk, Status status) {
        this.zzlf = zzdk;
        this.zzbd = status;
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final String getMatchId() {
        return this.zzlf.zzfr;
    }
}
