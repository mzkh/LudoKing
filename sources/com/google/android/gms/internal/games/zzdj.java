package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;

final class zzdj extends zzds {
    private final /* synthetic */ int zzld;
    private final /* synthetic */ int[] zzle;

    zzdj(zzcz zzcz, GoogleApiClient googleApiClient, int i, int[] iArr) {
        this.zzld = i;
        this.zzle = iArr;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadMatchesResult>) this, this.zzld, this.zzle);
    }
}
