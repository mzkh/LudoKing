package com.google.android.gms.internal.games;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class zzch implements Snapshots {
    public final int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbz();
    }

    public final int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzcb();
    }

    public final Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.zza(googleApiClient).zzb(str, z, z2, i);
    }

    public final PendingResult<LoadSnapshotsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzci(this, googleApiClient, z));
    }

    public final PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    public final PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata, int i) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false, i);
    }

    public final PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z) {
        return open(googleApiClient, str, z, -1);
    }

    public final PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z, int i) {
        zzcj zzcj = new zzcj(this, googleApiClient, str, z, i);
        return googleApiClient.execute(zzcj);
    }

    public final PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.execute(new zzck(this, googleApiClient, snapshot, snapshotMetadataChange));
    }

    public final void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.zza(googleApiClient).zzb(snapshot);
    }

    public final PendingResult<DeleteSnapshotResult> delete(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return googleApiClient.execute(new zzcl(this, googleApiClient, snapshotMetadata));
    }

    public final PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), new Builder().fromMetadata(metadata).build(), snapshot.getSnapshotContents());
    }

    public final PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        zzcm zzcm = new zzcm(this, googleApiClient, str, str2, snapshotMetadataChange, snapshotContents);
        return googleApiClient.execute(zzcm);
    }

    public final SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        if (bundle != null) {
            String str = "com.google.android.gms.games.SNAPSHOT_METADATA";
            if (bundle.containsKey(str)) {
                return (SnapshotMetadata) bundle.getParcelable(str);
            }
        }
        return null;
    }
}
