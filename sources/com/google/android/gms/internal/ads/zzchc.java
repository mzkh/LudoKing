package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzchc implements zzdcj {
    private final zzchd zzfxu;
    private final Uri zzfxv;
    private final zzcvz zzfxw;
    private final zzcvr zzfxx;

    zzchc(zzchd zzchd, Uri uri, zzcvz zzcvz, zzcvr zzcvr) {
        this.zzfxu = zzchd;
        this.zzfxv = uri;
        this.zzfxw = zzcvz;
        this.zzfxx = zzcvr;
    }

    public final zzddi zzf(Object obj) {
        return this.zzfxu.zza(this.zzfxv, this.zzfxw, this.zzfxx, obj);
    }
}
