package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzbk extends zzbv {
    private final /* synthetic */ ListenerHolder zzik;

    zzbk(zzbi zzbi, GoogleApiClient googleApiClient, ListenerHolder listenerHolder) {
        this.zzik = listenerHolder;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzah) anyClient).zzc(zzah(), this.zzik);
    }
}
