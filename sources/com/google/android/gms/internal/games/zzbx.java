package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

final class zzbx implements LoadQuestsResult {
    private final /* synthetic */ Status zzbd;

    zzbx(zzbw zzbw, Status status) {
        this.zzbd = status;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final QuestBuffer getQuests() {
        return new QuestBuffer(DataHolder.empty(this.zzbd.getStatusCode()));
    }
}
