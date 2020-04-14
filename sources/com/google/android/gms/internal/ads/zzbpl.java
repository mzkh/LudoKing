package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbpl implements Runnable {
    private final Object zzdbp;
    private final zzbpo zzfhi;

    zzbpl(zzbpo zzbpo, Object obj) {
        this.zzfhi = zzbpo;
        this.zzdbp = obj;
    }

    public final void run() {
        try {
            this.zzfhi.zzp(this.zzdbp);
        } catch (Throwable th) {
            zzq.zzkn().zzb(th, "EventEmitter.notify");
            zzaug.zza("Event emitter exception.", th);
        }
    }
}
