package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;

final class zzbv implements ClaimMilestoneResult {
    private final /* synthetic */ Status zzbd;

    zzbv(zzbu zzbu, Status status) {
        this.zzbd = status;
    }

    public final Milestone getMilestone() {
        return null;
    }

    public final Quest getQuest() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
