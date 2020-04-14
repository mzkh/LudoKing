package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcrd implements Runnable {
    private final String zzcyz;
    private final zzaxv zzftc;
    private final List zzftw;
    private final zzcrc zzgfs;
    private final Bundle zzgfu;

    zzcrd(zzcrc zzcrc, String str, zzaxv zzaxv, Bundle bundle, List list) {
        this.zzgfs = zzcrc;
        this.zzcyz = str;
        this.zzftc = zzaxv;
        this.zzgfu = bundle;
        this.zzftw = list;
    }

    public final void run() {
        this.zzgfs.zza(this.zzcyz, this.zzftc, this.zzgfu, this.zzftw);
    }
}
