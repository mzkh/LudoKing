package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;

final class zzdi extends zzdk {
    private final /* synthetic */ String zzey;

    zzdi(zzcz zzcz, String str, GoogleApiClient googleApiClient, String str2) {
        this.zzey = str2;
        super(str, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzf((ResultHolder<CancelMatchResult>) this, this.zzey);
    }
}
