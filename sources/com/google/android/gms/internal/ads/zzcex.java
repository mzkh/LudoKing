package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcex implements zzdcz<ParcelFileDescriptor> {
    private final /* synthetic */ zzaoy zzfvo;

    zzcex(zzcen zzcen, zzaoy zzaoy) {
        this.zzfvo = zzaoy;
    }

    public final void zzb(Throwable th) {
        try {
            this.zzfvo.zza(zzavq.zza(th, zzccu.zzd(th)));
        } catch (RemoteException e) {
            zzaug.zza("Service can't call client", e);
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzfvo.zzb((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzaug.zza("Service can't call client", e);
        }
    }
}
