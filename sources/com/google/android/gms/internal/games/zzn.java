package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;

final class zzn extends zzq {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ int zzka;

    zzn(zze zze, String str, GoogleApiClient googleApiClient, String str2, int i) {
        this.val$id = str2;
        this.zzka = i;
        super(str, googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb(null, this.val$id, this.zzka);
    }
}
