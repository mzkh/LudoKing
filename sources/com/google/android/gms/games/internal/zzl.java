package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;

final class zzl extends zzat<ClaimMilestoneResult> {
    private final /* synthetic */ String zzha;

    zzl(ResultHolder resultHolder, String str) {
        this.zzha = str;
        super(resultHolder);
    }

    public final void zzai(DataHolder dataHolder) {
        setResult(new zzg(dataHolder, this.zzha));
    }
}
