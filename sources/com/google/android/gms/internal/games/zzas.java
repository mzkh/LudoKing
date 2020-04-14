package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;

final class zzas extends zzaz {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ long zzbu;
    private final /* synthetic */ String zzbv;

    zzas(zzal zzal, GoogleApiClient googleApiClient, String str, long j, String str2) {
        this.zzbr = str;
        this.zzbu = j;
        this.zzbv = str2;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<SubmitScoreResult>) this, this.zzbr, this.zzbu, this.zzbv);
    }
}
