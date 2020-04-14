package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;

final class zzk extends zzat<AcceptQuestResult> {
    zzk(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzaj(DataHolder dataHolder) {
        setResult(new zza(dataHolder));
    }
}
