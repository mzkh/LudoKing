package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

final /* synthetic */ class zzag implements zzap {
    private final TurnBasedMatch zzij;

    zzag(TurnBasedMatch turnBasedMatch) {
        this.zzij = turnBasedMatch;
    }

    public final void accept(Object obj) {
        ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchReceived(this.zzij);
    }
}
