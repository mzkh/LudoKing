package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

final class zzcu implements OpenSnapshotResult {
    private final /* synthetic */ Status zzbd;

    zzcu(zzct zzct, Status status) {
        this.zzbd = status;
    }

    public final String getConflictId() {
        return null;
    }

    public final Snapshot getConflictingSnapshot() {
        return null;
    }

    public final SnapshotContents getResolutionSnapshotContents() {
        return null;
    }

    public final Snapshot getSnapshot() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
