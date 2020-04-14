package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int zzpd;
        ArrayList<String> zzpy;
        Bundle zzpz;
        int zzql;

        private Builder() {
            this.zzpd = -1;
            this.zzpy = new ArrayList<>();
            this.zzpz = null;
            this.zzql = 2;
        }

        public final Builder addInvitedPlayer(String str) {
            Preconditions.checkNotNull(str);
            this.zzpy.add(str);
            return this;
        }

        public final Builder addInvitedPlayers(ArrayList<String> arrayList) {
            Preconditions.checkNotNull(arrayList);
            this.zzpy.addAll(arrayList);
            return this;
        }

        public final Builder setVariant(int i) {
            Preconditions.checkArgument(i == -1 || i > 0, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.zzpd = i;
            return this;
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzpz = bundle;
            return this;
        }

        public final TurnBasedMatchConfig build() {
            return new zzb(this);
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zzdp();

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }
}
