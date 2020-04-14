package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;

final class zzi extends zzat<LoadMatchResult> {
    zzi(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzn(DataHolder dataHolder) {
        setResult(new zzaa(dataHolder));
    }
}
