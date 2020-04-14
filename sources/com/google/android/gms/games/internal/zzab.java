package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

final class zzab extends zzat<LoadAchievementsResult> {
    zzab(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(DataHolder dataHolder) {
        setResult(new zzw(dataHolder));
    }
}
