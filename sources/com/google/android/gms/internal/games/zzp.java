package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

final class zzp implements LoadAchievementsResult {
    private final /* synthetic */ Status zzbd;

    zzp(zzo zzo, Status status) {
        this.zzbd = status;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final AchievementBuffer getAchievements() {
        return new AchievementBuffer(DataHolder.empty(14));
    }
}
