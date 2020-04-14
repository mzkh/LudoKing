package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzaul;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzl extends zzauc {
    final /* synthetic */ zzc zzdhw;

    private zzl(zzc zzc) {
        this.zzdhw = zzc;
    }

    public final void zzsx() {
        Bitmap zza = zzq.zzlc().zza(Integer.valueOf(this.zzdhw.zzdgv.zzdif.zzblb));
        if (zza != null) {
            zzaul.zzdsu.post(new zzk(this, zzq.zzkl().zza(this.zzdhw.zzzr, zza, this.zzdhw.zzdgv.zzdif.zzbkz, this.zzdhw.zzdgv.zzdif.zzbla)));
        }
    }
}
