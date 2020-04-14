package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbwk implements zzdal<zzo, Bitmap> {
    private final /* synthetic */ double zzfnw;
    private final /* synthetic */ boolean zzfnx;
    private final /* synthetic */ zzbwl zzfny;

    zzbwk(zzbwl zzbwl, double d, boolean z) {
        this.zzfny = zzbwl;
        this.zzfnw = d;
        this.zzfnx = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.zzfny.zza(((zzo) obj).data, this.zzfnw, this.zzfnx);
    }
}
