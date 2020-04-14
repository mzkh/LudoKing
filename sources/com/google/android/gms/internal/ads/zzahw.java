package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzahw implements zzaxz<zzaha> {
    private final /* synthetic */ zzahn zzdac;
    private final /* synthetic */ zzaie zzdag;

    zzahw(zzahn zzahn, zzaie zzaie) {
        this.zzdac = zzahn;
        this.zzdag = zzaie;
    }

    public final /* synthetic */ void zzh(Object obj) {
        synchronized (this.zzdac.lock) {
            this.zzdac.status = 0;
            if (!(this.zzdac.zzczw == null || this.zzdag == this.zzdac.zzczw)) {
                zzaug.zzdy("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdac.zzczw.zzri();
            }
            this.zzdac.zzczw = this.zzdag;
        }
    }
}
