package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;

final class zzcq implements DeleteSnapshotResult {
    private final /* synthetic */ Status zzbd;

    zzcq(zzcp zzcp, Status status) {
        this.zzbd = status;
    }

    public final String getSnapshotId() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
