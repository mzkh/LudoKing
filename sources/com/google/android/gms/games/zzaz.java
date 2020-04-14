package com.google.android.gms.games;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Players.LoadPlayersResult;

final class zzaz implements ResultConverter<LoadPlayersResult, Player> {
    zzaz() {
    }

    private static Player zza(@Nullable LoadPlayersResult loadPlayersResult) {
        if (loadPlayersResult == null) {
            return null;
        }
        PlayerBuffer players = loadPlayersResult.getPlayers();
        if (players != null) {
            try {
                if (players.getCount() > 0) {
                    return (Player) ((Player) players.get(0)).freeze();
                }
            } finally {
                if (players != null) {
                    players.release();
                }
            }
        }
        if (players != null) {
            players.release();
        }
        return null;
    }

    public final /* synthetic */ Object convert(@Nullable Result result) {
        return zza((LoadPlayersResult) result);
    }
}
