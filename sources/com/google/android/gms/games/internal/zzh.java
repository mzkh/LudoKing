package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;

final class zzh extends zzat<CancelMatchResult> {
    zzh(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzc(int i, String str) {
        setResult(new zzc(GamesStatusCodes.zza(i), str));
    }
}
