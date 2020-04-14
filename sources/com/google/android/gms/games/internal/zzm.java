package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

final class zzm extends zzat<CommitSnapshotResult> {
    zzm(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzah(DataHolder dataHolder) {
        setResult(new zzh(dataHolder));
    }
}
