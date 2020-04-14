package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcwn implements Runnable {
    private final InputStream zzgks;
    private final ParcelFileDescriptor zzgkt;

    zzcwn(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgks = inputStream;
        this.zzgkt = parcelFileDescriptor;
    }

    public final void run() {
        zzcwo.zza(this.zzgks, this.zzgkt);
    }
}
