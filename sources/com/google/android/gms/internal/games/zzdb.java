package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;

final class zzdb extends zzdq {
    private final /* synthetic */ String zzey;

    zzdb(zzcz zzcz, GoogleApiClient googleApiClient, String str) {
        this.zzey = str;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzg(this, this.zzey);
    }
}
