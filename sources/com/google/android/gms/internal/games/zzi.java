package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.zze;

final class zzi extends zzq {
    private final /* synthetic */ String val$id;

    zzi(zze zze, String str, GoogleApiClient googleApiClient, String str2) {
        this.val$id = str2;
        super(str, googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<UpdateAchievementResult>) this, this.val$id);
    }
}
