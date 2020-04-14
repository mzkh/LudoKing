package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

final class zzcj extends zzct {
    private final /* synthetic */ String zzkr;
    private final /* synthetic */ boolean zzks;
    private final /* synthetic */ int zzkt;

    zzcj(zzch zzch, GoogleApiClient googleApiClient, String str, boolean z, int i) {
        this.zzkr = str;
        this.zzks = z;
        this.zzkt = i;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<OpenSnapshotResult>) this, this.zzkr, this.zzks, this.zzkt);
    }
}
