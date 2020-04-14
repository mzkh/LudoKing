package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

final class zzao extends zzav {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ int zzke;
    private final /* synthetic */ int zzkf;

    zzao(zzal zzal, GoogleApiClient googleApiClient, String str, int i, int i2) {
        this.zzbr = str;
        this.zzke = i;
        this.zzkf = i2;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadPlayerScoreResult>) this, (String) null, this.zzbr, this.zzke, this.zzkf);
    }
}
