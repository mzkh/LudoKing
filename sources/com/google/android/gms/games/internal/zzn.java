package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;

final class zzn extends zzat<DeleteSnapshotResult> {
    zzn(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzd(int i, String str) {
        setResult(new zzi(i, str));
    }
}
