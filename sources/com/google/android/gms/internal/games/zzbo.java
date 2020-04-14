package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;

final class zzbo extends zzbs {
    private final /* synthetic */ String zzkl;

    zzbo(zzbn zzbn, GoogleApiClient googleApiClient, String str) {
        this.zzkl = str;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzh(this, this.zzkl);
    }
}
