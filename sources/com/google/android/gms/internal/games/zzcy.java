package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

final class zzcy implements LoadPlayerStatsResult {
    private final /* synthetic */ Status zzbd;

    zzcy(zzcx zzcx, Status status) {
        this.zzbd = status;
    }

    public final PlayerStats getPlayerStats() {
        return null;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
