package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzccs extends zzafs {
    private final /* synthetic */ zzccj zzfth;
    private final /* synthetic */ Object zzfti;
    private final /* synthetic */ String zzftj;
    private final /* synthetic */ long zzftk;
    private final /* synthetic */ zzaxv zzftl;

    zzccs(zzccj zzccj, Object obj, String str, long j, zzaxv zzaxv) {
        this.zzfth = zzccj;
        this.zzfti = obj;
        this.zzftj = str;
        this.zzftk = j;
        this.zzftl = zzaxv;
    }

    public final void onInitializationSucceeded() {
        synchronized (this.zzfti) {
            this.zzfth.zza(this.zzftj, true, "", (int) (zzq.zzkq().elapsedRealtime() - this.zzftk));
            this.zzfth.zzfsz.zzfz(this.zzftj);
            this.zzftl.set(Boolean.valueOf(true));
        }
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.zzfti) {
            this.zzfth.zza(this.zzftj, false, str, (int) (zzq.zzkq().elapsedRealtime() - this.zzftk));
            this.zzfth.zzfsz.zzr(this.zzftj, "error");
            this.zzftl.set(Boolean.valueOf(false));
        }
    }
}
