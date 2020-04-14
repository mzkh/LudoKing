package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzahv implements zzaer<zzail> {
    private final /* synthetic */ zzaha zzdab;
    private final /* synthetic */ zzahn zzdac;
    private final /* synthetic */ zzdf zzdae;
    private final /* synthetic */ zzawn zzdaf;

    zzahv(zzahn zzahn, zzdf zzdf, zzaha zzaha, zzawn zzawn) {
        this.zzdac = zzahn;
        this.zzdae = zzdf;
        this.zzdab = zzaha;
        this.zzdaf = zzawn;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        synchronized (this.zzdac.lock) {
            zzaug.zzet("JS Engine is requesting an update");
            if (this.zzdac.status == 0) {
                zzaug.zzet("Starting reload.");
                this.zzdac.status = 2;
                this.zzdac.zza(this.zzdae);
            }
            this.zzdab.zzb("/requestReload", (zzaer) this.zzdaf.get());
        }
    }
}
