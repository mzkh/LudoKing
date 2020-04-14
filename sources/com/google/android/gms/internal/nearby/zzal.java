package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

final class zzal extends zzau<EndpointDiscoveryCallback> {
    private final /* synthetic */ zzer zzbr;

    zzal(zzak zzak, zzer zzer) {
        this.zzbr = zzer;
        super();
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        String zze;
        DiscoveredEndpointInfo discoveredEndpointInfo;
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if ("__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(this.zzbr.zze())) {
            zze = this.zzbr.zze();
            discoveredEndpointInfo = new DiscoveredEndpointInfo(this.zzbr.getServiceId(), this.zzbr.zzk());
        } else {
            zze = this.zzbr.zze();
            discoveredEndpointInfo = new DiscoveredEndpointInfo(this.zzbr.getServiceId(), this.zzbr.getEndpointName());
        }
        endpointDiscoveryCallback.onEndpointFound(zze, discoveredEndpointInfo);
    }
}
