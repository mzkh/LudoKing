package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

final class zzco implements CommitSnapshotResult {
    private final /* synthetic */ Status zzbd;

    zzco(zzcn zzcn, Status status) {
        this.zzbd = status;
    }

    public final SnapshotMetadata getSnapshotMetadata() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
