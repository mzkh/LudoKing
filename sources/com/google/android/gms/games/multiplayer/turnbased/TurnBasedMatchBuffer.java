package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

public final class TurnBasedMatchBuffer extends EntityBuffer<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public final String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getEntry(int i, int i2) {
        return new zzd(this.mDataHolder, i, i2);
    }
}
