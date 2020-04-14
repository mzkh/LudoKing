package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.AdapterStatus.State;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzafz implements AdapterStatus {
    private final String description;
    private final int zzcyp;
    private final State zzcyr;

    public zzafz(State state, String str, int i) {
        this.zzcyr = state;
        this.description = str;
        this.zzcyp = i;
    }

    public final State getInitializationState() {
        return this.zzcyr;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getLatency() {
        return this.zzcyp;
    }
}
