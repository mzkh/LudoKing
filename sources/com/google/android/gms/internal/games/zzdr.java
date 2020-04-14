package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;

final class zzdr implements LoadMatchResult {
    private final /* synthetic */ Status zzbd;

    zzdr(zzdq zzdq, Status status) {
        this.zzbd = status;
    }

    public final TurnBasedMatch getMatch() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
