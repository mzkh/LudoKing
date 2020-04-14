package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmz extends zzbpm<zzbnb> implements zzbnb {
    public zzbmz(Set<zzbqs<zzbnb>> set) {
        super(set);
    }

    public final void onAdFailedToLoad(int i) {
        zza((zzbpo<ListenerT>) new zzbnc<ListenerT>(i));
    }
}
