package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbws implements zzdal {
    private final String zzczh;
    private final int zzdtl;
    private final int zzdtm;
    private final double zzfot;

    zzbws(String str, double d, int i, int i2) {
        this.zzczh = str;
        this.zzfot = d;
        this.zzdtl = i;
        this.zzdtm = i2;
    }

    public final Object apply(Object obj) {
        String str = this.zzczh;
        zzaau zzaau = new zzaau(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzfot, this.zzdtl, this.zzdtm);
        return zzaau;
    }
}
