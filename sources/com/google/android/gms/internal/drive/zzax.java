package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzax extends zzav {
    private final /* synthetic */ zzj zzei;
    private final /* synthetic */ zzee zzej;

    zzax(zzaw zzaw, GoogleApiClient googleApiClient, zzj zzj, zzee zzee) {
        this.zzei = zzj;
        this.zzej = zzee;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzei, (zzes) this.zzej, (String) null, (zzeq) new zzgs(this));
    }
}
