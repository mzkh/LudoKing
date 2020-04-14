package com.google.android.gms.games;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Players.LoadPlayersResult;

final class zzax implements ResultConverter<LoadPlayersResult, PlayerBuffer> {
    zzax() {
    }

    public final /* synthetic */ Object convert(@Nullable Result result) {
        LoadPlayersResult loadPlayersResult = (LoadPlayersResult) result;
        if (loadPlayersResult == null) {
            return null;
        }
        return loadPlayersResult.getPlayers();
    }
}
