package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;

final class zzcb extends zzcf {
    private final /* synthetic */ String[] zzko;

    zzcb(zzbz zzbz, GoogleApiClient googleApiClient, String[] strArr) {
        this.zzko = strArr;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb((ResultHolder<UpdateRequestsResult>) this, this.zzko);
    }
}
