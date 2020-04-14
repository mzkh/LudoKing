package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

final class zzz extends zzat<LoadPlayerScoreResult> {
    zzz(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzac(DataHolder dataHolder) {
        setResult(new zzac(dataHolder));
    }
}
