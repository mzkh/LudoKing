package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzafn extends zzafg {
    private final /* synthetic */ zzaxv zzbrr;

    zzafn(zzafk zzafk, zzaxv zzaxv) {
        this.zzbrr = zzaxv;
    }

    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbrr.set(parcelFileDescriptor);
    }
}
