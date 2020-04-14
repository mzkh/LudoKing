package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzccq implements zzdcz<String> {
    final /* synthetic */ zzccj zzfth;

    zzccq(zzccj zzccj) {
        this.zzfth = zzccj;
    }

    public final void zzb(Throwable th) {
        synchronized (this) {
            this.zzfth.zzfsu = true;
            this.zzfth.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzq.zzkq().elapsedRealtime() - this.zzfth.zzfsv));
            this.zzfth.zzfsw.setException(new Exception());
        }
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            this.zzfth.zzfsu = true;
            this.zzfth.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (zzq.zzkq().elapsedRealtime() - this.zzfth.zzfsv));
            this.zzfth.executor.execute(new zzcct(this, str));
        }
    }
}
