package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcje implements zzdcz<T> {
    private final /* synthetic */ String zzfze;
    private final /* synthetic */ long zzfzf;
    private final /* synthetic */ zzcjf zzfzg;

    zzcje(zzcjf zzcjf, String str, long j) {
        this.zzfzg = zzcjf;
        this.zzfze = str;
        this.zzfzf = j;
    }

    public final void onSuccess(T t) {
        this.zzfzg.zza(this.zzfze, 0, this.zzfzg.zzbmp.elapsedRealtime() - this.zzfzf);
    }

    public final void zzb(Throwable th) {
        long elapsedRealtime = this.zzfzg.zzbmp.elapsedRealtime();
        int i = 3;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (!(th instanceof zzciv)) {
            i = th instanceof CancellationException ? 4 : (!(th instanceof zzccu) || ((zzccu) th).getErrorCode() != 3) ? 6 : 1;
        }
        this.zzfzg.zza(this.zzfze, i, elapsedRealtime - this.zzfzf);
    }
}
