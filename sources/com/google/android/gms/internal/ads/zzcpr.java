package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpr implements zzcrr<Bundle> {
    private final String zzdju;
    private final boolean zzdjw;

    public zzcpr(String str, boolean z) {
        this.zzdju = str;
        this.zzdjw = z;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zzdju);
        if (this.zzdjw) {
            bundle.putString("de", "1");
        }
    }
}
