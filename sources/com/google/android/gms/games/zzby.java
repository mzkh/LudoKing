package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.SnapshotsClient.SnapshotContentUnavailableApiException;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

final class zzby implements zzbl<OpenSnapshotResult> {
    zzby() {
    }

    public final /* synthetic */ ApiException zza(@NonNull Status status, @NonNull Object obj) {
        OpenSnapshotResult openSnapshotResult = (OpenSnapshotResult) obj;
        if (status.getStatusCode() != 26572 || openSnapshotResult.getSnapshot() == null || openSnapshotResult.getSnapshot().getMetadata() == null) {
            return ApiExceptionUtil.fromStatus(status);
        }
        return new SnapshotContentUnavailableApiException(status, (SnapshotMetadata) openSnapshotResult.getSnapshot().getMetadata().freeze());
    }
}
