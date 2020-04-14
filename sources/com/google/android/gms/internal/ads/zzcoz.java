package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoz implements zzcrr<Bundle> {
    private final double zzdmx;
    private final boolean zzdmy;

    public zzcoz(double d, boolean z) {
        this.zzdmx = d;
        this.zzdmy = z;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX;
        Bundle zza = zzcwk.zza(bundle, str);
        bundle.putBundle(str, zza);
        String str2 = "battery";
        Bundle zza2 = zzcwk.zza(zza, str2);
        zza.putBundle(str2, zza2);
        zza2.putBoolean("is_charging", this.zzdmy);
        zza2.putDouble("battery_level", this.zzdmx);
    }
}
