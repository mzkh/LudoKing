package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzsp.zzh;
import com.google.android.gms.internal.ads.zzsp.zzj.zzc;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcfs implements zzdcz<Bundle> {
    private final /* synthetic */ boolean zzfwo;
    final /* synthetic */ zzcft zzfwp;

    zzcfs(zzcft zzcft, boolean z) {
        this.zzfwp = zzcft;
        this.zzfwo = z;
    }

    public final void zzb(Throwable th) {
        zzaug.zzes("Failed to get signals bundle");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Bundle bundle = (Bundle) obj;
        ArrayList zza = zzcft.zzl(bundle);
        zzc zzb = zzcft.zzk(bundle);
        zzh zzc = this.zzfwp.zzj(bundle);
        zzcfj zza2 = this.zzfwp.zzfws;
        zzcfv zzcfv = new zzcfv(this, this.zzfwo, zza, zzc, zzb);
        zza2.zza(zzcfv);
    }
}
