package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcpl implements zzcrr<Bundle> {
    private final String zzdkk;
    private final Bundle zzgfe;

    private zzcpl(String str, Bundle bundle) {
        this.zzdkk = str;
        this.zzgfe = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zzdkk);
        bundle.putBundle("iab_consent_info", this.zzgfe);
    }
}
