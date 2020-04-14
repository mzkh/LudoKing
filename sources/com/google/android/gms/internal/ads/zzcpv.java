package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpv implements zzcrr<Bundle> {
    private final Bundle zzdjt;

    public zzcpv(Bundle bundle) {
        this.zzdjt = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX;
        Bundle zza = zzcwk.zza(bundle, str);
        zza.putBundle("android_mem_info", this.zzdjt);
        bundle.putBundle(str, zza);
    }
}
