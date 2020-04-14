package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdcg implements Runnable {
    private final /* synthetic */ int zzgqx;
    private final /* synthetic */ zzddi zzgqy;
    private final /* synthetic */ zza zzgqz;

    zzdcg(zza zza, int i, zzddi zzddi) {
        this.zzgqz = zza;
        this.zzgqx = i;
        this.zzgqy = zzddi;
    }

    public final void run() {
        try {
            this.zzgqz.zza(this.zzgqx, this.zzgqy);
        } finally {
            this.zzgqz.zzapa();
        }
    }
}
