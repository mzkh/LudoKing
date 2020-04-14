package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzafk implements zzdcj<zzafj, ParcelFileDescriptor> {
    private final /* synthetic */ zzafd zzcyk;

    zzafk(zzafl zzafl, zzafd zzafd) {
        this.zzcyk = zzafd;
    }

    public final /* synthetic */ zzddi zzf(Object obj) throws Exception {
        zzafj zzafj = (zzafj) obj;
        zzaxv zzaxv = new zzaxv();
        zzafj.zza(this.zzcyk, new zzafn(this, zzaxv));
        return zzaxv;
    }
}
