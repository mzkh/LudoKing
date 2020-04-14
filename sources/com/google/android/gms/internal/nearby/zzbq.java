package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbq extends RegisterListenerMethod<zzx, EndpointDiscoveryCallback> {
    private final /* synthetic */ String zzcn;
    private final /* synthetic */ ListenerHolder zzco;
    private final /* synthetic */ zzbd zzcq;
    private final /* synthetic */ DiscoveryOptions zzcr;

    zzbq(zzbd zzbd, ListenerHolder listenerHolder, String str, ListenerHolder listenerHolder2, DiscoveryOptions discoveryOptions) {
        this.zzcq = zzbd;
        this.zzcn = str;
        this.zzco = listenerHolder2;
        this.zzcr = discoveryOptions;
        super(listenerHolder);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void registerListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzx) anyClient).zza((ResultHolder<Status>) new zzby<Status>(this.zzcq, taskCompletionSource), this.zzcn, this.zzco, this.zzcr);
    }
}
