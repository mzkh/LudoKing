package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;

final class zzdh extends zzdo {
    private final /* synthetic */ String zzey;
    private final /* synthetic */ String zzlb;

    zzdh(zzcz zzcz, GoogleApiClient googleApiClient, String str, String str2) {
        this.zzey = str;
        this.zzlb = str2;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LeaveMatchResult>) this, this.zzey, this.zzlb);
    }
}
