package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaix {
    @VisibleForTesting
    private static final zzavr<zzaha> zzdbb = new zzaiw();
    @VisibleForTesting
    private static final zzavr<zzaha> zzdbc = new zzaiz();
    private final zzahn zzdbd;

    public zzaix(Context context, zzaxl zzaxl, String str) {
        zzahn zzahn = new zzahn(context, zzaxl, str, zzdbb, zzdbc);
        this.zzdbd = zzahn;
    }

    public final <I, O> zzaip<I, O> zza(String str, zzaiq<I> zzaiq, zzair<O> zzair) {
        return new zzaiy(this.zzdbd, str, zzaiq, zzair);
    }

    public final zzajc zzrl() {
        return new zzajc(this.zzdbd);
    }
}
