package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

final class zzar extends zzax {
    private final /* synthetic */ int zzkg;
    private final /* synthetic */ LeaderboardScoreBuffer zzkh;
    private final /* synthetic */ int zzki;

    zzar(zzal zzal, GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        this.zzkh = leaderboardScoreBuffer;
        this.zzkg = i;
        this.zzki = i2;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadScoresResult>) this, this.zzkh, this.zzkg, this.zzki);
    }
}
