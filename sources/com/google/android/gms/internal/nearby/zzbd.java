package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class zzbd extends ConnectionsClient {
    private static final AbstractClientBuilder<zzx, NoOptions> CLIENT_BUILDER = new zzbm();
    private static final ClientKey<zzx> CLIENT_KEY = new ClientKey<>();
    private static final Api<NoOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", CLIENT_BUILDER, CLIENT_KEY);
    private final zzk zzcd = zzk.zza();

    public zzbd(Activity activity) {
        super(activity, CONNECTIONS_API, Settings.DEFAULT_SETTINGS);
    }

    public zzbd(Context context) {
        super(context, CONNECTIONS_API, Settings.DEFAULT_SETTINGS);
    }

    private final Task<Void> zza(zzbw zzbw) {
        return doWrite((TaskApiCall<A, TResult>) new zzbv<A,TResult>(this, zzbw));
    }

    private final Task<Void> zza(zzbz zzbz) {
        return doWrite((TaskApiCall<A, TResult>) new zzbn<A,TResult>(this, zzbz));
    }

    /* access modifiers changed from: private */
    public final void zzb(String str) {
        ListenerHolder zza = this.zzcd.zza((GoogleApi) this, str, "connection");
        this.zzcd.zza((GoogleApi) this, (RegisterListenerMethod) new zzbt(this, zza), (UnregisterListenerMethod) new zzbu(this, zza.getListenerKey()));
    }

    /* access modifiers changed from: private */
    public final void zzc(String str) {
        zzk zzk = this.zzcd;
        zzk.zza((GoogleApi) this, zzk.zzb(this, str, "connection"));
    }

    public final Task<Void> acceptConnection(String str, PayloadCallback payloadCallback) {
        return zza((zzbw) new zzbf(str, registerListener(payloadCallback, PayloadCallback.class.getName())));
    }

    public final Task<Void> cancelPayload(long j) {
        return zza((zzbw) new zzbj(j));
    }

    public final void disconnectFromEndpoint(String str) {
        zza((zzbz) new zzbk(str));
        zzc(str);
    }

    public final Task<Void> rejectConnection(String str) {
        return zza((zzbw) new zzbg(str));
    }

    public final Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        ListenerHolder registerListener = registerListener(new zzbx(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zzb(str2);
        return zza((zzbw) new zzbe(str, str2, registerListener)).addOnFailureListener(new zzbs(this, str2));
    }

    public final Task<Void> sendPayload(String str, Payload payload) {
        return zza((zzbw) new zzbh(str, payload));
    }

    public final Task<Void> sendPayload(List<String> list, Payload payload) {
        return zza((zzbw) new zzbi(list, payload));
    }

    public final Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        ListenerHolder registerListener = registerListener(new zzbx(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        ListenerHolder zza = this.zzcd.zza((GoogleApi) this, new Object(), "advertising");
        zzk zzk = this.zzcd;
        zzbo zzbo = new zzbo(this, zza, str, str2, registerListener, advertisingOptions);
        return zzk.zza((GoogleApi) this, (RegisterListenerMethod) zzbo, (UnregisterListenerMethod) new zzbp(this, zza.getListenerKey()));
    }

    public final Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        ListenerHolder zza = this.zzcd.zza((GoogleApi) this, endpointDiscoveryCallback, "discovery");
        zzk zzk = this.zzcd;
        zzbq zzbq = new zzbq(this, zza, str, zza, discoveryOptions);
        return zzk.zza((GoogleApi) this, (RegisterListenerMethod) zzbq, (UnregisterListenerMethod) new zzbr(this, zza.getListenerKey()));
    }

    public final void stopAdvertising() {
        this.zzcd.zza((GoogleApi) this, "advertising");
    }

    public final void stopAllEndpoints() {
        stopAdvertising();
        stopDiscovery();
        zza(zzbl.zzcl);
        this.zzcd.zza((GoogleApi) this, "connection");
    }

    public final void stopDiscovery() {
        this.zzcd.zza((GoogleApi) this, "discovery");
    }
}
