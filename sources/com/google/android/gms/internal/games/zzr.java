package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

final class zzr implements UpdateAchievementResult {
    private final /* synthetic */ Status zzbd;
    private final /* synthetic */ zzq zzkb;

    zzr(zzq zzq, Status status) {
        this.zzkb = zzq;
        this.zzbd = status;
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final String getAchievementId() {
        return this.zzkb.zzfr;
    }
}
