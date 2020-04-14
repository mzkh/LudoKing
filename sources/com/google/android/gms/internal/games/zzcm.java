package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

final class zzcm extends zzct {
    private final /* synthetic */ SnapshotMetadataChange zzku;
    private final /* synthetic */ String zzkw;
    private final /* synthetic */ String zzkx;
    private final /* synthetic */ SnapshotContents zzky;

    zzcm(zzch zzch, GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        this.zzkw = str;
        this.zzkx = str2;
        this.zzku = snapshotMetadataChange;
        this.zzky = snapshotContents;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<OpenSnapshotResult>) this, this.zzkw, this.zzkx, this.zzku, this.zzky);
    }
}
