package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzec implements Runnable {
    private final /* synthetic */ zzdx zzyj;
    private final /* synthetic */ int zzym;
    private final /* synthetic */ boolean zzyn;

    zzec(zzdx zzdx, int i, boolean z) {
        this.zzyj = zzdx;
        this.zzym = i;
        this.zzyn = z;
    }

    public final void run() {
        zza zzb = this.zzyj.zzb(this.zzym, this.zzyn);
        this.zzyj.zzxy = zzb;
        if (zzdx.zza(this.zzym, zzb)) {
            this.zzyj.zza(this.zzym + 1, this.zzyn);
        }
    }
}
