package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzqe implements ValueCallback<String> {
    private final /* synthetic */ zzqb zzbqc;

    zzqe(zzqb zzqb) {
        this.zzbqc = zzqb;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.zzbqc.zzbpy.zza(this.zzbqc.zzbpv, this.zzbqc.zzbpw, (String) obj, this.zzbqc.zzbpx);
    }
}
