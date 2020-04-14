package com.google.android.gms.games;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

final class zzv implements ResultConverter<LoadGamesResult, Game> {
    zzv() {
    }

    private static Game zza(@Nullable LoadGamesResult loadGamesResult) {
        if (loadGamesResult == null) {
            return null;
        }
        GameBuffer games = loadGamesResult.getGames();
        if (games == null) {
            return null;
        }
        try {
            if (games.getCount() > 0) {
                return (Game) ((Game) games.get(0)).freeze();
            }
            games.release();
            return null;
        } finally {
            games.release();
        }
    }

    public final /* synthetic */ Object convert(@Nullable Result result) {
        return zza((LoadGamesResult) result);
    }
}
