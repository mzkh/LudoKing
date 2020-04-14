package com.google.android.gms.games.internal;

import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestUpdateListener;

final /* synthetic */ class zzai implements zzap {
    private final Quest zzin;

    zzai(Quest quest) {
        this.zzin = quest;
    }

    public final void accept(Object obj) {
        ((QuestUpdateListener) obj).onQuestCompleted(this.zzin);
    }
}
