package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxo implements zzdwb<ThreadFactory> {
    private static final zzcxo zzglk = new zzcxo();

    public static zzcxo zzanp() {
        return zzglk;
    }

    public final /* synthetic */ Object get() {
        return (ThreadFactory) zzdwh.zza(new zzcxg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
