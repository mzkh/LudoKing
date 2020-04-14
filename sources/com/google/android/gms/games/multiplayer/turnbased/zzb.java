package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class zzb extends TurnBasedMatchConfig {
    private final int zzpd;
    private final Bundle zzpz;
    private final String[] zzqb;
    private final int zzql;

    zzb(Builder builder) {
        this.zzpd = builder.zzpd;
        this.zzql = builder.zzql;
        this.zzpz = builder.zzpz;
        this.zzqb = (String[]) builder.zzpy.toArray(new String[builder.zzpy.size()]);
    }

    public final int getVariant() {
        return this.zzpd;
    }

    public final int zzdp() {
        return this.zzql;
    }

    public final String[] getInvitedPlayerIds() {
        return this.zzqb;
    }

    public final Bundle getAutoMatchCriteria() {
        return this.zzpz;
    }
}
