package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzazl implements Runnable {
    private boolean zzbpd = false;
    private zzayw zzdyw;

    zzazl(zzayw zzayw) {
        this.zzdyw = zzayw;
    }

    public final void run() {
        if (!this.zzbpd) {
            this.zzdyw.zzxd();
            zzxv();
        }
    }

    public final void pause() {
        this.zzbpd = true;
        this.zzdyw.zzxd();
    }

    public final void resume() {
        this.zzbpd = false;
        zzxv();
    }

    private final void zzxv() {
        zzaul.zzdsu.removeCallbacks(this);
        zzaul.zzdsu.postDelayed(this, 250);
    }
}
