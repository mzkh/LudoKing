package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdf;
import com.google.android.gms.internal.ads.zzdg;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzm implements Callable<zzdf> {
    private final /* synthetic */ zzl zzblj;

    zzm(zzl zzl) {
        this.zzblj = zzl;
    }

    public final /* synthetic */ Object call() throws Exception {
        return new zzdf(zzdg.zza(this.zzblj.zzblk.zzblz, this.zzblj.zzlk, false));
    }
}
