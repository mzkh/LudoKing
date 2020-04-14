package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsb implements zzcrr<Bundle> {
    private final String zzdmh;
    private final int zzdms;
    private final int zzdmt;
    private final int zzdmu;
    private final boolean zzdmz;
    private final int zzdna;

    public zzcsb(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdmh = str;
        this.zzdms = i;
        this.zzdmt = i2;
        this.zzdmu = i3;
        this.zzdmz = z;
        this.zzdna = i4;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zzdmh;
        boolean z = true;
        zzcwk.zza(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.zzdms);
        if (this.zzdms == -2) {
            z = false;
        }
        zzcwk.zza(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.zzdmt);
        bundle.putInt("pt", this.zzdmu);
        String str2 = TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX;
        Bundle zza = zzcwk.zza(bundle, str2);
        bundle.putBundle(str2, zza);
        String str3 = "network";
        Bundle zza2 = zzcwk.zza(zza, str3);
        zza.putBundle(str3, zza2);
        zza2.putInt("active_network_state", this.zzdna);
        zza2.putBoolean("active_network_metered", this.zzdmz);
    }
}
