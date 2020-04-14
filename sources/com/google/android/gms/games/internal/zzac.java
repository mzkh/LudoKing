package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

final class zzac extends zzat<LoadGamesResult> {
    zzac(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzg(DataHolder dataHolder) {
        setResult(new zzy(dataHolder));
    }
}
