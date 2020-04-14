package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

final class zzcw extends zzcx {
    private final /* synthetic */ boolean zzjz;

    zzcw(zzcv zzcv, GoogleApiClient googleApiClient, boolean z) {
        this.zzjz = z;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zze((ResultHolder<LoadPlayerStatsResult>) this, this.zzjz);
    }
}
