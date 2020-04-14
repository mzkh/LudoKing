package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.google.android.gms.internal.ads.zzdut.zzb.zzf.C3510zzb;
import java.io.ByteArrayOutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzasa implements Runnable {
    private final /* synthetic */ Bitmap val$bitmap;
    private final /* synthetic */ zzarv zzdov;

    zzasa(zzarv zzarv, Bitmap bitmap) {
        this.zzdov = zzarv;
        this.val$bitmap = bitmap;
    }

    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.val$bitmap.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.zzdov.lock) {
            this.zzdov.zzdoh.zzhvm = new zzdvi();
            this.zzdov.zzdoh.zzhvm.zzhwl = byteArrayOutputStream.toByteArray();
            this.zzdov.zzdoh.zzhvm.mimeType = "image/png";
            this.zzdov.zzdoh.zzhvm.zzhwk = C3510zzb.TYPE_CREATIVE;
        }
    }
}
