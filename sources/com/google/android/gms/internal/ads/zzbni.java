package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbni extends zzbpm<zzbnj> {
    private boolean zzfha = false;

    public zzbni(Set<zzbqs<zzbnj>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfha) {
            zza(zzbnh.zzfgz);
            this.zzfha = true;
        }
    }
}
