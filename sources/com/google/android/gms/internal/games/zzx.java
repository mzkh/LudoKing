package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;

final class zzx extends zzaa {
    private final /* synthetic */ String zzk;
    private final /* synthetic */ int zzl;

    zzx(zzu zzu, GoogleApiClient googleApiClient, String str, int i) {
        this.zzk = str;
        this.zzl = i;
        super(googleApiClient, null);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza(this.zzk, this.zzl);
    }
}
