package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzatt extends zzauc {
    private final /* synthetic */ zzatr zzdrb;

    zzatt(zzatr zzatr) {
        this.zzdrb = zzatr;
    }

    public final void zzsx() {
        zzzo zzzo = new zzzo(this.zzdrb.zzlk, this.zzdrb.zzblk.zzblz);
        synchronized (this.zzdrb.lock) {
            try {
                zzq.zzks();
                zzzt.zza(this.zzdrb.zzdqo, zzzo);
            } catch (IllegalArgumentException e) {
                zzaug.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
