package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

final class zzan extends zzat {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ boolean zzjz;

    zzan(zzal zzal, GoogleApiClient googleApiClient, String str, boolean z) {
        this.zzbr = str;
        this.zzjz = z;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb((ResultHolder<LeaderboardMetadataResult>) this, this.zzbr, this.zzjz);
    }
}
