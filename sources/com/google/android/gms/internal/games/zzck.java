package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

final class zzck extends zzcn {
    private final /* synthetic */ Snapshot zzeh;
    private final /* synthetic */ SnapshotMetadataChange zzku;

    zzck(zzch zzch, GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        this.zzeh = snapshot;
        this.zzku = snapshotMetadataChange;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<CommitSnapshotResult>) this, this.zzeh, this.zzku);
    }
}
