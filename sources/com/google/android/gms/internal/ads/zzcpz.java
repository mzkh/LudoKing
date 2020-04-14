package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpz implements zzcrr<Bundle> {
    private final zzcvp zzfbb;

    public zzcpz(zzcvp zzcvp) {
        this.zzfbb = zzcvp;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcvp zzcvp = this.zzfbb;
        if (zzcvp != null) {
            bundle.putBoolean("render_in_browser", zzcvp.zzamx());
            bundle.putBoolean("disable_ml", this.zzfbb.zzamy());
        }
    }
}
