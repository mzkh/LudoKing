package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcef extends zzaox {
    private final /* synthetic */ zzcec zzfvc;

    protected zzcef(zzcec zzcec) {
        this.zzfvc = zzcec;
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzfvc.zzdbn.set(new AutoCloseInputStream(parcelFileDescriptor));
    }

    public final void zza(zzavq zzavq) {
        this.zzfvc.zzdbn.setException(new zzavp(zzavq.zzdtw, zzavq.errorCode));
    }
}
