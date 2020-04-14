package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;

final class zzaa extends zzat<SubmitScoreResult> {
    zzaa(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzd(DataHolder dataHolder) {
        setResult(new zzba(dataHolder));
    }
}
