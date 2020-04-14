package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzaz extends zzav {
    private final /* synthetic */ zzj zzei;

    zzaz(zzaw zzaw, GoogleApiClient googleApiClient, zzj zzj) {
        this.zzei = zzj;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzei, (zzes) null, (String) null, (zzeq) new zzgs(this));
    }
}
