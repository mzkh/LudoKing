package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

final class zzcl extends zzcp {
    private final /* synthetic */ SnapshotMetadata zzkv;

    zzcl(zzch zzch, GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        this.zzkv = snapshotMetadata;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzi(this, this.zzkv.getSnapshotId());
    }
}
