package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqu implements zzcrr<Bundle> {
    private final Bundle zzfgs;

    public zzcqu(Bundle bundle) {
        this.zzfgs = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = this.zzfgs;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }
}
