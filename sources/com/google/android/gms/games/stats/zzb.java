package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;

public final class zzb extends DataBufferRef implements PlayerStats {
    private Bundle zzsp;

    zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    public final float getChurnProbability() {
        return getFloat("churn_probability");
    }

    public final int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    public final int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    public final int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    public final float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    public final float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    public final float getSpendProbability() {
        String str = "spend_probability";
        if (!hasColumn(str)) {
            return -1.0f;
        }
        return getFloat(str);
    }

    public final float getHighSpenderProbability() {
        String str = "high_spender_probability";
        if (!hasColumn(str)) {
            return -1.0f;
        }
        return getFloat(str);
    }

    public final float getTotalSpendNext28Days() {
        String str = "total_spend_next_28_days";
        if (!hasColumn(str)) {
            return -1.0f;
        }
        return getFloat(str);
    }

    public final Bundle zzdu() {
        Bundle bundle = this.zzsp;
        if (bundle != null) {
            return bundle;
        }
        this.zzsp = new Bundle();
        String string = getString("unknown_raw_keys");
        String string2 = getString("unknown_raw_values");
        if (!(string == null || string2 == null)) {
            String str = ",";
            String[] split = string.split(str);
            String[] split2 = string2.split(str);
            Asserts.checkState(split.length <= split2.length, "Invalid raw arguments!");
            for (int i = 0; i < split.length; i++) {
                this.zzsp.putString(split[i], split2[i]);
            }
        }
        return this.zzsp;
    }

    public final int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    public final String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerStatsEntity) ((PlayerStats) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new PlayerStatsEntity(this);
    }
}
