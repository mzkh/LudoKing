package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;

final class zzdn implements InitiateMatchResult {
    private final /* synthetic */ Status zzbd;

    zzdn(zzdm zzdm, Status status) {
        this.zzbd = status;
    }

    public final TurnBasedMatch getMatch() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
