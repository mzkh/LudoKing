package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzasq implements zzatb {
    private final String zzczh;
    private final Bundle zzdpx;

    zzasq(String str, Bundle bundle) {
        this.zzczh = str;
        this.zzdpx = bundle;
    }

    public final void zzb(zzbeb zzbeb) {
        zzbeb.logEvent("am", this.zzczh, this.zzdpx);
    }
}
