package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbyn implements zzdcz<zzbbw> {
    private final /* synthetic */ String zzfpv;
    private final /* synthetic */ Map zzfpw;

    zzbyn(zzbyh zzbyh, String str, Map map) {
        this.zzfpv = str;
        this.zzfpw = map;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbbw) obj).zza(this.zzfpv, this.zzfpw);
    }
}
