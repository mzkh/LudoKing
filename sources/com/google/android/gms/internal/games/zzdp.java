package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;

final class zzdp implements LeaveMatchResult {
    private final /* synthetic */ Status zzbd;

    zzdp(zzdo zzdo, Status status) {
        this.zzbd = status;
    }

    public final TurnBasedMatch getMatch() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
