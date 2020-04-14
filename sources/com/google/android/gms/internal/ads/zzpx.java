package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpx implements Runnable {
    private final /* synthetic */ zzpy zzbpc;

    zzpx(zzpy zzpy) {
        this.zzbpc = zzpy;
    }

    public final void run() {
        synchronized (this.zzbpc.lock) {
            if (!this.zzbpc.foreground || !this.zzbpc.zzbpd) {
                zzaug.zzdv("App is still foreground");
            } else {
                this.zzbpc.foreground = false;
                zzaug.zzdv("App went background");
                for (zzqa zzo : this.zzbpc.zzbpe) {
                    try {
                        zzo.zzo(false);
                    } catch (Exception e) {
                        zzaxi.zzc("", e);
                    }
                }
            }
        }
    }
}
