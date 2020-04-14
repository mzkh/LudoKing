package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.internal.zze;

final class zzf extends zzo {
    private final /* synthetic */ boolean zzjz;

    zzf(zze zze, GoogleApiClient googleApiClient, boolean z) {
        this.zzjz = z;
        super(googleApiClient, null);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzc((ResultHolder<LoadAchievementsResult>) this, this.zzjz);
    }
}
