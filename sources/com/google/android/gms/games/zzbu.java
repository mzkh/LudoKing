package com.google.android.gms.games;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;

final class zzbu implements ResultConverter<LoadSnapshotsResult, SnapshotMetadataBuffer> {
    zzbu() {
    }

    public final /* synthetic */ Object convert(@Nullable Result result) {
        LoadSnapshotsResult loadSnapshotsResult = (LoadSnapshotsResult) result;
        if (loadSnapshotsResult == null) {
            return null;
        }
        return loadSnapshotsResult.getSnapshots();
    }
}
