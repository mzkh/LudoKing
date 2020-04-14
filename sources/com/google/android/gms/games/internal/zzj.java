package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

final class zzj extends zzat<LoadPlayerStatsResult> {
    zzj(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzao(DataHolder dataHolder) {
        setResult(new zzad(dataHolder));
    }
}
