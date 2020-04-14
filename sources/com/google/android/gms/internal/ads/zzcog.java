package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcog implements zzcrr<Bundle> {
    private final zzuf zzgej;

    public zzcog(zzuf zzuf) {
        this.zzgej = zzuf;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzuf zzuf = this.zzgej;
        if (zzuf != null) {
            String str = "avo";
            if (zzuf.orientation == 1) {
                bundle.putString(str, "p");
            } else if (this.zzgej.orientation == 2) {
                bundle.putString(str, "l");
            }
        }
    }
}
