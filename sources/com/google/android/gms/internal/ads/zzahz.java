package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzahz implements zzaxx {
    private final /* synthetic */ zzahn zzdac;
    private final /* synthetic */ zzaie zzdag;

    zzahz(zzahn zzahn, zzaie zzaie) {
        this.zzdac = zzahn;
        this.zzdag = zzaie;
    }

    public final void run() {
        synchronized (this.zzdac.lock) {
            this.zzdac.status = 1;
            zzaug.zzdy("Failed loading new engine. Marking new engine destroyable.");
            this.zzdag.zzri();
        }
    }
}
