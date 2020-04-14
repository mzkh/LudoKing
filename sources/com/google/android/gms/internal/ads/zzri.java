package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzri {
    private final Object zzbre = new Object();
    @GuardedBy("poolLock")
    private boolean zzbrf = false;
}
