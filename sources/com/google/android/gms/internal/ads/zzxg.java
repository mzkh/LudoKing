package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.AdapterStatus.State;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzxg implements AdapterStatus {
    zzxg(zzxc zzxc) {
    }

    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }

    public final int getLatency() {
        return 0;
    }

    public final State getInitializationState() {
        return State.READY;
    }
}
