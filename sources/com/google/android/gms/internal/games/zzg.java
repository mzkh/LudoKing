package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.zze;

final class zzg extends zzq {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ int zzka;

    zzg(zze zze, String str, GoogleApiClient googleApiClient, String str2, int i) {
        this.val$id = str2;
        this.zzka = i;
        super(str, googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb((ResultHolder<UpdateAchievementResult>) this, this.val$id, this.zzka);
    }
}
