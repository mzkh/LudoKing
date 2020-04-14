package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcop implements zzcrr<Bundle> {
    private final boolean zzgeo = false;
    private final boolean zzgep = false;
    private final boolean zzgeq;

    public zzcop(boolean z, boolean z2, boolean z3) {
        this.zzgeq = z3;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("c_pcbg", this.zzgeo);
        bundle.putBoolean("c_phbg", this.zzgep);
        bundle.putBoolean("ar_lr", this.zzgeq);
    }
}
