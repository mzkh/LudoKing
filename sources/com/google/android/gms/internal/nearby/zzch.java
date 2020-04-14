package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions.Builder;
import com.google.android.gms.nearby.connection.Strategy;

final class zzch extends zzcw {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ long zzcy;
    private final /* synthetic */ ListenerHolder zzcz;

    zzch(zzca zzca, GoogleApiClient googleApiClient, String str, long j, ListenerHolder listenerHolder) {
        this.val$name = str;
        this.zzcy = j;
        this.zzcz = listenerHolder;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzx zzx = (zzx) anyClient;
        String str = this.val$name;
        long j = this.zzcy;
        ListenerHolder listenerHolder = this.zzcz;
        ((zzdu) zzx.getService()).zza(new zzga().zza((zzec) new zzbc(this)).zzi(str).zzj("__LEGACY_SERVICE_ID__").zzd(j).zza((zzdd) new zzag(listenerHolder)).zzg(new Builder().setStrategy(Strategy.P2P_CLUSTER).build()).zzv());
    }
}
