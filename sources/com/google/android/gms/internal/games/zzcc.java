package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;

final class zzcc extends zzcd {
    private final /* synthetic */ int zzkd;
    private final /* synthetic */ int zzkp;
    private final /* synthetic */ int zzkq;

    zzcc(zzbz zzbz, GoogleApiClient googleApiClient, int i, int i2, int i3) {
        this.zzkp = i;
        this.zzkq = i2;
        this.zzkd = i3;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadRequestsResult>) this, this.zzkp, this.zzkq, this.zzkd);
    }
}
