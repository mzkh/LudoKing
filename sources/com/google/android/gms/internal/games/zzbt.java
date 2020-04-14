package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;

final class zzbt implements AcceptQuestResult {
    private final /* synthetic */ Status zzbd;

    zzbt(zzbs zzbs, Status status) {
        this.zzbd = status;
    }

    public final Quest getQuest() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
