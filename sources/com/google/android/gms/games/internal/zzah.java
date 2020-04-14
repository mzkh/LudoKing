package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;

final /* synthetic */ class zzah implements zzap {
    private final String zzhv;

    zzah(String str) {
        this.zzhv = str;
    }

    public final void accept(Object obj) {
        ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchRemoved(this.zzhv);
    }
}
