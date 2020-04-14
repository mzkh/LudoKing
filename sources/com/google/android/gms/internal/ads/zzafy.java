package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzafy implements InitializationStatus {
    private final Map<String, AdapterStatus> zzcyq;

    public zzafy(Map<String, AdapterStatus> map) {
        this.zzcyq = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zzcyq;
    }
}
